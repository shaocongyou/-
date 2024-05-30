// package com.bloomcactus.book_management.test;

// import com.bloomcactus.book_management.config.GlobalExceptionHandler;
// import com.bloomcactus.book_management.entity.ErrorDetails;
// import org.springframework.mock.web.MockHttpServletRequest;
// import org.springframework.validation.BeanPropertyBindingResult;
// import org.springframework.validation.FieldError;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.ServletRequestDataBinder;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// public class CustomValidationErrorHandlingTest {
//     @Test
//     public void testCustomValidationErrorHandling() {
//         // 创建一个MockHttpServletRequest对象
//         MockHttpServletRequest request = new MockHttpServletRequest();

//         // 创建一个ServletRequestDataBinder对象
//         ServletRequestDataBinder binder = new ServletRequestDataBinder(new Object(), "target");

//         // 创建一个BeanPropertyBindingResult对象
//         BeanPropertyBindingResult result = new BeanPropertyBindingResult(binder.getTarget(), binder.getObjectName());

//         // 创建一个FieldError对象，并添加到BindingResult对象中
//         FieldError error = new FieldError("target", "field", "defaultMessage");
//         result.addError(error);

//         // 创建一个MethodArgumentNotValidException对象
//         MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, result);

//         // 创建一个GlobalExceptionHandler对象
//         GlobalExceptionHandler handler = new GlobalExceptionHandler();

//         // 调用customValidationErrorHandling方法
//         ResponseEntity<?> response = handler.customValidationErrorHandling(exception);

//         // 验证结果
//         assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//         assertTrue(response.getBody() instanceof ErrorDetails);
//         assertEquals("Validation Error", ((ErrorDetails)response.getBody()).getMessage());
//     }
// }