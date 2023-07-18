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

import com.unionhole.zparser.parser.Operator;
import com.unionhole.zparser.function.BaseFunction;
import com.unionhole.zparser.function.FunctionConstants;
import com.unionhole.zparser.function.FunctionException;
import com.unionhole.zparser.function.FunctionResult;

/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class ExpressionTree {

	private Object leftOperand = null;

	private Object rightOperand = null;

	private Operator operator = null;

	private Operator unaryOperator = null;

	private ExecutionCenter executionCenter = null;

	public ExpressionTree(final ExecutionCenter executionCenter, final Object leftOperand,
						  final Object rightOperand, final Operator operator,
						  final Operator unaryOperator) {

		this.executionCenter = executionCenter;
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
		this.unaryOperator = unaryOperator;
	}

	public Object getLeftOperand() {
		return leftOperand;
	}

	public Object getRightOperand() {
		return rightOperand;
	}

	public Operator getOperator() {
		return operator;
	}

	public Operator getUnaryOperator() {
		return unaryOperator;
	}


	public String execute(final boolean wrapStringFunctionResults)
			throws ExecutionException {

		String rtnResult = null;

		// Get the left operand.
		String leftResultString = null;
		Double leftResultDouble = null;

		if (leftOperand instanceof ExpressionTree) {
			leftResultString = ((ExpressionTree) leftOperand)
					.execute(wrapStringFunctionResults);

			try {
				leftResultDouble = new Double(leftResultString);
				leftResultString = null;
			} catch (NumberFormatException exception) {
				leftResultDouble = null;
			}
		} else if (leftOperand instanceof ExpressionOperand) {

			final ExpressionOperand leftExpressionOperand = (ExpressionOperand) leftOperand;

			leftResultString = leftExpressionOperand.getValue();
			leftResultString = executionCenter.replaceVariables(leftResultString);

			if (!executionCenter.isExpressionString(leftResultString)) {
				try {
					leftResultDouble = new Double(leftResultString);
					leftResultString = null;
				} catch (NumberFormatException nfe) {
					throw new ExecutionException("表达式无效", nfe);
				}

				if (leftExpressionOperand.getUnaryOperator() != null) {
					leftResultDouble = new Double(leftExpressionOperand
							.getUnaryOperator().execute(
									leftResultDouble.doubleValue()));
				}
			} else {
				if (leftExpressionOperand.getUnaryOperator() != null) {
					throw new ExecutionException("一元运算符的操作数无效\n" +
							"\n");
				}
			}
		} else if (leftOperand instanceof ParsedFunction) {

			final ParsedFunction parsedFunction = (ParsedFunction) leftOperand;
			final BaseFunction baseFunction = parsedFunction.getBaseFunction();
			String arguments = parsedFunction.getArguments();
			arguments = executionCenter.replaceVariables(arguments);
			
			if (executionCenter.getProcessNestedFunctions()) {
				arguments = executionCenter.processNestedFunctions(arguments);
			}

			try {
				FunctionResult functionResult =
					baseFunction.execute(executionCenter, arguments);
				leftResultString = functionResult.getResult();

				if (functionResult.getType() == 
					FunctionConstants.FUNCTION_RESULT_TYPE_MATH) {
					
					Double resultDouble = new Double(leftResultString);

					if (parsedFunction.getUnaryOperator() != null) {
						resultDouble = new Double(parsedFunction
								.getUnaryOperator().execute(
										resultDouble.doubleValue()));
					}

					leftResultString = resultDouble.toString();
				} 
				else if (functionResult.getType() == 
					FunctionConstants.FUNCTION_RESULT_TYPE_STRING) {
					
					if (wrapStringFunctionResults) {
						leftResultString = executionCenter.getQuoteCharacter()
								+ leftResultString
								+ executionCenter.getQuoteCharacter();
					}

					if (parsedFunction.getUnaryOperator() != null) {
						throw new ExecutionException("一元运算符的操作数无效\n" +
								"\n");
					}
				}
			} catch (FunctionException fe) {
				throw new ExecutionException(fe.getMessage(), fe);
			}

			if (!executionCenter.isExpressionString(leftResultString)) {
				try {
					leftResultDouble = new Double(leftResultString);
					leftResultString = null;
				} catch (NumberFormatException nfe) {
					throw new ExecutionException("表达式无效", nfe);
				}
			}
		} else {
			if (leftOperand != null) {
				throw new ExecutionException("表达式无效");
			}
		}

		String rightResultString = null;
		Double rightResultDouble = null;

		if (rightOperand instanceof ExpressionTree) {
			rightResultString = ((ExpressionTree) rightOperand)
					.execute(wrapStringFunctionResults);

			try {
				rightResultDouble = new Double(rightResultString);
				rightResultString = null;
			} catch (NumberFormatException exception) {
				rightResultDouble = null;
			}

		} else if (rightOperand instanceof ExpressionOperand) {

			final ExpressionOperand rightExpressionOperand = (ExpressionOperand) rightOperand;
			rightResultString = ((ExpressionOperand) rightOperand).getValue();
			rightResultString = executionCenter.replaceVariables(rightResultString);

			if (!executionCenter.isExpressionString(rightResultString)) {
				try {
					rightResultDouble = new Double(rightResultString);
					rightResultString = null;
				} catch (NumberFormatException nfe) {
					throw new ExecutionException("表达式无效", nfe);
				}

				if (rightExpressionOperand.getUnaryOperator() != null) {
					rightResultDouble = new Double(rightExpressionOperand
							.getUnaryOperator().execute(
									rightResultDouble.doubleValue()));
				}
			} else {
				if (rightExpressionOperand.getUnaryOperator() != null) {
					throw new ExecutionException("一元运算符的操作数无效\n" +
							"\n");
				}
			}
		} else if (rightOperand instanceof ParsedFunction) {

			final ParsedFunction parsedFunction = (ParsedFunction) rightOperand;
			final BaseFunction baseFunction = parsedFunction.getBaseFunction();
			String arguments = parsedFunction.getArguments();
			arguments = executionCenter.replaceVariables(arguments);
			
			if (executionCenter.getProcessNestedFunctions()) {
				arguments = executionCenter.processNestedFunctions(arguments);
			}

			try {				
				FunctionResult functionResult = 
					baseFunction.execute(executionCenter, arguments);
				rightResultString = functionResult.getResult();

				if (functionResult.getType() == 
					FunctionConstants.FUNCTION_RESULT_TYPE_MATH) {
					
					Double resultDouble = new Double(rightResultString);

					if (parsedFunction.getUnaryOperator() != null) {
						resultDouble = new Double(parsedFunction
								.getUnaryOperator().execute(
										resultDouble.doubleValue()));
					}

					rightResultString = resultDouble.toString();
				}
				else if (functionResult.getType() == 
					FunctionConstants.FUNCTION_RESULT_TYPE_STRING) {
					
					if (wrapStringFunctionResults) {
						rightResultString = executionCenter.getQuoteCharacter()
								+ rightResultString
								+ executionCenter.getQuoteCharacter();
					}

					if (parsedFunction.getUnaryOperator() != null) {
						throw new ExecutionException("一元运算符的操作数无效\n" +
								"\n");
					}
				}
			} catch (FunctionException fe) {
				throw new ExecutionException(fe.getMessage(), fe);
			}

			if (!executionCenter.isExpressionString(rightResultString)) {
				try {
					rightResultDouble = new Double(rightResultString);
					rightResultString = null;
				} catch (NumberFormatException nfe) {
					throw new ExecutionException("表达式无效", nfe);
				}
			}
		} else if (rightOperand == null) {
		} else {
			throw new ExecutionException("表达式无效");
		}

		if (leftResultDouble != null && rightResultDouble != null) {
			double doubleResult = operator.execute(leftResultDouble
					.doubleValue(), rightResultDouble.doubleValue());

			if (getUnaryOperator() != null) {
				doubleResult = getUnaryOperator().execute(doubleResult);
			}

			rtnResult = new Double(doubleResult).toString();
		} else if (leftResultString != null && rightResultString != null) {
			rtnResult = operator.execute(leftResultString, rightResultString);
		} else if (leftResultDouble != null && rightResultDouble == null) {
			double doubleResult = -1;

			if (unaryOperator != null) {
				doubleResult = unaryOperator.execute(leftResultDouble
						.doubleValue());
			} else {
				throw new ExecutionException("表达式无效");
			}

			rtnResult = new Double(doubleResult).toString();
		} else {
			throw new ExecutionException("表达式无效");
		}

		return rtnResult;
	}
}