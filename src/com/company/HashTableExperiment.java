/*
HETVI TUSHARBHAI PARSANA
CSCI _ 2110
B00877530
*/

package com.company;//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO EXERCISE 1
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HashTableExperiment {
	public static void main(String[] args) {
		// prompt the user to enter the table size
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int n = sc.nextInt();

		// create an Arraylist of size n
		// The ArrayList holds a LinkedList object
		// The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<LinkedList<Integer>>();
		//
		ArrayList<Integer> keys = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			hashtable.add(i, new LinkedList<Integer>());
		}

		System.out.print("Enter the number of keys to be hashed: ");
		int k = sc.nextInt();

		// random keys are inserted into the hashtable
		Random random = new Random();
		int key, index;

		for (int i = 0; i < k; i++) {
			key = random.nextInt(10000) + 1;
			while (keys.contains(key)) {
				key = random.nextInt(10000) + 1;
			}
			index = key % n;
			hashtable.get(index).add(key);

			;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
		}

		double loadFactor = (double) n / k;
		int numOfCollisions = 0, longestList = 0;
		int size;

		for (int i = 0; i < n; i++) {
			size = hashtable.get(i).size();
			longestList = size > longestList ? size : longestList;
			numOfCollisions += size > 0 ? size - 1 : 0;
		}

		System.out.println("Statistics:");
		System.out.println("Table size: " + n);
		System.out.println("Number of keys: " + k);
		System.out.println("Load factor: " + loadFactor);
		System.out.println("Number of collisions: " + numOfCollisions);
		System.out.println("Longest list: " + longestList);

		sc.close();
	}
}
