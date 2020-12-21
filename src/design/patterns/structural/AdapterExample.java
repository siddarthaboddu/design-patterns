package design.patterns.structural;


class Device{
    Plug plug;

    public Device(Plug plug){
        this.plug = plug;
    }

    public void charge(){
        if(plug instanceof EUPlug){
            plug.fits();
            System.out.println("using plug for charging: " + plug);
        }
        else
            System.out.println("incompatible plug : "+ plug);
    }
}

interface Plug{
    void fits();
}

class EUPlug implements Plug{

    public void fits(){
        fitsEUSocket();
    }

    public void fitsEUSocket(){
        System.out.println("fits with EUPlug");
    }

    public String toString(){
        return "EUPlug";
    }
}

class USPlug implements Plug{

    @Override
    public void fits() {
        fitsUSSocket();
    }

    public void fitsUSSocket(){
        System.out.println("fits with EUPlug");
    }

    public String toString(){
        return "USPlug";
    }
}

class EUPlugAdapter extends EUPlug{
    USPlug usPlug;

    EUPlugAdapter(USPlug usPlug){
        this.usPlug = usPlug;
    }

    public void fitsEUSocket(){
        System.out.println("using EUPlugAdapter with plug: " + usPlug);
    }

    public String toString(){
        return "current Adapter: EUPlugAdapter is using plug: " + usPlug;
    }
}

public class AdapterExample {
 
    static void example(){
        USPlug usPlug = new USPlug();
        EUPlugAdapter adapter = new EUPlugAdapter(usPlug);
        Device device = new Device(adapter);

        device.charge();

    }

    public static void main(String[] args){
        example();
    }
}
