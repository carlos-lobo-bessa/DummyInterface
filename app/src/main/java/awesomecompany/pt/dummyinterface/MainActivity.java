package awesomecompany.pt.dummyinterface;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import awesomecompany.pt.dummyinterface.Adapters.TabBarAdapter;
import awesomecompany.pt.dummyinterface.Repository.FoodRepo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FoodRepo fr = new FoodRepo();
        fr.createLists();

        setContentView(R.layout.activity_main);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }


        TabLayout tabLayout = findViewById(R.id.main_activity_tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_activity_view_pager);

        viewPager.setAdapter(new TabBarAdapter(getSupportFragmentManager(), getApplicationContext()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
