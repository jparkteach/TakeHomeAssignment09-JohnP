package net.jptechnology.android.takehomeassignment09_johnp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference vendorsRef = database.getReference("vendors");

    private TextView vendorNameTextView;
    private TextView logoUrlTextView;
    private CheckBox freeShipCheckBox;
    private CheckBox isPickupAvailableCheckBox;
    private TextView exchangeRateYenTextView;
    private TextView exchangeRateEuroTextView;
    private TextView exchangeRateRealTextView;

    private double exchangeRateYen;
    private double exchangeRateEuro;
    private double exchangeRateReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        vendorNameTextView = (TextView) findViewById(R.id.vendorNameText);
        logoUrlTextView = (TextView) findViewById(R.id.logoUrlText);
        exchangeRateYenTextView = (TextView) findViewById(R.id.exchangeRateYenText);
        exchangeRateEuroTextView = (TextView) findViewById(R.id.exchangeRateEuroText);
        exchangeRateRealTextView = (TextView) findViewById(R.id.exchangeRateRealText);
        freeShipCheckBox = (CheckBox) findViewById(R.id.freeShipCheckBox);
        isPickupAvailableCheckBox = (CheckBox) findViewById(R.id.isPickupAvailableCheckBox);
    }


    public void addFirebase(View view) {
        exchangeRateYen = Double.parseDouble(exchangeRateYenTextView.getText().toString());
        exchangeRateEuro = Double.parseDouble(exchangeRateEuroTextView.getText().toString());
        exchangeRateReal = Double.parseDouble(exchangeRateRealTextView.getText().toString());

        vendorsRef.push().setValue(new vendor(vendorNameTextView.getText().toString()
                , logoUrlTextView.getText().toString(), exchangeRateYen, exchangeRateEuro
                , exchangeRateReal, freeShipCheckBox.isChecked()
                , isPickupAvailableCheckBox.isChecked()));
        finish();
    }
}
