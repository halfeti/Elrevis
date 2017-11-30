//import Interface.WordGroup;
import bigproject.*;
import java.io.IOException;
import java.util.*;

public class BigProject {

    public static void main(String[] args) throws IOException {
//        WordGroup[] test = Directory.dir();
//        for(int i = 0 ; i < test.length ; i++) {
//            System.out.println(test[i].sotu);
//        }
        ALLOUT:
        while(true)
        {
            try
                {
                    //The following declare the attribute which use to make choice in menus.
                int main_menu_choose = -1;
                Scanner cin = new Scanner(System.in);
                Scanner nhapString = new Scanner(System.in);
                MAINMENU:
                while (true) {  //Infinity loop
                    MenuPrintout.printMainmenu();   //Print out mainmenu.
                    System.out.print("Lựa chọn: ");
                    main_menu_choose = cin.nextInt();   //Choosing option.
                    switch (main_menu_choose) {
                        //Search word in dictionary
                        case 1:
                            System.out.println("Nhập từ: ");
                            String tu = nhapString.nextLine();
                            ScanWordDict.printout(tu);
                            break;
                        //Inside the Word Group Menu options.
                        case 2:
                            WORDGROUPMENU:
                            while(true) {
                                MenuPrintout.printWordGroupMenu();  //Print out WordGroup Menu.
                                System.out.print("Lựa chọn: ");
                                int word_group_choose = cin.nextInt();  //Choosing option.
                                switch (word_group_choose) {
                                    //Learning Word (not done yet)
                                    case 1:
                                        {

                                        break;
                                        }
                                    //Add new Word Group
                                    case 2:
                                        System.out.print("Nhập vào tên bộ từ mới: ");
                                        String new_name = nhapString.nextLine();
                                        while(WordGroup.isExists(new_name))
                                        {
                                            System.out.print("Tên bộ từ bạn vừa nhập đã tồn tại.\nNhập vào tên bộ từ mới: ");
                                            new_name = nhapString.nextLine();
                                        }
                                        WordGroup.create(new_name);
                                        System.out.println("Bộ từ mới với tên " + new_name + " đã được tạo!");
                                        break;
                                    //Merging WordGroup
                                    case 3:
                                        
                                        //Input the name of the source word group.
                                        System.out.print("Nhập tên bộ từ làm gốc: ");
                                        String source_name = nhapString.nextLine();
                                        while(!WordGroup.isExists(source_name))
                                        {
                                            System.out.println("Bộ từ không tồn tại!");
                                            System.out.print("Nhập lại: ");
                                            source_name = nhapString.nextLine();
                                        }
                                        WordGroup source = new WordGroup(source_name); //The source word group will stay.
                                        
                                        //Input the combinning word group. 
                                        //The combinning word group will connect to the end of the source. 
                                        //The initial combinning word group will be deleted.
                                        System.out.print("Nhập tên bộ từ ghép vào: ");
                                        String com_name = nhapString.nextLine();
                                        while(!WordGroup.isExists(com_name))
                                        {
                                            System.out.println("Bộ từ không tồn tại!");
                                            System.out.print("Nhập lại: ");
                                            com_name = nhapString.nextLine();
                                        }
                                        WordGroup com_word_group = new WordGroup(com_name);
                                        source.merge(com_word_group);   //Merging them.
                                        System.out.println("Merge success!");   //Just a notification.
                                        break;
                                    case 4:
                                        //Inside Word menu.
                                        WORDMENU:
                                        while(true) {
                                            System.out.print("Nhập tên bộ từ muốn tương tác: ");    //Choosing word group to interact with.
                                            String name = nhapString.nextLine();
                                            while(!WordGroup.isExists(name))
                                            {
                                                System.out.println("Bộ từ không tồn tại!");
                                                System.out.print("Nhập lại: ");
                                                name = nhapString.nextLine();
                                            }
                                            WordGroup selected_word_group = new WordGroup(name);
                                            MenuPrintout.printWordMenu();   //Print out Word menu.
                                            System.out.print("Lựa chọn: "); //Choosing option.
                                            int word_choose = cin.nextInt();
                                            switch (word_choose) {
                                                //Add more word to selected word group.
                                                case 1:
                                                    //selected_word_group.addWord();
                                                    break;
                                                case 2:
                                                    break;
                                                case 3:
                                                    //Delete word by its name.
                                                    System.out.print("Nhập vào từ bạn muốn xóa: ");
                                                    String deleteWord = nhapString.nextLine();
                                                    selected_word_group.remove(deleteWord);
                                                    System.out.println("The word you entered has been removed");
                                                    break;
                                                default:
                                                    break WORDMENU;
                                            }
                                        }
                                        break;
                                    case 5:
                                        //Delete word group by its name
                                        System.out.print("Nhập vào tên bộ từ muốn xóa: ");
                                        String delete_name = nhapString.nextLine();
                                        WordGroup delete_word_group = new WordGroup(delete_name);
                                        WordGroup.delete(delete_word_group);
                                        break;
                                    case 6:
                                        //Browse for words in a word group.
                                        //Print out list of word
                                        System.out.print("Nhập vào bộ từ muốn xem: ");
                                        String name = nhapString.nextLine();
                                        while(!WordGroup.isExists(name))
                                        {
                                            System.out.println("Bộ từ không tồn tại!");
                                            System.out.print("Nhập lại: ");
                                            name = nhapString.nextLine();
                                        }
                                        WordGroup selected_word_group = new WordGroup(name);
                                        selected_word_group.browseWords();
                                        break;
                                    default:
                                        //Back to mainmenu
                                        break WORDGROUPMENU;
                                }
                            }
                            break;
                        case 3:
                            //Close program
                            System.out.println("Đang đóng...");
                            break ALLOUT;
                        default:
                            System.out.println("Lỗi, nhập lại!");
                    }
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error! Please enter an integer instead of another.");
            }
        }
    }
}