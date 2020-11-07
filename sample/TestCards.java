package sample;
import org.junit.Assert;
import org.junit.Test;

public class TestCards {
    @Test
    public void testcard() throws Exception{
        Cards cards = new Cards();
        String result =Cards.roles("Emperor ","Citizen ","Slave");
        Assert.assertEquals("Emperor Citizen Slave",result);

    }
}
