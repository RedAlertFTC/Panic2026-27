package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloWorld extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hi", "I'm so cool");
    }

    @Override
    public void loop () {
    }
}
