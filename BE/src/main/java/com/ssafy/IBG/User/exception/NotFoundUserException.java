package com.ssafy.IBG.User.exception;

import static com.ssafy.IBG.User.UserConstant.NOTFOUND_USER_ERROR_MESSAGE;

public class NotFoundUserException extends RuntimeException{

    public NotFoundUserException(){
        super(NOTFOUND_USER_ERROR_MESSAGE);
    }
}
