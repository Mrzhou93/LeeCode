package leetcode;

import javax.print.DocFlavor;
import java.util.*;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素accounts[i][0] 是 
 * 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 *
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。
 * 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
 * 一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 *
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。
 * accounts 本身可以以任意顺序返回。
 *
 * 例子 1:
 *
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 *   第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 *   第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 *   我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 *   ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 *
 * 注意：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N721accountsMerge {

    private int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();

        if (accounts == null || accounts.size() == 0)
            return null;

        parent = new int[accounts.size()];        // 对人进行并查集

        for(int i = 0; i < accounts.size(); i++){
            parent[i] = i;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if (!map.containsKey(email)){
                    map.put(email, i);
                } else {
                    int preIndex = map.get(email);
                    int preRoot = find(preIndex);
                    int curRoot = find(i);
                    if (curRoot != preRoot){
                        parent[i] = preRoot;
                    }
                }
            }
        }

        Map<Integer, Set<String>> map1 = new HashMap(); // 人与邮箱的映射关系
        for (int i = 0; i < accounts.size(); i++){
            int tmpRoot = find(i);
            if (!map1.containsKey(tmpRoot)){
                map1.put(tmpRoot, new HashSet<>());
            }

            for (int j = 1; j < accounts.get(i).size(); j++){
                map1.get(tmpRoot).add(accounts.get(i).get(j));
            }
        }

        for (int i: map1.keySet()){
            List<String> t = new ArrayList<>();
            t.add(accounts.get(i).get(0));
            List<String> emails = new ArrayList<>(map1.get(i));
            Collections.sort(emails);
            t.addAll(emails);
            ans.add(t);
        }

        return ans;
    }

    public int find(int x){
        int r = x;      // r为根
        while (parent[r] != r){
            parent[r] = parent[parent[r]];
            r = parent[r];
        }

//        int i = x, j;
//        while (i != r){     // 将x的所有父结点都和根结点相关联
//            j = parent[i];
//            parent[i] = r;
//            i = j;
//        }

        return r;
    }

    public static void main(String[] args){
        N721accountsMerge s = new N721accountsMerge();
        List<List<String>> accounts = new ArrayList<>();

        List<String> acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("johnsmith@mail.com");
        acc1.add("john00@mail.com");

        List<String> acc2 = new ArrayList<>();
        acc2.add("John");
        acc2.add("johnnybravo@mail.com");

        List<String> acc3 = new ArrayList<>();
        acc3.add("John");
        acc3.add("johnsmith@mail.com");
        acc3.add("john_newyork@mail.com");

        List<String> acc4 = new ArrayList<>();
        acc4.add("Mary");
        acc4.add("mary@mail.com");

        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);

        System.out.println(s.accountsMerge(accounts));
    }
}
