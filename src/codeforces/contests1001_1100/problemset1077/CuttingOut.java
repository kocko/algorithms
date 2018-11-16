package codeforces.contests1001_1100.problemset1077;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CuttingOut implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] cnt = new int[200001];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            cnt[next]++;
        }
        List<Value> list = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                list.add(new Value(i, cnt[i]));
            }
        }
        list.sort(Comparator.naturalOrder());

        int left = 1, right = n / k;
        int maxTimes = 0;
        int[] result = new int[k];
        while (left <= right) {
            int mid = (left + right) / 2; // that many cuts
            int[] temp = new int[k];
            int idx = 0;
            boolean ok = true;
            for (int i = 0; i < list.size(); i++) {
                Value v = list.get(i);
                if (idx == k) break;
                if (mid > v.count) {
                    ok = false;
                    break;
                } else {
                    int repetitions = v.count / mid;
                    for (int j = 0; j < repetitions && idx < k; j++) {
                        temp[idx++] = v.val;
                    }
                }
            }
            if (ok) {
                if (mid > maxTimes) {
                    maxTimes = mid;
                    result = temp;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        for (int value : result) {
            out.print(value);
            out.print(' ');
        }
    }

    private class Value implements Comparable<Value> {
        private int val, count;

        private Value(int val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Value o) {
            return Integer.compare(o.count, this.count);
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
        try (CuttingOut instance = new CuttingOut()) {
            instance.solve();
        }
    }
}
