package examples;

import com.unionhole.zparser.ExecutionCenter;

/**
 * ZParser 文本处理示例
 * 展示文本函数的使用
 */
public class TextExample {
    public static void main(String[] args) {
        // 获取计算引擎实例
        ExecutionCenter eval = ExecutionCenter.getInstance();

        // 基础文本操作
        System.out.println("=== 基础文本操作 ===");
        String concat = eval.getStringResult("CONCAT('Hello', ' ', 'World')");
        System.out.println("字符串连接: " + concat);

        String trim = eval.getStringResult("TRIM('   Hello World   ')");
        System.out.println("去除空格: " + trim);

        String upper = eval.getStringResult("UPPERCASE('Hello World')");
        System.out.println("转大写: " + upper);

        String lower = eval.getStringResult("LOWERCASE('Hello World')");
        System.out.println("转小写: " + lower);

        // 字符串查找
        System.out.println("\n=== 字符串查找 ===");
        String index = eval.getStringResult("INDEX('Hello World', 'o', 0)");
        System.out.println("查找位置: " + index);

        String lastIndex = eval.getStringResult("LASTINDEX('Hello World', 'o', 10)");
        System.out.println("最后出现位置: " + lastIndex);

        String charAt = eval.getStringResult("CHAR('Hello', 1)");
        System.out.println("指定位置字符: " + charAt);

        // 字符串处理
        System.out.println("\n=== 字符串处理 ===");
        String length = eval.getStringResult("LENGTH('Hello World')");
        System.out.println("字符串长度: " + length);

        String substring = eval.getStringResult("SUBSTRING('Hello World', 6, 5)");
        System.out.println("截取字符串: " + substring);

        String replace = eval.getStringResult("REPLACE('Hello World', 'o', 'O')");
        System.out.println("替换字符串: " + replace);

        // 字符串比较
        System.out.println("\n=== 字符串比较 ===");
        String compare = eval.getStringResult("COMPARE('apple', 'banana')");
        System.out.println("字符串比较: " + compare);

        String compareIgnore = eval.getStringResult("COMPAREIGNORE('Hello', 'hello')");
        System.out.println("忽略大小写比较: " + compareIgnore);

        String equals = eval.getStringResult("EQUALS('Hello', 'Hello')");
        System.out.println("字符串相等: " + equals);

        String equalsIgnore = eval.getStringResult("EQUALSIGNORE('Hello', 'hello')");
        System.out.println("忽略大小写相等: " + equalsIgnore);

        // 字符串匹配
        System.out.println("\n=== 字符串匹配 ===");
        String starts = eval.getStringResult("STARTS('Hello World', 'Hello', 0)");
        System.out.println("前缀匹配: " + starts);

        String ends = eval.getStringResult("ENDS('Hello World', 'World')");
        System.out.println("后缀匹配: " + ends);

        // 复杂文本处理
        System.out.println("\n=== 复杂文本处理 ===");
        String complex = eval.getStringResult(
            "CONCAT(UPPERCASE(SUBSTRING('hello world', 0, 5)), ' ', LOWERCASE(SUBSTRING('WORLD', 0, 5)))"
        );
        System.out.println("复杂文本处理: " + complex);
    }
} 