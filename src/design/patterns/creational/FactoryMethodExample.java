package design.patterns.creational;

import java.util.Scanner;

public class FactoryMethodExample {

	private TransportService transportService;
	
	abstract class TransportService{
		Vehicle transportVehicle;
		
		void travelToDestination(String destination) {
			System.out.println("Travelling to "+destination+" in "+transportVehicle.getName());
		}
		
		abstract void getVehicle();
	}
	
	class CarTransportService extends TransportService{
		void getVehicle() {
			transportVehicle = new Car();
		}
	}
	
	class BusTransportService extends TransportService{
		void getVehicle() {
			transportVehicle = new Bus();
		}
	}
	
	interface Vehicle{
		void travel();
		String getName();
	}
	
	class Car implements Vehicle{
		String name = "Car";
		
		@Override
		public void travel() {
			System.out.println("Travelling in Car");			
		}
		
		@Override
		public String getName() {
			return name;
		}
	}
	
	class Bus implements Vehicle{
		String name = "Bus";
		
		@Override
		public void travel() {
			System.out.println("Travelling in Bus");
		}
		
		@Override
		public String getName() {
			return name;
		}
	}
	
	void init(int choice) {
		switch(choice) {
			case 1: transportService = new CarTransportService(); break;
			case 2: transportService = new BusTransportService(); break;
			default: throw new RuntimeException("invalid input choice: "+choice);
		}
		
		transportService.getVehicle();
	}
	
	void transport(String destination) {
		transportService.travelToDestination(destination);
	}
	
	public static void main(String[] args) {
		
		FactoryMethodExample factoryMethod = new FactoryMethodExample();
		
		try (Scanner in = new Scanner(System.in)) {
			for(int i=0;i<3;i++) {
				System.out.println("enter choice of transport by vehicle: 1.Car 2.Bus");
				int choice = in.nextInt();
			
				factoryMethod.init(choice);
				factoryMethod.transport("Delhi");
			}
		}
	}

}
