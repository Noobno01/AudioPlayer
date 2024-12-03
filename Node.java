public class Node
{
    private String data;
    private Node nextAddress;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNextAddress() {
        return nextAddress;
    }

    public void setNextAddress(Node nextAddress) {
        this.nextAddress = nextAddress;
    }

    public Node(String data) {
        this.data = data;
        this.nextAddress = null;
    }

}
