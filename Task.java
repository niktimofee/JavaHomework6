package Homework6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Samsung", "8", "1000", "Windows", "silver");
        Laptop laptop2 = new Laptop("HP", "8", "512", "Linux", "silver");
        Laptop laptop3 = new Laptop("Lenovo", "16", "1512", "Windows", "black");
        Laptop laptop4 = new Laptop("MacBook", "16", "512", "MacOS", "gold");
        Laptop laptop5 = new Laptop("HP", "16", "1000", "Windows", "black");
        Set<Laptop> laptops = new HashSet<>(List.of(laptop1, laptop2,
        laptop3, laptop4, laptop5));
        Map<String, String> sel = selectCriteria();
        sort(sel, laptops);
    }

    public static String scanner() {
        String scan;
        if(sc.hasNext()){
            scan = sc.nextLine();
        } else {
            System.out.println("Ошибка при вводе! Попробуйте ещё раз.");
            sc.next();
            scan = scanner();
        }
        return scan;
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriteria = new HashMap<>();
        while (true) {
            System.out.println("Для выбора критериев введите: 'y', для отмены введите: 'n' ");
            String scan1 = scanner();
            char question = scan1.charAt(0);
            char answerY = 'y';
            char answerN = 'n';
            if (question == answerN) {
                break;
            } if (question == answerY) {
                System.out.println(
                    "Введите цифру для выбора критерия: \n 1 - Название модели \n 2 - Объём ОЗУ \n 3 - Объём внутреннего накопителя \n 4 - Операционная система \n 5 - Цвет");        
                String scan2 = scanner();
                int tempKey = Integer.parseInt(scan2);
                if (tempKey > 5 || tempKey < 1) {
                    System.out.println("Ошибка при вводе! Чтобы начать заново введите любое значение.");
                } else { 
                    System.out.println("Введите значение для выбранного критерия: ");}
                    String value = scanner();
                String key = String.valueOf(tempKey);
                resultCriteria.put(key, value);
            } else {
                System.out.println("Ошибка при вводе! Попробуйте ещё раз.");
            }
        }
        return resultCriteria;
    }

    public static void sort(Map<String, String> criteria, Set<Laptop> laptops) {
        Set<Laptop> temp = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            for (Object pair1 : criteria.keySet()) {
                if (pair1.equals("1") && !laptop.getName().equals(criteria.get(pair1))) {
                    temp.remove(laptop);
                }
                for (Object pair2 : criteria.keySet()) {
                    if (pair2.equals("2") && !laptop.getRam().equals(criteria.get(pair2))) {
                        temp.remove(laptop);
                    }
                    for (Object pair3 : criteria.keySet()) {
                        if (pair3.equals("3") && !laptop.getHdd().equals(criteria.get(pair3))) {
                            temp.remove(laptop);
                        }
                        for (Object pair4 : criteria.keySet()) {
                            if (pair4.equals("4") && !laptop.getOs().equals(criteria.get(pair4))) {
                                temp.remove(laptop);
                            }
                            for (Object pair5 : criteria.keySet()) {
                                if (pair5.equals("5") && !laptop.getColor().equals(criteria.get(pair5))) {
                                    temp.remove(laptop);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (temp.isEmpty()) {
            System.out.println("По введённым критериям ничего не найдено!");
        } else {
            System.out.println("Найдено по введённым критериям: \n" + temp.toString());
        }
    }
}