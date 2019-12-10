package com.lasalle.btssenger;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final EditText username = findViewById(R.id.login_activity_username);
        final EditText password = findViewById(R.id.login_activity_password);
        findViewById(R.id.login_activity_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(), password.getText().toString());
                 }
            });
    }

    private void login(String username, String password) {
        RestClient client = new RestClient();
        client.getAuthenticationService().login(new UserPassword(username, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Auth>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Auth auth) {
                        System.out.println(auth);

                    }

                    @Override
                    public void onError(Throwable e) {
                    e.printStackTrace();
                    }
                });
    }

}
