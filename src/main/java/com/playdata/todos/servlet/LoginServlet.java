package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(new UserDao().login(username,password)) { // dao에 있는 로그인을 사용하면
            resp.sendRedirect("/main");  //로그인이 되었으면 샌드리다이렉트로 보내고
            //아니먄 user
        }else resp.sendRedirect("/user"); // sendRedirect :이 페이지 자체를 넘겨버리는 것

    }
}

