package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TreeRecovery implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    private class Node {
        private char value;
        private Node left, right;

        public void setValue(char value) {
            this.value = value;
        }
    }

    public void solve() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            String[] split = line.split("\\s++");
            preorder = split[0].toCharArray();
            inorder = split[1].toCharArray();
            int n = preorder.length;
            idx = 0;
            Node root = new Node();
            recurse(root, 0, n - 1);
            postOrder(root);
            out.println();
        }
    }

    private char[] preorder, inorder;
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
    
    private void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        out.print(node.value);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TreeRecovery instance = new TreeRecovery()) {
            instance.solve();
        }
    }
}
