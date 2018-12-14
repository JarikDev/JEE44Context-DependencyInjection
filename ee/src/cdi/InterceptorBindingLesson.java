package cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("interceptorBinding")
public class InterceptorBinding extends HttpServlet {
    @Inject
    InterceptorServicee interceptorServicee;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        interceptorServicee.doJob();
    }
}
@javax.interceptor.InterceptorBinding



class InterceptorOnee {
    @AroundInvoke
    private Object AroundInvoke(InvocationContext context) throws Exception {
        System.out.println("InterceptorOne");
        return context.proceed();
    }
}

class InterceptorTwoo {
    @AroundInvoke
    private Object AroundInvoke(InvocationContext context) throws Exception {
        System.out.println("InterceptorTwo");
        return context.proceed();
    }
}

class InterceptorThreee {
    @AroundInvoke
    private Object AroundInvoke(InvocationContext context) throws Exception {
        System.out.println("InterceptorThree");
        return context.proceed();
    }
}

class InterceptorFourr {
    @AroundInvoke
    private Object AroundInvoke(InvocationContext context) throws Exception {
        System.out.println("InterceptorFour");
        return context.proceed();
    }
}

@Interceptors({cdi.InterceptorOnee.class, cdi.InterceptorThreee.class, cdi.InterceptorFourr.class})
class InterceptorServicee {
    @Interceptors({cdi.InterceptorTwoo.class})
    public void doJob() {
        System.out.println("Do job");
    }
}


