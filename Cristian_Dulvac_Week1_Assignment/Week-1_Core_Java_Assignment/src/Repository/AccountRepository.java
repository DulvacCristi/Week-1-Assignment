package Repository;

import ModelApp.Account;

public interface AccountRepository {
    void createAccount(Account account);
    void updateEmailOnTheBasisOfAccountNumber(int accountNumer, String email);
    void displayAccountBasedOnMaximumSumAssuredAmount();
    void countAccountsWherePremiumDateIsOver();
    void storeAccountEmailInASetWherePolicyIsNull();
}
