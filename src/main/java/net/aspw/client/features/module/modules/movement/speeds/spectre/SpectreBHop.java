package net.aspw.client.features.module.modules.movement.speeds.spectre;

import net.aspw.client.Client;
import net.aspw.client.event.MoveEvent;
import net.aspw.client.features.module.modules.movement.speeds.SpeedMode;
import net.aspw.client.features.module.modules.player.Scaffold;
import net.aspw.client.utils.MovementUtils;

public class SpectreBHop extends SpeedMode {

    public SpectreBHop() {
        super("SpectreBHop");
    }

    @Override
    public void onMotion() {
        if (!MovementUtils.isMoving() || mc.thePlayer.movementInput.jump)
            return;

        if (mc.thePlayer.onGround) {
            MovementUtils.strafe(1.1F);
            mc.thePlayer.motionY = 0.44D;
            return;
        }

        MovementUtils.strafe();
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onDisable() {
        final Scaffold scaffold = Client.moduleManager.getModule(Scaffold.class);

        if (!mc.thePlayer.isSneaking() && !scaffold.getState())
            MovementUtils.strafe(0.2f);
    }

    @Override
    public void onMove(MoveEvent event) {
    }
}
