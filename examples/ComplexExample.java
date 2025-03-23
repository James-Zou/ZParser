package examples;

import com.unionhole.zparser.ExecutionCenter;

/**
 * ZParser 复杂示例
 * 展示多种函数的组合使用
 */
public class ComplexExample {
    public static void main(String[] args) {
        // 获取计算引擎实例
        ExecutionCenter eval = ExecutionCenter.getInstance();

        // 示例1：条件日期处理
        System.out.println("=== 示例1：条件日期处理 ===");
        String result1 = eval.getStringResult(
            "IF(DAYS(CURRENTDAY(), '2024-12-31') > 180, " +
            "'距离年底超过180天', " +
            "CONCAT('距离年底还有', DAYS(CURRENTDAY(), '2024-12-31'), '天'))"
        );
        System.out.println("年底倒计时: " + result1);

        // 示例2：数值统计与文本处理
        System.out.println("\n=== 示例2：数值统计与文本处理 ===");
        String result2 = eval.getStringResult(
            "CONCAT('平均值: ', " +
            "VALUE((MAX(10, 20, 30) + MIN(10, 20, 30)) / 2), " +
            ', 总和: ', " +
            "VALUE(SUM(10, 20, 30)))"
        );
        System.out.println("数值处理: " + result2);

        // 示例3：日期区间判断
        System.out.println("\n=== 示例3：日期区间判断 ===");
        String result3 = eval.getStringResult(
            "IF(AND(" +
            "DAYMS(CURRENTDAYTIME(), '2024-12-31 23:59:59') >= 0, " +
            "DAYMS(CURRENTDAYTIME(), '2024-01-01 00:00:00') <= 0" +
            "), '在2024年内', '不在2024年内')"
        );
        System.out.println("日期区间: " + result3);

        // 示例4：复杂文本处理
        System.out.println("\n=== 示例4：复杂文本处理 ===");
        String text = "Hello World, Today is a good day!";
        String result4 = eval.getStringResult(
            "CONCAT(" +
            "UPPERCASE(SUBSTRING('" + text + "', 0, 5)), " +
            "' - ', " +
            "LOWERCASE(SUBSTRING('" + text + "', INDEX('" + text + "', 'World', 0), 5)), " +
            "' - ', " +
            "TRIM(SUBSTRING('" + text + "', LASTINDEX('" + text + "', 'day', 0), 3))" +
            ")"
        );
        System.out.println("文本处理: " + result4);

        // 示例5：财务计算
        System.out.println("\n=== 示例5：财务计算 ===");
        String result5 = eval.getStringResult(
            "IF(" +
            "VALUE('1000 * POW(1 + 0.05, 12)') > 2000, " +
            "'投资收益超过2000', " +
            "CONCAT('投资收益为: ', VALUE('1000 * POW(1 + 0.05, 12) - 1000'))" +
            ")"
        );
        System.out.println("投资分析: " + result5);

        // 示例6：数据验证
        System.out.println("\n=== 示例6：数据验证 ===");
        String email = "test@example.com";
        String phone = "13800138000";
        String result6 = eval.getStringResult(
            "CONCAT(" +
            "'邮箱验证: ', IF(CONTAIN('" + email + "', '@') AND CONTAIN('" + email + "', '.'), '有效', '无效'), " +
            ', 手机验证: ', IF(LENGTH('" + phone + "') == 11 AND STARTS('" + phone + "', '1', 0), '有效', '无效')" +
            ")"
        );
        System.out.println("数据验证: " + result6);

        // 示例7：报表数据处理
        System.out.println("\n=== 示例7：报表数据处理 ===");
        double[] sales = {1000.50, 2000.75, 1500.25, 3000.00};
        String result7 = eval.getStringResult(
            "CONCAT(" +
            "'销售统计 - ', " +
            "CURRENTDAYTIME(), " +
            '\n销售总额: ', VALUE('" + (sales[0] + sales[1] + sales[2] + sales[3]) + "'), " +
            '\n平均销售: ', VALUE('" + (sales[0] + sales[1] + sales[2] + sales[3]) + " / 4'), " +
            '\n最高销售: ', VALUE('MAX(" + sales[0] + "," + sales[1] + "," + sales[2] + "," + sales[3] + ")')" +
            ")"
        );
        System.out.println("报表处理: " + result7);
    }
} 