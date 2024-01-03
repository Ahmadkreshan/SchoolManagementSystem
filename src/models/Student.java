package models;

public class Student extends Person {
    private String parentPhoneNumber;

    public Student() {
    }


    public Student(String name, int age, String parentPhoneNumber) {
        super(name, age);
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    @Override
    public String getData(){
        return "Student Name: "+this.getName()+" Student Age: "+this.getAge()+" Parent Phone Number: "+this.parentPhoneNumber;
    }
}
