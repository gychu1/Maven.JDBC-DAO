import daos.IPhonesDAO;
import models.IPhones;

public class Main {

    public static void main(String[] args) {

        IPhonesDAO iPhonesDAO = new IPhonesDAO();
        IPhones iPhones = iPhonesDAO.findById(3);

        System.out.println(iPhones.getId());
        System.out.println(iPhones.getName());
    }
}
