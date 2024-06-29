/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

/**
 *
 * @author Fiqih Amrullah
 */
public class Token
{
    private String name;
    private Simbol symbol;
    private int position;

    public Token() 
    {
      symbol = new Simbol("");   
    }

    public Token(String name, Simbol symbol, int position) 
    {
        this.name = name;
        this.symbol = symbol;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(Simbol symbol) {
        this.symbol = symbol;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Simbol getSymbol() {
        return symbol;
    }
    
    
    
    
    
    
    
}
