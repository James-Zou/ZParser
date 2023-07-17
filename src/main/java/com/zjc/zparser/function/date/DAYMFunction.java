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
package com.zjc.zparser.function.date;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.enums.DateFunctionTypeEnum;
import com.zjc.zparser.function.*;
import com.zjc.zparser.utils.DateUtil;

import java.util.ArrayList;

/**
 * @author James.Zou
 * @Description:获取指定天 根据指定天时间戳
 *
 * @date 6/16/23 3:42 PM
 */
public class DAYMFunction extends BaseFunction {
    @Override
    public String getName() {
        return DateFunctionTypeEnum.DAYM_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要两个参数";

        ArrayList values= FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() != 2) {
            throw new FunctionException(exceptionMessage);
        }


        try {
            String argumentOne = (String)values.get(0);

            String argumentTwo= (String) values.get(1);

            long date=(long) Math.floor(Double.valueOf(argumentOne));

           int day= (int) Math.floor(Double.valueOf(argumentTwo));

            result = DateUtil.getDayByDate(date,day);
        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_DATE);
    }
}
