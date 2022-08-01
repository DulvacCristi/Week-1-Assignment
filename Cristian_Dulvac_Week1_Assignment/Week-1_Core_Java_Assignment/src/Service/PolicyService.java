package Service;

import ModelApp.Account;
import ModelApp.Policy;
import Repository.PolicyRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PolicyService implements PolicyRepository {
    private final List<Policy> allPolicies;

    public PolicyService() {
        this.allPolicies = new ArrayList<>();
    }

    @Override
    public void createPolicy(Policy policy) {
        try {
            allPolicies.add(policy);
            System.out.println("Policy " + policy + " was created successfully!");
        } catch (NullPointerException e){
            e.printStackTrace();}
    }

    @Override
    public void filterAccountsBasedOnStateAndPolicyName(String state, String name) {
        for (Policy policy : allPolicies) {
            if (policy != null){
            if (policy.getPremiumDate().isBefore(LocalDate.now())) {
                policy.setState("Valid");
            } else {
                policy.setState("Expired");
            }}
        }
        Policy filteredAccounts = allPolicies.stream()
                .filter(policy -> policy != null)
                .filter(policy -> policy.getState().equals(state) && policy.getPolicyName().equals(name))
                .findFirst().get();

        System.out.println("Policy: " + name + filteredAccounts);
    }

    @Override
    public void filterAccountsBasedOnStateAndPremiumAmountAndTotalBalance(int amount, int totalBalance) {
        for (Policy policy : allPolicies) {
            if (policy.getPremiumDate().isBefore(LocalDate.now())) {
                policy.setState("Expired");
            } else {
                policy.setState("Valid");
            }
        }
        Policy filteredAccounts = allPolicies.stream()
                .filter(policy -> policy != null)
                .filter(policy -> policy.getState().equals("Valid")
                        && policy.getPremiumAmount() == amount
                        && policy.getSumAssuredAmount() == totalBalance)
                .findFirst().get();
        System.out.println("Results after criteria: " + filteredAccounts);
    }

    @Override
    public void updatePremiumAmountOfAllMedicalPoliciesBy10Percent() {
        for (Policy policy : allPolicies) {
            policy.setPremiumAmount((int) (policy.getPremiumAmount() * 1.10));
            System.out.println("Premium amount set to: " + policy.getPremiumAmount());
        }
    }
}
