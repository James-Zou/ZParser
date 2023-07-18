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
package com.unionhole.zparser.enums;

/**
 * 字符串函数枚举类
 */
public enum StringFunctionTypeEnum {


    CHAR_AT_FUNCTION("CHAR"),//用于获取字符串中指定位置的字符
    COMPARE_TO_FUNCTION("COMPARE"),//比较两个对象之间的大小
    COMPARE_TO_IGNORE_CASE_FUNCTION("COMPAREIGNORE"),//比较两个对象之间的大小 忽略大小写
    CONCAT_FUNCTION("CONCAT"),//字符串拼接函数
    ENDS_WITH_FUNCTION("ENDS"),//检查一个字符串是否以指定的字符串结尾
    EQUALS_FUNCTION("EQUALS"),//字符串比较是否相等
    EQUALS_IGNORE_CASE_FUNCTION("EQUALSIGNORE"),//字符串比较是否相等 忽略大小写
    EVAL_AT_FUNCTION("EVAL"),//字符串作为表达式来执行
    INDEX_OF_FUNCTION("INDEX"),//用于在字符串中查找指定的子字符串
    LAST_INDEX_OF_FUNCTION("LASTINDEX"),//用于在字符串中搜索一个指定的子字符串，并返回它在字符串中最后一次出现的位置
    LENGTH_FUNCTION("LENGTH"),//用于获取一个字符串或数组的长度
    REPLACE_FUNCTION("REPLACE"),//用于在一个字符串中查找并替换指定的子字符串
    STARTS_WITH_FUNCTION("STARTS"),//用于判断一个字符串是否以指定的字符或字符串开头的函数
    SUBSTRING_FUNCTION("SUBSTRING"),//用于从一个字符串中提取指定长度的子字符串
    TO_LOWER_CASE_FUNCTION("LOWERCASE"),//将字符串中的所有字母转换为小写字母
    TO_UPPER_CASE_FUNCTION("UPPERCASE"),//将字符串中的所有字母转换为大写字母
    TRIM_FUNCTION("TRIM");//用于去除字符串两端的空格

    private String type;

    StringFunctionTypeEnum(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }

    public static StringFunctionTypeEnum getParamType(String type){
        for(StringFunctionTypeEnum typeEnum: StringFunctionTypeEnum.values()){
            if(typeEnum.getType().equals(type)){
                return typeEnum;
            }
        }
        return null;
    }

}
