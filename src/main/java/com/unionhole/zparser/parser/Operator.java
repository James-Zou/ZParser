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
public interface Operator {


	public abstract double execute(double leftOperand, double rightOperand);


	public abstract String execute(final String leftOperand,
                                    final String rightOperand) throws ExecutionException, ExecutionException;


	public abstract double execute(final double operand);


	public abstract String getSymbol();


	public abstract int getPrecedence();


	public abstract int getLength();


	public abstract boolean isUnary();
}