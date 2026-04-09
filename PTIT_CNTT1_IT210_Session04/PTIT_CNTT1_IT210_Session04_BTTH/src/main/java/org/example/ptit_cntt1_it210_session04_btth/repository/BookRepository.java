package org.example.ptit_cntt1_it210_session04_btth.repository;

import org.example.ptit_cntt1_it210_session04_btth.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books;

    public BookRepository(List<Book> books) {
        this.books = new ArrayList<>(
                Arrays.asList(
                        new Book(1, "HarryPotter và hòn đá phù thủy", "J. K. Rowling" ),
                        new Book(2, "SherlockHolmes", "Arthur Conan Doyle"),
                        new Book(3, "Conan Detective", "Gosho Aoyama"),
                        new Book(4, "Tôi thấy hoa vàng trên cỏ xanh", "Nguyễn Nhật Ánh")
                )
        );
    }

    // Lấy tất cả sách
    public List<Book> findAllBooks(){
        return books;
    }
    // Lấy sách theo ID
    public Book findBookById(int bookId){
        return books.stream().filter(book -> book.getId() == bookId).findFirst().orElse(null);
    }
    // Tìm kiếm sách theo tên (tìm kiếm tương đối).
    public List<Book> searchBooksByTitle(String name){
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(name.toLowerCase())).toList();
    }
}
