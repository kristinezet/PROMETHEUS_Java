package com.tasks6.rle_decoder;

public class Application
{
	public static void main( String[] args )
	{
       if (args.length == 0 || "".equals(args[0]))
            return;

        int buf = 1;
        String s = args[0];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 47 && s.charAt(i) < 58 && s.charAt(i + 1) > 47 && s.charAt(i + 1) < 58)
                System.out.print("");
            return;
        }
        int repeat;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 40 && s.charAt(i) < 123 && s.charAt(i + 1) > 47 && s.charAt(i + 1) < 58) {
                repeat = s.charAt(i + 1) - '0';
                for (int j = repeat; j > 0; j--)
                    System.out.print(s.charAt(i));
            } else
                System.out.print(s.charAt(i));
        }
	}
}