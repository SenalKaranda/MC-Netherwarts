package us.catdadstudios.netherwarts;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class Wand extends Item {

    public Wand(Settings settings) {super(settings);}

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {playerEntity.playSound(SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, 1.0F, 1.0F); return TypedActionResult.success(playerEntity.getStackInHand(hand));}

    @Override
    public boolean canRepair(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.GOLD_INGOT;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {tooltip.add(Text.translatable("item.netherwarts.wand.tooltip"));}

}
