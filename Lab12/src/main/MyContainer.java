package main;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class MyContainer<T extends Object> implements Iterable<T>, Serializable{

	private static final long serialVersionUID = 1L;
	private File f;
	private T[] data;
	private int size = 0;

	public MyContainer(){
		data = (T[])new Object[0];
		f = new File(hashCode() + "");
	}

	public MyContainer(String fileName) {
		f = new File(fileName + ".data");
		data = (T[])new Object[0];
		deserialize();
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
		serialize();
	}

	void clear() {
		size = 0;
		data = (T[])new Object[0];
		serialize();
	}

	boolean remove(T t) {
		int index = indexOf(t);
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

//	public void sort(){
//		qsort(0, size - 1);
//		serialize();
//	}

//	private void qsort(int b, int e){
//		String tmp;
//		int l = b;
//		int r = e;
//		int m = (l + r) / 2;
//		while(l <= r){
//			while(data[l].compareTo(data[m]) < 0)l++;
//			while(data[r].compareTo(data[m]) > 0)r--;
//			if(l <= r){
//				tmp = data[l];
//				data[l] = data[r];
//				data[r] = tmp;
//				l++;
//				r--;
//			}
//		}
//		if(b < r)
//			qsort(b, r);
//		if(e > l)
//			qsort(l, e);
//	}

	private void serialize(){
		try {
			if(!f.exists()){
				f.createNewFile();
			}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(this);
			out.close();
			System.out.println("serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deserialize(){
		if(!f.exists()){
			System.out.println("No such file exists");
			return;
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			MyContainer c = (MyContainer) in.readObject();
			this.size = c.size;
			this.data = (T[]) c.data;
			System.out.println("deserialized");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void remove(int ind) {
		for(int i = ind; i < size - 1; ++i)
			data[i] = data[i + 1];
		size--;
	}

	public T get(int index){
		return data[index];
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
