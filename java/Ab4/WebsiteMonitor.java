import Notification.INotification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebsiteMonitor {
    public static void main (String[] args) {

//        List<User> users = new ArrayList<>();
        List<Website> websites = new ArrayList<>();

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

                    String checkingSomething;
                    List<INotification> notification = new ArrayList<>();
                    do {
                        System.out.println("Enter Notification\nAvailable Services: mail, sms, whatsApp, telegram, discord");
                        notification.add(scan.nextLine()); //HIER LISTE VON NOTIFICATION ERZEUGEN DAMIT USER ERZEUGT WERDEN KÖNNEN
                        System.out.println("Do you want to add another notification? (y/n)");
                        checkingSomething = scan.nextLine();
                    } while (checkingSomething.equals("y"));

                    //check for duplicates
                    boolean duplicate = false;
                    for (Website website : websites) {
                        if (website.getWebsiteAddress().equals(websiteAdress)) {
                            duplicate = true;
                            website.attach(new User(userName, notification));
                        }
                    }
                    if (!duplicate) {
                        Website site = new Website(websiteAdress);
                        site.attach(new User(userName, notification));
                        websites.add(site);
                    }
                    break;
                case "2":
                    for (Website website : websites) {
                        System.out.println("\n" + website.toString());
                    }
                    System.out.println();
                    break;
                case "3":
                    for (Website website : websites) {
                        website.fetchWebsite();
                    }
                    break;
            }
        }
    }
}
