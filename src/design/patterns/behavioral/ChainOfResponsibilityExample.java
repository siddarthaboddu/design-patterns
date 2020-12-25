package design.patterns.behavioral;

public class ChainOfResponsibilityExample {
    
    class Request{
        int val;

        public String toString(){
            return String.format("{val: %d}", val);
        }
    }

    interface Handler{
        boolean handle(Request request);
        void setNextHandler(Handler nextHandler);
    }


    abstract class ConcreteHandler implements Handler{
        Handler nextHandler;

        public void setNextHandler(Handler nextHandler){
            this.nextHandler = nextHandler;    
        }
    }

    class LoggingHandler extends ConcreteHandler{

        public boolean handle(Request request){
            System.out.println(String.format("log: [request : %s]", request.toString()));

            return nextHandler.handle(request);
        }
    }

    class ValidateRequestHandler extends ConcreteHandler{

        public boolean handle(Request request){
            if(request.val >= 0){
                System.out.println(String.format("valid request : %s", request.toString()));
                if(nextHandler == null)
                    return true;
                else
                    return nextHandler.handle(request);
            }
            else{
                System.out.println(String.format("invalid request : %s", request.toString()));
                return false;
            }
        }
    }

    class Application{
        Handler handler;

        Application(){}

        void setHandler(Handler handler){
            this.handler = handler;
        }

        void process(Request request){
            if(handler.handle(request)){
                System.out.println(String.format("request processed : %s", request.toString()));
            }
            else{
                System.out.println(String.format("request failed : %s", request.toString()));
            }
        }
    }

    void example(){

        Application app = new Application();

        Handler handler = new LoggingHandler();
        handler.setNextHandler(new ValidateRequestHandler());

        app.setHandler(handler);

        Request request1 = new Request();
        request1.val = 10;
        app.process(request1);

        Request request2 = new Request();
        request2.val = -1;
        app.process(request2);
    }

    public static void main(String[] args){
        new ChainOfResponsibilityExample().example();
    }
}
