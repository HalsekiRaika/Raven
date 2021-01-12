package raika.halseki.raven.common.registries.impl;

import net.minecraft.potion.Effect;
import net.minecraftforge.registries.ForgeRegistries;
import raika.halseki.raven.common.library.base.potion.BaseRavenPotionEffect;
import raika.halseki.raven.common.registries.impl.wrapper.RavenLazyRegistryWrapper;

public class RavenLazyEffectRegister extends RavenLazyRegistryWrapper<Effect> {
    public RavenLazyEffectRegister(String modid) {
        super(modid, ForgeRegistries.POTIONS);
    }

}
