/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

 
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fiqih Amrullah
 */
public class GrammarRule 
{
    private HashMap<String, String[]> mapphrase ; 
    private HashMap<String, String[]> tenses;

    public GrammarRule() 
    {
        mappingRules();
    }
    
     
    public List<Simbol> getSimbolbyKey(String key) 
    {
          List<Simbol> listsimbol = new ArrayList<Simbol>();            
          keyloop:
          for (Map.Entry<String, String[]> entry : mapphrase.entrySet())
            {
              String keyy = entry.getKey();
            //  System.out.println(key);
              if (keyy.equals(key)) 
              {
                String value[] = entry.getValue();  
                isikeyloop:
                for(int i=0;i<value.length;i++)
                {                    
                     Simbol simb = new Simbol(value[i]);
                     simb.setType(keyy);
                     listsimbol.add(simb);                  
                   
                }
                break;
              }
            }
          return listsimbol;
    }
    
    
    public List<Simbol> getSimbolbyKey(String key,String compare)//Cocok
    {
          List<Simbol> listsimbol = new ArrayList<Simbol>();             

          keyloop:
          for (Map.Entry<String, String[]> entry : mapphrase.entrySet())
            {
              String keyy = entry.getKey();
            //  System.out.println(key);
              if (keyy.equals(key)) 
              {
                String value[] = entry.getValue();  
                isikeyloop:
                for(int i=0;i<value.length;i++)
                {
                    if (value[i].contains(compare)) 
                    {
                     Simbol simb = new Simbol(value[i]);
                     simb.setType(keyy);
                     listsimbol.add(simb);
                    }
                   
                }
                break;
              }
            } 
        return listsimbol;
    }
    
     public Simbol getSimbol(String pattern)
    {
          Simbol simbolbaru = new Simbol(pattern);
          String key ;        

          keyloop:
          for (Map.Entry<String, String[]> entry : mapphrase.entrySet())
          {
              key = entry.getKey();
              if (key.equals("O") || key.equals("A")|| key.equals("F")) {
                  continue;
              }
              //System.out.println(key);
              String value[] = entry.getValue();  
              isikeyloop:
              for(int i=0;i<value.length;i++)
              {
                  String col[] = value[i].split(" ");
                  for(int j=0;j<col.length;j++)
                  {
                      if (col[j].equals(pattern)) 
                      {
                          simbolbaru.setName(key);
                          if (j==0) 
                          {
                            break keyloop;              
                          } 
                      }
                  }
              }
          } 
          return simbolbaru;
    }
    
    private void mappingRules() 
    {
        mapphrase = new HashMap<String, String[]>();
        //Rule Coba-coba
        /*
        mapphrase.put("Sentence",new String[]{"NP VP"});
        mapphrase.put("NP",new String[]{"DT NN","NNP"});       //  
        mapphrase.put("VP",new String[]{"VBZ","VB","VBD NP","VBD"}); */
        
        
        //Rule Sebenarnya
        
        mapphrase.put("Sentence",new String[]{"S V O"});//------------------------- OK
        mapphrase.put("S",new String[]{"NN","M","PRP","NNP"}); //------------------ OK
        mapphrase.put("M",new String[]{"DT NN","DT NNS","NN NN","PRP$ NN"}); //Noun Phrase Subjek  ----- OK
        mapphrase.put("F",new String[]{"DT NN","DT NNS","DT JJS NN","NN NN","PRP$ NNP","PRP$ NN","JJ NN","DT JJ NN","NNP NNP"}); //Noun Phrase Objek ----- OK
        mapphrase.put("P",new String[]{"RB VBP","RB VB","RB VBZ","RB VBD","MD VB","VBP VBN","VBZ VBN"}); //Verb Phrase----> OK 
        mapphrase.put("V",new String[]{"VBP","VBZ","VBD","P"});//---- OK
        mapphrase.put("A",new String[]{"DT RBS","DT JJ","RBS JJ","RB JJ"});  //--------- OK Adjective Phrase
        mapphrase.put("B",new String[]{"RB RB","RB NN"}); //----------   //Adverb Phrase
        mapphrase.put("O",new String[]{"NN","PRP","RB","PRP RB","F","TO NN","RB NN","IN NN","IN NNP","IN F","TO F","A F", "A","F F","F RB","DT F","PRP F"});
    }
    
    
}
