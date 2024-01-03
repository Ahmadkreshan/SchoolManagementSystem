package services;
import models.Grade;
import models.School;
import models.Student;
import models.Teacher;

public class SchoolServices {
    private School school;

    public SchoolServices(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void addStudent(Student student){
        this.school.getStudents().add(student);
    }

    public void addTeacher(Teacher teacher){
        this.school.getTeachers().add(teacher);
    }

    public void addGrade(Grade grade){
        this.school.getGrades().add(grade);
    }

    public void removeStudent(Student student){
        this.school.getStudents().remove(student);
    }

    public void removeTeacher(Teacher teacher){
        this.school.getTeachers().remove(teacher);
    }

    public void removeGrade(Grade grade){
        this.school.getGrades().remove(grade);
    }

    public Student getStudentByName(String name){
        Student s=null;
        for(Student student : this.school.getStudents()){
            if(student.getName().equalsIgnoreCase(name)){
                s=student;
                break;
            }
        }
        return s;
    }

    public Teacher getTeacherByName(String name){
        for(Teacher teacher : this.school.getTeachers()){
            if(teacher.getName().equalsIgnoreCase(name)){
                return teacher;
            }
        }
        return null;
    }

    public Grade getGradeByCode(String code){
        Grade g=null;
        for(Grade grade : this.school.getGrades()){
            if(grade.getCode().equalsIgnoreCase(code)){
                g=grade;
                break;
            }
        }
        return g;
    }



}
