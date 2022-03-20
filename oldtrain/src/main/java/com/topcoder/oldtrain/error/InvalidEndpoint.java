package com.topcoder.oldtrain.error;

import com.topcoder.oldtrain.model.ErrorJson;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class InvalidEndpoint implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<ErrorJson> handleError(HttpServletRequest request) {
        ErrorJson errorJson = new ErrorJson("failed when edit train");

        return new ResponseEntity<>(errorJson, HttpStatus.BAD_REQUEST);
    }
}