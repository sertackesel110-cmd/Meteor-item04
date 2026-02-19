package com.sertac.debris;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;

public class Addon extends MeteorAddon {
    public static final Category CATEGORY = new Category("Debris", Items.ANCIENT_DEBRIS.getDefaultStack());

    @Override
    public void onInitialize() {
        // Modülü sisteme ekle
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
