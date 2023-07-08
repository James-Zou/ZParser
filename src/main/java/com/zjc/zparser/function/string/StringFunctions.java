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

package com.zjc.zparser.function.string;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
 */
public class StringFunctions implements FunctionGroup {
	private List functions = new ArrayList();
	public StringFunctions() {
		functions.add(new CharAtFunction());
		functions.add(new CompareToFunction());
		functions.add(new CompareToIgnoreCaseFunction());
		functions.add(new ConcatFunction());
		functions.add(new EndsWithFunction());
		functions.add(new EqualsFunction());
		functions.add(new EqualsIgnoreCaseFunction());
		functions.add(new EvalFunction());
		functions.add(new IndexOfFunction());
		functions.add(new LastIndexOfFunction());
		functions.add(new LengthFunction());
		functions.add(new ReplaceFunction());
		functions.add(new StartsWithFunction());
		functions.add(new SubstringFunction());
		functions.add(new ToLowerCaseFunction());
		functions.add(new ToUpperCaseFunction());
		functions.add(new TrimFunction());
	}

	public String getName() {
		return "字符串函数";
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
