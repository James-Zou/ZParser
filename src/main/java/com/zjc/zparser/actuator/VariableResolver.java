package com.zjc.zparser.actuator;


import com.zjc.zparser.function.FunctionException;
/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public interface VariableResolver {

    public String resolveVariable(String variableName) throws FunctionException;
}