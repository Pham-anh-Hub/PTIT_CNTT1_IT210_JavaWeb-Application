package org.example.ptit_cntt1_it210_session04_btth.service;


import org.example.ptit_cntt1_it210_session04_btth.model.Book;
import org.example.ptit_cntt1_it210_session04_btth.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Lấy tất cả sách
    public List<Book> getAllBooks(){
        return bookRepository.findAllBooks();
    }

    // Lấy sách theo ID
    public Book getBookById(int bookId){
        return bookRepository.findBookById(bookId);
    }

    // Tìm kiếm sách theo tên (tìm kiếm tương đối)
    public List<Book> searchBooksByName(String title){
        return bookRepository.searchBooksByTitle(title);
    }


}
