package com.algo;

import java.util.HashMap;

public class TrieNode {

	char c;
	private HashMap<Character, TrieNode> children = new HashMap<>();
	boolean endOfWord = false;
	String word=null;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

}
