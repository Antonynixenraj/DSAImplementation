package Problems;

import java.util.LinkedHashMap;

public class Frequency {
    public static void main(String[] args) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        String str="aaazzbb";

       for (int i=0;i<str.length();i++){
           char ch=str.charAt(i);
           if(!map.containsKey(ch))
               map.put(ch,1);
           else
               map.put(ch,map.get(ch)+1);
       }
        System.out.println(map);

        int min=map.get(str.charAt(0));

        for(int i:map.values())
            min= min>i?i:min;


        char ans='\0';
        for(char i: map.keySet()){
            if(map.get(i)==min)
                ans=i;
        }
        System.out.println(ans);
    }
}
