import java.util.*;

public class Flames {

    public int len(String nameOne,String nameTwo){
       
        String maxS="";
        String smaS="";

        if(nameOne.length()>nameTwo.length())
        {
            maxS=nameOne;
            smaS=nameTwo;
        }
        else
        {
            maxS=nameTwo;
            smaS=nameOne;
        }

        String[] a=maxS.split("");
        String[] b=smaS.split("");

        int flag=0;

        while(flag<smaS.length())
        {
            for(int i=0;i<maxS.length();i++)
            {
                if(b[flag].equals(a[i]))
                {
                    b[flag]="/";
                    a[i]="/";
                    break;
                }
            }
            flag++;
        }
        
        ArrayList<String> al=new ArrayList<>();

        for(String i:a)
        {
           if(i.equals("/"))
           {
            continue;
           }else
           {
              al.add(i);  
           }
        }
        
        for(String i:b)
        {
           if(i.equals("/"))
           {
            continue;
           }else
           {
              al.add(i);  
           }
        }

        return al.size();
    }

    public String result(int len)
    {

        ArrayList<String> gameG=new ArrayList<>();
        gameG.add("F");
        gameG.add("L");
        gameG.add("A");
        gameG.add("M");
        gameG.add("E");
        gameG.add("S");
        
        ArrayList<String> s=new ArrayList<>();
        
      
       int flag2=0;

       for(int i=0;i<5;i++){

           s.removeAll(s);

           int flag=0;

          while(flag<len)
          {
            if(flag2==gameG.size()-1)
            {
                s.add(gameG.get(flag2));
                flag2=0;
            }
            else
            {
                s.add(gameG.get(flag2));
                flag2++;
            }
         
            flag++;
        }

        int r=gameG.indexOf(s.get(s.size()-1));

        if(r+1==gameG.size())
        {
           flag2=0;
        }
        else
        {
            flag2=r;
        }

        gameG.remove(r);
     }

       return gameG.get(0).toString();

    }

    public static void main(String[] args) {
       
        Flames obj=new Flames();

        int len=obj.len("jeevanantham","sivapriya");
        System.out.println(obj.result(len));
        
    }
}