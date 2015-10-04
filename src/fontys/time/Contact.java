/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;

/**
 *
 * @author cas
 */
public class Contact {
    
    private String name;
    /**
     * Create a new Contact
     * @param name must be at least one character long
     */
    public Contact(String name) {
        
    }
    
    /**
     * @returns name of the contact
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Add appointment for this contact
     * @param a Appointment object
     * @returns boolean - true if success, false if not
     */
    boolean addAppointment(Appointment a) {
        throw new UnsupportedOperationException();
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
