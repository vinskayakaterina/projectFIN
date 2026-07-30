import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String[]> dArray = new ArrayList<>();
        Scanner scr = new Scanner(System.in);
        int choice;
        do {
            choice = menu(scr);
            scr.nextLine();
            switch (choice) {
                case 1:
                    dArray = create(dArray, scr);
                    break;
            }
        }
            while (choice != 0);
            scr.close();
    }
    public static int menu(Scanner scr) {
        System.out.println("1 Добавить трату/пополнение"+"\n"+"2 Удалить трату/пополнение"+"\n"+"3 Узнать текущий счет"+"\n"+"4 Вывести все траты/поплнения"+"\n"+"5 Вывести все траты по определенной категории"+"\n" + "0 Выход");
            while (!scr.hasNextInt()) {
                System.out.print("Введите число! Ваш выбор: ");
                scr.next();
            }
            return scr.nextInt();
    };

    public static List<String[]> create(List<String[]> list, Scanner scr){
        System.out.println("Вы выбрали добавление траты/пополнения" + "\n" + "Введите категорию и сумму");
        String input = scr.nextLine();
        String[] words = input.split(" ");
        if (words.length==2){
            list.add(new String[]{words[0], words[1]});
            System.out.println("✅ Добавлено: " + words[0] + words[1]);
            return list;
        }
        else {
            System.out.println("Введена некорректная строка");
            return (create(list, scr));
        }
    }
}