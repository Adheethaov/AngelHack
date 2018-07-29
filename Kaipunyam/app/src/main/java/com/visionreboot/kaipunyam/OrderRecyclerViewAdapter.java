package com.visionreboot.kaipunyam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The type Category list recycler view adapter.
 */
public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    private List<OrderModel.OrderModelData> orderTrackList = Collections.synchronizedList(new ArrayList<OrderModel.OrderModelData>());

    public OrderRecyclerViewAdapter(List<OrderModel.OrderModelData> trackDataList, Context context) {
        orderTrackList = trackDataList;
        mContext = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_orders, parent, false);
        final VHItem vhItem = new VHItem(v);
//        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
//        int width = displayMetrics.widthPixels;
//        int height = displayMetrics.heightPixels;
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width*2/3, ViewGroup.LayoutParams.WRAP_CONTENT);
//        vhItem.itemView.setLayoutParams(layoutParams);
        vhItem.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int position;
//                if (dashPresent) {
//                    position = vhItem.getAdapterPosition() - 1;
//                } else {
//                    position = vhItem.getAdapterPosition();
//                }
//                if (position < genreDataArrayList.size()) {
//                    encryptedEditorUser.putString(commonClasses.selectedGenreShare, new Gson().toJson(genreDataArrayList.get(position)));
//                    encryptedEditorUser.apply();
//                    Intent mainTag = new Intent(mContext, GenreSongsActivity.class);
//                    mContext.startActivity(mainTag);
//                }
            }
        });
        return vhItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof VHItem) {
            final VHItem VHitem = (VHItem) holder;
            OrderModel.OrderModelData genreData = orderTrackList.get(position);

            RequestOptions requestOptions = new RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.defaultimage)
                    .error(R.drawable.defaultimage);

            if (!((AppCompatActivity) VHitem.itemView.getContext()).isFinishing()) {
                Glide.with(VHitem.itemView.getContext())
                        .load(genreData.photo)
                        .apply(requestOptions)
                        .into(VHitem.mainImage);
            }
            VHitem.name.setText(genreData.food);
            VHitem.user.setText(genreData.userName);
            VHitem.tym.setText("Delivery at " + genreData.time);
            VHitem.quantity.setText(genreData.quantity + " Qty");
        }


    }


    @Override
    public int getItemCount() {
        int size = 0;
        if (orderTrackList != null) {
            size = orderTrackList.size();
        }
        return size;
    }


    public class VHItem extends RecyclerView.ViewHolder {
        public ImageView mainImage;
        public AppCompatTextView name, quantity, tym, user;

        VHItem(View itemView) {
            super(itemView);
            this.mainImage = itemView.findViewById(R.id.mainImage);
            this.quantity = itemView.findViewById(R.id.quantity);
            this.tym = itemView.findViewById(R.id.deliveryTym);
            this.user = itemView.findViewById(R.id.user);
            this.name = itemView.findViewById(R.id.itemName);
        }
    }


}
