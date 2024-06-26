import WebsiteComparison.ContentSizeWebsiteComparison;
import WebsiteComparison.ContextWebsiteComparison;
import WebsiteComparison.TextContentWebsiteComparison;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class Website extends Subject{
    private String websiteAdress;
    private String fetchedContent = "";
    ContextWebsiteComparison contextWebsiteComparison = new ContextWebsiteComparison();

    public Website(String url) {
        this.websiteAdress = url;
    }

    public void fetchWebsite() {
        try {
            StringBuilder result = new StringBuilder();
            URI uri = new URI(websiteAdress);
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
//            deprecated because of strategy pattern of comparison
//            if (!result.toString().equals(fetchedContent)){
//                notifyObservers();
//                setFetchedContent(result.toString());
//            }
//            contextWebsiteComparison.setWebsiteComparison(new ContentSizeWebsiteComparison());
            contextWebsiteComparison.setWebsiteComparison(new TextContentWebsiteComparison());
            if (!contextWebsiteComparison.performCompare(result.toString(), fetchedContent)){
                notifyObservers();
                setFetchedContent(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return fetchedContent;
    }
    public String getWebsiteAddress() {
        return websiteAdress;
    }
    public void setWebsiteAdress(String websiteAdress) {
        this.websiteAdress = websiteAdress;
    }
    public void setFetchedContent(String fetchedContent) {
        this.fetchedContent = fetchedContent;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(websiteAdress);
//        sb.append("\n");
//        sb.append("Users:\n");
//        for(User user : users){
//            sb.append(user.toString() + ", ");
//        }
        return(websiteAdress);
    }
}
