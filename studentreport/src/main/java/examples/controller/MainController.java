package examples.controller;

import examples.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private UI ui;
    private List<Student> studentList = new ArrayList<>();
    private StudentDao dao;

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void control() {
        while(true) {
            int value = ui.main();
            switch (value) {
                case 1:
                    Student student = ui.addStudent();
                    studentList.add(student);
                    break;
                case 2:
                    ui.listStudent(studentList);
                    break;
                case 3:
                    ui.end();

            }
        }


    }

}
