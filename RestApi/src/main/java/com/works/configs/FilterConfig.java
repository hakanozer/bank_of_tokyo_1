package com.works.configs;

import com.works.entities.Customer;
import com.works.entities.Role;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        if ( url.equals("/customer/login") ) {
            filterChain.doFilter(req, res);
        }else {
            boolean status = req.getSession().getAttribute("customer") == null;
            if (status) {
                // oturum yok!
                res.setStatus(401);
                res.setContentType("application/json");
                res.getWriter().println("{false}");
            }else {
                // oturum var!
                Customer c = (Customer) req.getSession().getAttribute("customer");
                boolean statusLogin = false;
                for (Role item : c.getRoles() ) {
                    if ( url.contains( item.getName() ) ) {
                        statusLogin = true;
                        break;
                    }
                }

                if ( statusLogin ) {
                    filterChain.doFilter(req, res);
                }else {
                    res.setStatus(403);
                    res.setContentType("application/json");
                    res.getWriter().println("{false}");
                }

            }
        }

    }

}
