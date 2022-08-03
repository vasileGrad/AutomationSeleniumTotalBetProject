package totalBet.classes;

public class Event {
    private int code;
    private String name;
    private String date;
    private String details;
    private String oddLabel;
    private double oddValue;
    private String status;

    public Event(int code, String name, String date, String details, String oddLabel, double oddValue, String status) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.details = details;
        this.oddLabel = oddLabel;
        this.oddValue = oddValue;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOddLabel() {
        return oddLabel;
    }

    public void setOddLabel(String oddLabel) {
        this.oddLabel = oddLabel;
    }

    public double getOddValue() {
        return oddValue;
    }

    public void setOddValue(double oddValue) {
        this.oddValue = oddValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
