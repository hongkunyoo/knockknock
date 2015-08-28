package edu.handong.design.knockknock.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.service.ArduinoClient;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.util.RequestHelper;

public class MenuActivity extends ActionBarActivity {


    Context context;
    private ProgressDialog progressDialog;

    private ImageView lightOff;
    private ImageView lightOn;
    private ImageView doorClose;
    private ImageView doorOpen;

    String openDoorStr;

    String closeDoorStr;

    String lightOnStr;

    String lightOffStr;
//    String lightOffStr = "http://google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tab_anim_toolbar);
        toolbar.setTitle("KnockKnock");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        try {
            openDoorStr = "http://us01.proxy.teleduino.org/api/1.0/2560.php?" + URLEncoder.encode("k={0D1416B67EC02539F99B96963AD408E4}&r=setServo&servo=0&position=10", "utf-8");
            closeDoorStr= "http://us01.proxy.teleduino.org/api/1.0/2560.php?" + URLEncoder.encode("k={0D1416B67EC02539F99B96963AD408E4}&r=setServo&servo=0&position=175", "utf-8");
            lightOnStr  = "http://us01.proxy.teleduino.org/api/1.0/2560.php?" + URLEncoder.encode("k={0D1416B67EC02539F99B96963AD408E4}&r=setDigitalOutput&pin=3&output=1", "utf-8");
            lightOffStr = "http://us01.proxy.teleduino.org/api/1.0/2560.php?" + URLEncoder.encode("k={0D1416B67EC02539F99B96963AD408E4}&r=setDigitalOutput&pin=3&output=0", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        setView();
        setBinding();
    }

    private void setBinding() {
//        showProgressDialog(this);
        lightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightOff.setSelected(true);
                lightOn.setSelected(false);
                requestUrl(lightOffStr);
            }
        });

        lightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightOff.setSelected(false);
                lightOn.setSelected(true);
                requestUrl(lightOnStr);
            }
        });

        doorOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doorOpen.setSelected(true);
                doorClose.setSelected(false);
                requestUrl(openDoorStr);
            }
        });

        doorClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doorOpen.setSelected(false);
                doorClose.setSelected(true);
                requestUrl(closeDoorStr);
            }
        });


    }

    private void requestUrl(String _url) {
        showProgressDialog();
        RequestHelper.request(_url, new RequestHelper.Callback() {
            @Override
            public void onCompleted(String entity) {
                Toast.makeText(context, entity, Toast.LENGTH_SHORT).show();
                dismissProgressDialog();
            }
        });
    }

    private void setView() {
        lightOff = (ImageView) findViewById(R.id.light_off_id);
        lightOn = (ImageView) findViewById(R.id.light_on_id);
        doorClose = (ImageView) findViewById(R.id.door_close_id);
        doorOpen = (ImageView) findViewById(R.id.door_open_id);

        doorClose.setSelected(true);
        lightOff.setSelected(true);

    }

    public void showProgressDialog(){
        this.showProgressDialog(context);
    }

    public void showProgressDialog(Context context){
//        if(progressDialog == null){
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(R.style.CustomAlertDialogStyle);
            progressDialog.show();
            progressDialog.setContentView(R.layout.custom_progress_dialog);

//        }
    }

    public void dismissProgressDialog(){
        if(progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
//
//    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menu_done) {
            finish();
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        // do something here and don't write super.onBackPressed()
        finish();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }


}
