package org.example.ptit_cntt1_it210_session04_btth.controller;
import org.example.ptit_cntt1_it210_session04_btth.model.Book;
import org.example.ptit_cntt1_it210_session04_btth.repository.BookRepository;
import org.example.ptit_cntt1_it210_session04_btth.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    // Trả về danh sách tất cả sách
    @GetMapping("/books")
    public String showAllBooks(Model model){
        List<Book> listBook = bookService.getAllBooks();
        model.addAttribute("listBook",listBook);
        return "list_books";
    }

    @GetMapping("/books/detail/{book-id}")
    public ModelAndView showBookDetail(
            @PathVariable(name = "book-id") String bookId
    ){
        ModelAndView modelAndView  = new ModelAndView("book-detail");
        Book targetBook = bookService.getBookById(Integer.parseInt(bookId));
        modelAndView.addObject("bookTarget",targetBook);
        return modelAndView;
    }

    @GetMapping("/books/search")
    public String searchBooks(
            @RequestParam(name="title", defaultValue = "") String bookTitle,
            Model model
    ){
        List<Book> fiterBooks = bookService.searchBooksByName(bookTitle);
        model.addAttribute("listBook", fiterBooks);
        return "list_books";
    }

}
