package uva.volume005;

import java.text.DecimalFormat;
import java.util.*;

public class Frogger {

    private final List<Point> points;

    private Frogger(List<Point> points) {
        this.points = points;
    }

    private void solve(int testCase) {
        int n = points.size();
        double[][] dist = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = dist[j][i] = findDistance(points.get(i), points.get(j));
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                }
            }
        }

        System.out.println("Scenario #" + testCase);
        System.out.println("Frog Distance = " + new DecimalFormat("0.000").format(dist[0][1]));
    }

    private double findDistance(Point a, Point b) {
        int x = Math.abs(a.x - b.x);
        int y = Math.abs(a.y - b.y);
        return Math.sqrt(x * x + y * y);
    }

    private static class Point {
        int index;
        int x;
        int y;

        private Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 1;
        while (true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] split = sc.nextLine().split("\\s+");
                points.add(new Point(i, Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            }
            new Frogger(points).solve(testCase++);
            sc.nextLine();
            System.out.println();
        }
    }

}
