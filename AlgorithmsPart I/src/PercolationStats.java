public class PercolationStats {
	public PercolationStats(int N, int T) { // perform T independent experiments
											// on an N-by-N grid
		if (T > 0 && N > 0) {

		} else {
			throw new java.lang.IllegalArgumentException();
		}

	}

	public double mean() { // sample mean of percolation threshold
		double result = 0;
		return result;
	}

	public double stddev() { // sample standard deviation of percolation
								// threshold
		double result = 0;
		return result;
	}

	public double confidenceLo() { // low endpoint of 95% confidence interval
		double result = 0;
		return result;
	}

	public double confidenceHi() { // high endpoint of 95% confidence interval
		double result = 0;
		return result;
	}

	public static void main(String[] args) {
		// test client (described below)
		
	}
}
