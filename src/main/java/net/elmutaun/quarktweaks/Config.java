package net.elmutaun.quarktweaks;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static int dtpf_convergence_ticks = 24000;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        dtpf_convergence_ticks = configuration.getInt(
            "dtpf_convergence_ticks",
            Configuration.CATEGORY_GENERAL,
            dtpf_convergence_ticks,
            0,
            Integer.MAX_VALUE,
            "Running ticks to achive maximum discount. GTNH default: 576000");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
