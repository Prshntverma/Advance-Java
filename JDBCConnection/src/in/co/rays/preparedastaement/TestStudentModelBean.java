package in.co.rays.preparedastaement;

import java.sql.SQLException;

public class TestStudentModelBean {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//TestAdd();
	   // update();
		delete();
	}

	private static void delete() throws ClassNotFoundException, SQLException {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
	
		bean.setId(2);
		
		
		model.delete(bean);
	

		
	}

	private static void update() throws ClassNotFoundException, SQLException {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		
		
		bean.setName("ram");
		bean.setPercentage(56.00);
		bean.setId(2);
		
		
		model.update(bean);
	
		
	}

	private static void TestAdd() throws ClassNotFoundException, SQLException {
	
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		
		bean.setId(2);
		bean.setName("shyam");
		bean.setPercentage(84.00);
		
		model.add(bean);
		
		
		
	}

}	
