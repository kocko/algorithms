package uva.volume001;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FollowingOrders {

    private List<List<Integer>> graph;
    private Map<Integer, String> inverse;
    private int[] in;
    private int n;

    private FollowingOrders(List<List<Integer>> graph, Map<Integer, String> inverse, int[] in) {
        this.graph = graph;
        this.inverse = inverse;
        this.in = in;
        this.n = graph.size();
    }

    public void solve() {
        orders = new ArrayList<>();
        visited = new boolean[n];
        order = new int[n - 1];
        if (!recurse(0)) {
            System.out.println("NO");
        } else {
            print();
        }
    }

    private int[] order;
    private boolean[] visited;
    private List<int[]> orders;

    private void print() {
        for (int[] o : orders) {
            for (int t : o) {
                System.out.print(inverse.get(t));
            }
            System.out.println();
        }
    }

    private boolean recurse(int index) {
        List<Integer> saved = new ArrayList<>();
        if (index == n - 1) {
            int[] result = new int[order.length];
            System.arraycopy(order, 0, result, 0, order.length);
            orders.add(result);
            return true;
        }
        boolean result = false;
        for (int i = 1; i < n; i++) {
            if (in[i] == 0 && !visited[i]) {
                copy(graph.get(i), saved);
                visited[i] = true;
                order[index] = i;
                for (int x : saved) in[x]--;

                result |= recurse(index + 1);

                visited[i] = false;
                order[index] = 0;
                for (int x : saved) in[x]++;
                copy(saved, graph.get(i));
            }
        }
        return result;
    }

    private void copy(List<? extends Integer> src, List<? super Integer> destination) {
        destination.addAll(src);
        src.clear();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split("\\s+");
            Arrays.sort(split);
            Map<String, Integer> order = new HashMap<>();
            Map<Integer, String> inverse = new HashMap<>();
            int n = split.length;
            for (int i = 1; i <= n; i++) {
                order.put(split[i - 1], i);
                inverse.put(i, split[i - 1]);
            }
            split = sc.nextLine().split("\\s+");
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            int[] in = new int[n + 1];
            for (int i = 0; i < split.length; i += 2) {
                String from = String.valueOf(split[i]);
                String to = String.valueOf(split[i + 1]);
                graph.get(order.get(from)).add(order.get(to));
                in[order.get(to)]++;
            }
            new FollowingOrders(graph, inverse, in).solve();
            if (sc.hasNextLine()) {
                System.out.println();
            }
        }
        sc.close();
    }
}
