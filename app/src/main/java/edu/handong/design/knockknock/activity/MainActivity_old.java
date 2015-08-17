//package edu.handong.design.knockknock.activity;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import android.app.Activity;
//import android.app.ActionBar;
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.support.design.widget.TabLayout;
//import android.support.v13.app.FragmentPagerAdapter;
//import android.os.Bundle;
//import android.support.v4.app.ActionBarDrawerToggle;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.view.ViewPager;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toolbar;
//
//import edu.handong.design.knockknock.R;
//import edu.handong.design.knockknock.adapter.kViewPagerAdapter;
//import edu.handong.design.knockknock.fragment.HomeFragment;
//import edu.handong.design.knockknock.fragment.HouseWorkFragment;
//import edu.handong.design.knockknock.fragment.MoneyFragment;
//import edu.handong.design.knockknock.view.CircleImageView;
//
//
//public class MainActivity_old extends AppCompatActivity {
//
//    //    private DrawerLayout mDrawerLayout;
////    private LinearLayout mLinearLayout;
////    private ListView mDrawerList;
////    private ActionBarDrawerToggle mDrawerToggle;
//    private Context context;
//    private CharSequence mDrawerTitle;
//    private CharSequence mTitle;
//    private String[] mPlanetTitles;
//
//    private CircleImageView mProfileImage;
//    private TextView mPetName;
//
//    // update the menu_main_ content by replacing fragments
//    Fragment fragment = null;
//
//
////    SectionsPagerAdapter mSectionsPagerAdapter;
////    ViewPager mViewPager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        context = this;
//        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tabanim_toolbar);
//        setSupportActionBar(toolbar);
//        ViewPager viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
//        setupViewPager(viewPager);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
//        tabLayout.setupWithViewPager(viewPager);
//
//        // Create the adapter that will return a fragment for each of the three
//        // primary sections of the activity.
////        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
////        mViewPager = (ViewPager) findViewById(R.id.pager);
////        mViewPager.setAdapter(mSectionsPagerAdapter);
//
//
////        mPlanetTitles = new String[]{"menu1, menu2, menu3"};
////        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
////        mLinearLayout = (LinearLayout) findViewById(R.id.left_drawer);
////        mDrawerList = (ListView) findViewById(R.id.drawer_list);
////        mProfileImage  = (CircleImageView) findViewById(R.id.drawer_profile);
////        mPetName = (TextView) findViewById(R.id.pet_name);
//
//
//        // set up the drawer's list view with items and click listener
////        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
////                R.layout.drawer_list_item, mPlanetTitles));
////
////        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
////
////        // ActionBarDrawerToggle ties together the the proper interactions
////        // between the sliding drawer and the action bar app icon
////        mDrawerToggle = new ActionBarDrawerToggle(
////                this,                  /* host Activity */
////                mDrawerLayout,         /* DrawerLayout object */
////                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
////                R.string.drawer_open,  /* "open drawer" description for accessibility */
////                R.string.drawer_close  /* "close drawer" description for accessibility */
////        ) {
////            public void onDrawerClosed(View view) {
////                getActionBar().setTitle(mTitle);
////                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
////            }
////
////            public void onDrawerOpened(View drawerView) {
////                getActionBar().setTitle(mDrawerTitle);
////                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
////            }
////        };
////        mDrawerLayout.setDrawerListener(mDrawerToggle);
////        // set a custom shadow that overlays the menu_main_ content when the drawer opens
////        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
////
//////        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
//////        setActionBar(toolbar);
////
////        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.knock_red));
//        // enable ActionBar app icon to behave as action to toggle nav drawer
////        ActionBar actionBar = getActionBar();
////        actionBar.setDisplayHomeAsUpEnabled(true);
////        actionBar.setHomeButtonEnabled(true);
////        actionBar.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.custom_action_bar));
//
////        mTitle = getTitle();
////        mDrawerTitle = "Select Menu";
//
////        startActivity(new Intent(MainActivity.this, TestActivity3.class));
////        finish();
//    }
//
//    private void setupViewPager(ViewPager viewPager) {
//        kViewPagerAdapter adapter = new kViewPagerAdapter(getSupportFragmentManager());
//
//        adapter.addFrag(new HomeFragment(), getResources().getDrawable(R.drawable.page1));
//        adapter.addFrag(new HouseWorkFragment(), getResources().getDrawable(R.drawable.page1));
//        adapter.addFrag(new MoneyFragment(), getResources().getDrawable(R.drawable.page1));
//        viewPager.setAdapter(adapter);
//    }
//
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
//
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//
////        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mLinearLayout);
//        return super.onPrepareOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(MainActivity.this, TestActivity.class));
//            return true;
//        } else if (id == R.id.action_drawer) {
//            startActivity(new Intent(MainActivity.this, DrawerActivity.class));
//            return true;
//        } else if (id == R.id.action_test2) {
//            startActivity(new Intent(MainActivity.this, TestActivity2.class));
//            return true;
//        } else if (id == R.id.action_test3) {
//            startActivity(new Intent(MainActivity.this, TestActivity3.class));
//            return true;
//        } else if (id == R.id.action_preset) {
//            startActivity(new Intent(MainActivity.this, PresetTabActivity.class));
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
////    private class DrawerItemClickListener implements ListView.OnItemClickListener {
////        @Override
////        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////            selectItem(position);
////        }
////    }
//
////    private void selectItem(int position) {
////
////        String tag = "";
////        switch (position) {
////            case 0:
//////                fragment = new ListFriendFragment();
////                break;
////            case 1:
//////                fragment = new MakeFriendFragment();
////                break;
////            case 2:
//////                fragment = new MessageBoxFragment();
////                break;
////            case 3:
//////                fragment = new CareHistoryFragment();
////                break;
////            case 4:
//////                fragment = new SettingFragment();
////                break;
////            default:
////                break;
////        }
////
//////        Bundle args = new Bundle();
//////        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//////        fragment.setArguments(args);
////        tag = fragment.getClass().getSimpleName();
////        FragmentManager fragmentManager = getFragmentManager();
////        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, tag).commit();
////
////        // update selected item and title, then close the drawer
////        mDrawerList.setItemChecked(position, true);
////        setTitle(mPlanetTitles[position]);
////        mDrawerLayout.closeDrawer(mLinearLayout);
////    }
//
////    public ListView getDrawer() {
////        return this.mDrawerList;
////    }
//
////    @Override
////    public void setTitle(CharSequence title) {
////        mTitle = title;
////        getActionBar().setTitle(mTitle);
////    }
//
//    /**
//     * When using the ActionBarDrawerToggle, you must call it during
//     * onPostCreate() and onConfigurationChanged()...
//     */
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        // Sync the toggle state after onRestoreInstanceState has occurred.
////        mDrawerToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        // Pass any configuration change to the drawer toggls
////        mDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
////    public class SectionsPagerAdapter extends FragmentPagerAdapter {
////
////        public SectionsPagerAdapter(FragmentManager fm) {
////            super(fm);
////        }
////
////        @Override
////        public Fragment getItem(int position) {
////            // getItem is called to instantiate the fragment for the given page.
////            // Return a PlaceholderFragment (defined as a static inner class below).
////            Fragment fragment = null;
////            switch (position) {
////                case 0:
//////                    fragment = new HomeFragment();
////                    break;
////                case 1:
//////                    fragment = new HouseWorkFragment();
////                    break;
////                case 2:
//////                    fragment = new MoneyFragment();
////                    break;
////                default:
////                    break;
////            }
////
////            Bundle args = new Bundle();
////
//////            fragment.setArguments(args);
////            return fragment;
////
//////            return PlaceholderFragment.newInstance(position + 1);
////        }
////
////        @Override
////        public int getCount() {
////            // Show 3 total pages.
////            return 3;
////        }
////
////        @Override
////        public CharSequence getPageTitle(int position) {
////            Locale l = Locale.getDefault();
////            switch (position) {
////                case 0:
////                    return getString(R.string.title_section1).toUpperCase(l);
////                case 1:
////                    return getString(R.string.title_section2).toUpperCase(l);
////                case 2:
////                    return getString(R.string.title_section3).toUpperCase(l);
////            }
////            return null;
////        }
////    }
//
//    /**
//     * A placeholder fragment containing a simple view.
//     */
////    public static class PlaceholderFragment extends Fragment {
////        /**
////         * The fragment argument representing the section number for this
////         * fragment.
////         */
////        private static final String ARG_SECTION_NUMBER = "section_number";
////
////        /**
////         * Returns a new instance of this fragment for the given section
////         * number.
////         */
////        public static PlaceholderFragment newInstance(int sectionNumber) {
////            PlaceholderFragment fragment = new PlaceholderFragment();
////            Bundle args = new Bundle();
////            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
////            fragment.setArguments(args);
////            return fragment;
////        }
////
////        public PlaceholderFragment() {
////        }
////
////        @Override
////        public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                                 Bundle savedInstanceState) {
////            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
////            return rootView;
////        }
////    }
//
//}
