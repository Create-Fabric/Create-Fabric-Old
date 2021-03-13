package com.simibubi.create;

import com.simibubi.create.content.contraptions.components.structureMovement.MovementBehaviour;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class AllMovementBehaviours {
	private static final HashMap<Identifier, MovementBehaviour> movementBehaviours = new HashMap<>();

	public static void addMovementBehaviour(Identifier resourceLocation, MovementBehaviour movementBehaviour) {
		if (movementBehaviours.containsKey(resourceLocation))
			Create.logger.warn("Movement behaviour for " + resourceLocation.toString() + " was overridden");
		movementBehaviours.put(resourceLocation, movementBehaviour);
	}

	public static void addMovementBehaviour(Block block, MovementBehaviour movementBehaviour) {
		addMovementBehaviour(block/*.getRegistryName()*/, movementBehaviour);
	}

	@Nullable
	public static MovementBehaviour of(Identifier resourceLocation) {
		return movementBehaviours.getOrDefault(resourceLocation, null);
	}

	@Nullable
	public static MovementBehaviour of(Block block) {
		return of(block/*.getRegistryName()*/);
	}
	
	@Nullable
	public static MovementBehaviour of(BlockState state) {
		return of(state.getBlock());
	}

	public static boolean contains(Block block) {
		return movementBehaviours.containsKey(Registry.BLOCK.getId(block)); // TODO ???
		// return movementBehaviours.containsKey(block.getRegistryName());
	}

	/*public static <B extends Block> NonNullConsumer<? super B> addMovementBehaviour(
		MovementBehaviour movementBehaviour) {
		return b -> addMovementBehaviour(b.getRegistryName(), movementBehaviour);
	}*/

	static void register() {
		/*addMovementBehaviour(Blocks.BELL, new BellMovementBehaviour()); TODO FIX MOVEMENT BEHAVIOURS
		addMovementBehaviour(Blocks.CAMPFIRE, new CampfireMovementBehaviour());*/

		//DispenserMovementBehaviour.gatherMovedDispenseItemBehaviours();
		/*addMovementBehaviour(Blocks.DISPENSER, new DispenserMovementBehaviour());
		addMovementBehaviour(Blocks.DROPPER, new DropperMovementBehaviour());*/
	}
}
