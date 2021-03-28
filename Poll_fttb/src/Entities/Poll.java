/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import utils.Utilities;

/**
 *
 * @author Slim
 */
public class Poll {
    private int poll_id ;
    private String Description;
    private Date creation_date;
    private String Status;

   
    public Poll() {
        this.poll_id = Utilities.generatedId("Poll","Poll_id");
    }

    public Poll(int poll_id, String Description) {
        this.poll_id = Utilities.generatedId("Poll","Poll_id");
        this.Description = Description;
        this.Status = Status;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    
    
    

    public int getPoll_id() {
        return poll_id;
    }

    public String getDescription() {
        return Description;
    }

    public void setPoll_id(int poll_id) {
        this.poll_id = poll_id;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
    

    
    @Override
    public String toString() {
        return "\n Poll ID is : " +poll_id+ "\nDescription:  " + Description + "\n-----------------------------------------\n";
    }
    
    
    
}
