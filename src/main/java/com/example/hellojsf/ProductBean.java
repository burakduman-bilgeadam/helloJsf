package com.example.hellojsf;

import com.example.hellojsf.model.Product;
import com.example.hellojsf.model.User;
import com.example.hellojsf.utils.MessageUtil;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

// product crud(create, read, update,delete) işlemleri
// product model id, serinum, name, price
// not: postconst ve constru farkı +
// Mesaj türleri FacesMessage.SEVERITY_ERROR +
// scope lar +
// converter +
// menü ekleme -> sayfa geçişleri +
//"/xxx/yyy.xhtml?faces-redirect=true" +
// birbiri içerisinden bean çağırma
// popup açma+
// backendden update+

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

    private Product selectedProduct;

    private Product selectedDropdownProduct;
    private List<Product> productList;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private List<User> userList;

    private User selectedUser;
    private String console;
    private List<String> consoleList;

    @PostConstruct
    public void init(){
        fillConsoleList();
        this.product = new Product();
        this.productList = new ArrayList<>();
    }

    public void fillConsoleList(){
        consoleList = new ArrayList<>();
        consoleList.add("PS4");
        consoleList.add("Wii");
        consoleList.add("XBOX");
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

    public void deleteProduct(){
        this.productList.remove(this.selectedProduct);
        PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('deleteProductWidget').hide();");
        current.ajax().update("dataTableId");
        /*FacesContext.getCurrentInstance()
                .getPartialViewContext().getRenderIds()
                .add("dataTableId");*/
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

    public void setProductForDelete(Product p) {
        this.selectedProduct = p;
        PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('deleteProductWidget').show();");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String productPage(){
        Product p = new Product();
        p.setId(1);
        p.setName("Çay");
        p.setPrice(60);
        p.setSerialNumber("213123");
        productList.add(p);

        this.userList=userBean.getUserList();

        return "product.xhtml?faces-redirect=true";
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public List<String> getConsoleList() {
        return consoleList;
    }

    public void setConsoleList(List<String> consoleList) {
        this.consoleList = consoleList;
    }

    public Product getSelectedDropdownProduct() {
        return selectedDropdownProduct;
    }

    public void setSelectedDropdownProduct(Product selectedDropdownProduct) {
        this.selectedDropdownProduct = selectedDropdownProduct;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
