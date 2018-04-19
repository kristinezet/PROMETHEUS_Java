package com.tasks3.linkedlist;

public class LinkedList {

	private Node root;

	public LinkedList() {}

	/* Додати елемент в кінець списку */
	public void add(Integer data) {
		if(root == null)
			root = new Node(data);
		else getElem(size() - 1).setNext(new Node(data));
	}
	/* Отримати елемент по індексу, повертає null якщо такий елемент недоступний */
	public Integer get(int index) {
		Node n = getElem(index);
		return n == null ? null : n.getData();
	}

	private Node getElem(int index){
		if(index < 0)
			return null;
		Node n = root;
		while(index!=0){
			if(n.getNext() == null)
				return null;
			n = n.getNext();
			index--;
		}
		return n;
	}

	/* Вилучення елементу за індексом, повертає true у разі успіху або false в іншому випадку */
	public boolean delete(int index) {
		if(index == 0)
			root = root.getNext();
		else {
			Node p = getElem(index - 1);
			if(p == null || p.getNext() == null)
				return false;
			p.setNext(p.getNext().getNext());
		}
		return true;
	}
	/*Поверта розмір списку: якщо елементів в списку нема то повертає 0 (нуль)*/
	public int size() {
		Node n = root;
		int s = 0;
		while(n != null){
			n = n.getNext();
			s++;
		}
		return s;
	}
}
