package com.example.mixin.client;

import net.minecraft.client.renderer.debug.EntityHitboxDebugRenderer;
import net.minecraft.gizmos.GizmoStyle;
import net.minecraft.gizmos.Gizmos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityHitboxDebugRenderer.class)
public class EntityHitboxDebugRendererMixin {
    
    @Redirect(
        method = "showHitboxes(Lnet/minecraft/world/entity/Entity;FZ)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/gizmos/Gizmos;arrow(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;I)V",
            ordinal = 0
        )
    )
    private void arrow1(Vec3 from, Vec3 to, int color) {
        Gizmos.line(from, to, color);
    }
    @Redirect(
        method = "showHitboxes(Lnet/minecraft/world/entity/Entity;FZ)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/gizmos/Gizmos;arrow(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;I)V",
            ordinal = 1
        )
    )
    private void arrow2(Vec3 from, Vec3 to, int color) {
        Gizmos.line(from, to, color);
    }
}
