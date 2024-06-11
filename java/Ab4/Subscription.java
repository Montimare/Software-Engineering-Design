/*
import Notification.INotification;

import java.util.ArrayList;
import java.util.List;

public class Subscription {

    private Website website;
    private List<User> users = new ArrayList<>();


    public Subscription(String websiteAdress, String userName, List<String> notification){
        website = new Website(websiteAdress);
        checkForDuplicateUserAndAddUser(userName, notification);
    }

    private void checkForDuplicateUserAndAddUser(String name, List<String> notification) {
        boolean duplicate = false;
        for (User user : users){
            if (user.getUserName().equals(name)) {
                duplicate = true;
            }
        }
        if (!duplicate){
            users.add(new User(name, notification));
        }
    }

    public void addUser(String userName, List<String> notification){
        checkForDuplicateUserAndAddUser(userName, notification);
    }

    public String getWebsiteAdress() {
        return website.getWebsiteAddress();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(website.getWebsiteAddress());
        sb.append("\n");
        sb.append("Users:\n");
        for(User user : users){
            sb.append(user.toString() + ", ");
        }
        return(sb.toString());
    }

    public void notifyAllUsers(){
        INotification notificationPrinter = new NotificationPrinter();
        for (User user : users){
            if(user.getNotificationPreference().getMail()){
                notificationPrinter.notifyMail(user.getUserName());
            }
            if(user.getNotificationPreference().getSms()){
                notificationPrinter.notifySms(user.getUserName());
            }
            if(user.getNotificationPreference().getWhatsApp()){
                notificationPrinter.notifyWhatsApp(user.getUserName());
            }
            if(user.getNotificationPreference().getTelegram()){
                notificationPrinter.notifyTelegram(user.getUserName());
            }
            if(user.getNotificationPreference().getDiscord()){
                notificationPrinter.notifyDiscord(user.getUserName());
            }
        }
    }

    public boolean checkForUpdate(){
        String fetchedSite = website.fetchWebsite();
        if (website.getWebsiteAddress().equals(fetchedSite)){
            return false;
        } else {
            website.setFetchedContent(fetchedSite);
            return true;
        }
    }
}
*/