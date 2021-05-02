package com.focamacho.ringsofascension.integration;

import com.focamacho.ringsofascension.config.ConfigRingsOfAscension;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class IntegrationModMenu implements ModMenuApi {

    @Override
    public String getModId() {
        return "ringsofascension";
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(ConfigRingsOfAscension.class, parent).get();
    }
}
