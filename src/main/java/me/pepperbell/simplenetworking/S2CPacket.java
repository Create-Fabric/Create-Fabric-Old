package me.pepperbell.simplenetworking;

import me.pepperbell.simplenetworking.SimpleChannel.ResponseTarget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public interface S2CPacket extends Packet {
	/**
	 * This method will be run on the network thread. Most method calls should be performed on the client thread by wrapping the code in a lambda:
	 * <pre>
	 * <code>client.execute(() -> {
	 * 	// code here
	 * }</code></pre>
	 */
	void handle(MinecraftClient client, ClientPlayNetworkHandler handler, ResponseTarget responseTarget);
}
