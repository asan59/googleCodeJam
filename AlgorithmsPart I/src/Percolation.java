public class Percolation {
	private int N;
	private int[][] grid;
	private WeightedQuickUnionUF u;
	private final static int BLOCKED_VALUE = 1;
	private final static int OPENED_VALUE = 0;
	private final int topVirtualNodeIndex;
	private final int bottomVirtualNodeIndex;

	public Percolation(int N) { // create N-by-N grid, with all sites blocked
		if (N > 0) {
			this.N = N;
			this.grid = new int[N][N];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					this.grid[i - 1][j - 1] = BLOCKED_VALUE;
				}
			}
			u = new WeightedQuickUnionUF((N ^ 2) + 2);
			topVirtualNodeIndex = N ^ 2 + 1;
			bottomVirtualNodeIndex = N ^ 2 + 2;
			for (int j = 1; j <= N; j++) {
				u.union(topVirtualNodeIndex, j);
				u.union(bottomVirtualNodeIndex, N * (N - 1) + j);
			}
		} else {
			throw new java.lang.IllegalArgumentException();
		}
	}

	public void open(int i, int j) { // open site (row i, column j) if it is not
		// open already
		if (0 < i && i <= N && 0 < j && j <= N) {
			this.grid[i - 1][j - 1] = OPENED_VALUE;
			try {
				if (this.isOpen(i + 1, j)) {
					u.union((i - 1) * N + j - 1, i * N + j - 1);
				}
			} catch (IndexOutOfBoundsException e) {

			}
			try {
				if (this.isOpen(i - 1, j)) {
					u.union((i - 1) * N + j - 1, (i - 2) * N + j - 1);
				}
			} catch (IndexOutOfBoundsException e) {

			}
			try {
				if (this.isOpen(i, j + 1)) {
					u.union((i - 1) * N + j - 1, (i - 1) * N + j);
				}
			} catch (IndexOutOfBoundsException e) {

			}
			try {
				if (this.isOpen(i, j - 1)) {
					u.union((i - 1) * N + j - 1, (i - 1) * N + j - 2);
				}
			} catch (IndexOutOfBoundsException e) {

			}
		} else {
			throw new java.lang.IndexOutOfBoundsException();
		}

	}

	public boolean isOpen(int i, int j) { // is site (row i, column j) open?
		validate(i, j);
		return this.grid[i - 1][j - 1] == OPENED_VALUE;

	}

	public boolean isFull(int i, int j) { // is site (row i, column j) full?
		validate(i, j);
		return (u.connected((i - 1) * N + j - 1, topVirtualNodeIndex));
	}

	public boolean percolates() { // does the system percolate?
		return u.connected(topVirtualNodeIndex, bottomVirtualNodeIndex);
	}

	private void validate(int i, int j) {
		if (i <= 0 || i > N || j <= 0 || j > N) {
			throw new IndexOutOfBoundsException("index out of bound");
		}
	}

	public static void main(String[] args) { // test client (optional)

	}
}
