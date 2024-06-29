/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

/**
 *
 * @author Fiqih Amrullah
 */
public class TensesIdentifier
{
    public static int UNIDENTIFIED_TENSE=0;   
    public static int PRESENT_TENSE_NOMINAL=1;    
    public static int PRESENT_TENSE_VERBAL=2;    
    public static int PRESENT_PERPECT_NOMINAL=3;    
    public static int PRESENT_PERPECT_VERBAL=4;     
    public static int PAST_TENSE_NOMINAL=5; 
    public static int PAST_TENSE_VERBAL=6;    
    public static int FUTURE_TENSE_NOMINAL=7; 
    public static int FUTURE_TENSE_VERBAL=8;    
    
    
    Kalimat kalimat;

    public TensesIdentifier(Kalimat kalimat) 
    {
        this.kalimat = kalimat;
    }
    
    public int IsTense() 
    {
        int t=UNIDENTIFIED_TENSE;   
        boolean bVBD = false,bVBP =false,bVBN = false,bMD=false;
        boolean bNominal=false;
         
        boolean bTobe = false;
        for(int i=0;i<kalimat.getTokenCount();i++)
        {
            
            if (kalimat.getToken(i).getSymbol().getName().equals("VBD")) 
            {
                bVBD = true;
                String tobe = kalimat.getToken(i).getName();
                if (tobe.equals("was") || tobe.equals("were"))
                {
                    bNominal =true;
                }
            }
            
            if (kalimat.getToken(i).getSymbol().getName().equals("VBP") || kalimat.getToken(i).getSymbol().getName().equals("VBZ") || kalimat.getToken(i).getSymbol().getName().equals("VB")) 
            {
                bVBP = true;
                String tobe = kalimat.getToken(i).getName();
                if (tobe.equals("am") || tobe.equals("is") || tobe.equals("are") ) 
                {
                    bNominal = true;
                }
               
            }            
            
            if (kalimat.getToken(i).getSymbol().getName().equals("VBN")) 
            {
                bVBN = true;
                String tobe = kalimat.getToken(i).getName();
                if (tobe.equals("been") ) 
                {
                    bNominal = true;
                }               
            }
            
             if (kalimat.getToken(i).getSymbol().getName().equals("MD")) 
            {
                bMD = true;
                String tobe = kalimat.getToken(i+1).getName();
                if (tobe.equals("be") ) 
                {
                    bNominal = true;
                }               
            }
            
            
            
        }
        
        if (bVBP) {
            if (bNominal) 
            {
                t = PRESENT_TENSE_NOMINAL;
            }else {
                 t = PRESENT_TENSE_VERBAL;
            }
        }
        
        
        if (bVBN) 
        {
            if (bNominal) 
            {
                t = PRESENT_PERPECT_NOMINAL;
            }else {
                 t = PRESENT_PERPECT_VERBAL;
            }
        }
        
        if (bVBD)
        {
            if (bNominal) 
            {
              t = PAST_TENSE_NOMINAL;    
            }else{
              t = PAST_TENSE_VERBAL;
            }
        }
        
        if (bMD)
        {
            if (bNominal) 
            {
              t = FUTURE_TENSE_NOMINAL;    
            }else{
              t = FUTURE_TENSE_VERBAL;
            }
        }
        
        return t;
    }
    
    
    
    
}
