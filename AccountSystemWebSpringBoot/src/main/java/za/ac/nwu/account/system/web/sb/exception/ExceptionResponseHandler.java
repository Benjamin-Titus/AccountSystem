package za.ac.nwu.account.system.web.sb.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "za.ac.nwu.account.system.web.sb.controller")
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={RuntimeException.class})
    private ResponseEntity<Object>handleGeneralexception(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        GeneralResponse<ErroResponse> generalResponse = new GeneralResponse<>(false, errorResponse);
        ResponseEntity<GeneralResponse<ErrorResponse>> response = new ResponseEntity<>(generalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

    }
}
