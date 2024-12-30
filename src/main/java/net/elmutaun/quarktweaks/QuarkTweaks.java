package net.elmutaun.quarktweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = QuarkTweaks.MODID, version = Tags.VERSION, name = "QuarkTweaks", acceptedMinecraftVersions = "[1.7.10]")
public class QuarkTweaks {

    public static final String MODID = "quarktweaks";
    // public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "net.elmutaun.quarktweaks.ClientProxy",
        serverSide = "net.elmutaun.quarktweaks.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    // @Mod.EventHandler
    // // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not
    // needed)
    // public void init(FMLInitializationEvent event) {
    // proxy.init(event);
    // }
    //
    // @Mod.EventHandler
    // // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    // public void postInit(FMLPostInitializationEvent event) {
    // proxy.postInit(event);
    // }
    //
    // @Mod.EventHandler
    // // register server commands in this event handler (Remove if not needed)
    // public void serverStarting(FMLServerStartingEvent event) {
    // proxy.serverStarting(event);
    // }
}
