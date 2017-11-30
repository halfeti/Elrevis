package bigproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
 *
 * This class is use to get the directory which access to the 'data' folder.
 *
 */

public class Directory {
        
    public static String getDirectory() {
        
        String directory = "";
        try {
            File initial = new File("init.tmp");
            initial.createNewFile();
            //File parent = new File(initial.getParentFile().getName());
            directory = initial.getAbsoluteFile().getParent();
            initial.delete();
            directory += "\\data\\";
            initial = new File(directory + "init.tmp");
            initial.mkdirs();
            initial.createNewFile();
            initial.delete();
        } catch(IOException e) {
            System.out.println("ERROR DIRECTORY");
        }
        
        return directory;
        
    }
    
//    public static void main(String[] args) throws IOException {
//        System.out.println(getDirectory());
//    }
    
    public static ArrayList<WordGroup> list() {
        ArrayList<WordGroup> listOfWordGroup = new ArrayList<WordGroup>();
        
        File folder = new File(getDirectory());
        File[] listOfWordGroupArray = folder.listFiles();
        
        for(int i=0;i<listOfWordGroupArray.length;i++) {
            listOfWordGroup.add(new WordGroup(listOfWordGroupArray[i].getName()));
        }
        return listOfWordGroup;
    }
    
    public static WordGroup[] dir() {
        
        File folder = new File(getDirectory());
        File[] listOfWordGroupArray = folder.listFiles();
        WordGroup[] listOfWordGroup = new WordGroup[listOfWordGroupArray.length];
        for(int i=0;i<listOfWordGroupArray.length;i++) {
            String fileName = listOfWordGroupArray[i].getName();
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            listOfWordGroup[i] = new WordGroup(fileName);
            //System.out.println(listOfWordGroup[i].name);
        }
        return listOfWordGroup;
    }
    
}