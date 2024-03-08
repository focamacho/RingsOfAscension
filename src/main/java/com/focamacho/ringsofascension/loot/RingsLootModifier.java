package com.focamacho.ringsofascension.loot;

import com.focamacho.ringsofascension.RingsOfAscension;
import com.focamacho.ringsofascension.item.ItemRingBase;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RingsLootModifier extends LootModifier {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS , RingsOfAscension.MODID);
    public static final RegistryObject<Codec<RingsLootModifier>> CODEC = REGISTER.register("rings_modifier", () ->
            RecordCodecBuilder.create(
                    inst -> LootModifier.codecStart(inst).and(
                            inst.group(
                                    Codec.list(Codec.STRING).fieldOf("loot_tables").forGetter(m -> m.lootTables),
                                    ForgeRegistries.ITEMS.getCodec().fieldOf("ring").forGetter(m -> m.item)
                            )
                    ).apply(inst, RingsLootModifier::new)
            )
    );

    public final List<String> lootTables;
    public final ItemRingBase item;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public RingsLootModifier(LootItemCondition[] conditionsIn, List<String> lootTables, Item ring) {
        super(conditionsIn);
        if(!(ring instanceof ItemRingBase)) {
            throw new IllegalArgumentException("Provided item is not a ring.");
        }

        this.lootTables = lootTables;
        this.item = (ItemRingBase) ring;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(item.isEnabled.get() && lootTables.contains(context.getQueriedLootTableId().toString())) {
            generatedLoot.add(new ItemStack(item));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
