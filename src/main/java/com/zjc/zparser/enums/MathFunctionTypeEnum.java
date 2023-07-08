package com.zjc.zparser.enums;

/**
 * 数学函数枚举类
 */
public enum MathFunctionTypeEnum {


    ABS_FUNCTION("ABS"),//绝对值函数
    ACOS_FUNCTION("ACOS"),//反余弦函数
    ASIN_FUNCTION("ASIN"),//反正弦函数
    ATAN2_FUNCTION("ATAN2"),//反正切值函数
    ATAN_FUNCTION("ATAN"),//反正切函数
    CEIL_FUNCTION("CEIL"),//用于将一个浮点数向上取整到最接近的整数
    COS_FUNCTION("COS"),//余弦函数
    EXP_FUNCTION("EXP"),//指数函数
    FLOOR_FUNCTION("FLOOR"),//floor函数
    LOG_FUNCTION("LOG"),//对数函数
    MAX_FUNCTION("MAX"),//求最大值函数
    MIN_FUNCTION("MIN"),//求最小值函数
    POW_FUNCTION("POW"),//计算一个数的幂
    RANDOM_FUNCTION("RANDOM"),//随机数函数
    SIN_FUNCTION("SIN"),//正弦函数
    SQRT_FUNCTION("SQRT"),//平方根函数
    SUM_FUNCTION("SUM"),//平方根函数
    TAN_FUNCTION("TAN");//正切函数

    private String type;

    MathFunctionTypeEnum(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }

    public static MathFunctionTypeEnum getParamType(String type){
        for(MathFunctionTypeEnum typeEnum: MathFunctionTypeEnum.values()){
            if(typeEnum.getType().equals(type)){
                return typeEnum;
            }
        }
        return null;
    }

}
