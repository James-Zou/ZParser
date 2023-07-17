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

package com.zjc.zparser.function;
/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class FunctionResult {

	private String result;

	private int type;

	public FunctionResult(String result, int type) throws FunctionException {

		if (type < FunctionConstants.FUNCTION_RESULT_TYPE_MATH
				|| type > FunctionConstants.FUNCTION_RESULT_TYPE_LOGIC) {

			throw new FunctionException("无效的函数结果类型\n" +
					"\n");
		}

		this.result = result;
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public int getType() {
		return type;
	}
}
