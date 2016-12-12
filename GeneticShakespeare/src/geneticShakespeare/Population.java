package geneticShakespeare;

import java.util.concurrent.ThreadLocalRandom;

public class Population {
	public static String[] firstPopulation(int PopCount, int testCaseLength){
		String[] population = new String[PopCount];
		String temp = "";
		for (int i = 0; i < PopCount; i++){
			for (int j = 0; j < testCaseLength; j++){
				int random = ThreadLocalRandom.current().nextInt(65, 92);
				if (random == 91){					
					random = 32;
				}
				temp = temp.concat(Character.toString((char) random));
					//Adds the random character to the end of the string
			}
			population[i] = temp;
			temp = "";
		}
		for (int j = 0; j < population.length; j++){
			//System.out.println(population[j]);
		}
		return population;
	}
	
	public static int calcFitness(String unit){
		int fitness = 0;
		char[] unitArray = unit.toCharArray();
		char[] testCaseArray = Main.getTestCase().toCharArray();
		for (int i = 0; i < unit.length(); i++){
			if(unitArray[i] == testCaseArray[i]){
				fitness++;
			}
		}
		return fitness;
	}
	
}
