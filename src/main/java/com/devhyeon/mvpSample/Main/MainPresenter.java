package com.devhyeon.mvpSample.Main;

import android.app.Activity;
import android.content.Intent;

import com.devhyeon.mvpSample.Calculator.Calc;
import com.devhyeon.mvpSample.Calculator.CalcModel;
import com.devhyeon.mvpSample.Usage.UsageActivity;

import java.util.Calendar;

/**
 * Created By DevHyeon on 2020.11.21
 * DevHyeon Blog : https://www.devhyeon.com
 * DevHyeon Git  : https://github.com/DevHyeon0312
 * CalcMain Presenter
 * */
class MainPresenter {
    private final String TAG = MainPresenter.class.getSimpleName();

    private MainView mainView;
    private CalcModel calcModel;
    private MainModel mainModel;

    MainPresenter(MainView mainView) {
        this.mainView  = mainView;
        this.calcModel = new CalcModel();
        this.mainModel = new MainModel();
    }

    void onItemClick(String item) {
        if (mainView != null) {
            CalcLogic(item);
            mainView.setInputData(calcModel.getInputData());
            mainView.setResultData(calcModel.getOutputData());
        }
    }

    void onStartActivity(Activity activity) {
        activity.startActivity(new Intent(activity, UsageActivity.class));
    }

    void getTime() {
        TimeLogic();
    }

    private void CalcLogic(String item) {
        if ("←".equals(item)) {
            if (calcModel.getInputData().length() > 0) {
                calcModel.setInputData(calcModel.getInputData().substring(0, calcModel.getInputData().length()-1));
            }
            try {
                calcModel.setOutputData(new Calc().processStr(calcModel.getInputData()));
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("=".equals(item)) {
            try {
                calcModel.setOutputData(new Calc().processStr(calcModel.getInputData()));
                calcModel.addUsage(calcModel.getInputData(), calcModel.getOutputData());
                calcModel.setInputData("");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if ("0".equals(calcModel.getInputData())) {
                calcModel.setInputData(item);
            } else {
                calcModel.setInputData(calcModel.getInputData() + item);
            }
            try {
                calcModel.setOutputData(new Calc().processStr(calcModel.getInputData()));
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void TimeLogic() {
        Calendar calendar = Calendar.getInstance(); // 칼렌다 변수
        int year = calendar.get(Calendar.YEAR); // 년
        int month = calendar.get(Calendar.MONTH); // 월
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 일
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // 시
        int minute = calendar.get(Calendar.MINUTE); // 분
        int second = calendar.get(Calendar.SECOND); // 초
        mainModel.setNowTime(year + "년 " +
                month + "월 " + day + "일 " +
                hour + "시 " + minute + "분 " +
                second + "초"
        );
        mainView.setTime(mainModel.getNowTime());
    }

    void onDestroy() {
        mainView = null;
    }
}
