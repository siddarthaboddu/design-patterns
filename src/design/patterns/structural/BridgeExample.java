package design.patterns.structural;


interface Shape{
    public String getShape();
}

interface Color{
    public String getColor();
}

class Circle implements Shape{
    
    String shape = "Circle";
    Color color;

    public Circle(Color color){
        this.color = color;
    }

    public String getShape(){
        return shape;
    }
    @Override
    public String toString(){
        return String.format("shape: %s ; color : %s", getShape(), color);
    }
}

class Square implements Shape{
    
    String shape = "Square";
    Color color;

    public Square(Color color){
        this.color = color;
    }

    public String getShape(){
        return shape;
    }
    @Override
    public String toString(){
        return String.format("[shape : %s, color : %s]", getShape(), color);
    }
}

class Red implements Color{
    String color = "Red";
    
    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        return String.format("[color: %s]", getColor());
    }
}

class Blue implements Color{
    String color = "Blue";

    public String getColor(){
        return color;
    }
    
    @Override
    public String toString(){
        return String.format("[color : %s]", getColor());
    }

}

public class BridgeExample {
    
    public static void main(String[] args){
        Color redColor = new Red();
        Color blueColor = new Blue();
    
        Shape redCircle = new Circle(redColor);
        Shape blueCircle = new Circle(blueColor);
    
        Shape redSquare = new Square(redColor);
        Shape blueSquare = new Square(blueColor);
    
        System.out.println(redColor);
        System.out.println(blueColor);
        System.out.println(redCircle);
        System.out.println(blueCircle);
        System.out.println(redSquare);
        System.out.println(blueSquare);
    }

    
}
