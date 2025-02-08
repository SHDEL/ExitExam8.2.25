package Model;

import java.time.LocalDate;

public class PickledFood extends Food{
    FoodType type = FoodType.Pickled;
    public PickledFood(int num, int d, int m, int y) {
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
    // 758027
    public String checkExpire(){
        LocalDate currentDate = LocalDate.now();
        LocalDate expireDate = LocalDate.of(years, month, day);
        
        if (currentDate.getMonthValue() > expireDate.getMonthValue()){
            System.out.println("Already Expire");
            return "Already Expire";
        }
        System.out.println("Not Expire");
        return "";
    }
    
}
