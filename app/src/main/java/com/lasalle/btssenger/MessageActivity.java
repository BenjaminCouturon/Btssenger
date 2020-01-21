package com.lasalle.btssenger;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private WS_Send socket=new WS_Send();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.messages_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.send_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String message = ((EditText)findViewById(R.id.message_text)).getText().toString();
        socket.send(message);
    }
}
