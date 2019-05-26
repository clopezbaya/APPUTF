package com.example.crizzz.mitren;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class conoceCochaFragment extends Fragment {

    private final String TAG = "MAPASCC";
    private final int ERROR_DIALOG_REQUEST = 9001;

    private ImageButton imgHospitales;
    private ImageButton imgBancos;
    private ImageButton imgParques;
    private ImageButton imgCentrosInformacion;
    private ImageButton imgPolicias;
    private ImageButton imgHoteles;
    private ImageButton imgCentroDeportivo;
    private ImageButton imgComercio;
    private ImageButton imgGastronomia;
    private ImageButton imgColegios;
    private ImageButton imgTuristico;

    public conoceCochaFragment() {
        // Required empty public constructor
    }

    public static conoceCochaFragment newInstance(String param1, String param2) {
        conoceCochaFragment fragment = new conoceCochaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public boolean isServiceOk(){
        Log.d(TAG,"isServiceOK : Verificando version Google Services");
        int disponible = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.getContext());

        if(disponible == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServiceOk: Google play Services Esta Trabajando");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(disponible)){
            Log.d(TAG, "isServiceOk: Un error Ocurrio Pero Podemos Resolverlo");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this.getActivity(),disponible,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this.getContext(),"Nosotros no podemos tomar la solicitud de MAPS",Toast.LENGTH_LONG).show();
        }
        return false;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_conoce_cocha, container, false);

        final CcBancos bancos = new CcBancos();
        imgBancos = (ImageButton)v.findViewById(R.id.btnB);
        imgBancos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,bancos)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return v;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getContext(), "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getContext(), "portrait", Toast.LENGTH_SHORT).show();
        }
    }

}
