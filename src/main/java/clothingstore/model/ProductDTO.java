package clothingstore.model;

import java.sql.Date;
import java.text.DecimalFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    private int id;
    private String name, description;
    private int stock, unitSold;
    private String[] images, colors, size;
    private Date releasedate;
    private double discount, price, salePrice;
    private boolean status;
    private CategoryDTO category;
    private SupplierDTO supplier;
    private TypeDTO type;

    public ProductDTO(int id, String name, String description, int stock, int unitSold, String[] images,
            String[] colors, String[] size, Date releasedate, double discount, double price, boolean status, CategoryDTO category, SupplierDTO supplier, TypeDTO type) {
        this.salePrice = price;
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.unitSold = unitSold;
        this.images = images;
        this.colors = colors;
        this.size = size;
        this.releasedate = releasedate;
        this.discount = discount;
        this.price = price;
        this.status = status;
        this.category = category;
        this.supplier = supplier;
        this.type = type;
    }

    public double getSalePrice() {
        double salePrice = price - Math.round(price * discount * 100) / 100.0;
        salePrice = Math.round(salePrice * 100.0) / 100.0;
        if (discount > 0) {
            return salePrice;
        } else {
            return price;
        }
    }

}
