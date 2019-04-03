package src;

import java.util.*;

class N599findRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i=0; i< list1.length; i++){
            map.put(list1[i], i);
        }

        int min = list1.length + list2.length - 2;

        for (int j=list2.length - 1; j >= 0; j--){
            if (map.containsKey(list2[j]) && j + map.get(list2[j]) <= min){
                if (j + map.get(list2[j]) < min){
                    min = j + map.get(list2[j]);
                    result.clear();
                    result.add(list2[j]);
                } else {
                    result.add(list2[j]);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args){
        String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        N599findRestaurant s = new N599findRestaurant();
        String[] result = s.findRestaurant(s1, s2);
        System.out.println(result[0]);
    }
}
