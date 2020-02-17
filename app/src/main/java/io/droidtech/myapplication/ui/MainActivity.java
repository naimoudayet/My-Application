package io.droidtech.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.droidtech.myapplication.R;
import io.droidtech.myapplication.repo.UserRepository;
import io.droidtech.myapplication.model.User;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;

    User user;
    UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.edittext_email);
        editTextPassword = findViewById(R.id.edittext_password);
        buttonLogin = findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = new User(editTextEmail.getText().toString(), editTextPassword.getText().toString());

                if (user.getEmail().isEmpty()) {
                    Toast.makeText(MainActivity.this, "plz enter your email !!", Toast.LENGTH_LONG).show();
                } else if (user.getPassword().isEmpty()) {
                    Toast.makeText(MainActivity.this, "plz enter your password !!", Toast.LENGTH_LONG).show();
                } else {
                    if (userRepository.login(user)) {

                        Intent intent = new Intent(MainActivity.this, MainMenu.class);
                        intent.putExtra("user", user);
                        startActivity(intent);

                    } else {
                        Toast.makeText(MainActivity.this, "plz verify your email or password !!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }
}
