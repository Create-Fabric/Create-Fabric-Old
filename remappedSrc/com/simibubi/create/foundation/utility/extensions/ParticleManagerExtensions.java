package com.simibubi.create.foundation.utility.extensions;

import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import org.jetbrains.annotations.ApiStatus;

public interface ParticleManagerExtensions {
	@ApiStatus.Internal
	<T extends ParticleEffect> void create$registerFactory0(ParticleType<T> particleType, ParticleManager.SpriteAwareFactory<T> spriteAwareFactory);

	@ApiStatus.Internal
	<T extends ParticleEffect> void create$registerFactory1(ParticleType<T> type, ParticleFactory<T> factory);
}
