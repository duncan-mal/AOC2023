import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
        //Make da Inputs

        String currentOut = "";
        int finalOut = 0;
        Path f = Paths.get("src/calcinputs");
        int fileLength;
        try {

            long count = Files.lines(f).count();
            fileLength = (int)count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Inputs: " + fileLength);
        //Get Puzzle input


        //Get Numbers
        for(int i = 0; i <= (fileLength-1); i++) {
            String Input1 = Files.readAllLines(f).get(i);
            char[] chars = Input1.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            int stringBuildLength = sb.length();
            if (stringBuildLength < 2) {
                currentOut = String.valueOf(sb) + String.valueOf(sb);
            }
            if (stringBuildLength >= 2) {
                currentOut = String.valueOf(sb);
            }
            if (stringBuildLength > 2) {

                currentOut = String.valueOf(String.valueOf(sb.charAt(0)) + String.valueOf(sb.charAt(stringBuildLength - 1)));
            }
            System.out.println("Input Was:");
            System.out.println(Files.readAllLines(f).get(i));
            System.out.println("Output Is:");
            System.out.println(currentOut);
            finalOut = finalOut + Integer.parseInt(currentOut);
            System.out.println("Current Value:");
            System.out.println(finalOut);
            System.out.println("------------");
        }
    }
}
