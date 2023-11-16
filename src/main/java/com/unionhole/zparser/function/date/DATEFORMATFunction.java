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
package com.unionhole.zparser.function.date;

import com.unionhole.zparser.actuator.ExecutionCenter;
import com.unionhole.zparser.actuator.ExecutionConstants;
import com.unionhole.zparser.enums.DateFunctionTypeEnum;
import com.unionhole.zparser.function.*;
import com.unionhole.zparser.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * @author James.Zou
 * @Description:
 * 日期格式化函数，可以指定格式进行格式化
 * 第一个参数必须为毫秒单位的整数
 * 第二个参数（格式化格式）
 * 第三个参数（是否为内置格式）说明：
 * 0：表示内置格式，内置格式即SimpleDateFormat官方支持格式
 * 1：表示自定义格式（D天H小时M分钟S秒）,此处 D、H、M、S为占位符，会被替换计算后数值，天、小时、分钟、秒为固定文本
 *
 * @date 11/15/23 6:42 PM
 */
public class DATEFORMATFunction extends BaseFunction {

    public static long DAY_MILLISECOND = 1000 * 24 * 60 * 60;// 一天的毫秒数

    public static long HOUR_MILLISECOND = 1000 * 60 * 60;// 一小时的毫秒数

    public static long MINUTE_MILLISECOND = 1000 * 60;// 一分钟的毫秒数

    public static long SECOND_MILLISECOND = 1000;// 一秒钟的毫秒数

    @Override
    public String getName() {
        return DateFunctionTypeEnum.DATEFORMAT_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要三个参数";

        ArrayList values= FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() != 3) {
            throw new FunctionException(exceptionMessage);
        }


        try {

            String argumentOne = (String) values.get(0);

            String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars(
                    (String) values.get(1), executionCenter.getQuoteCharacter());

            String argumentThree = FunctionHelper.trimAndRemoveQuoteChars(
                    (String) values.get(2), executionCenter.getQuoteCharacter());

            long date= (long) Math.floor(Double.valueOf(argumentOne));

            switch (argumentThree){
                case "0":
                    ThreadLocal<SimpleDateFormat> threadLocalFormat = ThreadLocal.withInitial(() ->
                            new SimpleDateFormat(argumentTwo));
                    SimpleDateFormat sdf = threadLocalFormat.get();
                    result=sdf.format(new Date(date));
                    break;
                case "1":
                    result=getCustomDate(date, argumentTwo);
                    break;
                default:result=argumentTwo;break;
            }


        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
    }

    /**
     * 获取自定义格式  D天H小时M分钟S秒
     * @param date
     * @param argumentTwo
     * @return
     */
    private String getCustomDate(long date,String argumentTwo){
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;

        //计算差几天
        day = date / DAY_MILLISECOND;
        // 计算差多少小时
        hour = date % DAY_MILLISECOND / HOUR_MILLISECOND ;
        // 计算差多少分钟
        min = date % DAY_MILLISECOND % HOUR_MILLISECOND / MINUTE_MILLISECOND ;
        // 计算差多少秒
        sec = date % DAY_MILLISECOND % HOUR_MILLISECOND % MINUTE_MILLISECOND / SECOND_MILLISECOND;
        //D天H小时M分钟S秒
        return argumentTwo.replaceFirst("D",String.valueOf(day))
                .replaceFirst("H",String.valueOf(hour))
                .replaceFirst("M",String.valueOf(min))
                .replaceFirst("S",String.valueOf(sec));

    }


}
