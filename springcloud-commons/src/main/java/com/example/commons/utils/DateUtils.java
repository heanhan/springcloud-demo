package com.example.commons.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Author: zhaojh0912
 * @Dae: 2019/11/23
 * @Vsersion: 1.0.0
 * @Description: 时间工具类，为各个微服务模块提供时间类的转换方法
 */
@Slf4j
public class DateUtils {

    /**
     * 判断需要的字符串转换的时间是否合法
     * @param timeStr 需要转换的时间字符串
     * @param pattern 装换后的时间格式
     * @return boolean
     */
    public static boolean islegalDate(String timeStr,String pattern){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.parse(timeStr);
            return true;
        }catch(Exception e){
            log.info("需要转化的时间字符串格式不正确:"+e.getMessage());
            return false;
        }
    }

    /**
     * 将时间字符串转换为 时间Date类型
     * @param timeString 时间字符串
     * @param pattern 转换后的时间格式
     * @return Date
     */
    public static Date string2Date(String timeString,String pattern){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = simpleDateFormat.parse(timeString);
            return date;
        }catch (ParseException e){
            log.info("时间转换失败！:"+e.getMessage());
            return null;
        }catch (Exception e){
            log.info("String2Date方法执行失败");
            return null;
        }
    }


}
