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
	static List<Integer> unmalteds = new ArrayList<>();
	static List<Integer> malteds = new ArrayList<>();

	@Override
	protected StringBuffer _solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		int numberOfFlavors = readInt();
		int numberOfCustomers = readInt();

		for (int i = 0; i < numberOfFlavors; i++) {
			unmalteds.add(i + 1);
		}
		List<User> users = new ArrayList<>();
		for (int i = 0; i < numberOfCustomers; i++) {
			String str = this.reader.nextLine();
			int[] rawArray = GcjUtil.lineToArrayOfInts(str, " ");
			int numberOFLikes = rawArray[0];
			HashMap<Integer, Integer> likes = new HashMap<>();

			for (int j = 1; j < 2 * numberOFLikes; j += 2) {
				likes.put(rawArray[j], rawArray[j + 1]);
			}
			User user = new User();
			user.setFavorites(likes);
			users.add(user);
		}
		this.rs.append(this.doItSimple(users));

		// List<Customer> cs = new ArrayList<>();
		//
		// for (int i = 0; i < numberOfCustomers; i++) {
		// String str = this.reader.nextLine();
		// int[] rawArray = GcjUtil.lineToArrayOfInts(str, " ");
		// int numberOFLikes = rawArray[0];
		// int[] newArray = new int[numberOfFlavors];
		// for (int j = 0; j < newArray.length; j++) {
		// newArray[j] = -1;
		// }
		// for (int j = 1; j < 2 * numberOFLikes; j += 2) {
		// newArray[rawArray[j] - 1] = rawArray[j + 1];
		// }
		//
		// cs.add(new Customer(numberOFLikes, newArray));
		// }
		// Collections.sort(cs);
		// for (Customer c : cs) {
		// if (c.getBestLike() == -1) {
		// this.rs.append("IMPOSSIBLE");
		// return this.rs;
		// }
		// }
		// for (int i = 0; i < numberOfFlavors; i++) {
		// this.rs.append(allLikes.get(i) != null ? allLikes.get(i) : 0);
		// }

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

	private String doItSimple(List<User> users) {
		boolean allSatisfied = false;
		int i = 0;
		while (!allSatisfied) {
			User user = users.get(i);
			int satisfactionResult = user.makeHimStatisfied();
			if (satisfactionResult == 1) {
				if (users.size() - 1 == i)
					allSatisfied = true;
				else
					i++;
			} else if (satisfactionResult == 0) {
				i = 0;
			} else {
				return "IMPOSSIBLE";
			}
		}
		String result = "";
		while (malteds.size() > 0 || unmalteds.size() > 0) {
			List<Integer> selectedList;
			if (malteds.size() > 0) {
				if (unmalteds.size() > 0) {
					if (malteds.get(0) > unmalteds.get(0)) {
						result += "0 ";
						unmalteds.remove(0);
					} else {
						result += "1 ";
						malteds.remove(0);
					}
				} else {
					result += "1 ";
					malteds.remove(0);
				}
			} else if (unmalteds.size() > 0) {
				result += "0 ";
				unmalteds.remove(0);
			}
		}
		return result;
	}

	public class User {
		HashMap<Integer, Integer> favorites = new HashMap<>();

		public HashMap<Integer, Integer> getFavorites() {
			return favorites;
		}

		public void setFavorites(HashMap<Integer, Integer> favorites) {
			this.favorites = favorites;
		}

		public int makeHimStatisfied() {
			int favoritMaltedFlavour = -1;
			for (Integer unmaltedFlavor : unmalteds) {
				if (this.favorites.get(unmaltedFlavor) != null) {
					if (this.favorites.get(unmaltedFlavor) == 0) {
						return 1;
					} else {
						favoritMaltedFlavour = unmaltedFlavor;
					}
				}
			}
			if (favoritMaltedFlavour == -1) {
				for (Integer maltedFlavor : malteds) {
					if (favorites.get(maltedFlavor) != null
							&& favorites.get(maltedFlavor) == 1) {
						return 1;
					}
				}
				return -1;
			} else {
				unmalteds.remove(new Integer(favoritMaltedFlavour));
				malteds.add(favoritMaltedFlavour);
				return 0;
			}
		}

	}

}
