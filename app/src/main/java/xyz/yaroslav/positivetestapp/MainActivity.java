package xyz.yaroslav.positivetestapp;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private int cur_frag = 0;

    public void setCur_frag(int cur_frag) {
        this.cur_frag = cur_frag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_cards:
                    displayCardsFragment();
                    break;
                    /*
                case R.id.nav_notes:
                    break;
                case R.id.nav_settings:
                    break;
                case R.id.nav_tests:
                    break;
                    */
            }

            menuItem.setChecked(false);
            drawerLayout.closeDrawers();

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            return true;
        });

        /*
        if (savedInstanceState != null) {
            int saved_key = savedInstanceState.getInt("frag");
            switch (saved_key) {
                case 1:
                    displayCardsFragment();
                    break;
                default:
                    displayStartFragment();
                    break;
            }
        } else {
            displayStartFragment();
        }
        */

        displayCardsFragment();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("frag", cur_frag);
    }

    private void displayStartFragment() {
        StartFragment fragment = new StartFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
        cur_frag = 0;
    }

    private void displayCardsFragment() {
        CardsFragment fragment = new CardsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
        cur_frag = 1;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressed();
        }
    }

    public void openThisFuckenDrawer() {
        drawerLayout.openDrawer(Gravity.START);
    }

}
