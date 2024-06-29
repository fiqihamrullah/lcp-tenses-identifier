/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
 
 
import java.util.ArrayList;
import java.util.List;
 

/**
 *
 * @author Fiqih Amrullah
 */
public class Tagger 
{
    public void tokenizeAndTagKalimat(Kalimat kalimat) 
    {
        
        List<Token> listokens = new ArrayList<Token>();
        // TODO code application logic here
            MaxentTagger tagger = new MaxentTagger("models/english-left3words-distsim.tagger");
             
            List<HasWord> sent = Sentence.toWordList(kalimat.tokenize());
            List<TaggedWord> taggedSent = tagger.tagSentence(sent);
            int pos=0;
            for (TaggedWord tw : taggedSent) 
            {
               pos++;
              Token token = new Token();
              token.setSymbol(new Simbol(tw.tag()));
              token.setName(tw.word());
              token.setPosition(pos);
              listokens.add(token);
          }
           
      
            kalimat.setTokens(listokens);
        
    }
    
    
    
}
