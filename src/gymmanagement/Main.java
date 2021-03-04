package gymmanagement;

import java.io.File;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String info;

        GymManagement gm = new GymManagement();
        FileHandler fh = new FileHandler();

        LinkedList<Member> members = fh.readFile();
        int choice = gm.getChoice();

        while(choice != -1)
        {
            switch (choice)
            {
                case 1:
                    info = gm.addMembers(members);
                    fh.appendFile(info);
                    break;
                case 2:
                    gm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                case 3:
                    gm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("\nYou have selected an invalid option.\n\n");
                    break;
            }
            choice = gm.getChoice();
        }
        System.out.println("\nHave a good day!");
    }
}
