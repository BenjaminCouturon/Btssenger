package com.lasalle.btssenger;

import android.os.AsyncTask;

import com.github.daniel_sc.rocketchat.modern_client.RocketChatClient;

public class WS_Send  {
    private static WS_Send instance;
    private RocketChatClient client;
    private LoginListener loginListener;

    private WS_Send(LoginListener listener){
        this.loginListener = listener;
    }

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
    public static WS_Send getInstance(LoginListener listener){
        if (instance == null){
            instance = new WS_Send(listener);
        }
        return instance;
    }
    protected void onPostExecute(Void v) {
    }

    public void login(String login, String password){
        new InternalConnect().execute(login, password);
    }

    public void send(String message) {
        client.sendMessage(message, "GENERAL");
    }
    class InternalConnect extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                client = new RocketChatClient("ws://92.222.66.192:3000/websocket", strings[0], strings[1]);
            } catch (Exception e) {
                loginListener.loginError();
                e.printStackTrace();
                return false;
            }
            loginListener.loginSuccess();
            return true;
        }
    }
}
