package com.rays.test;

import java.util.List;

import com.rays.bean.CricketPlayerBean;
import com.rays.model.CricketModel;
public class TestCricket {
public static void main(String[] args) throws Exception {
	//add();
	//update();
	//delete();
	//findByPk();
	//list();
	search();
}

private static void search() throws Exception {
	CricketPlayerBean bean = new CricketPlayerBean();

	bean.setPlayerName("Virat");

	CricketModel model = new CricketModel();

	List<CricketPlayerBean> list = model.search(bean);

	for (CricketPlayerBean cp : list) {

		System.out.print(cp.getId());
		System.out.print("\t" + cp.getPlayerName());
		System.out.print("\t" + cp.getTeam());
		System.out.print("\t" + cp.getRole());
		System.out.println("\t" + cp.getRuns());
	}
}

private static void list() throws Exception {

	CricketModel model = new CricketModel();

	List<CricketPlayerBean> list = model.list();

	for (CricketPlayerBean bean : list) {

		System.out.print(bean.getId());
		System.out.print("\t" + bean.getPlayerName());
		System.out.print("\t" + bean.getTeam());
		System.out.print("\t" + bean.getRole());
		System.out.println("\t" + bean.getRuns());
	}
}


private static void findByPk() throws Exception {
	CricketModel model = new CricketModel();

	CricketPlayerBean bean = model.findByPK(1);

	if (bean != null) {

		System.out.println("ID = " + bean.getId());
		System.out.println("Name = " + bean.getPlayerName());
		System.out.println("Amount = " + bean.getTeam());
		System.out.println("Year = " + bean.getRole());
		System.out.println("Status = " + bean.getRuns());

	} else {
		System.out.println("Record Not Found");
	}
}
	


private static void delete() throws Exception {
	
	CricketModel model = new CricketModel();

	model.delete(1);

	System.out.println("Data Deleted Successfully");
	
}

private static void update() throws Exception {

	CricketPlayerBean bean = new CricketPlayerBean();

	bean.setId(1); // Existing ID
	bean.setPlayerName("Virat Kohli");
	bean.setTeam("India");
	bean.setRole("Captain");
	bean.setRuns(35000);

	CricketModel model = new CricketModel();

	model.update(bean);

	System.out.println("Data Updated Successfully");
}

private static void add() throws Exception {
		CricketPlayerBean bean = new CricketPlayerBean();
         bean.setPlayerName("virat kohli");
         bean.setTeam("RCB");
         bean.setRole("Captain Batsman");
         bean.setRuns(34000);
     	CricketModel model = new CricketModel();

		int pk = model.add(bean);

		System.out.println("Data Inserted Successfully : " + pk);
	}

	
}

