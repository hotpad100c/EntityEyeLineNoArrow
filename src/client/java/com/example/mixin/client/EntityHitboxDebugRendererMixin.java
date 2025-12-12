package com.example.mixin.client;

import net.minecraft.client.render.debug.EntityHitboxDebugRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.debug.gizmo.GizmoDrawing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityHitboxDebugRenderer.class)
public class EntityHitboxDebugRendererMixin {
    
    @Redirect(
        method = "drawHitbox",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/debug/gizmo/GizmoDrawing;arrow(Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;I)Lnet/minecraft/world/debug/gizmo/GizmoDrawing$VisibilityConfigurable;",
            ordinal = 0 
        )
    )
    private static GizmoDrawing.VisibilityConfigurable redirectDirectionArrow(Vec3d start, Vec3d end, int color) {
        return GizmoDrawing.line(start, end, color);
    }
    
    @Redirect(
        method = "drawHitbox",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/debug/gizmo/GizmoDrawing;arrow(Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;I)Lnet/minecraft/world/debug/gizmo/GizmoDrawing$VisibilityConfigurable;",
            ordinal = 1 
        )
    )
    private static GizmoDrawing.VisibilityConfigurable redirectVelocityArrow(Vec3d start, Vec3d end, int color) {
        return GizmoDrawing.line(start, end, color);
    }
}
