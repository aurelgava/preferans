package org.preferans.igra;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


import static org.preferans.igra.Akcija.*;

public class DrvoAkcija {
    private static DrvoAkcija instanca;
    private Akcija a;
    private HashMap<Akcija,DrvoAkcija> deca;
    private DrvoAkcija(){
        this.a = null;
        this.dodajDecu(DALJE,DVA,IGRA,BETL,SANS);
        {
            this.deca.get(DALJE).dodajDecu(DALJE,DVA,IGRA,BETL,SANS);
            {
                this.deca.get(DALJE).deca.get(DALJE).dodajDecu(DALJE,DVA,IGRA,BETL,SANS);
                this.deca.get(DALJE).deca.get(DVA).dodajDecu(DOBAR,TRI,IGRA,BETL,SANS);
                this.deca.get(DALJE).deca.get(IGRA).dodajDecu(DOBAR,IGRA,BETL,SANS);
                this.deca.get(DALJE).deca.get(BETL).dodajDecu(DOBAR,SANS);
                this.deca.get(DALJE).deca.get(SANS).dodajDecu(DOBAR);
            }
            this.deca.get(DVA).dodajDecu(DOBAR,TRI,IGRA,BETL,SANS);
            {
                this.deca.get(DVA).deca.get(DOBAR).dodajDecu(DOBAR,TRI,IGRA,BETL,SANS);
                this.deca.get(DVA).deca.get(TRI).dodajDecu(DOBAR,CETIRI,IGRA,BETL,SANS);
                this.deca.get(DVA).deca.get(IGRA).dodajDecu(DOBAR,IGRA,BETL,SANS);
                this.deca.get(DVA).deca.get(BETL).dodajDecu(DOBAR,SANS);
                this.deca.get(DVA).deca.get(SANS).dodajDecu(DOBAR);
            }
            this.deca.get(IGRA).dodajDecu(DOBAR,IGRA,BETL,SANS);
            {
                this.deca.get(IGRA).deca.get(DOBAR).dodajDecu(DOBAR,IGRA,BETL,SANS);
                this.deca.get(IGRA).deca.get(IGRA).dodajDecu(DOBAR,IGRA,BETL,SANS);
                this.deca.get(IGRA).deca.get(BETL).dodajDecu(DOBAR,SANS);
                this.deca.get(IGRA).deca.get(SANS).dodajDecu(DOBAR);
            }
            this.deca.get(BETL).dodajDecu(DOBAR,SANS);
            {
                this.deca.get(BETL).deca.get(DOBAR).dodajDecu(DOBAR,SANS);
                this.deca.get(BETL).deca.get(SANS).dodajDecu(DOBAR);
            }
            this.deca.get(SANS).dodajDecu(DOBAR);
            {
                this.deca.get(SANS).deca.get(DOBAR).dodajDecu(DOBAR);
            }
        }
    }

    public static DrvoAkcija getInstance() {
        if (DrvoAkcija.instanca == null){
            DrvoAkcija.instanca = new DrvoAkcija();
        }
        return instanca;
    }

    private void dodajDecu(Akcija ... a) {
        this.deca = new HashMap<>();
        for(Akcija e : a){
            this.deca.put( e , new DrvoAkcija(e) );
        }
    }

    private DrvoAkcija(Akcija akcija) {
        this.a = akcija;
    }

    // Method to get children of a specific node
    public ArrayList<Akcija> getChildrenOfNode(ArrayList<Akcija> pathToNode) {
        DrvoAkcija targetNode = findNode(pathToNode);
        ArrayList<Akcija> children = new ArrayList<>();

        if (targetNode != null) {
            for (DrvoAkcija childNode : targetNode.deca.values()) {
                children.add(childNode.a);
            }
        }

        return children;
    }

    // Helper method to find a node based on the path
    private DrvoAkcija findNode(ArrayList<Akcija> pathToNode) {
        DrvoAkcija currentNode = this;

        for (Akcija akcija : pathToNode) {
            if (currentNode.deca.containsKey(akcija)) {
                currentNode = currentNode.deca.get(akcija);
            } else {
                // Node not found
                return null;
            }
        }

        return currentNode;
    }


    //*************************************** I <3 CHATGPT **********************
    public void printTree() {
        printTreeRecursive(this, "", true);
    }

    private void printTreeRecursive(DrvoAkcija node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }

        // Print the current node
        printNode(node, prefix, isTail);
        if (node.deca == null) {
            return;
        }
        // Recursively print the children
        int childCount = node.deca.size();
        int index = 0;
        for (DrvoAkcija child : node.deca.values()) {
            boolean isLastChild = ++index == childCount;
            printTreeRecursive(child, prefix + (isLastChild ? "    " : "│   "), isLastChild);
        }
    }

    private void printNode(DrvoAkcija node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.a);

        // If you want to print additional information about the node, you can modify this method
        // For example: System.out.println(prefix + (isTail ? "└── Node: " : "├── Node: ") + node.a.getDescription());
    }


    //***************************************

}
