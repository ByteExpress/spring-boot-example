let socket;

const Chat = {}
const MsgPosition = {
    left: "left",
    right: "right"
}

function init() {
    $.get("/getOnlineCount", "", function (ret) {
        //打开WebSocket连接
        Chat.uid = parseInt(ret) + 1;
        openSocket(Chat.uid);

        //初始化聊天界面
        initChat();
    })
}
init();

//打开WebSocket
function openSocket(uid) {
    if (typeof (WebSocket) === "undefined") {
        console.log("您的浏览器不支持WebSocket");
    } else {
        console.log("您的浏览器支持WebSocket");
        //实现化WebSocket对象，指定要连接的服务器地址与端口,建立连接.
        let socketUrl = "ws://localhost:8080/socket/" + uid;
        console.log(socketUrl);
        if (socket != null) {
            socket.close();
            socket = null;
        }
        socket = new WebSocket(socketUrl);
        //打开事件
        socket.onopen = function () {
            console.log("WebSocket已打开");
        };
        //获得消息事件
        socket.onmessage = function (msg) {
            console.log(msg);
            if (!isJson(msg.data)) {
                return;
            }
            console.log(msg.data);
            let msgJson = JSON.parse(msg.data)
            console.log(msgJson.fromUid, msgJson.Msg, MsgPosition.left)
            appendMsg(msgJson.fromUid, msgJson.Msg, MsgPosition.left)
            //发现消息进入,开始处理前端触发逻辑
        };
        //关闭事件
        socket.onclose = function () {
            console.log("WebSocket已关闭");
        };
        //发生了错误事件
        socket.onerror = function () {
            console.log("WebSocket发生了错误");
        }
    }
}

//发送消息
function sendMsg(msgStr) {
    if (typeof (WebSocket) === "undefined") {
        console.log("您的浏览器不支持WebSocket");
    } else {
        console.log("您的浏览器支持WebSocket");
        socket.send('{"toUid":"all","Msg":"' + msgStr + '"}');
    }
}

function initChat() {
    let $btnSend = getById("btnSend");
    let $message = getById("chat_context_item");
    // 回车发送消息
    $message.addEventListener("keyup", function (event) {
        event.preventDefault()
        if (event.keyCode === 13) {
            $btnSend.click()
        }
    })
    // 点击“发送”按钮发送消息
    $btnSend.addEventListener("click", function () {
        let $message = getById("chat_context_item");
        let msgStr = $message.value;

        sendMsg(msgStr);

        appendMsg(Chat.uid, msgStr, MsgPosition.right)

        $message.value = "";
    });
}

function appendMsg(from, msgStr, type) {
    console.log(from, msgStr, type)
    let $messageContent = getById("chat_middle_item");
    let date = new Date();
    let hour = date.getHours();
    let mm = date.getMinutes();
    let time = hour + ':' + mm;
    let msgHtml = '<div class="chat_' + type + '_item_1 clearfix">' + from + '</div>' +
        '<div class="chat_' + type + '_item_2">' +
        '<div class="chat_' + type + '_time clearfix">' + time + '</div>' +
        '<div class="chat_' + type + '_content clearfix">' + msgStr + '</div>'
        + '</div>';
    let eleMsg = document.createElement("div");
    eleMsg.setAttribute("class", "chat_" + type);
    eleMsg.innerHTML = msgHtml;
    $messageContent.append(eleMsg);
    $messageContent.scrollTop = $messageContent.scrollHeight;
}

function getById(elementId) {
    return document.getElementById(elementId);
}

function getByClassName(className) {
    return document.getElementsByClassName(className)[0];
}

function isJson(str) {
    try {
        JSON.parse(str);
    } catch (e) {
        return false;
    }
    return true;
}