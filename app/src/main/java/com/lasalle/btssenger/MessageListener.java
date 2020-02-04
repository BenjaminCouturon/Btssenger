package com.lasalle.btssenger;

import com.github.daniel_sc.rocketchat.modern_client.response.ChatMessage;

public interface MessageListener {
    public void newMessage(ChatMessage message);
}
