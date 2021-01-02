package edu.epam.servlet.controller;

import edu.epam.servlet.validation.NumberValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "helloServlet", urlPatterns = "/hello_servlet")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(HelloServlet.class);

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<hr/>" + request.getMethod() + "<hr/>" + request.getRequestURI());

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        String strNum = request.getParameter("number");
        String name = request.getParameter("name");
        String buttonValue = request.getParameter("submit_1");
        buttonValue = buttonValue.toUpperCase(Locale.ROOT);
        if(NumberValidator.isDataValid(strNum)){
            int result = Integer.parseInt(strNum) + 11;
            request.setAttribute("res", result);

            String resultName = "Hello " + name;
            request.setAttribute("resName", resultName);

            request.setAttribute("value", buttonValue);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/main.jsp");
            dispatcher.forward(request, response);
        } else{
            logger.error(" --- Incorrect data");
            String result = "Incorrect data";
            request.setAttribute("res", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/main.jsp");
            dispatcher.forward(request, response);
        }

    }
    public void destroy(){

    }
}
