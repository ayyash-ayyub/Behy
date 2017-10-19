package adompo.ayyash.behay.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import adompo.ayyash.behay.ConfigUmum;
import adompo.ayyash.behay.R;

import java.util.List;


public class MainAdapterAktifitas extends RecyclerView.Adapter<MainAdapterAktifitas.MainHolderAktifitas> {

    ProgressDialog progressDialog;



    public List<ItemObjectAktifitas.ObjectAkatifitas.Results> resultsList;
    public Context context;

    public MainAdapterAktifitas(Context context, List<ItemObjectAktifitas.ObjectAkatifitas.Results> resultsList) {
        this.context = context;
        this.resultsList = resultsList;
    }

    @Override
    public MainHolderAktifitas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        MainHolderAktifitas mainHolder = new MainHolderAktifitas(view);
        return mainHolder;
    }

    public void DeleteData(String Url) {
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url,
                new Response.Listener<String>() {;
                    @Override
                    public void onResponse(String response) {
                        Log.d("uye jadi hapus", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("uye gagal hapus", error.toString());

            }
        });
        queue.add(stringRequest);
    }

    @Override
    public void onBindViewHolder(MainHolderAktifitas holder, final int position) {
        holder.txt_judul.setText(resultsList.get(position).judul);
        holder.txt_label.setText(resultsList.get(position).kategori);
        holder.txt_tanggal.setText(resultsList.get(position).tanggal);

//        final String nama_makanan =resultsList.get(position).activity;
        final String idd = resultsList.get(position).id;

        holder.cardview_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                progressDialog = new ProgressDialog(context);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Silahkan Tunggu...");


                   //  DeleteData(ConfigUmum.URL_DELETE_ACTIVITY+idd);
                // Intent i = new Intent(context, Pengalih.class);
                //  view.getContext().startActivity(i);


                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Konfirmasi");
//                builder.setMessage("Apakah anda yakin ingin menghapus\n" +
//                        nama_makanan + " ?");
                builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  http://103.43.45.237/recfon/api/delete_activity.php?id=13
//                        DeleteData(ConfigUmum.URL_DELETE_ACTIVITY+idd);
//                        dialog.dismiss();

                        //   Intent i = new Intent(context, SarapanActivity.class);

                        //
                        //  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
                        //view.getContext().startActivity(i);

                        //   Toast.makeText(context,"UYE:"+idd, Toast.LENGTH_SHORT).show();


                        Activity activity = (Activity)view.getContext();
                        activity.finish();
                        view.getContext().startActivity(activity.getIntent());

                    }
                });
                builder.setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


                //   Toast.makeText(context,"ID nya: "+resultsList.get(position).nama_makanan, Toast.LENGTH_LONG).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return this.resultsList.size();
    }





    public final static class MainHolderAktifitas extends RecyclerView.ViewHolder {

        ImageView img_banner;
        TextView txt_judul, txt_tanggal, txt_label;

        CardView cardview_item;

        MainHolderAktifitas(View itemView) {
            super(itemView);

            img_banner = (ImageView)itemView.findViewById(R.id.imgTumb);
            txt_judul = (TextView) itemView.findViewById(R.id.txtJudul);
            txt_tanggal = (TextView) itemView.findViewById(R.id.txtTgl);
            txt_label = (TextView)itemView.findViewById(R.id.txtLabel);
            cardview_item = (CardView) itemView.findViewById(R.id.cv_item);
        }
    }
}
