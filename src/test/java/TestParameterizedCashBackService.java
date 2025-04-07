import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import ru.mirea.CashBackService;

public class TestParameterizedCashBackService {

    @ParameterizedTest
    @CsvSource(value = {"5000,true,500","5000,false,250","5000000,true,5000","5000000,false,5000"})
    public void testSubscribedUnderLimit(int amount, boolean ifRegistered, int expected) {

        CashBackService cashBackService = new CashBackService();
        int actual = cashBackService.bonusCalculation(amount,ifRegistered);

        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Testdata.csv")
    public void testAllOptionsFileSource (int purchaseSum, boolean ifRegistered, int expected) {
        CashBackService cashBackService = new CashBackService();
        int actual = cashBackService.bonusCalculation(purchaseSum,ifRegistered);

        Assertions.assertEquals(expected,actual);
    }
}
