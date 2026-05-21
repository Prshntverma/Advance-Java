package in.co.rays.preparedastaement;

import java.sql.SQLException;

public class TestEmpBean {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//testAdd();
		//updateAdd();
		delete();
	}

	private static void delete() throws ClassNotFoundException, SQLException {
		
		EmpBean bean = new EmpBean();
		EmpModel model = new EmpModel(); 
		
		bean.setId(3);
		 model.delete(bean);
		
	}

	private static void updateAdd() throws ClassNotFoundException, SQLException {
		EmpBean bean = new EmpBean();
		EmpModel model = new EmpModel(); 
		
		bean.setId(1);
		bean.setName("Chinkuu ");
		bean.setSalary(89000.00);
		
		model.update(bean);
		
		
	}

	private static void testAdd() throws ClassNotFoundException, SQLException {
	
		EmpBean bean = new EmpBean();
		EmpModel model = new EmpModel(); 
		
		bean.setId(3);
		bean.setName("Astha ");
		bean.setSalary(40000.00);
		
		model.add(bean);
		
	}
}
