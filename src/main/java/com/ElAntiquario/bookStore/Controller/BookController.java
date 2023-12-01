package com.ElAntiquario.bookStore.Controller;

import com.ElAntiquario.bookStore.Entity.Book;
import com.ElAntiquario.bookStore.Entity.MyBookList;
import com.ElAntiquario.bookStore.Service.BookService;
import com.ElAntiquario.bookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    //Services
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;



    @GetMapping("/hola")
    @ResponseBody
    public String hola(){
        return "Hola mundo!";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @RequestMapping("/delete_register_book/{id}")
    public String deleteRegisterBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/available_books";
    }


    @GetMapping("/available_books")
    public String getAllBooks(Model model){

        List<Book> list = bookService.getAllBook(); //asigna a "list" la lista de libros guardados en la base de datos

        //inserta en el modelo esa lista y le asigna a cada item el nombre de "libro" para que después la pueda usar en el front con Thymeleaf
        model.addAttribute("book",list); //le paso el nombre del atributo y el valor (la variable list)

        return "bookList";
    }

    /* Otra forma de hacer lo anterior
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list = service.getAllBook();

        return new ModelAndView("bookList","book", list); //el primer parámetro es el front end que queremos devolver
    }*/

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks(); //asigna a "list" la lista de libros guardados en la base de datos

        //inserta en el modelo esa lista y le asigna a cada item el nombre de "libro" para que después la pueda usar en el front con Thymeleaf
        model.addAttribute("book",list); //le paso el nombre del atributo y el valor (la variable list)

        return "myBooks";
    }

    @RequestMapping("/add_to_my_books_list/{id}")
    public String addToMyBooks(@PathVariable Long id){
        Book bookToSave = bookService.getBookById(id);

        //como no puedo pasarle un tipo Book, tengo que construir un objeto de tipo MyBookList (uso el constructor y le paso las mismas propiedades del Book)
        MyBookList myBook = new MyBookList(bookToSave.getId(),bookToSave.getName(),bookToSave.getAuthor(),bookToSave.getPrice());

        myBookListService.saveToMyBooks(myBook);

        return "redirect:/available_books";
    }

    @RequestMapping("/delete_from_my_book_list/{id}")
    public String deleteFromMyBooks(@PathVariable Long id){
        myBookListService.deleteMyBookById(id);

        return "redirect:/my_books";
    }
}
