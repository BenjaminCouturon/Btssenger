package com.lasalle.btssenger;

import android.os.AsyncTask;

import com.github.daniel_sc.rocketchat.modern_client.RocketChatClient;

public class WS_Send extends AsyncTask<String, Void, Boolean> {
    private RocketChatClient client;

    protected Boolean doInBackground(String... urls) {
        try {
            client = new RocketChatClient("ws://92.222.66.192:3000/websocket", "test", "azerty");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        }
        return true;
    }

    protected void onPostExecute(Void v) {

    }

    public void send(String message) {
        client.sendMessage(message, "GENERAL");
    }
}
