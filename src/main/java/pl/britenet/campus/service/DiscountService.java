package pl.britenet.campus.service;

import pl.britenet.campus.builder.DiscountBuilder;
import pl.britenet.campus.builder.ProductBuilder;
import pl.britenet.campus.obj.model.Discount;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class DiscountService {

    private final DatabaseService databaseService;

    public DiscountService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Discount> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM discount WHERE id=%d", id);
        Discount discount = this.databaseService.performQuery(sqlQuery, resultSet -> {

            if (resultSet.next()) {
                int discount_percent = resultSet.getInt("discount_percent");
                String discount_description	 = resultSet.getString("discount_description");

                return new DiscountBuilder(id)
                        .setDiscountPercent(discount_percent)
                        .setDescription(discount_description)
                        .getDiscount();
            }
            return null;

        });

        return Optional.of(discount);
    }

    public Discount create(Discount discount) {
        String dml = String.format("INSERT INTO discount (discount_percent, discount_description) VALUES (%d, '%s')",
                discount.getDiscount_percent(),
                discount.getDiscount_description());

        this.databaseService.performDML(dml);
        return discount;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM discount WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public Discount update(Discount discount) {
        String dml = String.format("UPDATE discount SET discount_percent=%d, discount_description='%s' WHERE id=%d",
                discount.getDiscount_percent(),
                discount.getDiscount_description(),
                discount.getId());

        this.databaseService.performDML(dml);
        return discount;
    }

    public void display(int id){
        Discount discount = this.retrieve(id).orElseThrow();
        System.out.println(discount);
    }

//    public void display(){
//        for (Discount discount : this.discounts){
//            System.out.println(discount);
//        }
//    }
}
