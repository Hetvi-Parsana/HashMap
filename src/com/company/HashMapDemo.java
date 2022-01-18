/*
HETVI TUSHARBHAI PARSANA
CSCI _ 2110
B00877530
*/

package com.company;//Simple illustration of hashmap in java
//Creates a hashmap of student id numbers as keys and student names as records.
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class HashMapDemo
{
	public static void main(String[] args) throws IOException
	{
		HashMap<Integer, String> studentRecord = new HashMap<Integer,String>();
		Integer id;
		String name;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		while (inputFile.hasNext())
		{
			id = Integer.parseInt(inputFile.next());
			name = inputFile.nextLine();
			studentRecord.put(id, name);
		}
		
		inputFile.close();
		System.out.println(studentRecord.values());
		System.out.println(studentRecord.keySet());
		
		System.out.print("Enter key: ");
		id = keyboard.nextInt();
		if (studentRecord.containsKey(id)){
			name = studentRecord.get(id);
			System.out.println(id + "\t" + name  + "  found");
		}
		else
			System.out.println(id + " not found");

		keyboard.close();
	}
}
