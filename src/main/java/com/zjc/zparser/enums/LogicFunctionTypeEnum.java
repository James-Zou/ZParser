package com.zjc.zparser.enums;

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
