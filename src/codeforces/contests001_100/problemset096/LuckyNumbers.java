package codeforces.contests001_100.problemset096;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class LuckyNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    private List<String> lucky = new ArrayList<>();

    public void solve() {
        int n = in.ni();
        generateLucky("");
        long[] list = lucky.stream().mapToLong(Long::valueOf).sorted().toArray();
        int left = 0;
        int right = lucky.size() - 1;
        long result = Long.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] >= n) {
                result = Math.min(result, list[mid]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        out.println(result);
    }

    private void generateLucky(String current) {
        if (current.length() <= 10) {
            int four = 0, seven = 0;
            for (char c : current.toCharArray()) {
                if (c == '4') four++;
                else seven++;
            }
            if (four == seven && four != 0) {
                lucky.add(current);
            }
            String x = current + "4";
            generateLucky(x);
            String y = current + "7";
            generateLucky(y);
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

    public static void main(String[] args) {
        new LuckyNumbers().solve();
    }
}
