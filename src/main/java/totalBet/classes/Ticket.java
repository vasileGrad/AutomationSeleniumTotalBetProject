package totalBet.classes;

import java.util.List;

public class Ticket {
    private String code;
    private String date;
    private double maxWin;
    private int combinations;
    private double betSum;
    private double betTaxValue;
    private double betTaxSum;
    private double totalBetValue;
    private String status;
    private List<Event> events;

    public Ticket(String code, String date, double maxWin, int combinations, double betSum, double betTaxValue, double betTaxSum, double totalBetValue, String status, List<Event> events) {
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

    public void setMaxWin(double maxWin) {
        this.maxWin = maxWin;
    }

    public int getCombinations() {
        return combinations;
    }

    public void setCombinations(int combinations) {
        this.combinations = combinations;
    }

    public double getBetSum() {
        return betSum;
    }

    public void setBetSum(double betSum) {
        this.betSum = betSum;
    }

    public double getBetTaxValue() {
        return betTaxValue;
    }

    public void setBetTaxValue(double betTaxValue) {
        this.betTaxValue = betTaxValue;
    }

    public double getBetTaxSum() {
        return betTaxSum;
    }

    public void setBetTaxSum(double betTaxSum) {
        this.betTaxSum = betTaxSum;
    }

    public double getTotalBetValue() {
        return totalBetValue;
    }

    public void setTotalBetValue(double totalBetValue) {
        this.totalBetValue = totalBetValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
