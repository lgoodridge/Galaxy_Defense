package com.fffan911.galaxy_defense.Utility;

public class RandomUtility {
	
	//Random Choose Methods
	public static final int chooseBetweenTwoNumbers(int one, int two){
		int randNum = randomInt(0, 100);
		if (randNum < 50) return one;
		else return two;
	}
	
	//Random Generator Methods
	public static final int randomInt(int min, int max){
		return (int)(min + Math.random() * (max - min + 1));
	}
	public static final long randomLong(long min, long max){
		return (long)(min + Math.random() * (max - min + 1));
	}
	public static final float randomFloat(float min, float max){
		return (float)(min + Math.random() * (max - min));
	}
	public static final double randomDouble(double min, double max){
		return min + Math.random() * (max - min);
	}
}
