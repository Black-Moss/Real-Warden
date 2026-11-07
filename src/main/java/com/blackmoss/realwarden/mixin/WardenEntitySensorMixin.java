package com.blackmoss.realwarden.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.WardenEntitySensor;
import net.minecraft.world.entity.monster.warden.Warden;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WardenEntitySensor.class)
public abstract class WardenEntitySensorMixin {
    @Inject(
            method = "doTick(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/monster/warden/Warden;)V",
            at = @At("TAIL")
    )
    private void realwarden$EraseScentTarget(
            ServerLevel serverLevel,
            Warden warden,
            CallbackInfo ci) {
        warden.getBrain().eraseMemory(MemoryModuleType.NEAREST_ATTACKABLE);
    }
}
