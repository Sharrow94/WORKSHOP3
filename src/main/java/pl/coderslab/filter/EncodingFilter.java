package pl.coderslab.filter;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/*")
public class EncodingFilter implements Filter {
    private String charsetEncoding = "utf-8";
    private String contentType = "text/html";
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        if (!((HttpServletRequest) request).getRequestURI().matches(".*(css|js|jpg|jpeg|png)")) {
            request.setCharacterEncoding(charsetEncoding);
            response.setContentType(contentType);
            response.setCharacterEncoding(charsetEncoding);
        }
        filterChain.doFilter(request, response);
    }
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {
    }
}
