package org.sezavar.cj.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.sezavar.cj.util.GoogleCodeJamUtil;
import org.sezavar.cj.util.InputOutputType;

;

public class MinimumScalarProduct extends Problem {
	List<Integer> x;
	List<Integer> y;
	int x1;
	int x2;
	int y1;
	int y2;

	@Override
	protected StringBuffer _solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		int n = Integer.valueOf(this.reader.nextLine());
		this.x = GoogleCodeJamUtil.lineToListOfIntegers(this.reader.nextLine(),
				" ");
		this.y = GoogleCodeJamUtil.lineToListOfIntegers(this.reader.nextLine(),
				" ");
		Collections.sort(this.x);
		Collections.sort(this.y);
		long sum = 0;
		while (x.size() > 0) {
			this.x1 = 0;
			this.x2 = this.x.size() - 1;
			this.y1 = 0;
			this.y2 = this.y.size() - 1;
			MyClass m = this.getMin();
			sum += m.multi;
			this.x.remove(m.x);
			this.y.remove(m.y);
		}
		this.rs.append(sum);
		return this.rs;
	}

	public MyClass getMin() {
		List<MyClass> listOfMulty = new ArrayList<>();
		listOfMulty.add(new MyClass(x1, y1, this.x.get(x1) * this.y.get(y1)));
		listOfMulty.add(new MyClass(x1, y2, this.x.get(x1) * this.y.get(y2)));
		listOfMulty.add(new MyClass(x2, y1, this.x.get(x2) * this.y.get(y1)));
		listOfMulty.add(new MyClass(x2, y2, this.x.get(x2) * this.y.get(y2)));
		Collections.sort(listOfMulty);
		return listOfMulty.get(0);
	}

	class MyClass implements Comparable<MyClass> {
		int x;
		int y;
		int multi;

		public MyClass(int x, int y, int multi) {
			super();
			this.x = x;
			this.y = y;
			this.multi = multi;
		}

		@Override
		public int compareTo(MyClass arg0) {
			if (this.multi > arg0.multi) {
				return +1;
			} else if (this.multi < arg0.multi) {
				return -1;
			} else if (multi == 0) {
				if (this.x + this.y > arg0.x + arg0.y)
					return -1;
				else
					return 1;
			}
			return 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + multi;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyClass other = (MyClass) obj;
			if (multi != other.multi)
				return false;
			return true;
		}

	}

	public static void main(String[] args) {
		Problem p = new MinimumScalarProduct();
		p.solveSetsFor(InputOutputType.LARGE);

	}

	private int seperateAndMultiply(List<Integer> l1, List<Integer> l2) {
		int result = 0;
		if (l1.size() != 0) {
			List<Integer> l1n = new ArrayList<>();
			List<Integer> l1p = new ArrayList<>();
			List<Integer> l1z = new ArrayList<>();
			List<Integer> l2n = new ArrayList<>();
			List<Integer> l2p = new ArrayList<>();
			List<Integer> l2z = new ArrayList<>();
			partisionAList(l1, l1n, l1z, l1p);
			partisionAList(l2, l2n, l2z, l2p);

			int sum1 = 0;
			int sum2 = 0;
			if (l1n.size() > 0){
				if (l2p.size() > 0)
					sum1 = calculate(l1n, l2p);
				else if (l2z.size() > 0)
					sum1 = calculate(l2z, l1n);
			}else if(l1p.size()>0){
				if(l2n.size()>0){
					
				}
			}
				
			// else

			sum2 = calculate(l2n, l1p);
			List<Integer> l1Reminders = new ArrayList<>();
			l1Reminders.addAll(l1n);
			l1Reminders.addAll(l1z);
			l1Reminders.addAll(l1p);
			List<Integer> l2Reminders = new ArrayList<>();
			l2Reminders.addAll(l2n);
			l2Reminders.addAll(l2z);
			l2Reminders.addAll(l2p);
			result = sum1 + sum2
					+ seperateAndMultiply(l1Reminders, l2Reminders);
		}
		return result;
	}

	private int calculate(List<Integer> fromStartList, List<Integer> fromEndList) {
		int sum = 0;
		while (fromEndList.size() > 0 && fromStartList.size() > 0) {
			sum += fromStartList.get(0)
					* fromEndList.get(fromEndList.size() - 1);
			fromStartList.remove(0);
			fromEndList.remove(fromEndList.size() - 1);
		}
		return sum;
	}

	private void partisionAList(List<Integer> l, List<Integer> negative,
			List<Integer> zero, List<Integer> positive) {
		int minusEnd = findBorderIndexes(l, true, false);
		int zeroStart = -1;
		int zeroEnd = -1;
		int positiveStart = findBorderIndexes(l, false, true);
		if (minusEnd != -1) {
			negative.addAll(l.subList(0, minusEnd + 1));
			if (minusEnd < l.size() - 1)
				zeroStart = minusEnd + 1;
		}
		if (positiveStart != -1) {
			negative.addAll(l.subList(positiveStart, l.size()));
			if (zeroStart != -1 && positiveStart > 0) {
				zeroEnd = positiveStart - 1;
				zero.addAll(l.subList(zeroStart, zeroEnd + 1));
			}
		}

	}

	private int findBorderIndexes(List<Integer> l, boolean forMinus,
			boolean isStart) {
		if (forMinus) {
			if (isStart) { // start of -
				if (l.get(0) < 0) {
					return 0;
				} else {
					return -1;
				}
			} else {// end of -
				if (!(l.get(0) < 0)) {
					return -1;
				} else {
					for (int i = 0; i < l.size(); i++) {
						if (!(l.get(i) < 0)) {
							return i - 1;
						}
					}
					return l.size() - 1;
				}
			}
		} else {
			if (!isStart) {// end of +
				if (l.get(l.size() - 1) > 0) {
					return l.size() - 1;
				} else {
					return -1;
				}
			} else {// start of +
				if (!(l.get(l.size() - 1) > 0)) {
					return -1;
				} else {
					for (int i = 0; i < l.size(); i++) {
						if (l.get(i) > 0) {
							return i;
						}
					}
					return -1;
				}
			}
		}
	}

}
