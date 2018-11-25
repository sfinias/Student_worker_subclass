package project2;

import java.util.Scanner;

public class Validation {

    private Validation() {
    }

    //Creates a new Person and checks if the first and last names fulfill the constraints given.
    //If so it returns the object, otherwise it returns null
    public static Person createPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        if (person.getFirstName() == null || person.getLastName() == null) {
            return null;
        } else {
            return person;
        }
    }

    //Expects an input from the user and checks if it is a positive integer and returns it, otherwise it returns -1
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        scanner = new Scanner(st);
        if (scanner.hasNext()) {
            st = scanner.next();
            if (scanner.hasNext() || !st.matches("[0-9]+")) {
                scanner.close();
                return -1;
            } else {
                scanner.close();
                return Integer.parseInt(st);
            }
        }
        scanner.close();
        return -1;
    }

    //Expects an input from the user and checks if it is a positive double and returns it, otherwise it returns -1
    public static double readDouble() {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        scanner = new Scanner(st);
        if (scanner.hasNext()) {
            st = scanner.next();
            if (scanner.hasNext()) {
                scanner.close();
                return -1;
            }
            if (st.matches("[0-9]+[.]?[0-9]*")) {
                scanner.close();
                return Double.parseDouble(st);
            }
        }
        scanner.close();
        return -1;
    }

    //The new student/worker may have more than 1 first and last names, so this method checks if each name fulfill the constraints
    //If so, it returns a StringBuilder with the name modified, else it returns the reason why it was not valid
    public static StringBuilder validateName(String name, int len) {
        Scanner scanner = new Scanner(name);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.length() <= len) {
                sb.setLength(0);
                sb.append("short");
                scanner.close();
                return sb;
            } else if (!str.matches("[a-zA-Z]+")) {
                sb.setLength(0);
                sb.append("notLetters");
                scanner.close();
                return sb;
            }
            str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
            sb.append(str + " ");
        }
        scanner.close();
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }
}
