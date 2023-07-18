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
 * @Description: 用于在一个字符串中查找并替换指定的子字符串
 * @date 6/6/23 3:50 PM
 */
public class ReplaceFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.REPLACE_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		String result = null;
		String exceptionMessage = "需要一个字符串参数和两个字符参数 ";

		ArrayList values = FunctionHelper.getStrings(arguments,
				ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);

		if (values.size() != 3) {
			throw new FunctionException(exceptionMessage);
		}

		try {
			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					(String) values.get(0), executionCenter.getQuoteCharacter());

			String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars(
					(String) values.get(1), executionCenter.getQuoteCharacter());

			String argumentThree = FunctionHelper.trimAndRemoveQuoteChars(
					(String) values.get(2), executionCenter.getQuoteCharacter());

			char oldCharacter = ' ';
			if (argumentTwo.length() == 1) {
				oldCharacter = argumentTwo.charAt(0);
			} else {
				throw new FunctionException(exceptionMessage);
			}

			char newCharacter = ' ';
			if (argumentThree.length() == 1) {
				newCharacter = argumentThree.charAt(0);
			} else {
				throw new FunctionException(exceptionMessage);
			}

			result = argumentOne.replace(oldCharacter, newCharacter);
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}