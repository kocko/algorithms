package uva.volume004;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class WordTransformation implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = parseInt(in.nextLine());
        while (t-- > 0) {
            go();
            if (t > 0) out.println();
        }
    }

    private void go() {
        List<String> words = new ArrayList<>();
        String next;
        while (!"*".equals(next = in.nextLine())) {
            words.add(next);
        }

        int n = words.size();
        Map<String, Integer> index = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            index.put(words.get(i), i);
        }
        for (int i = 0; i < n; i++) {
            String a = words.get(i);
            for (int j = i + 1; j < n; j++) {
                String b = words.get(j);
                if (diff(a, b) == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        String line;
        while (in.hasNextLine() && !"".equals(line = in.nextLine())) {
            String[] query = line.split("\\s++");
            int start = index.get(query[0]), end = index.get(query[1]), distance = bfs(graph, start, end);
            out.printf("%s %s %d\n", query[0], query[1], distance);
        }
    }

    private int diff(String a, String b) {
        if (a.length() != b.length()) return -1;
        int result = 0, n = a.length();
        for (int i = 0; i < n; i++) {
            result += (a.charAt(i) != b.charAt(i) ? 1 : 0);
        }
        return result;
    }

    private int bfs(List<List<Integer>> graph, int start, int end) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int[] dist = new int[n];
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    queue.offerLast(v);
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                }
            }
        }
        return dist[end];
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
        try (WordTransformation instance = new WordTransformation()) {
            instance.solve();
        }
    }
}
