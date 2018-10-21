package examples.controller;

public class Student {
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKoreanScore() {
        return koreanScore;
    }

    public void setKoreanScore(int koreanScore) {
        this.koreanScore = koreanScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    @Override
    public String toString() {
        return "Student : name = " + this.name + '\n' +
                " , korean = " + this.koreanScore + '\n' +
                " , english = " + this.englishScore + '\n' +
                " , math = " + this.mathScore;
    }
}
