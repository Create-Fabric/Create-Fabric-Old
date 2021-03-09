package com.simibubi.create.content.contraptions.base;

import com.simibubi.create.AllBlockPartials;
import com.simibubi.create.foundation.render.backend.instancing.InstancedModel;
import com.simibubi.create.foundation.render.backend.instancing.InstancedTileRenderRegistry;
import com.simibubi.create.foundation.render.backend.instancing.InstancedTileRenderer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class HalfShaftInstance extends SingleRotatingInstance {
	public HalfShaftInstance(InstancedTileRenderer<?> modelManager, KineticBlockEntity tile) {
		super(modelManager, tile);
	}

	public static void register(BlockEntityType<? extends KineticBlockEntity> type) {
		/**DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () ->*/
		InstancedTileRenderRegistry.instance.register(type, HalfShaftInstance::new);
	}

	@Override
	protected InstancedModel<RotatingData> getModel() {
		Direction dir = getShaftDirection();
		return AllBlockPartials.SHAFT_HALF.renderOnDirectionalSouthRotating(modelManager, lastState, dir);
	}

	protected Direction getShaftDirection() {
		return lastState.get(Properties.FACING);
	}
}
