package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
// 'HttpServlet' 인터페이스를 상속받아 'service' 메소드를 통해 'WAS'에서 전달받은 request와 response를 사용할 수 있다.
    // '@WebServlet' 어노테이션을 통해서 'Servlet'의 이름과 매핑을 간단하게 할 수 있다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);
        //req와 resp는 'WAS'에서 받은 'Http'정보이며, 이를 서블릿에서 가공하여 요청에 맞는 'html'을 클라이언트에게 제공한다.
        String username = req.getParameter("username");

        resp.setContentType("text/plain");
        // 'http' 헤더에 해당하는 타입 정보이며, 'text/plain'은 단순한 문자타입이다.
        resp.setCharacterEncoding("utf-8");
        // 'http' 헤더에 해당하며, 인코딩 형식을 정의할 수 있다.
        // 현재는 'utf-8'를 사용를 주로 사용하기 때문에 'utf-8'로 정의하였다.
        resp.getWriter().write("hello" + username);
        // 'req'에서 받은 정보에 따라 다른 결과를 만들어 클라이언트에게 제공한다.
    }
}
