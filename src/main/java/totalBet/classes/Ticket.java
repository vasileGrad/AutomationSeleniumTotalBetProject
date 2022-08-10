package totalBet.classes;

import java.util.List;

public class Ticket {
    private String code;
    private String date;
    private double maxWin;
    private int combinations;
    private double betSum;
    private int betTaxValue;
    private double betTaxSum;
    private double totalBetValue;
    private String status;
    private List<Event> events;

    public Ticket(String code, String date, double maxWin, int combinations, double betSum, int betTaxValue, double betTaxSum, double totalBetValue, String status, List<Event> events) {
        this.code = code;
        this.date = date;
        this.maxWin = maxWin;
        this.combinations = combinations;
        this.betSum = betSum;
        this.betTaxValue = betTaxValue;
        this.betTaxSum = betTaxSum;
        this.totalBetValue = totalBetValue;
        this.status = status;
        this.events = events;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMaxWin() {
        return maxWin;
    }

    public double getBetSum() {
        return betSum;
    }

    public String getStatus() {
        return status;
    }

    public List<Event> getEvents() {
        return events;
    }
}
