public class SearchTree {
    public Node root = null;
    public static void main(String[] args) {
        System.out.println();
        SearchTree searchTree = new SearchTree();
        searchTree.insert(2);
        searchTree.insert(23);
        searchTree.insert(12);
        searchTree.insert(3);
        searchTree.insert(1);
        searchTree.insert(8);
        searchTree.insert(67);
        searchTree.insert(34);
        searchTree.insert(24);

        System.out.println("in order traversal: ");
        searchTree.inOrderTraversal();
        System.out.println();

        System.out.println("reverse order traversal: ");
        searchTree.reverseOrderTraversal();
        System.out.println();

        System.out.println("pre order traversal: ");
        searchTree.preorderTraversal();
        System.out.println();

        System.out.println("post order traversal: ");
        searchTree.postorderTraversal();
        System.out.println();

        System.out.println("search 34: " + searchTree.search(34));
        System.out.println();

        System.out.println("search 22: " + searchTree.search(22));
        System.out.println();

        System.out.println("remove 23: " + searchTree.remove(23));
        System.out.println("in order traversal: ");
        searchTree.inOrderTraversal();
        System.out.println();

        System.out.println("remove 8: " + searchTree.remove(8));
        System.out.println("in order traversal: ");
        searchTree.inOrderTraversal();
        System.out.println();

        System.out.println("Height of search tree: " + searchTree.getHeight());
        System.out.println();
    }

    public class Node 
    {
        public Node l;
        public Node r;
        public int key;

        public Node(int key, Node l, Node r)
        {
            this.key = key;
            this.l = l;
            this.r = r;
        }
        
        public Node(int key)
        {
            this(key, null, null);
        }
    }

    public void insert(Node node)
    {
        if(root == null)
        {
            root = node;
        }
        else
        {
            Node curr = root;

            while (curr != null) 
            {
                if(node.key == curr.key)
                {
                    return;
                }
                else if(node.key < curr.key)
                {
                    if(curr.l == null)
                    {
                        curr.l = node;
                        curr = null;
                    }
                    else
                    {
                        curr = curr.l;
                    }
                }
                else
                {
                    if(curr.r == null)
                    {
                        curr.r = node;
                        curr = null;
                    }
                    else
                    {
                        curr = curr.r;
                    }
                }

            }
        }

    }

    public void insert(int v)
    {
        insert(new Node(v));
    }

    public boolean remove(int v)
    {
        Node parent = null;
        Node curr = root;

        while (curr != null) 
        {
            
            if(curr.key == v)
            {
                if(curr.r == null && curr.l == null)
                {
                    if(parent == null)
                    {
                        root = null;
                    }
                    else if(parent.l == curr)
                    {
                        parent.l = null;
                    }
                    else
                    {
                        parent.r = null;
                    }

                    return true;
                }     
                else if(curr.r == null && curr.l != null)
                {
                    if(parent == null)
                    {
                        root = curr.l;
                    }
                    else if(parent.l == curr)
                    {
                        parent.l = curr.l;
                    }
                    else
                    {
                        parent.r = curr.l;
                    }
                }
                else if(curr.r != null && curr.l == null)
                {
                    if(parent == null)
                    {
                        root = curr.r;
                    }
                    else if(parent.l == curr)
                    {
                        parent.l = curr.r;
                    }
                    else
                    {
                        parent.r = curr.r;
                    }

                    return true;
                }
                else
                {
                    Node succ = curr.r;

                    while(succ.l != null)
                    {
                        succ = succ.l;
                    }

                    curr.key = succ.key;
                    parent = curr;
                    curr = curr.r;
                    v = succ.key;
                }          
            }
            else if(curr.key > v)
            {
                parent = curr;
                curr = curr.l;
            }
            else
            {
                parent = curr;
                curr = curr.r;
            }
             
        }
        
        return false;
    }

    public boolean search(int v)
    {
        Node curr = root;

        while(curr != null)
        {
            if(curr.key == v)
            {
                return true;
            }
            else if(v < curr.key)
            {
                curr = curr.l;
            }
            else
            {
                curr = curr.r;
            }
        }

        return false;
    }

    public void inOrderTraversal()
    {
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node node)
    {
        if(node != null)
        {
            inOrder(node.l);
            System.out.print(node.key + " ");
            inOrder(node.r);
        }
    }

    public void reverseOrderTraversal()
    {
        reverseOrder(root);
        System.out.println();
    }

    public void reverseOrder(Node node)
    {
        if(node != null)
        {
            reverseOrder(node.r);
            System.out.print(node.key + " ");
            reverseOrder(node.l);
        }
    }

    public void preorderTraversal()
    {
        preorder(root);
        System.out.println();
    }

    public void preorder(Node node)
    {
        if(node != null)
        {
            System.out.print(node.key + " ");
            preorder(node.l);
            preorder(node.r);
        }
    }

    public void postorderTraversal()
    {
        postorder(root);
        System.out.println();
    }

    public void postorder(Node node)
    {
        if(node != null)
        {
            postorder(node.l);
            postorder(node.r);
            System.out.print(node.key + " ");
        }
    }

    public int getHeight()
    {
        return height(root);
    }

    public int height(Node node)
    {
        if(node == null)
        {
            return -1; //height of empty tree is -1, when there is only one node in the tree the height is 0
        }
        else
        {
            int lH = height(node.l);
            int rH = height(node.r);

            return Math.max(lH, rH) + 1;
        }
    }

}
