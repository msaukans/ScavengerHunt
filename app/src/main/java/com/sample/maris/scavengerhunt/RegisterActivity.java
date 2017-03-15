package com.sample.maris.scavengerhunt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.*;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registerBtn;
    private EditText edEmail,edPass;
    private TextView tv1;
    private ProgressDialog bar;

    private FirebaseAuth fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bar = new ProgressDialog(this);

        fire = FirebaseAuth.getInstance();

        if(fire.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        registerBtn = (Button) findViewById(R.id.registerBtn);
        edEmail = (EditText) findViewById(R.id.editTextEmail);
        edPass = (EditText) findViewById(R.id.editTextPass);

        tv1 = (TextView) findViewById(R.id.tv1);

        registerBtn.setOnClickListener(this);
        tv1.setOnClickListener(this);
    }//end onCreate methods

    private void registerUser(){
        String email = edEmail.getText().toString().trim();
        String pass = edPass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //if email is empty
            Toast.makeText(this,"Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){//if password is empty
            Toast.makeText(this,"Please enter pass", Toast.LENGTH_SHORT).show();
            return;
        }

        bar.setMessage("Registering user...");
        bar.show();


        fire.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registered user", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Fail register",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


    }//end RegisterUser method

    @Override
    public void onClick(View view) {
        if(registerBtn == view){
            registerUser();
        }

        if(view == tv1){
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        }
    }//end OnClick method

}

