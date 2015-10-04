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
    private List<Appointment> appointments;
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
     * @returns name of the contact
     */
    public String getName() {
        return name;
    }
    
    /**
     * Add appointment for this contact
     * @param a Appointment object
     * @returns boolean - true if success, false if not
     */
    boolean addAppointment(Appointment a) {
        for(Appointment i : appointments){
            
        }
    }
    
    
    /**
     * Remove appointment for this contact
     * @param a Appointment to remove
     * @throws InvalidArgumentException if no appointment was found
     */
    void removeAppointment(Appointment a) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Get a list of all appointments for this contact
     * @returns Iterator of all Appointments for this contact
     */
    public Iterator<Appointment> appointments() {
        throw new UnsupportedOperationException();
    }
}
