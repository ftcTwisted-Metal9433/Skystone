package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "Tele")
public class Tele extends OpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    Servo servoboiRight;
    Servo servoboiLeft;

    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        servoboiRight = hardwareMap.servo.get("servoboiRight");
        servoboiLeft = hardwareMap.servo.get("servoboiLeft");

        //setting the direction
        pullyBoi.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        servoboiRight.setPosition(.75);
        servoboiLeft.setPosition(.5);


    }

    @Override
    public void loop() {
        telemetry.addData("frontLeft", "power FL" + frontLeft.getPower());
        telemetry.addData("frontRight","power FR" + frontRight.getPower());
        telemetry.addData("backLeft","power BL" + backLeft.getPower());
        telemetry.addData("backRight","power BR" + backRight.getPower());
        telemetry.addData("servoboiRight","power SBR" + servoboiRight.getPosition());
        telemetry.addData("servoboiLeft","power SBL" + servoboiLeft.getPosition());
        telemetry.addData("pullyBoi","power PB" + pullyBoi.getPower());

        telemetry.update();





        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(-gamepad1.left_stick_y * 1);
            backLeft.setPower(-gamepad1.left_stick_y * 1);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y * 1);
            backRight.setPower(-gamepad1.right_stick_y * 1);
        } else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        if (Math.abs(gamepad1.left_trigger) > .1){
            frontLeft.setPower(-gamepad1.left_trigger * 1);
            backLeft.setPower(gamepad1.left_trigger * 1);
            frontRight.setPower(gamepad1.left_trigger * 1);
            backRight.setPower(-gamepad1.left_trigger * 1);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        if (Math.abs(gamepad1.right_trigger) > .1) {
            frontLeft.setPower(gamepad1.right_trigger * 1);
            backLeft.setPower(-gamepad1.right_trigger * 1);
            frontRight.setPower(-gamepad1.right_trigger * 1);
            backRight.setPower(gamepad1.right_trigger * 1);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        if (gamepad1.left_bumper){
            frontLeft.setPower(1);
            backLeft.setPower(1);
            frontRight.setPower(1);
            backRight.setPower(1);
        } else{
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        // spool boi power interchangable
        if (Math.abs(gamepad2.left_trigger) > .1) {
            pullyBoi.setPower(gamepad2.left_trigger);
        } else if (Math.abs(gamepad2.right_trigger) > .1) {
            pullyBoi.setPower(-gamepad2.right_trigger);
        }
        else {
            pullyBoi.setPower(0);
        }
        // 6 by 6 design is 4 dollars and 9 by 9 design is 6 dollars
        if (gamepad2.a) {
            servoboiRight.setPosition(0);

        }
        if (gamepad2.b) {
            servoboiRight.setPosition(.75);

        }

        if (gamepad2.x) {
            servoboiLeft.setPosition(.6);
        }

        if (gamepad2.y){
            servoboiLeft.setPosition(0);
        }



    }
}









