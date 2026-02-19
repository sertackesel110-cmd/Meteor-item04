package com.sertac.debris;

import meteordevelopment.meteorclient.events.render.Render3DEvent;
import meteordevelopment.meteorclient.renderer.RenderUtils3D;
import meteordevelopment.meteorclient.settings.ColorSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Items;

public class DebrisTracer extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<SettingColor> color = sgGeneral.add(new ColorSetting.Builder()
            .name("color")
            .description("Tracer color for Ancient Debris.")
            .defaultValue(new SettingColor(255, 165, 0, 255))
            .build()
    );

    public DebrisTracer() {
        super(Addon.CATEGORY, "debris-tracer", "Draws a line to Ancient Debris items on the ground.");
    }

    @EventHandler
    private void onRender(Render3DEvent event) {
        if (mc.world == null) return;

        for (Entity entity : mc.world.getEntities()) {
            if (!(entity instanceof ItemEntity item)) continue;

            if (item.getStack().getItem() == Items.ANCIENT_DEBRIS) {
                double x = item.prevX + (item.getX() - item.prevX) * event.tickDelta;
                double y = item.prevY + (item.getY() - item.prevY) * event.tickDelta;
                double z = item.prevZ + (item.getZ() - item.prevZ) * event.tickDelta;

                // RenderUtils yerine RenderUtils3D kullanıyoruz
                event.renderer.line(
                        RenderUtils3D.getCenter().x, RenderUtils3D.getCenter().y, RenderUtils3D.getCenter().z,
                        x, y + 0.2, z,
                        color.get()
                );
            }
        }
    }
}
