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

package com.unionhole.zparser.parser;


import com.unionhole.zparser.actuator.ExecutionConstants;
/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class EqualOperator extends AbstractOperator {


	public EqualOperator() {
		super("==", 3);
	}


	@Override
	public double execute(final double leftOperand, final double rightOperand) {
		if (leftOperand == rightOperand) {
			return 1;
		}

		return 0;
	}


	@Override
	public String execute(String leftOperand, String rightOperand) {
		if (leftOperand.compareTo(rightOperand) == 0) {
			return ExecutionConstants.BOOLEAN_STRING_TRUE;
		}

		return ExecutionConstants.BOOLEAN_STRING_FALSE;
	}
}