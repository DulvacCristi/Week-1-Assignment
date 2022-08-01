package ModelApp;

import java.time.LocalDate;

public class Policy {
    int policyNumber;
    String policyName;
    int premiumAmount;
    int sumAssuredAmount;
    LocalDate premiumDate;
    String state;


    public Policy(int policyNumber, String policyName, int premiumAmount, int sumAssuredAmount, String state, LocalDate premiumDate) {
        super();
        this.policyNumber = policyNumber;
        this.policyName = policyName;
        this.premiumAmount = premiumAmount;
        this.sumAssuredAmount = sumAssuredAmount;
        this.state = state;
        this.premiumDate = premiumDate;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public int getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(int premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public int getSumAssuredAmount() {
        return sumAssuredAmount;
    }

    public void setSumAssuredAmount(int sumAssuredAmount) {
        this.sumAssuredAmount = sumAssuredAmount;
    }

    public LocalDate getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(LocalDate premiumDate) {
        this.premiumDate = premiumDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber=" + policyNumber +
                ", policyName='" + policyName + '\'' +
                ", premiumAmount=" + premiumAmount +
                ", sumAssuredAmount=" + sumAssuredAmount +
                ", premiumDate=" + premiumDate +
                '}';
    }
}
