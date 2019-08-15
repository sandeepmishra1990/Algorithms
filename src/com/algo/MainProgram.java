package com.algo;

public class MainProgram {

	public static void main(String[] args) {
		
		TrieAlgo a=new TrieAlgo();
		a.insert("sand");
		a.insert("sandeep");
		
		TrieNode node=a.searchNode("sandeep");
		if(node!=null && node.isEndOfWord())
			System.out.println("Found");
		
		TrieNode node1=a.searchNode("sandeeo");
		if(node1!=null && node1.isEndOfWord())
			System.out.println("Found");
		else
			System.out.println("Not Found");

	}

}
