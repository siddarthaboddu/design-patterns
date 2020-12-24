package design.patterns.behavioral;

import java.util.HashMap;
import java.util.HashSet;

public class ObserverExample {
    
    interface Publisher{
        public void subscribe(String eventType, Listener listener);
        public void unsubscribe(String eventType, Listener listener);
        public void notify(String eventType, Object data);
    }

    class EventManager implements Publisher{
        HashMap<String, HashSet<Listener>> listenerMap;

        public EventManager(){
            this.listenerMap = new HashMap<>();
        }
        
        public void subscribe(String eventType, Listener listener){
            HashSet<Listener> listeners = listenerMap.getOrDefault(eventType, new HashSet<>());
            listeners.add(listener);
            listenerMap.put(eventType, listeners);
        }

        public void unsubscribe(String eventType, Listener listener){
            if(listenerMap.containsKey(eventType)){
                listenerMap.get(eventType).remove(listener);
            }
        }

        public void notify(String eventType, Object data){
            for(Listener listener : listenerMap.get(eventType)){
                listener.update(data);
            }
        }
    }

    interface Listener{
        void update(Object data);
    }

    class SMSAlertListener implements Listener{
        String mobileNumer;

        SMSAlertListener(String customerMobileNumer){
            this.mobileNumer = customerMobileNumer;
        }

        public void update(Object data){
            System.out.println(String.format("sending SMS Alert to mobile number '%s' with message '%s'", mobileNumer, (String)data));
        }
    }

    class EmailAlertListener implements Listener{
        String emailAddress;

        EmailAlertListener(String customerEmailAddress){
            this.emailAddress = customerEmailAddress;
        }

        public void update(Object data){
            System.out.println(String.format("sending Email Alert to email address '%s' with message '%s'", emailAddress, (String)data));
        }
    }


    class Application{
        Publisher eventPublisher;
        // Application related properties

        Application(Publisher publisher){
            this.eventPublisher = publisher;
        }

        public void doNewsStuff(){
            System.out.println("doing some news related");
            eventPublisher.notify("news", "Earthquake at hyderabad, India");
        }

        public void doIPLStuff(){
            System.out.println("doing some ipl match related stuff");
            eventPublisher.notify("ipl", "RCB lost again");
        }
        // Application related methods
    }

    void example(){
        Publisher publisher = new EventManager();

        Application app = new Application(publisher);

        app.eventPublisher.subscribe("news", new SMSAlertListener("88xxxxxxxx"));
        app.eventPublisher.subscribe("news", new EmailAlertListener("test@test.com"));

        app.eventPublisher.subscribe("ipl", new SMSAlertListener("99xxxxxxxx"));
        app.eventPublisher.subscribe("ipl", new EmailAlertListener("test2@test.com"));

        app.doNewsStuff();
        app.doIPLStuff();
    }

    public static void main(String[] args){
        new ObserverExample().example();
    }
}
