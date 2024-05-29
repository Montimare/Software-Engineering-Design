import java.util.List;

public class User {
    private String name;
    private NotificationPreference notificationPreference;

    public User(String userName, List<String> notification) {
        this.name = userName;
        this.notificationPreference = new NotificationPreference();
        this.notificationPreference.addNotification(notification);
    }
    public String getUserName() {
        return name;
    }
    public NotificationPreference getNotificationPreference() {
        return notificationPreference;
    }

    @Override
    public String toString() {
        return (name + " (" + notificationPreference.toString() + ")");
    }
}
