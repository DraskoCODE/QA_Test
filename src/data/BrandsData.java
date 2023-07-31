package data;

import models.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandsData {

    public List<String> returnListBrands() {
        List<String> listBrands = new ArrayList<>();
        listBrands.add("Nike");
        listBrands.add("Reebok");

        return listBrands;
    }

    public List<Brand> returnBrands() {
        List<Brand> listBrands = new ArrayList<>();
        listBrands.add(new Brand("NIKE"));
        listBrands.add(new Brand("Reebok"));


        return listBrands;
    }

}
