package com.tugcenurdaglar.detaylikitapsatis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tugcenurdaglar.detaylikitapsatis.controller.FragmentCallback;
import com.tugcenurdaglar.detaylikitapsatis.ui.anasayfa.AnasayfaFragment;
import com.tugcenurdaglar.detaylikitapsatis.ui.hesabim.HesabimFragment;
import com.tugcenurdaglar.detaylikitapsatis.ui.kategoriler.KategorilerFragment;
import com.tugcenurdaglar.detaylikitapsatis.ui.navbar.NavDegerlendirmeFragment;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, FragmentCallback {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private Button buttonDegerlendir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDegerlendir = findViewById(R.id.buttonDegerlendir);
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationView.bringToFront(); //önplana getirmek için, onClick i algılamadığı için
        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);


        drawer.addDrawerListener(toggle);
        toggle.syncState();
        loadFirstFragment();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_degerlendirme:
                        changeFragment(NavDegerlendirmeFragment.newInstance(), true);
                        //isAdded: geri tuşuna bastığımızda bu fragment i ekliyim mi
                        break;

                }
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });


        //bottom navigationa tıklama özelliği kazantırdık
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_anasayfa:
                        changeFragment(AnasayfaFragment.newInstance(), true);
                        break;
                    case R.id.action_favorilerim:
                        //changeFragment
                        break;

                    case R.id.action_kategoriler:
                        changeFragment(KategorilerFragment.newInstance(), true);
                        break;

                    case R.id.action_hesabim:
                        changeFragment(HesabimFragment.newInstance(), true);
                        break;



                }

                return false;

            }
        });

    }


    @Override
    public void onBackPressed() { //geri tuşuyla da drawer ı kapatabiliriz artık.
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void loadFirstFragment() {
        changeFragment(AnasayfaFragment.newInstance(), false);
    }

    @Override
    public void changeFragment(Fragment fragment, Boolean isAdded) { //fragment değeieştiren kod
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_tutucu, fragment);
        if (isAdded) {
            transaction.addToBackStack(fragment.getClass().getCanonicalName());
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //arama iconunu aktifleştirdik

        getMenuInflater().inflate(R.menu.toolbar_menu_arama, menu);

        MenuItem item = menu.findItem(R.id.action_arama);


        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen arama sonucu", query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf girdikçe sonucu", newText);
        return true;
    }


}