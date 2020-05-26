package com.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainProgram {

	public static void main(String[] args) throws IOException {
		
		TrieAlgo a=new TrieAlgo();
	
		
		BufferedReader reader=new BufferedReader(new FileReader(new File("c://apps/text.txt")));
		String line;
		while((line=reader.readLine())!=null)
		{
			String[] temp=line.split(" ");
			for(String word:temp)
			{
				a.insert(word);
				System.out.println(word);
			}
		}
		
		/*TrieNode node=a.searchNode("sandeep");
		if(node!=null && node.isEndOfWord())
			System.out.println("Found");
		
		TrieNode node1=a.searchNode("sandee");
		if(node1!=null && node1.isEndOfWord())
			System.out.println("Found");
		else
			System.out.println("Not Found");*/

		for(String str:a.wordsByPrefix("co"))
		{
			System.out.println(str);
		}
	}

}
