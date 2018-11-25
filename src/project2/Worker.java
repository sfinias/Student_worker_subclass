package project2;

public class Worker extends Person {

    private double weekSalary;
    private int workHours;

    Worker(String firstName, String lastName, double weekSalary, int workHours) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHours(workHours);
    }

    public Worker(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Worker(String firstName, String lastName, double weekSalary) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
    }

    public Worker(String firstName, String lastName, int workHours) {
        super(firstName, lastName);
        setWorkHours(workHours);
    }

    public Worker(Person person, double weekSalary, int workHours){
        super(person);
        setWeekSalary(weekSalary);
        setWorkHours(workHours);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary<=10.0){
            System.out.println("Week salary must be more than 10");
        }else{
            this.weekSalary=weekSalary;
            if(this.workHours!=0){
            }
        }
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        if (workHours<1 || workHours>12){
            System.out.println("Work hours must be in range 1-12");
        }else{
            this.workHours=workHours;
            if (this.weekSalary!=0){
            }
        }
    }

    public double salaryByHour(){
        if (workHours == 0 || weekSalary==0) return -1;
        return this.weekSalary/(this.workHours*5);
    }

    @Override
    public String toString() {
        String st = super.toString();
        st += "\nWeek Salary : ";
        if (weekSalary==0.0){
            st += "-";
        }else{
            st += String.format("%.2f",this.weekSalary);
        }
        st += "\nHours Per Day : ";
        if (workHours==0){
            st += "-";
        }else{
            st += this.workHours;
        }
        st += "\nSalary Per Hour : ";
        double s = salaryByHour();
        if (s == -1){
            st += "-";
        }else{
            st += String.format("%.2f",s);
        }
        return st;
    }
}
