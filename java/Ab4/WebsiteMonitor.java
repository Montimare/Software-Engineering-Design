import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebsiteMonitor {
    public static void main (String[] args) {

        List<Subscription> subscriptions = new ArrayList<Subscription>();

        // Create a few default data
        Subscription subscriptionForTesting = new Subscription("https://www.google.com/", "hallo", new ArrayList<String>());
        subscriptions.add(subscriptionForTesting);
        subscriptionForTesting.addUser("pat", new ArrayList<String>());
        subscriptionForTesting.addUser("Tomate", new ArrayList<String>());
        subscriptions.add(new Subscription("https://www.wikipedia.org/", "pat", new ArrayList<String>()));
        subscriptions.add(new Subscription("https://www.bing.com/", "kon", new ArrayList<String>()));

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(
                            "Please choose Operation:\n" +
                            "1: Add a subscription\n" +
                            "2: List subscriptions\n" +
                            "3: Check for updates\n" +
                            "0: Quit\n"
            );
            String input = scan.nextLine();
            switch (input) {
                default:
                    System.out.println("Wrong input");
                    break;
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Enter User Name");
                    String userName = scan.nextLine();
                    System.out.println("Enter Subscription Name");
                    String websiteAdress = scan.nextLine();

                    String abfrage;
                    List<String> notification = new ArrayList<>();
                    do {
                        System.out.println("Enter Notification\nAvailable Services: mail, sms, whatsApp, telegram, discord");
                        notification.add(scan.nextLine());
                        System.out.println("Do you want to add another notification? (y/n)");
                        abfrage = scan.nextLine();
                    } while (abfrage.equals("y"));

                    //check for duplicates
                    boolean duplicate = false;
                    for (Subscription subscription : subscriptions) {
                        if (subscription.getWebsiteAdress().equals(websiteAdress)) {
                            duplicate = true;
                            subscription.addUser(userName, notification);
                        }
                    }
                    if (!duplicate) {
                        subscriptions.add(new Subscription(websiteAdress, userName, notification));
                    }
                    break;
                case "2":
                    for (Subscription sub : subscriptions) {
                        System.out.println("\n" + sub.toString());
                    }
                    System.out.println();
                    break;
                case "3":
                    for (Subscription sub : subscriptions) {

                        sub.notifyAllUsers();
                    }
                    break;
                case "4":
                    for (Subscription sub : subscriptions) {
                        if(sub.checkForUpdate()){
                            sub.notifyAllUsers();
                        }
                    }
                    break;
            }
        }
    }
}
