package com.find;
import java.util.Map;
import java.util.HashMap;

public class FindDuplicateLinear {
    public static void main(String[] args) {
        int[] input_array={1,5,3,9,1,4,1,1,1,1};
        Map<Integer,Integer>duplicateMap=findDuplicate(input_array);
        duplicateMap.forEach((key,val)->{
            if(val>1){
                System.out.printf("Key=%d is duplicate=%d times",key,val);
            }
        });
    }

    private static Map<Integer, Integer> findDuplicate(int[] input_array) {
        Map<Integer,Integer>temp=new HashMap<>();
       /* Arrays.stream(input_array)
                .collect(Collectors.toMap(Function.identity(),e->1,Math::addExact));*/
        for(int i=0;i<input_array.length;i++){
             Integer value=input_array[i];
            if(temp.get(value)==null){
                    temp.put(value,1);
            }else{
                temp.computeIfPresent(value,(key,val)->val+1);
            }
        }

        return temp;
    }

}
