import com.zjc.zparser.actuator.ExecutionException;
import com.zjc.zparser.actuator.ExecutionCenter;

/**
 * @author roderick.zou
 * @Description:
 * @date 6/8/23 3:50 PM
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
            //算式一：$(总得分字段编码)=SUM($(变更影响字段编码)*0.20,$(服务不可用字段编码)*0.35,$(成功率字段编码)*0.25,$(回退时间字段编码)*0.10,$(复杂程度字段编码)*0.10)
            //
            //算式二：$(变更类型字段编码)=IF($(总得分字段编码)<=2,"一般变更"，"重大变更")


//        }
  }
}
