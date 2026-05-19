package in.co.rays.preparedastaement;

import java.sql.SQLException;
import java.util.Date;

public class TestBeanModel {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		testadd();	
	}

	private static void testadd() throws ClassNotFoundException, SQLException {
		
		UserBean bean = new  UserBean ();
		UserModel model = new UserModel();
		
		
		bean.setId(1);
		bean.setFirstName("Prashant");
		bean.setLastName("Verma");
		bean.setEmail("abc@gm,ail.com");
		bean.setPassword("abc");
		
		 model.add(bean);
		
		
		
		
	}

}