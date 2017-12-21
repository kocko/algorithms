package uva.volume004;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TheDepartmentOfRedundancyDepartment implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        Map<Integer, Integer> count = new TreeMap<>();
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int idx = 0;
        while (in.hasNextInt()) {
            int next = in.nextInt();
            if (firstSeen.get(next) == null) {
                firstSeen.put(next, idx);
                count.put(next, 1);
            } else {
                count.put(next, count.get(next) + 1);
            }
            idx++;
        }
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>();
        sorted.addAll(firstSeen.entrySet());
        sorted.sort(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : sorted) {
            out.println(entry.getKey() + " " + count.get(entry.getKey()));
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TheDepartmentOfRedundancyDepartment instance = new TheDepartmentOfRedundancyDepartment()) {
            instance.solve();
        }
    }
}
