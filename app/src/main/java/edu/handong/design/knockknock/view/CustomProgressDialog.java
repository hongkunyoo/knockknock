package edu.handong.design.knockknock.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import edu.handong.design.knockknock.R;

/**
 * Created by hongkunyoo on 15. 8. 31..
 */
public class CustomProgressDialog extends ProgressDialog {
    public CustomProgressDialog(Context context) {
        super(context);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setCancelable(false);

//        this.setProgressStyle();
//        this.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_progress_dialog);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }
}