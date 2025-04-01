package br.notificaai.application.adapters.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.ConstraintViolation;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponse<T> {

    private String message;
    private boolean success;
    private Map<String, String> errors;
    private T data;

    public HttpResponse(String message) {
        this.success = true;
        this.message = message;
        this.errors = null;
        this.data = null;
    }

    // Construtor para dados genéricos (como o token)
    public HttpResponse(T data) {
        this.success = true;
        this.message = null;
        this.errors = null;
        this.data = data;
    }

    // Novo construtor que recebe tanto o data quanto success
    public HttpResponse(T data, boolean success) {
        this.success = success;
        this.message = (String) data;
        this.errors = null;
        this.data = null;
    }



    public HttpResponse(Set<? extends ConstraintViolation<?>> violations) {
        this.success = false;
        this.message = "Erro(s) de validação";
        this.errors = violations.stream()
                .collect(Collectors.toMap(
                        v -> v.getPropertyPath().toString(),  // Nome do campo
                        ConstraintViolation::getMessage,      // Mensagem de erro
                        (msg1, msg2) -> msg1 + ", " + msg2    // Para evitar conflitos se houver múltiplos erros no mesmo campo
                ));
        this.data = null;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }

}
