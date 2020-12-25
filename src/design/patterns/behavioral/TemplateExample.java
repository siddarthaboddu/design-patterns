package design.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class TemplateExample {
   
    class Constants {
        public static final String CSV_INPUT = "1,2,3,4,5";
        public static final String PIPE_INPUT = "10|20|30|40|50";
    }

    class Application {
        Operation operation;

        Application(){}

        Application(Operation operation){
            this.operation = operation;
        }

        public void setOperation(Operation operation){
            this.operation = operation;
        }

        public void execute(){
            this.operation.execute();
        }
    }

    abstract class Operation {
        void execute(){
            printToConsole(operation(readFromFile()));
        }
        abstract List<Integer> readFromFile();
        int operation(List<Integer> list){
            return list.stream().mapToInt(Integer::intValue).sum();
        }
        void printToConsole(int result){
            System.out.println("result of operation : " + result);
        }
    }

    class CSVOperation extends Operation {
        public List<Integer> readFromFile(){
            String input = Constants.CSV_INPUT;
            String[] arr = input.split(",");
            
            List<Integer> list = new ArrayList<>();
            for(String num : arr)
                list.add(Integer.parseInt(num));
            return list;
        }
    }

    class PipeDelimitedOperation extends Operation {
        public List<Integer> readFromFile(){
            String input = Constants.PIPE_INPUT;
            String[] arr = input.split("\\|");
            
            List<Integer> list = new ArrayList<>();
            for(String num : arr)
                list.add(Integer.parseInt(num));
            return list;
        }
    }

    void example(){

        Application app = new Application();

        app.setOperation(new CSVOperation());
        System.out.println("using CSVOperation on csv input : ");
        app.execute();
        System.out.println("using PipeDelimitedOperation on pipe input : ");
        app.setOperation(new PipeDelimitedOperation());
        app.execute();
    }

    public static void main(String[] args){
        new TemplateExample().example();
    }
}
