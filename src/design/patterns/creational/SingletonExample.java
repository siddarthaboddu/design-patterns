package design.patterns.creational;


class Database{
    static Database instance;

    private Database(){}

    public static Database getInstance(){
        if(instance  == null){
            instance = new Database();
        }
        return instance;
    }
}

public class SingletonExample {
    
    void example(){
        Database dbInstance1 = Database.getInstance();
        Database dbInstance2 = Database.getInstance();

        System.out.println("dbInstance1 : " + dbInstance1.hashCode());
        System.out.println("dbInstance2 : " + dbInstance2.hashCode());
        System.out.println("dbInstance1 == dbInstance2 : " + (dbInstance1 == dbInstance2));
    }

    public static void main(String[] args){
        new SingletonExample().example();
    }
}
