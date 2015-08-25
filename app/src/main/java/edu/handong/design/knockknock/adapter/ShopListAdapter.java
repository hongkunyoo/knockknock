package edu.handong.design.knockknock.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.activity.HouseWorkAddActivity;
import edu.handong.design.knockknock.activity.ShopListActivity;
import edu.handong.design.knockknock.model.Item;
import edu.handong.design.knockknock.view.CustomImageDialog;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ViewHolder> {

    private List<Item> mItemList;

    static private Context context;
    private Fragment fragment;
    private CoordinatorLayout ll;



    public ShopListAdapter(Fragment fragment, List<Item> list, CoordinatorLayout ll) {
        this.fragment = fragment;
        this.context = fragment.getActivity();
        this.mItemList = list;
        this.ll = ll;

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

            this.itemImage = (ImageView) view.findViewById(R.id.money_image);
            this.okBtn = (ImageView) view.findViewById(R.id.shop_ok_btn);
            this.noBtn = (ImageView) view.findViewById(R.id.shop_not_btn);

            this.swipeLayout = (SwipeLayout) view.findViewById(R.id.swipe_layout);

//            swipeLayout.addDrag(SwipeLayout.DragEdge.Left, view.findViewById(R.id.bottom_wrapper));

        }
    }


    @Override
    public ShopListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shop_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Item item = mItemList.get(position);
        setComponent(holder, item);
        setButton(holder, item);
//        setImageView(holder, item);
    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }


    private void setComponent(ViewHolder holder, Item item){
        holder.itemImage.setImageResource(item.getResourceId());

//        holder.itemImage.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                CustomImageDialog dial = new CustomImageDialog(context);
//                dial.setImage(R.drawable.money_display);
//                dial.show();
//                return false;
//            }
//        });

    }


    private void setBottomButton(final ImageView btn, final Item item) {

        if (btn.getId() == R.id.shop_ok_btn) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, ShopListActivity.class));
                }
            });

            return;
        }

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final int index = mItemList.indexOf(item);
                removeAt(index);
                Snackbar.make(ll, "Confirmed", Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                add(index, item);
                            }
                        })
                        .show();
            }
        });
    }

    private void setButton(final ViewHolder holder, final Item item){

        setBottomButton(holder.okBtn, item);
        setBottomButton(holder.noBtn, item);
//        holder.swipeLayout.

        holder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView.
//                Toast.makeText(context, "onClose", Toast.LENGTH_SHORT).show();
                notTouch = false;
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                //you are swiping.
//                Toast.makeText(context, "onUpdate", Toast.LENGTH_SHORT).show();
                notTouch = true;
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {
//                Toast.makeText(context, "onStartOpen", Toast.LENGTH_SHORT).show();
                notTouch = true;
            }

            @Override
            public void onOpen(SwipeLayout layout) {
                //when the BottomView totally show.
//                Toast.makeText(context, "onOpen", Toast.LENGTH_SHORT).show();
                notTouch = true;
            }

            @Override
            public void onStartClose(SwipeLayout layout) {
//                Toast.makeText(context, "onStartClose", Toast.LENGTH_SHORT).show();
                notTouch = true;
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hand released.
//                Toast.makeText(context, "onHandRelease", Toast.LENGTH_SHORT).show();
//                if (!notTouch) {
//                    CustomImageDialog dial = new CustomImageDialog(context);
//                    dial.setImage(R.drawable.money_display);
//                    dial.show();
//                }
                notTouch = false;
            }
        });

//        CustomImageDialog2 dial = new CustomImageDialog2(context);
//        dial.setImage(R.drawable.h_profile);
//        dial.show();
    }
    private boolean notTouch = false;

    public void addAll(List<Item> itemList) {
        mItemList.addAll(itemList);
        notifyDataSetChanged();
    }


    public void add(int position, Item item) {
        mItemList.add(position, item);
        notifyItemInserted(position);
    }
}
