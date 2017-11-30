package bigproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 *
 * This class is use to search for word in dictionary
 * Not done yet.
 *
 */

public class ScanWordDict {
    

    //Tham khảo thuật toán tại: https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
    public static void printout(String tu) throws IOException {
        FileReader f = new FileReader("C:/Users/baolo/IdeaProjects/BigProject/EVDict.txt");
        String line = null;
        StringBuilder consider_word = new StringBuilder();
        StringBuilder dict = new StringBuilder();
        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader =
                new BufferedReader(f);

        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            dict.append(line);
        }

        // Always close files.
        bufferedReader.close();


        boolean found = false;
        for(int i = 0;i<dict.length();i++)
        {
            if(dict.charAt(i) == '@')
            {
                int j = i + 1;
                while(dict.charAt(j) != ' ' && dict.charAt(j) != '\n')
                {
                    consider_word.append(dict.charAt(j));
                    j++;
                }
                if(consider_word.toString().equals(tu))
                {
                    found = true;
                    i++;
                    while(dict.charAt(i) != '@')
                    {
                        System.out.print(dict.charAt(i));
                        i++;
                    }
                    break;
                }
                else
                {
                    consider_word = new StringBuilder();
                }
            }
            if(found) break;
        }
    }

    public static void main(String[] args) throws IOException {
        printout("a-going");
    }

}