package com.bloomcactus.book_management.entity;

// 导入 JPA 的注解
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
// 这些注解都是Java Persistence API (JPA)的一部分，用于将Java对象映射到数据库表：

// 1. `@Entity`: 这个注解表示该类是一个实体类，它将会被映射到数据库的一个表。每个实体类都会对应数据库中的一张表。

// 2. `@Id`: 这个注解表示该字段是实体的主键。每个实体类必须有一个主键。

// 3. `@GeneratedValue`: 这个注解用于指定主键的生成策略。`GenerationType.AUTO`表示让数据库自动决定最合适的策略。其他的策略还包括`GenerationType.IDENTITY`（使用数据库的自增功能），`GenerationType.SEQUENCE`（使用数据库的序列）和`GenerationType.TABLE`（使用一个特殊的表来保存下一个id值）。

// 4. `@Column`: 这个注解用于指定非主键字段与数据库表中的哪一列对应，以及列的属性如名字、长度等。如果省略这个注解，那么字段名就会被用作默认的列名。

// 这些注解使得我们可以在不写任何SQL代码的情况下，进行数据库的操作，大大提高了开发的效率。

import javax.validation.constraints.NotBlank;



// 使用 @Entity 注解标记这是一个实体类，JPA 将映射这个类到数据库的一个表
@Entity
public class Book {
    // @Id 注解标记这是主键
    // @GeneratedValue 注解表示主键的生成策略，这里设置为自动增长
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // 书籍的唯一标识，主键
    
    @NotBlank(message = "Title is mandatory")
    private String title;  // 书籍的标题
    @NotBlank(message = "Author is mandatory")
    private String author;  // 书籍的作者

    private Date publishedDate;
    
    // 下面是各个字段的 getter 和 setter 方法，用于获取和设置字段的值
    
    // 获取书籍的 ID
    public Long getId() {
        return id;
    }
    
    // 设置书籍的 ID
    public void setId(Long id) {
        this.id = id;
    }
    
    // 获取书籍的标题
    public String getTitle() {
        return title;
    }
    
    // 设置书籍的标题
    public void setTitle(String title) {
        this.title = title;
    }
    
    // 获取书籍的作者
    public String getAuthor() {
        return author;
    }
    
    // 设置书籍的作者
    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}