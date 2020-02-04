package com.lasalle.btssenger;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.daniel_sc.rocketchat.modern_client.RocketChatClient;
import com.github.daniel_sc.rocketchat.modern_client.response.ChatMessage;


public class MessageActivity extends AppCompatActivity implements View.OnClickListener, MessageListener {

    private WS_Send socket;

    @Override
    public void newMessage(ChatMessage message) {
        System.out.println(message.msg);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.messages_activity);

       socket = WS_Send.getInstance(null);
       socket.receive(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.send_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try {
            String message = ((EditText) findViewById(R.id.message_text)).getText().toString();
            socket.send(message);
        }catch (Throwable e){
            e.printStackTrace();
        }

    }
}
