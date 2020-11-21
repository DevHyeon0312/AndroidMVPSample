package com.devhyeon.mvpSample.Usage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devhyeon.mvpSample.Calculator.CalcModel;

import java.util.ArrayList;

/**
 * Created By DevHyeon on 2020.11.21
 * DevHyeon Blog : https://www.devhyeon.com
 * DevHyeon Git  : https://github.com/DevHyeon0312
 * CalcMain Activity
 * */
class UsageAdapter extends RecyclerView.Adapter<UsageAdapter.UsageViewHolder> {
    ArrayList<CalcModel> mList = new ArrayList<>();

    @NonNull
    @Override
    public UsageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class UsageViewHolder extends RecyclerView.ViewHolder {

        public UsageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

