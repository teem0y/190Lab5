import java.util.Scanner;
import java.io.*;
/**
 * Program Description
 * Reads lines of scores from an input file and writes a grade report for
 * each line to an output file.
 * 1) Get the input file name from the user with getInFile(), re-prompting
 *    until the file exists
 * 2) Get the output file name from the user with getOutFile()
 * 3) Call processFile() to read each line of scores until the -1 sentinel
 * 4) For each line, write the number of As, Bs, Cs, Ds, Fs, the high score,
 *    the low score, and the average to the output file
 * 5) Display a completion message with the output file location
 * 
 * @author Tobey Agapito
 * @version v1.0
 * @since 10/04/2026
 */
public class Grades {
    public static void main (String[] args) throws IOException {
        String inFile, outFile;
        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
    }

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner
     */
    public static String getInFile() throws IOException {
        String inFileName;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the input file (ie input.txt): ");
        inFileName = keyboard.nextLine();
        File file;
        file = new File(inFileName);
        while (!file.exists()) {
            System.out.println("The input file cannot be found.");
            System.out.print("Enter the name of the input file (ie input.txt): ");
            inFileName = keyboard.nextLine();
            file = new File(inFileName);
        }
        return inFileName;
    }

    /**
     * Uses Scanner to get and return output file name
     * @return name of output file from Scanner
     */
    public static String getOutFile() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the output file (ie output.txt): ");
        return keyboard.nextLine();
    }

    /**
     * Reads each line of scores from the input file until the -1 sentinel and
     * writes the number of As, Bs, Cs, Ds, Fs, the high score, the low score,
     * and the average for each line to the output file. A line containing
     * only -1 is reported as having no grades to average.
     * @param inFileName name of the input file containing the scores
     * @param outFileName name of the output file to create for the results
     */
    public static void processFile(String inFileName, String outFileName) throws IOException {
        int number;
        int As, Bs, Cs, Ds, Fs, min, max;
        int total, count;
        double avg;
        int set = 1;

        File file = new File(inFileName);
        Scanner inStream = new Scanner(file);
        PrintWriter outStream = new PrintWriter(outFileName);

        while (inStream.hasNextLine()) {
            As = Bs = Cs = Ds = Fs = count = 0;
            avg = 0.0;
            number = inStream.nextInt();
            min = max = number;
            total = count = 0;
            while (number != -1) {
                if (number < min)
                    min = number;
                if (number > max)
                    max = number;
                count++;
                total += number;

                if (number >= 90)
                    As++;
                else if (number >= 80)
                    Bs++;
                else if (number >= 70)
                    Cs++;
                else if (number >= 60)
                    Ds++;
                else
                    Fs++;

                number = inStream.nextInt();
            }

            outStream.println("Set " + set + " of grades calculated");
            set++;
            if (count == 0)
                outStream.println("No grades to average");
            else {
                outStream.println("Number of As: " + As);
                outStream.println("Number of Bs: " + Bs);
                outStream.println("Number of Cs: " + Cs);
                outStream.println("Number of Ds: " + Ds);
                outStream.println("Number of Fs: " + Fs);
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);
                avg = (double) total / count;
                outStream.printf("The avg score is: %.1f\n", avg);
            }
        }
        System.out.println("Grade processing completed");
        System.out.println("You can retrieve the output file at, " + outFileName);
        inStream.close();
        outStream.close();
    }
}