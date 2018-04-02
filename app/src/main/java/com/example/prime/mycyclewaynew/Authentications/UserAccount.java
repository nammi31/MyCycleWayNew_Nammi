package com.example.prime.mycyclewaynew.Authentications;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.prime.mycyclewaynew.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserAccount extends AppCompatActivity {

    Button editbtn;
    TextView username,emailaddress;
    ImageView imgview;
    FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mRootReference;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        username = (TextView)findViewById(R.id.nameTV);
        emailaddress=(TextView)findViewById(R.id.EmailTV);
        imgview=(ImageView)findViewById(R.id.userImage) ;
        editbtn=(Button)findViewById(R.id.editbtn);
        listView=(ListView)findViewById(R.id.placesList);

        auth=FirebaseAuth.getInstance();
        mRootReference = firebaseDatabase.getReference().child("users");
        final String mUserId=auth.getCurrentUser().getUid();

        mRootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                Profile profile = dataSnapshot.getValue(Profile.class);
//                System.out.println(profile.getUsername());
                String name=dataSnapshot.child(mUserId).child("name").getValue().toString();
                username.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        emailaddress.setText(auth.getCurrentUser().getEmail());



    }
}
