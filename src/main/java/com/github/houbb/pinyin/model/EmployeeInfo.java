package com.github.houbb.pinyin.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class EmployeeInfo extends BaseRowModel {

    /**
     * 第一列的数据
     */
    @ExcelProperty(index = 0)
    private String id;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 1)
    private String info;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 2)
    private String data1;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 3)
    private String date;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 4)
    private String data2;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 5)
    private String state;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 6)
    private String data3;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 7)
    private String data4;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 8)
    private String data5;
    /**
     * 第二列的数据
     */
    @ExcelProperty(index = 9)
    private String data6;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }
}
