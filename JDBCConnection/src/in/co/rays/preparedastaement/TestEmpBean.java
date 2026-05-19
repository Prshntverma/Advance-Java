package in.co.rays.preparedastaement;

import java.sql.SQLException;

public class TestEmpBean {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TestAdd();
	}

	private static void TestAdd() throws ClassNotFoundException, SQLException {
	
		EmpBean bean = new EmpBean();
		EmpModel model = new EmpModel(); 
		
		bean.setId(2);
		bean.setName("Kanak ");
		bean.setSalary(83000.00);
		
		model.add(bean);
		
	}
}
