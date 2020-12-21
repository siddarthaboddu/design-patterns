package design.patterns.structural;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    List<TreeNode> children;

    TreeNode(){
        children = new ArrayList<>();
    }

    TreeNode(int value){
        this.value = value;
        children = new ArrayList<>();
    }

    void addChild(TreeNode child){
        if(children == null) children = new ArrayList<>();
        children.add(child);
    }

    int getValue(){
        return value;
    }

    int TreeValue(){
        int result = value;

        for(TreeNode child : children)
            result += child.TreeValue();

        return result;
    }

}

public class CompositeExample {

    public static void main(String[] args){
        
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(10);
        TreeNode g = new TreeNode(10);

        d.addChild(a);
        d.addChild(b);
        e.addChild(c);
        g.addChild(d);
        g.addChild(e);
        g.addChild(f);

        System.out.println("a : "+a.TreeValue());
        System.out.println("b : "+b.TreeValue());
        System.out.println("c : "+c.TreeValue());
        System.out.println("d : "+d.TreeValue());
        System.out.println("e : "+e.TreeValue());
        System.out.println("f : "+f.TreeValue());
        System.out.println("g : "+g.TreeValue());

    }
}
