package mods.tinker.tconstruct;

import java.util.ArrayList;
import java.util.Random;

import mods.tinker.tconstruct.crafting.PatternBuilder;
import mods.tinker.tconstruct.crafting.Smeltery;
import mods.tinker.tconstruct.logic.LiquidTextureLogic;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class TEventHandler
{
	/* Ore Dictionary */
	@ForgeSubscribe
	public void registerOre (OreRegisterEvent evt)
	{
		if (evt.Name == "battery")
			TConstruct.content.modE.batteries.add(evt.Ore);

		else if (evt.Name == "basicCircuit")
			TConstruct.content.modE.circuits.add(evt.Ore);

		//Ingots
		else if (evt.Name == "ingotCopper")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Copper");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 3, 450, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 2));
		}
		
		else if (evt.Name == "ingotTin")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 5, 175, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 3));
		}

		else if (evt.Name == "ingotBronze")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Bronze");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 4, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 7));
		}
		
		else if (evt.Name == "ingotCobalt")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Cobalt");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 0, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 5));
		}
		
		else if (evt.Name == "ingotArdite")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Ardite");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 1, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 6));
		}
		
		else if (evt.Name == "ingotManyullyn")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Manyullyn");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 2, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 9));
		}
		
		else if (evt.Name == "ingotNaturalAluminum")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		else if (evt.Name == "naturalAluminum")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		else if (evt.Name == "ingotAluminumBrass")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 7, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 8));
		}
		
		else if (evt.Name == "ingotAlumite")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Alumite");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 8, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 10));
		}
		
		else if (evt.Name == "ingotSteel")
		{
			PatternBuilder.instance.registerMaterial(evt.Ore, 2, "Steel");
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 9, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 12));
		}
		
		//Ores
		else if (evt.Name == "oreCopper")
		{
			Smeltery.addMelting(evt.Ore, 550, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 2));
		}
		
		else if (evt.Name == "oreTin")
		{
			Smeltery.addMelting(evt.Ore, 275, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 3));
		}
		
		else if (evt.Name == "oreNaturalAluminum")
		{
			Smeltery.addMelting(evt.Ore, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 4));
		}
		
		else if (evt.Name == "oreCobalt")
		{
			Smeltery.addMelting(evt.Ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 5));
		}
		
		else if (evt.Name == "oreArdite")
		{
			Smeltery.addMelting(evt.Ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 6));
		}
		
		//Blocks
		else if (evt.Name == "blockCopper")
		{
			Smeltery.addMelting(evt.Ore, 550, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 2));
		}
		
		else if (evt.Name == "blockTin")
		{
			Smeltery.addMelting(evt.Ore, 275, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 3));
		}

		else if (evt.Name == "blockBronze")
		{
			Smeltery.addMelting(evt.Ore, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 7));
		}
		
		else if (evt.Name == "blockNaturalAluminum")
		{
			Smeltery.addMelting(evt.Ore, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 4));
		}
		
		else if (evt.Name == "blockCobalt")
		{
			Smeltery.addMelting(evt.Ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 5));
		}
		
		else if (evt.Name == "blockArdite")
		{
			Smeltery.addMelting(evt.Ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 6));
		}
		
		else if (evt.Name == "blockManyullyn")
		{
			Smeltery.addMelting(evt.Ore, 800, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 9));
		}
		
		else if (evt.Name == "blockAluminumBrass")
		{
			Smeltery.addMelting(evt.Ore, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 8));
		}
		
		else if (evt.Name == "blockAlumite")
		{
			Smeltery.addMelting(evt.Ore, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 10));
		}
		
		else if (evt.Name == "blockSteel")
		{
			Smeltery.addMelting(evt.Ore, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 12));
		}
		
		//Dust
		else if (evt.Name == "dustCopper")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 3, 450, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 2));
		}
		
		else if (evt.Name == "dustTin")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 5, 175, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 3));
		}

		else if (evt.Name == "dustBronze")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 4, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 7));
		}
		
		else if (evt.Name == "dustCobalt")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 0, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 5));
		}
		
		else if (evt.Name == "dustArdite")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 1, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 6));
		}
		
		else if (evt.Name == "dustManyullyn")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 2, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 9));
		}
		
		else if (evt.Name == "dustAluminum")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		else if (evt.Name == "dustNaturalAluminum")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		else if (evt.Name == "dustAluminumBrass")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 7, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 8));
		}
		
		else if (evt.Name == "dustAlumite")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 8, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 10));
		}
		
		else if (evt.Name == "dustSteel")
		{
			Smeltery.addMelting(new ItemStack(evt.Ore.itemID, 4, evt.Ore.getItemDamage()), TContent.metalBlock.blockID, 9, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 12));
		}
	}

	public void unfuxOreDictionary ()
	{
		ArrayList<ItemStack> ores = OreDictionary.getOres("ingotCopper");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Copper");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 3, 450, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 2));
		}
		
		ores = OreDictionary.getOres("ingotTin");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 5, 175, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 3));
		}
		
		ores = OreDictionary.getOres("ingotBronze");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Bronze");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 4, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 7));
		}
		
		ores = OreDictionary.getOres("ingotCobalt");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Cobalt");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 0, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 5));
		}
		
		ores = OreDictionary.getOres("ingotArdite");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Ardite");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 1, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 6));
		}
		
		ores = OreDictionary.getOres("ingotManyullyn");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Manyullyn");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 2, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 9));
		}
		
		ores = OreDictionary.getOres("naturalAluminum");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		ores = OreDictionary.getOres("ingotNaturalAluminum");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		ores = OreDictionary.getOres("ingotAluminumBrass");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 7, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 8));
		}
		
		ores = OreDictionary.getOres("ingotAlumite");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Alumite");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 8, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 10));
		}
		
		ores = OreDictionary.getOres("ingotSteel");
		for (ItemStack ore : ores)
		{
			PatternBuilder.instance.registerMaterial(ore, 2, "Steel");
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 9, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 12));
		}
		
		ores = OreDictionary.getOres("oreCopper");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 550, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 2));
		}
		
		ores = OreDictionary.getOres("oreTin");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 275, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 3));
		}
		
		ores = OreDictionary.getOres("oreNaturalAluminum");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 4));
		}
		
		ores = OreDictionary.getOres("oreCobalt");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 5));
		}
		
		ores = OreDictionary.getOres("oreArdite");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*2, 6));
		}
		
		ores = OreDictionary.getOres("blockCopper");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 550, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 2));
		}
		
		ores = OreDictionary.getOres("blockTin");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 275, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 3));
		}
		
		ores = OreDictionary.getOres("blockBronze");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 7));
		}
		
		ores = OreDictionary.getOres("blockNaturalAluminum");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 4));
		}
		
		ores = OreDictionary.getOres("blockCobalt");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 5));
		}
		
		ores = OreDictionary.getOres("blockArdite");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 6));
		}
		
		ores = OreDictionary.getOres("blockManyullyn");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 800, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 9));
		}
		
		ores = OreDictionary.getOres("blockAluminumBrass");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 8));
		}
		
		ores = OreDictionary.getOres("blockAlumite");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 10));
		}
		
		ores = OreDictionary.getOres("blockSteel");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(ore, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue*9, 12));
		}
		
		ores = OreDictionary.getOres("dustCopper");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 3, 450, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 2));
		}
		
		ores = OreDictionary.getOres("dustTin");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 5, 175, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 3));
		}
		
		ores = OreDictionary.getOres("dustBronze");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 4, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 7));
		}
		
		ores = OreDictionary.getOres("dustCobalt");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 0, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 5));
		}
		
		ores = OreDictionary.getOres("dustArdite");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 1, 650, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 6));
		}
		
		ores = OreDictionary.getOres("dustManyullyn");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 2, 750, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 9));
		}
		
		ores = OreDictionary.getOres("dustNaturalAluminum");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 6, 250, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 4));
		}
		
		ores = OreDictionary.getOres("dustAluminumBrass");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 7, 350, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 8));
		}
		
		ores = OreDictionary.getOres("dustAlumite");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 8, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 10));
		}
		
		ores = OreDictionary.getOres("dustSteel");
		for (ItemStack ore : ores)
		{
			Smeltery.addMelting(new ItemStack(ore.itemID, 4, ore.getItemDamage()), TContent.metalBlock.blockID, 9, 500, new LiquidStack(TContent.liquidMetalStill.blockID, TConstruct.ingotLiquidValue, 12));
		}
	}

	@ForgeSubscribe
	public void bucketFill (FillBucketEvent evt)
	{
		if (evt.current.getItem() == Item.bucketEmpty && evt.target.typeOfHit == EnumMovingObjectType.TILE)
		{
			int hitX = evt.target.blockX;
			int hitY = evt.target.blockY;
			int hitZ = evt.target.blockZ;

			if (!evt.entityPlayer.canPlayerEdit(hitX, hitY, hitZ, evt.target.sideHit, evt.current))
            {
				return;
                //return evt.current;
            }
			
			int bID = evt.world.getBlockId(hitX, hitY, hitZ);
			int meta = -1;
			
			if (bID == TContent.liquidMetalStill.blockID)
			{
				LiquidTextureLogic logic = (LiquidTextureLogic) evt.world.getBlockTileEntity(hitX, hitY, hitZ);
				meta = logic.getLiquidType();
			}
			
			if (meta != -1)
			{
				evt.world.setBlockToAir(hitX, hitY, hitZ); //Set air block
				evt.result = new ItemStack(TContent.buckets, 1, meta);
				evt.setResult(Result.ALLOW);
			}
		}
	}
}