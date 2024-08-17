/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167lab9;

public class RegisterClassAssertion {
    public static void main(String[] args) {
        TutorialSpaceAssertion class201 = new TutorialSpaceAssertion(2); // A class with 2 slots.

        // No try-catch blocks are needed here because we are using assertions, not exceptions.
        // Assert that the class starts unactivated.
        assert !class201.isActivated() : "Class should not be activated upon initialization.";

        class201.activate(); // Activating the class.
        System.out.println("Class activated.");

        // Enroll a student and assert the slots decrease correctly.
        class201.reserveSlot();
        assert class201.slotsRemaining() == 1 : "There should be 1 slot remaining.";

        // Enroll another student and assert no slots remain.
        class201.reserveSlot();
        assert class201.slotsRemaining() == 0 : "There should be no slots remaining.";

        // The following line should throw an AssertionError if assertions are enabled.
        class201.reserveSlot();
        // Since an assertion error is a runtime error, there is no need to catch it; 
        // the program will terminate if the assertion fails.

        // Assert that the class cannot be activated again.
        try {
            class201.activate(); // Should throw AssertionError if assertions are enabled.
        } catch (AssertionError e) {
            System.out.println("Caught assertion error as expected: " + e.getMessage());
        }
    }
}
