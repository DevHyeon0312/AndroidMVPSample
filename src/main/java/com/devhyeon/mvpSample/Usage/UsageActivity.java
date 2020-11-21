package com.devhyeon.mvpSample.Usage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devhyeon.mvpSample.Base.BaseActivity;
import com.devhyeon.mvpSample.Calculator.CalcModel;
import com.devhyeon.mvpSample.R;
import com.devhyeon.mvpSample.databinding.ActivityUsageBinding;

import java.util.ArrayList;

/**
 * Created By DevHyeon on 2020.11.21
 * DevHyeon Blog : https://www.devhyeon.com
 * DevHyeon Git  : https://github.com/DevHyeon0312
 * CalcUsage View
 * */
public class UsageActivity extends BaseActivity<ActivityUsageBinding> implements UsageView {
    private final String TAG = UsageActivity.class.getSimpleName();

    private UsagePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindingView(getView(R.layout.activity_usage));

        mPresenter = new UsagePresenter(this);
        mPresenter.setModel(mActivity);
        mPresenter.setAdapter();
        mPresenter.updateAdapter();
    }

    @Override
    protected void setBindingView(@NonNull View view) {
        setContentsView(view, ActivityUsageBinding.bind(view));
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setAdapter(UsageAdapter usageAdapter) {
        xml.rvUsage.setLayoutManager(new LinearLayoutManager(this));
        xml.rvUsage.setAdapter(usageAdapter);
    }

    @Override
    public void updateAdapter(UsageAdapter usageAdapter, CalcModel calcModel) {
        usageAdapter.addItem(calcModel.getCalcResultList().getResultUsage());
        usageAdapter.notifyDataSetChanged();
    }
}