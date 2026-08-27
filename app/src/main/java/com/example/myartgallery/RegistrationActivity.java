package com.example.myartgallery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextDateOfBirth;
    private RadioGroup radioGroupGender;
    private Button buttonRegister;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonRegister = findViewById(R.id.buttonRegister);

        mAuth = FirebaseAuth.getInstance();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = editTextName.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                final String dateOfBirth = editTextDateOfBirth.getText().toString();

                // Check the selected gender
                RadioButton selectedRadioButton = findViewById(radioGroupGender.getCheckedRadioButtonId());
                final String gender = selectedRadioButton.getText().toString();

                if (password.equals(confirmPassword)) {
                    // Register the user with Firebase Authentication
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Registration successful
                                        String userId = mAuth.getCurrentUser().getUid();
                                        User user = new User(name, email, dateOfBirth, gender,password);

                                        // Store user data in Firebase Realtime Database
                                        databaseReference.child("user").child(userId).setValue(user);

                                        Toast.makeText(RegistrationActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                        finish(); // Finish the registration activity

                                    } else {
                                        // Registration failed, display an error message
                                        Toast.makeText(RegistrationActivity.this, "Registration Failed. Please try again.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                } else {
                    // Passwords don't match, display an error message
                    Toast.makeText(RegistrationActivity.this, "Passwords do not match. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
