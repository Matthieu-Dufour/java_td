/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dufour76u
 */
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException{
    
    private static final long serialVersionID = 123456789;
    
    public NotFound(String message){
        super(message);
    }
    
    public NotFound(String message, Throwable cause){
        super(message, cause);
    }
}
