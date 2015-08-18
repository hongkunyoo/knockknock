package edu.handong.design.knockknock.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.handong.design.knockknock.R;

public class HouseWorkAddActivity extends ActionBarActivity {
    ArrayList<ImageView> imArr = new ArrayList();
    ImageView detail_iv1;
    ImageView detail_iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;
    ImageView iv6;
    ImageView iv7;
    ImageView iv8;
    ImageView iv9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_work_add);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tabanim_toolbar);
        toolbar.setTitle("할일 더하기");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setView();
        setBinding();
    }


    private void setView() {
        imArr.add((ImageView) findViewById(R.id.hw_id1));
        imArr.add((ImageView) findViewById(R.id.hw_id2));
        imArr.add((ImageView) findViewById(R.id.hw_id3));
        imArr.add((ImageView) findViewById(R.id.hw_id4));
        imArr.add((ImageView) findViewById(R.id.hw_id5));
        imArr.add((ImageView) findViewById(R.id.hw_id6));
        imArr.add((ImageView) findViewById(R.id.hw_id7));
        imArr.add((ImageView) findViewById(R.id.hw_id8));
        imArr.add((ImageView) findViewById(R.id.hw_id9));

        detail_iv1 = (ImageView) findViewById(R.id.hw_detail_iv1);
        detail_iv2 = (ImageView) findViewById(R.id.hw_detail_iv2);

    }

    private void setBinding() {


//        iv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (iv1.isSelected()) {
//                    iv1.setSelected(false);
//                } else {
//                    iv1.setSelected(true);
//                }
//            }
//        });
//        setClick(iv1);

        for (ImageView iv : imArr) {
            setClick(iv);
        }

        setClickDetail(detail_iv1);
        setClickDetail(detail_iv2);
        detail_iv1.setSelected(true);
    }

    private void setClick(final ImageView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ImageView iv : imArr) {
                    iv.setSelected(false);
                }
                view.setSelected(true);
            }
        });
    }

    private void setClickDetail(final ImageView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getId() == detail_iv1.getId()) {
                    detail_iv2.setSelected(false);
                } else if (view.getId() == detail_iv2.getId()) {
                    detail_iv1.setSelected(false);
                }
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_house_work_add, menu);
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
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
