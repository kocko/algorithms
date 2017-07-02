package topcoder.contests401_500.srm446;

public class SoldierLabeling {

    public int count(int n, int low, int high) {
        int lo = 1, hi = 1;
        for (int i = 1; i < low; i++) lo *= 10;
        for (int i = 0; i < high; i++) hi *= 10;
        if (n < lo) return 0;
        if (n < hi) return n - lo + 1;
        return hi - lo;
    }

    public static void main(String[] args) {
        System.out.println(new SoldierLabeling().count(100, 2, 2));
        System.out.println(new SoldierLabeling().count(31, 2, 3));
        System.out.println(new SoldierLabeling().count(1, 2, 8));
        System.out.println(new SoldierLabeling().count(10000000, 8, 8));
        System.out.println(new SoldierLabeling().count(2718317, 3, 7));
    }
}
