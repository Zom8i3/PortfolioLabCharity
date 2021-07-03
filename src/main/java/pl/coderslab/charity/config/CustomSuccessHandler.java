package pl.coderslab.charity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handle(request,response,authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request,HttpServletResponse response,Authentication authentication)throws IOException{
        String targetUrl = determineTargetUrl(authentication);
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }

    private String determineTargetUrl(final Authentication authentication) {

        Map<String,String> roleTargetURLMap = new HashMap<>();
        roleTargetURLMap.put("ROLE_USER","/form");
        roleTargetURLMap.put("ROLE_ADMIN","/admin");

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority a : authorities){
            String authorityName = a.getAuthority();
            if(roleTargetURLMap.containsKey(authorityName)){
                return roleTargetURLMap.get(authorityName);
            }
        }
        throw new IllegalArgumentException();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}
