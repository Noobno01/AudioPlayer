import javax.sound.sampled.Clip;

class BST_class {

    class NodeBst
    {
        String key;
        NodeBst left, right;

        public NodeBst(String data)
        {
            key = data;
            left = right = null;
        }
    }
    NodeBst root;
    BST_class()
    {
        root = null;

    }
    void insert(String key)
    {
        root = insert_Recursive(root, key);
    }
    NodeBst insert_Recursive(NodeBst root, String key)
    {
        if (root == null)
        {
            root = new NodeBst(key);
            return root;
        }

        if (key.compareTo(root.key)<0)
            root.left = insert_Recursive(root.left, key);
        else if (key.compareTo(root.key)>0)
            root.right = insert_Recursive(root.right, key);
        return root;
    }
    void inOrder(NodeBst node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print("Now playing  " + node.key);
        Clip currentClip = BetterAudioPLayer.playMusic(node.key);
        while (currentClip.getMicrosecondLength() != currentClip.getMicrosecondPosition()) {

        }
        inOrder(node.right);
    }

    void inOrder_traversal()
    {
        inOrder(root);
    }

    void invert()
    {
        root = invert(root);
    }

    NodeBst invert(NodeBst node)
    {
        if (node == null)
            return node;

        /* recursive calls */
        NodeBst left = invert(node.left);
        NodeBst right = invert(node.right);
        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }




}
