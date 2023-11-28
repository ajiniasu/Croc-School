package itog;

public class Product {
    private int idProduct;
    private String title;

    public Product(){
        this.idProduct=0;
        this.title="";
    }
    public Product(int id, String ProductInfo){
        this.idProduct=id;
        this.title=ProductInfo;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getTitle() {
        return title;
    }
}
