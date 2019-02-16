package com.xiaojiu.annotation.annotationdemo;

import com.xiaojiu.annotation.annotationdemo.middledemo.PersonBean;
import com.xiaojiu.annotation.annotationdemo.simpledemo.User;
import com.xiaojiu.annotation.annotationdemo.simpledemo.UserCheck;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_annotation() {
//        User user = new User();
//        UserCheck.chechk(user);
//        System.out.println(user.getAge());
//        System.out.println(user.getName());
          PersonBean personBean = new PersonBean();

    }
}