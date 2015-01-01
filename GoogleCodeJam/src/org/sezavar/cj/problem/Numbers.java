package org.sezavar.cj.problem;

import java.math.BigDecimal;

import org.sezavar.cj.util.InputOutputType;

public class Numbers extends Problem {

	@Override
	protected StringBuffer _solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected strictfp StringBuffer _solveEachSet() {
		int n = this.readInt();
		double number = 3 + Math.pow(5, 0.5);
		double dotPart = number - Math.floor(number);
		long intPart = (long) Math.floor(number);
		int m10 = 0;
		double last = number;
		int i = 2;
		while (i <= n) {
			// last += number * dotPart;
			intPart = (long) Math.floor(last);
			dotPart = last - intPart;
			double sum = number * dotPart;
			m10 = 0;
			while (sum < 1000 && intPart > 0) {
				sum += (intPart % 10) * Math.pow(10, m10) * number;
				intPart = intPart / 10;
				m10++;
			}
			last = sum;
			i++;
		}
		int lastIntPart = (int) Math.floor(last);
		String result = "";
		int c = 1;
		while (lastIntPart > 0 && c < 4) {
			result = lastIntPart % 10 + result;
			lastIntPart = lastIntPart / 10;
			c++;
		}
		if (n == 2) {
			result = "0" + result;
		}
		this.rs.append(result);
		return rs;
	}

	public static strictfp void main(String[] args) {
		// double number = 3 + Math.pow(5, 0.5);
		// int n = 2;
		// double dotPart = number - Math.floor(number);
		// long intPart = (long) Math.floor(number);
		// int m10 = 0;
		// double last = number;
		// int i = 2;
		// while (i <= n) {
		// // last += number * dotPart;
		// intPart = (long) Math.floor(last);
		// dotPart = last - intPart;
		// double sum = number * dotPart;
		// m10 = 0;
		// while (sum < 1000 && intPart > 0) {
		// sum += (intPart % 10) * Math.pow(10, m10) * number;
		// intPart = intPart / 10;
		// m10++;
		// }
		// last = sum;
		// i++;
		// }
		// int lastIntPart = (int) Math.floor(last);
		// String result = "";
		// int c = 1;
		// while (lastIntPart > 0 && c < 4) {
		// result = lastIntPart % 10 + result;
		// lastIntPart = lastIntPart / 10;
		// c++;
		// }
		// if (n == 2) {
		// result = "0" + result;
		// }
		// System.out.println(result);
		Problem p = new Numbers();
		;
		p.solveSetsFor(InputOutputType.SMALL);
	}
}
