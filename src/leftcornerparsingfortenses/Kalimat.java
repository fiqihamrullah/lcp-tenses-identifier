/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

import java.util.List;

/**
 *
 * @author Fiqih Amrullah
 */
public class Kalimat 
{
    private String kalimat;
    private List<Token> listword;

    public Kalimat() 
    {
        
    }

    public String getKalimat() 
    {
        return kalimat;
    }

    public void setKalimat(String kalimat) 
    {
        this.kalimat = kalimat;
    }
    
    public String[] tokenize() 
    {
       return kalimat.split(" ");    
    }

    public List<Token> getTokens() {
        return listword;
    }
    
    
    
    public void setTokens(List<Token> listword) 
    {
        this.listword = listword;
    }
            
    public Token getToken(int idx)
    {
        return listword.get(idx);
    }
    
    public int getTokenCount()
    {
        return listword.size();
    }
    
    
    
}
