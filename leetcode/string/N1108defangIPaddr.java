package leetcode.string;

/**
 * 5117. IP 地址无效化  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Easy
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 */

public class N1108defangIPaddr {
    public String defangIPaddr(String address) {
        String[] ip = address.split("\\.");

//        System.out.println(Arrays.toString(ip));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <3; i++){
            sb.append(ip[i]).append("[.]");
        }

        sb.append(ip[3]);

        return sb.toString();
    }

    public static void main(String[] args) {
        N1108defangIPaddr s = new N1108defangIPaddr();
        System.out.println(s.defangIPaddr("1.1.1.1"));
    }
}
