package com.amoghbhagwat.farmmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    public static final String IS_LOGIN = "isLogin";
    public static final String USERNAME = "username";
    public static final String FILE_NAME = "userInformation";

    private Button btnLogin;
    private TextInputLayout txtUsername;
    private TextInputLayout txtPassword;
    private TextView txtIncorrectCredentials;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnLogin = findViewById(R.id.btn_login);
        this.txtUsername = findViewById(R.id.txt_username);
        this.txtPassword = findViewById(R.id.txt_password);
        this.txtIncorrectCredentials = findViewById(R.id.txt_incorrectCredentials);

        this.preferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        initialize();
    }

    private void initialize() {
        btnLogin.setOnClickListener(v -> {
            String username = txtUsername.getEditText().getText().toString();
            String password = txtPassword.getEditText().getText().toString();

            login(username, password);
        });
    }

    private void login(String username, String password) {
        Log.d(TAG, "login: called");
        if (checkCredentials(username, password)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(IS_LOGIN, true);
            editor.putString(USERNAME, username);

            editor.apply();

            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra(USERNAME, username);
            startActivity(intent);
        } else {
            txtIncorrectCredentials.setVisibility(View.VISIBLE);
            Log.d(TAG, "login: incorrect credentials!");
        }
    }

    private boolean checkCredentials(String username, String password) {
        // TODO: 03-Apr-20 implement login functionality
        return true;
    }
}
