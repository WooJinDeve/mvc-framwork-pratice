package org.example.grade;

public class Course {

    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        GradeType gradeType = GradeType.hasToGradeType(this.grade);
        return gradeType.getGradeToNumber();
    }

    public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }
}
