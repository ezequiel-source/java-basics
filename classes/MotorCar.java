public class MotorCar {
    private String model;
    private boolean engineRunning;
    private int currentGear;
    private int rpm;
    private boolean isMoving;
    
    public MotorCar(String model) {
        this.model = model;
        this.engineRunning = false;
        this.currentGear = 0; // 0 = neutral, 1-6 = forward gears, -1 = reverse
        this.rpm = 0;
        this.isMoving = false;
    }
    
    public void startEngine() {
        if (!engineRunning) {
            engineRunning = true;
            rpm = 800; // idle RPM
            System.out.println(model + " engine started. RPM: " + rpm);
        } else {
            System.out.println("Engine is already running.");
        }
    }
    
    public void stopEngine() {
        if (engineRunning && currentGear == 0 && !isMoving) {
            engineRunning = false;
            rpm = 0;
            System.out.println(model + " engine stopped.");
        } else {
            System.out.println("Cannot stop engine - put car in neutral and stop moving first.");
        }
    }
    
    public void accelerate() {
        if (engineRunning && currentGear != 0) {
            rpm = Math.min(rpm + 500, 6000);
            isMoving = true;
            System.out.println("Accelerating... RPM: " + rpm);
        } else {
            System.out.println("Cannot accelerate - engine not running or in neutral.");
        }
    }
    
    public void brake() {
        if (isMoving) {
            rpm = Math.max(rpm - 300, 800);
            if (rpm <= 800) {
                isMoving = false;
                System.out.println("Car stopped. RPM: " + rpm);
            } else {
                System.out.println("Braking... RPM: " + rpm);
            }
        }
    }
    
    // Method that uses a local class for the clutch system
    public void operateClutch() {
        // Local class definition inside the method
        class Clutch {
            private boolean engaged;
            private boolean slipping;
            private double wearLevel; // 0.0 to 1.0, where 1.0 is completely worn
            
            public Clutch() {
                this.engaged = true; // Clutch starts engaged
                this.slipping = false;
                this.wearLevel = 0.1; // 10% wear initially
            }
            
            public void press() {
                if (engaged) {
                    engaged = false;
                    System.out.println("Clutch pressed - engine disconnected from transmission");
                    
                    // When clutch is pressed, engine can rev freely
                    if (engineRunning) {
                        System.out.println("Engine revs freely, current RPM: " + rpm);
                    }
                } else {
                    System.out.println("Clutch is already pressed");
                }
            }
            
            public void release() {
                if (!engaged) {
                    engaged = true;
                    
                    // Check for clutch slipping based on wear and RPM difference
                    if (wearLevel > 0.5 || (engineRunning && rpm > 3000)) {
                        slipping = true;
                        System.out.println("Clutch released but slipping! (Wear: " + 
                                         String.format("%.1f", wearLevel * 100) + "%)");
                        // Increase wear when slipping
                        wearLevel = Math.min(wearLevel + 0.05, 1.0);
                    } else {
                        slipping = false;
                        System.out.println("Clutch engaged smoothly - engine connected to transmission");
                    }
                    
                    // Synchronize engine RPM with transmission when engaging
                    if (engineRunning && currentGear != 0 && !slipping) {
                        rpm = calculateGearRPM(currentGear);
                        System.out.println("RPM synchronized to gear: " + rpm);
                    }
                } else {
                    System.out.println("Clutch is already engaged");
                }
            }
            
            public boolean canShiftGear() {
                return !engaged; // Can only shift when clutch is pressed
            }
            
            public boolean isEngaged() {
                return engaged;
            }
            
            public boolean isSlipping() {
                return slipping;
            }
            
            public double getWearLevel() {
                return wearLevel;
            }
            
            public void displayStatus() {
                System.out.println("Clutch Status:");
                System.out.println("  Engaged: " + engaged);
                System.out.println("  Slipping: " + slipping);
                System.out.println("  Wear Level: " + String.format("%.1f", wearLevel * 100) + "%");
            }
        }
        
        // Create and use the local Clutch class
        Clutch clutch = new Clutch();
        
        System.out.println("\n=== Clutch Operation Demo ===");
        clutch.displayStatus();
        
        // Demonstrate clutch operation
        System.out.println("\nTesting clutch operations:");
        
        // Try to shift without pressing clutch
        System.out.println("\nAttempting to shift gear without pressing clutch:");
        if (!clutch.canShiftGear()) {
            System.out.println("Cannot shift - clutch must be pressed first!");
        }
        
        // Press clutch and shift gear
        System.out.println("\nPressing clutch:");
        clutch.press();
        
        if (clutch.canShiftGear()) {
            System.out.println("Now we can shift gears safely");
            shiftGear(1, clutch); // Pass clutch to gear shifting method
        }
        
        System.out.println("\nReleasing clutch:");
        clutch.release();
        
        // Demonstrate clutch slipping under high RPM
        System.out.println("\n--- Testing high RPM scenario ---");
        if (engineRunning) {
            rpm = 4000; // High RPM
            System.out.println("Engine RPM increased to: " + rpm);
            
            clutch.press();
            clutch.release(); // This should cause slipping
            
            clutch.displayStatus();
        }
    }
    
    // Helper method that works with the clutch
    private void shiftGear(int newGear, Object clutch) {
        // In a real implementation, we'd use the clutch parameter
        // For this demo, we'll use reflection-like behavior conceptually
        
        if (newGear >= -1 && newGear <= 6) {
            int oldGear = currentGear;
            currentGear = newGear;
            System.out.println("Shifted from gear " + oldGear + " to gear " + currentGear);
            
            if (engineRunning && currentGear != 0) {
                rpm = calculateGearRPM(currentGear);
            }
        } else {
            System.out.println("Invalid gear: " + newGear);
        }
    }
    
    private int calculateGearRPM(int gear) {
        // Simple RPM calculation based on gear
        switch (Math.abs(gear)) {
            case 1: return 1500;
            case 2: return 1200;
            case 3: return 1000;
            case 4: return 900;
            case 5: return 850;
            case 6: return 800;
            default: return 800; // neutral/idle
        }
    }
    
    public void displayStatus() {
        System.out.println("\n=== " + model + " Status ===");
        System.out.println("Engine Running: " + engineRunning);
        System.out.println("Current Gear: " + currentGear);
        System.out.println("RPM: " + rpm);
        System.out.println("Moving: " + isMoving);
    }
    
    // Main method to demonstrate the motor car with clutch
    public static void main(String[] args) {
        System.out.println("Motor Car with Clutch System Demo");
        System.out.println("=================================");
        
        // Create a motor car
        MotorCar car = new MotorCar("Toyota Corolla");
        
        // Start the car
        car.startEngine();
        car.displayStatus();
        
        // Demonstrate clutch operation (uses local class)
        car.operateClutch();
        
        // Try some driving operations
        System.out.println("\n--- Driving Operations ---");
        car.accelerate();
        car.brake();
        car.brake(); // Stop the car
        
        car.displayStatus();
        
        // Stop the engine
        car.stopEngine();
        car.displayStatus();
    }
}
