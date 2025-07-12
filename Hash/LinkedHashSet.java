package Hash;

public class LinkedHashSet<T> {
    Entry<T>[] arr =new Entry[16];
    Entry<T> head;
   Entry<T> tail;
    int size;
    class Entry<T>{
        T val;
        Entry<T> tableNext;
        Entry<T> linkNext;
        Entry<T> linkPrev;
        Entry(T val) {
            this.val = val;
        }
    }

    public int hashCode(T val){
        return val==null?0:val.hashCode()% arr.length;
    }

    public boolean add(T val){
        Entry<T> entry=new Entry<>(val);
        int ind=hashCode(val);
        if(arr[ind]==null){
            arr[ind]=entry;
        }
        else{
            Entry<T> temp=arr[ind];
            while (temp.tableNext!=null) {
                if(val.equals(temp.val))
                        return false;
                temp = temp.tableNext;
            }
            if(val.equals(temp.val))
                return false;
            temp.tableNext=entry;
        }

        if(head==null)
            head=tail=entry;
        else{
            entry.linkPrev=tail;
            tail.linkNext=entry;
            tail=entry;
        }
        size++;
        return true;
    }
    public String toString(){
        StringBuilder str=new StringBuilder("[");
        Entry<T> temp=head;
        while(temp!=null) {
            str.append(temp.val + ", ");
            temp=temp.linkNext;
        }
        if(str.length()>1)
            str.delete(str.length()-2,str.length());
        str.append("]");
        return str.toString();
    }
    public String tableElement(){
        StringBuilder str=new StringBuilder("[");
        for(int i=0;i<arr.length;i++){
            Entry<T> temp=arr[i];
            while(temp!=null) {
                str.append(temp.val + ", ");
                temp=temp.tableNext;
            }
        }
        if(str.length()>1)
            str.delete(str.length()-2,str.length());
        str.append("]");
        return str.toString();
    }
    public boolean delete(T val){
        int ind=hashCode(val);
        Entry<T> temp=arr[ind];
        Entry<T> prev=null;

        while(temp!=null){
            if(temp.val.equals(val)){
                if(head!=temp)
                    temp.linkPrev.linkNext=temp.linkNext;

                else
                    head=head.linkNext;
                
                if(prev==null)
                    arr[ind]=null;
                else {
                    prev.tableNext=temp.tableNext;
                }
                size--;
                return true;
            }
            prev=temp;
            temp=temp.tableNext;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedHashSet<String> set=new LinkedHashSet<>();
        set.add("hello");
        set.add("Self");
        set.add("Hello");
        set.add("hello");
        set.delete("Self");
        System.out.println(set);
        System.out.println(set.tableElement());
    }
}
