package Notification;

public interface INotification {
    // Warum das hier nicht einfach von User aufrufen? waas wäre daran falsch?
    public void notify(String messenger);
}
