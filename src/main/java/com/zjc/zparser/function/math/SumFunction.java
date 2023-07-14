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

package com.zjc.zparser.function.math;


import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.enums.MathFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;

/**
 * @author James.Zou
 * @date 6/6/23 3:50 PM
 */
public class SumFunction extends BaseFunction {

	@Override
	public String getName() {
		return MathFunctionTypeEnum.SUM_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {

		String exceptionMessage = "需要一个以上的字符串参数 ";

		ArrayList values = FunctionHelper.getStrings(arguments,
				ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
		if (values.size() == 0) {
			throw new FunctionException(exceptionMessage);
		}


		Double result = 0.0;

		try {
			for(int i=0;i<values.size();i++){
				result=result+Double.parseDouble(String.valueOf(values.get(i)));
			}
		} catch (Exception e) {
			throw new FunctionException("非法参数", e);
		}

		return new FunctionResult(result.toString(),
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}
