/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict167lab9;


public class TutorialSpace {

    private int slots;
    private boolean activated;

    public TutorialSpace(int n) {
        slots = n;
        activated = false;
    }

    public void activate() throws NotActivatedException {
        if (activated) {
            throw new NotActivatedException("The class is already activated.");
        }
        activated = true;
    }

    public void reserveSlot() throws NotActivatedException, EmptyException {
        if (!activated) {
            throw new NotActivatedException("The class has not been activated yet.");
        }
        if (slots <= 0) {
            throw new EmptyException("No more slots available to reserve.");
        }
        slots--;
    }

    public int slotsRemaining() {
        return slots;
    }
    
    class NotActivatedException extends Exception {
        public NotActivatedException(String message) {
            super(message);
        }
    }
    
    class EmptyException extends Exception {
        public EmptyException(String message) {
            super(message);
        }
    }
}