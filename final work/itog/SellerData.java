package itog;

import java.util.List;

public class SellerData {
    private List<Seller> listSeller;

    public List<Seller> getListSeller() {
        return listSeller;
    }

    public void setListSeller(List<Seller> v) {
        this.listSeller = v;
    }

    public Seller[] getSellers() {
        // Преобразование списка в массив
        return listSeller.toArray(new Seller[0]);
    }
}

