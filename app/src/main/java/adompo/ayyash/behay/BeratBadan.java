package adompo.ayyash.behay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class BeratBadan extends AppCompatActivity {
Button btnSimpanBerat;
    EditText editTextBe;
    PrefManager pref;
    ProgressDialog progressDialog;

    public static final String KEY_EMAIL= "berat_tubuh";
    public static final String KEY_SAVEBERAT= "berat_tubuh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan);

        pref = new PrefManager(this);
        Log.d("bakso"," " + pref.getActiveEmail());


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Silahkan Tunggu...");


        btnSimpanBerat = (Button)findViewById(R.id.btn_simpanBerat);
        editTextBe = (EditText)findViewById(R.id.etxt_berat);

        btnSimpanBerat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextBe.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"tidak boleh kosong", Toast.LENGTH_LONG).show();
                }else {save();




                }


            }
        });

   //bla bla



    }

    private int aa(){
        return 0;
    }


    private void tampan(){
        System.out.println("sdfdgfd");
    }


    private void save() {
        progressDialog.show();

        final String email = pref.getActiveEmail();
        final String berat_badan = editTextBe.getText().toString().trim();




        StringRequest sR = new StringRequest(Request.Method.POST, ConfigUmum.INPUT_BERAT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();


                        progressDialog.dismiss();
                        //  signinhere.setText(response);
                        Intent i = new Intent(getApplicationContext(), UtamaActivity.class);
                        startActivity(i);
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email);
                params.put(KEY_SAVEBERAT, berat_badan);


                return params;
            }

        };
//        Toast.makeText(getApplicationContext(), txt_email + " makanan = " + makanan, Toast.LENGTH_LONG).show();
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        sR.setRetryPolicy(policy);
        requestQueue.add(sR);
    }
}
