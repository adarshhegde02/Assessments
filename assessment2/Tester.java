package assessment2;

public class Tester {
	public static void main(String[] args) {
		MobileDTO details = new MobileDTO();
		details.setBrand("Apple");
		details.setMemory(32);
		details.setMobileID(101);
		details.setModel("iPhone");
		details.setNoofCamera(2);
		details.setSerialNo(101234);
		details.setPrice(25000.00);

		MobileDAO dao = new MobileDAO();
		dao.add(details);

		MobileDTO details1 = new MobileDTO();
		details1.setBrand("Samsung");
		details1.setMemory(32);
		details1.setMobileID(104);
		details1.setModel("Galaxy");
		details1.setNoofCamera(2);
		details1.setSerialNo(104222);
		details1.setPrice(12000.00);

		dao.add(details1);

		MobileDTO details2 = new MobileDTO();
		details2.setBrand("Xiaomi");
		details2.setMemory(32);
		details2.setMobileID(107);
		details2.setModel("Redmi");
		details2.setNoofCamera(2);
		details2.setSerialNo(107122);
		details2.setPrice(8000.00);

		dao.add(details2);
		
		MobileDTO details3 = new MobileDTO();
		details3.setBrand("OnePlus");
		details3.setMemory(32);
		details3.setMobileID(105);
		details3.setModel("Nord");
		details3.setNoofCamera(2);
		details3.setSerialNo(105522);
		details3.setPrice(18000.00);
		
		dao.add(details3);

		dao.getAll();

		try{
			System.out.println(dao.updateBySerialNumber(107822, 107333));
		}
		catch(UpdateException e){
			System.out.println(e.getMessage());
		}

		dao.deleteByMobileID(105);
		
		dao.getAllByBrandName("Apple");

		dao.getAll();

	}

}
