/**
*@author Dalitso Banda
*@date 29/02/2020
*Program to read text file of loadshedding, print out all the data and print *out areas corresponding to a certain date and time
*/ 

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class LSArrayApp {

	String[] Data = new String[2976];
	File file = new File("cleanfinal.txt");
	
	public static void main(String[] args) {
		if (args.length == 3)
		(new LSArrayApp()).printAreas(args[0],args[1],args[2]);
		else
		(new LSArrayApp()).printAllAreas();
	}	
	//Method to read text file and organise data into an array of strings
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
				Data[i] = holdOne[0] + " " + holdOne[1];	
				i++;	
				}
			}
			catch(FileNotFoundException e) {
				System.out.println("file not found");
			}
		}

//Prints out all data in array
	public void printAllAreas() {
			
		String data = "";
		for(int j = 0; j < 2976; j++){
			data = Data[j].split("_");
			String data1 = data.substring(0,5);
			String data2 = data.substring(6, data.length()-1);
			System.out.println(data1 + data2);
		}
	}

//Searches array for date that equals the parameters entered and prinds out the areas corresponding to that date	
	public void printArea(String a, String b, String, c){
		
		int k = 0;
		
		while(k<Data.length){
			String x[] = Data[k].split("_");
			if(x[0].equals(a) && x[1].equals(b)){
				if(x[2].equals(c)){
				System.out.println(Data[k].substring(6,n)
				k = 2976;
				}
			}
			k++;
		}
	}
}

