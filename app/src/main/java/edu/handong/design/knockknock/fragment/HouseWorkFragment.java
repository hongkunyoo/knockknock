package edu.handong.design.knockknock.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.todddavies.components.progressbar.ProgressWheel;

import cn.pedant.SweetAlert.SweetAlertDialog;
import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.activity.HouseWorkAddActivity;
import edu.handong.design.knockknock.activity.MainActivity;
import edu.handong.design.knockknock.activity.TestActivity;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.view.CustomSweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link HouseWorkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HouseWorkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FloatingActionButton fab;
    private ImageButton addBtn;
    public static HouseWorkFragment newInstance(String param1, String param2) {
        HouseWorkFragment fragment = new HouseWorkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HouseWorkFragment() {
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
        View view = inflater.inflate(R.layout.fragment_house_work, container, false);

        setView(view);
        setBinding();
        return view;
    }

    private void setView(View view) {
        fab = (FloatingActionButton)view.findViewById(R.id.house_work_fab);
//        addBtn = (ImageButton) view.findViewById(R.id.house_work_fab);
//        ProgressWheel pw = (ProgressWheel)view.findViewById(R.id.icon1_wob_id);

//        pw.setProgress(60);
//
//        CustomSweetAlertDialog pDialog = new CustomSweetAlertDialog(this.getActivity(), SweetAlertDialog.NORMAL_TYPE);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading");
//        pDialog.setTitleText("Are you sure?")
//                .setContentText("Won't be able to recover this file!")
//                .setCancelText("No,cancel plx!")
//                .setConfirmText("Yes,delete it!");
//
//        pDialog.setCancelable(true);
//        pDialog.show();
    }

    private void setBinding() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), HouseWorkAddActivity.class));
                getActivity().overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            }
        });
        if (flag) {
//            startActivity(new Intent(getActivity(), HouseWorkAddActivity.class));
            flag =false;
        }

    }
    private boolean flag = true;
}
