package spell;



//option + comand+ l
public class Trie implements ITrie {

    Node root = new Node(); //object
    int NodeCount;
    int wordCount;


    public void add(String word) {
        root.add(word);
    }

    @Override
    public Node find(String word) {

        return root.find(word);
    }

    @Override
    public int getWordCount() {
        return wordCount;
    }

    @Override
    public int getNodeCount() {
        return NodeCount;
    }

    @Override
    public String toString() {

        Node word = root;
        StringBuilder sb = new StringBuilder();
	StringBuilder sb2 = new StringBuilder();
        traverseNode(word, sb, sb2);

        return sb2.toString();

    }

    public Node traverseNode(Node word, StringBuilder sb, StringBuilder sb2) {
//word is my parent
if(word.frequency >0){
System.out.println("hi");
sb2.append(sb.toString()+"\n");
}        

for (int i = 0; i < 26; i++) {
            //if node at the I exist

            if (word.nodes[i] != null) {
                //grab our first char
                char firstChar = (char) (i + 'a'); //this gives me the letter
                sb.append(firstChar); //this inserting my first char into my string builder
                //recurse on myself
                //go to every node
                traverseNode(word.nodes[i], sb, sb2);
                //remove the last word after recursion
                sb.deleteCharAt(sb.length() - 1);
            }
            //get rid of my last letter
            // cats
            //c-a-b-t

        }


        return null;
    }

    @Override
    public int hashCode() {
        return wordCount * NodeCount * 7 * 23;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Trie p = (Trie) o; // what is this doing ?
        // this.wordCount > I'm castin o into a trie

        //the object that I'm currently inside
        if (p.wordCount != this.wordCount) {
            return false;
        }
        if (p.NodeCount != this.NodeCount) {
            return false;
        }
        // create an equals method for my node class

        //calling my equals functions
        if (this.root.equals(p.root)) {
            return true;
        }
        return false;

    }

    public class Node implements INode {

        //Node[] node = new Node[26]
        //each time the constructor is called , we create a node
        Node[] nodes;
        int frequency;

        public Node() {

            nodes = new Node[26];
            NodeCount++;
        }

        public int getValue() {
            return frequency;
        }

        public void add(String word) {
            if (word.equals("")) {
                if (frequency == 0) {
                    wordCount++;
                }
                frequency++;
                return;
            }
            //gets first letter of word
            char c = word.charAt(0);
            //nodes[c - 'a'] gets index of letter

            if (nodes[c - 'a'] == null) { //gets the index of the letter
                nodes[c - 'a'] = new Node();
            }
            nodes[c - 'a'].add(word.substring(1));

        }

        public Node find(String word) {
            if ( word.equals("")){
            //we are at the end of word
                if( frequency > 0){
                    return this;
                }
                return null;
            }

            char c = word.charAt(0); //get first letter of word

            if (nodes[c - 'a'] == null ) {

                return null;
            }else {
                return nodes[c - 'a'].find(word.substring(1));
            }
        }

        public boolean equals(Node tempWord) {
            if (this.frequency != tempWord.frequency) {
                return false;
            }

            //for loop that goes trough my children
            for (int i = 0; i < 26; i++) {
                //node.array[i]

                // to myself
                if (this.nodes[i] == null && tempWord.nodes[i] != null) {

                    return false;
                }
                if (this.nodes[i] != null && tempWord.nodes[i] == null) {
                    return false;
                }
                if (this.nodes[i] != null && tempWord.nodes[i] != null) {
                    //this is comparing my n1 with n2
                    if (this.nodes[i].equals(tempWord.nodes[i]) == false) {
                        return false;
                    }
                }
            }
            return true;
        }


    }

}




