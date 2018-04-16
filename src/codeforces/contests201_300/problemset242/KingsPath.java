package codeforces.contests201_300.problemset242;

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
import java.util.StringTokenizer;

public class KingsPath implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x0 = in.ni(), y0 = in.ni(), x1 = in.ni(), y1 = in.ni();
        int[] distance = new int[100000];
        for (int i = 0; i < 100000; i++) {
            graph.add(new ArrayList<>());
            distance[i] = -1;
        }
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            int row = in.ni(), start = in.ni(), end = in.ni();
            for (int j = start; j <= end; j++) {
                build(row, j);
            }
        }
        
        int start = numberToIndex.get(getNumber(x0, y0)), end = numberToIndex.get(getNumber(x1, y1));
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int v : graph.get(u)) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    queue.offerLast(v);
                }
            }
        }
        out.println(distance[end]);
    }

    private final long MAX = (long) 1e9;
    private List<List<Integer>> graph = new ArrayList<>();
    private Map<Long, Integer> numberToIndex = new HashMap<>();
    private int next = 0;

    private void build(int row, int col) {
        long number = getNumber(row, col);
        if (!numberToIndex.containsKey(number)) {
            numberToIndex.put(number, next);
            
            long left = -1, right = -1, up = -1, down = -1, nw = -1, ne = -1, sw = -1, se = -1;
            if (row != 1) up = number - MAX;
            if (row != MAX) down = number + MAX;
            if (col != 1) left = number - 1;
            if (col != MAX) right = number + 1;
            
            if (row != 1 && col != 1) nw = up - 1;
            if (row != 1 && col != MAX) ne = up + 1;
            if (row != MAX && col != MAX) se = down - 1;
            if (row != MAX && col != 1) sw = down + 1;

            addEdge(left);
            addEdge(up);
            addEdge(right);
            addEdge(down);
            addEdge(nw);
            addEdge(ne);
            addEdge(sw);
            addEdge(se);
            
            next++;
        }
    }
    
    private void addEdge(long number) {
        if (numberToIndex.containsKey(number)) {
            graph.get(next).add(numberToIndex.get(number));
            graph.get(numberToIndex.get(number)).add(next);
        }
    }

    private long getNumber(int row, int col) {
        return (row - 1) * MAX + col;
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
        try (KingsPath instance = new KingsPath()) {
            instance.solve();
        }
    }
}
