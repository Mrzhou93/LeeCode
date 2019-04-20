package src;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 案例:
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 *
 * 注意事项:
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * */

public class N401readBinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < 12; i++){                // 约束函数
            for (int j = 0; j < 60; j++){           // 约束函数
                if (ones(i) + ones(j) == num){      // 限界函数
                    res.add(i + ":" + (j < 10? "0"+j: j));
                }
            }
        }

        return res;
    }

    private int ones(int i){
        int count  = 0;
        while (i != 0){
            i = i & (i -1);
            count++;
        }
        return count;
    }

    public static void main(String [] args){

        N401readBinaryWatch s= new N401readBinaryWatch();

        System.out.println(s.readBinaryWatch(1));
        System.out.println(s.readBinaryWatch(1).size());
    }

}
