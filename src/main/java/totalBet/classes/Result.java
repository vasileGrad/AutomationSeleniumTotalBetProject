package totalBet.classes;

import java.util.LinkedHashMap;

public class Result {
    private String date;
    private String time;
    private String sportTitle;
    private String code;
    private String name;
    LinkedHashMap<String, String> halves = new LinkedHashMap<>();

    public Result(String date, String time, String sportTitle, String code, String name, LinkedHashMap<String, String> halves) {
        this.date = date;
        this.time = time;
        this.sportTitle = sportTitle;
        this.code = code;
        this.name = name;
        this.halves = halves;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
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

    public LinkedHashMap<String, String> getHalves() {
        return halves;
    }
}
