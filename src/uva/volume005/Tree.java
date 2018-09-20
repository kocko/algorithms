package uva.volume005;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

public class Tree implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            String[] inOrder = in.nextLine().split("\\s+"), postOrder = in.nextLine().split("\\s+");
            this.n = inOrder.length;
            this.idx = -1;
            this.result = MAX_VALUE;
            this.map = new HashMap<>();
            this.inOrder = new int[n];
            for (int i = 0; i < n; i++) {
                this.inOrder[i] = parseInt(inOrder[i]);
                map.put(this.inOrder[i], i);
            }
            this.postOrder = new int[n];
            for (int i = 0; i < n; i++) {
                this.postOrder[i] = parseInt(postOrder[i]);
            }
            recurse(0, n - 1, 0);
            out.println(idx);
        }
    }

    private Map<Integer, Integer> map;
    private int[] inOrder, postOrder;
    private int result, idx, n;

    private void recurse(int start, int end, int sum) {
        if (start > end) return;
        if (start == end) {
            sum += postOrder[--n];
            if (sum < result) {
                result = sum;
                idx = inOrder[start];
            } else if (sum == result) {
                idx = min(idx, inOrder[start]);
            }
        } else {
            int root = postOrder[--n];
            int inOrderIdx = map.get(root);
            recurse(inOrderIdx + 1, end, sum + root);
            recurse(start, inOrderIdx - 1, sum + root);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Tree instance = new Tree()) {
            instance.solve();
        }
    }
}
