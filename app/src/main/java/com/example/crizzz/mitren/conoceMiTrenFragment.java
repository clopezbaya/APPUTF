package com.example.crizzz.mitren;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class conoceMiTrenFragment extends Fragment {

    private ImageButton imgApeaderoDoble;
    private ImageButton imgApeadero;
    private ImageButton imgLineaRoja;
    private ImageButton imgSenalizacion;
    private WebViewerPrincipal videos = new WebViewerPrincipal();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public conoceMiTrenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final Bundle bundle = new Bundle();
        View v = inflater.inflate(R.layout.fragment_conoce_mi_tren, container, false);

        imgApeaderoDoble = (ImageButton)v.findViewById(R.id.btnAD);
        imgApeaderoDoble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,videos)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url","https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                videos.setArguments(bundle);
            }
        });
        imgApeadero = (ImageButton)v.findViewById(R.id.btnA);
        imgApeadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,videos)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url","https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                videos.setArguments(bundle);
            }
        });
        imgLineaRoja = (ImageButton)v.findViewById(R.id.btnA);
        imgLineaRoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,videos)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url","https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                videos.setArguments(bundle);
            }

        });
        imgSenalizacion = (ImageButton) v.findViewById(R.id.btnS);
        imgSenalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,videos)
                        .addToBackStack(null)
                        .commit();
                bundle.putString("url","https://www.youtube.com/watch?v=ST_u8xXJ6TA");
                videos.setArguments(bundle);
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
