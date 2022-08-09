import daos.IPhonesDAO;
import models.IPhones;

import java.util.Arrays;
import java.util.List;

public class Main {
    //"App runner" to run each CRUD operation

    public static void main(String[] args) {

        //for findById()
        IPhonesDAO iPhonesDAO = new IPhonesDAO();
        IPhones iPhones = iPhonesDAO.findById(3);

        System.out.println(iPhones.getId());
        System.out.println(iPhones.getName());

        //for findAll()
        List<IPhones> iPhones1 = iPhonesDAO.findAll();
        System.out.println(iPhones1.toString());

        //for update()
        IPhones iPhones2 = new IPhones();
        iPhones2.setId(2);
        iPhones2.setSize(6.1f);
        iPhones2.setCost(1200);
        iPhones2.setFingerprint("N");
        iPhones2.setName("iPhone 14");
        iPhones2.setYear_released("2022");
        IPhones dto = iPhonesDAO.update(iPhones2);
        System.out.println(dto);

        //for create()
        IPhones iPhones3 = new IPhones();
        iPhones3.setId(7);
        iPhones3.setSize(6.7f);
        iPhones3.setCost(1300);
        iPhones3.setFingerprint("N");
        iPhones3.setName("iPhone 14 Pro");
        iPhones3.setYear_released("2022");
        IPhones dto2 = iPhonesDAO.create(iPhones3);
        System.out.println(dto2);

        //for delete()
        iPhonesDAO.delete(7);

    }
}
