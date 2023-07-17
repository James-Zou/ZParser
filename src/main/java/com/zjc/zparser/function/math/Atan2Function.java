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

package com.zjc.zparser.function.math;


import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.enums.MathFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;
/**
 * @author James.Zou
 * @Description: 反正切值函数
 * 它返回两个参数的反正切值。它通常用于计算极角，即从x轴到给定点的角度。
 * 该函数可以计算所有四个象限的角度，而不仅仅是第一象限。它的定义如下：
 *
 * atan2(y,x) = atan(y/x)
 * @date 6/6/23 3:50 PM
 */
public class Atan2Function extends BaseFunction {
	@Override
	public String getName() {
		return MathFunctionTypeEnum.ATAN2_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		Double result = null;

		ArrayList numbers = FunctionHelper.getDoubles(arguments,
				ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);

		if (numbers.size() != 2) {
			throw new FunctionException("需要两个参数");
		}

		try {
			double argumentOne = ((Double) numbers.get(0)).doubleValue();
			double argumentTwo = ((Double) numbers.get(1)).doubleValue();
			result = new Double(Math.atan2(argumentOne, argumentTwo));
		} catch (Exception e) {
			throw new FunctionException("需要两个参数", e);
		}

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}