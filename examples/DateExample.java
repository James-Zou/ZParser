package examples;

import com.unionhole.zparser.ExecutionCenter;

/**
 * ZParser 日期处理示例
 * 展示日期相关函数的使用
 */
public class DateExample {
    public static void main(String[] args) {
        // 获取计算引擎实例
        ExecutionCenter eval = ExecutionCenter.getInstance();

        // 获取当前日期时间
        System.out.println("=== 当前日期时间 ===");
        String currentDay = eval.getDateResult("CURRENTDAY()");
        System.out.println("当前日期: " + currentDay);

        String currentDayTime = eval.getDateResult("CURRENTDAYTIME()");
        System.out.println("当前日期时间: " + currentDayTime);

        String currentWeek = eval.getStringResult("CURRENTWEEK()");
        System.out.println("当前星期: " + currentWeek);

        // 日期计算
        System.out.println("\n=== 日期计算 ===");
        String nextDay = eval.getDateResult("NEXTDAY()");
        System.out.println("下一天: " + nextDay);

        String nextDayTime = eval.getDateResult("NEXTDAYTIME()");
        System.out.println("下一天带时间: " + nextDayTime);

        String getDay = eval.getDateResult("GETDAY(-2)");
        System.out.println("两天前: " + getDay);

        String getDayTime = eval.getDateResult("GETDAYTIME(2)");
        System.out.println("两天后带时间: " + getDayTime);

        // 月份和季度
        System.out.println("\n=== 月份和季度 ===");
        String monthStart = eval.getDateResult("MONTHSTARTDATE()");
        System.out.println("本月开始日期: " + monthStart);

        String monthEnd = eval.getDateResult("MONTHENDDATE()");
        System.out.println("本月结束日期: " + monthEnd);

        String seasonStart = eval.getDateResult("SEASONSTARTDATE('2023-07-08 15:11:01')");
        System.out.println("季度开始日期: " + seasonStart);

        String seasonEnd = eval.getDateResult("SEASONENDDATE('2023-07-08 15:11:01')");
        System.out.println("季度结束日期: " + seasonEnd);

        // 日期差值计算
        System.out.println("\n=== 日期差值 ===");
        String days = eval.getStringResult("DAYS('2023-07-08','2023-07-10')");
        System.out.println("日期差值(天): " + days);

        String dayMs = eval.getStringResult("DAYMS('2023-07-08 15:11:01','2023-07-10 05:11:01')");
        System.out.println("日期时间差值(天): " + dayMs);

        // 时间戳操作
        System.out.println("\n=== 时间戳操作 ===");
        String timeMillis = eval.getStringResult("TIMEMILLIS(-2)");
        System.out.println("两天前的时间戳: " + timeMillis);

        String dayFromMillis = eval.getDateResult("DAYMILLISM(" + timeMillis + ",1)");
        System.out.println("从时间戳还原日期时间: " + dayFromMillis);
    }
} 