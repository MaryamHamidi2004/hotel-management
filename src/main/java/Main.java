import model.Hotel;
import model.Manager;
import util.enums.HotelStatus;
import service.HotelService;
import service.ManagerService;
import view.login.Login;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (Objects.isNull(HotelService.getInstance().find())){
            Manager manager = ManagerService.getInstance().save(new Manager(0L, "reza", "rezai", "manager@gmail.com", "123456", "11"));
            HotelService.getInstance().save(new Hotel(0L, manager, 3000D, HotelStatus.OPEN));
        }
        new Login();
    }
}
