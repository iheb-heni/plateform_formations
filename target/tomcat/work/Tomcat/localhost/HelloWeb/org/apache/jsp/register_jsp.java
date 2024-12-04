/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-12-03 19:36:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Register</title>\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: #f8f9fa;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("        .container {\r\n");
      out.write("            background: #ffffff;\r\n");
      out.write("            padding: 2rem;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            max-width: 450px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-bottom: 1.5rem;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        .form-group label {\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("        .error-message {\r\n");
      out.write("            color: #ff4d4d;\r\n");
      out.write("            font-size: 0.9rem;\r\n");
      out.write("            margin-bottom: 1rem;\r\n");
      out.write("        }\r\n");
      out.write("        button {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            background-color: #007bff;\r\n");
      out.write("            color: #ffffff;\r\n");
      out.write("            padding: 0.75rem;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("        p {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-top: 1rem;\r\n");
      out.write("        }\r\n");
      out.write("        p a {\r\n");
      out.write("            color: #007bff;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        p a:hover {\r\n");
      out.write("            text-decoration: underline;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Register</h1>\r\n");
      out.write("        <form action=\"UtilisateurController\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"register\">\r\n");
      out.write("\r\n");
      out.write("            ");
 if (request.getAttribute("error") != null) { 
      out.write("\r\n");
      out.write("                <div class=\"error-message\">");
      out.print( request.getAttribute("error") );
      out.write("</div>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group mb-3\">\r\n");
      out.write("                <label for=\"nom\">Name:</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"nom\" name=\"nom\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group mb-3\">\r\n");
      out.write("                <label for=\"email\">Email:</label>\r\n");
      out.write("                <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group mb-3\">\r\n");
      out.write("                <label for=\"password\">Password:</label>\r\n");
      out.write("                <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group mb-3\">\r\n");
      out.write("                <label for=\"role\">Role:</label>\r\n");
      out.write("                <select class=\"form-select\" id=\"role\" name=\"role\" required>\r\n");
      out.write("                    <option value=\"formateur\">Trainer</option>\r\n");
      out.write("                    <option value=\"etudiant\">Student</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <p>Already have an account? <a href=\"./login\">Login here</a></p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap JS -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
