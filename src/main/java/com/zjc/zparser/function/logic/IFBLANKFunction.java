package com.zjc.zparser.function.logic;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.enums.LogicFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;

/**
 * @author roderick.zou
 * @Description:条件判断函数
 * IFBLANK(值, 空值情况的返回值)
 * 检查目标值是否为空，非空时返回该值本身，否则返回第二个参数的值
 * @date 6/16/23 3:42 PM
 */
public class IFBLANKFunction extends BaseFunction {
    @Override
    public String getName() {
        return LogicFunctionTypeEnum.IFBLANK_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要两个字符串参数 ";

        ArrayList values = FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() != 2) {
            throw new FunctionException(exceptionMessage);
        }

        try {
            if(values.get(0)==null||"''".equals(values.get(0))||"".equals(values.get(0))){
                result = String.valueOf(values.get(1)).replaceAll("'","");
            }else {
                result = String.valueOf(values.get(0)).replaceAll("'","");
            }

        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_LOGIC);
    }
}
