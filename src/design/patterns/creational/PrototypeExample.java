package design.patterns.creational;

public class PrototypeExample {

    interface Prototype{
        public Object clone();
    }

    abstract class Human {
        public String feature;

        public Human(String feature){
            this.feature = feature;
        }

        public Human(Human other){
            this.feature = other.feature;
        }

    }

    class Person extends Human implements Prototype{
        public String name;
        public int age;
        private String personalSecret;

        public Person(String name, int age, String personalSecret, String feature){
            super(feature);

            this.name = name;
            this.age = age;
            this.personalSecret = personalSecret;
        }

        public Person(Person other){
            super((Human) other);
            this.name = other.name;
            this.age = other.age;
            this.personalSecret  = other.personalSecret;
        }

        @Override
        public String toString(){
            return String.format("[[name: %s, age: %d, personalSecret: %s], feature: %s]", name, age, personalSecret, feature);
        }

        @Override
        public Object clone(){
            return new Person(this);
        }

    }

    void example() {
        Person person = new Person("william", 30, "private_secret", "feature");
        Person personClone = (Person) person.clone();

        System.out.println("person: " + person);
        System.out.println("personClone: " + personClone);
    }

    public static void main(String[] args){
        PrototypeExample prototypeExample = new PrototypeExample();
        prototypeExample.example();
    }

}
