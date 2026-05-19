package in.co.rays.preparedastaement;

import java.sql.SQLException;

public class TestStudentModelBean {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TestAdd();
	}

	private static void TestAdd() throws ClassNotFoundException, SQLException {
	
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		
		bean.setId(1);
		bean.setName("Prashant");
		bean.setPercentage("84%");
		
		model.add(bean);
		
		
		
	}

}	
