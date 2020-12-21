package design.patterns.creational;

public class BuilderExample {

	class Mobile{
		int cpuCores;
		int ramSize;
		int storage;
		int batteryCapacity;
		
		@Override
		public String toString() {
			return String.format("this Mobile is configured with cpucores: %d, ram: %dGb, storage: %dGb, battery capactiy: %dMAh", cpuCores, ramSize, storage, batteryCapacity);
		}
	}
	
	class MobileBuilder{
		Mobile mobile;
		
		MobileBuilder reset() {
			this.mobile = new Mobile();
			return this;
		}
		
		MobileBuilder setCpuCores(int val) {
			mobile.cpuCores = val;
			return this;
		}
		
		MobileBuilder setRamSize(int val) {
			mobile.ramSize = val;
			return this;
		}
		
		MobileBuilder setStorage(int val) {
			mobile.storage = val;
			return this;
		}
		
		MobileBuilder setBatteryCapacity(int val) {
			mobile.batteryCapacity = val;
			return this;
		}
		
		Mobile build() {
			return mobile;
		}
	}
	
	void example() {
		Mobile mobile = new MobileBuilder()
				.reset()
				.setCpuCores(8)
				.setRamSize(16)
				.setStorage(256)
				.setBatteryCapacity(4000).build();
		System.out.println(mobile);
	}
	
	public static void main(String[] args) {
		BuilderExample example = new BuilderExample();
		example.example();
	}
}
