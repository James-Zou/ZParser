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
 * @Description:随机数函数
 * @date 6/6/23 3:50 PM
 */
public class RandomFunction extends BaseFunction {
	@Override
	public String getName() {
		return MathFunctionTypeEnum.RANDOM_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		Double result = new Double(Math.random());

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}