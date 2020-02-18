package leetcode.ainterview.huawei.b;

import java.util.*;

public class Main {
    public void getAns(List<String> list){
        Map<Integer, List<String>> map = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));

        for (String s: list){
            // split中间是空格
            String[] detail = s.split(" ");
            int total = 0;
            for (int i = 1; i < 4; i++){
                if (Integer.valueOf(detail[i]) < 60){
                    break;
                }
                total += Integer.valueOf(detail[i]);
            }
            if (!map.containsKey(total)){
                List<String> tmp = new ArrayList<>();
                map.put(total, tmp);
            }
            List<String> l = map.get(total);
            l.add(s);
        }
        System.out.println(map);

        for (Integer key: map.keySet()){
            // split中间是空格
            map.get(key).sort(Comparator.comparing(o -> o.split(" ")[0]));
        }

        System.out.println("[First round name list]");
        for (Integer key: map.keySet()){
            List<String> list1 = map.get(key);
            for (String ss: list1){
                System.out.println(ss);
            }
        }

        System.out.println();
        System.out.println("[Final name list]");
        int count = 0;
        for (Integer key: map.keySet()){
            if (count == 3){
                break;
            }
            List<String> list1 = map.get(key);
            for (String ss: list1){
                System.out.println(ss);
            }
            count++;
        }
    }


    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++){
                list.add(sc.nextLine());
            }
            s.getAns(list);
        }
    }
}
