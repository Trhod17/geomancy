package net.codersdownunder.gemmod.items;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.telepad.TelepadBlock;
import net.codersdownunder.gemmod.blocks.telepad.TelepadSlab;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.List;

public class TeleCoreItem extends Item {

	public TeleCoreItem(Properties pProperties) {
		super(pProperties);

	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		
		if (!itemstack.getOrCreateTag().isEmpty()) {
			list.add(new TranslatableComponent("tooltip.pos.text").append(itemstack.getOrCreateTag().get("X").toString().replace("}", "").replace("{", "").replace(",", " ")));
		} else {
			list.add(new TranslatableComponent("No pos set"));
		}
		
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
		// TODO Auto-generated method stub
		return super.initCapabilities(stack, nbt);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {

		try {
		if (pContext.getLevel().isClientSide()) {
			return InteractionResult.FAIL;
		}

		Block block = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
		ItemStack stack = new ItemStack(this);

		if ((block instanceof TelepadBlock || block instanceof TelepadSlab) && pContext.getPlayer().isShiftKeyDown() && !stack.hasTag()) {
			CompoundTag pos;
			pos = new CompoundTag();
			pos.put("X", NbtUtils.writeBlockPos(pContext.getClickedPos().above()));
			pContext.getItemInHand().setTag(pos);
		}
		} catch(Exception e)  {
			GemMod.LOGGER.debug("Telecore pos saving failed: ", e);
		}

		return InteractionResult.SUCCESS;
	}

}
