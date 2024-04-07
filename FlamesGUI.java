import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

class FlamesGUI extends Thread{

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
           
        
        JFrame f=new JFrame("Flames");
        JLabel l1=new JLabel();
        l1.setText("Name One");
        l1.setBounds(50,15,100,50);
        JLabel l2=new JLabel("Name Two");
        l2.setText("Name two");
        l2.setBounds(50,105,100,50);
        JTextField tf1=new JTextField();
        JTextField tf2=new JTextField();
        JButton b=new JButton("check");        
        
        b.addActionListener(new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
               
                FlamesGUI obj=new FlamesGUI();
                
                String one=tf1.getText().trim();
                String two=tf2.getText().trim();

                if(one.length()>2 && two.length()>2)
                {
                int len=obj.len(one,two);
                String ans=obj.result(len);

                JOptionPane.showMessageDialog(f,ans);
                }
                else
                {
                    JOptionPane.showMessageDialog(f,"give correct name !");
                   
                }
            
            }
              
        }


        

        );
        tf1.setBounds(50,50,250,50);
        tf2.setBounds(50,140,250,50);
        b.setBounds(50,220,100,50);
        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(b);
       
        f.setSize(400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);


    }
}
