package bigproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * This class have methods to interact with word groups
 *
 */

public class WordGroup {
    
    // These following are word group's attributes and contructor.
    // Attributes
    public String name, path;
    public int sotu = 0;
    public static int number_of_word = 0;
    
    
    //Contructor
    public WordGroup(String name){
        this.name = name;
        path = Directory.getDirectory() + name + ".txt";
        this.sotu = this.getSoTu();
        //System.out.println("Successfully created WordGroup object with name: " + name);
    }
    
    /*
     * The following area contain methods to
     * interact with word group.
     * 
     */
    
    //This method find out if the .txt file is already exists or not. It uses name to consider.
    public static boolean isExists(String name) {
        String path = Directory.getDirectory() + name + ".txt";
        File file = new File(path);
        return file.exists();
    }
    
    //This method create a new .txt file with the given name.
    public static void create(String name) {
        try {
            String path = Directory.getDirectory() + name + ".txt";
            File file = new File(path);
            file.createNewFile();
        } catch(IOException e) {
            //e.printStackTrace();
        }
    }
    
    //This method has not been written done yet. It's use to learning (revision) word.
    public void learn() {
        
    }
    
    //This method combine 2 word groups. The given word group will stand at the end of the invoked word group.
    public void merge(WordGroup a) {
        File filewrite = new File(this.path);
        File fileread = new File(a.path);
        try {
            FileWriter fw = new FileWriter(filewrite,true);
            Scanner fr = new Scanner(fileread);

            while(fr.hasNextLine()) {
                String line = fr.nextLine();
                fw.write(line);
                fw.write("\r\n");
            }

            fw.close();
            fr.close();
            fileread.delete();
        } catch(IOException e) {
            System.out.println("Problem");
        }
    }
    
    public void mergeWithoutDelete(WordGroup a) {
        File filewrite = new File(this.path);
        File fileread = new File(a.path);
        try {
            FileWriter fw = new FileWriter(filewrite,true);
            Scanner fr = new Scanner(fileread);

            while(fr.hasNextLine()) {
                String line = fr.nextLine();
                fw.write(line);
                fw.write("\r\n");
            }

            fw.close();
            fr.close();
        } catch(IOException e) {
            System.out.println("Problem");
        }
    }

    //This method rename the selected word group.
    public void renameTo(String name) {
        this.name = name;
        File f = new File(path);
        File temp = new File(f.getParentFile() + "\\" + name + ".txt");
        f.renameTo(temp);
        this.path = Directory.getDirectory() + name + ".txt";
        
    }
    
    //These method add a new word to the word group. The new word goes to the end of the .txt file.
    public void addWord(String wordName, String meanning, String link) {
        
        try {
            //String path = Directory.getDirectory() + name + ".txt";
            File file = new File(path);
            //file.createNewFile();
            FileWriter writer = new FileWriter(file,true);
            writer.write(wordName);
            writer.write("\t");
            writer.write(meanning + "\t" + link + "\t" + LearningTime.currentTime() + "\t14400000" + "\t\r\n");
            writer.flush();
            writer.close();
        } catch(IOException e) {
            System.out.println("ERROR! " + e);
        }
        
    }
    
    public void addWord(String wordName, String meanning, String link, String lastTime, String restTime) {
        
        try {
            //String path = Directory.getDirectory() + name + ".txt";
            File file = new File(path);
            //file.createNewFile();
            FileWriter writer = new FileWriter(file,true);
            writer.write(wordName);
            writer.write("\t");
            writer.write(meanning + "\t" + link + "\t" + lastTime + "\t" + restTime + "\t\r\n");
            writer.flush();
            writer.close();
        } catch(IOException e) {
            System.out.println("ERROR! " + e);
        }
        
    }
    
    //This method delete a word in the .txt file by its name.
    public void remove(String name) {
        
        File inputFile = new File(path);
        File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

        try {
            Scanner reader = new Scanner(inputFile);
            FileWriter writer = new FileWriter(tempFile,true);

            String currentLine;

            while(reader.hasNextLine()) {
                currentLine = reader.nextLine();
                int i = 0;
                String considerWord = "";
                while(i<currentLine.length() && currentLine.charAt(i) != '\t') {
                    considerWord += currentLine.charAt(i);
                    i++;
                }
                if(!considerWord.equals(name))
                    writer.write(currentLine + "\r\n");
            }
            writer.close(); 
            reader.close(); 
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        }
    }
    
