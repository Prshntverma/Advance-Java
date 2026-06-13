package in.co.rays.preparedastaement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

    public static void main(String[] args) throws Exception {

         //testAdd();

        testUpdate();

        // testDelete();

        // testFindByLogin();

         //testFindByPk();

        // testAuthenticate();

        // testSearch();
    }

    public static void testAdd() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        UserBean bean = new UserBean();

        bean.setFirstName("kanak");
        bean.setLastName("soni");
        bean.setLogin("kanak@gmail.com");
        bean.setPassword("kanak123");
        bean.setDob(sdf.parse("2005-05-15"));

        UserModel model = new UserModel();

        model.add(bean);

        System.out.println("Record Inserted Successfully");
    }

    public static void testUpdate() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        UserBean bean = new UserBean();

        bean.setId(1); // Existing ID
        bean.setFirstName("Prashant");
        bean.setLastName("Sharma");
        bean.setLogin("kanak@gmail.com");
        bean.setPassword("12345");
        bean.setDob(sdf.parse("2001-06-20"));

        UserModel model = new UserModel();

        model.update(bean);

        System.out.println("Record Updated Successfully");
    }

    public static void testDelete() throws Exception {

        UserBean bean = new UserBean();

        bean.setId(1); // Existing ID

        UserModel model = new UserModel();

        model.delete(bean);

        System.out.println("Record Deleted Successfully");
    }

    public static void testFindByLogin() throws Exception {

        UserModel model = new UserModel();

        UserBean bean = model.findByLogin("prashan@gmail.com");

        if (bean != null) {

            System.out.println("ID : " + bean.getId());
            System.out.println("First Name : " + bean.getFirstName());
            System.out.println("Last Name : " + bean.getLastName());
            System.out.println("Login : " + bean.getLogin());
            System.out.println("Password : " + bean.getPassword());
            System.out.println("DOB : " + bean.getDob());

        } else {

            System.out.println("Record Not Found");
        }
    }

    public static void testFindByPk() throws Exception {

        UserModel model = new UserModel();

        UserBean bean = model.findByPk(1);

        if (bean != null) {

            System.out.println("ID : " + bean.getId());
            System.out.println("First Name : " + bean.getFirstName());
            System.out.println("Last Name : " + bean.getLastName());
            System.out.println("Login : " + bean.getLogin());
            System.out.println("Password : " + bean.getPassword());
            System.out.println("DOB : " + bean.getDob());

        } else {

            System.out.println("Record Not Found");
        }
    }

    public static void testAuthenticate() throws Exception {

        UserModel model = new UserModel();

        UserBean bean = model.authenticate(
                "prashant@gmail.com",
                "prashant123");

        if (bean != null) {

            System.out.println("Login Successful");

            System.out.println("ID : " + bean.getId());
            System.out.println("First Name : " + bean.getFirstName());
            System.out.println("Last Name : " + bean.getLastName());
            System.out.println("Login : " + bean.getLogin());

        } else {

            System.out.println("Invalid Login Id or Password");
        }
    }

    public static void testSearch() throws Exception {

        UserBean bean = new UserBean();

        bean.setFirstName("Prashant");

        UserModel model = new UserModel();

        List<UserBean> list = model.search(bean);

        Iterator<UserBean> it = list.iterator();

        while (it.hasNext()) {

            bean = it.next();

            System.out.print(bean.getId());
            System.out.print("\t" + bean.getFirstName());
            System.out.print("\t" + bean.getLastName());
            System.out.print("\t" + bean.getLogin());
            System.out.print("\t" + bean.getPassword());
            System.out.println("\t" + bean.getDob());
        }
    }
}