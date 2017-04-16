package codeforces.contests701_800.problemset797;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BrokenBST implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            int value = in.ni(), left = in.ni(), right = in.ni();
            nodes[i] = new Node(value, left, right);
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            int left = nodes[i].leftIdx, right = nodes[i].rightIdx;
            if (left > 0) {
                nodes[i].left = nodes[left];
                root ^= left;
            }
            if (right > 0) {
                nodes[i].right = nodes[right];
                root ^= right;
            }
            root ^= i;
        }
        validate(nodes[root], -INF, INF);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!result.contains(nodes[i].value)) {
                ans++;
            }
        }
        out.println(ans);
    }

    private class Node {
        private int value, leftIdx, rightIdx;
        private Node left, right;

        private Node(int value, int leftIdx, int rightIdx) {
            this.value = value;
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }
    }
    
    private final int INF = (int) (1e9);
    private Set<Integer> result = new HashSet<>();
    
    private void validate(Node node, int min, int max) {
        if (node.value > min && node.value < max) result.add(node.value);
        if (node.left != null)  validate(node.left, min, Math.min(max, node.value));
        if (node.right != null) validate(node.right, Math.max(min, node.value), max);
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
        try (BrokenBST instance = new BrokenBST()) {
            instance.solve();
        }
    }
}
