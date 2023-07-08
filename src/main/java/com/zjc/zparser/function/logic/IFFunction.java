package com.zjc.zparser.function.logic;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.enums.LogicFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;

/**
 * @author roderick.zou
 * @Description:条件判断函数
 * IF(判断条件, 为 TRUE 时的返回值, [为 FALSE 时的返回值])
 * 当判断条件为 TRUE 时返回一个值，为 FALSE 时返回另一个值
 * 示例：
 * IF(1==2, '相同', '不相同')
 * @date 6/16/23 3:42 PM
 */
public class IFFunction extends BaseFunction {
    @Override
    public String getName() {
        return LogicFunctionTypeEnum.IF_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要三个字符串参数 ";

        ArrayList values = FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() != 3) {
            throw new FunctionException(exceptionMessage);
        }

        try {
            result = ExecutionConstants.BOOLEAN_STRING_TRUE.equals(String.valueOf(values.get(0)).replaceAll("'",""))?String.valueOf(values.get(1)).replaceAll("'",""):String.valueOf(values.get(2)).replaceAll("'","");
        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_LOGIC);
    }
}
