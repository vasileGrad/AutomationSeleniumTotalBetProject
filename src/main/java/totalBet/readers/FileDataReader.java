package totalBet.readers;

import totalBet.classes.Event;
import totalBet.constants.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {

    public static List<Event> extractEvents(String filePath) {
        File eventsFile = new File(filePath);
        List<Event> eventList = new ArrayList();

        try {
            FileReader fileReader = new FileReader(eventsFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] eventFields = currentLine.split(Constants.SEMICOLON);

                int code = Integer.parseInt(eventFields[0].trim());
                String name = eventFields[1].trim();
                String date = eventFields[2].trim();
                String details = eventFields[3].trim();
                String oddLabel = eventFields[4].trim();
                double oddValue = Double.valueOf(eventFields[5].trim());
                String status = Boolean.valueOf(eventFields[6]) ? Constants.PARIU_CASTIGATOR : Constants.PARIU_NECASTIGATOR;

                Event event = new Event(code, name, date, details, oddLabel, oddValue, status);
                eventList.add(event);
            }
            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return eventList;
    }
}
