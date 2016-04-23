package topcoder.contests601_700.srm689;

public class SimilarUserDetection {

    public String haveSimilar(String[] handles) {
        int n = handles.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (similar(handles[i], handles[j])) {
                    return "Similar handles found";
                }
            }
        }
        return "Similar handles not found";
    }

    private boolean similar(String s, String t) {
        if (s.length() == t.length()) {
            int n = s.length();
            char[] a = s.toCharArray(), b = t.toCharArray();
            boolean result = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    result &= (o(a[i]) && o(b[i])) || (i(a[i]) && i(b[i]));
                }
            }
            return result;
        }
        return false;
    }

    private boolean o(char c) {
        return c == 'O' || c == '0';
    }

    private boolean i(char c) {
        return c == '1' || c == 'l' || c == 'I';
    }

    public static void main(String[] args) {
        System.out.println(new SimilarUserDetection().haveSimilar(new String[]{"tOp", "t0p"}));
    }

}
