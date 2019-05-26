package com.example.crizzz.mitren;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class NavigationDrawerMiTren extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        rutasFragment.OnFragmentInteractionListener,destinoFragment.OnFragmentInteractionListener
        ,educacionVialFragment.OnFragmentInteractionListener,
        conoceMiTrenFragment.OnFragmentInteractionListener,horariosFragment.OnFragmentInteractionListener,
        WebViewerPrincipal.OnFragmentInteractionListener,
        tarjetaFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_mi_tren);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        String fragmentoLlave = getIntent().getStringExtra("llave");

        if(fragmentoLlave.equals("rutas")){
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,new rutasFragment()).commit();
        }else if(fragmentoLlave.equals("destinos")){
            Fragment mapa = new MapCC();
            Bundle bundle = new Bundle();
            bundle.putInt("latitud",-34);
            mapa.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.content_main, mapa).commit();
        }else if(fragmentoLlave.equals("conoceMiTren")){
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,new conoceMiTrenFragment()).commit();
        }else if(fragmentoLlave.equals("conoceCocha")){
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,new conoceCochaFragment()).commit();
        }else if(fragmentoLlave.equals("horarios")){
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,new horariosFragment()).commit();
        }else if(fragmentoLlave.equals("educacionVial")){
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,new educacionVialFragment()).commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer_mi_tren, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Realizado Por : Christian Lopez Baya");
            alert.setTitle("Acerca Del Desarrollador: ");
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment itFragment = null;
        boolean fragmentSelected = false;

        int id = item.getItemId();

        if (id == R.id.rutas) {
           itFragment = new rutasFragment();
           fragmentSelected = true;
        } else if (id == R.id.destino) {
            itFragment = new destinoFragment();
            fragmentSelected = true;
        } else if (id == R.id.tarjeta) {
            itFragment = new tarjetaFragment();
            fragmentSelected = true;
        } else if (id == R.id.conoceCocha) {
            itFragment = new conoceCochaFragment();
            fragmentSelected = true;
        } else if (id == R.id.eduVial) {
            itFragment = new educacionVialFragment();
            fragmentSelected = true;
        } else if (id == R.id.conoceMiTren) {
            itFragment = new conoceMiTrenFragment();
            fragmentSelected = true;
        }else if (id == R.id.noticias) {
            String link = "https://www.facebook.com/mopsv.bolivia/";
            Intent intent = null;
            intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
            startActivity(intent);
        } else if (id == R.id.facebook) {
            String link = "https://www.facebook.com/MiTrenCochabamba/";
            Intent intent = null;
            intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
            startActivity(intent);
        }else if (id == R.id.twiter) {
            String link = "https://twitter.com/mitrencocha?lang=es";
            Intent intent = null;
            intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
            startActivity(intent);
        } else if (id == R.id.instagram) {
            String link = "https://www.instagram.com";
            Intent intent = null;
            intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
            startActivity(intent);
        }

        if(fragmentSelected){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,itFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
