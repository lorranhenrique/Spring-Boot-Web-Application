package com.web.tornese.SpringWeb.servico.autenticacao;

import org.springframework.web.servlet.HandlerInterceptor;

import com.web.tornese.SpringWeb.servico.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

    String usuarioId = CookieService.GetCookie(request, "usuarioId");

    if (usuarioId != null && !usuarioId.isEmpty()) {
        System.out.println("Usuário autenticado, cookie encontrado: " + usuarioId);
        return true;
    }

    System.out.println("Usuário não autenticado, redirecionando para login.");
    response.sendRedirect("/login");
    return false;
}

}
