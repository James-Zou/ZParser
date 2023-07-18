/*
 * Copyright 2023 James Zou.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.unionhole.zparser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     *获取下一天
     * @return
     */
    public  static String getNextDay() {
        long cur=System.currentTimeMillis();
        long dayh=(long)24*60*60*1000; //一天的毫秒数
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(cur+dayh));
    }

    /**
     *
     * @return
     */
    public  static String getNextDayMillis() {
        long cur=System.currentTimeMillis();
        long dayh=(long)24*60*60*1000; //一天的毫秒数
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(cur+dayh));
    }

    /**
     * 获取当天
     * @return
     */
    public static String getCurrentDay() {
        long cur=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(cur));
    }

    /**
     * 获取当天
     * @return
     */
    public static String getCurrentDayMillis() {
        long cur=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(cur));
    }

    /**
     *获取指定天
     * @return
     */
    public  static String getDay(int day) {
        long cur=System.currentTimeMillis();
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(cur+dayh));
    }

    /**
     *获取指定天 根据指定天
     * @return
     */
    public  static String getDayByDate(String date, int day) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        long cur=sdf.parse(date).getTime();
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        return sdf.format(new Date(cur+dayh));
    }

    /**
     *获取指定天 根据指定天
     * @return
     */
    public  static String getDayByDate(long date,int day) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        long cur=date;
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        return sdf.format(new Date(cur+dayh));
    }

    /**
     *获取指定天
     * @return
     */
    public  static String getDayMillis(int day) {
        long cur=System.currentTimeMillis();
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(cur+dayh));
    }
    /**
     *获取指定天 根据指定天
     * @return
     */
    public  static String getDayMillisByDate(String date,int day) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long cur=sdf.parse(date).getTime();
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        return sdf.format(new Date(cur+dayh));
    }

    /**
     *获取指定天 根据指定天
     * @return
     */
    public  static String getDayMillisByDate(long date,int day) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long cur=date;
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        return sdf.format(new Date(cur+dayh));
    }


    /**
     *获取指定天的时间戳
     * @return
     */
    public  static long getTimeMillis(int day) {
        long cur=System.currentTimeMillis();
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        return cur+dayh;
    }

    /**
     * 获取指定天数，指定秒数的时间戳
     * @param day
     * @return
     * @throws Exception
     */
    public static long getTimeMillisFormat(int day,String mills) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse(getDay(day)+" "+mills);
        long time=date.getTime();
        return time;

    }

    /**
     * 获取当前时间是周几
     * @return
     * @throws Exception
     */
    public static String getWeek() throws Exception {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("EEEE");
        return sdf.format(date);

    }

    /**
     * 获取指定时间是周几
     * @return
     * @throws Exception
     */
    public static String getWeekByDay(int day) throws Exception {
        long cur=System.currentTimeMillis();
        long dayh=(long)24*60*60*1000*day; //一天的毫秒数
        SimpleDateFormat sdf=new SimpleDateFormat("EEEE");
        return sdf.format(new Date(cur+dayh));
    }




    /**
     * 计算某日期所在季度开始日期
     * 季度划分：1、2、3， 4、5、6， 7、8、9， 10、11、12
     */
    public static String getSeasonStartDate (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month / 3 * 3);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 计算某日期所在季度结束日期
     * 季度划分：1、2、3， 4、5、6， 7、8、9， 10、11、12
     */
    public static String getSeasonEndDate (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, (month + 3) / 3 * 3);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(calendar.getTime().getTime() - 24 * 60 * 60 *1000));
    }

    /**
     * 获取当前日期上个月的今天
     * @param date
     * @return
     */
    public static String getLastMonthToday (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前日期指定月份的今天
     * @param date
     * @return
     */
    public static String getMonthToday (Date date,int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,amount);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前月月初
     * @return
     */
    public static String getMonthStartDay () {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale =  Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(cale.getTime());
    }

    /**
     * 获取当前月月末
     * @return
     */
    public static String getMonthEndDay () {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale =  Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return format.format(cale.getTime());

    }

    /**
     * 根据时间戳得到日期时分秒
     * @return
     */
    public  static String getDayTimeByMillis(long date) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(date));
    }

    /**
     * 根据时间戳得到日期
     * @return
     */
    public  static String getDayByMillis(long date) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(date));
    }

    /**
     * 根据日期得到时间戳
     * @return
     */
    public  static long getMillisByDay(Date date) {
        return date.getTime();
    }

    /**
     *获取两个时间的差值
     * @return
     */
    public  static long getDays(Date date1,Date date2) {
        long startDate=date1.getTime();
        long endDate=date2.getTime();
        long dateValue=endDate-startDate;
        long dayh=(long)24*60*60*1000; //一天的毫秒数
        long day=dateValue/dayh;
        return day;
    }

    /**
     *获取两个时间戳的差值
     * @return
     */
    public  static long getDays(long date1,long date2) {
        long dateValue=date2-date1;
        long dayh=(long)24*60*60*1000; //一天的毫秒数
        long day=dateValue/dayh;
        return day;
    }


}
