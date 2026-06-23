package com.rays.test;

import java.util.List;

import com.rays.bean.SchlorshipBean;
import com.rays.model.SchlorshipModel;

public class TestSchlorship {

	public static void main(String[] args) throws Exception {

		// add();
		// update();
		// delete();
		// findByPK();
		// search();
		list();
	}

	private static void add() throws Exception {

		SchlorshipBean bean = new SchlorshipBean();

		bean.setStudentName("Prashant Verma");
		bean.setAmount(25000.00);
		bean.setYear("2020");
		bean.setStatus("Approved");

		SchlorshipModel model = new SchlorshipModel();

		int pk = model.add(bean);

		System.out.println("Data Inserted Successfully : " + pk);
	}

	private static void update() throws Exception {

		SchlorshipBean bean = new SchlorshipBean();

		bean.setId(1);
		bean.setStudentName("Prashant Updated");
		bean.setAmount(30000.00);
		bean.setYear("2021");
		bean.setStatus("Pending");

		SchlorshipModel model = new SchlorshipModel();

		model.update(bean);

		System.out.println("Record Updated Successfully");
	}

	private static void delete() throws Exception {

		SchlorshipModel model = new SchlorshipModel();

		model.delete(1);

		System.out.println("Record Deleted Successfully");
	}

	private static void findByPK() throws Exception {

		SchlorshipModel model = new SchlorshipModel();

		SchlorshipBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.println("ID = " + bean.getId());
			System.out.println("Name = " + bean.getStudentName());
			System.out.println("Amount = " + bean.getAmount());
			System.out.println("Year = " + bean.getYear());
			System.out.println("Status = " + bean.getStatus());

		} else {
			System.out.println("Record Not Found");
		}
	}

	private static void search() throws Exception {

		SchlorshipBean bean = new SchlorshipBean();

		bean.setStudentName("Pra");

		SchlorshipModel model = new SchlorshipModel();

		List<SchlorshipBean> list = model.search(bean);

		for (SchlorshipBean b : list) {

			System.out.println(
					b.getId() + "\t" +
					b.getStudentName() + "\t" +
					b.getAmount() + "\t" +
					b.getYear() + "\t" +
					b.getStatus());
		}
	}

	private static void list() throws Exception {

		SchlorshipModel model = new SchlorshipModel();

		List<SchlorshipBean> list = model.list();

		for (SchlorshipBean b : list) {

			System.out.println(
					b.getId() + "\t" +
					b.getStudentName() + "\t" +
					b.getAmount() + "\t" +
					b.getYear() + "\t" +
					b.getStatus());
		}
	}
}