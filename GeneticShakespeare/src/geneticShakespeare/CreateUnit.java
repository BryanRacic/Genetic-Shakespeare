package geneticShakespeare;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CreateUnit {
	public static String createOffSpring(int par1Fit, int par2Fit, String parent1, String parent2){
		int par1PCent = (par1Fit/(par1Fit+par2Fit));
		int testCaseLength = Main.getTestCase().length();
		int split = ThreadLocalRandom.current().nextInt(testCaseLength) + (par1PCent*(testCaseLength));
		String temp = "";
		if (split > testCaseLength){
			temp = parent1;
		}
		else{
			temp = parent2;
		}
		for(int i = 0; i < parent1.length(); i++){
			temp.toCharArray()[i] = parent1.toCharArray()[i];
		}
		return temp;
	}
	
	public static ArrayList<String> genMatingPool(String[] population){
		int populationCount = population.length;
		ArrayList<String> matingPool = new ArrayList<String>();
		for(int i = 0; i < populationCount; i++){
			float popFit =Population.calcFitness(population[i]);
			float testCaseLength = Main.getTestCase().length();
			float temp = (popFit/testCaseLength)*100;
				//Separated for easy debugging
			for(int j =0; j < temp; j++){
				matingPool.add(population[i]);
			}
		}
		return matingPool;
	}
	
	private static int mutationChance = 100;
	public static ArrayList<String> Mutate(ArrayList<String> Unit){
		for(String unitString: Unit){
			StringBuilder unitStringBuilder = new StringBuilder(unitString);
			//System.out.println(unitString);
			int random = ThreadLocalRandom.current().nextInt(65, 92);
			if (random == 91){					
				random = 32;
			}
			char randChar = (char) random;
			if(ThreadLocalRandom.current().nextInt(mutationChance) == 1){
				unitStringBuilder.setCharAt(ThreadLocalRandom.current().nextInt(Main.getTestCase().length()), randChar);
				unitString = unitStringBuilder.toString();
				}
			//System.out.println(unitString);
		}
		return Unit;
	}
}
