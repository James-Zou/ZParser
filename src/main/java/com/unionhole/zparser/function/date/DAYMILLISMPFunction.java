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
 * @Description:获取指定天时分秒 根据指定天时间戳 支持传入 天/时/分/秒 单位
 *
 * @date 10/16/23 11:42 AM
 */
public class DAYMILLISMPFunction extends BaseFunction {
    @Override
    public String getName() {
        return DateFunctionTypeEnum.DAYMILLISMP_FUNCTION.getType();
    }

    @Override
    public FunctionResult execute(ExecutionCenter executionCenter, String arguments) throws FunctionException {
        String result = null;
        String exceptionMessage = "需要三个参数";

        ArrayList values= FunctionHelper.getStrings(arguments,
                ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
        if (values.size() != 3) {
            throw new FunctionException(exceptionMessage);
        }


        try {
            String argumentOne = (String) values.get(0);

            String argumentTwo= (String) values.get(1);

            String argumentThree= (String) values.get(2);

            long date= (long) Math.floor(Double.valueOf(argumentOne));
            long time= (long) Math.floor(Double.valueOf(argumentTwo));
            String unit=FunctionHelper.trimAndRemoveQuoteChars(
                    (String) argumentThree, executionCenter.getQuoteCharacter());

            long mills=0L;

            switch (unit){
                case "D": mills=(long)24*60*60*1000*time; break; //单位是天
                case "H": mills=(long)60*60*1000*time; break;//单位是小时
                case "M": mills=(long)60*1000*time; break;//单位是分钟
                case "S": mills=(long)1000*time; break;//单位是秒
                case "MI": mills=(long)time; break;//单位是毫秒
            }

            result = DateUtil.getDayMillisByMills(date,mills);
        } catch (Exception e) {
            throw new FunctionException(exceptionMessage, e);
        }
        return new FunctionResult(result,
                FunctionConstants.FUNCTION_RESULT_TYPE_DATE);
    }
}
