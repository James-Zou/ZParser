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

package com.zjc.zparser.function.string;


import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.enums.StringFunctionTypeEnum;
import com.zjc.zparser.function.*;

/**
 * @author roderick.zou
 * @Description: 将字符串中的所有字母转换为小写字母
 * @date 6/8/23 3:50 PM
 */
public class ToLowerCaseFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.TO_LOWER_CASE_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		String result = null;
		String exceptionMessage = "需要一个字符串函数";

		try {
			String stringValue = arguments;

			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					stringValue, executionCenter.getQuoteCharacter());

			result = argumentOne.toLowerCase();
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}