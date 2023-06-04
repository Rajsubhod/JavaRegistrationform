package com.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("uname");
        String usermail = request.getParameter("umail");
        String userpass = request.getParameter("upass");
        String userterms = request.getParameter("acpterms");
        // create new user object
        User p = null;
        if("on".equals(userterms)){
            p = new User(username,usermail,userpass);
        }
        boolean ans = UserDao.insertUserToDb(p);
	if(ans == true) {
            System.out.println("Successfully Added!!");
            out.print("<html><body><h1>"+"Registration Done!"+"</h1></body></html>");
	}
	else {
            System.out.println("Something Went wrong Retry!!");
            out.print("<html><body><h1>"+"Registration Done!"+"</h1></body></html>");
	}
        //out.print("<html><body><h1>"+username+" "+usermail+" "+userpass+" "+userterms+"</h1></body></html>");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
