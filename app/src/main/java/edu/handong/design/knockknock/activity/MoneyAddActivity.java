package edu.handong.design.knockknock.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.handong.design.knockknock.R;

public class MoneyAddActivity extends ActionBarActivity {
    ArrayList<ImageView> imArr = new ArrayList();
    ImageView by_person;
    ImageView by_share;

    ArrayList<ImageView> spendArr = new ArrayList<ImageView>();
    int[] drawableId = new int[]{
            R.id.m_add_1_id, R.id.m_add_2_id, R.id.m_add_3_id, R.id.m_add_4_id, R.id.m_add_5_id,
    };
    ImageView doneBtn;

    private EditText spendStart;
    private EditText spendEnd;
    private Context context;
    private EditText totalSpendMoney;
    private ArrayList<EditText> splitEts = new ArrayList<>();
    private int[] splitIds = new int[]{ R.id.split_id_1, R.id.split_id_2, R.id.split_id_3, R.id.split_id_4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_add);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tabanim_toolbar);
        toolbar.setTitle("새로운 지출");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.context = this;
        setView();
        setBinding();
    }


    private void setView() {

        by_person = (ImageView) findViewById(R.id.by_person_id);
        by_share = (ImageView) findViewById(R.id.by_share_id);
        doneBtn = (ImageView) findViewById(R.id.m_done_btn);
        spendStart = (EditText) findViewById(R.id.spend_start);
        spendEnd = (EditText) findViewById(R.id.spend_end);
        totalSpendMoney = (EditText) findViewById(R.id.total_spend_money);

        for (int i = 0 ; i < splitIds.length ; i++) {
            splitEts.add((EditText) findViewById(splitIds[i]));
        }

        for (int i = 0 ; i < drawableId.length ; i++) {
            spendArr.add((ImageView) findViewById(drawableId[i]));
        }

    }



    private void setBinding() {

//        for (ImageView iv : imArr) {
//            setClick(iv);
//        }

        setClickDetail(by_person);
        setClickDetail(by_share);
        by_share.setSelected(true);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            }
        });
        
        setDateEditText(spendStart);
        setDateEditText(spendEnd);
        inShareSelected();

        for (ImageView iv : spendArr) {
            setSpendClick(iv);
        }
    }

    private void setSpendClick(final ImageView iv) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ImageView _iv : spendArr) {
                    _iv.setSelected(false);
                }
                iv.setSelected(true);
            }
        });
    }

    private boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private void setClick(final ImageView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ImageView iv : imArr) {
                    iv.setSelected(false);
                }
                view.setSelected(true);
            }
        });
    }

    private void showDateDialog(final EditText et) {
        GregorianCalendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                String msg = String.format("%d. %d. %d", year,monthOfYear+1, dayOfMonth);
//                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                et.setText(msg);
            }
        };
        DatePickerDialog dpd = new DatePickerDialog(context, dateSetListener, year,month, day);
        dpd.show();
    }

    private void setDateEditText(final EditText et) {
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    et.clearFocus();
                    showDateDialog(et);
                }
            }
        });
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setClickDetail(final ImageView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getId() == by_share.getId()) {
                    by_person.setSelected(false);
                    by_share.setSelected(true);
                    inShareSelected();
                } else if (view.getId() == by_person.getId()) {
                    by_share.setSelected(false);
                    by_person.setSelected(true);
                    inPersonSelected();
                }
            }
        });
    }

    private void inShareSelected() {
        for (EditText et : splitEts) {
//            et.setFocusable(false);
        }
        totalSpendMoney.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String number = totalSpendMoney.getText().toString();
                if (!isNumeric(number)) return false;

                double totalMoney = Double.parseDouble(number);
                totalMoney = (totalMoney/4.0);
                for (EditText et : splitEts) {
                    et.setText(String.valueOf(totalMoney));
                }
                return false;
            }
        });
    }

    private void inPersonSelected() {
        for (EditText et : splitEts) {
//            et.setFocusable(true);
            totalSpendMoney.setOnKeyListener(null);
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_house_work_add, menu);
//        return true;
//    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
