package codeforces.contests600_699.problemset658;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BearAndDisplayedFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Friend {
        int id;
        int value;

        Friend(int id, int value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof Friend) && this.id == ((Friend) obj).id;
        }
    }

    public void solve() {
        int n = in.ni(), k = in.ni(), q = in.ni();
        Friend[] f = new Friend[n + 1];
        for (int i = 1; i <= n; i++) { f[i] = new Friend(i, in.ni()); }
        PriorityQueue<Friend> queue = new PriorityQueue<>(new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        for (int i = 0; i < q; i++) {
            int type = in.ni();
            int friendId = in.ni();
            if (type == 1) {
                queue.add(f[friendId]);
                if (queue.size() == k + 1) {
                    queue.remove();
                }
            } else {
                if (queue.contains(new Friend(friendId, -1))) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
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
        new BearAndDisplayedFriends().solve();
    }
}
