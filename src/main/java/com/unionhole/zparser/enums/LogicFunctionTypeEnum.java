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
 * 逻辑函数枚举类
 */
public enum LogicFunctionTypeEnum {


    IF_FUNCTION("IF"),//条件判断函数
    CONTAIN_FUNCTION("CONTAIN"),//文本查找函数
    IFBLANK_FUNCTION("IFBLANK"),//条件为空判断函数
    OR_FUNCTION("OR"),//条件为空判断函数
    AND_FUNCTION("AND");//多个条件判断函数

    private String type;

    LogicFunctionTypeEnum(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }

    public static LogicFunctionTypeEnum getParamType(String type){
        for(LogicFunctionTypeEnum typeEnum: LogicFunctionTypeEnum.values()){
            if(typeEnum.getType().equals(type)){
                return typeEnum;
            }
        }
        return null;
    }

}
