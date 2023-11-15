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
package com.unionhole.zparser.function.date;

import com.unionhole.zparser.actuator.ExecutionCenter;
import com.unionhole.zparser.enums.DateFunctionTypeEnum;
import com.unionhole.zparser.function.BaseFunction;
import com.unionhole.zparser.function.FunctionConstants;
import com.unionhole.zparser.function.FunctionException;
import com.unionhole.zparser.function.FunctionResult;
import com.unionhole.zparser.utils.DateUtil;

import java.text.SimpleDateFormat;

/**
 * @author James.Zou
 * @Description:计算某日期所在季度开始日期
 *
 * @date 6/16/23 3:42 PM
 */
public class SEASONSTARTDATEFunction extends BaseFunction {
    @Override
    public String getName() {
        return DateFunctionTypeEnum.SEASONSTARTDATE_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要传入一个参数 ";


        if (arguments == null || "".equals(arguments)) {
            throw new FunctionException(exceptionMessage);
        }

        try {
            ThreadLocal<SimpleDateFormat> threadLocalFormat = ThreadLocal.withInitial(() ->
                    new SimpleDateFormat("yyyy-MM-dd"));
            SimpleDateFormat sdf = threadLocalFormat.get();

//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            result = DateUtil.getSeasonStartDate(sdf.parse(arguments.replace("'","")));
        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_DATE);
    }
}
