package examples.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class UI {
    private BufferedReader br;
    public UI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Student addStudent() {
        System.out.print("이름 : ");
        String name = getLine();

        System.out.print("국어 : ");
        int koreanScore = getInt();

        System.out.print("영어 : ");
        int englishScore = getInt();

        System.out.print("수학 : ");
        int mathScore = getInt();

        Student student = new Student();
        student.setName(name);
        student.setKoreanScore(koreanScore);
        student.setEnglishScore(englishScore);
        student.setMathScore(mathScore);

        return student;
    }

    public void listStudent(List<Student> studentList) {
        for(Student stu : studentList) {
            System.out.println(stu);
        }
    }

    public void end() {
        System.out.println("종료하시겠습니까? y/n");
        String str = getLine();
        if("y".equals(str)) {
            System.exit(0);
        }
    }



    public int main() {
        System.out.println("1. 입력");
        System.out.println("2. 조회");
        System.out.println("3. 종료");
        return getInt();
    }

    private String getLine() {
        try {
            return br.readLine();
        }catch(Exception ex) {
            return null;
        }
    }

    private int getInt() {
        return Integer.parseInt(getLine());
    }

}
