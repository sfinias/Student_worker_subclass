package project2;

public class Student extends Person {

    private String facultyNumber;

    Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student (Person person, String facultyNumber){
        super(person);
        setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length()<5 || facultyNumber.length()>10){
            System.out.println("Faculty number must contain from 5 to 10 characters and/or numbers");
        }else{
            if (facultyNumber.matches("[a-zA-z0-9]+") ){
                this.facultyNumber = facultyNumber;
            }else{
                System.out.println("Faculty number must only consist of characters and numbers");
            }
        }
    }

    @Override
    public String toString() {
        String st = super.toString();
        st += "\nFaculty Number : ";
        if (this.facultyNumber==null){
            st += "-";
        }else{
            st += this.facultyNumber;
        }
        return st;
    }
}
