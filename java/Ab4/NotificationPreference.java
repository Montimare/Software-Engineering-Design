import java.util.List;

public class NotificationPreference {
    private Boolean mail;
    private Boolean sms;
    private Boolean whatsApp;
    private Boolean telegram;
    private Boolean discord;

    public NotificationPreference(){
        this.mail = false;
        this.sms = false;
        this.whatsApp = false;
        this.telegram = false;
        this.discord = false;
    }

    public void addNotification(List<String> notification) {
        for (String s : notification) {
            parseNotification(s);
        }
    }

    private void parseNotification(String notification) {
        switch (notification) {
            case "mail":
                mail = true;
                break;
            case "sms":
                sms = true;
                break;
            case "whatsApp":
                whatsApp = true;
                break;
            case "telegram":
                telegram = true;
                break;
            case "discord":
                discord = true;
                break;
        }
    }

    public Boolean getMail() {
        return mail;
    }

    public Boolean getSms() {
        return sms;
    }

    public Boolean getWhatsApp() {
        return whatsApp;
    }

    public Boolean getTelegram() {
        return telegram;
    }

    public Boolean getDiscord() {
        return discord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (mail) {
            sb.append("mail, ");
        }
        if (sms) {
            sb.append("sms, ");
        }
        if (whatsApp) {
            sb.append("whatsApp, ");
        }
        if (telegram) {
            sb.append("telegram, ");
        }
        if (discord) {
            sb.append("discord");
        }
        return sb.toString();
    }
}