/*
 * Copyright 2023 James Zou.
 * Copyright 2002-2007 Robert Breidecker.
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

package com.unionhole.zparser.function.math;

import com.unionhole.zparser.actuator.ExecutionCenter;
import com.unionhole.zparser.enums.MathFunctionTypeEnum;
import com.unionhole.zparser.function.BaseFunction;
import com.unionhole.zparser.function.FunctionConstants;
import com.unionhole.zparser.function.FunctionException;
import com.unionhole.zparser.function.FunctionResult;

/**
 * @author James.Zou
 * @Description: 指数函数
 * 通常用于计算e的幂次方。在数学中，e是一个重要的常数，
 * 其值约为2.71828。exp函数的数学表达式为：exp(x) = e^x，
 * 其中x是指数。exp函数接受一个参数x，返回e的x次方的值。例如，exp(1)的值为e，exp(2)的值为e的平方。
 * @date 6/6/23 3:50 PM
 */
public class ExpFunction extends BaseFunction {
	@Override
	public String getName() {
		return MathFunctionTypeEnum.EXP_FUNCTION.getType();
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

		result = new Double(Math.exp(number.doubleValue()));

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}