package com.tasks3.fibonacci;

public class Fibonacci
{
	public long getNumber(int position){
		long prev1 = 1, prev = 1, buf = 2;
		if (position < 1 || position > 92)
			return -1;
		if (position < 3)
			return 1;
		else {
			while (position != 2) {
				buf = prev + prev1;
				prev1 = prev;
				prev = buf;
				position--;
			}
			return buf;
		}
	}
}
      