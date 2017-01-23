package com.special.IsoRunner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.special.IsoRunner.callbackFiles.ICallService;
import com.special.IsoRunner.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pawel on 06/01/17.
 */

public class LoginActivity extends FragmentActivity {

    private LoginActivity mContext;
    EditText userNameEditText;
    EditText passwordEditText;

    Button loginButton;
    Button registerButton;

    TextView loginStatusTextView;

    Boolean isCalling;

    static String loginSuccess = "Login succes";
    static String registerSuccess = "Register succes";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mContext = this;
        isCalling = false;
        setUpMenu();
    }

    private void setUpMenu() {
        userNameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.login_button);
        registerButton = (Button) findViewById(R.id.register_button);

        loginStatusTextView = (TextView) findViewById(R.id.login_status);
        loginStatusTextView.setText("");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.LoginClicked();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.RegisterClicked();
            }
        });

        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.WHITE);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(6);

        userNameEditText.setBackground(shape);
        passwordEditText.setBackground(shape);
    }

    private void LoginClicked() {
        if(isCalling) return;

        if(userNameEditText.getText().toString().equals("")) {
            loginStatusTextView.setText("You cannot login without a username.");
            loginStatusTextView.setTextColor(Color.RED);
        }
        else if(passwordEditText.getText().toString().equals("")) {
            loginStatusTextView.setText("You cannot login without a password.");
            loginStatusTextView.setTextColor(Color.RED);
        }
        else {
            loginStatusTextView.setText("Try to log in...");
            loginStatusTextView.setTextColor(Color.WHITE);
            this.callLogin();
        }
    }


    private void RegisterClicked() {
        if(isCalling) return;

        if(userNameEditText.getText().toString().equals("")) {
            loginStatusTextView.setText("You cannot login without a username.");
            loginStatusTextView.setTextColor(Color.RED);
        }
        else if(passwordEditText.getText().toString().equals("")) {
            loginStatusTextView.setText("You cannot login without a password.");
            loginStatusTextView.setTextColor(Color.RED);
        }
        else {
            loginStatusTextView.setText("Try to register...");
            loginStatusTextView.setTextColor(Color.WHITE);
            this.callRegister();
        }
    }


    private void callRegister() {
        isCalling = true;
        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<LoginResponse> call = gitHubService.Register(userNameEditText.getText().toString(),passwordEditText.getText().toString());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                isCalling = false;
                LoginResponse loginResponse = response.body();
                if(loginResponse.error==null) {
                    loginStatusTextView.setText(registerSuccess);
                    loginStatusTextView.setTextColor(Color.WHITE);
//                    startActivity(new Intent(mContext, MenuActivity.class));
                }
                else {
                    loginStatusTextView.setText(loginResponse.error);
                    loginStatusTextView.setTextColor(Color.RED);
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                isCalling = false;
                loginStatusTextView.setText("Connection problem");
                loginStatusTextView.setTextColor(Color.RED);
            }
        });
    }

    private void callLogin() {
        isCalling = true;
        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<LoginResponse> call = gitHubService.Login(userNameEditText.getText().toString(),passwordEditText.getText().toString());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                isCalling = false;
                LoginResponse loginResponse = response.body();
                if(loginResponse.error==null) {
                    loginStatusTextView.setText(loginSuccess);
                    loginStatusTextView.setTextColor(Color.WHITE);

                    SharedPreferences myPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor e = myPrefs.edit();
                    e.putString("token", loginResponse.token);
                    e.apply();

                    startActivity(new Intent(mContext, MenuActivity.class));
                }
                else {
                    loginStatusTextView.setText(loginResponse.error);
                    loginStatusTextView.setTextColor(Color.RED);
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                isCalling = false;
                loginStatusTextView.setText("Connection problem");
                loginStatusTextView.setTextColor(Color.RED);
            }
        });
    }

}
