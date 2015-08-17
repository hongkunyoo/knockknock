package edu.handong.design.knockknock.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.adapter.kViewPagerAdapter;
import edu.handong.design.knockknock.fragment.HomeFragment;
import edu.handong.design.knockknock.fragment.HouseWorkFragment;
import edu.handong.design.knockknock.fragment.MoneyFragment;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.view.CircleImageView;


public class MainActivity extends AppCompatActivity {

    private Context context;

    private CircleImageView mProfileImage;
    // update the menu_main_ content by replacing fragments
    Fragment fragment = null;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tabanim_toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);

        setupViewPager(viewPager);



        tabLayout.setBackgroundColor(getResources().getColor(R.color.knock_white));



    }

    private void setupViewPager(ViewPager viewPager) {
        kViewPagerAdapter adapter = new kViewPagerAdapter(getSupportFragmentManager());
        adapter.setContext(this);

        adapter.addFrag(new HouseWorkFragment(), getResources().getDrawable(R.drawable.page01_icon));
        adapter.addFrag(new HomeFragment(), getResources().getDrawable(R.drawable.page02_icon));
        adapter.addFrag(new MoneyFragment(), getResources().getDrawable(R.drawable.page03_icon));
        adapter.addFrag(new MoneyFragment(), getResources().getDrawable(R.drawable.page04_icon));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
            Logger.log(tab);
        }




    }

//    class ViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
//        private final List<android.support.v4.app.Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();
//        public ViewPagerAdapter(android.support.v4.app.FragmentManager manager) {
//            super(manager);
//        }
//        @Override
//        public android.support.v4.app.Fragment getItem(int position) {
//            return mFragmentList.get(position);
//        }
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//        public void addFrag(android.support.v4.app.Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, TestActivity.class));
            return true;
        } else if (id == R.id.action_drawer) {
            startActivity(new Intent(MainActivity.this, DrawerActivity.class));
            return true;
        } else if (id == R.id.action_test2) {
            startActivity(new Intent(MainActivity.this, TestActivity2.class));
            return true;
        } else if (id == R.id.action_test3) {
            startActivity(new Intent(MainActivity.this, TestActivity3.class));
            return true;
        } else if (id == R.id.action_preset) {
            startActivity(new Intent(MainActivity.this, PresetTabActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
