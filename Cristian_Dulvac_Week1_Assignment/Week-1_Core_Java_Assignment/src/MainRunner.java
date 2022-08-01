import ModelApp.Account;
import ModelApp.ContactDetails;
import ModelApp.Policy;
import Service.AccountService;
import Service.PolicyService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainRunner {

	/*
	 *   Requirement (to be done by stream API only )
	 *   1. Update email on the basis of accountNumber
	 *   2. display Account based on maximum sumAssuredAmount
	 *   3. update premium amount of all medical policies by 10%
	 *   4. filter accounts based on following
	 *      4.a) state and policyname
	 *      4.b) state and premiumAmount (higher than certain amount) and total balance
	 *   5. count accounts where premium date is over
	          Note :- use setter method to Set premium date
			     LocalDate.of()  // is used to create date
				 LocalDate.now() // is used to get current date
	 *   6. Store account's email in a Set<String> where policy is null
	 *
	 *   Note:- Add couple of more records based on requirement
	 * */

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        PolicyService policyService = new PolicyService();
        List<Policy> policyList = new ArrayList<>();
        List<Account> accountsList = new ArrayList<>();

        Policy p1 = new Policy(new Random().nextInt(6000), "Medical Policy-1", 2000, 1000000, "Valid", LocalDate.of(2024, 8, 01));
        Policy p2 = new Policy(new Random().nextInt(6000), "Medical Policy-1", 2000, 1500000, "Valid", LocalDate.of(2021, 8, 01));
        Policy p3 = new Policy(new Random().nextInt(6000), "Car Policy-1", 2000, 1500000, "Valid", LocalDate.of(2021, 7, 01));
        Policy p4 = new Policy(new Random().nextInt(6000), "Medical Policy-2", 2500, 1800000, "Expired", LocalDate.of(2021, 6, 01));
        Policy p5 = new Policy(new Random().nextInt(6000), "Term Policy-1", 2000, 15000000, "Expired",LocalDate.of(2022, 9, 01));

        policyService.createPolicy(p1);
        policyService.createPolicy(p2);
        policyService.createPolicy(p3);
        policyService.createPolicy(p4);
        policyService.createPolicy(p5);

        policyList.add(p1);
        policyList.add(p2);
        policyList.add(p3);
        policyList.add(p4);
        policyList.add(p5);

        ContactDetails c1 = new ContactDetails("123-New Delhi", "Delhi", 1212122, "abc@gmail.com");
        ContactDetails c2 = new ContactDetails("454-New Delhi", "Delhi", 45412122, "xyz@gmail.com");
        ContactDetails c3 = new ContactDetails("A1-Gurgoan", "Delhi-NCR", 45412122, "a@gmail.com");
        ContactDetails c4 = new ContactDetails("A2-Gurgoan", "Delhi-NCR", 45412122, "b@gmail.com");


        Account a1 = addAccount(1,"Ramesh", Arrays.asList(p1, p2, p3), 5000, c1);
        Account a2 = addAccount(2,"Mike", Arrays.asList(p1, p4), 15000, c2);
        Account a3 = addAccount(3,"Kirti", Arrays.asList(p1), 25000, c3);
        Account a4 = addAccount(4,"Ajay", Arrays.asList(p1, p4), 17000, c4);

        accountService.createAccount(a1);
        accountService.createAccount(a2);
        accountService.createAccount(a3);
        accountService.createAccount(a4);

        accountsList.add(a1);
        accountsList.add(a2);
        accountsList.add(a3);
        accountsList.add(a4);

        // 1. Update email on the basis of accountNumber
        accountService.updateEmailOnTheBasisOfAccountNumber(1, "abc@gmail.com");
        System.out.println("-----------Next Requirement -----------");

        // 2. display Account based on maximum sumAssuredAmount
        accountService.displayAccountBasedOnMaximumSumAssuredAmount();
        System.out.println("-----------Next Requirement -----------");

        // 3. update premium amount of all medical policies by 10%
        policyService.updatePremiumAmountOfAllMedicalPoliciesBy10Percent();
        System.out.println("-----------Next Requirement -----------");

        // 4. filter accounts based on following
        // 4.a) state and policy name
        policyService.filterAccountsBasedOnStateAndPolicyName("Valid", "Car Policy-1" );
        System.out.println("-----------Next Requirement -----------");

        // 4.b) state and premiumAmount (higher than certain amount) and total balance
        policyService.filterAccountsBasedOnStateAndPremiumAmountAndTotalBalance(2200, 1000000);
        System.out.println("-----------Next Requirement -----------");

        // 5. count accounts where premium date is over
        accountService.countAccountsWherePremiumDateIsOver();
        System.out.println("-----------Next Requirement -----------");

        // 6. Store account's email in a Set<String> where policy is null
        accountService.storeAccountEmailInASetWherePolicyIsNull();
        System.out.println("-----------Next Requirement -----------");
    }

    public static Account addAccount (int id, String name, List< Policy > policyList, int balance, ContactDetails contactDetails)
        {
            Account a = new Account(id, name, balance, policyList, contactDetails);
            return a;
        }
}
