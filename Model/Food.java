package Model;

public class Food {
    int id;
    int day;
    int month;
    int years;
    

    public Food(int num, int d, int m, int y){
        this.id = num;
        this.day = d;
        this.month = m;
        this.years = y;
    }
    public int getFoodId(){
        return this.id;
    }
    public int getDay(){
        return this.day;
    }
    public int getYears(){
        return this.years;
    }
    public int getMonth(){
        return this.month;
    }
    @Override
    public String toString() {
        return "Food [id=" + id + ", day=" + day + ", month=" + month + ", years=" + years;
    }
    
    
    
}
