package com.bloomcactus.book_management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@EntityScan("com.bloomcactus.book_management.entity")
class BookManagementApplicationTests {

    @Test
    void contextLoads() {
    }

}