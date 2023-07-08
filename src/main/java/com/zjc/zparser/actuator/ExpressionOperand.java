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

/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class ExpressionOperand {

	private String value = null;

	private Operator unaryOperator = null;

	public ExpressionOperand(final String value, final Operator unaryOperator) {
		this.value = value;
		this.unaryOperator = unaryOperator;
	}

	public String getValue() {
		return value;
	}

	public Operator getUnaryOperator() {
		return unaryOperator;
	}
}