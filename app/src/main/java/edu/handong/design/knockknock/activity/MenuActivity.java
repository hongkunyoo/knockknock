package edu.handong.design.knockknock.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.util.Logger;

public class MenuActivity extends ActionBarActivity {

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tab_anim_toolbar);
        toolbar.setTitle("KnockKnock");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setView();
        setBinding();
    }

    private void setBinding() {
//        showProgressDialog(this);
    }

    private void setView() {


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
