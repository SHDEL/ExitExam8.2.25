package Controller;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Model.CannedFood;
import Model.Food;
import Model.FoodType;
import Model.FreshFood;
import Model.PickledFood;
import View.View;

public class Controller {
    LocalDate date = LocalDate.now();
    ArrayList<Food> arr = new ArrayList<>();
    View v = new View();
    Food foodFound;
    int cntCalculate = 0;
    //กำหนดตัวแปรสำหรับนับ รายการอาหารที่เสีย และไม่เสีย
    int freshCountExpired = 0, freshCountAvailable = 0;
    int pickledCountExpired = 0, pickledCountAvailable = 0;
    int cannedCountExpired = 0, cannedCountAvailable = 0;
    public Controller(){
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getYear());
        readCSV();
        getAllFood();
        BtnActionListener listener = new BtnActionListener(v, this);
        v.setActionListener(listener);
    }
    private void readCSV(){
        try (Scanner input = new Scanner(Paths.get("food_data.csv"));) {
            while (input.hasNext()){
                try {
                    String row = input.nextLine();
                    String [] tokens = row.split(",");
                    int idnum = Integer.parseInt(tokens[0]);
                    FoodType type = convertType(tokens[1]);
                    int day = Integer.parseInt(tokens[2]);
                    int month = Integer.parseInt(tokens[3]);
                    int years = Integer.parseInt(tokens[4]);
                    addFoodlist(idnum, type, day, month, years);
                }
                catch (Exception e){
                    // System.out.println("At row" + rownum + ", exception named " + e + "...skip");
                    continue;
                }
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    private void addFoodlist(int id, FoodType type, int day, int month, int years){
        if (type == FoodType.Fresh){
            FreshFood food = new FreshFood(id, day, month, years);
            arr.add(food);
        }
        else if (type == FoodType.Pickled){
            PickledFood food = new PickledFood(id, day, month, years);
            arr.add(food);
        }
        else if (type == FoodType.Canned){
            CannedFood food = new CannedFood(id, day, month, years);
            arr.add(food);
        }

    }
    private FoodType convertType(String str){
        if (str.equals("Fresh")){
            return FoodType.Fresh;
        }
        else if (str.equals("Pickled")){
            return FoodType.Pickled;
        }
        else if (str.equals("Canned")){
            return FoodType.Canned;
        }
        return FoodType.Error;
    }
    private void getAllFood(){
        String text = "";
        int i = 1;
        for (Food food : arr){
            text += i +  " " + food.toString() + "\n";
            System.out.println(food);
            i++;
        }
        v.getControllerData(text);
    }
    public void getViewInput(String input){
        System.out.println("Input: " + input);
        String state = verifyData(input);
        v.getControllerResponse(state);
        if (state.equals("FoodID Found")){
            calculateExpire();
        }
    }
    private void calculateExpire(){
        //นับจำนวนที่ตรวจสอบแล้ว
        cntCalculate++;
        String cntCal = "Food Checked: " + Integer.toString(cntCalculate) + "\n";
        String ans1 = "";
        String ans2 = "";
        String ans3 = "";
        ans1 = "FreshFood: " + freshCountAvailable + " available, " + freshCountExpired + " expired.";
        ans2 = "PickledFood: " + pickledCountAvailable + " available, " + pickledCountExpired + " expired.";
        ans3 = "CannedFood: " + cannedCountAvailable + " available, " + cannedCountExpired + " expired.";
        System.out.println("Calulate expire");
        //ขั้นตอนการเช็คอาหารที่เสีย และ ไม่เสีย
        try {
            if (foodFound instanceof FreshFood){
                FreshFood food = (FreshFood)foodFound;
                System.out.println(food);
                ans1 = food.checkExpire();
                if (ans1.equals("Already Expire")){
                    freshCountExpired++;
                }
                else{
                    freshCountAvailable++;
                }
            }
            else if (foodFound instanceof PickledFood){
                PickledFood food = (PickledFood)foodFound;
                System.out.println(food);
                ans2 = food.checkExpire();
                if (ans2.equals("Already Expire")){
                    pickledCountExpired++;
                }
                else{
                    pickledCountAvailable++;
                }
            }
            else{
                CannedFood food = (CannedFood)foodFound;
                System.out.println(food);
                ans3 = food.checkExpire();
                if (ans3.equals("Already Expire")){
                    cannedCountExpired++;
                }
                else{
                    cannedCountAvailable++;
                }
            }
            ans1 = "FreshFood: " + freshCountAvailable + " available, " + freshCountExpired + " expired. \n";
            ans2 = "PickledFood: " + pickledCountAvailable + " available, " + pickledCountExpired + " expired. \n";
            ans3 = "CannedFood: " + cannedCountAvailable + " available, " + cannedCountExpired + " expired. \n";
            
        } catch (Exception e) {
            // TODO: handle exception
            v.getExpireResult(cntCal , ans1, ans2, ans3);
        }
        v.getExpireResult(cntCal, ans1, ans2, ans3);
        foodFound = null;

    }
    //method สำหรับเช็คเงื่อนไข input FoodData
    private String verifyData(String input){
        if (input.length() != 6){
            System.out.println("false");
            return "FoodID must be 6 digits";
        }
        if (input.charAt(0) == '0'){
            System.out.println("false");
            return "First digit could not 0";
        }
        else{
            int id = Integer.parseInt(input);
            for (Food food : arr){
                if (id == food.getFoodId()){
                    foodFound = food;
                    System.out.println("found");
                    return "FoodID Found";
                }
            }
        }
        return "FoodID Not Found";
    }
}
