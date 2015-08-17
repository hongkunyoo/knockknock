package edu.handong.design.knockknock.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import cn.pedant.SweetAlert.SweetAlertDialog;
import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.util.Logger;

/**
 * Created by hongkunyoo on 15. 8. 18..
 */
public class CustomSweetAlertDialog extends SweetAlertDialog {
    public CustomSweetAlertDialog(Context context) {
        super(context);
    }

    public CustomSweetAlertDialog(Context context, int alertType) {
        super(context, alertType);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert_dialog);
        setTitleText("삭제하시겠습니까?");
    }

    public void cancelClick(View view) {
        Logger.log("Cancel");
    }

    public void confirmClick(View view) {
        Logger.log("Confirm");
    }
}
