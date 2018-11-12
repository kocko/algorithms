package timus.volume01;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class PruferCode implements Closeable {

    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s++");

        int n = line.length;
        int[] code = new int[n], degree = new int[n + 2];
        List<Set<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            code[i] = parseInt(line[i]);
            degree[code[i]]++;
            result.add(new TreeSet<>());
        }
        result.add(new TreeSet<>());
        result.add(new TreeSet<>());
        PriorityQueue<Integer> leaves = new PriorityQueue<>();
        for (int i = 1; i <= n + 1; i++) {
            if (degree[i] == 0) {
                leaves.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            int u = leaves.poll(), v = code[i];
            result.get(u).add(v);
            result.get(v).add(u);

            if (--degree[v] == 0) {
                leaves.add(v);
            }
        }
        for (int i = 1; i <= n + 1; i++) {
            Set<Integer> current = result.get(i);
            out.print(i + ":");
            for (int v : current) {
                out.print(' ');
                out.print(v);
            }
            out.println();
        }
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (PruferCode instance = new PruferCode()) {
            instance.solve();
        }
    }
}
