// package com.bloomcactus.book_management.test;

// import com.bloomcactus.book_management.config.GlobalExceptionHandler;
// import com.bloomcactus.book_management.entity.ErrorDetails;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.validation.DataBinder;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import org.springframework.boot.autoconfigure.domain.EntityScan;


// @SpringBootTest
// @EntityScan("com.bloomcactus.book_management.entity")
// public class ApplicationIntegrationTest {
//     @Autowired
//     private GlobalExceptionHandler handler;

//     @Test
//     public void testCustomValidationErrorHandling() {
//         // 创建一个DataBinder对象
//         DataBinder binder = new DataBinder(new Object());

//         // 创建一个MethodArgumentNotValidException对象
//         MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, binder.getBindingResult());

//         // 调用customValidationErrorHandling方法
//         ResponseEntity<?> response = handler.customValidationErrorHandling(exception);

//         // 验证结果
//         assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//         assertTrue(response.getBody() instanceof ErrorDetails);
//         assertEquals("Validation Error", ((ErrorDetails)response.getBody()).getMessage());
//     }
// }