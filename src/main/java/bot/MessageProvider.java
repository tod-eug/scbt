package bot;

import controllers.SprachCafeController;
import dto.RequestParameters;
import dto.SprachCafe;

import java.text.SimpleDateFormat;
import java.util.List;

public class MessageProvider {

    public static final String timePattern = "HH:mm:ss";

    public static String getSprachCafeMessage(RequestParameters rp) {
        SimpleDateFormat formatter = new SimpleDateFormat(timePattern);
        StringBuilder sb = new StringBuilder();
        List<SprachCafe> list = SprachCafeController.getSprachcafes(rp.getWeekDay(), rp.getDistrict(), rp.getDayTime());
        sb.append("Auf Ihre Anfrage für <b>")
                .append(rp.getWeekDay())
                .append("</b> in <b>")
                .append(rp.getDistrict())
                .append("</b> am <b>")
                .append(rp.getDayTime())
                .append("</b> sind folgende Sprachcafés verfügbar:\n").append("\n");
        for (int i = 0; i < list.size(); i++) {
            SprachCafe sc = list.get(i);
            sb.append("\uD83D\uDCDA ")
                    .append(sc.getName()).append("\n")
                    .append("\uD83D\uDCCD ")
                    .append(sc.getAddress()).append("\n")
                    .append("\uD83D\uDD50 ")
                    .append(formatter.format(sc.getStartTime()).substring(0, 5))
                    .append(" - ")
                    .append(formatter.format(sc.getEndTime()).substring(0, 5))
                    .append("\n").append("\n");

        }
        return sb.toString();
    }
}
