package raika.halseki.raven.client.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.util.Objects;

public class RenderManipulatorSearchingOut {
    private static final ResourceLocation OVERLAY = new ResourceLocation("raven", "gui/overlay/manipulator_searching_out.png");

    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Post postEvent) {
        if (postEvent.getType() != RenderGameOverlayEvent.ElementType.ALL) return;

        final Minecraft mcInstance = Minecraft.getInstance();
        PlayerEntity player  = Objects.requireNonNull(mcInstance.player, "Rq Player.");
        int windowWidth  = mcInstance.getMainWindow().getWidth();
        int windowHeight = mcInstance.getMainWindow().getHeight();

        // Render System Start Line
        RenderSystem.enableBlend();
        RenderSystem.blendColor(0.46f, 1.00f, 0.74f, 0.78f);
        mcInstance.getTextureManager().bindTexture(OVERLAY);

        final Tessellator   tsInstance = Tessellator.getInstance();
        final BufferBuilder builder    = tsInstance.getBuffer();

        builder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);

        tsInstance.draw();
        RenderSystem.bindTexture(0);
    }
}
