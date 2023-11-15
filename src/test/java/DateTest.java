import com.unionhole.zparser.utils.DateUtil;

/**
 * @author roderick.zou
 * @Description: 日期测试类
 * @date 11/15/23 5:34 PM
 */
public class DateTest {
    public static void main(String[] args) {
        String day=DateUtil.getDay(-1);
        System.out.printf("day="+day);
    }
}

