package org.sezavar.cj.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.sezavar.cj.util.GcjUtil;
import org.sezavar.cj.util.InputOutputType;

;

public class MinimumScalarProduct extends Problem {
	List<Integer> x;
	List<Integer> y;

	@Override
	protected StringBuffer _solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		int n = Integer.valueOf(this.reader.nextLine());
		this.x = GcjUtil.lineToListOfIntegers(this.reader.nextLine(),
				" ");
		this.y = GcjUtil.lineToListOfIntegers(this.reader.nextLine(),
				" ");
		long sum = this.doItLikeThem(x, y);

		this.rs.append(sum);
		return this.rs;
	}

	public static void main(String[] args) {
		Problem p = new MinimumScalarProduct();
		p.solveSetsFor(InputOutputType.SMALL);

	}

	private long doItLikeThem(List<Integer> l1, List<Integer> l2) {
		long sum = 0;
		Collections.sort(l1);
		Collections.sort(l2);
		Collections.reverse(l2);
		for (int i = 0; i < l1.size(); i++) {
			sum += l1.get(i) * l2.get(i);
		}
		return sum;

	}
}
