package leetcode.ainterview.huawei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public long findTime(String time) throws ParseException {
        String[] tt = time.split("/");

        for (String ele: tt){
            if (ele.matches("(\\d{4})-(\\d{2})-(\\d{2})T(\\d{2})\\:(\\d{2})\\:(\\d{2})")){
                String realTime = ele.replace('T', ' ');

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(realTime);
                return date.getTime();
            }
        }
        return 0L;
    }

    public void getAns(String[] list) throws ParseException {
        Map<Long, Set<String>> map = new TreeMap<>();
        for (String t: list){
            long time = findTime(t);
            if (!map.containsKey(time)) {
                Set<String> set = new TreeSet<>();
                map.put(time, set);
            }
            Set<String> set = map.get(time);
            set.add(t);
        }

        for (Long key: map.keySet()){
            Set<String> set = map.get(key);
            for (String e : set) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Main s = new Main();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            String[] list = new String[n];
            for (int i = 0; i < n; i++){
                list[i] = sc.nextLine();
            }
            s.getAns(list);
        }
    }
}

//7
//my/2019-01-01T09:00:01
//my/2019-01-01T09:00:01
//bcd/2018-12-24T08:00:00/test/you
//abc/2018-12-24T08:00:00/test/you
//bcd/2018-12-24T08:00:00/test/you
//1/2018-12-24T08:00:00/test/Test1
//123/2018-12-24T08:00:09/test/me