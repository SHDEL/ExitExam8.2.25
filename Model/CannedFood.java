package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CannedFood extends Food{
    FoodType type = FoodType.Canned;
    public CannedFood(int num, int d, int m, int y) {
        super(num, d, m, y);
        //TODO Auto-generated constructor stub
    }
    @Override
    public int getDay() {
        // TODO Auto-generated method stub
        return super.getDay();
    }
    @Override
    public int getFoodId() {
        // TODO Auto-generated method stub
        return super.getFoodId();
    }
    @Override
    public int getMonth() {
        // TODO Auto-generated method stub
        return super.getMonth();
    }
    @Override
    public int getYears() {
        // TODO Auto-generated method stub
        return super.getYears();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", type=" + this.type + "]";
    }
    public FoodType getType(){
        return this.type;
    }
    public String checkExpire(){
        LocalDate currentDate = LocalDate.now();
        LocalDate endofYear = LocalDate.of(this.years, 12, 31);
        LocalDate expireDate = endofYear.plusMonths(9);
        System.out.println("CurrentDate: " + currentDate);
        System.out.println("ExpireDate: " + expireDate);
        if (currentDate.isAfter(expireDate)){
            System.out.println("Already Expire");
            return "Already Expire";
        }
        System.out.println("Not Expire");
        return "Not Expire";
    }
    
}
