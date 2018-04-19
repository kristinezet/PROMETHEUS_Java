package com.tasks7.rpn;

import java.util.ArrayList;
import java.util.LinkedList;

public class Application {

	static final String OPERATIONS = "+-*/^";

	public static double parse(String rpnString) {
		LinkedList<Double> list = new LinkedList<>();
		String[] commands = rpnString.split(" ");
		for (String s : commands) {
			if (OPERATIONS.contains(s)) {
				Double d2 = list.pollFirst();
				Double d1 = list.pollFirst();
				if (d1 == null || d2 == null)
					throw new RPNParserException();
				switch (s) {
					case "+":
						list.addFirst(d1 + d2);
						break;
					case "-":
						list.addFirst(d1 - d2);
						break;
					case "*":
						list.addFirst(d1 * d2);
						break;
					case "/":
						if (d2 == 0)
							throw new ArithmeticException();
						list.addFirst(d1 / d2);
						break;
				}
			} else {
				try {
					Double.parseDouble(s);
				} catch (NumberFormatException e) {
					throw new RPNParserException();
				}
				list.addFirst(Double.parseDouble(s));
			}
		}
		if(list.size() != 1)
			throw new RPNParserException();
		return list.pollFirst();
	}
}
