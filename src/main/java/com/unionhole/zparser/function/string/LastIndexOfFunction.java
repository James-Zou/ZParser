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
 * @Description: 用于在字符串中搜索一个指定的子字符串，并返回它在字符串中最后一次出现的位置。
 * @date 6/6/23 3:50 PM
 */
public class LastIndexOfFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.LAST_INDEX_OF_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		Integer result = null;
		String exceptionMessage = "需要两个字符参数和一个整型参数 ";

		ArrayList values = FunctionHelper.getTwoStringsAndOneInteger(arguments,
				ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);

		if (values.size() != 3) {
			throw new FunctionException(exceptionMessage);
		}

		try {
			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					(String) values.get(0), executionCenter.getQuoteCharacter());
			String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars(
					(String) values.get(1), executionCenter.getQuoteCharacter());
			int index = ((Integer) values.get(2)).intValue();
			result = new Integer(argumentOne.lastIndexOf(argumentTwo, index));
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_MATH);
	}
}