package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tradepoint implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String adress;
	private ArrayList<String> phones;
	private String specialization;
	private String time;

	public Tradepoint(){

	}

	public Tradepoint(String name, String adress,
					  List<String> numbers, String spec, String time) {
		this.name = name;
		this.adress = adress;
		this.phones = new ArrayList<String>();
		for(String s : numbers){
			this.phones.add(s);
		}
		this.specialization = spec;
		this.time = time;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public ArrayList<String> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<String> phones) {
		this.phones = phones;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Name : " + name + "\n");
		sb.append("Adress : " + adress + "\n");
		sb.append("Numbers :\n");
		for(String s : phones)
			sb.append("\t" + s + "\n");
		sb.append("Specialization : " + specialization + "\n");
		sb.append("Time : " + time + "\n");
		return sb.toString();
	}
}
