package gymmanagement;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.InputMismatchException;

public class GymManagement {
    final private Scanner reader = new Scanner(System.in);

    // this method is used to read an integer from user
    private int getIntInput() {
        int input = 0;
        while(input == 0)
        {
            try
            {
                input = reader.nextInt();
                if(input == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println("\nERROR: INVALID INPUT. Try again: ");
            }
        }
        return input;
    }

    // this method is used to print the membership options for our gym network
    private void printGymOptions() {
        System.out.println("\n1. Gym Unirii");
        System.out.println("2. Gym Victoriei");
        System.out.println("3. Gym Dristor");
        System.out.println("4. Gym Brasov");
        System.out.println("5. Gym Mamaia");
        System.out.println("6. All Gyms");
    }

    // this method is used as a "menu" to get the choice of the user
    public int getChoice() {
        int choice;
        System.out.println("\nWELCOME TO FITNESS GYM NETWORK");
        System.out.println("==============================");
        System.out.println("1. Add Member");
        System.out.println("2. Remove Member");
        System.out.println("3. Display Member Info");
        System.out.println("-1. Exit\n");

        System.out.print("Please select an option: ");
        choice = getIntInput();
        return choice;
    }

    // this method takes a LinkedList of Member objects and adds a new member to it
    // after the member is added the method returns a string with information about the new member
    public String addMembers(LinkedList<Member> m) {
        Member newMember; // object for new member
        String newMemberName;
        int newMemberGym;
        double newMembershipPrice;
        int newMemberID;
        String newMemberInfo;
        Calculator<Integer> calculator;

        // name
        System.out.println("\nMember Name: ");
        newMemberName = reader.nextLine();

        // gym choice
        printGymOptions();
        System.out.println("\nGym ID: ");
        newMemberGym = getIntInput();
        while(newMemberGym < 1 || newMemberGym > 6)
        {
            System.out.print("\nInvalid Gym ID. Try again: ");
            newMemberGym = getIntInput();
        }

        // ID
        if(m.size() > 0)
            newMemberID = m.getLast().getMemberID() + 1;
        else
            newMemberID = 1;

        // membership prices
        if (newMemberGym != 6)
        {
            calculator = (n) -> {
                switch (n)
                {
                    case 1:
                        return 220;
                    case 2:
                        return 240;
                    case 3:
                        return 200;
                    case 4:
                        return 180;
                    case 5:
                        return 200;
                    default:
                        return -1;
                }
            };

            newMembershipPrice = calculator.calculatePrice(newMemberGym);

            newMember = new SingleGymMember('S', newMemberID, newMemberName, newMembershipPrice, newMemberGym);
            m.add(newMember);
            newMemberInfo = newMember.toString();

            System.out.println("\nSucces: Single Gym Member added.\n");
        }
        else
        {
            calculator = (n) -> {
                if (n == 6)
                    return 350;
                else
                    return -1;
            };

            newMembershipPrice = calculator.calculatePrice(newMemberGym);
            newMember = new MultiGymMember('M', newMemberID, newMemberName, newMembershipPrice, 100);
            m.add(newMember);
            newMemberInfo = newMember.toString();

            System.out.println("\nSucces: Multi Gym Member added.\n");
        }
        return newMemberInfo;
    }

    // this method removes a member from the LinkedList
    public void removeMember(LinkedList<Member> m) {
        int memberID;

        System.out.println("\n Enter the ID of the member you want to remove: ");
        memberID = getIntInput();

        for(int i = 0; i < m.size(); i++)
        {
            if(m.get(i).getMemberID() == memberID)
            {
                m.remove(i);
                System.out.println("\nSucces: Member removed.\n");
                return;
            }
        }
        System.out.println("\nError: Member not found.\n");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberID;

        System.out.println("\nEnter the ID of the member to display Info:\n");
        memberID = getIntInput();

        for(int i = 0; i < m.size(); i++)
        {
            if(m.get(i).getMemberID() == memberID)
            {
                String[] memberInfo = m.get(i).toString().split(", ");
                System.out.println("\nMember Type = " + memberInfo[0]);
                System.out.print("; Member ID = " + memberInfo[1]);
                System.out.print("; Membership price = " + memberInfo[3]);

                if(memberInfo[0].equals("S"))
                    System.out.print("; Gym ID = " + memberInfo[4]);
                else
                    System.out.print("; Membership Credits = " + memberInfo[4]);

                return;
            }
        }
        System.out.println("\nError: Member ID not found.\n");
    }
}
