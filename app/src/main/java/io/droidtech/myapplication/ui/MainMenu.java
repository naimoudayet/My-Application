package io.droidtech.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import io.droidtech.myapplication.R;
import io.droidtech.myapplication.model.User;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        User user = (User) getIntent().getExtras().get("user");

        Toast.makeText(MainMenu.this, "Hello " + user.getEmail(), Toast.LENGTH_LONG).show();
    }
}
