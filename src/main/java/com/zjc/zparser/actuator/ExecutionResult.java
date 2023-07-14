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

package com.zjc.zparser.actuator;
/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class ExecutionResult {

	private String result;

	private char quoteCharacter;

	public ExecutionResult(String result, char quoteCharacter) {

		this.result = result;
		this.quoteCharacter = quoteCharacter;
	}

	public char getQuoteCharacter() {
		return quoteCharacter;
	}

	public void setQuoteCharacter(char quoteCharacter) {
		this.quoteCharacter = quoteCharacter;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isBooleanTrue() {

		if (result != null
				&& ExecutionConstants.BOOLEAN_STRING_TRUE.equals(result)) {

			return true;
		}

		return false;
	}

	public boolean isBooleanFalse() {

		if (result != null
				&& ExecutionConstants.BOOLEAN_STRING_FALSE.equals(result)) {

			return true;
		}

		return false;
	}

	public boolean isString() {

		if (result != null && result.length() >= 2) {

			if (result.charAt(0) == quoteCharacter
					&& result.charAt(result.length() - 1) == quoteCharacter) {

				return true;
			}
		}

		return false;
	}

	public Double getDouble() throws NumberFormatException {

		return new Double(result);
	}

	public String getUnwrappedString() {

		if (result != null && result.length() >= 2) {

			if (result.charAt(0) == quoteCharacter
					&& result.charAt(result.length() - 1) == quoteCharacter) {

				return result.substring(1, result.length() - 1);
			}
		}

		return null;
	}
}
