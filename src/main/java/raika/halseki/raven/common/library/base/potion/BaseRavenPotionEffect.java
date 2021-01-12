package raika.halseki.raven.common.library.base.potion;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;

import java.awt.*;

public abstract class BaseRavenPotionEffect extends Effect {
    public BaseRavenPotionEffect(EffectType typeIn, Color colorIn) {
        super(typeIn, colorIn.getRGB());
    }
    public void attachEvent(IEventBus eventBus) { }
}