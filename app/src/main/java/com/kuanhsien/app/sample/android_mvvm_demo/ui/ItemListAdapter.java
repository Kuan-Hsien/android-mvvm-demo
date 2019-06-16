package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import java.util.ArrayList;
import java.util.List;


public class ItemListAdapter extends RecyclerView.Adapter {

    interface OnItemClickListener {
        public void onItemClick(ItemInfoModel data);
    }

    private OnItemClickListener mListener;
    private List<ItemInfoModel> mDataList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_viewholder, parent, false);
        return new MainItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MainItemViewHolder) {
            ((MainItemViewHolder) holder).bind(mDataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // set dataList
    public void setData(List<ItemInfoModel> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }


    // View holder
    public class MainItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextviewTitle;

        public MainItemViewHolder(@NonNull View itemView) {
            super(itemView);

            // get view component
            mTextviewTitle = itemView.findViewById(R.id.tv_item_list_title);
        }

        public void bind(final ItemInfoModel data) {
            mTextviewTitle.setText(data.getTitle());

            mTextviewTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(data);
                }
            });
        }

    }


}
