package edu.handong.design.knockknock.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.handong.design.knockknock.R;

/**
 * Created by hongkunyoo on 15. 8. 17..
 */
public class kViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    private final List<Drawable> mFragmentTitleList = new ArrayList<>();
    private Context context;

    public kViewPagerAdapter(android.support.v4.app.FragmentManager manager) {
        super(manager);
    }
    public void setContext(Context context) {
        this.context = context;
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFrag(android.support.v4.app.Fragment fragment, Drawable bitmap) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(bitmap);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position).toString();

//        SpannableStringBuilder sb = new SpannableStringBuilder(" "); // space added before text for convenience
//        Drawable myDrawable = mFragmentTitleList.get(position);
//        myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
//        ImageSpan span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);
//        sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        return sb;
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);

        ImageView img = (ImageView) v.findViewById(R.id.icon_img);
        img.setImageDrawable(mFragmentTitleList.get(position));
//        img.setImageResource(imageResId[position]);
        return v;
    }


}
