package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name="Minecraft")
public class Minecraft extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;
    public Servo leftArm;
    public Servo rightArm;


    @Override
    public void runOpMode() throws InterruptedException {
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //I'll leave this here I'm kinda curious how this'll go if ya test it
        rightArm.setDirection(Servo.Direction.REVERSE);
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        leftArm = hardwareMap.servo.get("leftArm");
        rightArm = hardwareMap.servo.get("rightArm");
        waitForStart();
        //Walk forward at full speed for 3 seconds
        walkForward(1,3000);
        //pivot turn right for 5.26 seconeds
        turn(-1,1,5260);
        //point turn right for 5 seconeds
        turn(0,1,5000);
        //Close servo with 2 second timeout
        closeServo(2000);
        //Open servo with 2 second timeout
        openServo(2000);

    }
    public void walkForward(double power, long time){
        frontLeft.setPower(power);
        backRight.setPower(power);//nyeheheheheh
        backLeft.setPower(power);
        frontRight.setPower(power);
        sleep(time);
    }
    public void turn(double right,double left, long time) {
        frontLeft.setPower(left);
        frontRight.setPower(right);
        backRight.setPower(right);
        backLeft.setPower(left);
        sleep(time);
    }
    public void closeServo(long time){
        leftArm.setPosition(.5);
        rightArm.setPosition(.5);
        sleep(time);
    }
    public void openServo(long time){
        //so remember this is a result of reversing the servo direction
        leftArm.setPosition(1);
        rightArm.setPosition(1);
        sleep(time);
    }
}
