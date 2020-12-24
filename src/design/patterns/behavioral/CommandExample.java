package design.patterns.behavioral;

public class CommandExample {
    
    class Button{
        Command command;
        String name;
        
        Button(Command command, String buttonName){
            this.command = command;
            this.name = buttonName;
        }

        void click(){
            command.execute();
        }
    }

    class GUI{
        Button copyButton;
        Button pasteButton;
        Button cutButton;
        Button deleteButton;


        void clickCopy(){
            copyButton.click();
        }
        void clickPaste(){
            pasteButton.click();
        }
        void cutButton(){
            pasteButton.click();
        }
        void deleteButton(){
            deleteButton.click();
        }

    }

    abstract class Command{
        GUI gui;
        Service service;

        Command(GUI gui, Service service){
            this.gui = gui;
            this.service = service;
        }

        abstract void execute();
    }

    class CopyCommand extends Command{

        public CopyCommand(GUI gui, Service service){
            super(gui, service);
        }
        public void execute(){
            service.copy(this);
        }
    }

    class PasteCommand extends Command{
        public PasteCommand(GUI gui, Service service){
            super(gui, service);
        }
        public void execute(){
            service.paste(this);
        }
    }

    class CutCommand extends Command{
        public CutCommand(GUI gui, Service service){
            super(gui, service);
        }
        public void execute(){
            service.cut(this);
        }
    }

    class DeleteCommand extends Command{
        public DeleteCommand(GUI gui, Service service){
            super(gui, service);
        }
        public void execute(){
            service.delete(this);
        }
    }

    class Service{
        void copy(Command command){
        }
        
        void paste(Command command){
        }

        void cut(Command command){
        }

        void delete(Command command){
        }
    }


    void example(){

    }

    public static void main(String[] args){
        new CommandExample().example();
    }
}
