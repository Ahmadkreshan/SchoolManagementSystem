package com.mycompany.project2;

import models.*;
import services.SchoolServices;
import tools.Actions;

import java.util.Scanner;

public class Hmi {
    private static SchoolServices schoolServices;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        School school = Hmi.createSchool();
        System.out.println("Welcome to " + school.getName() + " in "+school.getAddress());
        System.out.println();
        int action;

        do {
            System.out.println("What do you want to do ?");
            System.out.println("1.Add Student");
            System.out.println("2.Add Teacher");
            System.out.println("3.Add Grade");
            System.out.println("4.Print All Students");
            System.out.println("5.Print All Teachers");
            System.out.println("6.Print All Grades");
            System.out.println("7.Find Student By Name");
            System.out.println("8.Find Teacher By Name");
            System.out.println("9.Find Grade By Code");
            System.out.println("10.Remove Student");
            System.out.println("11.Remove Teacher");
            System.out.println("11.Remove Grade");
            System.out.println("13.Exit");

            try {
                action = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid entry!");
                throw new RuntimeException(e);
            }

            switch (action){
                case 1:
                    Hmi.addStudent();
                    break;
                case 2:
                    Hmi.addTeacher();
                    break;
                case 3:
                    Hmi.addGrade(scanner);
                    break;
                case 4:
                    Hmi.printAllStudents();
                    break;
                case 5:
                    Hmi.printAllTeachers();
                    break;
                case 6:
                    Hmi.printAllGrades();
                    break;
                case 7:
                    Hmi.printDataPersonByName(Actions.STUDENT);
                    break;
                case 8:
                    Hmi.printDataPersonByName(Actions.TEACHER);
                    break;
                case 9:
                    Hmi.printDataGradeByCode();
                    break;
                case 10:
                    Hmi.removePerson(Actions.STUDENT);
                    break;
                case 11:
                    Hmi.removePerson(Actions.TEACHER);
                    break;
                case 12:
                    Hmi.removeGrade();
                    break;
                default:
                    if(action !=13){
                    System.out.println("Invalid entry,please select from the list!");}
            }
        }while(action !=13);
    }

    private static School createSchool(){
        School school=new School();
        school.setName("IT School");
        school.setAddress("Amman");
        school.setPhoneNumber("0123456789");
        Hmi.schoolServices = new SchoolServices(school);
        return school;
    }

    private static void addStudent(){
        Student student = new Student();
        Hmi.setDataPerson(student);
        Hmi.schoolServices.addStudent(student);
    }

    private static void addTeacher(){
        Teacher teacher = new Teacher();
        Hmi.setDataPerson(teacher);
        Hmi.schoolServices.addTeacher(teacher);
    }

    private static void addGrade(Scanner scanner){
        Grade grade = new Grade();
        System.out.println("Please Enter Grade Name: ");
        grade.setName(scanner.next());
        System.out.println("Please Enter Grade Code: ");
        grade.setCode(scanner.next());
        Hmi.schoolServices.addGrade(grade);
    }

    private static void printAllStudents(){
        for(Student student:Hmi.schoolServices.getSchool().getStudents()){
            System.out.println(student.getData());
        }
    }

    private static void printAllTeachers(){
        for(Teacher teacher:Hmi.schoolServices.getSchool().getTeachers()){
            System.out.println(teacher.getData());
        }
    }

    private static void printAllGrades(){
        for(Grade grade:Hmi.schoolServices.getSchool().getGrades()){
            System.out.println(grade.toString());
        }
    }

    private static void setDataPerson(Person person){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Name: ");
        person.setName(scanner.next());
        System.out.println("Please Enter The Age: ");
        person.setAge(scanner.nextInt());
        if (person instanceof Teacher){
            System.out.println("Please Enter The Salary: ");
            ((Teacher)person).setSalary(scanner.nextFloat());
        }else if(person instanceof Student){
            System.out.println("Please Enter The Phone Number: ");
            ((Student)person).setParentPhoneNumber(scanner.next());
        }
    }

    private static void printDataPersonByName(Actions action){
        Person person = Hmi.findPersonByName(action);
        Hmi.printDataPerson(person);
    }

    private static void printDataPerson(Person person){
        if(person == null){
            System.out.println("Not Found!");
        }else {
            System.out.println(person.getData());
        }
    }

    private static Person findPersonByName(Actions action){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Name: ");
        String name=scanner.next();
        Person person;
        if (action == Actions.STUDENT){
            person = Hmi.schoolServices.getStudentByName(name);
        }else{
            person = Hmi.schoolServices.getTeacherByName(name);
        }
        return person;
    }

    private static void printDataGradeByCode(){
        Grade grade = Hmi.findGradeByCode();
        Hmi.printDataGrade(grade);
    }

    private static void printDataGrade(Grade grade){
        if(grade == null){
            System.out.println("Not Found!");
        }else {
            System.out.println(grade.toString());
        }
    }

    private static Grade findGradeByCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Code: ");
        String code=scanner.next();
        Grade grade= Hmi.schoolServices.getGradeByCode(code);
        return grade;
    }

    private static void removePerson(Actions action){
        Person person = Hmi.findPersonByName(action);
        if(person instanceof Student) {
            Hmi.schoolServices.removeStudent((Student) person);
            System.out.println("The Student Removed Successfully");
        }else{
            Hmi.schoolServices.removeTeacher((Teacher) person);
            System.out.println("The Teacher Removed Successfully");
        }
    }

    private static void removeGrade(){
        Grade grade = Hmi.findGradeByCode();
        Hmi.schoolServices.removeGrade(grade);
        System.out.println("The Grade Removed Successfully");
    }
}
