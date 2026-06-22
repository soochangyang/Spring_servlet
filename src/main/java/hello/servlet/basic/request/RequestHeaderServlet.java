package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns="/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=============== REQUEST - LINE - START ==================");
        System.out.println("request.getMethod() = " + req.getMethod());     // GET
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
    }

    private static void printStartLine(HttpServletRequest req) {
        System.out.println("request.getProtocol() = " + req.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() = " + req.getScheme());     // http
        System.out.println("request.getRequestURL() = " + req.getRequestURL()); // http://localhost:8080/request-header
        System.out.println("request.getRequestURI() = " + req.getRequestURI()); // request-test
        System.out.println("request.getQueryString() = " + req.getQueryString()); // useName
        System.out.println("request.isSecure() = " + req.isSecure()); //https사용 여부
        System.out.println("request.getRemoteAddr() = " + req.getRemoteAddr());
        System.out.println("request.getRemoteHost() = " + req.getRemoteHost());
        System.out.println("request.getRemotePort() = " + req.getRemotePort());
        System.out.println("request.getRemoteUser() = " + req.getRemoteUser());
        System.out.println("request.getLocale() = " + req.getLocale());
        System.out.println("request.getLocalAddr() = " + req.getLocalAddr());
        System.out.println("request.getLocalName() = " + req.getLocalName());
        System.out.println("request.getLocalPort() = " + req.getLocalPort());
        System.out.println("=============== REQUEST - LINE - END ==================");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("=============== HEADER - START ==================");

/*        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println("headerName: " + headerName);
        }*/

        req.getParameterNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : "+ headerName));

        System.out.println("=============== HEADER - END ==================");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("=== Header 편의 조회 start ===");
        System.out.println(" [ Host 편의 조회 ] ");
        System.out.println(" request.getServerName() = " + req.getServerName()); //Host 헤더
        System.out.println(" request.getServerPort() = " + req.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println(" [ Accept-Language 편의 조회] ");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println(locale + " : " + locale));
        System.out.println("request.getLocale() = " + req.getLocale());
        System.out.println();

        System.out.println(" [ cookie 편의 조회 ] ");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();
    }
}
