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


import com.unionhole.zparser.actuator.ExecutionException;
/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public abstract class AbstractOperator implements Operator {

	private String symbol = null;

	private int precedence = 0;

	private boolean unary = false;


	public AbstractOperator(final String symbol, final int precedence) {

		this.symbol = symbol;
		this.precedence = precedence;
	}


	public AbstractOperator(

	String symbol, int precedence, boolean unary) {

		this.symbol = symbol;
		this.precedence = precedence;
		this.unary = unary;
	}


	public double execute(final double leftOperand, final double rightOperand) {
		return 0;
	}


	public String execute(final String leftOperand, final String rightOperand)
			throws ExecutionException {
		throw new ExecutionException("不合理的操作字符串");
	}


	public double execute(double operand) {
		return 0;
	}


	public String getSymbol() {
		return symbol;
	}


	public int getPrecedence() {
		return precedence;
	}


	public int getLength() {
		return symbol.length();
	}


	public boolean isUnary() {
		return unary;
	}


	@Override
	public boolean equals(final Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof AbstractOperator)) {
			throw new IllegalStateException("不合理的操作对象");
		}

		AbstractOperator operator = (AbstractOperator) object;

		if (symbol.equals(operator.getSymbol())) {
			return true;
		}

		return false;
	}


	@Override
	public String toString() {
		return getSymbol();
	}
}