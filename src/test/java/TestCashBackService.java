import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mirea.CashBackService;

public class TestCashBackService {

    @Test
    public void testSubscribedUnderLimit() {
        int amount = 5000;
        boolean ifRegistered = true;
        int expected = 1500;

        CashBackService cashBackService = new CashBackService();
        int actual = cashBackService.bonusCalculation(amount,ifRegistered);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testUnsubscribedUnderLimit() {
        int amount = 5000;
        boolean ifRegistered = false;
        int expected = 250;

        CashBackService cashBackService = new CashBackService();
        int actual = cashBackService.bonusCalculation(amount,ifRegistered);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testSubscribedOverLimit() {
        int amount = 5000000;
        boolean ifRegistered = true;
        int expected = 5000;

        CashBackService cashBackService = new CashBackService();
        int actual = cashBackService.bonusCalculation(amount,ifRegistered);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testUnsubscribedOverLimit() {
        int amount = 5000000;
        boolean ifRegistered = false;
        int expected = 5000;

        CashBackService cashBackService = new CashBackService();
        int actual = cashBackService.bonusCalculation(amount,ifRegistered);

        Assertions.assertEquals(expected,actual);
    }
}
