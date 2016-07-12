package topcoder.contests300_400.srm302;

public class NounReform {

    public String[] makePlural(String[] nouns) {
        int n = nouns.length;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String c = nouns[i];
            char last = c.charAt(c.length() - 1);
            String lastTwo = c.length() >= 2 ? c.substring(c.length() - 2) : "";
            if (last == 's' || last == 'z' || last == 'x' || "ch".equals(lastTwo) || "sh".equals(lastTwo)) {
                result[i] = c + "es";
            } else if ("ay".equals(lastTwo) || "ey".equals(lastTwo) || "iy".equals(lastTwo) || "oy".equals(lastTwo) || "uy".equals(lastTwo)) {
                result[i] = c + "s";
            } else if (last == 'y') {
                result[i] = c.substring(0, c.length() - 1) + "ies";
            } else {
                result[i] = c + "s";
            }
        }
        return result;
    }
}
