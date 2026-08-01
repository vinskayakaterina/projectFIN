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
                case 2:
                    delete(dArray, scr);
                    break;
                case 3:
                    getBalance(dArray);
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
            System.out.println("✅ Добавлено: " + words[0] +" с суммой " + words[1]);
            return list;
        }
        else {
            System.out.println("Введена некорректная строка");
            return (create(list, scr));
        }
    }
    public static void delete(List<String[]> list, Scanner scr){
        if (list.isEmpty()){
            System.out.println("Список пустой, нет записей на удаление");
            return;
        }
        System.out.println("Вы выбрали удаление траты/пополнения" + "\n" + "Введите номер записи");
        int index = scr.nextInt()-1;
        scr.nextLine();
        if (index>=0 && index<=list.size()){
            String[] deleteRow = list.remove(index);
            System.out.println("Удалено:"+deleteRow[0]+ " с суммой "+ deleteRow[1]);
        }
        else {
            System.out.println("Не найдена запись с таким номером");
            System.out.println("Доступны номера: 1-"+list.size());
        }
    }
    public static int getBalance(List<String[]> list) {
        if (list.isEmpty()) {
            System.out.println("Нет записи о тратах. Баланс = 0");
            return 0;
        }
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            String[] row = list.get(i);
            int element = Integer.parseInt(row[1]);
            sum = sum+element;
        }
        System.out.println("Ваш баланс: " + sum);
        return sum;

    }
}