package codeforces.contests301_400.problemset321;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class KefaAndCompany implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Friend implements Comparable<Friend> {
        long money;
        long rate;
        
        Friend(long money, long rate) {
            this.money = money;
            this.rate = rate;
        }

        @Override
        public int compareTo(Friend o) {
            return Long.compare(this.money, o.money);
        }
        
    }
    
    public void solve() {
        int n = in.ni(); long d = in.ni();
        List<Friend> list = new ArrayList<>();
        list.add(new Friend(Long.MIN_VALUE, 0));
        for (int i = 0; i < n; i++) {
            list.add(new Friend(in.nl(), in.nl()));
        }
        Collections.sort(list);
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 1; i < list.size(); i++) {
            prefix[i] = prefix[i - 1]  + list.get(i).rate;
        }
        long result = 0;
        for (int i = 0; i < n + 1; i++) {
            int left = i, right = n, j = i;
            long current = list.get(i).money;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (list.get(mid).money - d >= current) {
                    right = mid - 1;    
                } else {
                    left = mid + 1;
                    j = mid;
                }
            }
            if (i == j) {
                result = Math.max(result, list.get(i).rate);
            } else {
                result = Math.max(result, prefix[j] - prefix[i - 1]);
            }
        }
        out.println(result);
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
        new KefaAndCompany().solve();
    }
}
