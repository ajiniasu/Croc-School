package itog;

public class Sells {
    private int idSell;
    private int idSeller;
    private int idProduct;
    private int sold;
    private String sellData;

    public Sells(){
        this.idSell=0;
        this.idSeller=0;
        this.idProduct=0;
        this.sold=0;
        this.sellData="";
    }
    public Sells(int idS, int idSer, int idP, int CSP, String Data){
        this.idSell=idS;
        this.idSeller=idSer;
        this.idProduct=idP;
        this.sold=CSP;
        this.sellData=Data;
    }

    public int getIdSell() {
        return idSell;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getsold() {
        return sold;
    }

    public String getSellData() {
        return sellData;
    }
}
