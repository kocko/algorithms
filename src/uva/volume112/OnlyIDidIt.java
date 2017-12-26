package uva.volume112;

import java.io.*;
import java.util.*;

import static java.util.Comparator.naturalOrder;

public class OnlyIDidIt implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Player implements Comparable<Player> {
        private Set<Integer> tasks = new TreeSet<>();
        private int idx;

        private Player(int idx) {
            this.idx = idx;
        }

        private int score() {
            return tasks.size();
        }

        @Override
        public int compareTo(Player o) {
            return Integer.compare(o.score(), this.score());
        }

        @Override
        public String toString() {
            StringJoiner result = new StringJoiner(" ");
            result.add(Integer.toString(idx));
            result.add(Integer.toString(tasks.size()));
            Iterator<Integer> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                result.add(Integer.toString(iterator.next()));
            }
            return result.toString();
        }
    }

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            List<Player> list = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                list.add(new Player(i));
            }
            int f = in.ni();
            while (f-- > 0) list.get(0).tasks.add(in.ni());
            int s = in.ni();
            while (s-- > 0) list.get(1).tasks.add(in.ni());
            int th = in.ni();
            while (th-- > 0) list.get(2).tasks.add(in.ni());
            for (int i = 1; i <= 10000; i++) {
                int count = 0;
                for (int j = 0; j < 3; j++) {
                    if (list.get(j).tasks.contains(i)) count++;
                }
                if (count > 1) {
                    for (int j = 0; j < 3; j++) {
                        list.get(j).tasks.remove(i);
                    }
                }
            }
            list.sort(naturalOrder());
            out.printf("Case #%d:\n", testCase);
            int score = list.get(0).score();
            out.println(list.get(0).toString());
            for (int i = 1; i <= 2; i++) {
                if (list.get(i).score() == score) {
                    out.println(list.get(i));
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

    public static void main(String[] args) throws IOException {
        try (OnlyIDidIt instance = new OnlyIDidIt()) {
            instance.solve();
        }
    }
}
