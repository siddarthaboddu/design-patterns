package design.patterns.behavioral;

public class VisitorExample {

    class Node{
        int val;
        Node child;   

        Node(int val, Node child){
            this.val = val;
            this.child = child;
        }

        Object visitor(Visitor simpleVisitor){
            return simpleVisitor.getForNode(this);
        }
    }

    interface Visitor{
    	public String getForNode(Node node);
    }
    
    class SquareBracketVisitor implements Visitor{
        public String getForNode(Node node){
            return String.format("[val: %d, child: %s]",node.val, node.child == null ? "null" : node.child.visitor(this));
        }
    }
    
    class CurlyBracketVisitor implements Visitor{
        public String getForNode(Node node){
            return String.format("{val: %d, child: %s}",node.val, node.child == null ? "null" : node.child.visitor(this));
        }
    }

    void example(){
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node node0 = new Node(0, node1);

        Visitor squareBracketVisitor = new SquareBracketVisitor();
        System.out.println(node0.visitor(squareBracketVisitor));
        
        Visitor curlyBracketVisitor = new CurlyBracketVisitor();
        System.out.println(node0.visitor(curlyBracketVisitor));
    }

    public static void main(String[] args){
        new VisitorExample().example();
    }
}
