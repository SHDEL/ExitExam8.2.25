package Model;

import java.time.LocalDate;

public class FreshFood extends Food{
    FoodType type = FoodType.Fresh;
    public FreshFood(int num, int d, int m, int y) {
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
    // 338962
    public String checkExpire(){
        LocalDate currenDate = LocalDate.now();
        LocalDate expireDate = LocalDate.of(years, month, day);
        if (currenDate.isAfter(expireDate)){
            System.out.println("Already Expire");
            return "Already Expire";

        }
        System.out.println("Not Expire");
        return "Not Expire";
    }
    
    

}
