package edu.handong.design.knockknock.view;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import cn.pedant.SweetAlert.OptAnimationLoader;
import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.util.Logger;

/**
 * Created by hongkunyoo on 15. 8. 21..
 */
public class CustomImageDialog extends Dialog {

    private View mDialogView;
    private AnimationSet mModalOutAnim;
    private int myAlertType;
    private ImageView customImage;
    private int resId;
    private LinearLayout ll;
    private int height;
    private ImageButton cancelBtn;

    private ArrayList<Integer> taskImages = new ArrayList<Integer>(){{
        add(R.drawable.task_info_01);
        add(R.drawable.task_info_02);
        add(R.drawable.task_info_03);
        add(R.drawable.task_info_04);
        add(R.drawable.task_info_05);
        add(R.drawable.task_info_06);
        add(R.drawable.task_info_07);
        add(R.drawable.task_info_08);
    }
    };
    public CustomImageDialog(Context context) {
        super(context);

//        getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.MATCH_PARENT;
//        params.width = 100;
//        params.height = 100;
//        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);


    }

    public CustomImageDialog(Context context, int theme) {
        super(context, theme);
    }

    protected CustomImageDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (resId == R.drawable.h_profile_dohyung || resId == R.drawable.h_profile_seojun
            || resId == R.drawable.h_profile_taewan) {

            setContentView(R.layout.custom_image_dialog1);
        } else if (taskImages.contains(resId)) {
            setContentView(R.layout.custom_image_dialog3);
        } else if (resId == R.drawable.money_display) {
            setContentView(R.layout.custom_image_dialog);
        } else {
            setContentView(R.layout.custom_image_dialog2);
        }


        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.custom_moal_out);

//        ll = (LinearLayout) findViewById(R.id.custom_image_linear_layout_id);

        customImage = (ImageView) findViewById(R.id.my_custom_image);
        cancelBtn = (ImageButton) findViewById(R.id.cancel_button_one);

        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        CustomImageDialog.super.dismiss();
//                        if (mCloseFromCancel) {
//                            CustomSweetAlertDialog.super.cancel();
//                        } else {
//                            CustomSweetAlertDialog.super.dismiss();
//                        }
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        customImage.setImageResource(resId);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public int dp2pix(int dp) {
        Resources r = getContext().getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return (int)px;
    }

    public void setImage(int resId) {
        this.resId = resId;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
