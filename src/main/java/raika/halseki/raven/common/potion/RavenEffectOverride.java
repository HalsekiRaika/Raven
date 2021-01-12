package raika.halseki.raven.common.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import raika.halseki.raven.common.library.base.potion.BaseRavenPotionEffect;

import javax.annotation.Nonnull;
import java.awt.*;

public class RavenEffectOverride extends BaseRavenPotionEffect {
    public static final Color EFFECT_OVERRIDE = new Color(255, 59, 94);
    public static RavenEffectOverride INSTANCE; // <- Really an instance???

    public RavenEffectOverride() {
        super(EffectType.BENEFICIAL, EFFECT_OVERRIDE);
    }

    @Override
    public void performEffect(@Nonnull LivingEntity entityIn, int amplifier) {
        if (!entityIn.getEntityWorld().isRemote && entityIn.isPotionActive(INSTANCE)) {
            entityIn.setAbsorptionAmount(20 * amplifier);
            entityIn.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 600, -10, false, false));
            entityIn.addPotionEffect(new EffectInstance(Effects.STRENGTH,     600,  20, false, false));
        }
    }

    private static void onEffectApply(LivingEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (!entity.getEntityWorld().isRemote && entity.isPotionActive(INSTANCE)) {
            event.setCanceled(true);
        }
    }
}
