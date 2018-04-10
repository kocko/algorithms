package topcoder.tchs.srm05;

public class TVSize {

    public int[] calcSize(int d, int hr, int wr) {
        double W, H;
        W = (d * wr) / Math.sqrt(wr * wr + hr * hr);
        H = W * hr / wr;

        return new int[] {(int) H, (int) W};
    }
    
}