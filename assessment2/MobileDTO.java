package assessment2;

public class MobileDTO {
	private int mobileID;
	private String brand;
	private String model;
	private int serialNo;
	private double price;
	private int noofCamera;
	private int memory;

	public int getMobileID() {
		return mobileID;
	}

	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoofCamera() {
		return noofCamera;
	}

	public void setNoofCamera(int noofCamera) {
		this.noofCamera = noofCamera;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return "MobileDetails [mobileID=" + mobileID + ", brand=" + brand + ", model=" + model + ", serialNo="
				+ serialNo + ", price=" + price + ", noofCamera=" + noofCamera + ", memory=" + memory + "]";
	}

}
