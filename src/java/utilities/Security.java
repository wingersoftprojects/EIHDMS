package utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class Security implements Serializable {
   private static final long serialVersionUID = 1L;
   private String Enc;
   private String Decr;
   public static String Encrypt(String DecryptedText){
       String EncryptedText = "";
       ArrayList<String> EncryptedList = new ArrayList<String>();
       int index;
       int n;
       Random rand1 = new Random();
       Random rand2 = new Random();
       try {
           if (!"".equals(DecryptedText)) {

               //1. move the decrpted text to an encrypted list in a reverse order
               for (int i = (DecryptedText.length() - 1); i >= 0; i--) {
                   EncryptedList.add("" + DecryptedText.charAt(i));
               }

               //2. Insert at 2nd(Index 1) character from the START with an integer
               EncryptedList.add(1, Integer.toString(rand1.nextInt(10)));//randon numbers from 0-to-9

               //3. Append any character between a-z
               EncryptedList.add(Security.getAlphabet(rand1.nextInt(27)));//randon numbers from 0-to-26

               //4. Insert at 1st(Index 0) character from the START with a character between a-z
               EncryptedList.add(0, Security.getAlphabet(rand1.nextInt(27)));//randon numbers from 0-to-26

               //5. Append any integer between 0-9
               EncryptedList.add(Integer.toString(rand1.nextInt(10)));//randon numbers from 0-to-9

               //6. Add random numbers on odd positions such as from ab to 1a2b
               index = 0;
               n = EncryptedList.size();
               while (n - index >= 1) {
                   EncryptedList.add(index, Integer.toString(rand1.nextInt(10)));//randon numbers from 0-to-9
                   n = EncryptedList.size();
                   index = index + 2;
               }

               //7. Add random characters on odd positions, get rand(1-25) and replace each random no by the equiv a-z
               index = 0;
               n = EncryptedList.size();
               int rd;
               while (n - index >= 1) {
                   rd = rand2.nextInt(27);//randon numbers from 0-to-26
                   EncryptedList.add(index, Security.getAlphabet(rd));
                   n = EncryptedList.size();
                   index = index + 2;
               }

               //8. Finally, move the array list to text
               for (int i = 0; i < EncryptedList.size(); i++) {
                   EncryptedText = EncryptedText + EncryptedList.get(i);
               }

               return EncryptedText;

           } else {
               return "";
           }
       } catch (Exception e) {
           System.err.println(e.getMessage());
           return "";
       }
   }
   
   public static String Decrypt(String EncryptedText){
       String DecryptedText;
       ArrayList<String> DecryptedList=new ArrayList<String>();
       ArrayList<String> TempDecryptedList=new ArrayList<String>();
       int index;
       int n;
     try{
     if(!"".equals(EncryptedText)){
       //0. move the enc text to dec list
       for(int i=0;i<EncryptedText.length();i++){
           DecryptedList.add("" + EncryptedText.charAt(i));
       }
       
       //1(X7). Pick charcaters at even points, the ones at odd points are invalid
       index=1;
       n=DecryptedList.size();
       while(index<n){
           TempDecryptedList.add(DecryptedList.get(index));
           index=index+2;
       }
       DecryptedList.clear();
       DecryptedList.addAll(TempDecryptedList);
       TempDecryptedList.clear();
       
        //2(X6). Pick integers at even points, the ones at odd points are invalid
       index=1;
       n=DecryptedList.size();
       while(index<n){
           TempDecryptedList.add(DecryptedList.get(index));
           index=index+2;
       }
       DecryptedList.clear();
       DecryptedList.addAll(TempDecryptedList);
       TempDecryptedList.clear();
       
       //3 (X5). Remove last integer
       n=DecryptedList.size();
       DecryptedList.remove(n-1);
       
       //4 (X4). Remove 1st(Index 0) character from the START
       DecryptedList.remove(0);
       
       //5 (X3). Remove last character
       n=DecryptedList.size();
       DecryptedList.remove(n-1);
       
       //6 (X2). Remove 2nd(Index 1) Integer from the START
       DecryptedList.remove(1);
       
       //7 (X1). Reverse reverse order and move to Text
       DecryptedText="";
       for(int i=(DecryptedList.size()-1);i>=0;i--){
           TempDecryptedList.add(DecryptedList.get(i));
           DecryptedText=DecryptedText+DecryptedList.get(i);
       }
       
       return DecryptedText;
     }else{
         return "";
     }
     }catch(Exception e){
        System.err.println(e.getMessage());
        return "";
    }
   }
   
   public static String getAlphabet(int i){
       String alph;
       
       if(i==0){
           alph="a";
       }else if(i==1){
           alph="a";
       }else if(i==2){
           alph="b";
       }else if(i==3){
           alph="c";
       }else if(i==4){
           alph="d";
       }else if(i==5){
           alph="e";
       }else if(i==6){
           alph="f";
       }else if(i==7){
           alph="g";
       }else if(i==8){
           alph="h";
       }else if(i==9){
           alph="i";
       }else if(i==10){
           alph="j";
       }else if(i==11){
           alph="k";
       }else if(i==12){
           alph="l";
       }else if(i==13){
           alph="m";
       }else if(i==14){
           alph="n";
       }else if(i==15){
           alph="o";
       }else if(i==16){
           alph="p";
       }else if(i==17){
           alph="q";
       }else if(i==18){
           alph="r";
       }else if(i==19){
           alph="s";
       }else if(i==20){
           alph="t";
       }else if(i==21){
           alph="u";
       }else if(i==22){
           alph="v";
       }else if(i==23){
           alph="w";
       }else if(i==24){
           alph="x";
       }else if(i==25){
           alph="y";
       }else if(i==26){
           alph="z";
       }else{
           alph="z";
       }
       
       if(i%2==0){
          alph=alph.toUpperCase();
       }else{
          alph=alph.toLowerCase();
       }
       
       return alph;
   }

    /**
     * @return the Enc
     */
    public String getEnc() {
        
        return Enc;
    }

    /**
     * @param Enc the Enc to set
     */
    public void setEnc(String Enc) {
        this.Enc = Enc;
    }

    /**
     * @return the Decr
     */
    public String getDecr() {
        return Decr;
    }

    /**
     * @param Decr the Decr to set
     */
    public void setDecr(String Decr) {
        this.Decr = Decr;
    }
}
