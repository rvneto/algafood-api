package com.roberto.algafood.api.exceptionhandler;

import com.roberto.algafood.domain.exception.EntidadeEmUsoException;
import com.roberto.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.roberto.algafood.domain.exception.NegocioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncotradoException(EntidadeNaoEncontradaException e, WebRequest request) {
        Problem problem = createProblemBuilder(HttpStatus.NOT_FOUND, ProblemType.ENTIDADE_NAO_ENCONTRADA, e.getMessage()).build();
        return handleExceptionInternal(e, problem, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException e, WebRequest request) {
        Problem problem = createProblemBuilder(HttpStatus.CONFLICT, ProblemType.ENTIDADE_EM_USO, e.getMessage()).build();
        return handleExceptionInternal(e, problem, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException e, WebRequest request) {
        Problem problem = createProblemBuilder(HttpStatus.BAD_REQUEST, ProblemType.ERRO_NEGOCIO, e.getMessage()).build();
        return handleExceptionInternal(e, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body == null) {
            body = Problem.builder()
                    .status(status.value())
                    .title(status.getReasonPhrase())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .status(status.value())
                    .title((String) body)
                    .build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Problem problem = createProblemBuilder(HttpStatus.BAD_REQUEST,
                ProblemType.MENSAGEM_INCOMPREENSIVEL,
                "O corpo da requisição está inválido. Verifique erro de sintaxe")
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {
        return Problem.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }
}
