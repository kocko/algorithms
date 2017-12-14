package uva.volume108;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;

public class MatrixTranspose implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Cell {
        private int column, value;

        private Cell(int column, int value) {
            this.column = column;
            this.value = value;
        }
    }

    public void solve() {
        while (in.hasNextInt()) {
            int n = in.nextInt(), m = in.nextInt();
            List<List<Cell>> result = new ArrayList<>();
            for (int i = 0; i < m; i++) result.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                int count = in.nextInt();
                int[] indices = new int[count];
                for (int j = 0; j < count; j++) {
                    indices[j] = in.nextInt() - 1;
                }
                int next = 0;
                for (int j = 0; j < count; j++) {
                    result.get(indices[next++]).add(new Cell(i, in.nextInt()));
                }
            }
            out.println(m + " " + n);
            for (List<Cell> cells : result) {
                cells.sort(comparingInt(c -> c.column));
                int size = cells.size();
                out.print(size);
                if (size > 0) {
                    out.print(' ');
                    for (int i = 0; i < size; i++) {
                        out.print(cells.get(i).column + 1);
                        if (i < size - 1) out.print(' ');
                        if (i == size - 1) out.print('\n');
                    }
                    for (int i = 0; i < size; i++) {
                        out.print(cells.get(i).value);
                        if (i < size - 1) out.print(' ');
                    }
                } else {
                    out.println();
                }
                out.println();
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (MatrixTranspose instance = new MatrixTranspose()) {
            instance.solve();
        }
    }
}
