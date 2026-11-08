public class CarTest {
    private static void reportResult(String testName, boolean success){
        IO.println((success ? "SUCCESS:" : "FAILURE: ") + testName);
    }

    private static void testTurbo(){
        Saab95 slowsSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowsSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowsSaab.gas(0.5);
        boolean result = slowsSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void testSaabTurboVsVolvo(){
        Saab95 fastSaab = new Saab95();
        Volvo240 volvo = new Volvo240();
        fastSaab.setTurboOn();
        fastSaab.gas(10);
        volvo.gas(10);
        boolean result = fastSaab.getCurrentSpeed() < volvo.getCurrentSpeed();
        reportResult("volvo is faster than Saab with no turbo", result);
    }

    private  static void testSameColor(){
        Saab95 Saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        boolean result = volvo.getColor() == Saab.getColor();
        reportResult("volvo is same color as Saab", result);
    }
    private static void testDoors(){
        Saab95 Saab = new Saab95();
        Volvo240 Volvo = new Volvo240();
        boolean result = Volvo.getNrDoors() > Saab.getNrDoors();
        reportResult("Volvo has more doors than Saab", result);
    }
    static void main(){
        testTurbo(); // result True
        testSaabTurboVsVolvo(); // result False
        testSameColor(); // result False
        testDoors(); // result True
        // TODO: add and run more tests
    }
}
