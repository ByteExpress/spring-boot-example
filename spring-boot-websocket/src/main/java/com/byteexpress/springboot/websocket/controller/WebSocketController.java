package com.byteexpress.springboot.websocket.controller;

import com.byteexpress.springboot.websocket.server.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * websocket测试页面controller
 * @Author: ByteExpress
 * @Date: 2024/1/21 14:45
 * @Version V1.0
 */
@Controller
public class WebSocketController {

    /**
     * websocket测试页面
     * @return
     */
    @GetMapping("/")
    public ModelAndView page() {
        return new ModelAndView("index");
    }

    @RequestMapping("/push/{toUid}")
    public ResponseEntity<String> pushToClient(String message, @PathVariable String toUid) throws Exception {
        WebSocketServer.sendInfo(message, toUid);
        return ResponseEntity.ok("Send Success!");
    }

    @RequestMapping("/getOnlineCount")
    public ResponseEntity<String> getOnlineCount() {
        int onlineCount = WebSocketServer.getOnlineCount();
        return ResponseEntity.ok(onlineCount+"");
    }
}