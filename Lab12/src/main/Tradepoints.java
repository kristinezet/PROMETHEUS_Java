package main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Arrays;

public class Tradepoints implements Serializable{

	private static final long serialVersionUID = 1L;
	File f;
	MyContainer<Tradepoint> tradepoints;

	public Tradepoints(String filename){
		this.tradepoints = new MyContainer<>("1");
		f = new File(filename + ".xml");
		read();
	}

	public void add(String[] params){
		tradepoints.add(new Tradepoint(
				params[0],
				params[1],
				Arrays.asList(params[2].split("\\s+")),
				params[3],
				params[4]
		));
		save();
	}

	private void save(){
		try {
			if(!f.exists()){
				f.createNewFile();
			}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			XMLEncoder en = new XMLEncoder(out);
			en.writeObject(tradepoints);
			en.close();
			System.out.println("serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void read(){
		if(!f.exists()){
			System.out.println("No such file exists");
			return;
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			XMLDecoder dec = new XMLDecoder(in);
			tradepoints = (MyContainer<Tradepoint>)dec.readObject();
			System.out.println("deserialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean remove(int ind) {
		if(ind >= tradepoints.size())
			return false;
		tradepoints.remove(ind);
		save();
		return true;
	}

	public void clear() {
		tradepoints.clear();
		save();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < tradepoints.size(); ++i)
			sb.append("\n" + (i + 1) + ").\n" + tradepoints.get(i) + "\n");
		return sb.toString();
	}
}
