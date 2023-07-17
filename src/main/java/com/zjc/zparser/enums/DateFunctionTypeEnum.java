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
package com.zjc.zparser.enums;

/**
 * 日期函数枚举类
 */
public enum DateFunctionTypeEnum {


    NEXTDAY_FUNCTION("NEXTDAY"),//获取下一天函数
    NEXTDAYTIME_FUNCTION("NEXTDAYTIME"),//获取下一天函数 时分秒
    GETDAY_FUNCTION("GETDAY"),//获取指定天天函数
    GETDAYTIME_FUNCTION("GETDAYTIME"),//获取指定天天函数 时分秒
    TIMEMILLIS_FUNCTION("TIMEMILLIS"),//获取指定天时间戳函数
    WEEK_FUNCTION("WEEK"),//获取指定天是周几函数
    CURRENTWEEK_FUNCTION("CURRENTWEEK"),//获取获取当前时间是周几函数
    CURRENTDAYTIME_FUNCTION("CURRENTDAYTIME"),//获取当天函数 时分秒
    SEASONSTARTDATE_FUNCTION("SEASONSTARTDATE"),//计算某日期所在季度开始日期
    SEASONENDDATE_FUNCTION("SEASONENDDATE"),//计算某日期所在季度结束日期
    MONTHSTARTDATE_FUNCTION("MONTHSTARTDATE"),//计算某日期所在月份开始日期
    MONTHENDDATE_FUNCTION("MONTHENDDATE"),//计算某日期所在月份结束日期
    CURRENTDAY_FUNCTION("CURRENTDAY"),//获取当天函数
    DAYMILLIS_FUNCTION("DAYMILLIS"),//根据指定日期获取日期时分秒
    DAYMILLISM_FUNCTION("DAYMILLISM"),//根据指定日期时间戳获取日期时分秒
    DAYM_FUNCTION("DAYM"),//根据指定日期时间戳获取日期
    DAY_FUNCTION("DAY"),//根据指定日期获取日期
    DAYS_FUNCTION("DAYS"),//获取两个时间的差值
    DAYMS_FUNCTION("DAYMS"),//获取两个时间时分秒的差值
    DAYTS_FUNCTION("DAYTS");//获取两个时间戳的差值

    private String type;

    DateFunctionTypeEnum(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }

    public static DateFunctionTypeEnum getParamType(String type){
        for(DateFunctionTypeEnum typeEnum: DateFunctionTypeEnum.values()){
            if(typeEnum.getType().equals(type)){
                return typeEnum;
            }
        }
        return null;
    }

}
