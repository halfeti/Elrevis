package bigproject;

/*
 *
 * This class is use to print out the menus to the console screen.
 * Not use in GUI
 */


public class MenuPrintout {
    
    //Print out the main menu
    //Input 3 here will close the program
    public static void printMainmenu() {
        System.out.println("______________________________\n" +
                           "| 1. Tra từ điển (Anh Việt)  |\n" +
                           "| 2. Bộ từ                   |\n" +
                           "| 3. Thoát chương trình      |\n" +
                           "______________________________");
    }

    //Print out the WordGroup Menu
    //Activate after input 2 in main menu
    //Input 7 will bring back the main menu    
    public static void printWordGroupMenu() {
        System.out.println("______________________________\n" +
                "| 1. Học bộ từ               |\n" +
                "| 2. Thêm bộ từ              |\n" +
                "| 3. Ghép 2 bộ từ            |\n" +
                "| 4. Sửa bộ từ               |\n" +
                "| 5. Xóa bộ từ               |\n" +
                "| 6. Duyệt từ của bộ         |\n" +
                "| 7. Quay lại                |\n" +
                "______________________________");
    }

    //Print out the Word Menu
    //Activate after input 4 in WordGroup menu
    //Input 4 will bring back the WordGroup menu.
    public static void printWordMenu() {
        System.out.println("______________________________\n" +
                "| 1. Thêm từ                 |\n" +
                "| 2. Sửa từ                  |\n" +
                "| 3. Xóa từ                  |\n" +
                "| 4. Quay lại                |\n" +
                "______________________________");
    }

    //Print out the Liscence.
    public static void printLiscence() {
        System.out.println("© Copyright 2017. All Rights Reserved.\n"
                + "Application created by: \nNguyen Dang Bao Long & Nguyen Thi Thuy Nga.");
    }
    
}
