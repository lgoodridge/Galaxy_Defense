package com.fffan911.galaxy_defense.Utility;

public class MathUtility {
	
	//Exponent Methods
	public static final int expNum(int num, int exp){
		return (int) Math.pow(num, exp);
	}
	public static final long expNum(long num, long exp){
		return (long) Math.pow(num, exp);
	}
	public static final float expNum(float num, float exp){
		return (float) Math.pow(num, exp);
	}
	public static final double expNum(double num, double exp){
		return Math.pow(num, exp);
	}
	
	public static final int hypotenuse(int one, int two){
		return (int)(Math.sqrt(Math.pow(one, 2) + Math.pow(two, 2)));
	}
	public static final long hypotenuse(long one, long two){
		return (long)(Math.sqrt(Math.pow(one, 2) + Math.pow(two, 2)));
	}
	public static final float hypotenuse(float one, float two){
		return (float)(Math.sqrt(Math.pow(one, 2) + Math.pow(two, 2)));
	}
	public static final double hypotenuse(double one, double two){
		return Math.sqrt(Math.pow(one, 2) + Math.pow(two, 2));
	}
	
	public static final int pythagoreanSide(int hypotenuse, int sideTwo){
		return (int)(Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(sideTwo, 2)));
	}
	public static final long pythagoreanSide(long hypotenuse, long sideTwo){
		return (long)(Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(sideTwo, 2)));
	}
	public static final float pythagoreanSide(float hypotenuse, float sideTwo){
		return (float)(Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(sideTwo, 2)));
	}
	public static final double pythagoreanSide(double hypotenuse, float sideTwo){
		return Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(sideTwo, 2));
	}
	
	//Common Exponent Methods
	public static final int squareNum(int num){
		return (int) Math.pow(num, 2);
	}
	public static final long squareNum(long num){
		return (long) Math.pow(num, 2);
	}
	public static final float squareNum(float num){
		return (float) Math.pow(num, 2);
	}
	public static final double squareNum(double num){
		return Math.pow(num, 2);
	}
	
	public static final double squareRootNum(int num){
		return Math.pow(num, 0.5);
	}
	public static final double squareRootNum(long num){
		return Math.pow(num, 0.5);
	}
	public static final double squareRootNum(float num){
		return Math.pow(num, 0.5);
	}
	public static final double squareRootNum(double num){
		return Math.pow(num, 0.5);
	}
	
	//Trig Methods
	public static final float sin(int degrees){
		return (float) Math.sin(degrees * Math.PI / 180.0);
	}
	public static final double sin(long degrees){
		return Math.sin(degrees * Math.PI / 180.0);
	}
	public static final float sin(float degrees){
		return (float) Math.sin(degrees * Math.PI / 180.0);
	}
	public static final double sin(double degrees){
		return Math.sin(degrees * Math.PI / 180.0);
	}
	
	public static final float cos(int degrees){
		return (float) Math.cos(degrees * Math.PI / 180.0);
	}
	public static final double cos(long degrees){
		return Math.cos(degrees * Math.PI / 180.0);
	}
	public static final float cos(float degrees){
		return (float) Math.cos(degrees * Math.PI / 180.0);
	}
	public static final double cos(double degrees){
		return Math.cos(degrees * Math.PI / 180.0);
	}
	
	public static final float tan(int degrees){
		return (float) Math.tan(degrees * Math.PI / 180.0);
	}
	public static final double tan(long degrees){
		return Math.tan(degrees * Math.PI / 180.0);
	}
	public static final float tan(float degrees){
		return (float) Math.tan(degrees * Math.PI / 180.0);
	}
	public static final double tan(double degrees){
		return Math.tan(degrees * Math.PI / 180.0);
	}
	
	//Inverse Trig Methods
	public static final int arcsin(int num){
		return (int) (Math.asin(num) * 180.0 / Math.PI);
	}
	public static final int arcsin(long num){
		return (int) (Math.asin(num) * 180.0 / Math.PI);
	}
	public static final float arcsin(float num){
		return (float) (Math.asin(num) * 180.0 / Math.PI);
	}
	public static final double arcsin(double num){
		return Math.asin(num) * 180.0 / Math.PI;
	}
	
	public static final int arccos(int num){
		return (int) (Math.acos(num) * 180.0 / Math.PI);
	}
	public static final int arccos(long num){
		return (int) (Math.acos(num) * 180.0 / Math.PI);
	}
	public static final float arccos(float num){
		return (float) (Math.acos(num) * 180.0 / Math.PI);
	}
	public static final double arccos(double num){
		return Math.acos(num) * 180.0 / Math.PI;
	}
	
	public static final int arctan(int num){
		return (int) (Math.atan(num) * 180.0 / Math.PI);
	}
	public static final int arctan(long num){
		return (int) (Math.atan(num) * 180.0 / Math.PI);
	}
	public static final float arctan(float num){
		return (float) (Math.atan(num) * 180.0 / Math.PI);
	}
	public static final double arctan(double num){
		return Math.atan(num) * 180.0 / Math.PI;
	}
	
	//Degree Methods
	public static final int wrapDegrees(int num){
		while (num > 360) num -= 360;
		while (num < 0) num += 360;
		return num;
	}
	public static final int wrapDegrees(long num){
		while (num > 360.0) num -= 360.0;
		while (num < 0) num += 360.0;
		return (int) num;
	}
	public static final float wrapDegrees(float num){
		while (num > 360.0f) num -= 360.0f;
		while (num < 0) num += 360.0f;
		return num;
	}
	public static final double wrapDegrees(double num){
		while (num > 360.0) num -= 360.0;
		while (num < 0) num += 360.0;
		return num;
	}
	
	public static final int degreesToQuadrant(int degrees){
		if (wrapDegrees(degrees) > 270) return 4;
		if (wrapDegrees(degrees) > 180) return 3;
		if (wrapDegrees(degrees) > 90) return 2;
		return 1;
	}
	public static final int degreesToQuadrant(long degrees){
		if (wrapDegrees(degrees) > 270) return 4;
		if (wrapDegrees(degrees) > 180) return 3;
		if (wrapDegrees(degrees) > 90) return 2;
		return 1;
	}
	public static final int degreesToQuadrant(float degrees){
		if (wrapDegrees(degrees) > 270) return 4;
		if (wrapDegrees(degrees) > 180) return 3;
		if (wrapDegrees(degrees) > 90) return 2;
		return 1;
	}
	public static final int degreesToQuadrant(double degrees){
		if (wrapDegrees(degrees) > 270) return 4;
		if (wrapDegrees(degrees) > 180) return 3;
		if (wrapDegrees(degrees) > 90) return 2;
		return 1;
	}
	
	public static final int displacementToQuadrant(int dx, int dy){
		if (dx >= 0){
			if (dy >= 0) return 1;
			else return 2;
		} else {
			if (dy >= 0) return 4;
			else return 3;
		}
	}
	public static final int displacementToQuadrant(long dx, long dy){
		if (dx >= 0){
			if (dy >= 0) return 1;
			else return 2;
		} else {
			if (dy >= 0) return 4;
			else return 3;
		}
	}
	public static final int displacementToQuadrant(float dx, float dy){
		if (dx >= 0){
			if (dy >= 0) return 1;
			else return 2;
		} else {
			if (dy >= 0) return 4;
			else return 3;
		}
	}
	public static final int displacementToQuadrant(double dx, double dy){
		if (dx >= 0){
			if (dy >= 0) return 1;
			else return 2;
		} else {
			if (dy >= 0) return 4;
			else return 3;
		}
	}
	
	public static final int displacementToDegreesFromYAxis(int dx, int dy){
		return arcsin(Math.abs(dx) / hypotenuse(dx, dy));
	}
	public static final int displacementToDegreesFromYAxis(long dx, long dy){
		return arcsin(Math.abs(dx) / hypotenuse(dx, dy));
	}
	public static final float displacementToDegreesFromYAxis(float dx, float dy){
		return arcsin(Math.abs(dx) / hypotenuse(dx, dy));
	}
	public static final double displacementToDegreesFromYAxis(double dx, double dy){
		return arcsin(Math.abs(dx) / hypotenuse(dx, dy));
	}
	
	public static final int displacementToDegrees(int dx, int dy){
		if(displacementToQuadrant(dx, dy) == 1) return displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 2) return 180 - displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 3) return 180 + displacementToDegreesFromYAxis(dx, dy);
		return 360 - displacementToDegreesFromYAxis(dx, dy);
	}
	public static final int displacementToDegrees(long dx, long dy){
		if(displacementToQuadrant(dx, dy) == 1) return displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 2) return 180 - displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 3) return 180 + displacementToDegreesFromYAxis(dx, dy);
		return 360 - displacementToDegreesFromYAxis(dx, dy);
	}
	public static final float displacementToDegrees(float dx, float dy){
		if(displacementToQuadrant(dx, dy) == 1) return displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 2) return 180 - displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 3) return 180 + displacementToDegreesFromYAxis(dx, dy);
		return 360 - displacementToDegreesFromYAxis(dx, dy);
	}
	public static final double displacementToDegrees(double dx, double dy){
		if(displacementToQuadrant(dx, dy) == 1) return displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 2) return 180 - displacementToDegreesFromYAxis(dx, dy);
		if(displacementToQuadrant(dx, dy) == 3) return 180 + displacementToDegreesFromYAxis(dx, dy);
		return 360 - displacementToDegreesFromYAxis(dx, dy);
	}
}
