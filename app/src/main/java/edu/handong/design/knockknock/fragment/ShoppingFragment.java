package edu.handong.design.knockknock.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.activity.HouseWorkAddActivity;
import edu.handong.design.knockknock.activity.MoneyAddActivity;
import edu.handong.design.knockknock.activity.ShopAddActivity;
import edu.handong.design.knockknock.activity.ShopListActivity;
import edu.handong.design.knockknock.adapter.MoneyListAdapter;
import edu.handong.design.knockknock.adapter.ShopListAdapter;
import edu.handong.design.knockknock.model.Item;
import edu.handong.design.knockknock.util.Logger;


public class ShoppingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView moneyList;
    private List mItemList = new ArrayList<Item>();
    private ShopListAdapter moneyAdapter;
    private LinearLayoutManager llManager;
    private CoordinatorLayout moneyLayout;

    private FloatingActionButton shopListBtn;
    private FloatingActionButton addBtn;

    // TODO: Rename and change types and number of parameters
    public static ShoppingFragment newInstance(String param1, String param2) {
        ShoppingFragment fragment = new ShoppingFragment();
        return fragment;
    }

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        setView(view);
        setBinding();
        return view;
    }

    private void setView(View view) {
        moneyList = (RecyclerView) view.findViewById(R.id. money_recycler_view);
        moneyLayout = (CoordinatorLayout) view.findViewById(R.id.money_layout);

        llManager = new LinearLayoutManager(getActivity());
        moneyList.setLayoutManager(llManager);
        moneyList.setItemAnimator(new DefaultItemAnimator());

        mItemList = new ArrayList<Item>();
        moneyAdapter = new ShopListAdapter(this, mItemList, moneyLayout);

        moneyList.setAdapter(moneyAdapter);

        mItemList.add(new Item(R.drawable.shop_row_1));
        mItemList.add(new Item(R.drawable.shop_row_2));
        mItemList.add(new Item(R.drawable.shop_row_3));
        mItemList.add(new Item(R.drawable.shop_row_4));
        mItemList.add(new Item(R.drawable.shop_row_5));
        moneyAdapter.notifyDataSetChanged();

        shopListBtn = (FloatingActionButton) view.findViewById(R.id.shop_cart_fab);
        addBtn = (FloatingActionButton) view.findViewById(R.id.shop_plus_fab);
    }

    private void setBinding() {
//        startActivity(new Intent(this.getActivity(), ShopListActivity.class));
        shopListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShopListActivity.class));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShopAddActivity.class));
            }
        });
    }




}
