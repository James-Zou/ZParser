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

import java.util.ArrayList;

/**
 * @author James.Zou
 * @Description:获取两个时间戳的差值
 * 可指定单位
 * "D": 单位是天
 * "H": 单位是小时
 * "M": 单位是分钟
 * "S": 单位是秒
 * "MI": 单位是毫秒
 *
 * @date 11/9/23 3:42 PM
 */
public class DAYTSPFunction extends BaseFunction {
    @Override
    public String getName() {
        return DateFunctionTypeEnum.DAYTSP_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要四个参数";

        ArrayList values= FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() != 4) {
            throw new FunctionException(exceptionMessage);
        }


        try {
            String argumentOne = (String) values.get(0);

            String argumentTwo= (String) values.get(1);

            String argumentThree= (String) values.get(2);

            String argumentFour= (String) values.get(3);

            String unit=FunctionHelper.trimAndRemoveQuoteChars(
                    (String) argumentThree, executionCenter.getQuoteCharacter());

            String argumentFourStr=FunctionHelper.trimAndRemoveQuoteChars(
                    (String) argumentFour, executionCenter.getQuoteCharacter());

            long date1= (long) Math.floor(Double.valueOf(argumentOne));
            long date2= (long) Math.floor(Double.valueOf(argumentTwo));
            int isUpper=Integer.valueOf(argumentFourStr);

            result = String.valueOf(DateUtil.getDaysByUnit(date1,date2,unit,isUpper));

            long mills=0L;


        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_DATE);
    }
}
