/**
*@author Dalitso Banda
*@date 29/02/2020
*Program to read text file of loadshedding and store it in a binary search *tree (BST), print out all the data and print out areas corresponding to a certain date and time
*/ 

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
package bst;

public class LSBSTApp {	

	File file = new File("cleanfinal.txt");
	//Creates class and attributes for BST
	class Node {
		int data;
		Node left;
		Node right;
	}
	//Creates head for new BST
	public Node createNewNode(int k) {
		Node a = new Node();
		a.data = k;
		a.left = null;
		a.right = null;
	}
	//BST class with method insert for adding data to BST
	class BST {
		public Node insert(Node node, int val) {
			if(node == null){
				return createNewNode(val);
			}
			if(val < node.data) {
				node.left = insert(node.left, val);
			}else if(val > node.data) {
				node.right = insert(node.right, val);
			}
		}
		return node;
	}
//reads text file into array of strings, then converts strings into one int that is added to the BST
	public String read() {
			
		try {
			Scanner s = new Scanner(new File(file));
			int i = 0;
			while(s.hasNextLine()) {
				String hold = s.nextLine();
				String[] holdOne = hold.split(" ");
/**
*This if statment and while loop are to deal with format of data which may or *may not contain *  *commas and is of varying length
*/
				if(holdOne[1].contains(",")){
					int j = 1;
					while(j < holdOne.length){
						holdOne[j] = holdOne[j].substring(0);
						if(j > 1){
							holdOne[1] = holdOne[1] + " " + holdOne[j];
						}
						j++;
					}
				} 
				String a[] = holdOne[0].split("_");
				Data[i] = a[0]+a[1]+a[2]+holdOne[1];
				int add = Interger.parseInt(Data[i]);
				BST data = new BST;
				if(i==0){
					data.insert(null,add);
				}else{
					data.insert(Interger.parseInt(Data[0]),add);
				}
				i++;	
				}
			}
			catch(FileNotFoundException e) {
				System.out.println("file not found");
			}
		}

	
	public static void main(String[] args) {
		if (args.length == 3)
			(new LSArrayApp()).printAreas(args[0],args[1],args[2]);
			else
			(new LSArrayApp()).printAllAreas();
		}
	}
}
