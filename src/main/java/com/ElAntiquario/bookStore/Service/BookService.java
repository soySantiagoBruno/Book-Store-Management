package com.ElAntiquario.bookStore.Service;

import com.ElAntiquario.bookStore.Entity.Book;
import com.ElAntiquario.bookStore.Entity.MyBookList;
import com.ElAntiquario.bookStore.Repository.BookRepository;
import com.ElAntiquario.bookStore.Repository.MyBookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class BookService {

    //REPOS
    @Autowired
    private BookRepository bookRepository;



    public void save(Book book){
        bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        Book bookToGet = bookRepository.findById(id).get();
        return bookToGet ;
    }

}
