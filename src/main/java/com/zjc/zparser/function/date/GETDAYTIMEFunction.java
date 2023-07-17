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
import com.zjc.zparser.enums.DateFunctionTypeEnum;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionConstants;
import com.zjc.zparser.function.FunctionException;
import com.zjc.zparser.function.FunctionResult;
import com.zjc.zparser.utils.DateUtil;

/**
 * @author James.Zou
 * @Description:获取指定天函数 时分秒
 *
 * @date 6/16/23 3:42 PM
 */
public class GETDAYTIMEFunction extends BaseFunction {
    @Override
    public String getName() {
        return DateFunctionTypeEnum.GETDAYTIME_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要传入一个参数 ";


        if (arguments == null || "".equals(arguments)) {
            throw new FunctionException(exceptionMessage);
        }

        try {
            Double day=Double.valueOf(arguments);
            result = DateUtil.getDayMillis((int) Math.floor(day));
        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_DATE);
    }
}
