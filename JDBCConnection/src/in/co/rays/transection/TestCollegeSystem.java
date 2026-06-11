package in.co.rays.transection;

import java.sql.SQLException;

public class TestCollegeSystem {
	public static void main(String[] args) throws Exception  {

      //add();
	  //update();
	   delete();
      
	}

	private static void delete() throws Exception {

		        CollegeSystemBean bean = new CollegeSystemBean();

		        bean.setStudentId(5);

		        CollegeSystemModel model = new CollegeSystemModel();

		        model.delete(bean);
		    }
		
	

	private static void update() throws Exception {

		CollegeSystemBean bean = new CollegeSystemBean();

		
		bean.setStudentId(2);
        bean.setStudentName("Chinkkkk");
        bean.setBranch("information technology");
        bean.setSemester(7);
        bean.setCgpa(8.33);

        CollegeSystemModel model = new CollegeSystemModel();

        model.update(bean);
		
	}

	public static void add() throws Exception {
	
		CollegeSystemBean bean = new CollegeSystemBean();

        bean.setStudentName("Kanak Soni");
        bean.setBranch("BBA");
        bean.setSemester(6);
        bean.setCgpa(8.5);

        CollegeSystemModel model = new CollegeSystemModel();

        model.add(bean);
	}
	
}


