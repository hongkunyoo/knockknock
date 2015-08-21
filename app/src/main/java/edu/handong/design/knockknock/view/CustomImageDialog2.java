package edu.handong.design.knockknock.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.pedant.SweetAlert.OptAnimationLoader;
import edu.handong.design.knockknock.R;

/**
 * Created by hongkunyoo on 15. 8. 21..
 */
public class CustomImageDialog2 extends Dialog {

    private View mDialogView;
    private AnimationSet mModalOutAnim;
    private int myAlertType;
    private ImageView customImage;
    private int resId;
    private LinearLayout ll;
    private int height;
    private ImageButton cancelBtn;

    public CustomImageDialog2(Context context) {
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

    public CustomImageDialog2(Context context, int theme) {
        super(context, theme);
    }

    protected CustomImageDialog2(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_image_dialog2);

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
                        CustomImageDialog2.super.dismiss();
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
//        customImage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height));
//        ViewGroup.LayoutParams par = customImage.getLayoutParams();
//        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getContext(), getContext().getResources().getDisplayMetrics());

//        customImage.getLayoutParams().height = dp2pix(height);
//        LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams)cancelBtn.getLayoutParams();
//        Logger.log(dp2pix(height), dp2pix(height-100));
//        LinearLayout btnParent = (LinearLayout)cancelBtn.getParent();
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        Logger.log(ll, ll.topMargin, btnParent, btnParent.getLayoutParams());
//        ll.setMargins(0, dp2pix(height-20), 0, 0);
//        cancelBtn.setLayoutParams(lp);

//        Logger.log(cancelBtn.getLayoutParams().height);
//        Logger.log("[[[",ll, ll.getLayoutParams(), ll.getLayoutParams().getClass(), "]");
//        LinearLayout.LayoutParams lll = (LinearLayout.LayoutParams)ll.getLayoutParams();
//        lll.setMargins(0, height-20, 0, 0);
//        ll.setLayoutParams(lll);

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
