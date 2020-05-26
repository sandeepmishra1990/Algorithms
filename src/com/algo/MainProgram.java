package com.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) throws IOException {
		
		TrieAlgo a=new TrieAlgo();
	
		
		BufferedReader reader=new BufferedReader(new FileReader(new File("c://apps/text.txt")));
		String line;
		while((line=reader.readLine())!=null)
		{
			String[] temp=line.toLowerCase().split(" ");
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

		while(true){
			Scanner sc =new Scanner(System.in);
			String word=sc.next();
		
		a.wordsByPrefix(word.toLowerCase()).forEach(System.out::println);;
	
		
		}
	}

}
