package com.example.crizzz.mitren;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class educacionVialFragment extends Fragment {

    private ImageButton imgCrucePeatonal;
    private ImageButton imgParadaTransportePublico;
    private ImageButton imgSemaforo;

    private WebViewerPrincipal videos = new WebViewerPrincipal();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public educacionVialFragment() {
    }

    public static educacionVialFragment newInstance(String param1, String param2) {
        educacionVialFragment fragment = new educacionVialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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

        final Bundle bundle = new Bundle();
        View v = inflater.inflate(R.layout.fragment_educacion_vial, container, false);

        imgCrucePeatonal = (ImageButton)v.findViewById(R.id.btnCP);
        imgCrucePeatonal.setOnClickListener(new View.OnClickListener() {
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
        imgParadaTransportePublico = (ImageButton)v.findViewById(R.id.btnPTP);
        imgParadaTransportePublico.setOnClickListener(new View.OnClickListener() {
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
        imgSemaforo = (ImageButton)v.findViewById(R.id.btnS);
        imgSemaforo.setOnClickListener(new View.OnClickListener() {
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
