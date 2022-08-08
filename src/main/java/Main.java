import daos.IPhonesDAO;
import models.IPhones;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //for findById()
        IPhonesDAO iPhonesDAO = new IPhonesDAO();
        IPhones iPhones = iPhonesDAO.findById(3);

        System.out.println(iPhones.getId());
        System.out.println(iPhones.getName());

        //for findAll()
        List<IPhones> iPhones1 = iPhonesDAO.findAll();
        System.out.println(iPhones1.toString());
    }
}
