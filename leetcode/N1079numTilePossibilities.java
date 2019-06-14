package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1079numTilePossibilities {
    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        List<String> list = new ArrayList<>();
        List<Character> last = new ArrayList<>();

        dfs(list, visited, last, tiles, 0);

        return list.size();
    }

    public void dfs(List<String> list, boolean[] visited, List<Character> lastStr, String tiles, int index){
        if (!list.contains(lastStr.toString()) && lastStr.size() != 0)
            list.add(lastStr.toString());

        for (int i = index; i < tiles.length(); i++){
            List<Character> newList = new ArrayList<>(lastStr);
            if (!visited[i]) {
                visited[i] = true;

                lastStr.add(tiles.charAt(i));
                newList.add(tiles.charAt(i));
                dfs(list, visited, newList, tiles, index);
                lastStr.remove(lastStr.size() - 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args){
        N1079numTilePossibilities s = new N1079numTilePossibilities();

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