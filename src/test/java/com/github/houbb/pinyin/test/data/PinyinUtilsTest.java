package com.github.houbb.pinyin.test.data;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONObject;
import com.github.houbb.pinyin.model.EmployeeInfo;
import com.github.houbb.pinyin.model.ExportData;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class PinyinUtilsTest {

    @Test
    public void charTest() throws Exception {
        Sheet sheet = new Sheet(1, 1, EmployeeInfo.class);
        List<Object> list = EasyExcelFactory.read(getInputStream("F:\\test.xlsx"), sheet);

        List<EmployeeInfo> infos = new ArrayList<>();
        for (Object o : list) {
            infos.add((EmployeeInfo) o);
        }

        List<ExportData> idList = new ArrayList<>();
        for (EmployeeInfo employeeInfo : infos) {
            String ename = JSONObject.parseObject(employeeInfo.getInfo()).getString("ENAME");
            String zzadno = JSONObject.parseObject(employeeInfo.getInfo()).getString("ZZADNO");
            boolean result = this.nameIsEqualPinYin(ename, zzadno, "");
            if (!result) {
                ExportData data = new ExportData();
                data.setPernr(JSONObject.parseObject(employeeInfo.getInfo()).getString("PERNR"));
                data.setName(JSONObject.parseObject(employeeInfo.getInfo()).getString("ENAME"));
                data.setNamePy(JSONObject.parseObject(employeeInfo.getInfo()).getString("ZZADNO"));
                data.setMobile(JSONObject.parseObject(employeeInfo.getInfo()).getString("ZZMOBILE"));
                data.setTime(employeeInfo.getDate());
                idList.add(data);
            }
        }
        String fileName = "不匹配人员id" + UUID.randomUUID().toString() + ".xls";
        File file = new File("e:/excel", fileName);

        ExcelWriter excelWriter = EasyExcel.write(file).build();
        // 导出
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "不匹配人员id")
                .head(ExportData.class).build();

        excelWriter.write(idList,
                writeSheet);

        excelWriter.finish();
    }

    private boolean nameIsEqualPinYin(String ename, String zzadno,
                                      String separator) {
        char[] chars = ename.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 设置大小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 设置声调表示方法
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // 设置字母u表示方法
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String[] s;
        String rs = "";
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                // 判断是否为汉字字符
                if (String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    s = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                    if (s != null) {
                        sb.append(s[0]).append(separator);
                        continue;
                    }
                }
                sb.append(String.valueOf(chars[i]));
                if ((i + 1 >= chars.length) || String.valueOf(chars[i + 1]).matches("[\\u4E00-\\u9FA5]+")) {
                    sb.append(separator);
                }
            }
            rs = sb.substring(0, sb.length());
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        return zzadno.contains(rs);
    }

    private InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
