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

package com.unionhole.zparser.actuator;
/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class ExecutionHelper {

	public static String replaceAll(final String expression,
			final String oldString, final String newString) {

		String replacedExpression = expression;

		if (replacedExpression != null) {
			int charCtr = 0;
			int oldStringIndex = replacedExpression.indexOf(oldString, charCtr);

			while (oldStringIndex > -1) {
				final StringBuffer buffer = new StringBuffer(replacedExpression
						.substring(0, oldStringIndex)
						+ replacedExpression.substring(oldStringIndex
								+ oldString.length()));

				buffer.insert(oldStringIndex, newString);

				replacedExpression = buffer.toString();

				charCtr = oldStringIndex + newString.length();

				if (charCtr < replacedExpression.length()) {
					oldStringIndex = replacedExpression.indexOf(oldString,
							charCtr);
				} else {
					oldStringIndex = -1;
				}
			}
		}

		return replacedExpression;
	}

	public static boolean isSpace(final char character) {

		if (character == ' ' || character == '\t' || character == '\n'
				|| character == '\r' || character == '\f') {
			return true;
		}

		return false;
	}
}
