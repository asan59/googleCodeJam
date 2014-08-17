package org.sezavar.cj.problem;

import org.sezavar.cj.util.GcjUtil;
import org.sezavar.cj.util.InputOutputType;

public class StoreCredit extends Problem {

	public static void main(String[] args) {
		StoreCredit storeCredit = new StoreCredit();
		storeCredit.solveSetsFor(InputOutputType.LARGE);
	}

	@Override
	protected StringBuffer _solve() {
		return this.rs;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		int c = Integer.valueOf(this.reader.nextLine().trim()); // Credit amount
		int i = Integer.valueOf(this.reader.nextLine()); // Number of items
		int[] prices = GcjUtil
				.lineToArrayOfInts(this.reader.nextLine(), " ");
		for (int j = 0; j < prices.length; j++) {
			for (int k = j + 1; k < prices.length; k++) {
				if (prices[j] + prices[k] == c) {
					this.rs.append((j + 1) + " " + (k + 1));
				}
			}
		}
		return this.rs;
	}

}
