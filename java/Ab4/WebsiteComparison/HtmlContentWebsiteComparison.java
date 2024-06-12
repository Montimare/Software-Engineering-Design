package WebsiteComparison;

public class HtmlContentWebsiteComparison implements IWebsiteComparison{
    @Override
    public boolean compare(String old, String current) {
        /**
         * @returns true if equivalent
         */
        return old.equals(current);
    }
}
