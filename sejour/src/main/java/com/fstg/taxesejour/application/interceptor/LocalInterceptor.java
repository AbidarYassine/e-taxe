package com.fstg.taxesejour.application.interceptor;

import com.fstg.taxesejour.infrastructure.messaging.LocalMessageReader;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Configuration
public class LocalInterceptor implements HandlerInterceptor {
    private final LocalMessageReader messageReader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        messageReader.setLocale(request.getLocale());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
