import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        getPersonsData(persons);

        for (Person person : persons) {
            System.out.println(person.toString());
        }

        for (Person person : persons) {
            try (FileWriter writer = new FileWriter(person.getLastName() + ".txt", true)) {
                writer.write(person.toString() + "\n");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
            }
        }
    }

    private static void getPersonsData(List<Person> users) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите данные пользователей (в формате Фамилия Имя Отчество Дата рождения(дд.мм.гггг) Номер Пол): ");
        String inputData = scanner.nextLine();

        String[] data = inputData.split(" ");

        try {
            if (data.length % 6 != 0) {
                throw new IllegalArgumentException("Неверное количество введенных данных!");
            }
                try {
                    Person user = new Person(data[0], data[1], data[2], data[3], Long.parseLong(data[4]), data[5].charAt(0));
                    users.add(user);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка при обработке данных: ");
                }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
