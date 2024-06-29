/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

 
 
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import javax.swing.JTextArea;

/**
 *
 * @author Fiqih Amrullah
 */
public class LeftCornerParser 
{
    private Stack<Token> RHS;
    private Stack<String> LHS;
    private Stack<String> LHSPrediction;
    private Simbol prevsimb;
    private JTextArea jTxtLogResult;
    private GrammarRule grammarRule;
    private HashMap<String,String> historymap;
    private String currentTokenString;
    private boolean hasCetak;
    
    private int nbenar;

    public LeftCornerParser() 
    {
        LHS= new Stack<String>();
        LHSPrediction= new Stack<String>();
        grammarRule = new GrammarRule();
        historymap = new HashMap<String, String>();
        currentTokenString = "";
        prevsimb = new Simbol("");
    }    
    
    private void translateSymbol(Kalimat kalimat)
    {
        for(int i=0;i<kalimat.getTokenCount();i++)
        {
            Token token= kalimat.getToken(i);
            if (token.getPosition()>1 && token.getSymbol().getName().equals("NN"))
            {
               //  token.getSymbol().setName("NNO");
            }
        }        
    }
    
    public void setLogger(JTextArea jTxtLogResult)
    {
        this.jTxtLogResult = jTxtLogResult;
    }
    
    private void appendText(String log)
    {
         
         if (!currentTokenString.equals("Final")) 
           {             
              jTxtLogResult.append(log  + "\n");
           }
         
          if (currentTokenString.equals("Final"))
          {
            //  if (hasCetak==false) {
              //    hasCetak=true;
                   jTxtLogResult.append(log  + "\n");
             // }    
          } 
           
        
         
    }
    
    private void addToRHS(List<Token> listokens) 
    {
        RHS = new Stack<Token>();
        for(int i=listokens.size()-1;i>=0;i--)
        {
            RHS.add(listokens.get(i));
        }
    }
    
    private void printStringVector(String s[]) 
    {
        for(int i=0;i<s.length;i++)
        {
            System.out.print(s[i]);System.out.print(" ");
        }
        System.out.println();
    }
    
    public boolean isSentence() 
    {
        return currentTokenString.equals("Final");
    }
    
    private void parseTopDown(List<Simbol> listsimbol,int level ) 
    {
          if (currentTokenString.equals("Final")) {
              return;
          }
          
        
     
          for(int i=0;i<listsimbol.size();i++)
          {
              String h = listsimbol.get(i).getName();
              System.out.println("Rule Sekarang >>>> " + h + " ----- Level " + String.valueOf(level));
              appendText("Rule Sekarang >> " + h);
              String hs[] = h.split(" ");         
              //printStringVector(hs);
              boolean cocok= false;
              int nseb=0;
              for(int j=0;j<hs.length;j++)
              {
                  System.out.println("---> " + hs[j] + " Vs "  + currentTokenString);
                  appendText("---> " + hs[j] + " Vs "  + currentTokenString);
                  if (level==1) {
                      nseb = nbenar;
                  }
                  if (hs[j].equals(currentTokenString)) 
                  {
                       //Jika Match
                      prevsimb = new Simbol(hs[j]);
                      System.out.println("Cocok Pada '" + currentTokenString +"'");   
                      appendText("Cocok Dilanjutkan Ke Token/Tagger Berikutnya..");
                      RHS.pop();
                      nbenar++;
                      if (!RHS.empty()) 
                      {
                          cocok=true;
                          currentTokenString = RHS.peek().getSymbol().getName();     
                          appendText("Selanjutnya -> '" + currentTokenString + "'");
                          System.out.println("Selanjutnya '" + currentTokenString +"'"); 
                      }
                      else
                      {                          
                           currentTokenString="Final";
                          
                          
                      }
                      
                  }else{
                      List<Simbol> listsimbolx = grammarRule.getSimbolbyKey(hs[j]);
                      appendText("[Tidak Cocok]");
                      System.out.println("Tidak Cocok"); 
                      if (listsimbolx.size()!=0) 
                      {
                         appendText("Lanjut ke turunan " + hs[j]);
                         System.out.println("Lanjut ke turunan " + hs[j]); 
                         parseTopDown(listsimbolx,level+1);
                      }else{
                         appendText("'" + hs[j] + "' adalah Simbol Terminal");
                         System.out.println(hs[j] + " adalah Simbol Terminal.. - Ke-" + j);  
                         if (!hs[j].equals(prevsimb.getName())) 
                         { 
                            break;    
                         }else {
                             appendText(hs[j] + " Sama dengan Sebelumnya " + prevsimb.getName());
                             System.out.println(hs[j] + " Sama dengan Sebelumnya " + prevsimb.getName());  
                         }
                          
                         
                      }                   
                  }
                  
                  if (level==1) 
                  {
                      if (nseb==nbenar)
                      {
                         break;           
                      }
                      
                      if (currentTokenString.equals("Final") &&  j==0)
                      {
                          System.out.println("--------------------------------- MMMMMMMMMMMMMMAAAAAAAAASSSSSUUUUUUUUUUUUUUUUKKKKKKKKKK-----------");
                          currentTokenString ="NonFinal";
                          break;
                      }
                  }
                  
                  if (currentTokenString.equals("Final")) {
                      break;
                  }
                  
              }
              
               if (currentTokenString.equals("Final")) {
                      break;
                  }
              
          }   
          
          
          
    }
    
