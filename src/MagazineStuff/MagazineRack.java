package src.MagazineStuff;

public class MagazineRack {
    private Link head;
    public int displayCount = 1;
    
    public MagazineRack(Link head) {
        this.head = head;
    }
    public void setHead(Link head) {
        this.head = head;
    }
    public void displayRack(Link start) {
        boolean isNotNull = true;
        
        while (isNotNull) {
            if(start.getNext() == head) {
                isNotNull = false;
                System.out.println(displayCount + " -- " + ((Magazine)start.getItem()).getName());
                displayCount++;
            }
            else {
                System.out.println(displayCount + " -- " + ((Magazine)start.getItem()).getName());
                displayCount++;
                displayRack(start.getNext());
                isNotNull = false;
            }      
        }

        
    }
    public void rDisplayRack(Link start) {
        boolean isNotStart = true;
        
        while (isNotStart) {
            if(start.getPrevious() == head) {
                isNotStart = false;
                System.out.println(displayCount + " -- " + ((Magazine)start.getItem()).getName());
                displayCount++;
            }
            else {
                System.out.println(displayCount + " -- " + ((Magazine)start.getItem()).getName());
                displayCount++;
                displayRack(start.getPrevious());
                isNotStart = false;
            }      
        }
        displayCount = 1;
        
    }

    

    
    public Link getLast(Link start) {
        if(start.getNext() == head) {
            return start;
        }
        else {
            return getLast(start.getNext());
        }
        

    }
    public Magazine chooseItem(Link start, int count) {
        if(count > 1) {
            count--;
            return chooseItem(start.getNext(), count);
            
        }
        return (Magazine)start.getItem();
        

    }
    public Magazine rChooseItem(Link start, int count) {
        if(count > 1) {
            count--;
            return chooseItem(start.getPrevious(), count);
            
        }
        return (Magazine)start.getItem();
        

    }
    public Link chooseNode(Link start, int count) {
        if(count > 1) {
            count--;
            return chooseNode(start.getNext(), count);
            
        }
        return start;
    }
    
    public void removeItem(int choice, Link head) {
        if (chooseNode(head, choice - 1).getNext().getNext() == null) {
            chooseNode(head, choice - 1).setNext(null);
        }
        else if (choice == 1) {
            setHead(chooseNode(head, choice + 1));
        }
        else {
            chooseNode(head, choice - 1).setNext(chooseNode(head, choice + 1));
        }
        
    }
    
    public Link getHead() {
        return head;
    }

}
