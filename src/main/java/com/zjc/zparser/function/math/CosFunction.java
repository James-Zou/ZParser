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

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.enums.MathFunctionTypeEnum;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionConstants;
import com.zjc.zparser.function.FunctionException;
import com.zjc.zparser.function.FunctionResult;

/**
 * @author James.Zou
 * @Description: 余弦函数
 * 表示一个角的余弦值。在直角三角形中，cos函数定义为斜边与直角边之间的比值。
 * cos函数是偶函数，其定义域为实数集，值域为[-1,1]。
 * @date 6/6/23 3:50 PM
 */
public class CosFunction extends BaseFunction {
	@Override
	public String getName() {
		return MathFunctionTypeEnum.COS_FUNCTION.getType();
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

		result = new Double(Math.cos(number.doubleValue()));

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}