package com.web.tornese.SpringWeb.servico;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
    public static void SetCookie(HttpServletResponse response, String key, String valor, int segundos){
        Cookie cookie = new Cookie(key, valor);
        cookie.setMaxAge(segundos);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public static String GetCookie(HttpServletRequest request, String key) {
        return Optional.ofNullable(request.getCookies())
            .flatMap(cookies -> Arrays.stream(cookies)
                .filter(cookie -> key.equals(cookie.getName()))
                .findAny()
            )
            .map(cookie -> cookie.getValue())
            .orElse(null);
    }
    
}
