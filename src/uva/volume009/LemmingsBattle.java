package uva.volume009;

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

import static java.util.Comparator.reverseOrder;

public class LemmingsBattle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int battlefields = in.ni(), green = in.ni(), blue = in.ni();
            PriorityQueue<Integer> greenArmy = new PriorityQueue<>(reverseOrder()), blueArmy = new PriorityQueue<>(reverseOrder());
            for (int i = 0; i < green; i++) greenArmy.add(in.ni());
            for (int i = 0; i < blue; i++) blueArmy.add(in.ni());
            while ((green = greenArmy.size()) > 0 & (blue = blueArmy.size()) > 0) {
                List<Integer> g = new ArrayList<>(), b = new ArrayList<>();
                for (int i = 0; i < battlefields; i++) {
                    if (greenArmy.size() == 0 | blueArmy.size() == 0) break;
                    Integer x = greenArmy.poll(), y = blueArmy.poll();
                    if (x > y) g.add(x - y);
                    else if (y > x) b.add(y - x);
                }
                greenArmy.addAll(g);
                blueArmy.addAll(b);
            }
            if (green == 0 && blue == 0) {
                out.println("green and blue died");
            } else if (blue > 0) {
                out.println("blue wins");
                for (int i = 0; i < blue; i++) {
                    out.println(blueArmy.poll());
                }
            } else {
                out.println("green wins");
                for (int i = 0; i < green; i++) {
                    out.println(greenArmy.poll());
                }
            }
            if (t > 0) out.println();
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
        try (LemmingsBattle instance = new LemmingsBattle()) {
            instance.solve();
        }
    }
}
