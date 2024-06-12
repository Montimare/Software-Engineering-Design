import Notification.*;

import java.util.*;

public class WebsiteMonitor {
    public static void main (String[] args) {

        Map<Website, List<User>> users = new HashMap<>();
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
                        switch (scan.nextLine()) {
                            case "mail":
                                notification.add(new MailNotification());
                                break;
                            case "sms":
                                notification.add(new SmsNotification());
                                break;
                            case "whatsApp":
                                notification.add(new WhatsAppNotification());
                                break;
                            case "telegram":
                                notification.add(new TelegramNotification());
                                break;
                            case "discord":
                                notification.add(new DiscordNotification());
                                break;
                        }
                        System.out.println("Do you want to add another notification? (y/n)");
                        checkingSomething = scan.nextLine();
                    } while (checkingSomething.equals("y"));

                    //check for duplicates
                    boolean duplicate = false;
                    for (Website website : websites) {
                        if (website.getWebsiteAddress().equals(websiteAdress)) {
                            //check for duplicate user
                            if (users.containsKey(website) ){
                                for (User user : users.get(website)) {
                                    if (user.getUserName().equals(userName)){
                                        duplicate = true;
                                    }
                                }
                            }
                            if (!duplicate) {
                                duplicate = true;
                                User user = new User(userName, notification);
                                website.attach(user);
                                users.get(website).add(user);
                            }
                        }
                    }
                    if (!duplicate) {
                        Website site = new Website(websiteAdress);
                        User user = new User(userName, notification);
                        site.attach(user);
                        websites.add(site);
                        List<User> listForNewWebsiteAndUser = new ArrayList<>();
                        listForNewWebsiteAndUser.add(user);
                        users.put(site, listForNewWebsiteAndUser);
                    }
                    break;
                case "2":
                    for (Website website : websites) {
                        System.out.println("\n" + website.toString() + users.get(website).toString());
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
