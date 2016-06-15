package filter;
 
import controllers.LoginController;
import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
/**
 * Filter checks if LoginBean has loginIn property set to true.
 * If it is not set then request is being redirected to the login.xhml page.
 * 
 * @author itcuties
 *
 */
public class FilterLogin implements Filter {
 
  @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("authenticated") != null || req.getRequestURI().endsWith("login.xhtml")) {
            chain.doFilter(request, response);
            //System.out.println("authenticated");
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
           
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}
