package us.catdadstudios.netherwarts;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class WandCorePiglin extends WandCore {
    public WandCorePiglin(Settings settings) {super(settings);}

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {tooltip.add(Text.translatable("item.netherwarts.piglin_wand_core.tooltip"));}
}
