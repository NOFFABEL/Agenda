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
public interface Form {

    /**
     * 
     * @return 
     */
    boolean isValidForm();
    void buildErrors();
}
