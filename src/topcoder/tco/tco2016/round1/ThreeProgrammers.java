package topcoder.tco.tco2016.round1;

public class ThreeProgrammers {

    public String validCodeHistory(String code) {
        char[] ch = code.toCharArray();
        int a = 0, b = 0, c = 0;
        int n = ch.length;
        for (char x : ch) {
            if (x == 'A') a++;
            if (x == 'B') b++;
            if (x == 'C') c++;
        }
        if (3 * c - 2 > n) return "impossible";
        if (2 * b - 1 > n) return "impossible";

        char[] result = new char[n];
        int next = 0;
        if (c >= b) {
            for (int i = 0; i < c; i++) {
                if (next >= n) return "impossible";
                else {
                    result[next] = 'C';
                    next += 3;
                }
            }
            next = 0;
            for (int i = 0; i < b; i++) {
                if (next >= n) return "impossible";
                else {
                    if (result[next] == 'C') {
                        i--;
                        next++;
                        continue;
                    }
                    result[next] = 'B';
                    next += 2;
                }
            }
        } else {
            for (int i = 0; i < b; i++) {
                if (next >= n) return "impossible";
                else {
                    result[next] = 'B';
                    next += 2;
                }
            }
            next = 0;
            for (int i = 0; i < c; i++) {
                if (next >= n) return "impossible";
                else {
                    if (result[next] == 'B') {
                        i--;
                        next++;
                        continue;
                    }
                    result[next] = 'C';
                    next += 3;
                }
            }
        }

        next = 0;
        for (int i = 0; i < a; i++) {
            if (result[next] == 'C' || result[next] == 'B') {
                i--;
                next++;
                continue;
            }
            result[next] = 'A';
            next++;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new ThreeProgrammers().validCodeHistory("CCCCCCCCCCCCCCCCCBBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAA"));
    }

}
