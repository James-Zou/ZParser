/*
 * Copyright 2023 James Zou.
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
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */

public class NextOperator {

	private Operator operator = null;

	private int index = -1;


	public NextOperator(final Operator operator, final int index) {
		this.operator = operator;
		this.index = index;
	}


	public Operator getOperator() {
		return operator;
	}


	public int getIndex() {
		return index;
	}
}