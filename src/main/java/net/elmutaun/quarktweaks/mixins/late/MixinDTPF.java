package net.elmutaun.quarktweaks.mixins.late;

import net.elmutaun.quarktweaks.Config;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import gregtech.common.tileentities.machines.multi.MTEPlasmaForge;

@Mixin(MTEPlasmaForge.class)
public class MixinDTPF {

    // Cannot manipulate private static final primitive afaik (and it shouldn't)
    // Likely inlined at compile time, someone said.
    @Unique
    private static final double quarktweaks$max_efficiency_time_in_ticks = (double) Config.dtpf_convergence_ticks;

    @Shadow(remap = false)
    @Final
    private static double maximum_discount;

    @Shadow(remap = false)
    private double discount;

    @Shadow(remap = false)
    private long running_time;

    /**
     * @author ElMuTaun
     * @reason DTPF heat-up time is now configurable.
     */
    @Overwrite(remap = false)
    private void recalculateDiscount() {
        double time_percentage = running_time / quarktweaks$max_efficiency_time_in_ticks;
        time_percentage = Math.min(time_percentage, 1.0d);
        // Multiplied by 0.5 because that is the maximum achievable discount
        discount = 1 - time_percentage * 0.5;
        discount = Math.max(maximum_discount, discount);
    }
}
