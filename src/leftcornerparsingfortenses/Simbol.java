/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leftcornerparsingfortenses;

/**
 *
 * @author Fiqih Amrullah
 */
public class Simbol 
{
    private String name;
    private String type;
    private String alias;

    public Simbol(String name) 
    {
        this.name = name;
    }   

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    
    
}
