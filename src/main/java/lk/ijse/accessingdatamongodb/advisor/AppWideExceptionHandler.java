/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) IJSE-intern. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  --------------------------------------------------------------------------------------------/
 *
 */

package lk.ijse.accessingdatamongodb.advisor;

import lk.ijse.accessingdatamongodb.util.StandardLogger;
import lk.ijse.accessingdatamongodb.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 4/11/2021
 **/

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity handleException(RuntimeException ex) {
        StandardResponse response = new StandardResponse(500, "Runtime Exception", ex.getMessage());
        StandardLogger logger = new StandardLogger("error",ex.getMessage());
        LoggerHandler.handleLogger(logger);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({SQLException.class})
    public ResponseEntity sqlExceptionHandler(SQLException e){
        StandardResponse response = new StandardResponse(500, "SQLException", e.getMessage());
        StandardLogger logger = new StandardLogger("error", e.getMessage());
        LoggerHandler.handleLogger(logger);
        return new ResponseEntity(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ClassNotFoundException.class})
    public ResponseEntity classNotFoundHandler(ClassNotFoundException e){
        StandardResponse response = new StandardResponse(404, "ClassNotFoundException", e.getMessage());
        StandardLogger logger = new StandardLogger("error", e.getMessage());
        LoggerHandler.handleLogger(logger);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
