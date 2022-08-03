package totalBet.data;

import totalBet.classes.Event;
import totalBet.classes.Ticket;
import totalBet.constants.Constants;
import totalBet.readers.FileDataReader;

import java.util.HashMap;
import java.util.List;

public class TestData {

    public static HashMap<String, String> registrationFormTestData() {
        HashMap<String, String> registrationFormData = new HashMap<>();
        registrationFormData.put(Constants.FULL_NAME, "Ana Adi12");
        registrationFormData.put(Constants.EMAIL, "ana.adi12@gmail.com");
        registrationFormData.put(Constants.PASSWORD, "Text1234");
        return registrationFormData;
    }

    public static HashMap<String, String> loginFormTestData() {
        HashMap<String, String> loginFormData = new HashMap<>();
        loginFormData.put(Constants.EMAIL, "dacekib883@altpano.com");
        loginFormData.put(Constants.PASSWORD, "Text1234");
        return loginFormData;
    }

    public static HashMap<String, String> accountSettingsFormTestData() {
        HashMap<String, String> accountSettingsFormData = new HashMap<>();
        accountSettingsFormData.put(Constants.FULL_NAME, "Dace Altpano");
        accountSettingsFormData.put(Constants.EMAIL, "dacekib883@altpano.com");
        accountSettingsFormData.put(Constants.PHONE, "0743123456");
        accountSettingsFormData.put(Constants.ACTUAL_PASSWORD, "Text1234");
        accountSettingsFormData.put(Constants.NEW_PASSWORD, "1234");
        return accountSettingsFormData;
    }

    public static HashMap<String, String> sportsBetTicketTestData() {
        HashMap<String, String> sportsBetTicketData = new HashMap<>();
        sportsBetTicketData.put(Constants.NUMBER_EVENTS, "3");
        sportsBetTicketData.put(Constants.TICKET_TAX, "0.05");
        return sportsBetTicketData;
    }

    public static Ticket ticketTestData() {
        List<Event> events = FileDataReader.extractEvents("src/main/java/TicketEvents.txt");
        Ticket ticket = new Ticket("SB221663IB7", "15.06 15:21", 601.32, 1, 4.76, 5, 0.24, 102.64, Constants.BILET_NECASTIGATOR, events);
        return ticket;
    }
}
