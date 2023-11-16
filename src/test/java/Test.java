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
import com.unionhole.zparser.actuator.ExecutionException;
import com.unionhole.zparser.actuator.ExecutionCenter;

/**
 * @author James.Zou
 * @Description:
 * @date 6/6/23 3:50 PM
 */
public class Test {

    public static void main(String[] args) throws ExecutionException {
//        for(int i=0;i<100000;i++) {
            ExecutionCenter eval = ExecutionCenter.getInstance();
            System.out.println(eval.getNumberResult("2*3-5/(3-1)+9-1*22+222-22"));
            System.out.println(eval.getNumberResult("(2*0.3)+(3*0.4)+(0.2*2)"));
            System.out.println(eval.execute("7 / 2"));
            System.out.println(eval.getIntResult("7 % 2"));
            System.out.println(eval.execute("((4.11 + 3) * -2) * 3"));
            System.out.println(eval.execute("ABS(-10)"));
            System.out.println(eval.execute("FLOOR(-10.12)"));
            System.out.println(eval.execute("CEIL(10.12)"));
            System.out.println(eval.execute("SQRT(10)"));
            System.out.println(eval.execute("EXP(2)"));
            System.out.println(eval.execute("MAX(MAX(2,3),5)"));
            System.out.println(eval.execute("MIN(2,3)"));
            System.out.println(eval.execute("POW(2,3)"));
            System.out.println("eval.execute(min(max(2,3),1))=" + eval.execute("MIN(MAX(2,3),1)+3"));
            String equation = "$(字段编码1)=MAX($(字段编码2),$(字段编码3))";
            System.out.println(eval.execute("LOWERCASE('SDFldddDS')"));
            System.out.println(eval.execute("IF(1>=2,'一般变更','重大变更')"));
            System.out.println("" + eval.getBooleanResult("1<=2"));
            System.out.println(eval.execute("SUM(1*0.30,2*0.90,3*1)"));
            System.out.println(eval.execute("SIN(30)"));
            System.out.println(Math.sin(Double.valueOf(30.0)));
            System.out.println("fsdaf bfsd".trim());
            System.out.println(eval.execute("AND(1==1,2<3)"));
            System.out.println(eval.execute("CONTAIN('Bob is a boy','2','boy')"));
            System.out.println(eval.execute("IFBLANK('Bob is a boy','2')"));
            System.out.println(eval.execute("OR(1!=1,2>3)"));
            System.out.println(eval.execute("NEXTDAY()"));
            System.out.println(eval.execute("NEXTDAYTIME()"));
            System.out.println(eval.execute("CURRENTDAY()"));
            System.out.println(eval.execute("CURRENTDAYTIME()"));
            System.out.println(eval.execute("GETDAY(-2)"));
            System.out.println(eval.execute("GETDAYTIME(-2)"));
            System.out.println(eval.execute("TIMEMILLIS(-2)"));
            System.out.println(eval.execute("CURRENTWEEK()"));
            System.out.println(eval.execute("WEEK(1)"));
            System.out.println(eval.execute("SEASONSTARTDATE('2023-07-08 15:11:01')"));
            System.out.println(eval.execute("SEASONENDDATE('2023-07-08 15:11:01')"));
            System.out.println(eval.execute("MONTHSTARTDATE()"));
            System.out.println(eval.execute("MONTHENDDATE()"));
            System.out.println(eval.execute("DAY('2023-07-30',-1)"));
            System.out.println(eval.execute("DAY(CURRENTDAY(),1)"));
            System.out.println(eval.execute("DAYMILLIS(CURRENTDAYTIME(),1)"));
            System.out.println(eval.execute("DAYM(1689042334000,1)"));
            System.out.println(eval.execute("DAYMILLISM(1689042334000,1)"));
            System.out.println(eval.execute("DAYS('2023-07-08','2023-07-10')"));
            System.out.println(eval.execute("DAYMS('2023-07-08  15:11:01','2023-07-10  05:11:01')"));
            System.out.println(eval.execute("DAYTS(1689042334000,1689387934000)"));
            //算式一：$(总得分字段编码)=SUM($(变更影响字段编码)*0.20,$(服务不可用字段编码)*0.35,$(成功率字段编码)*0.25,$(回退时间字段编码)*0.10,$(复杂程度字段编码)*0.10)
            //
            //算式二：$(变更类型字段编码)=IF($(总得分字段编码)<=2,"一般变更"，"重大变更")
            System.out.println(eval.execute("DAYMILLISMP(1697436777193,20,'M')"));
            System.out.println(eval.execute("DAYTSP(1699515284116,1699516785949,'M','0')"));
            System.out.println(eval.execute("DAYTSP(1699515284116,1699516785949,'MI','0')"));
            System.out.println(eval.execute("DATEFORMAT(1700104866156,'yyyy-MM-dd','0')"));
            System.out.println(eval.execute("DATEFORMAT(1501833,'D天H小时M分钟S秒','1')"));
            System.out.println(eval.execute("PARSEINT('1501833')"));

//        }
  }
}
