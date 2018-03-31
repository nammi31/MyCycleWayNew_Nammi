package com.example.prime.mycyclewaynew.Authentications;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.prime.mycyclewaynew.MainActivity;
import com.example.prime.mycyclewaynew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class EmailSignUpinActivity extends AppCompatActivity  {
    Button btnSignIn;
    EditText userNameET,passwordET,cPasswordET,emailEt;
    ProgressBar progressBar;
    FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference;
    private FirebaseStorage mStorage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);
        //get firebase auth instance
        auth=FirebaseAuth.getInstance();
        mStorage=FirebaseStorage.getInstance();

        mRootReference = firebaseDatabase.getReference();
        emailEt= (EditText) findViewById(R.id.EmailET);
        passwordET=(EditText)findViewById(R.id.PassET);
        cPasswordET=(EditText)findViewById(R.id.CpassET);
        userNameET=(EditText)findViewById(R.id.nameEditText);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=emailEt.getText().toString().trim();
                final String password=passwordET.getText().toString().trim();
                String confPass=cPasswordET.getText().toString().trim();
                final String name=userNameET.getText().toString().trim();
                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confPass)) {
                    Toast.makeText(getApplicationContext(), "Confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(confPass)){
                    Toast.makeText(getApplicationContext(), "password didn't match", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6) {
                    Toast.makeText(getApplicationContext(), "password is too short", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(EmailSignUpinActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(EmailSignUpinActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                        progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(EmailSignUpinActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {

//                            StorageReference filepath = mStorage.child("user_profile").child(mImageUri.getLastPathSegment());
//                            filepath.putFile(mImageUri).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
//                                    if (progress == 100) {
//                                        hideProgressDialog();
//                                        //upload();
//                                    }
//                                    System.out.println("Upload is " + progress + "% done");
//                                }
//                            }).addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onPaused(UploadTask.TaskSnapshot taskSnapshot) {
//                                    System.out.println("Upload is paused");
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception exception) {
//                                    // Handle unsuccessful uploads
//                                }
//                            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                                    /** Get Image Download Path**/
//                                    Uri downloadUri = taskSnapshot.getDownloadUrl();
//
//                                    /** Converting Image Uri In String **/
//
//                                    if (downloadUri != null) {
//                                        imagerls = downloadUri.toString();
//                                    }
//
//                                    //Add user data and image URL to firebase database
//                            mRootReference.child("users").child(auth.getCurrentUser().getUid()).child("User Name").child(name);
//                            mRootReference.child("users").child(auth.getCurrentUser().getUid()).child("Email").child(email);
//                            mRootReference.child("users").child(auth.getCurrentUser().getUid()).child("password").child(password);
                            Toast.makeText(getApplicationContext(), "Logged in as "+auth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(EmailSignUpinActivity.this, UserAccount.class));
                        }
                    }
                });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

}

