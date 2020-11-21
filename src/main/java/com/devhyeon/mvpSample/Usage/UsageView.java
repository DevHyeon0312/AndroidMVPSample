package com.devhyeon.mvpSample.Usage;

import com.devhyeon.mvpSample.Calculator.CalcModel;

/**
 * Created By DevHyeon on 2020.11.21
 * DevHyeon Blog : https://www.devhyeon.com
 * DevHyeon Git  : https://github.com/DevHyeon0312
 * CalcMain Activity
 * */
public interface UsageView {

    void setAdapter(UsageAdapter usageAdapter);

    void updateAdapter(UsageAdapter usageAdapter, CalcModel item);

}