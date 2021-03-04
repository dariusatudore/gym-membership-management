package gymmanagement;

import java.nio.Buffer;
import java.util.LinkedList;
import java.io.*;

public class FileHandler {

    // this method reads from csv(comma separated values) file the details of each member
    // then it adds each member to a LinkedList and then returns it
    // the format of the file is:   memberType, memberID, memberName, memberPrice, gymID - Single gym members
    //                              memberType, memberID, memberName, memberPrice, memberPoints - Multiple gym members
    public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList();
        String lineRead;
        String[] splitLine;
        Member mem;

        try(BufferedReader reader = new BufferedReader(new FileReader("members.csv")))
        {
            lineRead = reader.readLine();
            while (lineRead != null)
            {
                splitLine = lineRead.split(", ");

                if (splitLine[0].equals("S"))
                {
                    mem = new SingleGymMember('S', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                } else
                {
                    mem = new MultiGymMember('M', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                }

                m.add(mem);
                lineRead = reader.readLine();
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return m;
    }

    // this method appends a new line to the csv file whenever a new member is added
    // appendMemberToFile
    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true)))
        {
            writer.write(mem + "\n");
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // this method is used when you need to remove a member from the file
    public void overwriteFile(LinkedList<Member> m) {
        String s;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
            for(int i = 0; i < m.size(); i++)
            {
                s = m.get(i).toString();
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            File f = new File("members.csv");
            File tf = new File("members.temp");

            f.delete();
            tf.renameTo(f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
