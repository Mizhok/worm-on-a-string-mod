package com.mizhok.wormonstring.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;

public class WormIron extends Block {

    public WormIron(){
    super(Properties.create(Material.IRON).
                    sound(SoundType.METAL).
                    hardnessAndResistance(2.0f).
                    lightValue(14)
    );
    setRegistryName("wormiron");
}
}
