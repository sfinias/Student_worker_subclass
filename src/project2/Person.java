package project2;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Person(Person person){
        this(person.getFirstName(), person.getLastName());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
            int len = 2;
            if (firstName.length() <= len) {
                System.out.println("First name must be longer than " + len + " characters");
                return;
            }
            firstName = Validation.validateName(firstName, len).toString();
            if (firstName.equals("short")){
                System.out.println("First name must be longer than " + len + " characters");
            }else if (firstName.equals("notLetters")){
                System.out.println("First name must only contain letters");
            }else{
                this.firstName = firstName;
            }
    }

    public void setLastName(String lastName) {
        int len = 3;
        if (lastName.length() <= len) {
            System.out.println("Last name must be longer than " + len + " characters");
            return;
        }
        lastName = Validation.validateName(lastName, len).toString();
        if (lastName.equals("short")){
            System.out.println("Last name must be longer than " + len + " characters");
        }else if (lastName.equals("notLetters")){
            System.out.println("First name must only contain letters");
        }else{
            this.lastName = lastName;
        }
    }

    @Override
    public String toString() {
        return "First Name : "+this.firstName+"\nLast Name : "+this.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
