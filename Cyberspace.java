import java.util.ArrayList;
import javafoundations.ArrayStack;

/**
 * Maintains a collection of Webpages. Main functionalist is browser history.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class Cyberspace
{
    private ArrayList<Webpage> cyberspace;
    private ArrayStack<Webpage> history;

    /**
     * Creates a new empty CyberSpace.
     */
    public Cyberspace() {
        cyberspace = new ArrayList<>();
        history = new ArrayStack<>();
    }

    /**
     * Takes a url and adds the associated Webpage to the list of webpages in cyberspace
     */
    public void addWebpage(String address){
        cyberspace.add(Webpage.readAndCreateWebpage(address));
    }

    /**
     * Takes a url and adds the associated Webpage to the history of visited webpages
     */
    public void visitWebpage(String url) {
        for (Webpage page : cyberspace) {
            if (page.getUrl().equals(url)) {
                history.push(page);
                return;
            }
        }
        System.out.println("Webpage not found in cyberspace.");
    }

    /**
     * Returns the last page in the history and removes it from history (go back one url)
     * @return the Webpage before the current one
     */
    public Webpage goBack() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        System.out.println("No history to go back to."); // if there is no history
        return null;
    }

    /**
     * Prints the list of webpages in cyberspace
     */
    public void printWebpages() {
        if (cyberspace.isEmpty()) {
            System.out.println("No history available.");
            return;
        }

        for (Webpage page : cyberspace) {
            System.out.println(page);
        }
    }

    /**
     * Prints the list of visited webpages
     */
    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
            return;
        }

        ArrayStack<Webpage> tempStack = new ArrayStack<>();
        while (!history.isEmpty()) {
            Webpage page = history.pop();
            System.out.println(page);
            tempStack.push(page);
        }

        while (!tempStack.isEmpty()) { // restore
            history.push(tempStack.pop());
        }
    }
    
    /**
     * Main method to test this class
     */
    public static void main(String[] args) {
        Cyberspace cyberspace = new Cyberspace();
        
        cyberspace.addWebpage("https://www.wellesley.edu");
        cyberspace.addWebpage("https://www.google.com/");
        System.out.println("Webpages in cyberspace: ");
        cyberspace.printWebpages();
        
        System.out.println("\nVisited Google... Visited Wellesley...");
        cyberspace.visitWebpage("https://www.google.com/");
        cyberspace.visitWebpage("https://www.wellesley.edu");
        
        System.out.println("\nHistory (new to old): ");
        cyberspace.printHistory();
        
        System.out.println("\nGo back...");
        System.out.println("(Currently visiting: " + cyberspace.goBack() + ")");
        
        System.out.println("\nHistory (new to old): ");
        cyberspace.printHistory();
    }
}