    private void parse(Simbol simbol)
    {
        //bottom up first
        String result="";
        String prev = simbol.getName();
        while (!result.equals("Sentence"))
        {   
          Simbol simbolbaru = grammarRule.getSimbol(simbol.getName());    
          appendText(simbol.getName() + " Reduce to " + simbolbaru.getName());
          System.out.println(simbol.getName() + " Reduce to " + simbolbaru.getName()); 
          result = simbolbaru.getName();   
          if (!result.equals("Sentence"))
          {
            if (!result.equals(simbol.getName())) 
            {
              LHS.pop();
              LHS.push(simbolbaru.getName());
              System.out.println("-----> " + simbolbaru.getName());
              historymap.put(simbolbaru.getName(), simbol.getName());
              simbol.setName(simbolbaru.getName());      
             
            }else
             {
              RHS.pop();            
              Token token = RHS.peek();
              LHS.push(token.getSymbol().getName());
              String newSimbol="";
              while (!LHS.isEmpty())
              {
                 newSimbol = LHS.pop() + " " + newSimbol; 
                 System.out.println("Simbol : " + newSimbol);
              }
              simbol.setName(newSimbol.trim()); 
             }
            }
        }     
        
        //Get LHSPredicition S-> NP VP
        List<Simbol> listsimbol = grammarRule.getSimbolbyKey(result);
        convertToLHSPrediction(listsimbol.get(0));
        System.out.println(listsimbol.size() + " " + listsimbol.get(0).getName());        
        
        
        String newSimbol="";
        String sebelum="";
        while (!LHS.isEmpty())
        {
            newSimbol = LHS.pop() + " " + newSimbol; 
            System.out.println("Simbol : " + newSimbol);
            sebelum = prev ;;//historymap.get(newSimbol.trim());
            System.out.println("Simbol Sebelum : " + sebelum);
        }
        currentTokenString = sebelum;
        historymap.clear();
        nbenar=0;
        parseTopDown(listsimbol,1);
       
        
         if (!currentTokenString.equals("Final")) 
           {
            appendText("Kalimat Tidak Diterima..");
            System.out.println("Kalimat Tidak Diterima.."); 
           }else{
            appendText("Kalimat Diterima..");
            System.out.println("Kalimat Diterima.."); 
         }
        
        simbol.setName(prev);
       
        
        
        
    }
    
    public void convertToLHSPrediction(Simbol simbol) 
    {
         String name[]  = simbol.getName().split(" ");
         for(int i=name.length-1;i>=0;i--)
         {
             LHSPrediction.push(name[i]);
         }
        
    }
    
    public void doLeftCornerParsing(Kalimat kalimat)
    {
        hasCetak = false;
       
        appendText("------ Hasil Tagging ---------");
        for(int i=0;i<kalimat.getTokenCount();i++)
        {
            Token token = kalimat.getToken(i);
            appendText(token.getName() + "-->" + token.getSymbol().getName());
        }
     
        appendText("------ Mulai Parsing ---------");
        translateSymbol(kalimat);
        addToRHS(kalimat.getTokens());     
       
        Token token = RHS.peek();
        LHS.push(token.getSymbol().getName());
        parse(token.getSymbol());
      
    }
}
