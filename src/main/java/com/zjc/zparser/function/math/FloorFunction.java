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
 * @Description: floor函数
 *	用于将输入值向下取整为最接近且小于等于该值的整数。
 *	例如，floor(3.7)将返回3，floor(-2.4)将返回-3。
 *	在计算机语言中，通常使用floor函数来处理浮点数的舍入错误或将数值截断为整数。
 * @date 6/8/23 3:50 PM
 */
public class FloorFunction extends BaseFunction {
	@Override
	public String getName() {
		return MathFunctionTypeEnum.FLOOR_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		Double result = null;
		Double number = null;

		try {
			number = new Double(arguments);
		} catch (Exception e) {
			throw new FunctionException("非法参数.", e);
		}

		result = new Double(Math.floor(number.doubleValue()));

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}