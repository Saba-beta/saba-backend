package saba.example.global.error;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.filter.OncePerRequestFilter;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.SabaException;
import saba.example.global.error.exception.GlobalErrorCode;
import saba.example.global.error.response.ErrorResponse;
import saba.example.global.event.exception.model.ExceptionEvent;
import saba.example.global.util.LogUtil;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (SabaException e) {
            writeErrorResponse(response, e.getErrorProperty());
        } catch (Exception e) {
            if (e.getCause() instanceof SabaException exception) {
                writeErrorResponse(response, exception.getErrorProperty());
            } else {
                log.error(LogUtil.stackTraceToString(e));
                eventPublisher.publishEvent(ExceptionEvent.builder().request(request).exception(e).build());
                writeErrorResponse(response, GlobalErrorCode.INTERNAL_SERVER_ERROR);
            }
        }
    }

    private void writeErrorResponse(HttpServletResponse response, ErrorProperty errorProperty) throws IOException {
        response.setStatus(errorProperty.getHttpStatus().getStatusCode());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ErrorResponse errorResponse = ErrorResponse.of(errorProperty);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
