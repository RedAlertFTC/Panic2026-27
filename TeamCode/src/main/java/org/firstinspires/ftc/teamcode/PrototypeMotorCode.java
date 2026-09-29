package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="PrototypeMotorCode", group="teleOp")
public class PrototypeMotorCode extends LinearOpMode {

    private DcMotor input_motor = null;

    @Override
    public void runOpMode(){
        input_motor = hardwareMap.get(DcMotor.class, "im");
        input_motor.setDirection(DcMotor.Direction.FORWARD);

        while (opModeIsActive()) {

            if (gamepad1.left_stick_y > 0) {
                input_motor.setPower(500);
            } else if(gamepad1.left_stick_y < 0) {
                input_motor.setPower(-500);
            }
            else{
                input_motor.setPower(-500);
            }

            if (gamepad2.left_stick_y > 0) {
                input_motor.setPower(500);
            } else if(gamepad2.left_stick_y < 0) {
                input_motor.setPower(-500);
            }
            else{
                input_motor.setPower(-500);
            }
        }
    }
}