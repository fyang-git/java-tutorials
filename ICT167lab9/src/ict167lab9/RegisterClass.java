/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167lab9;

public class RegisterClass {

    public static void main(String[] args) {
        try {
            // Initialize the TutorialSpace with 2 slots
            TutorialSpace tutorial = new TutorialSpace(2);
            
            System.out.println("Trying to reserve a slot before activation.");
            try {
                tutorial.reserveSlot(); // This should throw NotActivatedException
            } catch (TutorialSpace.NotActivatedException e) {
                System.out.println(e.getMessage());
            }
            
            // Activate the class
            System.out.println("Activating the class.");
            tutorial.activate();
            System.out.println("Class activated successfully.");
            
            // Reserve a slot
            System.out.println("Reserving a slot after activation.");
            tutorial.reserveSlot(); // This should work fine
            System.out.println("Slot reserved successfully.");
            System.out.println("Slots remaining: " + tutorial.slotsRemaining());
            
            // Reserve the last slot
            System.out.println("Reserving the last slot.");
            tutorial.reserveSlot(); // This should work fine
            System.out.println("Last slot reserved successfully.");
            System.out.println("Slots remaining: " + tutorial.slotsRemaining());
            
            // Attempt to reserve a slot when no slots are left
            System.out.println("Trying to reserve a slot when none are left.");
            try {
                tutorial.reserveSlot(); // This should throw EmptyException
            } catch (TutorialSpace.EmptyException e) {
                System.out.println(e.getMessage());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}