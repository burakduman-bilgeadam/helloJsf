package com.example.hellojsf.converter;

import com.example.hellojsf.UserBean;
import com.example.hellojsf.model.User;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "userConverter")
public class UserConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx,
                              UIComponent uiComponent, String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        UserBean bean =
                (UserBean)
                        context.getApplication()
                                .evaluateExpressionGet(context
                                        , "#{userBean}"
                                        , UserBean.class);

        User user = bean.getUserList().stream().filter(
                u-> u.getId() == Integer.parseInt(id)
        ).findFirst().get();
        return user;
    }

    @Override
    public String getAsString(FacesContext facesContext,
                              UIComponent uiComponent, Object user) {
        return String.valueOf(((User)user).getId());
    }

}
