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

package com.zjc.zparser.function.date;

import com.zjc.zparser.actuator.ExecutionCenter;
import com.zjc.zparser.function.BaseFunction;
import com.zjc.zparser.function.FunctionGroup;
import com.zjc.zparser.function.logic.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class DateFunctions implements FunctionGroup {
	private List functions = new ArrayList();
	public DateFunctions() {
		functions.add(new NEXTDAYFunction());
		functions.add(new CURRENTDAYFunction());
		functions.add(new GETDAYFunction());
		functions.add(new GETDAYTIMEFunction());
		functions.add(new TIMEMILLISFunction());
		functions.add(new WEEKFunction());
		functions.add(new CURRENTWEEKFunction());
		functions.add(new NEXTDAYTIMEFunction());
		functions.add(new CURRENTDAYTIMEFunction());
		functions.add(new SEASONSTARTDATEFunction());
		functions.add(new SEASONENDDATEFunction());
		functions.add(new MONTHSTARTDATEFunction());
		functions.add(new MONTHENDDATEFunction());
		functions.add(new DAYFunction());
		functions.add(new DAYMILLISFunction());
		functions.add(new DAYMILLISMFunction());
		functions.add(new DAYMFunction());
		functions.add(new DAYSFunction());
		functions.add(new DAYMSFunction());
		functions.add(new DAYTSFunction());
	}

	@Override
	public String getName() {
		return "日期函数";
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
