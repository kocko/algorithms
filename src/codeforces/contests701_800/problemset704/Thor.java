package codeforces.contests701_800.problemset704;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Thor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Message {
        int from;
        boolean read;
        
        Message(int from) {
            this.from = from;
        }

        private void markAsRead() {
            read = true;
        }
    }

    public void solve() {
        int n = in.ni(), q = in.ni(), total = 0, read = 0, startFrom = 0;
        List<Message> notificationFrom = new ArrayList<>();
        List<List<Message>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        while (q-- > 0) {
            int type = in.ni();
            switch (type) {
                case 1 : {
                    int x = in.ni();
                    Message message = new Message(x);
                    map.get(x).add(message);
                    notificationFrom.add(message);
                    total++;
                    break;
                }
                case 2: {
                    int x = in.ni();
                    List<Message> messagesFromX = map.get(x);
                    for (Message m : messagesFromX) {
                        if (!m.read) {
                            read++;
                            m.markAsRead();
                        }
                    }
                    map.set(x, new ArrayList<>());
                    break;
                }
                case 3: {
                    int t = in.ni();
                    if (t > startFrom) {
                        for (int i = startFrom; i < t; i++) {
                            Message next = notificationFrom.get(i);
                            if (!next.read) {
                                next.markAsRead();
                                read++;
                            }
                        }
                        startFrom = t;
                    }
                    break;
                }
            }
            out.println(total - read);
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
        try (Thor instance = new Thor()) {
            instance.solve();
        }
    }
}
