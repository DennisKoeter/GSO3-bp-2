/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cas
 */
public class Contact {
    
    private String name;
    private List<Appointment> agenda;
    /**
     * Create a new Contact
     * @param name must be at least one character long
     * @throws IllegalArgumentException when name is null or empty
     */
    public Contact(String name) {
        if(name == null || name.length() < 1) throw new IllegalArgumentException("Name cannot be empty");
        
        this.name = name;
    }
    
    /**
     * Get the name of this contact
     * @return contact name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Add appointment for this contact
     * @param a Appointment object
     * @return boolean - true if success, false if not
     */
    boolean addAppointment(Appointment a) {
        boolean allowed = true;
        
        for(Appointment i : agenda){
            if(i.getTimespan().unionWith(a.getTimespan()) != null) allowed = false;
        }
        
        if(allowed) agenda.add(a);
        return allowed;
    }
    
    
    /**
     * Remove appointment for this contact
     * @param a Appointment to remove
     * @throws InvalidArgumentException if no appointment was found
     */
    void removeAppointment(Appointment a) {
        boolean done = false;
        int removeIndex = 0;
        
        int counter = 0;
        for(Appointment i : agenda) {
            if(i.getTimespan().unionWith(a.getTimespan()) != null) {
                removeIndex = counter;
                done = true;
                break;
            }
            counter++;
        }
        
        if(done) {
            agenda.remove(removeIndex);
        }
        else {
            throw new IllegalArgumentException("Given appointment " + a +  " is not in this contact's agenda");
        }
        
    }
    
    /**
     * Get a list of all appointments for this contact
     * @return Iterator of all Appointments for this contact
     */
    public Iterator<Appointment> appointments() {
        return agenda.iterator();
    }
}
