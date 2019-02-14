package com.marlon.fireapp.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.marlon.fireapp.R;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth auth;

    EditText etEmail,etPass;
    Button btnLogin,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.log_etEmail);
        etPass  = findViewById(R.id.log_etPass);

        btnLogin = findViewById(R.id.logbtnSignIn);
        btnRegister= findViewById(R.id.log_btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Debes ingresar un email", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "Debes ingresar tu contraseña", Toast.LENGTH_SHORT).show();
                }

                auth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login con exito", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
