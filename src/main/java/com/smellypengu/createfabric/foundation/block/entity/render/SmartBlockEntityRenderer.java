package com.smellypengu.createfabric.foundation.block.entity.render;

import com.smellypengu.createfabric.foundation.block.entity.SmartBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public class SmartBlockEntityRenderer<T extends SmartBlockEntity> extends SafeBlockEntityRenderer<T> {
	
	@Override
	protected void renderSafe(T blockEntityIn, float partialTicks, MatrixStack ms, VertexConsumerProvider buffer, int light,
			int overlay) {
		/**FilteringRenderer.renderOnTileEntity(blockEntityIn, partialTicks, ms, buffer, light, overlay);
		LinkRenderer.renderOnTileEntity(blockEntityIn, partialTicks, ms, buffer, light, overlay);*/
	}

}
