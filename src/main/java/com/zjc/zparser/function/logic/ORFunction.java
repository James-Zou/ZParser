package com.zjc.zparser.function.logic;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.enums.LogicFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;

/**
 * @author roderick.zou
 * @Description: 条件判断函数 ，多组条件
 * @date 6/16/23 3:42 PM
 */
public class ORFunction extends BaseFunction {
    @Override
    public String getName() {
        return LogicFunctionTypeEnum.OR_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = "false";
        String exceptionMessage = "至少需要一个字符串参数 ";

        ArrayList values = FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() ==0) {
            throw new FunctionException(exceptionMessage);
        }

        try {
            for(int i=0;i<values.size();i++){
                if(ExecutionConstants.BOOLEAN_STRING_TRUE.equals(String.valueOf(values.get(i)).replaceAll("'",""))){
                    result="true";
                }
            }


        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_LOGIC);
    }
}
