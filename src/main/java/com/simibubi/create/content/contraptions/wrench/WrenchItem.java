package com.simibubi.create.content.contraptions.wrench;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import org.jetbrains.annotations.NotNull;

public class WrenchItem extends Item {

	public WrenchItem(Settings properties) {
		super(properties);
	}

	@NotNull
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity player = context.getPlayer();
		if (player == null || !player.canModifyBlocks())
			return super.useOnBlock(context);

		BlockState state = context.getWorld()
			.getBlockState(context.getBlockPos());
		if (!(state.getBlock() instanceof IWrenchable))
			return super.useOnBlock(context);
		IWrenchable actor = (IWrenchable) state.getBlock();

		if (player.isSneaking())
			return actor.onSneakWrenched(state, context);
		return actor.onWrenched(state, context);
	}
	
	/*public static void wrenchInstaKillsMinecarts(AttackEntityEvent event) {
		Entity target = event.getTarget();
		if (!(target instanceof AbstractMinecartEntity))
			return;
		PlayerEntity player = event.getPlayer();
		ItemStack heldItem = player.getMainHandStack();
		if (!AllItems.WRENCH.isIn(heldItem))
			return;
		if (player.isCreative())
			return;
		AbstractMinecartEntity minecart = (AbstractMinecartEntity) target;
		minecart.damage(DamageSource.player(player), 100);
	}*/
	
}
