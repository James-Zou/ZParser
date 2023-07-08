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

package com.zjc.zparser.function.logic;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionGroup;
import com.zjc.zparser.function.string.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class LogicFunctions implements FunctionGroup {
	private List functions = new ArrayList();
	public LogicFunctions() {
		functions.add(new IFFunction());
		functions.add(new ANDFunction());
		functions.add(new CONTAINFunction());
		functions.add(new IFBLANKFunction());
		functions.add(new ORFunction());
	}

	@Override
	public String getName() {
		return "逻辑函数";
	}

	@Override
	public List getFunctions() {
		return functions;
	}

	@Override
	public void load(final ExecutionCenter executionCenter) {
		Iterator functionIterator = functions.iterator();

		while (functionIterator.hasNext()) {
			executionCenter.putFunction((BaseFunction) functionIterator.next());
		}
	}

	@Override
	public void unload(final ExecutionCenter executionCenter) {
		Iterator functionIterator = functions.iterator();

		while (functionIterator.hasNext()) {
			executionCenter.removeFunction(((BaseFunction) functionIterator.next())
					.getName());
		}
	}
}
