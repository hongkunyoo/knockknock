package edu.handong.design.knockknock.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.activity.ShopListActivity;
import edu.handong.design.knockknock.model.Item;

public class ShopListListAdapter extends RecyclerView.Adapter<ShopListListAdapter.ViewHolder> {

    private List<Item> mItemList;

    static private Context context;

    public ShopListListAdapter(Activity activity, List<Item> list) {
        this.context = activity;
        this.mItemList = list;

    }

    public void removeAt(Item item) {
        int index = mItemList.indexOf(item);
        removeAt(index);
    }

    public void removeAt(int position) {
        mItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mItemList.size());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View view;

        public ImageView itemImage;
        public ImageView okBtn;
        public ImageView noBtn;
        public SwipeLayout swipeLayout;


        public ViewHolder(View view) {
            super(view);
            this.view = view;

            this.itemImage = (ImageView) view.findViewById(R.id.shop_list_list_id);
        }
    }


    @Override
    public ShopListListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shop_list_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Item item = mItemList.get(position);
        setComponent(holder, item);
    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }


    private void setComponent(ViewHolder holder, Item item){
        holder.itemImage.setImageResource(item.getResourceId());
    }


}
