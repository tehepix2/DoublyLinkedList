package src.MagazineStuff;

public class Link {
    private Object data;
    private Link nextNode;
    private Link prevNode;

    public Link(Object object, Link next, Link previous) {
        this.data = object;
        this.prevNode = previous;
        this.nextNode = next;
    }

    public Object getItem() {
        return data;
    }

    public Link getNext() {
        return nextNode;
    }

    public Link getPrevious() {
        return prevNode;
    }

    public void setNext(Link nextLink) {
        this.nextNode = nextLink;
    }

    public void setPrev(Link prevLink) {
        this.prevNode = prevLink;
    }
}
