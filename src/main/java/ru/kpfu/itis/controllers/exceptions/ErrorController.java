package ru.kpfu.itis.controllers.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {
    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exception(Throwable throwable) {
        logger.error("Exception during execution of SpringSecurity application", throwable);

        ModelAndView modelAndView = new ModelAndView("error");
        String errorMessage = (throwable != null ? throwable.toString() : "Unknown error");

        modelAndView.addObject("errorMessage", errorMessage);

        return modelAndView;
    }
}
