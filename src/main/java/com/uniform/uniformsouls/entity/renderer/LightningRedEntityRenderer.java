//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.misc.LightningRedEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class LightningRedEntityRenderer extends EntityRenderer<LightningRedEntity> {

    public LightningRedEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    public void render(LightningRedEntity lightningRedEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        float[] fs = new float[8];
        float[] gs = new float[8];
        float h = 0.0F;
        float j = 0.0F;
        Random random = new Random(lightningRedEntity.seed);

        for(int k = 7; k >= 0; --k) {
            fs[k] = h;
            gs[k] = j;
            h += (float)(random.nextInt(11) - 5);
            j += (float)(random.nextInt(11) - 5);
        }

        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getLightning());
        Matrix4f matrix4f = matrixStack.peek().getModel();

        for(int l = 0; l < 4; ++l) {
            Random random2 = new Random(lightningRedEntity.seed);

            for(int m = 0; m < 3; ++m) {
                int n = 7;
                int o = 0;
                if (m > 0) {
                    n = 7 - m;
                }

                if (m > 0) {
                    o = n - 2;
                }

                float p = fs[n] - h;
                float q = gs[n] - j;

                for(int r = n; r >= o; --r) {
                    float s = p;
                    float t = q;
                    if (m == 0) {
                        p += (float)(random2.nextInt(11) - 5);
                        q += (float)(random2.nextInt(11) - 5);
                    } else {
                        p += (float)(random2.nextInt(31) - 15);
                        q += (float)(random2.nextInt(31) - 15);
                    }

                    float u = 0.5F;
                    float v = 0.45F;
                    float w = 0.45F;
                    float x = 0.5F;
                    float y = 0.1F + (float)l * 0.2F;
                    if (m == 0) {
                        y = (float)((double)y * ((double)r * 0.1D + 1.0D));
                    }

                    float z = 0.1F + (float)l * 0.2F;
                    if (m == 0) {
                        z *= (float)(r - 1) * 0.1F + 1.0F;
                    }

                    method_23183(matrix4f, vertexConsumer, p, q, r, s, t, 0.45F, 0.45F, 0.5F, y, z, false, false, true, false);
                    method_23183(matrix4f, vertexConsumer, p, q, r, s, t, 0.45F, 0.45F, 0.5F, y, z, true, false, true, true);
                    method_23183(matrix4f, vertexConsumer, p, q, r, s, t, 0.45F, 0.45F, 0.5F, y, z, true, true, false, true);
                    method_23183(matrix4f, vertexConsumer, p, q, r, s, t, 0.45F, 0.45F, 0.5F, y, z, false, true, false, false);
                }
            }
        }

    }


    private static void method_23183(Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float g, int i, float h, float j, float k, float l, float m, float n, float o, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        vertexConsumer.vertex(matrix4f, f + (bl ? o : -o), (float)(i * 16), g + (bl2 ? o : -o)).color(k, l, m, 0.3F).next();
        vertexConsumer.vertex(matrix4f, h + (bl ? n : -n), (float)((i + 1) * 16), j + (bl2 ? n : -n)).color(k, l, m, 0.3F).next();
        vertexConsumer.vertex(matrix4f, h + (bl3 ? n : -n), (float)((i + 1) * 16), j + (bl4 ? n : -n)).color(k, l, m, 0.3F).next();
        vertexConsumer.vertex(matrix4f, f + (bl3 ? o : -o), (float)(i * 16), g + (bl4 ? o : -o)).color(k, l, m, 0.3F).next();
    }

    public Identifier getTexture(LightningRedEntity lightningRedEntity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
