package org.sezavar.cj.problem;

import org.sezavar.cj.util.InputOutputType;

public class ReverseWords extends Problem {

	public static void main(String[] args) {
		Problem problem = new ReverseWords();
		problem.solveSetsFor(InputOutputType.VERY_SMALL);

	}

	@Override
	protected StringBuffer _solve() {
		return this.rs;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		return this.rs;
	}

}
