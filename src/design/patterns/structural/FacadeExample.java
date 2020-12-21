package design.patterns.structural;

public class FacadeExample {
    
    class Rice{}
    class Masala{}
    class Meat{}
    class Cook{
        Dish prepareDish(String dishName, Cook cook, Rice rice, Masala masala, Meat meat){
            return new Dish(dishName);
        }
    }

    class Dish{
        String dish;
        Dish(String dish){
            this.dish = dish;
        }

        public String toString(){
            return String.format("dish : %s", dish);
        }
    }

    class DishFacade{
        Dish getBiryani(){

            Rice rice = new Rice();
            Masala masala = new Masala();
            Meat meat =  new Meat();
            Cook cook = new Cook();

            Dish biryani = cook.prepareDish("biryani", cook, rice, masala, meat);

            return biryani;
        }
    }

    void example(){
        System.out.println(new DishFacade().getBiryani());
    }

    public static void main(String[] args){
        new FacadeExample().example();
    }
}
