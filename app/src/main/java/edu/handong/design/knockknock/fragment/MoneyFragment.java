package edu.handong.design.knockknock.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.CoordinatorLayout;
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
import edu.handong.design.knockknock.adapter.MoneyListAdapter;
import edu.handong.design.knockknock.model.Item;
import edu.handong.design.knockknock.util.Logger;


public class MoneyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView moneyList;
    private List mItemList = new ArrayList<Item>();
    private MoneyListAdapter moneyAdapter;
    private LinearLayoutManager llManager;
    private CoordinatorLayout moneyLayout;

    // TODO: Rename and change types and number of parameters
    public static MoneyFragment newInstance(String param1, String param2) {
        MoneyFragment fragment = new MoneyFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public MoneyFragment() {
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
        View view = inflater.inflate(R.layout.fragment_money, container, false);
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
        moneyAdapter = new MoneyListAdapter(this, mItemList, moneyLayout);

        moneyList.setAdapter(moneyAdapter);

        mItemList.add(new Item(R.drawable.money01));
        mItemList.add(new Item(R.drawable.money02));
        mItemList.add(new Item(R.drawable.money03));
        mItemList.add(new Item(R.drawable.money04));
        moneyAdapter.notifyDataSetChanged();
    }

    private void setBinding() {

    }




}
