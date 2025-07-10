package com.sc.ddd.unusualSpends.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

//    @Test
//    void shouldCreateObjectWithGivenValues(){
//        String userId="111";
//        String userName="Vidhi";
//        String userEmail="vidhigopale@gmail.com";
//        String userMobile="9518970490";
//
//        var user=new User("111", "Vidhi","vidhigopale@gmail.com", "9518970490");
//
//        assertEquals(userId, user.getId());
//        assertEquals(userName, user.getName());
//        assertEquals(userEmail, user.getEmail());
//        assertEquals(userMobile, user.getMobile());
//    }
//
//    @Test
//    void shouldThrowInvalidIdExceptionWhenIdIsNull(){
//        String id=null;
//        String name="Vidhi";
//        String email="vidhigopale@gmail.com";
//        String mobile="9518970490";
//        String expectedExceptionMessage="Invalid UserId: null";
//
//        var exceptionObj=assertThrows(InvalidUserIdException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidIdExceptionWhenIdIsBlank(){
//        String id=" ";
//        String name="Vidhi";
//        String email="vidhigopale@gmail.com";
//        String mobile="9518970490";
//        String expectedExceptionMessage="Invalid UserId:  ";
//
//        var exceptionObj=assertThrows(InvalidUserIdException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidNameExceptionWhenNameIsNull(){
//        String id="111";
//        String name=null;
//        String email="vidhigopale@gmail.com";
//        String mobile="9518970490";
//        String expectedExceptionMessage="Invalid UserName : null";
//
//        var exceptionObj=assertThrows(InvalidUserNameException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidNameExceptionWhenNameIsBlank(){
//        String id="111";
//        String name=" ";
//        String email="vidhigopale@gmail.com";
//        String mobile="9518970490";
//        String expectedExceptionMessage="Invalid UserName :  ";
//
//        var exceptionObj=assertThrows(InvalidUserNameException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidEmailExceptionWhenEmailIsNull(){
//        String id="111";
//        String name="Vidhi";
//        String email=null;
//        String mobile="9518970490";
//        String expectedExceptionMessage="Invalid Email Id: null";
//
//        var exceptionObj=assertThrows(InvalidEmailIdException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidEmailExceptionWhenEmailIsBlank(){
//        String id="111";
//        String name="Vidhi";
//        String email=" ";
//        String mobile="9518970490";
//        String expectedExceptionMessage="Invalid Email Id:  ";
//
//        var exceptionObj=assertThrows(InvalidEmailIdException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidMobileNumberExceptionWhenNumberIsNull(){
//        String id="111";
//        String name="Vidhi";
//        String email="vidhigopale@gmail.com";
//        String mobile=null;
//        String expectedExceptionMessage="Invalid mobile number: null";
//
//        var exceptionObj=assertThrows(InvalidMobileNumberException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidMobileNumberExceptionWhenNumberIsBlank(){
//        String id="111";
//        String name="Vidhi";
//        String email="vidhigopale@gmail.com";
//        String mobile=" ";
//        String expectedExceptionMessage="Invalid mobile number:  ";
//
//        var exceptionObj=assertThrows(InvalidMobileNumberException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
//
//    @Test
//    void shouldThrowInvalidMobileNumberExceptionWhenDigitsAreNotTen(){
//        String id="111";
//        String name="Vidhi";
//        String email="vidhigopale@gmail.com";
//        String mobile="919518970490";
//        String expectedExceptionMessage="Invalid mobile number: 919518970490";
//
//        var exceptionObj=assertThrows(InvalidMobileNumberException.class, ()->  new User(id,name,email,mobile));
//        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
//    }
}