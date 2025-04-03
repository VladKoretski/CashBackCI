package ru.mirea;

public class CashBackService {

    float SUBSCRIBED_PERCENT = 0.1f;
    float UNSUBSCRIBED_PERCENT = 0.05f;
    final static int MAX_BONUS = 5000;

    public int bonusCalculation(int purchaseSum, boolean ifSubscribed) {
        int bonus;

        if (ifSubscribed) {
            bonus = (int) (purchaseSum * SUBSCRIBED_PERCENT);
        } else {
            bonus = (int) (purchaseSum * UNSUBSCRIBED_PERCENT);
        }

        if (bonus > MAX_BONUS) {
            bonus = MAX_BONUS;
        }
        return bonus;
    }
}