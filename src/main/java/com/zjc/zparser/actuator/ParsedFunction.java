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


import com.zjc.zparser.parser.Operator;
import com.zjc.zparser.function.BaseFunction;

/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class ParsedFunction {

	private final BaseFunction baseFunction;

	private final String arguments;

	private final Operator unaryOperator;

	public ParsedFunction(final BaseFunction baseFunction, final String arguments,
						  final Operator unaryOperator) {

		this.baseFunction = baseFunction;
		this.arguments = arguments;
		this.unaryOperator = unaryOperator;
	}

	public BaseFunction getBaseFunction() {
		return baseFunction;
	}

	public String getArguments() {
		return arguments;
	}

	public Operator getUnaryOperator() {
		return unaryOperator;
	}
}