package codeforces.contests600_699.problemset608;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SaitamaDestroysHotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (int i = 0; i < n; i++) {
            int floor = sc.nextInt();
            int time = sc.nextInt();
            if (map.containsKey(floor)) {
                map.put(floor, Math.max(map.get(floor), time));
            } else {
                map.put(floor, time);
            }
        }
        sc.close();

        int time = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())  {
            time += s - entry.getKey();
            if (entry.getValue() > time) {
                time += (entry.getValue() - time);
            }
            s = entry.getKey();
        }
        time += s;
        System.out.println(time);
    }

}
