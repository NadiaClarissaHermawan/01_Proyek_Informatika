package com.topcoder.oldtrain.error;

import com.topcoder.oldtrain.model.ErrorJson;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Controller
public class InvalidEndpoint implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<ErrorJson> handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        //System.out.println("masuk error");
        ErrorJson errorJson = new ErrorJson("invalid endpoint");
        if (status != null) {
            //System.out.println("masuk if");
            Integer statusCode = Integer.valueOf(status.toString());
            System.out.println(statusCode);
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return new ResponseEntity<>(errorJson, HttpStatus.METHOD_NOT_ALLOWED);
            }
            else if (statusCode== HttpStatus.BAD_REQUEST.value()){
                System.out.println("jackpot");
                ErrorJson response= new ErrorJson("failed when edit train");
                return new ResponseEntity<>(response, BAD_REQUEST);
            }

        }
        return new ResponseEntity<>(errorJson, HttpStatus.METHOD_NOT_ALLOWED);
    }
}