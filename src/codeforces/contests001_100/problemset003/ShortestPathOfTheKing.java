package codeforces.contests001_100.problemset003;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ShortestPathOfTheKing implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public void solve() throws IOException {
        String start = in.readLine();
        String end = in.readLine();

        int kingCol = start.charAt(0) - 'a', kingRow = start.charAt(1) - '0';
        int endCol = end.charAt(0) - 'a', endRow = end.charAt(1) - '0';
        boolean diffCol = kingCol != endCol;
        boolean diffRow = kingRow != endRow;

        int absCol = Math.abs(kingCol - endCol);
        int absRow = Math.abs(kingRow - endRow);

        List<String> path = new ArrayList<>();
        String dir;
        if (diffRow && diffCol) {
            dir = (endCol > kingCol) ? "R" : "L";
            dir += (endRow > kingRow) ? "U" : "D";
            int limit = Math.min(absCol, absRow);
            for (int i = 0; i < limit; i++) {
                path.add(dir);
            }
            limit = Math.max(absCol, absRow) - limit;
            if (absCol > absRow) {
                if (endCol > kingCol) {
                    kingCol += path.size();
                } else {
                    kingCol -= path.size();
                }
                dir = (endCol > kingCol) ? "R" : "L";
            } else {
                if (endRow > kingRow) {
                    kingRow += path.size();
                } else {
                    kingRow -= path.size();
                }
                dir = (endRow > kingRow) ? "U" : "D";
            }
            for (int i = 0; i < limit; i++) {
                path.add(dir);
            }
        } else if (diffRow) {
            dir = (endRow > kingRow) ? "U" : "D";
            for (int i = 0; i < absRow; i++) {
                path.add(dir);
            }
        } else if (diffCol) {
            dir = (endCol > kingCol) ? "R" : "L";
            for (int i = 0; i < absCol; i++) {
                path.add(dir);
            }
        } else {
            out.println(0);
            return;
        }

        out.println(path.size());
        path.forEach(out::println);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (ShortestPathOfTheKing instance = new ShortestPathOfTheKing()) {
            instance.solve();
        }
    }

}
