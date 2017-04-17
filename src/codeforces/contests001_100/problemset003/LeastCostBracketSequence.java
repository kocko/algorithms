package codeforces.contests001_100.problemset003;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LeastCostBracketSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Wildcard implements Comparable<Wildcard> {
        private int idx;
        private long diff;
        
        private Wildcard(int idx, long diff) {
            this.idx = idx;
            this.diff = diff;
        }

        @Override
        public int compareTo(Wildcard o) {
            return Long.compare(this.diff, o.diff);
        }
    }

    public void solve() {
        char[] x = in.next().toCharArray();
        PriorityQueue<Wildcard> queue = new PriorityQueue<>();
        int n = x.length, cost = 0;
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == '(')  {
                cost++;
            } else if (x[i] == ')') {
                cost--;
            } else {
                long left = in.ni(), right = in.ni();
                queue.offer(new Wildcard(i, left - right));
                result += right;
                x[i] = ')';
                cost--;
            }
            
            if (cost < 0) {
                if (queue.isEmpty()) {
                    out.println(-1);
                    return;
                } else {
                    Wildcard top = queue.poll();
                    x[top.idx] = '(';
                    result += top.diff;
                    cost += 2;
                }
            }
        }
        if (cost > 0) {
            out.println(-1);
        } else {
            out.println(result);
            for (char c : x) out.print(c);
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
        try (LeastCostBracketSequence instance = new LeastCostBracketSequence()) {
            instance.solve();
        }
    }
}
