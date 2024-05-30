package com.bloomcactus.book_management.controller;
// 导入我们的 BookService
import com.bloomcactus.book_management.service.BookService;
import com.bloomcactus.book_management.entity.Book;

// 导入 Spring 的 Autowired 注解，用于自动注入依赖
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 使用 @RestController 注解，告诉 Spring 这是一个 RESTful 控制器
// 这意味着这个类的所有方法返回的结果将直接写入 HTTP 响应的 body，而不是渲染一个模板
@RestController
public class BookController {
    // 声明一个 BookService 类型的变量，用于处理业务逻辑
    // final 关键字表示这个变量一旦被初始化就不能被改变
    private final BookService bookService;

    // 使用 @Autowired 注解，告诉 Spring 自动注入 BookService 的实例
    // 这是依赖注入的一种方式，Spring 会自动找到 BookService 的实例并注入到这个构造器中
    // 构造器参数就是我们需要的依赖
    @Autowired
    public BookController(BookService bookService) {
        // 将传入的 BookService 实例赋值给我们的变量
        this.bookService = bookService;
    }

    // 添加新图书
    @PostMapping("/books")
    public Book addBook(@RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

    // 更新图书信息
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    // 删除图书
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}