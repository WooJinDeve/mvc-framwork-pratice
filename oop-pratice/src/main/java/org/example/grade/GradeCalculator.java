package org.example.grade;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculatorGrade() {
        // (학점수 x 교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = courses.multipliedCreditAndCourseGrade();

        // 수강 신청 총 학점수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
