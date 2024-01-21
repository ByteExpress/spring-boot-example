package com.byteexpress.springboot.websocket.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket服务类
 *
 * @Author: ByteExpress
 * @Date: 2024/1/21 14:45
 * @Version V1.0
 */
@Slf4j
@Component
@ServerEndpoint("/socket/{uid}")
public class WebSocketServer {

    /**
     * 记录当前在线连接数
     */
    private static int onlineCount = 0;

    /**
     * 使用线程安全的ConcurrentHashMap来存放每个客户端对应的WebSocket对象
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收客户端消息的uid
     */
    private String uid = "";

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param uid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        this.session = session;
        this.uid = uid;
        if (webSocketMap.containsKey(uid)) {
            webSocketMap.remove(uid);
            webSocketMap.put(uid, this);
        } else {
            webSocketMap.put(uid, this);
            addOnlineCount();
        }

        log.info("用户【{}】连接成功，当前在线人数为:{}", uid, getOnlineCount());
        try {
            sendMsg("连接成功");
        } catch (IOException e) {
            log.error("用户【{}】网络异常!", uid, e);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(uid)) {
            webSocketMap.remove(uid);
            subOnlineCount();
        }
        log.info("用户【{}】退出，当前在线人数为:", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户【{}】发送报文:", uid, message);
        //群发消息
        //消息保存到数据库或者redis
        if (StringUtils.isNotBlank(message)) {
            try {
                //解析发送的报文
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> map = objectMapper.readValue(message, new TypeReference<>() {
                });
                //追加发送人(防止串改)
                map.put("fromUid", this.uid);
                String toUid = map.get("toUid");
                //发送消息
                if (StringUtils.isNotBlank(toUid)) {
                    //发送给所有人
                    if ("all".equals(toUid)) {
                        for (Map.Entry<String, WebSocketServer> entry : webSocketMap.entrySet()) {
                            if (this.uid.equals(entry.getKey())) {
                                continue;
                            }
                            webSocketMap.get(entry.getKey()).sendMsg(objectMapper.writeValueAsString(map));
                        }
                        //传送给对应的toUserId用户的WebSocket
                    } else if (webSocketMap.containsKey(toUid)) {
                        webSocketMap.get(toUid).sendMsg(objectMapper.writeValueAsString(map));
                    }
                } else {
                    //若果不在这个服务器上，可以考虑发送到mysql或者redis
                    log.error("请求目标用户【{}】不在该服务器上", toUid);
                }
            } catch (Exception e) {
                log.error("用户【{}】发送消息异常！", uid, e);
            }
        }
    }

    /**
     * 处理错误
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户【{}】处理消息错误，原因:", uid, error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     *
     * @param msg
     * @throws IOException
     */
    private void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    /**
     * 发送自定义消息
     *
     * @param message
     * @param uid
     * @throws IOException
     */
    public static void sendInfo(String message, @PathParam("uid") String uid) throws IOException {
        log.info("发送消息到用户【{}】发送的报文:", uid, message);
        if (!StringUtils.isEmpty(uid) && webSocketMap.containsKey(uid)) {
            webSocketMap.get(uid).sendMsg(message);
        } else {
            log.error("用户【{}】不在线！", uid);
        }
    }

    /**
     * 获取在线人数
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 在线人数加一
     */
    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    /**
     * 在线人数减一
     */
    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}