package WebsiteComparison;

public class ContextWebsiteComparison {
    private IWebsiteComparison websiteComparison;

    public void setWebsiteComparison(IWebsiteComparison websiteComparison) {
        this.websiteComparison = websiteComparison;
    }

    public boolean performCompare(String old, String current){
        return websiteComparison.compare(old, current);
    }
}
