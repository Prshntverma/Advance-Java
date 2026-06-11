package in.co.rays.bundle;

import java.sql.SQLException;

public class TestProduct {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
		add();
		//update();
		//delete();
	}



	private static void delete() throws ClassNotFoundException, SQLException {
		BundleProductBean bean = new BundleProductBean();

		bean.setPro_id(1);

		BundleProModel model = new BundleProModel();

		model.delete(bean);
	}



	public static void add() throws ClassNotFoundException, SQLException {
		BundleProModel model = new BundleProModel();
		BundleProductBean bean = new BundleProductBean();

		
		bean.setPro_id(1);
		bean.setPro_prize(85000.45);
		bean.setProduct_name("Iphone 17");
		bean.setProd_description("smart moblie");
		
		model.add(bean);
		
		
	}
	  public static void update()
	            throws ClassNotFoundException, SQLException {

	        BundleProModel model = new BundleProModel();

	        BundleProductBean bean = new BundleProductBean();

	        bean.setPro_id(1); // Existing Product ID
	        bean.setProduct_name("Samsung S26 Ultra");
	        bean.setProd_description("Android Smart Mobile");
	        bean.setPro_prize(95000.00);

	        model.update(bean);
}
	  }
