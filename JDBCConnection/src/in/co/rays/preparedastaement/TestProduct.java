package in.co.rays.preparedastaement;

import java.sql.SQLException;

public class TestProduct {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//add();
		//update();
		//delete();
		
	}

	private static void delete() throws ClassNotFoundException, SQLException {
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean.setPro_id(2);
		
		model.delete(bean);


		
	}

	private static void update() throws ClassNotFoundException, SQLException {
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean.setPro_id(1);
		bean.setProduct_name("HP ");
		bean.setProd_description("Laptop.......");
		bean.setPro_prize(40000.00);
		
		
		model.update(bean);
		

		
	}

	private static void add() throws ClassNotFoundException, SQLException {
		
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean.setPro_id(2);
		bean.setProduct_name("One Plus Smart Phone");
		bean.setProd_description("5G Smart phone  CE 4 Series.......");
		bean.setPro_prize(20000.00);
		
		model.add(bean);
		
		
	}

}
