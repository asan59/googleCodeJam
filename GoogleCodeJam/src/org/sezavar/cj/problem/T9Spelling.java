package org.sezavar.cj.problem;

import java.util.HashMap;

import org.sezavar.cj.util.InputOutputType;

public class T9Spelling extends Problem {
	static HashMap<Character, String> map = new HashMap<>();
	{
		map.put('a', "2");
		map.put('b', "22");
		map.put('c', "222");
		map.put('d', "3");
		map.put('e', "33");
		map.put('f', "333");
		map.put('g', "4");
		map.put('h', "44");
		map.put('i', "444");
		map.put('j', "5");
		map.put('k', "55");
		map.put('l', "555");
		map.put('m', "6");
		map.put('n', "66");
		map.put('o', "666");
		map.put('p', "7");
		map.put('q', "77");
		map.put('r', "777");
		map.put('s', "7777");
		map.put('t', "8");
		map.put('u', "88");
		map.put('v', "888");
		map.put('w', "9");
		map.put('x', "99");
		map.put('y', "999");
		map.put('z', "9999");
		map.put(' ', "0");
	}

	@Override
	protected StringBuffer _solve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected StringBuffer _solveEachSet() {
		String line = this.reader.nextLine();
		String lastTranslation = "*";
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			String tr = map.get(ch);
			if (lastTranslation.charAt(lastTranslation.length() - 1) == tr
					.charAt(0)) {
				this.rs.append(" " + tr);
			} else {
				this.rs.append(tr);
			}
			lastTranslation = tr;
		}
		return this.rs;
	}

	public static void main(String[] args) {
		Problem p = new T9Spelling();
		p.solveSetsFor(InputOutputType.LARGE);
	}

}
