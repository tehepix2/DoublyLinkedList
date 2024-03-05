package src.MagazineStuff;

public class Link {
    private Object data;
    private Link nextNode;

    public Link(Object object, Link next) {
        this.data = object;
        this.nextNode = next;
    }

    public Object getItem() {
        return data;
    }

    public Link getNext() {
        return nextNode;
    }

    public void setNext(Link nextLink) {
        this.nextNode = nextLink;
    }
}
