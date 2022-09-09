package com.johnbryce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        Button btOk = findViewById(R.id.btn_ok);
        Button btnClear = findViewById(R.id.btn_clear);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_ok:
                        handleOkClicked();
                        break;
                    case R.id.btn_clear:
                        handleClearClicked();
                        break;
                }
            }
        };

        btOk.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);
    }

    private void handleClearClicked() {
        etUsername.setText("");
        etPassword.setText("");

        Toast.makeText(this, "Cleared!", Toast.LENGTH_LONG).show();
    }

    private void handleOkClicked() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Toast.makeText(this, String.format("%s->%s", username, password), Toast.LENGTH_LONG)
                .show();
    }
}