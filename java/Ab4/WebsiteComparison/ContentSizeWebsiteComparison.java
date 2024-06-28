package WebsiteComparison;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ContentSizeWebsiteComparison implements IWebsiteComparison{
    @Override
    public boolean compare(String old, String current) {
        /**
         * @returns true if equivalent
         */
        return old.length() == current.length();
    }

    @Test
    public void testCompare() {
        ContentSizeWebsiteComparison forTesting = new ContentSizeWebsiteComparison();           
        assertTrue(forTesting.compare("abc", "abc"));
    }

}