package edu.handong.design.knockknock.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.OnWheelChangedListener;
import antistatic.spinnerwheel.OnWheelScrollListener;
import antistatic.spinnerwheel.adapters.AbstractWheelTextAdapter;
import antistatic.spinnerwheel.adapters.ArrayWheelAdapter;
import edu.handong.design.knockknock.R;

public class TestActivity extends Activity {

    AbstractWheel city = null;
    private boolean scrolling = false;

    private int mActiveCities[] = new int[] {
            1, 1, 1, 1
    };

    private int mActiveCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        city = (AbstractWheel)findViewById(R.id.vertical_wheel);
        city.setVisibleItems(4);
        city.setViewAdapter(new CountryAdapter(this));

        city.addChangingListener(new OnWheelChangedListener() {
            public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
                if (!scrolling) {
                    updateCities(city, null, newValue);
                }
            }
        });

        city.addScrollingListener( new OnWheelScrollListener() {
            public void onScrollingStarted(AbstractWheel wheel) {
                scrolling = true;
            }
            public void onScrollingFinished(AbstractWheel wheel) {
                scrolling = false;
//                updateCities(city, cities, country.getCurrentItem());
            }
        });

        city.setCurrentItem(1);
    }

    private void updateCities(AbstractWheel city, String cities[][], int index) {
//        mActiveCountry = index;
//        ArrayWheelAdapter<String> adapter =
//                new ArrayWheelAdapter<String>(this, cities[index]);
//        adapter.setTextSize(18);
//        city.setViewAdapter(adapter);
//        city.setCurrentItem(mActiveCities[index]);
    }
    private class CountryAdapter extends AbstractWheelTextAdapter {
        // Countries names
        private String countries[] =
                new String[] {"USA", "Canada", "Ukraine", "France", "Korea", "Japan", "China", "Thailand", "England", "Malawi"};
        // Countries flags
//        private int flags[] =
//                new int[] {R.drawable.usa, R.drawable.canada, R.drawable.ukraine, R.drawable.france};

        /**
         * Constructor
         */
        protected CountryAdapter(Context context) {
            super(context, R.layout.country_item, NO_RESOURCE);

            setItemTextResource(R.id.country_name);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
//            ImageView img = (ImageView) view.findViewById(R.id.flag);
//            img.setImageResource(flags[index]);
            return view;
        }

        @Override
        public int getItemsCount() {
            return countries.length;
        }

        @Override
        protected CharSequence getItemText(int index) {
            return countries[index];
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
