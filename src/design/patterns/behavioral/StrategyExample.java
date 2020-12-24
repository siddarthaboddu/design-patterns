package design.patterns.behavioral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StrategyExample {
    
    class Application{
        List<Integer> data;
        ListStrategy listStrategy;

        Application(List<Integer> data){
            this.data = data;
        }

        public void setListStrategy(ListStrategy listStrategy){
            this.listStrategy = listStrategy;
        }

        public void execute(){
            System.out.println(listStrategy.execute(data));
        }
    }

    interface ListStrategy{
        public List<Integer> execute(List<Integer> list);
    }

    class AscendingOrderList implements ListStrategy{
        public List<Integer> execute(List<Integer> list){
            List<Integer> result = new ArrayList<>(list);
            Collections.sort(result);
            return result;
        }
    }

    class DescendingOrderList implements ListStrategy{
        public List<Integer> execute(List<Integer> list){
            List<Integer> result = new ArrayList<>(list);
            Collections.sort(result, Collections.reverseOrder());
            return result;
        }
    }

    class RandomOrderList implements ListStrategy{
        public List<Integer> execute(List<Integer> list){
            List<Integer> result = new ArrayList<>(list);
            Collections.shuffle(result);
            return result;
        }
    }

    void example(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add(random.nextInt(100));
        
        Application app = new Application(list);

        app.setListStrategy(new AscendingOrderList());
        app.execute();

        app.setListStrategy(new DescendingOrderList());
        app.execute();

        app.setListStrategy(new RandomOrderList());
        app.execute();

    }

    public static void main(String[] args){
        new StrategyExample().example();
    }
}
