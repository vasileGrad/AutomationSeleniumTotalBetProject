package totalBet.readers;

import totalBet.classes.Event;
import totalBet.classes.Result;
import totalBet.constants.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDataReader {

    public static List<Event> extractEvents(String filePath) {
        File eventsFile = new File(filePath);
        List<Event> eventList = new ArrayList();

        try {
            FileReader fileReader = new FileReader(eventsFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] eventFields = currentLine.split(";");

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

    public static List<Result> extractResults(String filePath) {
        File eventsFile = new File(filePath);
        List<Result> resultsList = new ArrayList();

        try {
            FileReader fileReader = new FileReader(eventsFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] resultFields = currentLine.split(",");
                String date = resultFields[0];
                String sportTitle = resultFields[1];
                String code = resultFields[2];
                String name = resultFields[3];
                Map<String, String> halves = new HashMap<>();
                int resultFieldsLength = resultFields.length;
                for (int i = 5; i < resultFieldsLength; i += 2) {
                    halves.put(resultFields[i], resultFields[i + 1]);
                }
                Result result = new Result(date, sportTitle, code, name, halves);
                resultsList.add(result);
            }
            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultsList;
    }
}
