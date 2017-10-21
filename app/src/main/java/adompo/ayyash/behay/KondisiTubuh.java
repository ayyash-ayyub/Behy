package adompo.ayyash.behay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class KondisiTubuh extends Fragment {
    CardView cvBerat, cvTinggi, cvLemak;
    public static KondisiTubuh newInstance() {
        KondisiTubuh fragment = new KondisiTubuh();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kondisi_tubuh, container, false);
        cvLemak = (CardView) rootView.findViewById(R.id.cvLT);
        cvLemak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),FormLemak.class);
                getActivity().startActivity(i);
            }
        });
        cvTinggi = (CardView) rootView.findViewById(R.id.cvTB);
        cvTinggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),TinggiBadan.class);
                getActivity().startActivity(i);
            }
        });
        cvBerat = (CardView) rootView.findViewById(R.id.cvBB);
        cvBerat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),BeratBadan.class);
                getActivity().startActivity(i);
            }
        });

        return rootView;
    }
}