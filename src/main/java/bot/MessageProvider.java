package bot;

import controllers.SprachCafeController;
import dto.RequestParameters;
import dto.SprachCafe;

import java.util.List;

public class MessageProvider {

    public static String getSprachCafeMessage(RequestParameters rp) {
        StringBuilder sb = new StringBuilder();
        List<SprachCafe> list = SprachCafeController.getSprachcafes(rp.getWeekDay(), rp.getDistrict(), rp.getDayTime());
        sb.append("Sprachcafes: \n");
        for (int i = 0; i < list.size(); i++) {
            SprachCafe sc = list.get(i);
            sb.append("1. ").append(sc.getName()).append("\n");

        }
        return sb.toString();
    }
}
