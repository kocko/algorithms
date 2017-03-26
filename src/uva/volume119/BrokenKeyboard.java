package uva.volume119;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BrokenKeyboard implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    private class Node {
        private char value;
        private Node next;

        private Node(char value) {
            this.value = value;
        }
    }

    private class LinkedList {
        private Node head;
        private Node tail;

        private void addToParent(Node node, Node parent) {
            if (parent == null) {
                if (head == null && tail == null) {
                    head = tail = node;
                } else {
                    node.next = head;
                    head = node;
                }
            } else {
                if (parent == tail) {
                    parent.next = node;
                    tail = node;
                } else {
                    Node next = parent.next;
                    parent.next = node;
                    node.next = next;
                }
            }
        }
    }

    public void solve() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            char[] x = line.toCharArray();
            LinkedList text = new LinkedList();
            Node parent = null;
            for (char c : x) {
                if (c == '[') {
                    parent = null;
                } else if (c == ']') {
                    parent = text.tail;
                } else {
                    Node node = new Node(c);
                    text.addToParent(node, parent);
                    parent = node;
                }
            }
            print(text);
        }
    }

    private void print(LinkedList list) {
        Node head = list.head;
        while (head != null) {
            out.print(head.value);
            head = head.next;
        }
        out.println();
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
        try (BrokenKeyboard instance = new BrokenKeyboard()) {
            instance.solve();
        }
    }
}
