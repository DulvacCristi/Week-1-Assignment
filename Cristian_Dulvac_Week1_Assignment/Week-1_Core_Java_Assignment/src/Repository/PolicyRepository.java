package Repository;

import ModelApp.Policy;

public interface PolicyRepository {
    void createPolicy(Policy policy);
    void filterAccountsBasedOnStateAndPolicyName(String state, String name);
    void filterAccountsBasedOnStateAndPremiumAmountAndTotalBalance(int amount, int totalBalance);
    void updatePremiumAmountOfAllMedicalPoliciesBy10Percent();
}
