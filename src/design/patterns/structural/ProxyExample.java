package design.patterns.structural;

public class ProxyExample {
    
    interface FileReader{
        public String read();
    }

    class SimpleFileReader implements FileReader{
        public String read(){
            return "content in file";
        }
    }

    class FileReaderLoggerProxy implements FileReader{
        FileReader fileReader;
    
        FileReaderLoggerProxy(FileReader fileReader){
            this.fileReader = fileReader;
        }
        
        public String read(){
            System.out.println("reading from file...");
            String content = fileReader.read();
            System.out.println(String.format("read from file; content : [%s]", content));
            return content;
        }
    }

    void example(){
        FileReader fileReader = new SimpleFileReader();
        FileReader fileReaderLoggerProxy = new FileReaderLoggerProxy(fileReader);

        fileReaderLoggerProxy.read();
    }

    public static void main(String[] args){
        new ProxyExample().example();
    }

}
