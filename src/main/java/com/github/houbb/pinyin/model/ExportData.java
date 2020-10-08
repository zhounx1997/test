package com.github.houbb.pinyin.model;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExportData {
    /**
     * 院系名称
     */
    @ExcelProperty({ "工号" })
    private String pernr;

    /**
     * 院系名称
     */
    @ExcelProperty({ "姓名" })
    private String name;
    /**
     * 院系名称
     */
    @ExcelProperty({ "手机号" })
    private String mobile;
    /**
     * 院系名称
     */
    @ExcelProperty({ "姓名拼音" })
    private String namePy;
    /**
     * 院系名称
     */
    @ExcelProperty({ "时间" })
    private String time;

    public String getPernr() {
        return pernr;
    }

    public void setPernr(String pernr) {
        this.pernr = pernr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNamePy() {
        return namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
