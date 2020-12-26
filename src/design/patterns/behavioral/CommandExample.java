package design.patterns.behavioral;


public class CommandExample {

    class Editor {
        String content;
        private String clipboard;

        private Button copyButton;
        private Button pasteButton;
        private Button cutButton;
        private Button deleteButton;

        Editor(String content){
            this.content = content;
            this.clipboard = "";
        }

        void setCopyButton(Button copyButton){
            this.copyButton = copyButton;
        }

        void setPasteButton(Button pasteButton){
            this.pasteButton = pasteButton;
        }

        void setCutButton(Button cutButton){
            this.cutButton = cutButton;
        }

        void setDeleteButton(Button deleteButton){
            this.deleteButton = deleteButton;
        }

        void clickCopyButton(){
            this.copyButton.execute();
        }

        void clickPasteButton(){
            this.pasteButton.execute();
        }

        void clickCutButton(){
            this.cutButton.execute();
        }

        void clickDeleteButton(){
            this.deleteButton.execute();
        }

        String getClipBoard(){
            return this.clipboard;
        }
    }

    abstract class Button{
        Editor editor;
        
        Button(Editor editor){
            this.editor = editor;
        }

        abstract void execute();
    }

    class CopyButton extends Button{
        CopyButton(Editor editor){
            super(editor);

        }

        void execute(){
            editor.clipboard = editor.content;
        }
    }

    class PasteButton extends Button{
        PasteButton(Editor editor){
            super(editor);

        }

        void execute(){
            editor.content = editor.clipboard;
        }
    }

    class CutButton extends Button{
        CutButton(Editor editor){
            super(editor);
        }

        void execute(){
            editor.clipboard = editor.content;
            editor.content = "";
        }
    }

    class DeleteButton extends Button{
        DeleteButton(Editor editor){
            super(editor);
        }

        void execute(){
            editor.content = "";
        }
    }

    void example(){
        Editor editor = new Editor("");
        editor.setCopyButton(new CopyButton(editor));
        editor.setCutButton(new CutButton(editor));
        editor.setPasteButton(new PasteButton(editor));
        editor.setDeleteButton(new DeleteButton(editor));

        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.content = "Hello word";
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.clickCopyButton();
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.content = "sdfjslkdfjlskdf";
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.clickPasteButton();
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.clickCutButton();
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.content = "lolol";
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.clickDeleteButton();
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
        editor.clickPasteButton();
        System.out.println(String.format("Editor: {content: %s, clipBoard: %s}", editor.content, editor.getClipBoard()));
    }

    public static void main(String[] args){
        new CommandExample().example();
    }
}
