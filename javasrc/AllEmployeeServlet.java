import bean.PersonalData;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllEmployeeServlet extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response){
    try{
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      String sql = "select * from employee where not exists(select * from retirement where employee.id = retirement.id)";
      request.setAttribute("sql",sql);
      RequestDispatcher dispatch = request.getRequestDispatcher("/EmployeeServlet");
      dispatch.forward(request,response);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
