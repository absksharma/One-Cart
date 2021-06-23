package com.example.oneshop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.oneshop.R;
import com.example.oneshop.ui.LoginActivity;
import com.example.oneshop.ui.home.fragments.FavoriteFragment;
import com.example.oneshop.ui.home.fragments.HomeFragment;
import com.example.oneshop.ui.home.fragments.ProfileFragment;
import com.example.oneshop.ui.home.fragments.StoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNav;
    FragmentManager fm;
    Fragment fragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("  One cart");
        //to set icons over toolbar
        actionBar.setIcon(R.drawable.call_icon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.navigationHome) {
            fragment = new HomeFragment();
        }
        if (id == R.id.navigationProfile) {
            fragment = new ProfileFragment();
        }
        if (id == R.id.navigationStore) {
            fragment = new StoreFragment();
        }
        if (id == R.id.navigationFavorite) {
            fragment = new FavoriteFragment();
        }
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int tool = item.getItemId();

        if (tool == R.id.toolbarFavorite) {
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(getApplicationContext(), "Favorite clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}