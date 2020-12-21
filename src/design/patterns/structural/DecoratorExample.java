package design.patterns.structural;

import java.util.Base64;


interface FileReader{
    String read();
    boolean write(String content);
}

class Base64FileDecorator implements FileReader{
    FileReader fileReader;

    Base64FileDecorator(FileReader fileReader){
        this.fileReader = fileReader;
    }

    public String read(){
        return new String(Base64.getDecoder().decode(fileReader.read()));
    }

    public boolean write(String content){
        return fileReader.write(Base64.getEncoder().encodeToString(content.getBytes()));
    }

}

class SimpleFileReader implements FileReader{

    String content = "";

    public String read(){
        return content;
    }

    public boolean write(String content){
        this.content = content;
        return true;
    }
}

public class DecoratorExample {
    
    public static void main(String[] args){

        SimpleFileReader simpleFileReader = new SimpleFileReader();
        Base64FileDecorator base64FileDecorator = new Base64FileDecorator(simpleFileReader);

        String input = "wow this is a great input string";

        base64FileDecorator.write(input);

        System.out.println("content stored in file : " + simpleFileReader.content);
        System.out.println(String.format("input: {%s} ; readFromFile: {%s}", input, base64FileDecorator.read()));
    }
}
