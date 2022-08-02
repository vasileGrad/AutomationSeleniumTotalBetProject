package totalBet.data;

import java.util.HashMap;

public class TestData {

    public static HashMap<String, String> registrationFormTestData() {
        HashMap<String, String> registrationFormData = new HashMap<>();
        registrationFormData.put("fullName", "Ana Adi12");
        registrationFormData.put("email", "ana.adi12@gmail.com");
        registrationFormData.put("password", "Text1234");
        return registrationFormData;
    }

    public static HashMap<String, String> loginFormTestData() {
        HashMap<String, String> loginFormData = new HashMap<>();
        loginFormData.put("email", "dacekib883@altpano.com");
        loginFormData.put("password", "Text1234");
        return loginFormData;
    }

    public static HashMap<String, String> accountSettingsFormTestData() {
        HashMap<String, String> accountSettingsFormData = new HashMap<>();
        accountSettingsFormData.put("fullName", "Dace Altpano");
        accountSettingsFormData.put("email", "dacekib883@altpano.com");
        accountSettingsFormData.put("phone", "0743123456");
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
}
