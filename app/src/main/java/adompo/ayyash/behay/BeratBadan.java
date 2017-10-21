package adompo.ayyash.behay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeratBadan extends AppCompatActivity {
Button btnSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan);

//        btnSimpan = (Button)findViewById(R.id.btn_simpan);
//        btnSimpan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),TinggiBadan.class);
//                startActivity(i);
//                finish();
//            }
//        });
    }
}
