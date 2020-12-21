package design.patterns.creational;

import java.util.Scanner;

public class AbstractFactoryExample {

	FurnitureFactory factory;
	
	interface FurnitureFactory{
		Chair getChair();
		Sofa getSofa();
		Table getTable();
	}
	
	class IndianFurnitueFactory implements FurnitureFactory {

		@Override
		public Chair getChair() {
			return new IndianChair();
		}

		@Override
		public Sofa getSofa() {
			return new IndianSofa();
		}

		@Override
		public Table getTable() {
			return new IndianTable();
		}
	}
	
	class WesternFurnitureFactory implements FurnitureFactory {

		@Override
		public Chair getChair() {
			return new WesternChair();
		}

		@Override
		public Sofa getSofa() {
			return new WesternSofa();
		}

		@Override
		public Table getTable() {
			return new WesternTable();
		}
		
	}
	
	interface Chair{
		void use();
	}
	
	interface Sofa{
		void use();
	}
	
	interface Table{
		void use();
	}
	
	class IndianChair implements Chair{

		@Override
		public void use() {
			System.out.println("using IndianChair");
		}
	}
	
	class WesternChair implements Chair{

		@Override
		public void use() {
			System.out.println("using WesternChair");
		}
		
	}
	
	class IndianSofa implements Sofa{

		@Override
		public void use() {
			System.out.println("using IndianSofa");
		}
		
	}
	
	class WesternSofa implements Sofa{

		@Override
		public void use() {
			System.out.println("using WesternSofa");
		}
		
	}

	class IndianTable implements Table{

		@Override
		public void use() {
			System.out.println("using IndianTable");
		}
		
	}
	
	class WesternTable implements Table{

		@Override
		public void use() {
			System.out.println("using WesternTable");
		}
		
	}
	
	void init(Scanner in) {
		System.out.println("Enter one of below choice 1.IndianFactory 2.WesternFactory: ");
		int choice = in.nextInt();
		
		if(choice == 1)
			factory = new IndianFurnitueFactory();
		else if(choice == 2)
			factory = new WesternFurnitureFactory();
		else throw new RuntimeException("invalid Input");
	}
	
	void createFurniture() {
		factory.getChair().use();
		factory.getSofa().use();
		factory.getTable().use();
	}
	
	public static void main(String[] args) {
		AbstractFactoryExample abstractFactory = new AbstractFactoryExample();
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<3;i++) {
			abstractFactory.init(in);
			abstractFactory.createFurniture();
		}
	}
}
