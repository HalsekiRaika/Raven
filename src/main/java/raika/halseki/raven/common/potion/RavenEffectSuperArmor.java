package raika.halseki.raven.common.potion;

import net.minecraft.potion.EffectType;
import raika.halseki.raven.common.library.base.potion.BaseRavenPotionEffect;

import java.awt.*;

public class RavenEffectSuperArmor extends BaseRavenPotionEffect {
    public static final Color EFFECT_SUPER_ARMOR = new Color(247, 100, 64);
    public static RavenEffectSuperArmor INSTANCE;

    public RavenEffectSuperArmor(EffectType typeIn, Color colorIn) {
        super(EffectType.BENEFICIAL, colorIn);
    }


}
