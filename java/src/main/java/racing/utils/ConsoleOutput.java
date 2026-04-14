package racing.utils;

import java.util.List;

public class ConsoleOutput {

   public void printlnAll(List<String> list){
       if (list == null || list.isEmpty()){
           throw new IllegalArgumentException("출력할 리스트가 null이거나 요소를 가지고 있지 않습니다.");
       }
       System.out.println(String.join("\n", list));
       System.out.println();
   }

    public void println(String value){
        if (value == null){
            throw new IllegalArgumentException("출력할 값이 null입니다.");
        }
        System.out.println(value);
    }
}
