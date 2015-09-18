package edu.handong.design.knockknock.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.todddavies.components.progressbar.ProgressWheel;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.activity.HouseWorkAddActivity;
import edu.handong.design.knockknock.activity.MainActivity;
import edu.handong.design.knockknock.activity.TestActivity;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.util.ObjectPreferenceUtil;
import edu.handong.design.knockknock.util.RandomUtil;
import edu.handong.design.knockknock.view.CustomImageDialog;
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
    private CoordinatorLayout corLayout;

    private ArrayList<ProgressWheel> progressImageArr = new ArrayList<>();
    private int[] icons = new int[]{
            R.id.icon_wob_id1, R.id.icon_wob_id2, R.id.icon_wob_id3, R.id.icon_wob_id4,
            R.id.icon_wob_id5, R.id.icon_wob_id6, R.id.icon_wob_id7,
            R.id.icon_wob_id8
    };

    private int[] taskImages = new int[]{
            R.drawable.task_info_01, R.drawable.task_info_02, R.drawable.task_info_03,
            R.drawable.task_info_04, R.drawable.task_info_05, R.drawable.task_info_06,
            R.drawable.task_info_07, R.drawable.task_info_08,
    };


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

        for (int i = 0 ; i < icons.length ; i++) {
            progressImageArr.add((ProgressWheel)view.findViewById(icons[i]));
        }
        corLayout = (CoordinatorLayout) view.findViewById(R.id.hw_cor_layout);
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
//        startActivity(new Intent(getActivity(), HouseWorkAddActivity.class));

        for (ProgressWheel progImg : progressImageArr) {
            progImg.setCase(getRand());
            setProButton(progImg, progressImageArr.indexOf(progImg));
        }
    }

    private void setProButton(final ProgressWheel pw, final int index) {
        pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pw.getCase() == ProgressWheel.CASE0) return;
                final int prevCase = pw.getCase();
                pw.clearAnimSize();
                Snackbar.make(corLayout, "Completed!", Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pw.diminishing = false;
                                pw.setCase(prevCase);
                            }
                        })
                        .show();
            }
        });

        pw.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                CustomSweetAlertDialog sweetDialog = new CustomSweetAlertDialog(getActivity());
//                sweetDialog.setImage(taskImages[index]);
//                sweetDialog.show();
                CustomImageDialog customDialog = new CustomImageDialog(getActivity());
                customDialog.setImage(taskImages[index]);
                customDialog.show();
                return false;
            }
        });
    }

    private int getRand() {
        return RandomUtil.getInt(6);
    }

}
