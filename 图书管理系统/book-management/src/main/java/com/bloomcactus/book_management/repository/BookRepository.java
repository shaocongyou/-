package com.bloomcactus.book_management.repository;

// 导入我们的实体类 Book
import com.bloomcactus.book_management.entity.Book;

// 导入 Spring Data JPA 的 JpaRepository 接口
import org.springframework.data.jpa.repository.JpaRepository;
// `JpaRepository`接口是Spring Data JPA提供的一个接口，它继承自`PagingAndSortingRepository`接口，并添加了一些额外的用于JPA的方法。当你的接口继承自`JpaRepository`时，Spring Data JPA会在运行时自动创建该接口的实现，并提供了许多常用的数据访问操作，如保存（save）、删除（delete）、查找（findAll, findOne）等。

// 具体来说，`JpaRepository`接口提供以下方法：

// - `List<T> findAll()`: 获取所有实体对象的列表。
// - `List<T> findAll(Sort sort)`: 获取所有实体对象的列表，并进行排序。
// - `List<T> findAllById(Iterable<ID> ids)`: 根据一组ID获取实体对象的列表。
// - `Optional<T> findById(ID id)`: 根据ID获取实体对象。
// - `boolean existsById(ID id)`: 根据ID检查实体对象是否存在。
// - `long count()`: 获取实体对象的总数。
// - `void deleteById(ID id)`: 根据ID删除实体对象。
// - `void delete(T entity)`: 删除实体对象。
// - `void deleteAll(Iterable<? extends T> entities)`: 删除一组实体对象。
// - `void deleteAll()`: 删除所有实体对象。
// - `<S extends T> S save(S entity)`: 保存实体对象。

// 此外，你还可以在继承了`JpaRepository`的接口中定义自己的查询方法，Spring Data JPA会根据方法名自动实现这些方法。例如，如果你的实体类中有一个`name`字段，你可以在接口中定义一个`findByName(String name)`方法，Spring Data JPA就会自动为你实现这个方法。

import java.util.List;


// 定义一个接口，名为 BookRepository
// 这个接口继承了 JpaRepository，表示这是一个用于操作 Book 实体的仓库
// JpaRepository 的两个泛型参数分别是：要操作的实体类和主键的类型
// JpaRepository 接口包含了许多用于操作数据库的方法，如保存、删除、查找等
// 我们可以在这个接口中自定义方法，Spring Data JPA 会自动实现这些方法
public interface BookRepository extends JpaRepository<Book, Long> {
//     `JpaRepository<Book, Long>`是Java中泛型的应用。在这里，`JpaRepository`接口接受两个参数：

// 1. `Book`：这是实体类，代表了数据库中的一个表。所有通过这个仓库接口进行的操作都将应用于这个实体类对应的表。

// 2. `Long`：这是`Book`实体的主键（ID）的类型。这意味着你的`Book`实体类中应该有一个类型为`Long`的属性作为主键，并且应该使用`@Id`注解来标注。

// 所以，`public interface BookRepository extends JpaRepository<Book, Long>`的意思是：定义一个名为`BookRepository`的接口，这个接口继承自`JpaRepository`接口，并且这个接口是用来操作主键类型为`Long`的`Book`实体的。

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

//     当你在Spring Data JPA的Repository接口中定义方法时，Spring会根据方法名生成对应的SQL查询。这是Spring Data JPA的一项强大功能，它能够根据方法名的约定来自动实现查询。

// 在你的例子中，`findByTitle(String title)`和`findByAuthor(String author)`这两个方法名遵循了Spring Data JPA的命名规则：

// - `findBy`：这是固定的部分，表示这是一个查找方法。
// - `Title`或`Author`：这是属性名，它需要与你的实体类中的属性名完全匹配（大小写敏感）。Spring Data JPA会根据这个属性名生成对应的SQL查询。

// 所以，当你调用`findByTitle(String title)`方法时，Spring Data JPA会生成一个SQL查询，这个查询会在数据库中查找所有标题（Title）等于给定字符串的图书。

// 同样，当你调用`findByAuthor(String author)`方法时，Spring Data JPA会生成一个SQL查询，这个查询会在数据库中查找所有作者（Author）等于给定字符串的图书。

// 这就是Spring Data JPA如何根据方法名知道你要查找的是标题还是作者的。



}