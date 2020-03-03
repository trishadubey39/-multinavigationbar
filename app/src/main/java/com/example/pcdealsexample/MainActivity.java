package com.example.pcdealsexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pcdealsexample.Fragments.CartFragment;
import com.example.pcdealsexample.Fragments.HomeFragment;
import com.example.pcdealsexample.Fragments.ProfileFragment;
import com.example.pcdealsexample.Fragments.ShopFragment;
import com.example.pcdealsexample.Fragments.WishListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationViewTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.nav_view_bottom);
        navigationViewTop = findViewById(R.id.nav_view_top);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        drawer = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        navigation.setOnNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_hum);

        navigationViewTop.setNavigationItemSelectedListener(this);

        loadCategories(new HomeFragment());

    }

    private boolean loadCategories(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()

                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;


        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_cart:
                fragment = new CartFragment();
                break;
            case R.id.navigation_favorites:
                fragment = new WishListFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;

            default:
                fragment = new HomeFragment();
                break;


        }


        return loadFragment(fragment);



    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()

                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}