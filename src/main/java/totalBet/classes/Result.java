package totalBet.classes;

import java.util.Map;

public class Result {
    private String date;
    private String sportTitle;
    private String code;
    private String name;
    Map<String, String> halves;

    public Result(String date, String sportTitle, String code, String name, Map<String, String> halves) {
        this.date = date;
        this.sportTitle = sportTitle;
        this.code = code;
        this.name = name;
        this.halves = halves;
    }

    public String getDate() {
        return date;
    }

    public String getSportTitle() {
        return sportTitle;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getHalves() {
        return halves;
    }
}
