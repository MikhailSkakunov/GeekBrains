package Lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneNumberSearch {

    public static void main(String[] args) {

        Phone phonebook = new Phone();
        phonebook.add("Иванов", "35-33-08");
        phonebook.add("Петров", "35-93-00");
        phonebook.add("Голубев", "45-63-49");
        phonebook.add("Петров", "55-99-76");
        phonebook.add("Иванов", "63-29-12");
        phonebook.add("Иванько", "79-54-02");

        Set<String> allName = phonebook.getAllPhoneCustomer();
        for (String nameCustomer : allName) {
            Set<String> phones = phonebook.get(nameCustomer);
            System.out.println("Фамилия: " + nameCustomer + " " + "Телефоны: " + phones);
        }
    }

}
