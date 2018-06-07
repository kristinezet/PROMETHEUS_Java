package main;

public class InputChecker {

	private static String t = "\\d{2}?(:)\\d{2}?";

	public static boolean checkNumbers(String numbers){
		String[] nums = numbers.split("\\s");
		for(String n : nums){
			if(!n.matches("(\\+){1}?\\d{12}?"))
				return false;
		}
		return true;
	}

	public static boolean checkTime(String time){
		return time.matches(t + "\\s*(-)\\s*" + t + "\\s(Mo)??\\s" +
				"(Tu)??\\s(We)??\\s(Th)??\\s(Fr)??\\s(Sa)??\\s(Su)??\\s");
	}
}
