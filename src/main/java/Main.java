import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resources\\text.txt");
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String finalLine = "";
        String currentLine = fileReader.readLine();
        while ((currentLine != null) && !currentLine.isEmpty()){
            finalLine += " ";
            finalLine += currentLine;
            currentLine = fileReader.readLine();
        }
        finalLine = finalLine.trim();
        fileReader.close();

        String[] arrOfWords;
        List<String> listOfWords;
        arrOfWords = finalLine.split("\\s");
        listOfWords = Arrays.asList(arrOfWords);
        Collections.sort(listOfWords);

        Map<String, Integer> statisticsOfWords = new TreeMap<>();
        int maxOccurrence = 0;
        String wordOfMaxOccurrence = "";

        for (String s : listOfWords) {
            int occurrence = Collections.frequency(listOfWords, s);
            statisticsOfWords.put(s, occurrence);
            if (occurrence > maxOccurrence) {
                maxOccurrence = occurrence;
                wordOfMaxOccurrence = s;
            }
        }
        for (Map.Entry<String, Integer> entity : statisticsOfWords.entrySet()) {
            String key = entity.getKey();
            Integer value = entity.getValue();
            System.out.println(key + "-" + value);
        }
        System.out.printf("The biggest occurrence has a word: '%s'. It occurs %d times.", wordOfMaxOccurrence, maxOccurrence);
    }
}
