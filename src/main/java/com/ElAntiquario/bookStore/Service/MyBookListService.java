package com.ElAntiquario.bookStore.Service;

import com.ElAntiquario.bookStore.Entity.Book;
import com.ElAntiquario.bookStore.Entity.MyBookList;
import com.ElAntiquario.bookStore.Repository.MyBookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService{
    @Autowired
    private MyBookListRepository myBookListRepository;


    public void saveToMyBooks(MyBookList book){
        myBookListRepository.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBookListRepository.findAll();
    }

    public void deleteMyBookById(Long id){
        myBookListRepository.deleteById(id);
    }
}
