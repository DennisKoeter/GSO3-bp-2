/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class Appointment{
    private final String subject;
    private final ITimeSpan timespan;
    private List<Contact> contacts;
    
    /**
     * constructor
     * @param subject the subject of the appointment
     * @param timespan the timespan of the appointment
     */
    public Appointment(String subject, ITimeSpan timespan){
        this.subject = subject;
        this.timespan = timespan;
        this.contacts = new ArrayList<Contact>();
    }
    
    /**
     * return the subject of the appointment
     * @return the subject of the appointment
     */
    public String getSubject(){
        return this.subject;
    }
    
    /**
     * return the timespan of the appointment
     * @return the timespan of the appointment;
     */
    public ITimeSpan getTimespan(){
        return this.timespan;
    }
    
    /**
     * return all contacts of the appointment
     * @return an iterator of the contacts of the appointment
     */
    public Iterator<Contact> invitees(){
        return this.contacts.iterator();
    }
    
    /**
     * add a contact to the appointment
     * @param c contact to be added
     * @return true if successful, false if not
     */
    public boolean addContact(Contact c){
            if(c.addAppointment(this)) {
                this.contacts.add(c);
                return true;
            }
            return false;  
    }
    
    /**
     * remove a contact from the appointment
     * @param c contact to be removed
     */
    public void removeContact(Contact c){
        c.removeAppointment(this);
        this.contacts.remove(c);
    }
}
