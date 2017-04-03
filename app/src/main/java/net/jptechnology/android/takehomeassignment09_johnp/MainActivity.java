package net.jptechnology.android.takehomeassignment09_johnp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView displayText;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference vendorsRef = database.getReference("vendors");
    private ArrayList<vendor> vendorsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView) findViewById(R.id.display_text);

        vendorsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                vendorsList.add(dataSnapshot.getValue(vendor.class));
                displayVendors();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(vendor.class) + " has changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(vendor.class) + " is removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void addVendor(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    private void displayVendors() {
        String text = "";
        for (vendor p : vendorsList)
            text += p + "\n";
        displayText.setText(text);
    }
}
