package edu.handong.design.knockknock.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.activity.MainActivity;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.util.ObjectPreferenceUtil;
import edu.handong.design.knockknock.view.CustomImageDialog;


public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView myRoom;
    private ImageButton myState;

    private ImageButton fab;

    private ImageButton profileBtn1;
    private ImageButton profileBtn2;

    private SubActionButton[] subActionButtons = new SubActionButton[4];
    private int[] subButtonImages = new int[] {R.drawable.h_freemode_s, R.drawable.h_no_dist_s,
        R.drawable.h_no_room_s, R.drawable.h_outside_s};
    private int[] roomImages = new int[] {R.drawable.h_room_freemode, R.drawable.h_room_no_dist,
        R.drawable.h_room_no_room, R.drawable.h_room_outside};

    private RelativeLayout homeBg;
    private ImageView dimBg;
    FrameLayout ll;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setView(view);
//        ObjectPreferenceUtil pref = new ObjectPreferenceUtil(getActivity());
//        pref.put("tab", 1);
//        setBinding();
        return view;

    }

    private void setView(View view) {
        myRoom = (ImageView) view.findViewById(R.id.myroom_id);
        myState = (ImageButton) view.findViewById(R.id.my_state);
        homeBg = (RelativeLayout) view.findViewById(R.id.frag_home_bg_id);
        dimBg = (ImageView) view.findViewById(R.id.dim_bg_id);

        profileBtn1 = (ImageButton) view.findViewById(R.id.h_profile_btn1);
        profileBtn2 = (ImageButton) view.findViewById(R.id.h_profile_btn2);

        viewProfile(profileBtn1);
        viewProfile(profileBtn2);

        myMenu(view);
    }

    private void viewProfile(ImageButton bt) {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomImageDialog customDialog = new CustomImageDialog(getActivity());
                customDialog.setImage(R.drawable.h_profile);
                customDialog.show();
            }
        });
    }

    private void myMenu(View view) {
        final ImageView icon = new ImageView(getActivity()); // Create an icon
        icon.setImageResource(R.drawable.h_mode_s);

        ll = (FrameLayout) view.findViewById(R.id.linear_layout_id);

        final com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton actionButton = new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(getActivity())
                .setContentView(icon)
                .build();

        ViewGroup parent = (ViewGroup) actionButton.getParent();
        parent.removeView(actionButton);

        ll.addView(actionButton);


        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        starParams.setMargins(0,
                0,
                0,
                0);
        actionButton.setLayoutParams(starParams);
        actionButton.setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER, starParams);
        actionButton.setBackgroundResource(R.color.my_transparent);



        for (int i = 0 ; i < subButtonImages.length ; i++) {
            SubActionButton.Builder itemBuilder = new SubActionButton.Builder(getActivity());
            // repeat many times:
            ImageView itemIcon = new ImageView(getActivity());
            itemIcon.setImageResource(subButtonImages[i]);
            subActionButtons[i] = itemBuilder.setContentView(itemIcon).build();
            subActionButtons[i].setLayoutParams(starParams);
            subActionButtons[i].setBackgroundResource(R.color.my_transparent);

        }

        final FloatingActionMenu.Builder actionMenuBuilder = new FloatingActionMenu.Builder(getActivity());

        actionMenuBuilder.attachTo(actionButton)
                .setStartAngle(210)
                .setEndAngle(330)
                .setRadius(400);

        for (int i = 0 ; i < subActionButtons.length ; i++) {
            actionMenuBuilder.addSubActionView(subActionButtons[i]);
        }

        final FloatingActionMenu actionMenu = actionMenuBuilder.build();

        actionMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu floatingActionMenu) {

                dimBg.setVisibility(View.VISIBLE);
                dimBg.setZ(90);

                ll.setZ(100);
                ll.bringToFront();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu floatingActionMenu) {
                dimBg.setVisibility(View.GONE);
            }
        });

        for (int i = 0 ; i < roomImages.length ; i++) {
            final int j = i;
            subActionButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            myRoom.setImageResource(roomImages[j]);
            myState.setImageResource(subButtonImages[j]);
            actionMenu.close(true);
                }
            });
        }

    }

}
