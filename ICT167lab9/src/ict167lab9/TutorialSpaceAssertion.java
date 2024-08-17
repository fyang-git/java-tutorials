/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict167lab9;

public class TutorialSpaceAssertion {

    private int slots;
    private boolean activated;

    public TutorialSpaceAssertion(int n) {
        slots = n;
        activated = false;
    }

    public void activate() {
        // The class should not already be activated.
        assert !activated : "The class is already activated.";
        activated = true;
    }

    public void reserveSlot() {
        // The class must be activated before reserving a slot, and slots should be available.
        assert activated : "The class has not been activated yet.";
        assert slots > 0 : "No more slots available to reserve.";
        slots--;
    }

    public int slotsRemaining() {
        return slots;
    }
}

