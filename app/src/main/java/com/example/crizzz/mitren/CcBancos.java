package com.example.crizzz.mitren;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class CcBancos extends Fragment {

    private ImageButton imgBancoUP;
    private ImageButton imgBancoFR;
    private ImageButton imgBancoBV;
    private ImageButton imgBancoUV;
    private ImageButton imgBancoBNBV;
    private MapCC mapas = new MapCC();


    private OnFragmentInteractionListener mListener;

    public CcBancos() {
    }

    public static CcBancos newInstance(String param1, String param2) {
        CcBancos fragment = new CcBancos();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Bundle bundle = new Bundle();
        View v =  inflater.inflate(R.layout.fragment_cc_bancos, container, false);
        imgBancoUP = (ImageButton)v.findViewById(R.id.btnCCBUC);
        imgBancoUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,mapas)
                        .addToBackStack(null)
                        .commit();
                bundle.putDouble("latitud",-17.401273);
                bundle.putDouble("longitud",-66.153130);
                mapas.setArguments(bundle);
            }
        });
        imgBancoFR = (ImageButton)v.findViewById(R.id.btnCCBFR);
        imgBancoFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,mapas)
                        .addToBackStack(null)
                        .commit();
                bundle.putDouble("latitud",-17.423467);
                bundle.putDouble("longitud",-66.158386);
                mapas.setArguments(bundle);
            }
        });
        imgBancoBV = (ImageButton)v.findViewById(R.id.btnCCBBV);
        imgBancoBV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,mapas)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url","https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                mapas.setArguments(bundle);
            }

        });
        imgBancoUV = (ImageButton) v.findViewById(R.id.btnCCBUV);
        imgBancoUV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, mapas)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url", "https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                mapas.setArguments(bundle);

            }
        });

        imgBancoBNBV = (ImageButton) v.findViewById(R.id.btnCCBBV);
        imgBancoBNBV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, mapas)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url", "https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                mapas.setArguments(bundle);

            }
        });
        return v;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
