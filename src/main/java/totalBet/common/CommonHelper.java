package totalBet.common;

import totalBet.enums.Year;

public class CommonHelper {

    public CommonHelper() {
    }

    public String getMonth(int month) {
        switch (month) {
            case 1:
                return Year.IANUARIE.toString();
            case 2:
                return Year.FEBRUARIE.toString();
            case 3:
                return Year.MARTIE.toString();
            case 4:
                return Year.APRILIE.toString();
            case 5:
                return Year.MAI.toString();
            case 6:
                return Year.IUNIE.toString();
            case 7:
                return Year.IULIE.toString();
            case 8:
                return Year.AUGUST.toString();
            case 9:
                return Year.SEPTEMBRIE.toString();
            case 10:
                return Year.OCTOMBRIE.toString();
            case 11:
                return Year.NOIEMBRIE.toString();
            case 12:
                return Year.DECEMBRIE.toString();
            default:
                return null;
        }
    }
}
