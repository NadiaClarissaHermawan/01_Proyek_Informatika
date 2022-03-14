package ProIF01.mainClass.error;

import ProIF01.mainClass.model.ErrorJson;
import org.apache.coyote.Response;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class InvalidEndPointHandler implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ErrorJson> handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        ErrorJson errorJson = new ErrorJson("invalid endpoint");
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return new ResponseEntity<>(errorJson, HttpStatus.METHOD_NOT_ALLOWED);
            }
        }
        return new ResponseEntity<>(errorJson, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
