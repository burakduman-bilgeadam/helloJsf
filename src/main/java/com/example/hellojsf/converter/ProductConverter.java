package com.example.hellojsf.converter;

import com.example.hellojsf.ProductBean;
import com.example.hellojsf.UserBean;
import com.example.hellojsf.model.Product;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "productConverter")
public class ProductConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext,
                              UIComponent uiComponent, String s) {
        FacesContext context = FacesContext.getCurrentInstance();
        ProductBean bean =
                (ProductBean)
                        context.getApplication()
                                .evaluateExpressionGet(context
                                        , "#{productBean}"
                                        , ProductBean.class);
        return bean.getProductList().stream()
                .filter(p -> p.getId() == Integer.parseInt(s))
                .findFirst().get();
    }

    @Override
    public String getAsString(FacesContext facesContext,
                              UIComponent uiComponent, Object product) {
       return String.valueOf(((Product)product).getId());
    }
}
