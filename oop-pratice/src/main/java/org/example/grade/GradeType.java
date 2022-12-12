package org.example.grade;

import java.util.Arrays;

public enum GradeType {

    GRADE_A_PLUS("A+", 4.5),
    GRADE_A("A", 4.0),
    GRADE_B_PLUS("B+", 3.5),
    GRADE_B("B", 3.0),
    GRADE_C_PLUS("C+", 2.5),
    GRADE_C("C", 2.0),
    GRADE_OTHER("NONE", 0);

    private final String grade;
    private final double gradeNumber;

    GradeType(String grade, double gradeNumber) {
        this.grade = grade;
        this.gradeNumber = gradeNumber;
    }

    public static GradeType hasToGradeType(String grade){
        return Arrays.stream(values())
                .filter(gradeType -> gradeType.grade.equals(grade))
                .findFirst()
                .orElse(GradeType.GRADE_OTHER);
    }

    public double getGradeToNumber() {
        return gradeNumber;
    }
}
