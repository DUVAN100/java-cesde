package co.edu.cesde;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String photo;
    private List<Double> grades = new ArrayList<>();
    private double finalGrade;

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public void addGrade(double grade){
        this.grades.add(grade);
    }
    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
