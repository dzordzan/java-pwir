package cw1;
//Andrzej Piszczek (c) 2014
class Vehicle {
	private String name, type;
	private int speedLimit, power, weight;
	
	
	public Vehicle(String name, String type, int speedLimit, int power,
			int weight) {
		super();
		this.name = name;
		this.type = type;
		this.speedLimit = speedLimit;
		this.power = power;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getSpeedLimit() {
		return speedLimit;
	}


	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", type=" + type + ", speedLimit="
				+ speedLimit + ", power=" + power + ", weight=" + weight + "]";
	}


	
	
}

	class Car extends Vehicle {
	private String Brand; 
	private int yearOfProduction;
	
	public Car(String name, String type, int speedLimit, int power, int weight,
			String brand, int yearOfProduction) {
		super(name, type, speedLimit, power, weight);
		Brand = brand;
		this.yearOfProduction = yearOfProduction;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	@Override
	public String toString() {
		return super.toString()+" Car [Brand=" + Brand + ", yearOfProduction=" + yearOfProduction
				+ "]";
	}
	
	
	
}

class Tank extends Vehicle {
	private int traverseSpeed;
	private String tankType;
	
	public Tank(String name, String type, int speedLimit, int power,
			int weight, int traverseSpeed, String tankType) {
		super(name, type, speedLimit, power, weight);
		this.traverseSpeed = traverseSpeed;
		this.tankType = tankType;
	}
	public int getTraverseSpeed() {
		return traverseSpeed;
	}
	public void setTraverseSpeed(int traverseSpeed) {
		this.traverseSpeed = traverseSpeed;
	}
	public String getTankType() {
		return tankType;
	}
	public void setTankType(String tankType) {
		this.tankType = tankType;
	}
	@Override
	public String toString() {
		return "Tank [traverseSpeed=" + traverseSpeed + ", tankType="
				+ tankType + "]";
	}
	
	
}

public class zad3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle rower = new Vehicle("Wigry 3", "dwukolowy", 999, 0, 10);
		Car audi = new Car("Audi a3", "Spalinowy", 190, 110, 1500, "audi", 2009);
		System.out.print(rower.toString());
		System.out.println();
		System.out.print(audi.toString());
	}

}
