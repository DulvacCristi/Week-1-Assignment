package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import p2.BankAccount;

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
		
	
		
		Policy p1 = new Policy(new Random().nextInt(6000),"Medical Policy-1",2000,1500000);
		Policy p2 = new Policy(new Random().nextInt(6000),"Car Policy-1",2000,1500000);
		Policy p3 = new Policy(new Random().nextInt(6000),"Medical Policy-2",2500,1800000);
		Policy p4 = new Policy(new Random().nextInt(6000),"Term Policy-1",2000,15000000);
		
		ContactDetails c1 = new ContactDetails("123-New Delhi","Delhi",1212122,"abc@gmail.com");
		ContactDetails c2 = new ContactDetails("454-New Delhi","Delhi",45412122,"xyz@gmail.com");
		ContactDetails c3 = new ContactDetails("A1-Gurgoan","Delhi-NCR",45412122,"a@gmail.com");
		ContactDetails c4 = new ContactDetails("A2-Gurgoan","Delhi-NCR",45412122,"b@gmail.com");
		
		
		Account a1 = addAccount("Ramesh", Arrays.asList(p1,p2,p3), 5000, c1);
		Account a2 = addAccount("Mike", Arrays.asList(p1,p4), 15000, c2);
		Account a3 = addAccount("Kirti", Arrays.asList(p1), 25000, c3);
		Account a4 = addAccount("Ajay", Arrays.asList(p1,p4), 17000, c4);
		
		MainRunner assignmentApp = new MainRunner();
		while(true)
		{
			System.out.println("\n 1. Update email on the basis of accountNumber");
			System.out.println("\n 2. Display Account based on maximum sumAssuredAmount");
			System.out.println("\n 3. Update premium amount of all medical policies by 10%");
			System.out.println("\n 4a. Filter accounts based on state and policyname");
			System.out.println("\n 4b. Filter accounts based on state and premiumAmount and total balance");
			System.out.println("\n 5. Count accounts where premium date is over");
			System.out.println("\n 6. Store account's email in a Set<String> where policy is null");
			System.out.println("\n 0. EXIT");
			
			System.out.println("\n Enter Requirement Option :- ");
			switch (new Scanner(System.in).nextInt()) 
			{
			
			case 1:
				assignmentApp.updateEmailOnTheBasisOfAccountNumber();
				break;
				
			case 2:
				assignmentApp.displayAccountBasedOnMaximumSumAssuredAmount();
				break;
				
			case 3:
				assignmentApp.updatePremiumAmountOfAllMedicalPoliciesBy10Percent();
				break;
				
			case 4:
				assignmentApp.filterAccountsBasedOnStateAndPolicyName();
				break;
		/*		
			case 5:
				assignmentApp.filterAccountsBasedOnStateAndPremiumAmountAndTotalBalance();
				break;
				
			case 6:
				assignmentApp.countAccountsWhttps://github.com/alexsorindrago/assigmnents/tree/master/src/main/java/com/alexd/week_1_assignment/modelherePremiumDateIsOver();
				break;
			
			case 7:
				assignmentApp.storeAccountEmailInASetWherePolicyIsNull();
				break;
			*/
			default:
				break;
			}//end swicth
			
		}//end of while
	}//end main
	
		
		public static Account addAccount(String name,List<Policy> policyList,int balance,ContactDetails contactDetails)
		{
			
			Account a = new Account();
			a.setAccountHolderName(name);
			a.setBalance(balance);
			a.setPolicies(policyList);
			a.setContactDetails(contactDetails);
			 
			return a;
			
		} 
		
		//1. Update email on the basis of accountNumber
		public void updateEmailOnTheBasisOfAccountNumber(Account... account)
		{
			List <Account> allAccounts = Arrays.asList(account);
			allAccounts.stream()
			.filter((a)->(a.getaccountNumber().equals())?true:false)
			.map((a)->{
				String email = a.getEmail();
				a.setEmail(String);
			.collect(Collectors.toList())
				return a;
			)}
		}
		
		//2. display Account based on maximum sumAssuredAmount
		public void displayAccountBasedOnMaximumSumAssuredAmount(Account... account) 
		{
			List <Account> allAccounts = Arrays.asList(account);
			Integer expectedMaximumSumAssuredAmount = 15000000;
			List<String> newStringList = Stream
					.concat(contactDetailsList.stream(), policyList.stream())
	                .collect(Collectors.toList());
			Integer maximumSumAssuredAmount = newJoinedList
			.stream()
			.max(Comparator.comparing(Policy::getPolicy))
			System.out.println("Maximum insured amount : " + maximumSumAssuredAmount + " for emp id : " +  && max.getId());
			
			
			
			
		}
		
		//3. update premium amount of all medical policies by 10%
		public void updatePremiumAmountOfAllMedicalPoliciesBy10Percent()
		{
			List <Policy> policyList = Arrays.asList(p1,p2,p3,p4);
			policyList.stream()
		     .map((p)->{
		    	 int currentPremiumAmount = p.getPremiumAmount();
		    	 p.setPremiumAmount((int)(currentPremiumAmount*1.10));
		    	 return p;
		     })
		}
		
	     
	     //4. filter accounts based on following
		 //      4.a) state and policyname
		public void filterAccountsBasedOnStateAndPolicyName() {
			List <ContactDetails> contactDetailsList = Arrays.asList(c1,c2,c3,c4);
			 List <Policy> policyList = Arrays.asList(p1,p2,p3,p4);
			 List<String> newJoinedList = Stream
						.concat(contactDetailsList.stream(), policyList.stream())
		                .collect(Collectors.toList());
			 List<Integer> accountsFilteredOnStateAndPolicyName = newJoinedList.stream()
			 .filter((n)->(n.getState()) && (n) ->(n.getPolicyName))
			 .map((n)->{
				 Int accountId = (.filter(n).getAccount());
			 })
			 .collect(Collectors.toSet())
			 stringSet.forEach((n)->System.out.println(n));
			 
		}
	     
		 
	     
		 //      4.b) state and premiumAmount (higher than certain amount) and total balance
		public void filterAccountsBasedOnStateAndPremiumAmountAndTotalBalance() {
			List <ContactDetails> contactDetailsList = Arrays.asList(c1,c2,c3,c4);
			 List <Policy> policyList = Arrays.asList(p1,p2,p3,p4);
			 List<String> newJoinedList = Stream
						.concat(contactDetailsList.stream(), policyList.stream())
		                .collect(Collectors.toList());
			 List<Integer> accountsFilteredOnStateAndPremiumAmountAndTotalBalance = newJoinedList.stream()
					 .filter((n)->(n.getState()) && (n) ->(n.getPolicyName) && (n) ->(n.getTotalBAlance))
					 .map((n)->{
						 String currentEmailAddress = (.filter(n).getEmail());
					 })
					 .collect(Collectors.toSet())
					 stringSet.forEach((n)->System.out.println(n));
		}
		
		 //5. count accounts where premium date is over
         //Note :- use setter method to Set premium date 
		     //LocalDate.of()  // is used to create date 
			 //LocalDate.now() // is used to get current date
		public void countAccountsWherePremiumDateIsOver() {
			List <ContactDetails> contactDetailsList = Arrays.asList(c1,c2,c3,c4);
			 List <Policy> policyList = Arrays.asList(p1,p2,p3,p4);
			 List<String> newJoinedList = Stream
						.concat(contactDetailsList.stream(), policyList.stream())
		                .collect(Collectors.toList());
			
		}
		 
		 //6. Store account's email in a Set<String> where policy is null
		public void storeAccountEmailInASetWherePolicyIsNull() {
			List <ContactDetails> contactDetailsList = Arrays.asList(c1,c2,c3,c4);
			 List <Policy> policyList = Arrays.asList(p1,p2,p3,p4);
			 List<String> newJoinedList = Stream
						.concat(contactDetailsList.stream(), policyList.stream())
		                .collect(Collectors.toList());
			 Set<String> stringSet =  newJoinedList.stream()
					 .filter((n)->(n.getPolicy().equals(null)))
					 .map((n)->{
						 String currentEmailAddress = (.filter(n).getEmail());
					 })
					 .collect(Collectors.toSet())
					 stringSet.forEach((n)->System.out.println(n));
			 return stringSet;
		}
		 
		
	
	
	
}//end class
