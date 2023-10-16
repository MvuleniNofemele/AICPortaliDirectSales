package utility;

// Java program to merge two
// files  into third file alternatively

import java.io.*;

public class Merger {
    public static void main1(String[] args) throws IOException
    {
        // PrintWriter object for file3.txt
        PrintWriter pw = new PrintWriter("C:\\Users\\ABASACG\\Desktop\\selenium WorkSpace\\Parallel\\AOL_BAU\\TestResults\\Result_22062018132022\\result.txt");

        // BufferedReader object for file1.txt
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ABASACG\\Desktop\\selenium WorkSpace\\Parallel\\AOL_BAU\\TestResults\\Result_22062018132022\\result_Chrome.html"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\ABASACG\\Desktop\\selenium WorkSpace\\Parallel\\AOL_BAU\\TestResults\\Result_22062018132022\\result_Firefox.html"));

        String line1 = br1.readLine();
        String line2 = br2.readLine();

        // loop to copy lines of
        // file1.txt and file2.txt
        // to  file3.txt alternatively
        while (line1 != null || line2 !=null)
        {
            if(line1 != null)
            {
                pw.println(line1);
                line1 = br1.readLine();
            }

            if(line2 != null)
            {
                pw.println(line2);
                line2 = br2.readLine();
            }
        }

        pw.flush();

        // closing resources
        br1.close();
        br2.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt alternatively into file3.txt");
    }

    public static void main(String[] args) {
        File[] files = new File[2];
        files[0]=new File("C:\\Users\\ABASACG\\Desktop\\selenium WorkSpace\\Parallel\\AOL_BAU\\TestResults\\Result_22062018132022\\result_Chrome.html");
        files[1]=new File("C:\\Users\\ABASACG\\Desktop\\selenium WorkSpace\\Parallel\\AOL_BAU\\TestResults\\Result_22062018132022\\result_Firefox.html");
        File mergedFile = new File("C:\\Users\\ABASACG\\Desktop\\selenium WorkSpace\\Parallel\\AOL_BAU\\TestResults\\Result_22062018132022\\result.html");
        FileWriter fstream = null;
        BufferedWriter out = null;
        try
        {
            fstream = new FileWriter(mergedFile, true);
            out = new BufferedWriter(fstream);
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

        for (File f : files)
        {
            //System.out.println("merging: " + f.getName());
            FileInputStream fis;
            try {
                fis = new FileInputStream(f);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));

                String aLine;
                while ((aLine = in.readLine()) != null)
                {
                    out.write(aLine);
                    out.newLine();
                }

                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
