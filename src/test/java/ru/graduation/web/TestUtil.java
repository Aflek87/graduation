package ru.graduation.web;

import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

public class TestUtil {

    public static String getContent(ResultActions action) throws UnsupportedEncodingException {
        return action.andReturn().getResponse().getContentAsString();
    }

    public static ResultActions print(ResultActions action) throws UnsupportedEncodingException {
        System.out.println(getContent(action));
        return action;
    }

}
