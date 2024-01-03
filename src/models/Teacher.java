package models;

public class Teacher extends Person{
    private float salary;

    public Teacher() {
    }

    public Teacher(String name, int age, float salary) {
        super(name, age);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String getData(){
        return "Teacher Name: "+this.getName()+" Teacher Age: "+this.getAge()+" Salary: "+this.salary;
    }
}
