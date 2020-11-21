package com.devhyeon.mvpSample.Usage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.devhyeon.mvpSample.Base.BaseActivity;
import com.devhyeon.mvpSample.R;
import com.devhyeon.mvpSample.databinding.ActivityUsageBinding;

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
    }

    @Override
    protected void setBindingView(@NonNull View view) {
        setContentsView(view, ActivityUsageBinding.bind(view));
    }

}