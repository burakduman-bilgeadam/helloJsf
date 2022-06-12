package com.example.hellojsf;

import com.example.hellojsf.model.Product;
import com.example.hellojsf.utils.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

// product crud(create, read, update,delete) işlemleri
// product model id, serinum, name, price
// not: postconst ve constru farkı
// Mesaj türleri FacesMessage.SEVERITY_ERROR
// scope lar
// converter
// menü ekleme -> sayfa geçişleri
//"/xxx/yyy.xhtml?faces-redirect=true"
// birbiri içerisinden bean çağırma
// popup açma
// RequestContext.getCurrentInstance().execute("PF('bpAracSorgulamaWidgetVar').show()");
// backendden update
// RequestContext context = RequestContext.getCurrentInstance();
// context.update("bpKullaniciFormId:bppanel");

/* PostConstruct
    - @PostConstruct yönteminde
    Bean tamamen başlatıldıktan sonra bağımlılıkları kullanabilirsiniz.
    - @PostConstruct yönteminde bean lifecycle'ında sadece birkez
    çağıralacağını garanti eder. Constructer da durumlara göre birden
    fazla olabilir.
 */
@ManagedBean //named
@SessionScoped
public class ProductBean {
    private Product product;
    private List<Product> productList;

    @PostConstruct
    public void init(){
        this.product = new Product();
        this.productList = new ArrayList<>();
    }

    public void addProduct(){
        this.productList.add(this.product);
        this.product = new Product();
        MessageUtil.message(FacesMessage.SEVERITY_INFO,
                "Başarılı","Kayıt Eklendi.");
    }

    public void editProduct(){
        this.product = new Product();
    }

    public void deleteProduct(Product p){
        this.productList.remove(p);
    }

    public void selectProduct(Product p){
        this.product = p;
    }

    public void clearForm(){
        this.product = new Product();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
