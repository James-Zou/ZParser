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

package com.zjc.zparser.function.string;

import com.zjc.zparser.actuator.ExecutionException;
import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.enums.StringFunctionTypeEnum;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionConstants;
import com.zjc.zparser.function.FunctionException;
import com.zjc.zparser.function.FunctionResult;

/**
 * @author James.Zou
 * @Description: 字符串作为表达式来执行
 * 例如，我们可以使用eval函数来计算一个字符串表示的算术表达式：
 *
 * ```
 * >>> s = '1 + 2 * 3'
 * >>> eval(s)
 * 7
 * ```
 *
 * 在这个例子中，字符串s表示一个算术表达式，其中包含加法和乘法运算。使用eval函数对s进行计算后，得到的结果为7。
 * @date 6/6/23 3:50 PM
 */
public class EvalFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.EVAL_AT_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter,
								  final String arguments) throws FunctionException {
		String result = null;

		try {
			result = executionCenter.execute(arguments, false, true);
		} catch (ExecutionException ee) {
			throw new FunctionException(ee.getMessage(), ee);
		}

		int resultType = FunctionConstants.FUNCTION_RESULT_TYPE_MATH;
		try {
			Double.parseDouble(result);
		} catch (NumberFormatException nfe) {
			resultType = FunctionConstants.FUNCTION_RESULT_TYPE_STRING;
		}

		return new FunctionResult(result, resultType);
	}
}