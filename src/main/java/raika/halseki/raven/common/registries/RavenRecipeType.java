package raika.halseki.raven.common.registries;

import raika.halseki.raven.common.registries.impl.RavenLazyRecipeSerializerRegister;

public class RavenRecipeType {
    public static final RavenLazyRecipeSerializerRegister RecipeSerializer = new RavenLazyRecipeSerializerRegister("raven");

}
