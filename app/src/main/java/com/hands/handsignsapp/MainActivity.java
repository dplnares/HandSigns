package com.hands.handsignsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hands.handsignsapp.fragments.HelpFragment;
import com.hands.handsignsapp.fragments.HomeFragment;
import com.hands.handsignsapp.fragments.LearnFragment;
import com.hands.handsignsapp.fragments.TranslateFragment;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    LearnFragment learnFragment = new LearnFragment();
    TranslateFragment translateFragment = new TranslateFragment();
    HelpFragment helpFragment = new HelpFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            switch(item.getItemId()){
                case R.id.homeFragment:
                    loadFragment(homeFragment);
                    return true;
                case R.id.learnFragment:
                    loadFragment(learnFragment);
                    return true;
                case R.id.translateFragment:
                    loadFragment(translateFragment);
                    return true;
                case R.id.helpFragment:
                    loadFragment(helpFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }

}