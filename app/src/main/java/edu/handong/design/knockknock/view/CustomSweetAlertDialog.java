package edu.handong.design.knockknock.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import cn.pedant.SweetAlert.OptAnimationLoader;
import cn.pedant.SweetAlert.SweetAlertDialog;
import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.util.Logger;

/**
 * Created by hongkunyoo on 15. 8. 18..
 */
public class CustomSweetAlertDialog extends SweetAlertDialog {

    private View mDialogView;
    private AnimationSet mModalOutAnim;
    private int myAlertType;
    private ImageView customImage;
    private int resId;

    public CustomSweetAlertDialog(Context context) {
        super(context);
    }

    public CustomSweetAlertDialog(Context context, int alertType) {
        super(context, alertType);
        this.myAlertType = alertType;
        changeAlertType(myAlertType);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert_dialog);

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.custom_moal_out);
//        customImage = (ImageView) findViewById(R.id.my_custom_image);
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
                        CustomSweetAlertDialog.super.dismiss();
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

//        customImage.setVisibility(View.VISIBLE);
//        customImage.setImageResource(resId);


    }

    public void setMyTitleText(String str) {
        setTitleText(str);
    }
//    public void setMyCustomImage(int resId) {
//        this.resId = resId;
////        setCustomImage(resId);
//
//    }

    public void cancelClick(View view) {
        Logger.log("Cancel");
    }

    public void confirmClick(View view) {
        Logger.log("Confirm");
    }

    @Override
    public void cancel() {
        Logger.log("click cancel");
        mDialogView.startAnimation(mModalOutAnim);
//        dismiss();
    }
}
