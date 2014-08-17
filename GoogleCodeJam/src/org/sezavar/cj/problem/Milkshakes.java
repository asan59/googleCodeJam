package org.sezavar.cj.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.sezavar.cj.util.GcjUtil;
import org.sezavar.cj.util.InputOutputType;

public class Milkshakes extends Problem {
	static HashMap<Integer, Integer> allLikes = new HashMap<Integer, Integer>();

	@Override
	protected StringBuffer _solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		int numberOfFlavors = readInt();
		int numberOfCustomers = readInt();
		List<Customer> cs = new ArrayList<>();

		for (int i = 0; i < numberOfCustomers; i++) {
			String str = this.reader.nextLine();
			int[] rawArray = GcjUtil.lineToArrayOfInts(str, " ");
			int numberOFLikes = rawArray[0];
			int[] newArray = new int[numberOfFlavors];
			for (int j = 0; j < newArray.length; j++) {
				newArray[j] = -1;
			}
			for (int j = 1; j < 2 * numberOFLikes; j += 2) {
				newArray[rawArray[j] - 1] = rawArray[j + 1];
			}

			cs.add(new Customer(numberOFLikes, newArray));
		}
		Collections.sort(cs);
		for (Customer c : cs) {
			if (c.getBestLike() == -1) {
				this.rs.append("IMPOSSIBLE");
				return this.rs;
			}
		}
		for (int i = 0; i < numberOfFlavors; i++) {
			this.rs.append(allLikes.get(i) != null ? allLikes.get(i) : 0);
		}

		return this.rs;
	}

	public static void main(String[] args) {
		Problem p = new Milkshakes();
		p.solveSetsFor(InputOutputType.SMALL);
	}

	class Customer implements Comparable<Customer> {
		int numberOfLikes;
		int[] likes;

		public int getNumberOfLikes() {
			return numberOfLikes;
		}

		public int[] getLikes() {
			return likes;
		}

		public Customer(int numberOfLikes, int[] likes) {
			super();
			this.numberOfLikes = numberOfLikes;
			this.likes = likes;
		}

		public int getBestLike() {
			int indexOfMalted = -1;
			for (int i = 0; i < likes.length; i++) {
				if (likes[i] == 0) {
					if (allLikes.get(i) == null || allLikes.get(i) == 0) {
						allLikes.put(i, 0);
						return i;
					}
				} else if (likes[i] == 1
						&& (allLikes.get(i) == null || allLikes.get(i) == 1)) {
					indexOfMalted = i;
				}
			}
			if (indexOfMalted != -1) {
				allLikes.put(indexOfMalted, 1);
			}
			return indexOfMalted;
		}

		@Override
		public int compareTo(Customer o) {
			return this.numberOfLikes - o.numberOfLikes;
		}

	}

}
