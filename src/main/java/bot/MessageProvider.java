package bot;

import dto.RequestParameters;

public class MessageProvider {

    public static String getSprachCafeMessage(RequestParameters rp) {
        StringBuilder sb = new StringBuilder();
        return sb.append("Your data is: ")
                .append("Weekday: ").append(rp.getWeekDay()).append(". District: ").append(rp.getDistrict()).append(". Daytime: ").append(rp.getDayTime()).toString();
    }
}
