package main;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.*;

public class MyContainer<T extends Object> implements Iterable<T>, Serializable{

	private static final long serialVersionUID = 1L;
	private T[] data;
	private int size = 0;

	public MyContainer(){
		data = (T[])new Object[0];
	}

	public MyContainer(String fileName) {
		data = (T[])new Object[0];
	}

	public MyContainer(MyContainer<T> ts) {
		data = Arrays.copyOf(ts.data, ts.data.length);
		size = ts.size;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (T t : this)
			sb.append(t + "\n");
		return sb.toString();
	}

	void add(T t) {
		if (size == data.length)
			data = Arrays.copyOf(data, size == 0 ? 1 : size * 2);
		data[size++] = t;
		
	}

	void clear() {
		size = 0;
		data = (T[])new Object[0];
	}

	boolean remove(T t) {
		int index = indexOf(t);
		if (index == -1)
			return false;
		for (int i = index; i < size - 1; ++i)
			data[i] = data[i + 1];
		size--;
		
		return true;
	}

	Object[] toArray() {
		return data;
	}

	int size() {
		return size;
	}

	boolean contains(T t) {
		return indexOf(t) != -1;
	}

	boolean containsAll(MyContainer container) {
		for (Object t : container)
			if (!contains((T)t))
				return false;
		return true;
	}

	public Iterator<T> iterator() {
		return new Iter<T>();
	}

	public int indexOf(T t) {
		for (int i = 0; i < size; ++i)
			if (data[i].equals(t))
				return i;
		return -1;
	}

	public void remove(int ind) {
		for(int i = ind; i < size - 1; ++i)
			data[i] = data[i + 1];
		size--;
	}

	public T get(int index){
		return data[index];
	}

	public void countNumber(int number){
		MyContainer<Integer> container = new MyContainer(this);
		Thread thread = new Thread() {
			@Override
			public void run() {
				int k = 0;
				for(Integer i : container)
					if(i == number){
						k++;
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				System.out.println("Number " + number + " is " + k + " times in array");
			}
		};
		thread.start();
	}

	public void countNumberLessThen(int number){
		MyContainer<Integer> container = new MyContainer(this);
		Thread thread = new Thread() {
			@Override
			public void run() {
				int k = 0;
				for(Integer i : container)
					if(i < number){
						k++;
						if(k % 100 == 0)
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				System.out.println("There are " + k + " numbers less then " + number + " in array");
			}
		};
		thread.start();
	}

	public void countNumberBiggerThen(int number){
		MyContainer<Integer> container = new MyContainer(this);
		Thread thread = new Thread() {
			@Override
			public void run() {
				int k = 0;
				for(Integer i : container)
					if(i > number){
						k++;
						if(k % 100 == 0)
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				System.out.println("There are " + k + " numbers bigger then " + number + " in array");
			}
		};
		thread.start();
	}


	private class Iter<T> implements Iterator<T> {

		int index = 0;

		public boolean hasNext() {
			return index < size;
		}

		public T next() {
			if (hasNext())
				return (T) data[index++];
			return null;
		}

		public void remove() {
			MyContainer.this.remove(data[index - 1]);
		}
	}
}
