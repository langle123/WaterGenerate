package minecraft.plugin.temp.watergenerate;

import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class WaterGenerate extends JavaPlugin {

    public static Biome biome = Biome.VOID;
    public static int level = 62;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        level = getConfig().getInt("waterLevel");
        biome = Biome.valueOf(getConfig().getString("biome"));
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new WaterChunkGenerator();
    }

}
