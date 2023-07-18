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

package com.unionhole.zparser.function.string;

import com.unionhole.zparser.actuator.ExecutionCenter;
import com.unionhole.zparser.enums.StringFunctionTypeEnum;
import com.unionhole.zparser.function.*;

/**
 * @author James.Zou
 * @Description: 用于获取一个字符串或数组的长度
 * @date 6/6/23 3:50 PM
 */
public class LengthFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.LENGTH_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		Integer result = null;
		String exceptionMessage = "需要一个字符参数";

		try {
			String stringValue = arguments;

			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					stringValue, executionCenter.getQuoteCharacter());

			result = new Integer(argumentOne.length());
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}