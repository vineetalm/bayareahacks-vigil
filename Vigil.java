package vigil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vigil {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is your address?");
		String address = scan.nextLine();
		
		String csvfile = "src/vigil/covidHotspots";
		String csvfile2 = "src/vigil/covidPopulation";
		String line = " ";
		String csvSplit = ",";
		
		Map<String, String> dictionary = new HashMap<String, String>();
		Map<String, String> dictionary2 = new HashMap<String, String>();
		
		BufferedReader objreader = null;
		BufferedReader objreader2 = null;
		
		objreader = new BufferedReader(new FileReader(csvfile));
		objreader2 = new BufferedReader(new FileReader(csvfile2));
		
		while ((line = objreader.readLine()) != null) {
			String hotspots[] = line.split(csvSplit);
			
			String location = hotspots[0];
			String extremity = hotspots[1]; 
			
			dictionary.put(location, extremity);
		}
		
		while ((line = objreader2.readLine())!=null) {
			String population[] = line.split(csvSplit);
			
			String location2 = population[0];
			String people = population[1];
			
			dictionary2.put(location2, people);
		}
		
		if(dictionary.containsKey(address)){
			if(dictionary2.containsKey(address)){
				float covid = Float.parseFloat(dictionary.get(address));
				float number = Float.parseFloat(dictionary2.get(address));
				
				if((covid/number) >= 0.5){
					System.out.println("You are at an extremely high risk. I reccomend getting tested.");
				}
				
				if((covid/number) >= 0.35 & (covid/number)<0.5 ){
					System.out.println("You are at a high risk. I reccomend getting tested.");
				}
				
				if((covid/number) >=0.25 & (covid/number)<0.35 ){
					System.out.println("You are at a medium. If you want to get tested, you can.");
				}
				
				if((covid/number) >=0.25 & (covid/number)<0.35 ){
					System.out.println("You are at a medium. If you want to get tested, you can.");
				}
				
				if((covid/number) < 0.05){
					System.out.println("You are at a low risk");
				}
			}
		}
		}

	}


