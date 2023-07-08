/*
 * Copyright 2023 Roderick Zou.
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
import com.zjc.zparser.enums.MathFunctionTypeEnum;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionConstants;
import com.zjc.zparser.function.FunctionException;
import com.zjc.zparser.function.FunctionResult;

/**
 * @author roderick.zou
 * @Description: 对数函数
 * 它是以对数为基础的函数。log函数的作用是将一个数值转换成一个对数值。
 * 它通常被用来解决指数方程和指数函数的问题。在计算机科学中，log函数通常用于对数时间复杂度的计算。
 * log函数的一般形式为：log(a,b)，其中a是对数的底数，b是要求对数的数值。
 * log函数的计算结果是以a为底的b的对数值。例如，log2(8)的结果是3，因为2的3次幂等于8。
 * @date 6/8/23 3:50 PM
 */
public class LogFunction extends BaseFunction {
	@Override
	public String getName() {
		return MathFunctionTypeEnum.LOG_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		Double result = null;
		Double number = null;

		try {
			number = new Double(arguments);
		} catch (Exception e) {
			throw new FunctionException("非法参数", e);
		}

		result = new Double(Math.log(number.doubleValue()));

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}