package assessment2;


public class MobileDAO extends Methods {
	private MobileDTO details[] = new MobileDTO[10];
	private int index = 0;

	public void getAll() {
		for (int i = 0; i < details.length; i++) {
			if (details[i] != null) {
				System.out.println(details[i]);
			}
		}
	}

	public boolean add(MobileDTO details) {
		if (details != null) {
			if (index < this.details.length) {
				this.details[index] = details;
				index++;
				return true;
			} 
			else {
				System.out.println();
				System.out.println("No space...");
				return false;
			}
		}
		return false;
	}

	public MobileDTO deleteByMobileID(int mobileID) {
		for (int i = 0; i < details.length; i++) {
			if (details[i] != null) {
				if (details[i].getMobileID() == mobileID) {
					details[i] = null;
					return details[i];

				}
			}
		}return null;
	}

	public MobileDTO updateBySerialNumber(int serialNumber, int newNumber) throws UpdateException {
		for (int i = 0; i < details.length; i++) {
			if (details[i] != null) {
				if (serialNumber == details[i].getSerialNo()) {
					details[i].setSerialNo(newNumber);
				return details[i];
			}
				else {
					UpdateException updateException=new UpdateException();
					throw updateException;
				}
		}

	}return null;
	}

	void getAllByBrandName(String brandName) {
		for (int i = 0; i < details.length; i++) {
			if (details[i] != null) {
				if (brandName.equals(details[i].getBrand()))
					System.out.println(details[i]);
			}
		}

	}
}
