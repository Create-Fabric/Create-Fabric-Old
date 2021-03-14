package com.simibubi.create.foundation.utility.worldWrappers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.jetbrains.annotations.Nullable;

import com.simibubi.create.foundation.utility.worldWrappers.chunk.WrappedChunk;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.light.LightingProvider;

public class WrappedChunkProvider extends ChunkManager {
    private PlacementSimulationWorld world;

    public HashMap<Long, WrappedChunk> chunks;

    public WrappedChunkProvider setWorld(PlacementSimulationWorld world) {
        this.world = world;
        this.chunks = new HashMap<>();
        return this;
    }

    public Stream<BlockPos> getLightSources() {
        return world.blocksAdded
                .entrySet()
                .stream()
                .filter(it -> it.getValue().getLuminance() != 0) // TODO MIGHT BE WRONG ORIGINAL IS getLightValue(world, it.getKey()) != 0
                .map(Map.Entry::getKey);
    }

    @Override
    public BlockView getWorld() {
        return world;
    }

    @Nullable
    @Override
    public Chunk getChunk(int x, int z, ChunkStatus status, boolean p_212849_4_) {
        return getChunk(x, z);
    }

    public WrappedChunk getChunk(int x, int z) {
        long pos = ChunkPos.toLong(x, z);

        WrappedChunk chunk = chunks.get(pos);

        if (chunk == null) {
            chunk = new WrappedChunk(world, x, z);
            chunks.put(pos, chunk);
        }

        return chunk;
    }

    /*@Override
    public void tick(BooleanSupplier p_217207_1_) { TODO COULD BE WRONG WHEN COMMENTING THIS OUT

    }*/

    @Override
    public String getDebugString() {
        return "WrappedChunkProvider";
    }


    @Override
    public LightingProvider getLightingProvider() {
        return world.getLightingProvider();
    }
}
