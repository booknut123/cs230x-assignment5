import java.net.URL;
import java.util.Scanner;
import java.net.HttpURLConnection;

/**
 * Webpage with url and HTML code.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class Webpage {
    private String url;
    private String code;

    /**
     * Constructs empty Webpage.
     */
    public Webpage (String url) {
        this.url = url;
        this.code = "";
    }

    /**
     * Constructs user-specified webpage.
     * 
     * @param url the url to the webpage
     * @param code the HTML code of the webpage
     */
    public Webpage (String url, String code) {
        this.url = url;
        this.code = code;
    }

    /**
     * @return the url of the webpage
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return a new webpage from the given url
     */
    public static Webpage readAndCreateWebpage(String addr) {
        String content = ""; // pretty memory heavy because Strings are immutable - can use StringBuilder?
        try {
            HttpURLConnection connection = (HttpURLConnection)new URL(addr).openConnection();
            connection.setRequestMethod("GET");

            try (Scanner scan = new Scanner(connection.getInputStream())) {
                while (scan.hasNextLine()) {
                    content += scan.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Webpage(addr, content);
    }

    /**
     * This method extracts the title of a webpage from its HTML code.
     * @return the title of webpage if it has one
     */
    public String getTitle(){
        int startTitle = code.indexOf("<title>");
        int endTitle = code.indexOf("</title>");

        if (startTitle > 0 && endTitle < code.length()) {
            return code.substring(startTitle + 7, endTitle);
        } else {
            return "untitled";
        }
    }

    @Override
    public String toString() {
        return "URL: " + url + ", Title: " + this.getTitle();
    }

    /**
     * Main method to test this class
     */
    public static void main(String[] args) {
        Webpage page1 = readAndCreateWebpage("https://www.wellesley.edu");
        System.out.println(page1);

        Webpage page2 = readAndCreateWebpage("https://www.google.com/");
        System.out.println(page2);

        Webpage page3 = readAndCreateWebpage("https://www.wholefoodsmarket.com");
        System.out.println(page3);

        Webpage page4 = readAndCreateWebpage("https://www.massport.com/logan-airport");
        System.out.println(page4);

        Webpage page5= readAndCreateWebpage("https://www.gap.com");
        System.out.println(page5);
    }
}
