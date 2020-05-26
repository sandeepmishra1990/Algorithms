package com.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
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
				//System.out.println("char found");
			} else {
				t = new TrieNode(c);
				children.put(c, t);
				//System.out.println("char not found");
			}
			children = t.getChildren();
			if (i == word.length() - 1) {
				t.endOfWord = true;
				t.word=word;
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
	
	
	public List<String> wordsByPrefix(String str) {

		Map<Character, TrieNode> children = root.getChildren();
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
				 t = children.get(c);
			if (t!=null) {
				children = t.getChildren();
			} else {
				return null;
			}
		}
		
		ArrayList<String> words=new ArrayList<String>();
		Deque<TrieNode> dq=new ArrayDeque<TrieNode>();
		dq.addLast(t);
		while(!dq.isEmpty())
		{
			TrieNode firstNode=dq.removeFirst();
			if(firstNode.endOfWord)
			{
				words.add(firstNode.word);
			}
			
			for (Map.Entry<Character,TrieNode> entry : firstNode.getChildren().entrySet()) {
			    TrieNode child=entry.getValue();
			    if(child !=null)
			    	dq.add(child);
			}
			
		}
		
		return words;
	}


}
