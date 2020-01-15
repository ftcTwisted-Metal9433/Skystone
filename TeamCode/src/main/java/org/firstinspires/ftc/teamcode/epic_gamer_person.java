package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp (name = "SinglePlayer")
public class epic_gamer_person extends OpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    CRServo intake;

    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        intake = hardwareMap.crservo.get("intake");

        //setting the direction
        pullyBoi.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);



    }

    @Override
    public void loop() {
        telemetry.addData("frontLeft", "power FL" + frontLeft.getPower());
        telemetry.addData("frontRight","power FR" + frontRight.getPower());
        telemetry.addData("backLeft","power BL" + backLeft.getPower());
        telemetry.addData("backRight","power BR" + backRight.getPower());
        telemetry.addData("pullyBoi","power PB" + pullyBoi.getPower());

        telemetry.update();




        //Base Motors
        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(-gamepad1.left_stick_y);
            backLeft.setPower(-gamepad1.left_stick_y * .9);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y);
            backRight.setPower(-gamepad1.right_stick_y * .9);
        } else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        //Strafing Left
        if (gamepad1.left_bumper){
            frontLeft.setPower(-1);
            backLeft.setPower(1);
            frontRight.setPower(1);
            backRight.setPower(-1);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        //Strafing Right
        if (gamepad1.right_bumper) {
            frontLeft.setPower(1);
            backLeft.setPower(-1);
            frontRight.setPower(-1);
            backRight.setPower(1);
        }
        else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        // spool boi power interchangable
        if (Math.abs(gamepad1.left_trigger) > .1) {
            pullyBoi.setPower(.6);
        } else if (Math.abs(gamepad1.right_trigger) > .1) {
            pullyBoi.setPower(-.6);
        }
        else {
            pullyBoi.setPower(0);
        }
        // 6 by 6 design is 4 dollars and 9 by 9 design is 6 dollars

        if (gamepad1.x) {
            intake.setPower(1);
        }
        else if (gamepad1.y) {
            intake.setPower(-1);
        }
        else {
            intake.setPower(0);
        }
    }
}




