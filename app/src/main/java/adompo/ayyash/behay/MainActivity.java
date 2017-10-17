package adompo.ayyash.behay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView tombolDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            ulangIntro();


        tombolDaftar = (TextView)findViewById(R.id.tmbDaftar);

        tombolDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
                finish();

            }
        });


    }


    protected void ulangIntro(){
        PrefManager prefManager = new PrefManager(getApplicationContext());

        // make first time launch TRUE
        prefManager.setFirstTimeLaunch(true);

       // startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
       // finish();

    }
}
