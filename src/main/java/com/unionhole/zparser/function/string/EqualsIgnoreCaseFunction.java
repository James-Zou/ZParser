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

import com.unionhole.zparser.actuator.ExecutionConstants;
import com.unionhole.zparser.actuator.ExecutionCenter;
import com.unionhole.zparser.enums.StringFunctionTypeEnum;
import com.unionhole.zparser.function.*;

import java.util.ArrayList;
/**
 * @author James.Zou
 * @Description: 字符串比较是否相等 忽略大小写
 * @date 6/6/23 3:50 PM
 */
public class EqualsIgnoreCaseFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.EQUALS_IGNORE_CASE_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		String result = null;
		String exceptionMessage = "需要两个字符参数";

		ArrayList strings = FunctionHelper.getStrings(arguments,
				ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);

		if (strings.size() != 2) {
			throw new FunctionException(exceptionMessage);
		}

		try {
			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					(String) strings.get(0), executionCenter.getQuoteCharacter());
			String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars(
					(String) strings.get(1), executionCenter.getQuoteCharacter());

			if (argumentOne.equalsIgnoreCase(argumentTwo)) {
				result = ExecutionConstants.BOOLEAN_STRING_TRUE;
			} else {
				result = ExecutionConstants.BOOLEAN_STRING_FALSE;
			}
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}