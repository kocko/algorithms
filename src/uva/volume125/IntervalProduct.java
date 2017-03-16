package uva.volume125;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class IntervalProduct implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private int[] arr;
        private int[] zeroTree;
        private int[] oneTree;
        
        private int max;
        
        private FenwickTree(int[] arr) {
            this.max = arr.length;
            this.arr = new int[max];
            zeroTree = new int[max + 1];
            oneTree = new int[max + 1];
            for (int i = 1; i <= max; i++) {
                if (arr[i - 1] == 0) {
                    updateCount(zeroTree, i, 1);
                } else {
                    int value = arr[i - 1] / Math.abs(arr[i - 1]);
                    if (value == 1) {
                        updateCount(oneTree, i, 1);
                    }
                    this.arr[i - 1] = value;
                }
            }
        }
        
        private void updateCount(int[] tree, int idx, int delta) {
            for (; idx <= max; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }
        
        private int query(int left, int right) {
            int a = queryCount(zeroTree, right), b = queryCount(zeroTree, left - 1);
            if (a == b) {
                int x = queryCount(oneTree, right), y = queryCount(oneTree, left - 1);
                int ones = x - y;
                int minus = right - left + 1 - ones;
                return (minus % 2 == 0) ? 1 : -1;
            }
            return 0;
        }
        
        private int queryCount(int[] tree, int idx) {
            int result = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
        
        private void update(int idx, int value) {
            int old = arr[idx - 1];
            if (old == 0) {
                updateCount(zeroTree, idx, -1);
            } else if (old > 0) {
                updateCount(oneTree, idx, -1);
            }
            arr[idx - 1] = value;
            if (value >= 0) {
                int[] tree = value == 0 ? zeroTree : oneTree;
                updateCount(tree, idx, 1);
            }
        }
    }

    public void solve() throws IOException {
        String next;
        while ((next = in.readLine()) != null) {
            String[] line = next.split("\\s+");
            int n = Integer.parseInt(line[0]);
            int q = Integer.parseInt(line[1]);
            int[] arr = new int[n];
            line = in.readLine().split("\\s+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            FenwickTree tree = new FenwickTree(arr);
            for (int i = 0; i < q; i++) {
                line = in.readLine().split("\\s+");
                char type = line[0].charAt(0);
                if (type == 'C') {
                    int idx = Integer.parseInt(line[1]);
                    int value = Integer.parseInt(line[2]);
                    value = value == 0 ? 0 : value / Math.abs(value);
                    tree.update(idx, value);
                } else {
                    int left = Integer.parseInt(line[1]);
                    int right = Integer.parseInt(line[2]);
                    int answer = tree.query(left, right);
                    if (answer == 0) {
                        out.print('0');
                    } else if (answer > 0) {
                        out.print('+');
                    } else {
                        out.print('-');
                    }
                }
            }
            out.println();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (IntervalProduct instance = new IntervalProduct()) {
            instance.solve();
        }
    }
}
