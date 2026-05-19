package in.co.rays.preparedastaement;

import java.sql.SQLException;

public class TestProduct {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		add();
	}

	private static void add() throws ClassNotFoundException, SQLException {
		
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean.setPro_id(1);
		bean.setProduct_name("One Plus Smart Phone");
		bean.setProduct_description("5G Smart phone  CE 4 Series.......");
		bean.setPrize(20000.00);
		
		model.add(bean);
		
		
	}

}
