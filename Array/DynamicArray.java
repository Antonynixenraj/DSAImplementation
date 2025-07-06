package Array;
public class DynamicArray {
    private int arr[]=new int[10];
    private int index=-1;

    public boolean isfull(){

        return index==arr.length-1;
    }

    public boolean isEmpty(){

        return index==-1;
    }


// -------------------------- ADDING VALUES ----------------------------------------------

    public boolean append(int num){
        if(isfull())
            expandArray();

        arr[++index]=num;
        return true;
    }

    public boolean prepend(int num){
        if(isfull())
            expandArray();
        
        for (int i = index; i >= 0; i--){ 
            arr[i+1]=arr[i];
        }

        arr[0]=num;
        index++;
        return true;
            
        
    }

    public boolean insert(int ind,int value){

        if(ind<0 || index>=arr.length)
            return false;

        else if(isfull())
            expandArray();

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

// -------------------------- DELETE VALUES USING INDEX ----------------------------------------------

    public boolean deleteFirst(){
        if(isEmpty())
            return false;
        for(int i=1;i<=index;i++)
            arr[i-1]=arr[i];
        arr[index--]=0;
        if(length()<arr.length/2)
            shrinkArray();
        return true;
    }

    public boolean deleteLast(){
        if(isEmpty())
            return false;
        arr[index]=0;
        index--;
        if(length()<arr.length/2)
            shrinkArray();
        return true;
    }
    public boolean delete(int ind){
        if(index<ind || isEmpty())
            return false;

        for(int i=ind;i<=index;i++)
            arr[i]=arr[i+1];
        arr[index--]=0;
        if(length()<arr.length/2)
            shrinkArray();
        return true;
    } 

// -------------------------- REMOVE VALUES USING ELEMENT ----------------------------------------------

    public boolean remove(int value){
        if(isEmpty())
            return false;
        
        for(int i=0;i<=index;i++){
            if(arr[i]==value){
                delete(i);
                return true;
            }
        }
        if(length()<arr.length/2)
            shrinkArray();
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
        if(length()<arr.length/2)
            shrinkArray();
        return found;
    }

// -------------------------- FETCH VALUES USING INDEX ----------------------------------------------

    public int getValue(int ind){
        if(index<ind || isEmpty())
            throw new IndexOutOfBoundsException("Index "+ind+" out of bounds for length "+(index+1));
        return arr[ind];
        
        
    }

// -------------------------- ESSENTIAL METHODS ----------------------------------------------

    public void expandArray(){

        int temp[]=new int[arr.length*2];

        for(int i=0;i<this.arr.length;i++)
            temp[i]=arr[i];

        arr=temp;

    }

    public void shrinkArray(){
        int arr[]=new int[(this.arr.length/2)]; 
        for(int i=0;i<=index;i++){
            arr[i]=this.arr[i];
        }
        this.arr=arr;
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
}