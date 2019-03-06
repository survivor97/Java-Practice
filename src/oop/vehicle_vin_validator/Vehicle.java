package oop.vehicle_vin_validator;

/*
 * Vehicle Identification Numbers (VIN codes)/Check digit:
 * https://en.wikibooks.org/wiki/Vehicle_Identification_Numbers_(VIN_codes)/Check_digit
 */

public class Vehicle 
{
	private final static String producedBy = "Toyota";
	private final int productionYear;
	private final String vin;
	private String plateNumber;
	private int kilometers;
	private int lastSoldOnYear;
	private double positionX, positionY;
	
	public Vehicle(int productionYear, String vin){
		this.productionYear = productionYear;
		this.vin = vin;
	}
	
	public Vehicle(int productionYear, String vin, String plateNumber){
		this.productionYear = productionYear;
		this.vin = vin;
		this.plateNumber = plateNumber;
	}
	
	public Vehicle(int productionYear, String vin, String plateNumber, int lastSoldOnYear){
		this.productionYear = productionYear;
		this.vin = vin;
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}
	
	public Vehicle(int productionYear, String vin, String plateNumber, int lastSoldOnYear, int kilometers){
		this.productionYear = productionYear;
		this.vin = vin;
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
		this.kilometers = kilometers;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public int getKilometers()
	{
		return kilometers;
	}
	
	public void sellVehicle(String plateNumber, int lastSoldOnYear)
	{
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}
	
	public double move(double positionX, double positionY)
	{
		double distance = Math.sqrt(Math.pow((positionX - this.positionX), 2)+Math.pow((positionY - this.positionY), 2));
		this.positionX = positionX;
		this.positionY = positionY;
		return distance;
	}
	
	public boolean isVinValid(boolean isDrivingInNorthAmerica)
	{
		if(isDrivingInNorthAmerica)
		{
			return validateVin(this.vin);
		}
		else
		{
			return true;
		}
	}	
	
	public void printVinDecomposed()
	{
		System.out.println("--------------------");
		System.out.println("Manufacturer Identifier: "+this.vin.subSequence(0, 3));
		System.out.println("Vehicle's Attributes: "+this.vin.subSequence(3, 8));
		System.out.println("Verification Number: "+this.vin.charAt(8));
		System.out.println("Model Year: "+this.vin.charAt(9));
		System.out.println("Plant Code: "+this.vin.charAt(10));
		System.out.println("Numeric Identifier: "+this.vin.subSequence(11, 17));
		System.out.println("--------------------");
	}
	
	public void display()
	{
		System.out.println("--------------------");
		System.out.println("Produced By: "+this.producedBy);
		System.out.println("Production Year: "+this.productionYear);
		System.out.println("VIN Number: "+this.vin);
		System.out.println("Plate Number: "+this.plateNumber);
		System.out.println("Kilometers: "+this.kilometers);
		System.out.println("Last Sold On: "+this.lastSoldOnYear);
		System.out.println("Current Position (X, Y): "+this.positionX+"; "+this.positionY);
		System.out.println("--------------------");
	}

	//PRIVATE METHODS
	private boolean validateVin(String inputVin)	{
		String transliteratedValues = getConvertedValues(inputVin);	 
		if(!transliteratedValues.equals("error") && inputVin.length() == 17) {
			int[] weights = getWeightArray(17);
			int[] products = getProductArray(transliteratedValues, weights, 17);	
			int sumOfProducts = getSumOfArrayElements(products);	
			
			System.out.print("Correct Verification Number: ");
			int  modulo = sumOfProducts % 11;
			
			//Modulo int to char
			char moduloChar;
	
			if(modulo == 10)
			{
				moduloChar = 'X';
			}
			else
			{
				moduloChar = (char)(modulo + 48);
			}
			System.out.println(moduloChar);
			if(getVerificationCharacter(inputVin) == moduloChar)
			{
				System.out.println("VIN is valid!"); 
				return true;
			}
			else
			{
				System.out.println("Invalid VIN!");
				return false;
			}
		}
		else {
		System.out.println("Wrong VIN Number!");
		return false;
		}
	}

	private String getConvertedValues(String inputVin) {
		if(inputVin.length() == 17) {		
			StringBuilder str = new StringBuilder();
			for(int i=0; i<inputVin.length(); i++)	{
				if(Character.isLetter(inputVin.charAt(i))) {
					switch(inputVin.charAt(i)) { 
					case 'A':	str.append("1"); break;
					case 'B':	str.append("2"); break;
					case 'C':	str.append("3"); break;
					case 'D':	str.append("4"); break;
					case 'E':	str.append("5"); break;
					case 'F':	str.append("6"); break;
					case 'G':	str.append("7"); break; 
					case 'H':	str.append("8"); break;
					case 'J':	str.append("1"); break;
					case 'K':	str.append("2"); break;
					case 'L':	str.append("3"); break;
					case 'M':	str.append("4"); break;
					case 'N':	str.append("5"); break;
					case 'P':	str.append("7"); break;
					case 'R':	str.append("9"); break;
					case 'S':	str.append("2"); break;
					case 'T':	str.append("3"); break;
					case 'U':	str.append("4"); break;
					case 'V':	str.append("5"); break;
					case 'W':	str.append("6"); break;
					case 'X':	str.append("7"); break;
					case 'Y':	str.append("8"); break;
					case 'Z':	str.append("9"); break;
					default:	System.out.println("WRONG VIN LETTER!"); return "error";
					}
				}
				else if(Character.isDigit(inputVin.charAt(i))) {
					str.append(inputVin.charAt(i));
				}
				else if(inputVin.charAt(i) == '_')
				{
					str.append("_");
				}
			}
			return str.toString();
		}
		else
		{
			System.out.println("WRONG VIN FORMAT!"); return "error";
		}
	}
	
	private int getWeight(int position) {
		int pos = position + 1;
		if(pos == 8) {
			return 10;
		}
		else {
			return 9 - pos % 10;
		}
	}
	
	private int[] getWeightArray(int arrayLength)
	{
		int[] arr = new int[arrayLength];
		for(int i=0; i<arrayLength; i++)
		{
			arr[i] = getWeight(i);
		}
		return arr;
	}
	
	private int[] getProductArray(String convertedValues, int[] weightsArray, int arrayLength) {
		int[] arr = new int[arrayLength];
		for(int i=0; i < arrayLength; i++) {
			arr[i] = Character.getNumericValue(convertedValues.charAt(i)) * weightsArray[i];
		}	
		return arr;
	}
	
	private int getSumOfArrayElements(int[] inputArray)
	{
		int sum = 0;
		for(int i=0; i<inputArray.length; i++)
		{
			sum += inputArray[i];
		}
		return sum;
	}
	
	private char getVerificationCharacter(String inputVin)
	{
		if(Character.isDigit(inputVin.charAt(8)) || inputVin.charAt(8) == 'X')
		return inputVin.charAt(8);
		else
		{
			System.out.println("WRONG VERIFICATION CHARACTER!");
			return '\0';
		}
	}	
	
}
