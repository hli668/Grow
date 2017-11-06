package com.grow.cmputf17team4.grow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


/**
 * MainActivity
 */
public class ActivityMain extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private MenuItem menuItem;
    private User user;
    private String file;
    private BottomNavigationView bottomNavigationView;
    private ListView listView;
    private EventTodayAdapter eventAdapter;
    private ImageButton addHabit;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_habit_event:
                                viewPager.setCurrentItem(0);
                                return false;
                            case R.id.navigation_trace:
                                viewPager.setCurrentItem(1);
                                return false;
                            case R.id.navigation_community:
                                viewPager.setCurrentItem(2);
                                return false;
                            case R.id.navigation_settings:
                                viewPager.setCurrentItem(3);
                                return false;
                            default:
                                return false;
                        }
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        // Initialize Toolbar
        Log.d("toolbar", "adding button");
        addHabit = (ImageButton) findViewById(R.id.add_habit);
        addHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityMain.this, "Add habit", Toast.LENGTH_SHORT).show();
            }
        });

        setupViewPager(viewPager);
    }

    @Override
    public void onClick(View v){
        Log.d("click", "invoked onClick()");
        int id = v.getId();
        if(id == R.id.add_habit){
            Toast.makeText(ActivityMain.this, "Add habit", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(FragmentEventList.newInstance("Habit Event"));
        adapter.addFragment(FragmentEventList.newInstance("Trace"));
        adapter.addFragment(FragmentEventList.newInstance("Community"));
        adapter.addFragment(FragmentEventList.newInstance("Settings"));
        viewPager.setAdapter(adapter);
    }



    public void saveInFile(){

    }

    public void loadFromFile(){

    }
}
