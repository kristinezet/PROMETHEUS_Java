package main;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class MyContainer implements Iterable<String>, Serializable {

	private static final long serialVersionUID = 1L;
	private File f;
	private String[] data;
	private int size = 0;

	public MyContainer(String fileName) {
		f = new File(fileName);
		data = new String[0];
		deserialize();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (String s : this)
			sb.append(s + "\n");
		return sb.toString();
	}

	void add(String string) {
		if (size == data.length)
			data = Arrays.copyOf(data, size == 0 ? 1 : size * 2);
		data[size++] = string;
		serialize();
	}

	void clear() {
		size = 0;
		data = new String[0];
		serialize();
	}

	boolean remove(String string) {
		int index = indexOf(string);
		if (index == -1)
			return false;
		for (int i = index; i < size - 1; ++i)
			data[i] = data[i + 1];
		size--;
		serialize();
		return true;
	}

	Object[] toArray() {
		return data;
	}

	int size() {
		return size;
	}

	boolean contains(String string) {
		return indexOf(string) != -1;
	}

	boolean containsAll(MyContainer container) {
		for (String s : container)
			if (!contains(s))
				return false;
		return true;
	}

	public Iterator<String> iterator() {
		return new Iter<String>();
	}

	public int indexOf(String string) {
		for (int i = 0; i < size; ++i)
			if (data[i].equals(string))
				return i;
		return -1;
	}

	public void sort() {
		qsort(0, size - 1);
		serialize();
	}

	private void qsort(int b, int e) {
		String tmp;
		int l = b;
		int r = e;
		int m = (l + r) / 2;
		while (l <= r) {
			while (data[l].compareTo(data[m]) < 0) l++;
			while (data[r].compareTo(data[m]) > 0) r--;
			if (l <= r) {
				tmp = data[l];
				data[l] = data[r];
				data[r] = tmp;
				l++;
				r--;
			}
		}
		if (b < r)
			qsort(b, r);
		if (e > l)
			qsort(l, e);
	}

	private void serialize() {
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(this);
			System.out.println("serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deserialize() {
		if (!f.exists()) {
			System.out.println("No such file exists");
			return;
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			MyContainer c = (MyContainer) in.readObject();
			this.size = c.size;
			this.data = c.data;
			System.out.println("deserialized");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private class Iter<String> implements Iterator<String> {

		int index = 0;

		public boolean hasNext() {
			return index < size;
		}

		public String next() {
			if (hasNext())
				return (String) data[index++];
			return null;
		}

		public void remove() {
			MyContainer.this.remove(data[index - 1]);
		}
	}
}
