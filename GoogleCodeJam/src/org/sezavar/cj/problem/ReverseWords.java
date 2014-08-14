package org.sezavar.cj.problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.sezavar.cj.util.InputOutputType;

public class ReverseWords extends Problem {

	public static void main(String[] args) {
		Problem problem = new ReverseWords();
		problem.solveSetsFor(InputOutputType.LARGE);

	}

	@Override
	protected StringBuffer _solve() {
		return this.rs;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		List<String> l = Arrays.asList(this.reader.nextLine().split(" "));
		Collections.reverse(l);
		for (String token : l) {
			this.rs.append(token.trim() + " ");
		}
		return this.rs;
	}

}
