package edu.handong.design.knockknock.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import edu.handong.design.knockknock.R;
import edu.handong.design.knockknock.model.Item;
import edu.handong.design.knockknock.util.Logger;
import edu.handong.design.knockknock.view.CustomImageDialog;
import edu.handong.design.knockknock.view.CustomImageDialog2;
import edu.handong.design.knockknock.view.CustomSweetAlertDialog;

public class MoneyListAdapter extends RecyclerView.Adapter<MoneyListAdapter.ViewHolder> {

    private List<Item> mItemList;

    static private Context context;
    private Fragment fragment;
    private CoordinatorLayout ll;



    public MoneyListAdapter(Fragment fragment, List<Item> list, CoordinatorLayout ll) {
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
        public ImageView completeBtn;
        public SwipeLayout swipeLayout;


//        public DynamicHeightImageView itemImage;
//        public TextView imageNumber;
//        public View unfold;
//
//        public TextView content;
//        public TextView likeNumber;
//        public TextView replyNumber;
//        public ImageButton likeButton;
//        public Button productTag;
//
//        public View profileLayout;
//        public CircleImageView profileImage;
//        public TextView nickName;

        public ViewHolder(View view) {
            super(view);
            this.view = view;

            this.itemImage = (ImageView)view.findViewById(R.id.money_image);
            this.completeBtn = (ImageView)view.findViewById(R.id.m_complete_btn);

            this.swipeLayout = (SwipeLayout) view.findViewById(R.id.swipe_layout);

//            view.setOnClickListener(this);
//            this.imageNumber = (TextView)view.findViewById(R.id.row_home_item_image_number);
//            this.unfold = view.findViewById(R.id.row_home_item_unfold);
//
//            this.content = (TextView)view.findViewById(R.id.row_home_item_content);
//            this.likeNumber = (TextView)view.findViewById(R.id.row_home_item_like_number);
//            this.replyNumber = (TextView)view.findViewById(R.id.row_home_item_reply_number);
//            this.likeButton = (ImageButton)view.findViewById(R.id.row_home_item_like_button);
//            this.productTag = (Button)view.findViewById(R.id.row_home_item_product_tag);
//
//            this.profileLayout = view.findViewById(R.id.row_home_item_profile_layout);
//            this.profileImage = (CircleImageView)view.findViewById(R.id.row_home_item_profile_image);
//            this.nickName = (TextView)view.findViewById(R.id.row_home_item_nick_name);
        }

//        @Override
//        public void onClick(View v) {
//            Logger.log("view: onClick");
//        }
    }


    @Override
    public MoneyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_money_list, parent, false);
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

        holder.itemImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CustomImageDialog dial = new CustomImageDialog(context);
                dial.setImage(R.drawable.money_display);
                dial.show();
                return false;
            }
        });

    }




    private void setButton(final ViewHolder holder, final Item item){
        holder.completeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final int index = mItemList.indexOf(item);
                removeAt(index);
                Snackbar.make(ll, "지출 완료", Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                add(index, item);
                            }
                        })
                        .show();
            }
        });

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
