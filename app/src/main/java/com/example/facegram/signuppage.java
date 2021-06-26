package com.example.facegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signuppage extends AppCompatActivity {
    private Button startbtn;
    private EditText username,useremail,userpsw,usercpsw,userage,usernation,usercontact;
    private TextView second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        username =findViewById(R.id.name);
        second = findViewById(R.id.second);
        startbtn = findViewById(R.id.start);
        useremail = findViewById(R.id.email);
        userpsw = findViewById(R.id.psw);
        usercpsw = findViewById(R.id.cpsw);
        userage = findViewById(R.id.age);
        usernation = findViewById(R.id.nation);
        usercontact = findViewById(R.id.contact);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flip=new Intent(signuppage.this,loginpage.class);
                startActivity(flip);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {

            private boolean validatename(){
                String info = username.getText().toString().trim();
                if (info.isEmpty()){
                    username.setError("Field can't be empty");
                    return false;
                }
                else{
                    username.setError(null);
                    return true;
                }
            }
            private boolean validateemail(){
                String mail = useremail.getText().toString().trim();
                if (mail.isEmpty()){
                    useremail.setError("Field can't be empty");
                    return false;
                }
                else{
                    useremail.setError(null);
                    return true;
                }
            }
            private boolean validatepsw(){
                String pass = userpsw.getText().toString().trim();
                if (pass.isEmpty()){
                    userpsw.setError("Field can't be empty");
                    return false;
                }
                else{
                    userpsw.setError(null);
                    return true;
                }
            }
            private boolean validatecpsw() {
                String confirmpass = usercpsw.getText().toString().trim();

                if (confirmpass.isEmpty()) {
                    usercpsw.setError("Field can't be empty");
                    return false;


                } else {
                    usercpsw.setError(null);
                    return true;
                }

            }
            private boolean validateupm(){
                String check = usercpsw.getText().toString().trim();
                String pass = userpsw.getText().toString().trim();
                if(!check.equals(pass)){
                    usercpsw.setError("password not matched");
                    return false;
                }
                else {
                    usercpsw.setError(null);
                    return true;
                }
            }

            private boolean validateage(){
                String AGE = userage.getText().toString().trim();
                if (AGE.isEmpty()){
                    userage.setError("Field can't be empty");
                    return false;
                }
                else{
                    userage.setError(null);
                    return true;
                }
            }
            private boolean validatenation(){
                String country = usernation.getText().toString().trim();
                if (country.isEmpty()){
                    usernation.setError("Field can't be empty");
                    return false;
                }
                else{
                    usernation.setError(null);
                    return true;
                }
            }
            private boolean validatecontact(){
                String phone = usercontact.getText().toString().trim();
                if (phone.isEmpty()){
                    usercontact.setError("Field can't be empty");
                    return false;
                }
                else{
                    usercontact.setError(null);
                    return true;
                }
            }
            private boolean validatephone(){
                String check = usercontact.getText().toString().trim();
                if(check.length()!=10){
                    usercontact.setError("phone number should consist ten digits");
                    return false;
                }
                else {
                    usercontact.setError(null);
                    return true;
                }
            }
            private boolean validatepassword(){
                String cheg = userpsw.getText().toString().trim();
                if(cheg.length()>6 ){
                    userpsw.setError(null);
                    return true;
                }
                else {
                    userpsw.setError("password length must be more than 6");
                    return false;
                }
            }
            private boolean validatepass(){
                String avail = userpsw.getText().toString().trim();
                if(avail.matches("(.*[A-Z]*.)") && avail.matches("(.*[0-9]*.)")){
                    userpsw.setError(null);
                    return true;
                }
                else {
                    userpsw.setError("password must contain at least one uppercase letter and number");
                    return false;
                }
            }
            public void onClick(View v) {
                if (!validatename() | !validateemail() | !validatepsw() | !validatecpsw() | !validateage() | !validatenation() | !validatecontact() | !validateupm() | !validatephone() | !validatepassword() | !validatepass()) {
                    return;
                }
                String info = username.getText().toString().trim();
                String mail = useremail.getText().toString().trim();
                String pass = userpsw.getText().toString().trim();
                String confirmpass = usercpsw.getText().toString().trim();
                String check = usercpsw.getText().toString().trim();
                String AGE = userage.getText().toString().trim();
                String country = usernation.getText().toString().trim();
                String phone = usercontact.getText().toString().trim();
                Intent intent = new Intent(signuppage.this,workingpage.class);
                startActivity(intent);

            }
        });

    }
}