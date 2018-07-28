package topcoder.contests501_600.srm572;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.pow;

public class EllysBulls {

    public String getNumber(String[] guesses, int[] bulls) {
        n = guesses.length;
        k = guesses[0].length();
        scores = bulls;
        guess = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                guess[i][j] = guesses[i].charAt(j) - '0';
            }
        }
        left();
        right();
        if (possible == 0) {
            return "Liar";
        } else if (possible > 1) {
            return "Ambiguity";
        } else {
            return result;
        }
    }

    private int n, k, possible;
    private int[][] guess;
    private int[] scores;

    private HashMap<Long, List<int[]>> map = new HashMap<>();
    private String result;

    private void left() {
        int half = k / 2, max = (int) pow(10, half);
        for (int i = 0; i < max; i++) {
            int[] score = new int[n];
            int[] value = normalize(i, half);

            for (int j = 0; j < n; j++) {
                for (int idx = 0; idx < half; idx++) {
                    if (guess[j][idx] == value[idx]) score[j]++;
                }
            }
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                ok &= (score[j] <= scores[j]);
                score[j] = scores[j] - score[j];
            }
            if (ok) {
                long hash = hash(score);
                List<int[]> list = map.getOrDefault(hash, new ArrayList<>());
                list.add(value);
                map.put(hash, list);
            }
        }
    }

    private void right() {
        int half = k / 2, max = (int) pow(10, k - half);
        for (int i = 0; i < max; i++) {
            int[] score = new int[n];
            int[] value = normalize(i, k - half);
            for (int j = 0; j < n; j++) {
                for (int idx = half; idx < k; idx++) {
                    if (guess[j][idx] == value[idx - half]) {
                        score[j]++;
                    }
                }
            }

            boolean ok = true;
            for (int j = 0; j < n; j++) {
                ok &= (score[j] <= scores[j]);
            }
            if (ok) {
                long hash = hash(score);
                if (map.containsKey(hash)) {
                    List<int[]> list = map.get(hash);
                    if (list.size() > 1) {
                        possible += list.size();
                    } else if (list.size() == 1) {
                        int[] h = list.get(0);
                        StringBuilder sb = new StringBuilder();
                        for (int p : h) sb.append(p);
                        for (int p : value) sb.append(p);
                        possible++;
                        if (result == null) {
                            result = sb.toString();
                        }
                    }
                }
            }

        }
    }

    private int[] normalize(int value, int size) {
        int[] result = new int[size];
        int idx = size - 1;
        while (value > 0) {
            result[idx--] = value % 10;
            value /= 10;
        }
        return result;
    }

    private long hash(int[] score) {
        final long BASE = 13;
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = result * BASE + (score[i] + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new EllysBulls().getNumber(new String[]{"925833420", "428667474", "341137424", "128302424", "528097704", "208332280", "058533582", "018344464", "976534348", "876106084", "435436585", "148083488", "416837064", "938538714", "378234621", "902097680", "588047470", "940935888", "568438021", "901069584", "028437000", "998612754", "935932465", "838797564", "678424030", "961453420", "089007482", "950737920", "874936435", "971217992", "978134930", "478547368", "489347434", "392967404", "738456114", "381414480", "983037632", "977267914", "092436124", "270760884", "876367885", "878634276", "108431644", "671172384", "128157734", "978504850", "308407903", "628067456", "316477446", "985297514"}, new int[]{3, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 4, 3, 3, 3, 3, 3, 3, 3}));
    }
}
