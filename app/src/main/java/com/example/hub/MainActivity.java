package com.example.hub;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmoothBottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Initialize ViewPager and SmoothBottomBar
        viewPager = findViewById(R.id.viewPager);
        bottomBar = findViewById(R.id.BottomBar);

        // Set up ViewPager and SmoothBottomBar
        setupViewPager(viewPager);

        bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                // Handle "History" item separately
                if (i != 3) {
                    viewPager.setCurrentItem(i);
                } else {
                    // If the selected item is "History," show a toast
                    Toast.makeText(MainActivity.this, "History menu item clicked", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        // Listen for page changes in the ViewPager to update swipe ability
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    bottomBar.setItemActiveIndex(2);  // Set the SmoothBottomBar to "Organization"
                } else {
                    bottomBar.setItemActiveIndex(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.history) {
            // Set the ViewPager to display the History fragment
            viewPager.setCurrentItem(3);  // History fragment is at position 3

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        // Set up the adapter and add the initial fragments
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(new Mission());
        fragmentAdapter.addFragment(new Navigation());
        fragmentAdapter.addFragment(new Organization());
        fragmentAdapter.addFragment(new History());
        viewPager.setAdapter(fragmentAdapter);
    }

    // FragmentAdapter to manage fragments
    private static class FragmentAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            fragmentList.add(fragment);
        }
    }
}
