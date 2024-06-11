import Notification.INotification;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private String name;
    private List<INotification> notificationPreference = new ArrayList<>();


    public User(String userName, List<INotification> notification) {
        this.name = userName;
        this.notificationPreference = notification;
    }

    @Override
    public void update() {
        for (INotification notification : notificationPreference) {
            notification.notify(name);
        }
    }

    public String getUserName() {
        return name;
    }
    public List<INotification> getNotificationPreference() {
        return notificationPreference;
    }

    @Override
    public String toString() {
        return (name + " (" + notificationPreference.toString() + ")");
    }
}
