package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Argus implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Query implements Comparable<Query> {

        private int id;
        private int interval;
        private int moment;
        
        private Query(int id, int interval, int moment) {
            this.id = id;
            this.interval = interval;
            this.moment = moment;
        }
        
        @Override
        public int compareTo(Query o) {
            int x = Integer.compare(this.moment, o.moment);
            return (x != 0) ? x : Integer.compare(id, o.id); 
        }
        
    }

    public void solve() throws IOException {
        String line;
        PriorityQueue<Query> queue = new PriorityQueue<>();
        while (!"#".equals((line = in.readLine()))) {
            String[] split = line.split("\\s+");
            int id = Integer.parseInt(split[1]);
            int interval = Integer.parseInt(split[2]);
            queue.offer(new Query(id, interval, interval));
        }
        int k = Integer.parseInt(in.readLine());
        while (k-- > 0) {
            Query top = queue.poll();
            out.println(top.id);
            top.moment += top.interval;
            queue.offer(top);
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
        try (Argus instance = new Argus()) {
            instance.solve();
        }
    }
}
