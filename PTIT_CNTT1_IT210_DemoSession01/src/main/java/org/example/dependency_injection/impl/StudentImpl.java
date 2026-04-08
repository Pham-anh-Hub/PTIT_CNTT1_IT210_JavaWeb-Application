package org.example.dependency_injection.impl;

import org.example.dependency_injection.Student;
import org.springframework.stereotype.Component;

@Component // Không ngữ nghĩa <=> Đánh dấu đâi là bean để IoC biết và khởi tạo
public class StudentImpl implements Student {


    @Override
    public void study() {

    }

    @Override
    public void eating() {

    }
}
