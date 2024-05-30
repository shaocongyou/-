package com.bloomcactus.book_management.service;

// 导入我们的 BookRepository
import com.bloomcactus.book_management.repository.BookRepository;
import com.bloomcactus.book_management.entity.Book;

// 导入 Spring 的 Autowired 注解，用于自动注入依赖
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// 导入 Spring 的 Service 注解，用于标识这是一个服务类
import org.springframework.stereotype.Service;

import java.util.List;

// 使用 @Service 注解，告诉 Spring 这是一个服务类，需要进行管理
@Service
public class BookService {
    // 声明一个 BookRepository 类型的变量，用于操作 Book 实体
    // final 关键字表示这个变量一旦被初始化就不能被改变
    private final BookRepository bookRepository;

    // 使用 @Autowired 注解，告诉 Spring 自动注入 BookRepository 的实例
    // 这是依赖注入的一种方式，Spring 会自动找到 BookRepository 的实例并注入到这个构造器中
    // 构造器参数就是我们需要的依赖
    @Autowired
    public BookService(BookRepository bookRepository) {
        // 将传入的 BookRepository 实例赋值给我们的变量
        this.bookRepository = bookRepository;
    }

    // 获取所有图书
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 根据书名查询图书
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // 根据作者查询图书
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    // 添加一本书
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // 更新一本书的信息
    public ResponseEntity<Book> updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublishedDate(bookDetails.getPublishedDate());
        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    // 删除一本书
    public ResponseEntity<Void> deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookRepository.delete(book);
        return ResponseEntity.ok().build(); // 返回一个状态码为200的ResponseEntity<Void>
    }
}