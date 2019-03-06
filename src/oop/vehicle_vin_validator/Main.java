package oop.vehicle_vin_validator;

public class Main {
	public static void main(String[] args)
	{
		//1M8GDM9AXKP042788
		Vehicle myVehicle = new Vehicle(1991, "4T1SV21E1MU396756", "XX 33 66", 2000, 250_000);
		myVehicle.isVinValid(true);
		myVehicle.printVinDecomposed();
		myVehicle.display();
	}
}
