package edu.handong.design.knockknock.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.util.Logger;

public class ShopAddActivity extends ActionBarActivity {

    private Context context;
    private ImageView selectBtn;
    private TextView selectLabel;
    private ImageView doneBtn;

    private ArrayList<ImageView> shopArr = new ArrayList<>();
    private ArrayList<ImageView> shopArr2 = new ArrayList<>();
    private int[] shopDrawId = new int[] {
            R.id.shop_01_id, R.id.shop_02_id, R.id.shop_03_id,
            R.id.shop_04_id, R.id.shop_05_id, R.id.shop_06_id,
            R.id.shop_07_id, R.id.shop_08_id, R.id.shop_09_id,
            R.id.shop_10_id
    };
    final int Y = 0;
    final int G = 1;
    final int Red = 2;
    final int B = 3;
    private int[] shopDrawType = new int[]{ Y, B, G, G, Y, Red, G, Red, Red, G};
    private int[] shopDraw2Id = new int[] {
            R.id.shop2_01_id, R.id.shop2_02_id, R.id.shop2_03_id,
            R.id.shop2_04_id
    };
    private int[] shopDraw2Type = new int[]{ Y, G, Red, B};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_add);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tab_anim_toolbar);
        toolbar.setTitle("새로운 구매목록 추가");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.context = this;
        setView();
        setBinding();
    }

    private void setView() {
        selectBtn = (ImageView) findViewById(R.id.shop_list_select_btn_id);
        selectLabel = (TextView) findViewById(R.id.select_label_id);
        doneBtn = (ImageView) findViewById(R.id.shop_list_done_btn);

        for (int id : shopDrawId) {
            shopArr.add((ImageView) findViewById(id));
        }

        for (int id : shopDraw2Id) {
            shopArr2.add((ImageView) findViewById(id));
        }


    }
    int selected_index = 0;
    private void setBinding() {
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String items[] = { "자주 사용한 순서", "생필품", "보관식품", "신선식품", "의약품 외 기타"};
                AlertDialog.Builder ab = new AlertDialog.Builder(context);
                ab.setTitle("순서");
                ab.setSingleChoiceItems(items, 0,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // 각 리스트를 선택했을때
                                selected_index = whichButton;
                            }
                        }).setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.
                                selectLabel.setText(items[selected_index]);
                            }
                        }).setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // Cancel 버튼 클릭시
                            }
                        });
                ab.show();
            }
        });

        for (ImageView iv : shopArr) {
            setShopClick(iv, shopArr);
        }

        for (ImageView iv : shopArr2) {
            setShopClick(iv, shopArr2);
        }

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setShopClick(final ImageView iv, final List<ImageView> list) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (ImageView ii : list) {
                    ii.setSelected(false);
                }
                for (ImageView ii : shopArr2) {
                    ii.setSelected(false);
                }

                iv.setSelected(true);

                if (list.equals(shopArr)) {
                    int idx = shopArr.indexOf(iv);
                    int color = shopDrawType[idx];

                    shopArr2.get(color).setSelected(true);
                }

                if (list.equals(shopArr2)) {
                    for (ImageView ii : shopArr) {
                        ii.setSelected(false);
                    }
                }

            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_shop_add, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
