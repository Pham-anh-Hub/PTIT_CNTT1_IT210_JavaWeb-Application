package BaiTapSession02.demo.model;

public class Student {
    private String fullname;
    private double score;

    public Student() {
    }

    public Student(String fullname, double score) {
        this.fullname = fullname;
        this.score = score;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
