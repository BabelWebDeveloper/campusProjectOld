package pl.britenet.campus.service;

import pl.britenet.campus.builder.DiscountBuilder;
import pl.britenet.campus.obj.model.Discount;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class DiscountService {

    private final DatabaseService databaseService;

    public DiscountService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Discount> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM discount WHERE id=%d", id);

        try {
            Discount discount = this.databaseService.performQuery(sqlQuery, resultSet -> {

                if (resultSet.next()) {
                    int discount_percent = resultSet.getInt("percent");
                    String discount_description	 = resultSet.getString("description");

                    return new DiscountBuilder(id)
                            .setDiscountPercent(discount_percent)
                            .setDescription(discount_description)
                            .getDiscount();
                }
                return null;

            });

            return Optional.of(discount);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }

    public Discount create(Discount discount) {
        String dml = String.format("INSERT INTO discount (percent, description) VALUES (%d, '%s')",
                discount.getPercent(),
                discount.getDescription());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return discount;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM discount WHERE id=%d", id);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public Discount update(Discount discount) {
        String dml = String.format("UPDATE discount SET percent=%d, description='%s' WHERE id=%d",
                discount.getPercent(),
                discount.getDescription(),
                discount.getId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return discount;
    }

    public void display(int id){
        try {
            Discount discount = this.retrieve(id).orElseThrow();
            System.out.println(discount);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

//    public void display(){
//        for (Discount discount : this.discounts){
//            System.out.println(discount);
//        }
//    }
}
