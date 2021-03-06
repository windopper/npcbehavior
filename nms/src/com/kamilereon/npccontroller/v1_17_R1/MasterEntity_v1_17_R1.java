package com.kamilereon.npccontroller.v1_17_R1;

import com.kamilereon.npccontroller.AIEntity;
import net.minecraft.core.BlockPosition;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Zombie;

public class MasterEntity_v1_17_R1 extends AIEntity {
    public MasterEntity_v1_17_R1(World world) {
        super(world);
    }


    public static AIEntity summon(Location location) {
        World nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        MasterEntity_v1_17_R1 entityAI = new MasterEntity_v1_17_R1(nmsWorld);
        entityAI.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        Zombie zombie = (Zombie) entityAI.getBukkitEntity();
        nmsWorld.addEntity(entityAI);
        zombie.setInvisible(true);
        zombie.teleport(location);
        return entityAI;
    }

    @Override
    public int getNoDamageTicks() {
        return this.getBukkitEntity().getHandle().W;
    }
}
