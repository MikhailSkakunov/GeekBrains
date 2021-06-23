package Lesson3;

import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        ArrayList<String> capitalCities = new ArrayList<>();
        capitalCities.add("Rome");
        capitalCities.add("London");
        capitalCities.add("Minsk");
        capitalCities.add("Prague");
        capitalCities.add("Berlin");
        capitalCities.add("Helsinki");
        capitalCities.add("Tokyo");
        capitalCities.add("Helsinki");
        capitalCities.add("Lisbon");
        capitalCities.add("Singapore");
        capitalCities.add("Madrid");
        capitalCities.add("Madrid");
        capitalCities.add("Bern");
        capitalCities.add("Prague");
        capitalCities.add("Prague");
        capitalCities.add("Lisbon");
        capitalCities.add("Budapest");
        capitalCities.add("Lisbon");
        capitalCities.add("Stockholm");
        capitalCities.add("Lisbon");
        capitalCities.add("Stockholm");

        Set<String> stringSet = new HashSet<>(capitalCities);

        printUnique(stringSet);
        reverse(capitalCities, map);
    }

    private static void printUnique(Set<String> capitalCities) {
            Iterator<String> iterator = capitalCities.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                System.out.print(str + " ");
            }
        System.out.println("\n");
    }

    public static void reverse(ArrayList<String> capitalCities, Map<String, Integer> map) {

        for (int i = 0; i < capitalCities.size(); i++) {
            String capital = String.valueOf(capitalCities.get(i));
            if (!map.containsKey(capital)) {
                map.put(capital, 1);
            }
            else {map.put(capital, map.get(capital) + 1);
            }
        }
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println("Слово: " + entry.getKey() + " " + "Повторений: " + entry.getValue());
                }
            }
        }

