package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeOrder implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Node {
        private int value;
        private Node left, right;

        public void setValue(int value) {
            this.value = value;
        }
    }

    public void solve() {
        int n = in.ni();
        preorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = in.ni();
        }
        postorder = new int[n];
        for (int i = 0; i < n; i++) {
            postorder[i] = in.ni();
        }
        inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = in.ni();
        }
        Node root = new Node();
        recurse(root, 0, n - 1);
        postOrder(root);
        verify();
    }
    
    private int[] preorder, postorder, inorder;
    private int idx;
    
    private Node recurse(Node node, int start, int end) {
        if (start <= end) {
            node.setValue(preorder[idx]);
            int i;
            for (i = start; i <= end; i++) {
                if (inorder[i] == preorder[idx]) break;
            }
            idx++;
            node.left = recurse(new Node(), start, i - 1);
            node.right = recurse(new Node(), i + 1, end);
            return node;
        }
        return null;
    }
    
    private List<Integer> list = new ArrayList<>();
    
    private void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        list.add(root.value);
    }
    
    private void verify() {
        if (list.size() == postorder.length) {
            boolean ok = true;
            for (int i = 0; i < postorder.length; i++) {
                ok &= list.get(i) == postorder[i];
            }
            out.println(ok ? "yes" : "no");
        } else {
            out.println("no");
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
        try (TreeOrder instance = new TreeOrder()) {
            instance.solve();
        }
    }
}
