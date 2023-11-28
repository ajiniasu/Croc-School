package itog;

public class SellerHasProduct {
    private int idSeller;
    private int idProduct;
    private int count;
    private int price;

    public SellerHasProduct(){
        this.idSeller=0;
        this.idProduct=0;
        this.count=0;
        this.price=0;
    }
    public SellerHasProduct(int idS, int idP, int CP, int PP){
        this.idSeller=idS;
        this.idProduct=idP;
        this.count=CP;
        this.price=PP;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getcount() {
        return count;
    }

    public int getprice() {
        return price;
    }
}
