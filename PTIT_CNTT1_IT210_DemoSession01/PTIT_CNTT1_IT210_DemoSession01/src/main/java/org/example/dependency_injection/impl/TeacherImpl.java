package org.example.dependency_injection.impl;

import org.example.dependency_injection.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherImpl implements Teacher {
    @Override
    public void testing() {
        System.out.println("Giảng viên giao bài kiểm tra");
    }

    @Override
    public void teaching() {

    }
}
