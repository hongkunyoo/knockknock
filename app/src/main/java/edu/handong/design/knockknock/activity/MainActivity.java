package edu.handong.design.knockknock.activity;

import java.util.ArrayList;
import java.util.HashMap;
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
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.adapter.kViewPagerAdapter;
import edu.handong.design.knockknock.fragment.HomeFragment;
import edu.handong.design.knockknock.fragment.HouseWorkFragment;
import edu.handong.design.knockknock.fragment.MoneyFragment;
import edu.handong.design.knockknock.fragment.ShoppingFragment;
import edu.handong.design.knockknock.util.BitmapUtil;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.view.CircleImageView;


public class MainActivity extends AppCompatActivity {

    private Context context;

    private CircleImageView mProfileImage;
    // update the menu_main_ content by replacing fragments
//    Fragment fragment = null;
    ViewPager viewPager;
    TabLayout tabLayout;

    public static HashMap<Bitmap, Bitmap> resizeImageMap = new HashMap<>();

    public static Bitmap getBitmap(Bitmap key, int _width, int _height) {
        Bitmap retBit = resizeImageMap.get(key);
        if (retBit == null) {
            double width = _width;
            double height = _height;
            double scaleFactor = 0.57;
            Bitmap bit;
            Bitmap bitmapImage = key;

            bit = BitmapUtil.decodeInSampleSize(bitmapImage, (int) (width * scaleFactor), (int) (height * scaleFactor));
            resizeImageMap.put(bitmapImage, bit);
            retBit = bit;
        }
        return retBit;
    }

    private int[] iconArr = new int[]{R.drawable.icon1_wob, R.drawable.icon2_wob, R.drawable.icon3_wob,
            R.drawable.icon4_wob, R.drawable.icon5_wob, R.drawable.icon6_wob, R.drawable.icon7_wob,
            R.drawable.icon8_wob, R.drawable.icon9_wob};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tab_anim_toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.tab_anim_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_anim_tabs);

        setupViewPager(viewPager);


        tabLayout.setBackgroundColor(getResources().getColor(R.color.knock_white));

//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        if(collapsingToolbarLayout != null) {
//            collapsingToolbarLayout.setTitle(toolbar.getTitle());
//        }

    }

    private void setupViewPager(ViewPager viewPager) {
        kViewPagerAdapter adapter = new kViewPagerAdapter(getSupportFragmentManager());
        adapter.setContext(this);

        adapter.addFrag(new HouseWorkFragment(), getResources().getDrawable(R.drawable.page01_icon));
        adapter.addFrag(new HomeFragment(), getResources().getDrawable(R.drawable.page02_icon));
        adapter.addFrag(new MoneyFragment(), getResources().getDrawable(R.drawable.page03_icon));
        adapter.addFrag(new ShoppingFragment(), getResources().getDrawable(R.drawable.page04_icon));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }

        tabLayout.getTabAt(0).select();

    }

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
        if (id == R.id.action_menu) {
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        }
        return super.onOptionsItemSelected(item);
    }

}
