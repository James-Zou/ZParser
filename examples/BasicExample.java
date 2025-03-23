package examples;

import com.unionhole.zparser.ExecutionCenter;

/**
 * ZParser 基础计算示例
 * 展示基本的数学运算和函数调用
 */
public class BasicExample {
    public static void main(String[] args) {
        // 获取计算引擎实例
        ExecutionCenter eval = ExecutionCenter.getInstance();

        // 基础数学运算
        System.out.println("=== 基础数学运算 ===");
        double result1 = eval.getNumberResult("2*3-5/(3-1)+9-1*22+222-22");
        System.out.println("复杂表达式计算: " + result1);

        double result2 = eval.getNumberResult("MAX(2, 100)");
        System.out.println("最大值: " + result2);

        double result3 = eval.getNumberResult("MIN(2, 100)");
        System.out.println("最小值: " + result3);

        double result4 = eval.getNumberResult("ABS(-123.45)");
        System.out.println("绝对值: " + result4);

        // 三角函数
        System.out.println("\n=== 三角函数 ===");
        double sin = eval.getNumberResult("SIN(30*3.14159/180)");
        System.out.println("sin(30°): " + sin);

        double cos = eval.getNumberResult("COS(60*3.14159/180)");
        System.out.println("cos(60°): " + cos);

        // 数学函数
        System.out.println("\n=== 数学函数 ===");
        double sqrt = eval.getNumberResult("SQRT(16)");
        System.out.println("平方根: " + sqrt);

        double pow = eval.getNumberResult("POW(2, 3)");
        System.out.println("幂运算: " + pow);

        double ceil = eval.getNumberResult("CEIL(3.14)");
        System.out.println("向上取整: " + ceil);

        double floor = eval.getNumberResult("FLOOR(3.14)");
        System.out.println("向下取整: " + floor);

        // 组合计算
        System.out.println("\n=== 组合计算 ===");
        double complex = eval.getNumberResult("MAX(POW(2,3), SQRT(16)) + MIN(10, ABS(-15))");
        System.out.println("组合计算结果: " + complex);
    }
} 