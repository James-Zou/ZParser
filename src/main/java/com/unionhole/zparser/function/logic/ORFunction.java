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
