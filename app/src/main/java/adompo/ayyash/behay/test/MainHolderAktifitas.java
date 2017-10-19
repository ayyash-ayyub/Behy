package adompo.ayyash.behay.test;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import adompo.ayyash.behay.R;

/**
 * Created by Isfahani on 30-Jul-16.
 */

public class MainHolderAktifitas extends RecyclerView.ViewHolder {

    public ImageView img_banner;
    public TextView txt_judul, txt_tanggal, txt_label;

    public CardView cardview_item;

    public MainHolderAktifitas(View itemView) {
        super(itemView);

        img_banner = (ImageView)itemView.findViewById(R.id.imgTumb);
        txt_judul = (TextView) itemView.findViewById(R.id.txtJudul);
        txt_tanggal = (TextView) itemView.findViewById(R.id.txtTgl);
        txt_label = (TextView)itemView.findViewById(R.id.txtLabel);
        cardview_item = (CardView) itemView.findViewById(R.id.cv_item);
    }
}
