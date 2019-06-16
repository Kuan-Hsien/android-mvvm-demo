package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter {

    private List<ItemInfoModel> mDataList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
