public class Llist
{
    private Node first;
    private int numberOfEntries;


    public Llist() {
        initialize();
    }

    public void add(String entry)
    {
        Node newNode = new Node(entry);
        if(isEmpty()) {
            first = newNode;
        }
        else {
            Node  lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextAddress(newNode);
        }
        numberOfEntries++;
    }
    public void print()
    {
        Node cur = first;
        int i =1;
        while (cur != null)
        {
            System.out.println(i+". "+cur.getData());
            cur = cur.getNextAddress();
            i++;
        }
    }
    public String remove(int pos)
    {
        if(pos>=1 && pos<= numberOfEntries)
        {
            String toReturn = null;
            if(pos ==1)
            {
                toReturn = first.getData();
                first = first.getNextAddress();

            }
            else
            {
                Node before = getNodeAt(pos-1);
                Node toRemove = before.getNextAddress();
                Node after = toRemove.getNextAddress();

                toReturn = toRemove.getData();

                before.setNextAddress(after);

            }
            numberOfEntries--;
            return toReturn;
        }
        else
        {
            throw new IndexOutOfBoundsException("Index out of bound must be from 1 to " + numberOfEntries+1);
        }
    }

    public String getEntry(int pos)
    {
        if(pos>=1 && pos<= numberOfEntries) {
            return getNodeAt(pos).getData();
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bound must be from 1 to " + numberOfEntries+1);
        }


    }

    public int getLength() {

        return numberOfEntries;
    }
    public boolean isEmpty()
    {
        return numberOfEntries ==0;
    }

    public void clear()
    {
        initialize();
    }

    private void initialize()
    {
        first = null;
        numberOfEntries = 0;
    }

    private Node getNodeAt(int givenPos)
    {
        Node curr = first;
        for (int i = 1; i < givenPos; i++)
        {
            curr = curr.getNextAddress();
        }
        return curr;

    }
}
