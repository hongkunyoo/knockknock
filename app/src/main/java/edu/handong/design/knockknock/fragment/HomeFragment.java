package edu.handong.design.knockknock.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.view.BlurBuilder;
import edu.handong.design.knockknock.view.SlideInAnimationHandler;


public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView myRoom;

    private ImageButton fab;

    private View fabAction1;
    private View fabAction2;
    private View fabAction3;

    private float offset1;
    private float offset2;
    private float offset3;

    private boolean expanded = false;

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
//        setBinding();
        return view;

    }

    private void setView(View view) {
        myRoom = (ImageView) view.findViewById(R.id.myroom_id);


//        icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                icon.setSelected(true);
//            }
//        });
//        actionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                icon.setSelected(true);
//            }
//        });

//        final ViewGroup fabContainer = (ViewGroup) view.findViewById(R.id.fab_container);
//        fab = (ImageButton) view.findViewById(R.id.fab);
//        fabAction1 = view.findViewById(R.id.fab_action_1);
//        fabAction2 = view.findViewById(R.id.fab_action_2);
//        fabAction3 = view.findViewById(R.id.fab_action_3);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                expanded = !expanded;
//                if (expanded) {
//                    expandFab();
//                } else {
//                    collapseFab();
//                }
//            }
//        });
//        fabContainer.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            @Override
//            public boolean onPreDraw() {
//                fabContainer.getViewTreeObserver().removeOnPreDrawListener(this);
//                offset1 = fab.getY() - fabAction1.getY();
//                fabAction1.setTranslationY(offset1);
//                offset2 = fab.getY() - fabAction2.getY();
//                fabAction2.setTranslationY(offset2);
//                offset3 = fab.getY() - fabAction3.getY();
//                fabAction3.setTranslationY(offset3);
//                return true;
//            }
//        });
//
//        myRoom.setImageResource(R.drawable.myroom_outside);
        myMenu(view);
//        setCustomAnimation();
    }

    private void myMenu(View view) {
        final ImageView icon = new ImageView(getActivity()); // Create an icon
        icon.setImageResource(R.drawable.h_mode2);

        FrameLayout ll = (FrameLayout) view.findViewById(R.id.linear_layout_id);


        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton actionButton = new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(getActivity())
//                .setContentView(icon)
                .setContentView(icon)
                .build();


        ViewGroup parent = (ViewGroup) actionButton.getParent();
//        int index = parent.indexOfChild(actionButton);
        Logger.log(parent, parent.getClass(), parent.getLayoutParams());
        parent.removeView(actionButton);

        ll.addView(actionButton);
//        parent.addView(C, index);

//        icon.setPadding(0,0,0,0);

        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        starParams.setMargins(0,
                0,
                0,
                0);
        actionButton.setLayoutParams(starParams);
        actionButton.setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER, starParams);
        actionButton.setBackgroundResource(R.color.my_transparent);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(getActivity());
        // repeat many times:
        ImageView itemIcon = new ImageView(getActivity());
        itemIcon.setImageResource(R.drawable.h_freemode2);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon).build();
        button1.setLayoutParams(starParams);
        button1.setBackgroundResource(R.color.my_transparent);

        itemIcon = new ImageView(getActivity());
        itemIcon.setImageResource(R.drawable.h_no_dist2);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon).build();
        button2.setLayoutParams(starParams);
        button2.setBackgroundResource(R.color.my_transparent);

        itemIcon = new ImageView(getActivity());
        itemIcon.setImageResource(R.drawable.h_no_room2);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon).build();
        button3.setLayoutParams(starParams);
        button3.setBackgroundResource(R.color.my_transparent);

        itemIcon = new ImageView(getActivity());
        itemIcon.setImageResource(R.drawable.h_outside2);
        SubActionButton button4 = itemBuilder.setContentView(itemIcon).build();
        button4.setLayoutParams(starParams);
        button4.setBackgroundResource(R.color.my_transparent);


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(getActivity())
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .attachTo(actionButton)
                .setStartAngle(210)
                .setEndAngle(330)
                .setRadius(400)
                .build();


