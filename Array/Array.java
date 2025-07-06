package DataStructuresImplementation.Array;
public class Array {
    private int arr[]=new int[10];
    private int index=-1;
    public boolean isfull(){
        return index==arr.length-1;
    }
    public boolean isEmpty(){
        return index==-1;
    }
    public boolean append(int num){
        if(isfull())
            return false;

        arr[++index]=num;
        return true;
    }
    public boolean prepend(int num){
        if(isfull())
            return false;
        
        for (int i = index; i >= 0; i--){ 
            arr[i+1]=arr[i];
        }

        arr[0]=num;
        index++;
        return true;
            
        
    }
    public boolean insert(int ind,int value){

        if(isfull()||ind<0 || index>=arr.length)
            return false;

        else if(ind>=index){
            append(value);
            return true;
        }

        
        for(int i=index;i>=ind;i--)
            arr[i+1]=arr[i];

        arr[ind]=value;
        index++;
        return true;
        
    }
    public boolean deleteFirst(){
        if(isEmpty())
            return false;
        for(int i=1;i<=index;i++)
            arr[i-1]=arr[i];
        arr[index--]=0;
        return true;
    }
    public boolean deleteLast(){
        if(isEmpty())
            return false;
        arr[index]=0;
        index--;
        return true;
    }
    public boolean delete(int ind){
        if(index<ind || isEmpty())
            return false;

        for(int i=ind;i<=index;i++)
            arr[i]=arr[i+1];
        arr[index--]=0;

        return true;
    } 
    public boolean remove(int value){
        if(isEmpty())
            return false;
        
        for(int i=0;i<=index;i++){
            if(arr[i]==value){
                delete(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeAll(int value){
        if(isEmpty())
            return false;
        
        boolean found=false;
        for(int i=0;i<=index;i++){
            if(arr[i]==value){
                delete(i);
                found=true;
            }
        }
        return found;
    }
    public int getValue(int ind){
        if(index<ind || isEmpty())
            throw new IndexOutOfBoundsException("Index "+ind+" out of bounds for length "+(index+1));
        return arr[ind];
        
        
    }
    public String toString(){
        StringBuffer s=new StringBuffer("[");
        for (int i = 0; i <= index; i++) {
            s.append(arr[i]);
            if(i!=index)
                s.append(", ");
        }
        s.append("]");
        return new String(s);
    }
    public int length(){
        return index+1;
    }
    
    public static void main(String[] args) {
        Array arr=new Array();
        arr.append(7);
        arr.append(78);
        arr.append(34);
        
        arr.prepend(4);
        arr.prepend(489);
       arr.insert(0, 300);
       arr.append(300);
        arr.append(67);
        arr.append(77);
        arr.append(78);
        System.out.println(arr.isfull());



        //System.out.println(arr);
        arr.removeAll(300);

         arr.prepend(4);
        arr.prepend(489);
       arr.insert(0, 300);
       arr.append(300);
       arr.append(300);
        System.out.println(arr.isfull());



    System.out.println(arr.arr.length);


        System.out.println(arr);
        System.out.println(arr.getValue(9));

        System.out.println(java.util.Arrays.toString(arr.arr));
        
    }
    
}
