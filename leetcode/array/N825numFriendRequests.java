package leetcode.array;

/**
 * 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
 *
 * 当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：
 *
 * age[B] <= 0.5 * age[A] + 7       相同年龄的话，必须要大于15岁
 * age[B] > age[A]                  只有年龄大的可以向年龄小的发送请求
 * age[B] > 100 && age[A] < 100
 * 否则，A 可以给 B 发送好友请求。
 *
 * 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
 *
 * 求总共会发出多少份好友请求?
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [16,16]
 * 输出: 2
 * 解释: 二人可以互发好友申请。
 * 示例 2:
 *
 * 输入: [16,17,18]
 * 输出: 2
 * 解释: 好友请求可产生于 17 -> 16, 18 -> 17.
 * 示例 3:
 *
 * 输入: [20,30,100,110,120]
 * 输出: 3
 * 解释: 好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
 *  
 *
 * 说明:
 *
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N825numFriendRequests {
    public int numFriendRequests(int[] ages) {
        int[] helper = new int[121];

        for (int age: ages){
            helper[age]++;
        }

        int ans = 0;

        for (int i = 15; i < 121; i++){
            for (int j = i; j < 121; j++){
                if (i <= 0.5 * j + 7){
                    break;
                } else {
                    if (i == j){
                        ans += helper[i] * (helper[j] - 1);
                    } else {
                        ans += helper[i] * helper[j];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N825numFriendRequests s = new N825numFriendRequests();

        System.out.println(s.numFriendRequests(new int[]{16, 16}));
        System.out.println(s.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(s.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }
}
