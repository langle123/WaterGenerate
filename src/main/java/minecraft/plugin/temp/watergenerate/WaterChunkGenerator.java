package minecraft.plugin.temp.watergenerate;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.List;
import java.util.Random;

/**
 * @author white
 * @version 1.0
 */
public class WaterChunkGenerator extends ChunkGenerator {

    @Override
    public Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, 0.5d, 51.0d, 0.5d);
    }

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunkData = this.createChunkData(world);
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                biome.setBiome(x, z, WaterGenerate.biome);
                chunkData.setBlock(x, 0, z, Material.BEDROCK);
                for (int y = 1; y <= WaterGenerate.level; y++) {
                    chunkData.setBlock(x, y, z, Material.WATER);
                }
            }
        }
        return chunkData;
    }

    @Override
    public boolean canSpawn(World world, int x, int z) {
        return super.canSpawn(world, x, z);
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return super.getDefaultPopulators(world);
    }

}
