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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.marlon.fireapp.R;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText etEmail,etPass;

    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.reg_etEmail);
        etPass = findViewById(R.id.reg_etPass);

        btnRegister = findViewById(R.id.reg_btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Ingresa tu email", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(RegisterActivity.this, "Ingresa tu contraseña", Toast.LENGTH_SHORT).show();
                }

                auth.createUserWithEmailAndPassword(email,pass)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(RegisterActivity.this, "Registrado con exito!", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                           startActivity(intent);
                           finish();
                       }else {
                           Toast.makeText(RegisterActivity.this, "Fallo el registro", Toast.LENGTH_SHORT).show();
                       }

                   }
               });
            }
        });

    }
}
