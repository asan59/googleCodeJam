package org.sezavar.cj.problem;

import org.sezavar.cj.util.InputOutputType;

public class StoreCredit extends Problem {

	public static void main(String[] args) {
		StoreCredit storeCredit = new StoreCredit();
		storeCredit.solveFor(InputOutputType.SMALL);
	}

	@Override
	protected void _solve() {
		this.rs.append("hello worlds!");

	}

}
