package net.elmutaun.quarktweaks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class LateMixinLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.quarktweaks.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        mixins.add("MixinDTPF");
        return mixins;
    }

}
