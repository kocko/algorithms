package acm.regionals.year2007.europe.southeast;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoubleQueue implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    class Client implements Comparable<Client> {
        int id;
        int priority;
        
        Client(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        @Override
        public int compareTo(Client o) {
            return Integer.compare(priority, o.priority);
        }
    }

    public void solve() {
        PriorityQueue<Client> min = new PriorityQueue<>();
        PriorityQueue<Client> max = new PriorityQueue<>((a, b) -> b.compareTo(a));
        while (true) {
            int next = in.ni();
            if (next == 0) break;
            else {
                if (next == 1) {
                    int k = in.ni(), p = in.ni();
                    Client client = new Client(k, p);
                    min.add(client);
                    max.add(client);
                } else if (next == 2) {
                    Client client = max.poll();
                    if (client != null) {
                        out.println(client.id);
                        min.remove(client);
                    } else {
                        out.println(0);
                    }
                } else {
                    Client client = min.poll();
                    if (client != null) {
                        out.println(client.id);
                        max.remove(client);
                    } else {
                        out.println(0);
                    }
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
        try (DoubleQueue instance = new DoubleQueue()) {
            instance.solve();
        }
    }
}
