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



import com.zjc.zparser.function.*;
import com.zjc.zparser.function.logic.LogicFunctions;
import com.zjc.zparser.function.math.MathFunctions;
import com.zjc.zparser.function.string.StringFunctions;
import com.zjc.zparser.parser.*;
import com.zjc.zparser.parser.*;

import java.util.*;
/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */

public class ExecutionCenter {

	private List operators = new ArrayList();

	private Map functions = new HashMap();

	private Map variables = new HashMap();

	private char quoteCharacter = ExecutionConstants.SINGLE_QUOTE;

	private Operator openParenthesesOperator = new OpenParenthesesOperator();

	private Operator closedParenthesesOperator = new ClosedParenthesesOperator();

	private boolean loadMathVariables;

	private boolean loadMathFunctions;

	private boolean loadStringFunctions;

	private boolean loadLogicFunctions;

	private boolean processNestedFunctions;

	private String previousExpression = null;

	private Stack previousOperatorStack = null;

	private Stack previousOperandStack = null;

	private Stack operatorStack = null;

	private Stack operandStack = null;
	
	private VariableResolver variableResolver = null;



	private ExecutionCenter() {
		this(ExecutionConstants.SINGLE_QUOTE, true, true, true, true,true);
	}

	private ExecutionCenter(final char quoteCharacter,
						   final boolean loadMathVariables, final boolean loadMathFunctions,
						   final boolean loadStringFunctions,final boolean loadLogicFunctions,
						   final boolean processNestedFunctions) {

		installOperators();

		this.loadMathVariables = loadMathVariables;
		loadSystemVariables();

		this.loadMathFunctions = loadMathFunctions;
		this.loadStringFunctions = loadStringFunctions;
		this.loadLogicFunctions=loadLogicFunctions;
		loadSystemFunctions();

		setQuoteCharacter(quoteCharacter);

		this.processNestedFunctions = processNestedFunctions;
	}

	private static class SingletonHolder{
		private static final ExecutionCenter INSTANCE = new ExecutionCenter();
	}

	public static ExecutionCenter getInstance(){
		return SingletonHolder.INSTANCE;
	}

	public char getQuoteCharacter() {
		return quoteCharacter;
	}

	public void setQuoteCharacter(final char quoteCharacter) {
		if (quoteCharacter == ExecutionConstants.SINGLE_QUOTE
				|| quoteCharacter == ExecutionConstants.DOUBLE_QUOTE) {
			this.quoteCharacter = quoteCharacter;
		} else {
			throw new IllegalArgumentException("无效的引号字符");
		}
	}

	public void putFunction(final BaseFunction baseFunction) {
		isValidName(baseFunction.getName());

		final BaseFunction existingBaseFunction = (BaseFunction) functions.get(baseFunction
				.getName());

		if (existingBaseFunction == null) {
			functions.put(baseFunction.getName(), baseFunction);
		} else {
			throw new IllegalArgumentException("具有相同名称的函数已存在");
		}
	}

	public BaseFunction getFunction(final String functionName) {
		return (BaseFunction) functions.get(functionName);
	}

	public void removeFunction(final String functionName) {
		if (functions.containsKey(functionName)) {
			functions.remove(functionName);
		} else {
			throw new IllegalArgumentException("函数不存在");
		}
	}

	public void clearFunctions() {
		functions.clear();

		loadSystemFunctions();
	}
	
	public Map getFunctions() {
		return functions;
	}
	
	public void setFunctions(Map functions) {
		this.functions = functions;
	}

	public void putVariable(final String variableName,
			final String variableValue) {
		isValidName(variableName);

		variables.put(variableName, variableValue);
	}

