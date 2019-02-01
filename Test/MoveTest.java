import org.junit.*;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class MoveTest {

    Saab95 saab;
    Volvo240 volvo;

    @Before
    public void init(){

        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void moveWithEngineOff(){

        saab.stopEngine();
        volvo.stopEngine();
        saab.move();
        volvo.move();

        assertTrue(saab.getX() == 0 && saab.getY() == 0 && volvo.getX() == 0 && volvo.getY() == 0);

    }

    @Test
    public void saabWithTurboOnVsVolvo(){
        saab.startEngine();
        saab.setTurboOn();
        volvo.startEngine();
        saab.gas(10);
        volvo.gas(10);
        saab.brake(5);
        volvo.brake(5);
        saab.move();
        volvo.move();

        assertTrue(saab.getCurrentSpeed() > volvo.getCurrentSpeed());
    }

    @Test
    public void saabWithTurboOffVsVolvo(){
        saab.startEngine();
        saab.stopEngine();
        volvo.stopEngine();
        saab.setTurboOff();
        volvo.startEngine();
        saab.gas(10);
        volvo.gas(10);
        saab.brake(5);
        volvo.brake(5);
        saab.move();
        volvo.move();

        assertTrue(saab.getCurrentSpeed() == volvo.getCurrentSpeed());
    }

    @Test
    public void turnRightAndBack(){
        saab.turnLeft(Math.PI);
        volvo.turnLeft(Math.PI);
        saab.turnRight(Math.PI);
        volvo.turnRight(Math.PI);

        assertTrue(saab.getDirection() == 0 && volvo.getDirection() == 0);
    }

    @Test
    public void saab95Attributes(){
        assertTrue(saab.getNrDoors() == 2
        && saab.getEnginePower() == 125
        && saab.getColor() == Color.RED
        && saab.getModelName().equals("Saab95"));
    }

    @Test
    public void volvo240Attributes(){
        assertTrue(volvo.nrDoors == 4
        && volvo.getEnginePower() == 100
        && volvo.getColor() == Color.BLACK
        && volvo.getModelName().equals("Volvo240"));

    }

    @Test
    public void switchColor(){

        saab.setColor(Color.BLACK);
        volvo.setColor(Color.RED);

        assertTrue(saab.getColor() == Color.BLACK && volvo.getColor() == Color.RED);
    }




}
