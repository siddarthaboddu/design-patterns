package design.patterns.behavioral;

import java.util.Stack;

public class MementoExample {
    


    class State {
        String content;
    }

    class Originator{
        State state;

        Originator(){
            this.state = new State();
        }
        public Memento save(){
            return new Memento(this.state);
        }

        public void restore(Memento memento){
            this.state = memento.getState();
        }


        class Memento{
            private State state;
    
            Memento(State state){
                this.state = state;
            }

            private State getState(){
                return this.state;
            }
        }
    }

    class Application{
        private Originator originator;
        private Stack<Originator.Memento> stack;

        Application(){
            this.originator = new Originator();
            this.stack = new Stack<>();
            originator.state.content = "initial Content";
        }

        public void setContent(String content){
            stack.push(this.originator.save());

            this.originator = new Originator();
            originator.state.content = content;
        }

        public boolean undo(){
            if(!stack.isEmpty()){
                this.originator.restore(stack.pop());
                return true;
            }
            return false;
        }

        public void print(){
            System.out.println(originator.state.content);
        }
    }

    void example(){
        Application app = new Application();
        
        for(String content : new String[]{"first", "second", "third"}){
            app.setContent(content);
        }

        app.print();
        app.undo();

        for(String content : new String[]{"four", "five", "six"}){
            app.setContent(content);
        }

        do{
            app.print();
        } while(app.undo());
    }

    public static void main(String[] args){
        new MementoExample().example();
    }
}