    //This method delete the .txt file of a word group by its name.
    public static void delete(WordGroup a) {
//        System.out.println(a.path);
//        System.out.println(a.name);
        if(isExists(a.name))
        {
            //System.out.println("Here");
            File delFile = new File(a.path);
            boolean success = delFile.delete();
                if (success) {
                    System.out.println("The file has been successfully deleted");  
                }
                else {
                    System.out.println("Something went wrong here!");
                }
        }
        else    
            System.out.println("You are trying to delete a non-exists word group.");
    }
    
    //This method show all the containning word inside the .txt file of a word group.
    public void browseWords() throws FileNotFoundException {
        File f = new File(path);
        
        Scanner fr = new Scanner(f);
        
        ArrayList<String> list = new ArrayList<String>();
        while(fr.hasNextLine()) {
            String line = fr.nextLine();
            //System.out.println(line);
            list.add(line);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
    
    //This method return the number of words in the invoking Word Group
    public int getSoTu() {
        int wordNumber = 0;
        try{
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null && !line.equals("")) {
                wordNumber++;
            }
            br.close();
        } catch(FileNotFoundException e) {
            //e.printStackTrace();
        } catch(IOException e) {
            //e.printStackTrace();
        }
        
        //sotu = wordNumber;
        return wordNumber;
    }
    
    //This method return a group of String which represent words in the invoking Word Group
    public String[][] getWordListStringArray() {
        ArrayList<ArrayList<String>> listWord = new ArrayList<ArrayList<String>>();
        
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            int wordIndex = 0;
            
            while((line = br.readLine()) != null && !line.equals("")) {
                String cell = "";
                listWord.add(new ArrayList<String>());
                
                for(int i = 0; i < line.length(); i++) {
                    
                    if(line.charAt(i) != '\t') {
                        cell += line.charAt(i);
                    } else {
                        listWord.get(wordIndex).add(cell);
                        cell = "";
                    }
                    
                }
                
                wordIndex++;
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(WordGroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            
        }
        
        String[][] arrayWordList = new String[listWord.size()][5];
        
        for(int i = 0; i < listWord.size(); i++) {
            for(int j = 0; j < listWord.get(i).size(); j++) {
                arrayWordList[i][j] = listWord.get(i).get(j);
                //System.out.println(listWord.get(i).get(j));
            }
        }
        
        
        return arrayWordList;
    }
    
    //This method return an ArrayList which contain a group of Word object in the invoking Word Group
    public ArrayList<Word> getWordList() {
        ArrayList<Word> wordList = new ArrayList<>();
        
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            
            while((line = br.readLine()) != null && !line.equals("")) {
                wordList.add(new Word(line));
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(WordGroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            
        }
        
        return wordList;
    }
    
    //This method sort all the word inside the invoking Word Group
    public void sort() {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Word> wordList = getWordList();
        
        for(int i=0; i < wordList.size(); i++) {
            words.add(wordList.get(i).toLine());
        }
        
        Collections.sort(words);
        
        try {
            
            File nonSortedFile = new File(path);
            
            File sortedFile = new File(path + ".tmp");
            BufferedWriter sfBr = new BufferedWriter(new FileWriter(sortedFile));
            
            for(int i = 0; i < words.size(); i++) {
                sfBr.write(words.get(i));
            }
            
            sfBr.close();
            nonSortedFile.delete();
            sortedFile.renameTo(nonSortedFile);
            
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        }
        
    }
    
    public void editWord(Word initial, Word result) {
        this.remove(initial.name);
        this.addWord(result.name, result.meanning, result.link, initial.lastTime, initial.restTime);
        this.sort();
    }
    
    public static File getCombineAllWordGroup() {
        String fileName = "-+ALL+-";
        
        if(isExists(fileName)){
            delete(new WordGroup(fileName));
        }
        
        ArrayList<WordGroup> listOfWordGroup = Directory.list();
        create(fileName);
        WordGroup combineAllWordGroup = new WordGroup(fileName);
        
        for(int i = 0; i < listOfWordGroup.size(); i++) {
            combineAllWordGroup.mergeWithoutDelete(listOfWordGroup.get(i));
        }
        combineAllWordGroup.sort();
        
        File fileCombineAllWordGroup = new File(combineAllWordGroup.path);
        return fileCombineAllWordGroup;
    }
    
}