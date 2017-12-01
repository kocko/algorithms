package topcoder.tchs.srm02;

public class FountainOfLife {
	
	public double elixirOfDeath(int elixir, int poison, int pool) {
		if (poison <= elixir) return -1d;
		double d = (poison - elixir);
		return pool / d;
	}
	
}
