package com.rays.test;

import com.rays.bean.ModuleBean;
import com.rays.model.ModuleModel;

public class TestModule {
	public static void main(String[] args) throws Exception {
		 testAdd();
         //testUpdate();
        // testDelete();
        // testFindByPK();
        // testFindByName();
        // testSearch();
		
		
	}

	private static void testAdd() throws Exception {
		 ModuleModel model = new ModuleModel();
	        ModuleBean bean = new ModuleBean();

	        bean.setModuleName("JSP / Servlet");
	        bean.setTechnology("Java");
	        bean.setDeveloperName("Prashant Verma");
	        bean.setStatus("Active");

	        model.add(bean);

	        System.out.println("Data Inserted Successfully");
	}
	public static void testUpdate() throws Exception {

        ModuleModel model = new ModuleModel();
        ModuleBean bean = new ModuleBean();

        bean.setModuleId(1); // Existing Module ID
        bean.setModuleName("Library Management");
        bean.setTechnology("Spring Boot");
        bean.setDeveloperName("Prashant Verma");
        bean.setStatus("Completed");

        model.update(bean);

        System.out.println("Data Updated Successfully");
    }
	


}
