package com.tasks6.rle;

public class Application
{
    public static void main(String[] args) {
        if(args.length == 0 || "".equals(args[0]))
            return;

        int buf = 1;
        String s = args[0];

        for (int i = 0; i < s.length(); i++) {
          if(i!=s.length()){
            if(s.charAt(i) == s.charAt(i+1))
                buf++;
            if(s.charAt(i) != s.charAt(i+1) && buf>1){
                while(buf>0){
                    System.out.print(s.charAt(i) + ((buf>=9)?9:buf));
                    buf-=9;
                }
                buf=1;
            }
            if(s.charAt(i) != s.charAt(i+1) && buf==1)
                System.out.print(s.charAt(i));
               
        }else if(i==s.length() && s.charAt(i) > 40 && s.charAt(i) < 123 )
            System.out.print(s.charAt(i));
       }
    }
    
}

  