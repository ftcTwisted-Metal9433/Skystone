package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Red_Triangle_Side")
public class Red_triangle_side extends LinearOpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    Servo servoboiRight;
    Servo servoboiLeft;

    public void opentopickupblock(){

    }



    public void move(double rightPower, double leftPower, int ms) {
        frontRight.setPower(rightPower);
        frontLeft.setPower(leftPower);
        backRight.setPower(rightPower);
        backLeft.setPower(leftPower);
        sleep(ms);
    }


    public void closearms(int ms){
        servoboiLeft.setPosition(1);
        servoboiRight.setPosition(1);
        sleep(1000);
    }
    public void open(int ms){
        servoboiLeft.setPosition(.5);
        servoboiRight.setPosition(.75);
        sleep(1000);
    }
    public void dropLift(int ms){
        pullyBoi.setPower(-.25);
        sleep(1000);
    }
    public void LiftupLift(int ms){
        pullyBoi.setPower(.25);
        sleep(1000);


    }



    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        move(.4,.4,2500);

        //turnLeft
        move(.26,-.26,1000);

        move(.5,.5,2350);
        //turnRight
        move(-.26,.26,1000);

        move(.25,.25,800);
        //turnleft
        move(.26,-.26,1000);


        //pick up block
        dropLift(1200);
        open(25000);
        closearms(1000);
        LiftupLift(1200);


        //turnright
        move(-.26,.26,1000);
        //backwards
        move(-.5,-.5,800);
        //turnleft
        move(.26,-.26,1000);
        //backwards
        move(-.5,-.5,3500);


        //turn left
        move(.26,-.26,1000);


        dropLift(1000);

        open(2500);
        LiftupLift(1000);




        stop();








    }
}
