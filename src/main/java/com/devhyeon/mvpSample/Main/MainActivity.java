package com.devhyeon.mvpSample.Main;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;

import com.devhyeon.mvpSample.Base.BaseActivity;
import com.devhyeon.mvpSample.R;
import com.devhyeon.mvpSample.databinding.ActivityMainBinding;

/**
 * Created By DevHyeon on 2020.11.21
 * DevHyeon Blog : https://www.devhyeon.com
 * DevHyeon Git  : https://github.com/DevHyeon0312
 * CalcMain Activity
 * */
public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainView {
    private final String TAG = MainActivity.class.getSimpleName();
    private final int TIME_TICK = 1000;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindingView(getView(R.layout.activity_main));

        mPresenter = new MainPresenter(this);
        setOnClick();
        setTimer();
    }

    @Override
    protected void setBindingView(@NonNull View view) {
        setContentsView(view, ActivityMainBinding.bind(view));
    }

    @Override
    public void setInputData(String inputData) {
        xml.tvInputData.setText(inputData);
    }

    @Override
    public void setResultData(String resultData) {
        xml.tvResult.setText(resultData);
    }

    @Override
    public void setTime(String time) {
        xml.tvTime.setText(time);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    private void setOnClick() {
        xml.btnNum0.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num0)));
        xml.btnNum1.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num1)));
        xml.btnNum2.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num2)));
        xml.btnNum3.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num3)));
        xml.btnNum4.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num4)));
        xml.btnNum5.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num5)));
        xml.btnNum6.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num6)));
        xml.btnNum7.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num7)));
        xml.btnNum8.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num8)));
        xml.btnNum9.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.num9)));
        xml.btnPlus.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.plus)));
        xml.btnMinus.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.minus)));
        xml.btnMultiplication.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.multiplication)));
        xml.btnDivision.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.division)));
        xml.btnDelete.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.delete)));
        xml.btnResult.setOnClickListener(v -> mPresenter.onItemClick(mActivity.getString(R.string.result)));
        xml.btnUsage.setOnClickListener(v -> mPresenter.onStartActivity(mActivity));
    }

    private void setTimer() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    runOnUiThread(() -> mPresenter.getTime());
                    try {
                        Thread.sleep(TIME_TICK);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
