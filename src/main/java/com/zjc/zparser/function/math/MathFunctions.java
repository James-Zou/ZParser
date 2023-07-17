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

package com.zjc.zparser.function.math;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class MathFunctions implements FunctionGroup {
	private List functions = new ArrayList();

	public MathFunctions() {
		functions.add(new AbsFunction());
		functions.add(new AcosFunction());
		functions.add(new AsinFunction());
		functions.add(new AtanFunction());
		functions.add(new Atan2Function());
		functions.add(new CeilFunction());
		functions.add(new CosFunction());
		functions.add(new ExpFunction());
		functions.add(new FloorFunction());
		functions.add(new LogFunction());
		functions.add(new MaxFunction());
		functions.add(new MinFunction());
		functions.add(new PowFunction());
		functions.add(new RandomFunction());
		functions.add(new SinFunction());
		functions.add(new SqrtFunction());
		functions.add(new TanFunction());
		functions.add(new SumFunction());
	}

	public String getName() {
		return "数学函数";
	}

	public List getFunctions() {
		return functions;
	}

	public void load(final ExecutionCenter executionCenter) {
		Iterator functionIterator = functions.iterator();

		while (functionIterator.hasNext()) {
			executionCenter.putFunction((BaseFunction) functionIterator.next());
		}
	}

	public void unload(final ExecutionCenter executionCenter) {
		Iterator functionIterator = functions.iterator();

		while (functionIterator.hasNext()) {
			executionCenter.removeFunction(((BaseFunction) functionIterator.next())
					.getName());
		}
	}
}
