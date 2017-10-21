package adompo.ayyash.behay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FormLemak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lemak);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);



        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Tanita BC-418 Segmental Body Composition Analyzer");
        categories.add("seca mBCA 515");
        categories.add("Other");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
}
