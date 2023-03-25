package us.catdadstudios.netherwarts;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

import static us.catdadstudios.netherwarts.Netherwarts.*;

public class WandForge extends Block implements BlockEntityProvider {
    public WandForge(Settings settings) {super(settings);}

    List<Item> Tips = Arrays.asList(STONE_WAND_TIP, COPPER_WAND_TIP, IRON_WAND_TIP, LAPIS_WAND_TIP, GOLD_WAND_TIP, EMERALD_WAND_TIP, NETHERITE_WAND_TIP, DIAMOND_WAND_TIP);
    List<Item> Cores = Arrays.asList(PIGLIN_WAND_CORE, BLAZE_WAND_CORE, WITHERSKELETON_WAND_CORE);

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

        if (!player.getMainHandStack().isEmpty()) {

            if ((blockEntity.getStack(0).isEmpty()) & (player.getMainHandStack().getItem().equals(WAND_BASE.getDefaultStack().getItem()))) {
                blockEntity.setStack(0, player.getStackInHand(hand).getItem().getDefaultStack());
                player.getStackInHand(hand).setCount(0);
            }
            else if ((blockEntity.getStack(1).isEmpty()) & (Tips.contains(player.getMainHandStack().getItem()))) {
                blockEntity.setStack(1, player.getStackInHand(hand).getItem().getDefaultStack());
                player.getStackInHand(hand).setCount(0);
            }
            else if ((blockEntity.getStack(2).isEmpty()) & (Cores.contains(player.getMainHandStack().getItem()))) {
                blockEntity.setStack(2, player.getStackInHand(hand).getItem().getDefaultStack());
                player.getStackInHand(hand).setCount(0);
            }
            else {
                player.sendMessage(Text.of("Wand Forge:").copy().formatted(Formatting.GREEN));
                player.sendMessage(Text.of("Incompatible item.").copy().formatted(Formatting.RED));
                /*player.sendMessage(Text.of("The first slot holds "
                        + blockEntity.getStack(0) + " and the second slot holds "
                            + blockEntity.getStack(1) + " and the third slot holds "
                                + blockEntity.getStack(2)));*/
            }
        }
        else {
            // Find the first slot that has an item and give it to the player
            if ((!blockEntity.getStack(0).isEmpty()) & (!blockEntity.getStack(1).isEmpty()) & (!blockEntity.getStack(2).isEmpty())) {

                if(blockEntity.getStack(1).getItem().equals(STONE_WAND_TIP)){player.getInventory().offerOrDrop(STONE_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(COPPER_WAND_TIP)){player.getInventory().offerOrDrop(COPPER_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(IRON_WAND_TIP)){player.getInventory().offerOrDrop(IRON_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(LAPIS_WAND_TIP)){player.getInventory().offerOrDrop(LAPIS_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(GOLD_WAND_TIP)){player.getInventory().offerOrDrop(GOLD_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(EMERALD_WAND_TIP)){player.getInventory().offerOrDrop(EMERALD_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(NETHERITE_WAND_TIP)){player.getInventory().offerOrDrop(NETHERITE_WAND.getDefaultStack());}
                else if(blockEntity.getStack(1).getItem().equals(DIAMOND_WAND_TIP)){player.getInventory().offerOrDrop(DIAMOND_WAND.getDefaultStack());}
                blockEntity.clear();
            }
        }
        return ActionResult.SUCCESS;
    }



    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WandForgeEntity(pos, state);
    }

}
