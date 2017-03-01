/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view.form;

/**
 *
 * @author NOFFABEL
 */
public interface Fields {
   
    /**
     * 
     */
    public void check();
    
    /**
     * 
     * @return 
     */
    public boolean isValidField();
    
    /**
     * 
     * @param bln 
     */
    public void setError(boolean bln);
    
    /**
     * Method calls when an error is remind on the field.
     */
    public void buildError();
    
    public boolean isRequired();
}
