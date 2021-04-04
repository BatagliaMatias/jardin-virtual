package telegram;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_EXCLUSIONPeer;

public class NotificationResponse {

    private Exception exception;

    public NotificationResponse(){

    }

    public boolean hasError(){
        return this.getException()!= null;
    }

    public NotificationResponse(Exception e){
        this.exception=e;
    }

    public Exception getException(){
        return this.exception;
    }
}
