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
 * @Description: 用于去除字符串两端的空格
 * @date 6/6/23 3:50 PM
 */
public class TrimFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.TRIM_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		String result = null;
		String exceptionMessage = "需要一个字符串参数";

		try {
			String stringValue = arguments;

			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					stringValue, executionCenter.getQuoteCharacter());

			result = argumentOne.trim();
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}