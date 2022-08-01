package Service;

import ModelApp.Account;
import ModelApp.Policy;
import Repository.AccountRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AccountService implements AccountRepository {
    private final List<Account> allAccounts;

    public AccountService() {
        this.allAccounts = new ArrayList<>();
    }

    @Override
    public void createAccount(Account account) {
        try {
            allAccounts.add(account);
            System.out.println("Account " + account + " was created successfully!");
        }catch (NullPointerException e){
            e.printStackTrace();}
    }

    @Override
    public void updateEmailOnTheBasisOfAccountNumber(int accountNumber, String email) {
        try {
            Account accountToUpdate = allAccounts.stream()
                    .filter(account -> account.getAccountNumber() == accountNumber).findAny().orElse(null);
            assert accountToUpdate != null;
            accountToUpdate.getContactDetails().setEmail(email);
            System.out.println(accountToUpdate.getContactDetails().getEmail());
            System.out.println("Account: " + accountNumber + " was successfully updated with Email: " + email);
        }catch (NullPointerException e ){
            System.out.println("Entered account number does not exist");
        }

    }

    @Override
    public void displayAccountBasedOnMaximumSumAssuredAmount() {
        List<Policy> listOfAllPolicies = new ArrayList<>();
        for (Account account: allAccounts){
            listOfAllPolicies.addAll(account.getPolicies());
        }
        Policy maxAssuredPolicy = listOfAllPolicies.stream()
                .max(Comparator.comparingInt(Policy::getSumAssuredAmount)).get();
        System.out.println("policy with max assured amount: " + maxAssuredPolicy);
    }

    @Override
    public void countAccountsWherePremiumDateIsOver() {
        for (Account account : allAccounts){
            List<Policy> listOfAllPolicies = account.getPolicies();
            List<Policy> premiumDateIsOver = listOfAllPolicies.stream()
                    .filter(policy -> policy.getPremiumDate().isBefore(LocalDate.now()))
                    .collect(Collectors.toList());
            System.out.println("Account(s) with expired Premium: " + account.getAccountNumber() + premiumDateIsOver.size());
        }
    }

    @Override
    public void storeAccountEmailInASetWherePolicyIsNull() {
        Set email = new HashSet<>();
        for (Account account : allAccounts) {
            email.add(account.getContactDetails().getEmail());
            System.out.println("Email " + account.getContactDetails().getEmail() + " was added to String set");
        }
        if (!email.isEmpty()) {
            System.out.println("Please enter a valid email address! " + email);
        }

    }
}
