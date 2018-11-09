package timus.volume01;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class PruferCode implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] line = in.nextLine().split("\\s++");
        int n = line.length;
        int[] code = new int[n], degree = new int[n + 2];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            code[i] = parseInt(line[i]);
            degree[code[i]]++;
            result.add(new ArrayList<>());
        }
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        PriorityQueue<Integer> leaves = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
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
            List<Integer> current = result.get(i);
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
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (PruferCode instance = new PruferCode()) {
            instance.solve();
        }
    }
}
