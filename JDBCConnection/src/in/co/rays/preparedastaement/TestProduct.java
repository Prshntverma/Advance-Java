package in.co.rays.preparedastaement;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestProduct {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		add();
		//update();
		//delete();
		//search();
		
	}

	private static void search() throws ClassNotFoundException, SQLException {

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		List<ProductBean> list = model.search();

		Iterator<ProductBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getPro_id());
			System.out.println(bean.getProduct_name());
			System.out.println(bean.getProd_description());
			System.out.println(bean.getPro_prize());

			System.out.println("----------------");
		}
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
