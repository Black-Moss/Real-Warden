package com.blackmoss.realwarden.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.behavior.warden.Sniffing;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.warden.Warden;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Sniffing.class)
public abstract class SniffingMixin {
    @Inject(
            method = "stop(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/monster/warden/Warden;J)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void realwarden$CancelScentResult(
            ServerLevel serverLevel,
            Warden warden,
            long l,
            CallbackInfo ci) {
        if (warden.hasPose(Pose.SNIFFING)) {
            warden.setPose(Pose.STANDING);
        }

        warden.getBrain().eraseMemory(MemoryModuleType.IS_SNIFFING);
        ci.cancel();
    }
}
