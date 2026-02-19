package com.sertac.debris;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("DebrisTracer");
    public static final Category CATEGORY = new Category("Debris", Items.ANCIENT_DEBRIS.getDefaultStack());

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Debris Tracer...");

        // Modules
        Modules.get().add(new DebrisTracer());
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.sertac.debris";
    }
}
