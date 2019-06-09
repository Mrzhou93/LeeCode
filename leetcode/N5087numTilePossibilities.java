package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N5087numTilePossibilities {
    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        List<String> list = new ArrayList<>();
        List<Character> last = new ArrayList<>();

        dfs(list, visited, "", tiles);

        return list.size();
    }

    public void dfs(List<String> list, boolean[] visited, String lastStr, String tiles){
        if (lastStr.length() == 0)
            return;

        for (int i = 0; i < tiles.length(); i++){

            if (!visited[i]) {
                visited[i] = true;

                String newStr = lastStr + tiles.charAt(i);

                list.add(newStr);
                dfs(list, visited, newStr, tiles);

                visited[i] = false;
            }
        }
    }

    public int numTilePossibilities1(String tiles){
        List<String> res = new ArrayList<>();
        int size = tiles.length();

        System.out.println((1 << size));

        for (int i = 0; i < (1 << size); i++){
            List<Character> ax = new ArrayList<>();
            for (int j = 0; j < size; j++){
                if ((i & (1 << j)) != 0){
                    ax.add(tiles.charAt(j));
                }
            }
            res.add(ax.toString());
        }

        return res.size();
    }

    public static void main(String[] args){
        N5087numTilePossibilities s = new N5087numTilePossibilities();

        System.out.println(s.numTilePossibilities("AAB"));
        System.out.println(s.numTilePossibilities("AAABBC"));
        System.out.println(s.numTilePossibilities("MGBENBK"));
        System.out.println(s.numTilePossibilities("TBAKNLM"));
        System.out.println(s.numTilePossibilities("AAEBBCB"));
    }
}


//    public int numTilePossibilities(String tiles) {
//        boolean[] visited = new boolean[tiles.length()];
//        List<String> list = new ArrayList<>();
//        List<Character> last = new ArrayList<>();
//
//        dfs(list, visited, last, tiles, 0);
//
//        return list.size();
//    }
//
//    public void dfs(List<String> list, boolean[] visited, List<Character> lastStr, String tiles, int index){
//        if (!list.contains(lastStr.toString()) && lastStr.size() != 0)
//            list.add(lastStr.toString());
//
//        for (int i = index; i < tiles.length(); i++){
//            List<Character> newList = new ArrayList<>(lastStr);
//            if (!visited[i]) {
//                visited[i] = true;
//
//                lastStr.add(tiles.charAt(i));
//                newList.add(tiles.charAt(i));
//                dfs(list, visited, newList, tiles, index);
//                lastStr.remove(lastStr.size() - 1);
//                visited[i] = false;
//            }
//        }
//    }