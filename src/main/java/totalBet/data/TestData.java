package totalBet.data;

import totalBet.classes.Event;
import totalBet.classes.Result;
import totalBet.classes.Ticket;
import totalBet.constants.Constants;
import totalBet.readers.FileDataReader;

import java.util.HashMap;
import java.util.List;

public class TestData {

    public static HashMap<String, String> registrationFormTestData() {
        HashMap<String, String> registrationFormData = new HashMap<>();
        registrationFormData.put("fullName", "Matei Cristian");
        registrationFormData.put("email", "matei@gmail.com");
        registrationFormData.put("password", "Text1234");
        return registrationFormData;
    }

    public static HashMap<String, String> loginFormTestData() {
        HashMap<String, String> loginFormData = new HashMap<>();
        loginFormData.put("email", "matei@gmail.com");
        loginFormData.put("password", "Text1234");
        return loginFormData;
    }

    public static HashMap<String, String> accountSettingsFormTestData() {
        HashMap<String, String> accountSettingsFormData = new HashMap<>();
        accountSettingsFormData.put("fullName", "Dace Altpano");
        accountSettingsFormData.put("email", "matei@gmail.com");
        accountSettingsFormData.put("phone", "0743000000");
        accountSettingsFormData.put("actualPassword", "Text1234");
        accountSettingsFormData.put("newPassword", "1234");
        return accountSettingsFormData;
    }

    public static HashMap<String, String> sportsBetTicketTestData() {
        HashMap<String, String> sportsBetTicketData = new HashMap<>();
        sportsBetTicketData.put("numberEvents", "3");
        sportsBetTicketData.put("ticketTax", "0.05");
        return sportsBetTicketData;
    }

    public static Ticket ticketTestData() {
        List<Event> events = FileDataReader.extractEvents("src/main/java/TicketEvents.txt");
        Ticket ticket = new Ticket("SB221663IB7", "15.06 15:21", 601.32, 1, 4.76, 5, 0.24, 102.64, Constants.BILET_NECASTIGATOR, events);
        return ticket;
    }

    public static List<Result> resultsTestData() {
        return FileDataReader.extractResults("src/main/java/ResultEvents.txt");
    }
}
