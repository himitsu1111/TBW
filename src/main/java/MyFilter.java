import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by secret on 17.04.2017.
 */
public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI().substring(req.getContextPath().length());
        String uri = req.getRequestURI();
        System.out.println(uri + " - was in filter");
        if (!uri.equals("/")) {
            if (path.startsWith("/index")
                    || path.startsWith("/settings")
                    || path.startsWith("/ad")
                    || path.startsWith("/login")
                    || path.startsWith("/logout")
                    || path.startsWith("/search")
                    || path.startsWith("/mail")) {

                filterChain.doFilter(servletRequest, servletResponse); // Goes to container's own default servlet.
            } else if (!uri.startsWith("/css") && !uri.startsWith("/js")) {
                servletRequest.getRequestDispatcher("/ads" + uri).forward(servletRequest, servletResponse); // Goes to controller servlet.
            }
            else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        else
            servletRequest.getRequestDispatcher("/index").forward(servletRequest, servletResponse);
//        response.sendRedirect("/index.jsp");

    }

    public void destroy() {

    }
}
