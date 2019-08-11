package leetcode.array;

/**
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *
 *
 * 提示：
 *
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 */

public class N1154ordinalOfDate {

    static int[] month1 = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] month2 = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int[] mm1 = new int[13];
    static int[] mm2 = new int[13];
    static {
        for (int i = 1; i <= 12; i++){
            mm1[i] = mm1[i - 1] + month1[i - 1];
            mm2[i] = mm2[i - 1] + month2[i - 1];
        }
    }

    public int ordinalOfDate(String date) {

        String[] day = date.split("-");
        int[] month;
        int ans = 0;

        int yy = Integer.parseInt(day[0]);
        int mm = Integer.parseInt(day[1]);
        int dd = Integer.parseInt(day[2]);

        if ((yy % 400 == 0) || (yy % 100 != 0 && yy % 4 == 0)){
            month = mm2;
        } else {
            month = mm1;
        }

        for (int i = 0; i < mm; i++){
            ans = month[i];
        }

        ans += dd;

        return ans;
    }

    public static void main(String[] args) {
        N1154ordinalOfDate s = new N1154ordinalOfDate();

        System.out.println(s.ordinalOfDate("2019-01-09"));
        System.out.println(s.ordinalOfDate("2019-02-10"));
        System.out.println(s.ordinalOfDate("2003-03-01"));
        System.out.println(s.ordinalOfDate("2004-03-01"));
    }
}
