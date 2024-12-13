import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main driver
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class CyberspaceExplorer
{
    public static void main(String[] args) {
        Cyberspace cyberspace = new Cyberspace();
        loadWebpagesFromFile(cyberspace, "urls.txt");

        Scanner scan = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter a URL, 'back', 'history', or 'q' (quit): ");
            command = scan.nextLine().trim();
            if (command.equals("q")) {
                break;
            } else if (command.equals("back")) {
                Webpage page = cyberspace.goBack();
                if (page != null) {
                    System.out.println("Current webpage: " + page);
                }
            } else if (command.equals("history")) {
                cyberspace.printHistory();
            } else {
                cyberspace.visitWebpage(command);
            }
        }
        scan.close();
    }

    private static void loadWebpagesFromFile(Cyberspace cyberspace, String filename) {
        try (Scanner scan = new Scanner(new FileReader(filename))) {
            while (scan.hasNextLine()) {
                String url = scan.nextLine().trim();
                if (!url.isEmpty()) {
                    cyberspace.addWebpage(url);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

