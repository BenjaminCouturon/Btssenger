package com.lasalle.btssenger;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.UUID;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WS_Send extends WebSocketListener {
    private OkHttpClient clientws;
    private WebSocket webSocket;

    public WS_Send() {
        clientws = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("ws://92.222.66.192:300/websocket").build();
        webSocket = clientws.newWebSocket(request, this);
    }

    public void send(String message) {
    Message msg = new Message();
    msg.setMsg("method");
    msg.setMethod("sendMessage");
    msg.setId(UUID.randomUUID().toString());

    Param param = new Param();
    param.set_id(UUID.randomUUID().toString());
    param.setRid("XWTEqyghh4jJZtp5T");
    param.setMsg(message);
    msg.setParams(Collections.singletonList(param));
        webSocket.send(new Gson().toJson(msg));
    }
}

