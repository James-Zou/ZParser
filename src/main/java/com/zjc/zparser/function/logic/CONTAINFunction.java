package com.zjc.zparser.function.logic;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.enums.LogicFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;

/**
 * @author roderick.zou
 * @Description: 判断查找范围是否包含要查找的内容
 * @date 6/16/23 3:42 PM
 */
public class CONTAINFunction extends BaseFunction {
    @Override
    public String getName() {
        return LogicFunctionTypeEnum.CONTAIN_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = "false";
        String exceptionMessage = "至少需要两个字符串参数 ";

        ArrayList values = FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() <2) {
            throw new FunctionException(exceptionMessage);
        }

        String findStr=String.valueOf(values.get(0)).replaceAll("'","");
        try {
            for(int i=1;i<values.size();i++){
               if(findStr.contains(String.valueOf(values.get(i)).replaceAll("'",""))){
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
