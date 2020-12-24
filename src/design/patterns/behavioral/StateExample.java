package design.patterns.behavioral;

public class StateExample {
    
    class MusicPlayer {
        State state;

        MusicPlayer(){
            state = new ReadyState(this);
        }

        public void setState(State state){
            System.out.println(String.format("previous State: %s | new State: %s", this.state.getName(), state.getName()));
            this.state = state;
        }

        public void clickPlay(){
            System.out.println("clicked play button");
            state.clickPlay();
        }

        public void clickStop(){
            System.out.println("clicked stop button");
            state.clickStop();
        }
    }

    abstract class State{
        MusicPlayer player;
        String name;

        State(MusicPlayer player, String name){
            this.player = player;
            this.name = name;
        }

        public abstract void clickPlay();
        public abstract void clickStop();

        public String getName(){
            return name;
        }
    }

    class ReadyState extends State{
        ReadyState(MusicPlayer player){
            super(player, "READY");
        }

        public void clickPlay(){
            player.setState(new PlayingState(player));
        }
        public void clickStop(){}
    }

    class PlayingState extends State{

        PlayingState(MusicPlayer player){
            super(player, "PLAYING");
        }

        public void clickPlay(){}
        public void clickStop(){
            player.setState(new StopState(player));
        }
    }

    class StopState extends State{

        StopState(MusicPlayer player){
            super(player, "STOP");
        }

        public void clickPlay(){
            player.setState(new PlayingState(player));
        }
        public void clickStop(){}
    }

    void example(){
        MusicPlayer musicPlayer = new MusicPlayer();

        musicPlayer.clickPlay();
        musicPlayer.clickStop();
        musicPlayer.clickPlay();
        musicPlayer.clickStop();
    }

    public static void main(String[] args){
        new StateExample().example();
    }
}
