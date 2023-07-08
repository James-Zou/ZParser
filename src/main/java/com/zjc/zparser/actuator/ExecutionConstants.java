package com.zjc.zparser.actuator;

/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class ExecutionConstants {


	public static final char SINGLE_QUOTE = '\'';


	public static final char DOUBLE_QUOTE = '"';


	public static final char OPEN_BRACE = '{';


	public static final char CLOSED_BRACE = '}';


	public static final char POUND_SIGN = '#';


	public static final String OPEN_VARIABLE = String.valueOf(POUND_SIGN)
			+ String.valueOf(OPEN_BRACE);


	public static final String CLOSED_VARIABLE = String.valueOf(CLOSED_BRACE);


	public static final String BOOLEAN_STRING_TRUE = "1.0";


	public static final String BOOLEAN_STRING_FALSE = "0.0";
	

	public static final char COMMA = ',';
	

	public static final char FUNCTION_ARGUMENT_SEPARATOR = COMMA;
}
