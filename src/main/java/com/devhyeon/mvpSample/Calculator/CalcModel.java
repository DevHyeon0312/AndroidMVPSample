package com.devhyeon.mvpSample.Calculator;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created By DevHyeon on 2020.11.21
 * DevHyeon Blog : https://www.devhyeon.com
 * DevHyeon Git  : https://github.com/DevHyeon0312
 * Calc Model
 * */
@Data
public class CalcModel {
    private String inputData = "";               //input  data
    private String outputData = "";              //result data
    private ArrayList<result> resultUsage = new ArrayList<>();  //result data usage

    public void addUsage(String expr, String result) {
        resultUsage.add(new result(expr,result));
    }

    static class result {
        String expr;
        String result;
        result(String expr, String result) {
            this.expr = expr;
            this.result = result;
        }
    }
}