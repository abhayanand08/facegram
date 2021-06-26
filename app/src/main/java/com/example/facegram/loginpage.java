package com.example.facegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginpage extends AppCompatActivity {
 private Button loginbtn;
 private TextView register , help;
 private EditText name,psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        loginbtn = findViewById(R.id.button1);
        register = findViewById(R.id.button3);
        name = findViewById(R.id.user);
        psw = findViewById(R.id.password);
        help = findViewById(R.id.button2);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helper = new Intent(loginpage.this,helppage.class);
                startActivity(helper);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(loginpage.this,signuppage.class);
                startActivity(second);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {

            private boolean validatename(){
                String info = name.getText().toString().trim();
                if (info.isEmpty()){
                    name.setError("Field can't be empty");
                    return false;
                }
                else{
                    name.setError(null);
                    return true;
                }
            }
            private boolean validatepsw(){
                String pass = psw.getText().toString().trim();
                if (pass.isEmpty()){
                    psw.setError("Field can't be empty");
                    return false;
                }
                else{
                    psw.setError(null);
                    return true;
                }
            }
            public void onClick(View v) {
                if (!validatename() | !validatepsw()){
                    return;
                }
                String info = name.getText().toString().trim();
                String pass = psw.getText().toString().trim();
                Intent first = new Intent(loginpage.this,workingpage.class);
                startActivity(first);
            }
        });
    }
}