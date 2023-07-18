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
import com.unionhole.zparser.actuator.ExecutionConstants;
import com.unionhole.zparser.enums.DateFunctionTypeEnum;
import com.unionhole.zparser.function.*;
import com.unionhole.zparser.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author James.Zou
 * @Description:获取两个时间的差值
 *
 * @date 6/16/23 3:42 PM
 */
public class DAYSFunction extends BaseFunction {
    @Override
    public String getName() {
        return DateFunctionTypeEnum.DAYS_FUNCTION.getType();
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
            String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
                    (String) values.get(0), executionCenter.getQuoteCharacter());

            String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars(
                    (String) values.get(1), executionCenter.getQuoteCharacter());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            result = String.valueOf(DateUtil.getDays(sdf.parse(argumentOne),sdf.parse(argumentTwo)));
        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_DATE);
    }
}
