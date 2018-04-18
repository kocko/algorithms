package codeforces.contests901_1000.problemset964;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class DestructionOfATree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n % 2 == 0) {
            out.println("NO");
            return;
        }
        int[] degree = new int[n + 1];
        int[] depth = new int[n + 1];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
            depth[i] = -1;
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            int parent = in.ni();
            if (parent != 0) {
                degree[parent]++;
                degree[i]++;
                tree.get(i).add(parent);
                tree.get(parent).add(i);
            } else {
                root = i;
            }
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        depth[root] = 0;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int u = deque.pollFirst();
            for (int v : tree.get(u)) {
                if (depth[v] == -1) {
                    depth[v] = depth[u] + 1;
                    deque.offerLast(v);
                }
            }
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>(comparingInt(x -> -depth[x]));
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (visited[u] || degree[u] % 2 == 1) continue;
            result.add(u);
            degree[u] = 0;
            visited[u] = true;
            for (int v : tree.get(u)) {
                if (degree[v] == 0) continue;

                if (degree[v] > 0) degree[v]--;
                if (degree[v] % 2 == 0) {
                    queue.add(v);
                }
            }
        }
        if (result.size() == n) {
            out.println("YES");
            result.forEach(out::println);
        } else {
            out.println("NO");
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
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (DestructionOfATree instance = new DestructionOfATree()) {
            instance.solve();
        }
    }
}