	public String getVariableValue(final String variableName)
			throws ExecutionException {

		String variableValue = null;

		if (variableResolver != null) {

			try {
				variableValue = variableResolver.resolveVariable(variableName);
			} catch (Exception fe) {
				throw new ExecutionException(fe.getMessage(), fe);
			}
		}

		if (variableValue == null) {

			variableValue = (String) variables.get(variableName);
		}

		if (variableValue == null) {

			throw new ExecutionException(
					"无法解析名称等于的变量\""
							+ variableName + "\".");
		}

		return variableValue;
	}

	public void removeVaraible(final String variableName) {
		if (variables.containsKey(variableName)) {
			variables.remove(variableName);
		} else {
			throw new IllegalArgumentException("变量不存在");
		}
	}

	public void clearVariables() {
		variables.clear();

		loadSystemVariables();
	}
	
	public Map getVariables() {
		return variables;
	}
	
	public void setVariables(Map variables) {
		this.variables = variables;
	}	
	
	public VariableResolver getVariableResolver() {
		return variableResolver;
	}

	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}

	public String execute(final String expression) throws ExecutionException {
		return execute(expression, true, true);
	}

	public String execute() throws ExecutionException {
		final String expression = previousExpression;

		if (expression == null || expression.length() == 0) {
			throw new ExecutionException("未指定任何表达式");
		}

		return execute(expression, true, true);
	}

	public String execute(final String expression, final boolean keepQuotes,
			final boolean wrapStringFunctionResults) throws ExecutionException {

		parse(expression);

		String result = getResult(operatorStack, operandStack,
				wrapStringFunctionResults);

		if (isExpressionString(result) && !keepQuotes) {
			result = result.substring(1, result.length() - 1);
		}

		return result;
	}

	public String execute(final boolean keepQuotes,
			final boolean wrapStringFunctionResults) throws ExecutionException {

		final String expression = previousExpression;

		if (expression == null || expression.length() == 0) {
			throw new ExecutionException("未指定任何表达式");
		}

		return execute(expression, keepQuotes, wrapStringFunctionResults);
	}

	public boolean getBooleanResult(final String expression)
			throws ExecutionException {

		final String result = execute(expression);

		try {
			Double doubleResult = new Double(result);

			if (doubleResult.doubleValue() == 1.0) {
				return true;
			}
		} catch (NumberFormatException exception) {
			return false;
		}

		return false;
	}

	public double getNumberResult(final String expression)
			throws ExecutionException {

		final String result = execute(expression);
		Double doubleResult = null;

		try {
			doubleResult = new Double(result);
		} catch (NumberFormatException nfe) {
			throw new ExecutionException(
					"表达式不产生数字", nfe);
		}

		return doubleResult.doubleValue();
	}

	public int getIntResult(final String expression)
			throws ExecutionException {

		final String result = execute(expression);
		Integer integerResult = null;

		try {
			integerResult = new Integer(result.substring(0,result.indexOf(".")));
		} catch (NumberFormatException nfe) {
			throw new ExecutionException(
					"表达式不产生数字", nfe);
		}

		return integerResult.intValue();
	}

	public void parse(final String expression) throws ExecutionException {

		boolean parse = true;
		if (!expression.equals(previousExpression)) {
			previousExpression = expression;
		} else {
			parse = false;
			operatorStack = (Stack) previousOperatorStack.clone();
			operandStack = (Stack) previousOperandStack.clone();
		}

		try {
			if (parse) {
				operandStack = new Stack();
				operatorStack = new Stack();

				boolean haveOperand = false;
				boolean haveOperator = false;
				Operator unaryOperator = null;

				int numChars = expression.length();
				int charCtr = 0;

				while (charCtr < numChars) {
					Operator operator = null;
					int operatorIndex = -1;

					if (ExecutionHelper.isSpace(expression.charAt(charCtr))) {
						charCtr++;
						continue;
					}

					NextOperator nextOperator = getNextOperator(expression,
							charCtr, null);

					if (nextOperator != null) {
						operator = nextOperator.getOperator();
						operatorIndex = nextOperator.getIndex();
					}

					if (operatorIndex > charCtr || operatorIndex == -1) {
						charCtr = processOperand(expression, charCtr,
								operatorIndex, operandStack, unaryOperator);

						haveOperand = true;
						haveOperator = false;
						unaryOperator = null;
					}

					if (operatorIndex == charCtr) {
						if (nextOperator.getOperator().isUnary()
								&& (haveOperator || charCtr == 0)) {
							charCtr = processUnaryOperator(operatorIndex,
									nextOperator.getOperator());

							if (unaryOperator == null) {
								unaryOperator = nextOperator.getOperator();
							} else {
								throw new ExecutionException(
										"不允许连续使用一元运算符（索引="
												+ charCtr + ").");
							}
						} else {
							charCtr = processOperator(expression,
									operatorIndex, operator, operatorStack,
									operandStack, haveOperand, unaryOperator);

							unaryOperator = null;
						}

						if (!(nextOperator.getOperator() instanceof ClosedParenthesesOperator)) {
							haveOperand = false;
							haveOperator = true;
						}
					}
				}

				previousOperatorStack = (Stack) operatorStack.clone();
				previousOperandStack = (Stack) operandStack.clone();
			}
		} catch (Exception e) {
			previousExpression = "";

			throw new ExecutionException(e.getMessage(), e);
		}
	}

	private void installOperators() {
		operators.add(openParenthesesOperator);
		operators.add(closedParenthesesOperator);
		operators.add(new AdditionOperator());
		operators.add(new SubtractionOperator());
		operators.add(new MultiplicationOperator());
		operators.add(new DivisionOperator());
		operators.add(new EqualOperator());
		operators.add(new NotEqualOperator());

		operators.add(new LessThanOrEqualOperator()); // Length of 2.
		operators.add(new LessThanOperator()); // Length of 1.
		operators.add(new GreaterThanOrEqualOperator()); // Length of 2.
		operators.add(new GreaterThanOperator()); // Length of 1.

		operators.add(new BooleanAndOperator());
		operators.add(new BooleanOrOperator());
		operators.add(new BooleanNotOperator());
		operators.add(new ModulusOperator());
	}

	private int processOperand(final String expression, final int charCtr,
			final int operatorIndex, final Stack operandStack,
			final Operator unaryOperator) throws ExecutionException {

		String operandString = null;
		int rtnCtr = -1;

		if (operatorIndex == -1) {
			operandString = expression.substring(charCtr).trim();
			rtnCtr = expression.length();
		} else {
			operandString = expression.substring(charCtr, operatorIndex).trim();
			rtnCtr = operatorIndex;
		}

		if (operandString.length() == 0) {
			throw new ExecutionException("表达式不合理");
		}

		final ExpressionOperand operand = new ExpressionOperand(operandString,
				unaryOperator);
		operandStack.push(operand);

		return rtnCtr;
	}

	private int processOperator(final String expression,
			final int originalOperatorIndex, final Operator originalOperator,
			final Stack operatorStack, final Stack operandStack,
			final boolean haveOperand, final Operator unaryOperator)
			throws ExecutionException {

		int operatorIndex = originalOperatorIndex;
		Operator operator = originalOperator;

		if (haveOperand && operator instanceof OpenParenthesesOperator) {
			NextOperator nextOperator = processFunction(expression,
					operatorIndex, operandStack);

			operator = nextOperator.getOperator();
			operatorIndex = nextOperator.getIndex() + operator.getLength();

			nextOperator = getNextOperator(expression, operatorIndex, null);

			if (nextOperator != null) {
				operator = nextOperator.getOperator();
				operatorIndex = nextOperator.getIndex();
			} else {
				return operatorIndex;
			}
		}

		if (operator instanceof OpenParenthesesOperator) {
			final ExpressionOperator expressionOperator = new ExpressionOperator(
					operator, unaryOperator);
			operatorStack.push(expressionOperator);
		} else if (operator instanceof ClosedParenthesesOperator) {
			ExpressionOperator stackOperator = null;

			if (operatorStack.size() > 0) {
				stackOperator = (ExpressionOperator) operatorStack.peek();
			}

			while (stackOperator != null
					&& !(stackOperator.getOperator() instanceof OpenParenthesesOperator)) {
				processTree(operandStack, operatorStack);

				if (operatorStack.size() > 0) {
					stackOperator = (ExpressionOperator) operatorStack.peek();
				} else {
					stackOperator = null;
				}
			}

			if (operatorStack.isEmpty()) {
				throw new ExecutionException("表达式无效");
			}

			final ExpressionOperator expressionOperator = (ExpressionOperator) operatorStack
					.pop();

			if (!(expressionOperator.getOperator() instanceof OpenParenthesesOperator)) {
				throw new ExecutionException("表达式无效");
			}

			if (expressionOperator.getUnaryOperator() != null) {
				Object operand = operandStack.pop();

				ExpressionTree tree = new ExpressionTree(this, operand, null,
						null, expressionOperator.getUnaryOperator());

				operandStack.push(tree);
			}
		} else {
			if (operatorStack.size() > 0) {
				ExpressionOperator stackOperator = (ExpressionOperator) operatorStack
						.peek();

				while (stackOperator != null
						&& stackOperator.getOperator().getPrecedence() >= operator
								.getPrecedence()) {
					processTree(operandStack, operatorStack);

					if (operatorStack.size() > 0) {
						stackOperator = (ExpressionOperator) operatorStack
								.peek();
					} else {
						stackOperator = null;
					}
				}
			}

			ExpressionOperator expressionOperator = new ExpressionOperator(
					operator, unaryOperator);

			operatorStack.push(expressionOperator);
		}

		final int rtnCtr = operatorIndex + operator.getLength();

		return rtnCtr;
	}

	private int processUnaryOperator(final int operatorIndex,
			final Operator operator) {

		final int rtnCtr = operatorIndex + operator.getSymbol().length();

		return rtnCtr;
	}

	private NextOperator processFunction(final String expression,
                                         final int operatorIndex, final Stack operandStack)
			throws ExecutionException {

		int parenthesisCount = 1;
		NextOperator nextOperator = null;
		int nextOperatorIndex = operatorIndex;

		// Loop until we find the function's closing parentheses.
		while (parenthesisCount > 0) {
			nextOperator = getNextOperator(expression, nextOperatorIndex + 1,
					null);

			if (nextOperator == null) {
				throw new ExecutionException("函数未关闭");
			} else if (nextOperator.getOperator() instanceof OpenParenthesesOperator) {
				parenthesisCount++;
			} else if (nextOperator.getOperator() instanceof ClosedParenthesesOperator) {
				parenthesisCount--;
			}

			nextOperatorIndex = nextOperator.getIndex();
		}

		String arguments = expression.substring(operatorIndex + 1,
				nextOperatorIndex);

		final ExpressionOperand operand = (ExpressionOperand) operandStack
				.pop();
		final Operator unaryOperator = operand.getUnaryOperator();
		final String functionName = operand.getValue();

		try {
			isValidName(functionName);
		} catch (IllegalArgumentException iae) {
			throw new ExecutionException("函数名无效 \""
					+ functionName + "\".", iae);
		}

		final BaseFunction baseFunction = (BaseFunction) functions.get(functionName);

		if (baseFunction == null) {
			throw new ExecutionException("未定义函数（索引="
					+ operatorIndex + ").");
		}

		final ParsedFunction parsedFunction = new ParsedFunction(baseFunction,
				arguments, unaryOperator);
		operandStack.push(parsedFunction);

		return nextOperator;
	}

	private void processTree(final Stack operandStack, final Stack operatorStack) {

		Object rightOperand = null;
		Object leftOperand = null;
		Operator operator = null;

		if (operandStack.size() > 0) {
			rightOperand = operandStack.pop();
		}

		if (operandStack.size() > 0) {
			leftOperand = operandStack.pop();
		}

		operator = ((ExpressionOperator) operatorStack.pop()).getOperator();

		final ExpressionTree tree = new ExpressionTree(this, leftOperand,
				rightOperand, operator, null);

		operandStack.push(tree);
	}

	private String getResult(final Stack operatorStack,
			final Stack operandStack, final boolean wrapStringFunctionResults)
			throws ExecutionException {

		String resultString = null;

		while (operatorStack.size() > 0) {
			processTree(operandStack, operatorStack);
		}

		if (operandStack.size() != 1) {
			throw new ExecutionException("表达式无效");
		}

		final Object finalOperand = operandStack.pop();

		if (finalOperand instanceof ExpressionTree) {
			resultString = ((ExpressionTree) finalOperand)
					.execute(wrapStringFunctionResults);
		}
		else if (finalOperand instanceof ExpressionOperand) {
			ExpressionOperand resultExpressionOperand = (ExpressionOperand) finalOperand;

			resultString = ((ExpressionOperand) finalOperand).getValue();
			resultString = replaceVariables(resultString);

			if (!isExpressionString(resultString)) {
				Double resultDouble = null;
				try {
					resultDouble = new Double(resultString);
				} catch (Exception e) {
					throw new ExecutionException("表达式无效", e);
				}

				if (resultExpressionOperand.getUnaryOperator() != null) {
					resultDouble = new Double(resultExpressionOperand
							.getUnaryOperator().execute(
									resultDouble.doubleValue()));
				}

				resultString = resultDouble.toString();
			} else {
				if (resultExpressionOperand.getUnaryOperator() != null) {
					throw new ExecutionException("一元运算符的操作数无效");
				}
			}
		} else if (finalOperand instanceof ParsedFunction) {
			final ParsedFunction parsedFunction = (ParsedFunction) finalOperand;
			final BaseFunction baseFunction = parsedFunction.getBaseFunction();
			String arguments = parsedFunction.getArguments();
			
			if (processNestedFunctions) {
				arguments = processNestedFunctions(arguments);
			}
			
			arguments = replaceVariables(arguments);

			try {
				FunctionResult functionResult =
					baseFunction.execute(this, arguments);
				resultString = functionResult.getResult();

				if (functionResult.getType() == 
					FunctionConstants.FUNCTION_RESULT_TYPE_MATH) {
					
					Double resultDouble = new Double(resultString);

					if (parsedFunction.getUnaryOperator() != null) {
						resultDouble = new Double(parsedFunction
								.getUnaryOperator().execute(
										resultDouble.doubleValue()));
					}

					resultString = resultDouble.toString();
				}
				else if (functionResult.getType() == 
					FunctionConstants.FUNCTION_RESULT_TYPE_STRING) {
					
					if (wrapStringFunctionResults) {
						resultString = quoteCharacter + resultString
								+ quoteCharacter;
					}

					if (parsedFunction.getUnaryOperator() != null) {
						throw new ExecutionException("一元运算符的操作数无效\n" +
								"\n");
					}
				}
				else if (functionResult.getType() ==
						FunctionConstants.FUNCTION_RESULT_TYPE_LOGIC) {

					if (wrapStringFunctionResults) {
						resultString = quoteCharacter + resultString
								+ quoteCharacter;
					}

					if (parsedFunction.getUnaryOperator() != null) {
						throw new ExecutionException("一元运算符的操作数无效\n" +
								"\n");
					}
				}
			} catch (FunctionException fe) {
				throw new ExecutionException(fe.getMessage(), fe);
			}
		} else {
			throw new ExecutionException("无效表达式");
		}

		return resultString;
	}

	private NextOperator getNextOperator(final String expression,
                                         final int start, final Operator match) {

		final int numChars = expression.length();
		int numQuoteCharacters = 0;

		for (int charCtr = start; charCtr < numChars; charCtr++) {
			if (expression.charAt(charCtr) == quoteCharacter) {
				numQuoteCharacters++;
			}

			if ((numQuoteCharacters % 2) == 1) {
				continue;
			}

			final int numOperators = operators.size();
			for (int operatorCtr = 0; operatorCtr < numOperators; operatorCtr++) {
				Operator operator = (Operator) operators.get(operatorCtr);

				if (match != null) {
					if (!match.equals(operator)) {
						continue;
					}
				}

				if (operator.getLength() == 2) {
					int endCtr = -1;
					if (charCtr + 2 <= expression.length()) {
						endCtr = charCtr + 2;
					} else {
						endCtr = expression.length();
					}

					if (expression.substring(charCtr, endCtr).equals(
							operator.getSymbol())) {
						NextOperator nextOperator = new NextOperator(operator,
								charCtr);

						return nextOperator;
					}
				} else {
					if (expression.charAt(charCtr) == operator.getSymbol()
							.charAt(0)) {
						NextOperator nextOperator = new NextOperator(operator,
								charCtr);

						return nextOperator;
					}
				}
			}
		}

		return null;
	}

	protected boolean isExpressionString(final String expressionString)
			throws ExecutionException {

		if (expressionString.length() > 1
				&& expressionString.charAt(0) == quoteCharacter
				&& expressionString.charAt(expressionString.length() - 1) == quoteCharacter) {
			return true;
		}

		if (expressionString.indexOf(quoteCharacter) >= 0) {
			throw new ExecutionException("引号的使用无效");
		}

		return false;
	}

	public void isValidName(final String name) throws IllegalArgumentException {

		if (name.length() == 0) {
			throw new IllegalArgumentException("变量为空");
		}

		final char firstChar = name.charAt(0);
		if (firstChar >= '0' && firstChar <= '9') {
			throw new IllegalArgumentException("变量或函数名称不能以数字开头。\n" +
					"\n");
		}

		if (name.indexOf(ExecutionConstants.SINGLE_QUOTE) > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含引号字符\n" +
					"\n");
		} else if (name.indexOf(ExecutionConstants.DOUBLE_QUOTE) > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含引号字符");
		}

		if (name.indexOf(ExecutionConstants.OPEN_BRACE) > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含大括号字符\n" +
					"\n");
		} else if (name.indexOf(ExecutionConstants.CLOSED_BRACE) > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含大括号字符\n" +
					"\n");
		} else if (name.indexOf(ExecutionConstants.POUND_SIGN) > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含磅符号字符\n" +
					"\n");
		}

		final Iterator operatorIterator = operators.iterator();

		while (operatorIterator.hasNext()) {
			final Operator operator = (Operator) operatorIterator.next();

			if (name.indexOf(operator.getSymbol()) > -1) {
				throw new IllegalArgumentException(
						"变量或函数名称不能包含运算符符号\n" +
								"\n");
			}
		}

		if (name.indexOf("!") > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含特殊字符\n" +
					"\n");
		} else if (name.indexOf("~") > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含特殊字符\n" +
					"\n");
		} else if (name.indexOf("^") > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含特殊字符\n" +
					"\n");
		} else if (name.indexOf(",") > -1) {
			throw new IllegalArgumentException("变量或函数名称不能包含特殊字符\n" +
					"\n");
		}
	}

	private void loadSystemFunctions() {
		if (loadMathFunctions) {
			final FunctionGroup mathFunctions = (FunctionGroup) new MathFunctions();

			mathFunctions.load(this);
		}

		if (loadStringFunctions) {
			final FunctionGroup stringFunctions = (FunctionGroup) new StringFunctions();

			stringFunctions.load(this);
		}

		if (loadLogicFunctions) {
			final FunctionGroup logicFunctions = (FunctionGroup) new LogicFunctions();

			logicFunctions.load(this);
		}
	}

	private void loadSystemVariables() {
		if (loadMathVariables) {
			putVariable("E", new Double(Math.E).toString());
			putVariable("PI", new Double(Math.PI).toString());
		}
	}

	public String replaceVariables(final String expression)
			throws ExecutionException {

		int openIndex = expression.indexOf(ExecutionConstants.OPEN_VARIABLE);

		if (openIndex < 0) {
			return expression;
		}

		String replacedExpression = expression;

		while (openIndex >= 0) {

			int closedIndex = -1;
			if (openIndex >= 0) {

				closedIndex = replacedExpression.indexOf(
						ExecutionConstants.CLOSED_VARIABLE, openIndex + 1);
				if (closedIndex > openIndex) {

					String variableName = replacedExpression.substring(
							openIndex
									+ ExecutionConstants.OPEN_VARIABLE
											.length(), closedIndex);
					
					try {
						isValidName(variableName);
					} catch (IllegalArgumentException iae) {
						throw new ExecutionException("不合理的变量名称 \""
								+ variableName + "\".", iae);
					}
					
					String variableValue = getVariableValue(variableName);

					String variableString = ExecutionConstants.OPEN_VARIABLE
							+ variableName
							+ ExecutionConstants.CLOSED_VARIABLE;

					replacedExpression = ExecutionHelper.replaceAll(
							replacedExpression, variableString, variableValue);
				} else {

					break;
				}
			}

			openIndex = replacedExpression.indexOf(
					ExecutionConstants.OPEN_VARIABLE);
		}

		int openBraceIndex = replacedExpression
				.indexOf(ExecutionConstants.OPEN_VARIABLE);
		if (openBraceIndex > -1) {
			throw new ExecutionException(
					"变量尚未关闭（索引=" + openBraceIndex
							+ ").");
		}

		return replacedExpression;
	}
	
	protected String processNestedFunctions(final String arguments)
			throws ExecutionException {

		StringBuffer executedArguments = new StringBuffer();

		if (arguments.length() > 0) {

			ExecutionCenter argumentsExecutionCenter = new ExecutionCenter(quoteCharacter,
					loadMathVariables, loadMathFunctions, loadStringFunctions,loadLogicFunctions,
					processNestedFunctions);
			argumentsExecutionCenter.setFunctions(getFunctions());
			argumentsExecutionCenter.setVariables(getVariables());
			argumentsExecutionCenter.setVariableResolver(getVariableResolver());

			final ArgumentTokenizer tokenizer = new ArgumentTokenizer(
					arguments, ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);

			List evalautedArgumentList = new ArrayList();
			while (tokenizer.hasMoreTokens()) {

				String argument = tokenizer.nextToken().trim();

				try {
					argument = argumentsExecutionCenter.execute(argument);
				} catch (Exception e) {
					throw new ExecutionException(e.getMessage(), e);
				}

				evalautedArgumentList.add(argument);
			}

			Iterator executedArgumentIterator = evalautedArgumentList
					.iterator();

			while (executedArgumentIterator.hasNext()) {

				if (executedArguments.length() > 0) {

					executedArguments
							.append(ExecutionConstants.FUNCTION_ARGUMENT_SEPARATOR);
				}

				String executedArgument = (String) executedArgumentIterator
						.next();
				executedArguments.append(executedArgument);
			}
		}

		return executedArguments.toString();
	}

	public boolean isLoadMathVariables() {
		return loadMathVariables;
	}

	public boolean getLoadMathFunctions() {
		return loadMathFunctions;
	}

	public boolean getLoadStringFunctions() {
		return loadStringFunctions;
	}

	public boolean getLoadLogicFunctions() {
		return loadLogicFunctions;
	}

	public boolean getProcessNestedFunctions() {
		return processNestedFunctions;
	}
}