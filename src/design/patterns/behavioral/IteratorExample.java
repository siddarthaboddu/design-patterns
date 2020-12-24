package design.patterns.behavioral;

import java.util.Random;

public class IteratorExample {
    
    interface Iterator{
        int getNext();
        boolean hasMore();
    }

    interface List{
        Iterator createForwardIterator();
        Iterator createBackwardIterator();
        Iterator createRandomIterator();
    }

    class ArrayList implements List {
        int[] arr;
        int size;
        
        ArrayList(int[] arr){
            this.arr = arr;
            this.size = arr.length;
        }
        
        ArrayList(int size){
            this.size = size;
            arr = new int[size];
        }

        public Iterator createForwardIterator(){
            int[] newArr = arr.clone();
            return new ForwardIterator(newArr);
        }

        public Iterator createBackwardIterator(){
            int[] newArr = arr.clone();
            return new BackwardIterator(newArr);
        }

        public Iterator createRandomIterator(){
            int[] newArr = arr.clone();
            return new RandomIterator(newArr);
        }
    }

    class ForwardIterator implements Iterator{
        int[] arr;
        int size;
        int currPos;

        ForwardIterator(int[] arr){
            this.arr = arr;
            this.size = arr.length;
            this.currPos = 0;
        }

        public int getNext(){
            if(currPos >= size){
                throw new RuntimeException("No More Elements");
            }
            return arr[currPos++];
        }

        public boolean hasMore(){
            return currPos < size;
        }
    }

    class BackwardIterator implements Iterator{
        int[] arr;
        int size;
        int currPos;

        BackwardIterator(int[] arr){
            this.arr = arr;
            this.size = arr.length;
            this.currPos = this.size - 1;
        }

        public int getNext(){
            if(currPos < 0){
                throw new RuntimeException("No More Elements");
            }
            return arr[currPos--];
        }

        public boolean hasMore(){
            return currPos >= 0;
        }
    }

    class RandomIterator implements Iterator{
        int[] arr;
        int size;
        int currPos;

        RandomIterator(int[] arr){
            this.arr = arr;
            this.size = arr.length;
            this.currPos = 0;

            shuffle(arr);
        }

        public int getNext(){
            if(currPos >= size){
                throw new RuntimeException("No More Elements");
            }
            return arr[currPos++];
        }

        public boolean hasMore(){
            return currPos < size;
        }

        private void shuffle(int[] arr){
            int n = arr.length;
            Random random = new Random();

            for(int i=0;i<n;i++){
                int pos = random.nextInt(n);
                swap(arr, i, pos);
            }
        }
        
        private void swap(int[] arr, int pos1, int pos2){
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }
    }

    void example(){
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        List list = new ArrayList(arr);

        Iterator forwardIterator = list.createForwardIterator();
        System.out.print("Forward Iterator : ");
        while(forwardIterator.hasMore()){
            System.out.print(forwardIterator.getNext());
            if(forwardIterator.hasMore())
                System.out.print(", ");
        }

        System.out.print("\n_______________\n");

        Iterator backwardIterator = list.createBackwardIterator();
        System.out.print("Backward Iterator : ");
        while(backwardIterator.hasMore()){
            System.out.print(backwardIterator.getNext());
            if(backwardIterator.hasMore())
                System.out.print(", ");
        }

        System.out.print("\n_______________\n");

        Iterator randomIterator = list.createRandomIterator();
        System.out.print("Random Iterator : ");
        while(randomIterator.hasMore()){
            System.out.print(randomIterator.getNext());
            if(randomIterator.hasMore())
                System.out.print(", ");
        }

    }
    
    public static void main(String[] args){
        new IteratorExample().example();
    }
}
