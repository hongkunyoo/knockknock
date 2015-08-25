package edu.handong.design.knockknock.activity;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.adapter.ShopListAdapter;
import edu.handong.design.knockknock.adapter.ShopListListAdapter;
import edu.handong.design.knockknock.model.Item;

public class ShopListActivity extends ActionBarActivity {

    private Context context;
    private ShopListListAdapter shopListListAdapter;
    private RecyclerView shopListList;
    private List mItemList = new ArrayList<Item>();
    private ImageView doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tab_anim_toolbar);
        toolbar.setTitle("장보기 리스트");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.context = this;
        setView();
        setBinding();
    }

    private void setView() {

        shopListList = (RecyclerView) findViewById(R.id.shop_list_recycler_view);
        doneBtn = (ImageView) findViewById(R.id.shop_list_done_btn);

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        shopListList.setLayoutManager(llManager);
        shopListList.setItemAnimator(new DefaultItemAnimator());

        mItemList = new ArrayList<Item>();
        shopListListAdapter = new ShopListListAdapter(this, mItemList);


        shopListList.setAdapter(shopListListAdapter);

        mItemList.add(new Item(R.drawable.shop_list_list_item1));
        mItemList.add(new Item(R.drawable.shop_list_list_item2));
        mItemList.add(new Item(R.drawable.shop_list_list_item3));
        shopListListAdapter.notifyDataSetChanged();



    }

    private void setBinding() {
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_shop_list, menu);
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
