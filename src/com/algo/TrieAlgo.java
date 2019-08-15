package com.algo;

import java.util.HashMap;
import java.util.Map;

public class TrieAlgo {

	private TrieNode root;

	public TrieAlgo() {
		root = new TrieNode();
	}

	public void insert(String word) {

		HashMap<Character, TrieNode> children = root.getChildren();
		System.out.println("length of map" + children.size());

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
				t = children.get(c);
			if (t!=null) {
				System.out.println("char found");
			} else {
				t = new TrieNode(c);
				children.put(c, t);
				System.out.println("char not found");
			}
			children = t.getChildren();
			if (i == word.length() - 1) {
				t.endOfWord = true;
			}
		}
	}

	public TrieNode searchNode(String str) {
		long startTime = System.nanoTime();
		
		Map<Character, TrieNode> children = root.getChildren();
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
				t = children.get(c);
				if (t!=null) {
				children = t.getChildren();
			} else {
				long endTime = System.nanoTime();
				long duration = (endTime - startTime); 
				System.out.println("time take in millis:"+duration);
				return null;
			}
		}

		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println("time take in millis:"+duration);
		return t;
	}

}
