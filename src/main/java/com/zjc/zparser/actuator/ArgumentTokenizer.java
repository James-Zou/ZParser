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

package com.zjc.zparser.actuator;

import java.util.Enumeration;
/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class ArgumentTokenizer implements Enumeration {


	public final char defaultDelimiter = 
		ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR;


	private String arguments = null;

	private char delimiter = defaultDelimiter;


	public ArgumentTokenizer(final String arguments, final char delimiter) {
		this.arguments = arguments;
		this.delimiter = delimiter;
	}


	public boolean hasMoreElements() {
		return hasMoreTokens();
	}


	public boolean hasMoreTokens() {

		if (arguments.length() > 0) {
			return true;
		}

		return false;
	}


	public Object nextElement() {
		return nextToken();
	}


	public String nextToken() {
		int charCtr = 0;
		int size = arguments.length();
		int parenthesesCtr = 0;
		String returnArgument = null;

		while (charCtr < size) {
			if (arguments.charAt(charCtr) == '(') {
				parenthesesCtr++;
			} else if (arguments.charAt(charCtr) == ')') {
				parenthesesCtr--;
			} else if (arguments.charAt(charCtr) == delimiter
					&& parenthesesCtr == 0) {

				returnArgument = arguments.substring(0, charCtr);
				arguments = arguments.substring(charCtr + 1);
				break;
			}

			charCtr++;
		}

		if (returnArgument == null) {
			returnArgument = arguments;
			arguments = "";
		}

		return returnArgument;
	}
}
