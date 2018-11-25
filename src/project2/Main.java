package project2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Set<Person> set = new HashSet<>();
    static Scanner scanner = new Scanner(System.in);
    static int countWorkers;


    public static void main(String[] args) {
        boolean exit = false;
        String menuTitle = "Type 1 for a new manual entry, 2 for random entries, 3 to print all the unique inputs, any other key to exit";
        while (!exit){
            System.out.println(menuTitle);
            int i = Validation.readInt();
            switch (i){
                case 1:
                    manualEntry();
                    break;
                case 2:
                    randomEntry();
                    break;
                case 3:
                    printCollection();
                    break;
                default:
                    exit = true;
                    System.out.print("Exiting program...");
            }
        }
    }

    //Let the user give new students and workers manually
    public static void manualEntry(){
        String menuTitle = "Type 1 if you want to create a Student, 2 for a Worker, any other key to go back to the main menu";
        System.out.println(menuTitle);
        int i = Validation.readInt();
        switch (i){
            case 1:
                createStudent();
                break;
            case 2:
                createWorker();
                break;
            default:
                return;
        }
    }

    public static void createStudent(){
        Person p = createPerson();
        if (p==null) {
            System.out.println("Could not create new student");
            return;
        }
        System.out.println("Type in the faculty number");
        String fac = scanner.nextLine();
        Student s = new Student(p, fac);
        System.out.println("Student created successfully with the following details:");
        System.out.println(s);
        if (set.add(s)){
            System.out.println("Student added to the collection");
        }else{
            System.out.println("Student already exists in the collection");
        }
    }

    public static void createWorker(){
        Person p = createPerson();
        if (p==null){
            System.out.println("Could not create new worker");
            return;
        }
        System.out.println("Type in the week salary");
        double weekSalary = Validation.readDouble();
        System.out.println("Type in the work hours per day");
        int workHours = Validation.readInt();
        Worker w = new Worker(p, weekSalary, workHours);
        System.out.println("Worker created successfully with the following details:");
        System.out.println(w);
        countWorkers++;
        if(set.add(w)){
            System.out.println("Worker added to the collection");
        }else{
            System.out.println("Worker already exists in the collection");
        }
    }

    public static Person createPerson(){
        System.out.println("Type in the first name");
        String firstName = scanner.nextLine();
        System.out.println("Type in the last name");
        String lastName = scanner.nextLine();
        Person p = Validation.createPerson(firstName, lastName);
        return p;
    }

    //Let the program create new students and workers and add them to the collection
    public static void randomEntry(){
        Student s = new Student("john","vegas","74EA54646");
        set.add(s);
        s = new Student("john nick","brown","217AG5");
        set.add(s);
        s = new Student("helGA","frAU");
        set.add(s);
        s = new Student("nick","offerman","14asdaf81");
        set.add(s);
        Worker w = new Worker("yohan", "strauss", 12.50);
        set.add(w);
        w = new Worker("jack ", "vander halos");
        set.add(w);
        w = new Worker("mick", "jonas", 10);
        set.add(w);
        w = new Worker("michael", "fassbender", 69, 4);
        set.add(w);
        System.out.println("Random entries created");
    }

    public static void printCollection(){
        int count = 0;
        for (Person p:set){
            System.out.println(p);
            System.out.println("======================================");
            if (p instanceof Worker) count++;
        }
        System.out.println("There are " + countWorkers + " workers that were created during the run");
        System.out.println("There are " + count + " unique workers in our collection");
    }
}