//        actionMenu.getActivityContentView().getParent()



//        Bitmap image = BlurBuilder.blur(view);
//        getActivity().getWindow().setBackgroundDrawable(new BitmapDrawable(getActivity().getResources(), image));

//        final Activity activity = getActivity();
//        final View content = activity.findViewById(android.R.id.content).getRootView();
//        if (content.getWidth() > 0) {
//            Bitmap image = BlurBuilder.blur(content);
//            getActivity().getWindow().setBackgroundDrawable(new BitmapDrawable(activity.getResources(), image));
//        } else {
//            content.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                @Override
//                public void onGlobalLayout() {
//                    Bitmap image = BlurBuilder.blur(content);
//                    getActivity().getWindow().setBackgroundDrawable(new BitmapDrawable(activity.getResources(), image));
//                }
//            });
//        }
    }

//    private void setCustomAnimation() {
//        ImageView fabContent = new ImageView(getActivity());
//        fabContent.setImageDrawable(getResources().getDrawable(R.drawable.h_mode_s));
//
//        FloatingActionButton darkButton = new FloatingActionButton.Builder(getActivity())
////                .setTheme(FloatingActionButton.THEME_DARK)
//                .setContentView(fabContent)
//                .setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER)
//                .build();
//
//        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity());
////                .setTheme(SubActionButton.THEME_DARK);
//        ImageView rlIcon1 = new ImageView(getActivity());
//        ImageView rlIcon2 = new ImageView(getActivity());
//        ImageView rlIcon3 = new ImageView(getActivity());
//        ImageView rlIcon4 = new ImageView(getActivity());
//
//        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.h_freemode_s));
//        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.h_no_dist_s));
//        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.h_no_room_s));
//        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.h_outside_s));
//
//        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        starParams.setMargins(0,
//                0,
//                0,
//                50);
////        actionButton.setLayoutParams(starParams);
//
//        SubActionButton sub1 = rLSubBuilder.setContentView(rlIcon1).build();
//        sub1.setLayoutParams(starParams);
//        // Set 4 SubActionButtons
//        FloatingActionMenu centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
//                .setStartAngle(210)
//                .setEndAngle(330)
////                .setAnimationHandler(new SlideInAnimationHandler())
//                .addSubActionView(sub1)
//                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
//                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
//                .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
//                .attachTo(darkButton)
//                .build();
//    }
//
//    private void setBinding() {
//
//    }
//
//
//    private void collapseFab() {
//        fab.setImageResource(R.drawable.h_mode_sel);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(createCollapseAnimator(fabAction1, offset1),
//                createCollapseAnimator(fabAction2, offset2),
//                createCollapseAnimator(fabAction3, offset3));
//        animatorSet.start();
//        animateFab();
//    }
//
//    private void expandFab() {
//        fab.setImageResource(R.drawable.h_mode);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(createExpandAnimator(fabAction1, offset1),
//                createExpandAnimator(fabAction2, offset2),
//                createExpandAnimator(fabAction3, offset3));
//        animatorSet.start();
//        animateFab();
//    }
//
//    private static final String TRANSLATION_Y = "translationY";
//
//    private Animator createCollapseAnimator(View view, float offset) {
//        return ObjectAnimator.ofFloat(view, TRANSLATION_Y, 0, offset)
//                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
//    }
//
//    private Animator createExpandAnimator(View view, float offset) {
//        return ObjectAnimator.ofFloat(view, TRANSLATION_Y, offset, 0)
//                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
//    }
//
//    private void animateFab() {
//        Drawable drawable = fab.getDrawable();
//        if (drawable instanceof Animatable) {
//            ((Animatable) drawable).start();
//        }
//    }

}
