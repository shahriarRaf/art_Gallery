package com.example.myartgallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    FirebaseAuth auth;
    TextView textViewE,textViewP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        textViewE=findViewById(R.id.editTextEmail);
        textViewP=findViewById(R.id.editTextPassword);
        auth=FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=textViewE.getText().toString();
                String password=textViewP.getText().toString();
                if(!email.equals("")&&!password.equals("")){
                    login(email,password);
                }else {
                    Toast.makeText(MainActivity.this, "Please Enter ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Click listener to navigate to the registration activity
        TextView textViewRegister = findViewById(R.id.textViewRegister);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
    public  void login(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(MainActivity.this,ControlFunction.class);
                    Toast.makeText(MainActivity.this, "LogIn is successfull", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Unsucessful", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
