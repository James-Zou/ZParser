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

package com.zjc.zparser.parser;

/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class AdditionOperator extends AbstractOperator {


	public AdditionOperator() {
		super("+", 5, true);
	}


	@Override
	public double execute(final double leftOperand, final double rightOperand) {
		Double rtnValue = new Double(leftOperand + rightOperand);

		return rtnValue.doubleValue();
	}


	@Override
	public String execute(final String leftOperand, final String rightOperand) {
		String rtnValue = new String(leftOperand.substring(0, leftOperand
				.length() - 1)
				+ rightOperand.substring(1, rightOperand.length()));

		return rtnValue;
	}


	@Override
	public double execute(double operand) {
		return operand;
	}
}