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
package com.unionhole.zparser.function.logic;

import com.unionhole.zparser.actuator.ExecutionCenter;
import com.unionhole.zparser.actuator.ExecutionConstants;
import com.unionhole.zparser.enums.LogicFunctionTypeEnum;
import com.unionhole.zparser.function.*;

import java.util.ArrayList;

/**
 * @author James.Zou
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
