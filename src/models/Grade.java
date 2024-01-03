package models;

import java.util.ArrayList;

public class Grade {
    private String code;
    private String name;
    private Teacher teacher;
    private ArrayList <Student> students;

    public Grade() {
        this.students = new ArrayList<Student>();
    }

    public Grade(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<Student>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
