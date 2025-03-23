package examples;

import com.unionhole.zparser.ExecutionCenter;

/**
 * ZParser 逻辑运算示例
 * 展示逻辑函数的使用
 */
public class LogicExample {
    public static void main(String[] args) {
        // 获取计算引擎实例
        ExecutionCenter eval = ExecutionCenter.getInstance();

        // 基础逻辑运算
        System.out.println("=== 基础逻辑运算 ===");
        boolean and = eval.getBooleanResult("AND(1==1, 2<3)");
        System.out.println("AND运算: " + and);

        boolean or = eval.getBooleanResult("OR(1!=1, 2>3)");
        System.out.println("OR运算: " + or);

        // 条件判断
        System.out.println("\n=== 条件判断 ===");
        String if1 = eval.getStringResult("IF(1==2, '相同', '不相同')");
        System.out.println("IF判断1: " + if1);

        String if2 = eval.getStringResult("IF(100>50, '大于', '小于')");
        System.out.println("IF判断2: " + if2);

        // 空值处理
        System.out.println("\n=== 空值处理 ===");
        String ifblank1 = eval.getStringResult("IFBLANK('', '默认值')");
        System.out.println("IFBLANK空值: " + ifblank1);

        String ifblank2 = eval.getStringResult("IFBLANK('有值', '默认值')");
        System.out.println("IFBLANK非空: " + ifblank2);

        // 包含判断
        System.out.println("\n=== 包含判断 ===");
        boolean contain1 = eval.getBooleanResult("CONTAIN('Bob is a boy', 'boy')");
        System.out.println("CONTAIN判断1: " + contain1);

        boolean contain2 = eval.getBooleanResult("CONTAIN('Hello World', 'hi')");
        System.out.println("CONTAIN判断2: " + contain2);

        // 复杂逻辑组合
        System.out.println("\n=== 复杂逻辑组合 ===");
        boolean complex1 = eval.getBooleanResult("AND(OR(1>0, 2<1), NOT(5==6))");
        System.out.println("复杂逻辑1: " + complex1);

        String complex2 = eval.getStringResult("IF(AND(1>0, 2>1), IF(3>2, '条件1成立', '条件1不成立'), '条件2不成立')");
        System.out.println("复杂逻辑2: " + complex2);

        // 数值比较
        System.out.println("\n=== 数值比较 ===");
        boolean compare1 = eval.getBooleanResult("100 > 50 AND 200 <= 300");
        System.out.println("数值比较1: " + compare1);

        boolean compare2 = eval.getBooleanResult("2 * 3 == 6 OR 10 % 3 == 0");
        System.out.println("数值比较2: " + compare2);
    }
} 