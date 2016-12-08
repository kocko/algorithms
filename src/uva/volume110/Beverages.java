package uva.volume110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Beverages {

    private List<List<Integer>> graph;
    private Map<Integer, String> inverse;
    private int[] in;

    private Beverages(List<List<Integer>> graph, Map<Integer, String> inverse, int[] in) {
        this.graph = graph;
        this.inverse = inverse;
        this.in = in;
    }

    public void solve(int testCase) {
        List<Integer> order = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < in.length; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int i = 0; i < graph.get(top).size(); i++) {
                int next = graph.get(top).get(i);
                in[next]--;
                if (in[next] == 0) {
                    queue.add(next);
                }
            }
            order.add(top);
        }
        System.out.print("Case #" + testCase + ": Dilbert should drink beverages in this order:");
        for (Integer o : order) {
            System.out.print(" " + inverse.get(o));
        }
        System.out.println(".\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 1;
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            Map<String, Integer> order = new HashMap<>();
            Map<Integer, String> inverse = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                String next = sc.nextLine();
                order.put(next, i);
                inverse.put(i, next);
            }
            int m = Integer.parseInt(sc.nextLine());
            int[] in = new int[n + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                String[] split = sc.nextLine().split("\\s+");
                graph.get(order.get(split[0])).add(order.get(split[1]));
                in[order.get(split[1])]++;
                
            }
            new Beverages(graph, inverse, in).solve(testCase++);
            if (sc.hasNextLine()) sc.nextLine();
        }
        sc.close();
    }

}
