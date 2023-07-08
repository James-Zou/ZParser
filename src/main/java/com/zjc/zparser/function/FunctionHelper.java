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

package com.zjc.zparser.function;


import com.zjc.zparser.actuator.ArgumentTokenizer;

import java.util.ArrayList;
/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class FunctionHelper {


	public static String trimAndRemoveQuoteChars(final String arguments,
			final char quoteCharacter) throws FunctionException {

		String trimmedArgument = arguments;

		trimmedArgument = trimmedArgument.trim();

		if (trimmedArgument.charAt(0) == quoteCharacter) {
			trimmedArgument = trimmedArgument.substring(1, trimmedArgument
					.length());
		} else {
			throw new FunctionException("值不以引号开头\n" +
					"\n");
		}

		if (trimmedArgument.charAt(trimmedArgument.length() - 1) == quoteCharacter) {
			trimmedArgument = trimmedArgument.substring(0, trimmedArgument
					.length() - 1);
		} else {
			throw new FunctionException("值不以引号结尾\n" +
					"\n");
		}

		return trimmedArgument;
	}


	public static ArrayList getDoubles(final String arguments,
									   final char delimiter) throws FunctionException {

		ArrayList returnValues = new ArrayList();

		try {

			final ArgumentTokenizer tokenizer = new ArgumentTokenizer(
					arguments, delimiter);

			while (tokenizer.hasMoreTokens()) {
				final String token = tokenizer.nextToken().trim();
				returnValues.add(new Double(token));
			}
		} catch (Exception e) {
			throw new FunctionException("字符串中的值无效 \n" +
					"\n", e);
		}

		return returnValues;
	}


	public static ArrayList getStrings(final String arguments,
			final char delimiter) throws FunctionException {

		final ArrayList returnValues = new ArrayList();

		try {
			ArgumentTokenizer tokenizer = new ArgumentTokenizer(arguments,
					delimiter);

			while (tokenizer.hasMoreTokens()) {
				final String token = tokenizer.nextToken();
				returnValues.add(token);
			}
		} catch (Exception e) {
			throw new FunctionException("字符串中的值无效\n" +
					"\n", e);
		}

		return returnValues;
	}


	public static ArrayList getOneStringAndOneInteger(final String arguments,
			final char delimiter) throws FunctionException {

		ArrayList returnValues = new ArrayList();

		try {
			final ArgumentTokenizer tokenizer = new ArgumentTokenizer(
					arguments, delimiter);

			int tokenCtr = 0;
			while (tokenizer.hasMoreTokens()) {
				if (tokenCtr == 0) {
					final String token = tokenizer.nextToken();
					returnValues.add(token);
				} else if (tokenCtr == 1) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(new Integer(new Double(token).intValue()));
				} else {
					throw new FunctionException("字符串中的值无效\n" +
							"\n");
				}

				tokenCtr++;
			}
		} catch (Exception e) {
			throw new FunctionException("字符串中的值无效\n" +
					"\n", e);
		}

		return returnValues;
	}


	public static ArrayList getTwoStringsAndOneInteger(final String arguments,
			final char delimiter) throws FunctionException {

		final ArrayList returnValues = new ArrayList();

		try {
			final ArgumentTokenizer tokenizer = new ArgumentTokenizer(
					arguments, delimiter);

			int tokenCtr = 0;
			while (tokenizer.hasMoreTokens()) {
				if (tokenCtr == 0 || tokenCtr == 1) {
					final String token = tokenizer.nextToken();
					returnValues.add(token);
				} else if (tokenCtr == 2) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(new Integer(new Double(token).intValue()));
				} else {
					throw new FunctionException("字符串中的值无效\n" +
							"\n");
				}

				tokenCtr++;
			}
		} catch (Exception e) {
			throw new FunctionException("字符串中的值无效\n" +
					"\n", e);
		}

		return returnValues;
	}


	public static ArrayList getOneStringAndTwoIntegers(final String arguments,
			final char delimiter) throws FunctionException {

		final ArrayList returnValues = new ArrayList();

		try {
			final ArgumentTokenizer tokenizer = new ArgumentTokenizer(
					arguments, delimiter);

			int tokenCtr = 0;
			while (tokenizer.hasMoreTokens()) {
				if (tokenCtr == 0) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(token);
				} else if (tokenCtr == 1 || tokenCtr == 2) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(new Integer(new Double(token).intValue()));
				} else {
					throw new FunctionException("字符串中的值无效\n" +
							"\n");
				}

				tokenCtr++;
			}
		} catch (Exception e) {
			throw new FunctionException("字符串中的值无效\n" +
					"\n", e);
		}

		return returnValues;
	}
}
