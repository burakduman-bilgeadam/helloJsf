package com.example.hellojsf.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtil {
    public static void message(FacesMessage.Severity messageStatus,
                               String header, String body){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(
                messageStatus,
                header,
                body));
    }
}
