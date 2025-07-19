package Hash;

public class HashSet {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    int size;

    Node[] arr =new Node[16];
    public int hashValue(int val){
        return val%arr.length;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public boolean add(int val){
        if ((double)size>0.75* arr.length)
            expandArray();
        int ind=hashValue(val);
        Node temp=arr[ind];
        if(temp==null){ // If arr is empty
            arr[ind]=new Node(val);
            size++;
            return true;
        }
        else{
            while(temp.next!=null) {
                if (temp.val==val)
                    return false;
                temp = temp.next;
            }
            if (temp.val==val)  return false;
            temp.next=new Node(val);
            size++;
            return true;
        }
    }
    public boolean delete(int val){
        Node temp=arr[hashValue(val)];
        if (temp==null) return false;
        if(temp.val==val){
            arr[hashValue(val)]=temp.next;
            size--;
            return true;
        }
        Node prev=null;
        while(temp!=null){
            if(temp.val==val){
                prev.next=temp.next;
                size--;
                return true;
            }
            prev=temp;
            temp=temp.next;
        }
        return false;
    }
    public boolean contains(int val){
        Node temp=arr[hashValue(val)];
        while (temp!=null){
            if(temp.val==val)
                return true;
            temp=temp.next;
        }
        return false;
    }

    public void expandArray(){
        size=0;
        Node[] oldArr=arr;
        arr=new Node[oldArr.length*2];
        for(int i = 0; i < oldArr.length; i++) {
            Node temp=oldArr[i];
            while (temp!=null) {
                add(temp.val);
                temp=temp.next;
            }
        }
    }
    public String toString(){
        StringBuilder str=new StringBuilder("[");
        for (int i=0;i<arr.length;i++){
            Node temp=arr[i];
            while(temp!=null){
                str.append(temp.val+", ");
                temp=temp.next;
            }
        }
        if (str.length()!=1)
            str.delete(str.length()-2,str.length());
        str.append("]");
        return str.toString();
    }
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            Node temp=arr[i];
            System.out.print(i+": ");
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashSet set=new HashSet();
        set.add(16);
        set.add(0);
        set.add(32);
        set.add(64);
        System.out.println(set.contains(64));
        set.delete(64);
        System.out.println(set.contains(64));

//        set.print();
        System.out.println(set);


    }
}
