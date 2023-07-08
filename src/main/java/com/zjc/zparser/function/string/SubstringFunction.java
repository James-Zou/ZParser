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

import com.zjc.zparser.actuator.ExecutionConstants;
import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.enums.StringFunctionTypeEnum;
import com.zjc.zparser.function.*;

import java.util.ArrayList;
/**
 * @author roderick.zou
 * @Description: 用于从一个字符串中提取指定长度的子字符串
 * 它需要三个参数：原字符串、起始位置和子字符串长度。起始位置是从0开始的。
 *
 * 例如，如果我们有一个字符串"Hello World"，我们可以使用substrin函数来提取"World"，代码如下：
 *
 * ```javascript
 * var str = "Hello World";
 * var substring = str.substring(6, 5);
 * console.log(substring); // 输出 "World"
 * ```
 * @date 6/8/23 3:50 PM
 */
public class SubstringFunction extends BaseFunction {
	@Override
	public String getName() {
		return StringFunctionTypeEnum.SUBSTRING_FUNCTION.getType();
	}

	@Override
	public FunctionResult execute(final ExecutionCenter executionCenter, final String arguments)
			throws FunctionException {
		String result = null;
		String exceptionMessage = "需要一个字符串参数和两个整型参数 ";

		ArrayList values = FunctionHelper.getOneStringAndTwoIntegers(arguments,
				ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);

		if (values.size() != 3) {
			throw new FunctionException(exceptionMessage);
		}

		try {
			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					(String) values.get(0), executionCenter.getQuoteCharacter());
			int beginningIndex = ((Integer) values.get(1)).intValue();
			int endingIndex = ((Integer) values.get(2)).intValue();
			result = argumentOne.substring(beginningIndex, endingIndex);
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}