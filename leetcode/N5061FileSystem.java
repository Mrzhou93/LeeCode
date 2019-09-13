package leetcode;

import java.util.*;

/**
 * 你需要设计一个能提供下面两个函数的文件系统：
 *
 * create(path, value): 创建一个新的路径，并尽可能将值 value 与路径 path 关联，然后返回 True。如果路径已经存在或者路径的父路径不存在，则返回 False。
 * get(path): 返回与路径关联的值。如果路径不存在，则返回 -1。
 * “路径” 是由一个或多个符合下述格式的字符串连接起来形成的：在 / 后跟着一个或多个小写英文字母。
 *
 * 例如 /leetcode 和 /leetcode/problems 都是有效的路径，但空字符串和 / 不是有效的路径。
 *
 * 好了，接下来就请你来实现这两个函数吧！（请参考示例以获得更多信息）
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["N5061FileSystem","create","get"]
 * [[],["/a",1],["/a"]]
 * 输出：
 * [null,true,1]
 * 解释：
 * N5061FileSystem fileSystem = new N5061FileSystem();
 *
 * fileSystem.create("/a", 1); // 返回 true
 * fileSystem.get("/a"); // 返回 1
 * 示例 2：
 *
 * 输入：
 * ["N5061FileSystem","create","create","get","create","get"]
 * [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
 * 输出：
 * [null,true,true,2,false,-1]
 * 解释：
 * N5061FileSystem fileSystem = new N5061FileSystem();
 *
 * fileSystem.create("/leet", 1); // 返回 true
 * fileSystem.create("/leet/code", 2); // 返回 true
 * fileSystem.get("/leet/code"); // 返回 2
 * fileSystem.create("/c/d", 1); // 返回 false 因为父路径 "/c" 不存在。
 * fileSystem.get("/c"); // 返回 -1 因为该路径不存在。
 *
 *
 * 提示：
 *
 * 对两个函数的调用次数加起来小于等于 10^4
 * 2 <= path.length <= 100
 * 1 <= value <= 10^9
 */

public class N5061FileSystem {

    private class Node {
        HashMap<String, Node> child = new HashMap<>();
        int val;

        Node(int val){
            this.val = val;
        }
    }

    private Node root;

    public N5061FileSystem() {
        root = new Node(-1);
    }

    public boolean create(String path, int value) {
        String[] pat = path.split("/");
        Node cur = root;

        for (int i = 1; i < pat.length - 1; i++){
            if (cur.child.containsKey(pat[i])){
                cur = cur.child.get(pat[i]);
            } else {
                return false;
            }
        }

        int n = pat.length;
        if (cur.child.containsKey(pat[n - 1])){
            return false;
        }
        cur.child.put(pat[n - 1], new Node(value));

        return true;
    }

    public int get(String path) {
        String[] pat = path.split("/");
//        System.out.println(Arrays.toString(pat));
        Node cur = root;
        for (int i = 1; i < pat.length; i++){
            if (cur.child.containsKey(pat[i])){
                cur = cur.child.get(pat[i]);
            } else {
                return -1;
            }
        }
        return cur.val;
    }

    public static void main(String[] args) {
        N5061FileSystem f = new N5061FileSystem();
        System.out.println(f.create("/leet", 1));
        System.out.println(f.create("/leet/code", 2));
        System.out.println(f.get("/leet/code"));
        System.out.println(f.create("/c/d", 1));
        System.out.println(f.get("/c"));
    }
}
