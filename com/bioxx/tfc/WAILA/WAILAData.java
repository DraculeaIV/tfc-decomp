/*      */ package com.bioxx.tfc.WAILA;
/*      */ import com.bioxx.tfc.Blocks.Flora.BlockFruitLeaves;
/*      */ import com.bioxx.tfc.Core.Player.SkillStats;
/*      */ import com.bioxx.tfc.Core.TFC_Core;
/*      */ import com.bioxx.tfc.Core.TFC_Time;
/*      */ import com.bioxx.tfc.Food.CropIndex;
/*      */ import com.bioxx.tfc.Food.FloraIndex;
/*      */ import com.bioxx.tfc.Food.FloraManager;
/*      */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*      */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*      */ import com.bioxx.tfc.TileEntities.TEBerryBush;
/*      */ import com.bioxx.tfc.TileEntities.TEBlastFurnace;
/*      */ import com.bioxx.tfc.TileEntities.TEBloom;
/*      */ import com.bioxx.tfc.TileEntities.TECrop;
/*      */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*      */ import com.bioxx.tfc.TileEntities.TEFruitLeaves;
/*      */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*      */ import com.bioxx.tfc.TileEntities.TELoom;
/*      */ import com.bioxx.tfc.TileEntities.TEMetalTrapDoor;
/*      */ import com.bioxx.tfc.TileEntities.TEOilLamp;
/*      */ import com.bioxx.tfc.TileEntities.TEOre;
/*      */ import com.bioxx.tfc.TileEntities.TESmokeRack;
/*      */ import com.bioxx.tfc.TileEntities.TEWorldItem;
/*      */ import com.bioxx.tfc.api.Constant.Global;
/*      */ import com.bioxx.tfc.api.Crafting.BarrelPreservativeRecipe;
/*      */ import com.bioxx.tfc.api.Crafting.BarrelRecipe;
/*      */ import com.bioxx.tfc.api.Crafting.LoomRecipe;
/*      */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*      */ import com.bioxx.tfc.api.Food;
/*      */ import com.bioxx.tfc.api.HeatRegistry;
/*      */ import com.bioxx.tfc.api.Interfaces.IFood;
/*      */ import com.bioxx.tfc.api.TFCBlocks;
/*      */ import com.bioxx.tfc.api.TFCFluids;
/*      */ import com.bioxx.tfc.api.TFCItems;
/*      */ import com.bioxx.tfc.api.TFCOptions;
/*      */ import com.bioxx.tfc.api.Util.Helper;
/*      */ import java.util.List;
/*      */ import mcp.mobius.waila.api.IWailaConfigHandler;
/*      */ import mcp.mobius.waila.api.IWailaDataAccessor;
/*      */ import mcp.mobius.waila.api.IWailaRegistrar;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.fluids.FluidStack;
/*      */ 
/*      */ public class WAILAData implements IWailaDataProvider {
/*      */   public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*   55 */     Block block = accessor.getBlock();
/*   56 */     TileEntity tileEntity = accessor.getTileEntity();
/*      */     
/*   58 */     World world = accessor.getWorld();
/*   59 */     MovingObjectPosition pos = accessor.getPosition();
/*      */     
/*   61 */     if (block instanceof BlockAnvil) {
/*   62 */       return anvilStack(accessor, config);
/*      */     }
/*   64 */     if (tileEntity instanceof TEBerryBush) {
/*   65 */       return berryBushStack(accessor, config);
/*      */     }
/*   67 */     if (tileEntity instanceof TEBloom) {
/*   68 */       return new ItemStack(TFCItems.rawBloom);
/*      */     }
/*   70 */     if (block instanceof BlockCharcoal) {
/*   71 */       return new ItemStack(TFCItems.coal, accessor.getMetadata(), 1);
/*      */     }
/*   73 */     if (TFC_Core.isClay(block) || TFC_Core.isClayGrass(block)) {
/*   74 */       return new ItemStack(TFCItems.clayBall);
/*      */     }
/*   76 */     if (block instanceof BlockCobble) {
/*   77 */       return new ItemStack(block, 1, accessor.getMetadata() % 8);
/*      */     }
/*   79 */     if (tileEntity instanceof TECrop) {
/*   80 */       return cropStack(accessor, config);
/*      */     }
/*   82 */     if (block instanceof BlockCustomDoor) {
/*   83 */       return new ItemStack(Recipes.doors[((BlockCustomDoor)block).getWoodType() / 2]);
/*      */     }
/*   85 */     if (tileEntity instanceof TEFruitLeaves) {
/*   86 */       return fruitLeavesStack(accessor, config);
/*      */     }
/*   88 */     if (tileEntity instanceof TEFruitTreeWood) {
/*   89 */       return fruitTreeWoodStack(accessor, config);
/*      */     }
/*   91 */     if (tileEntity instanceof TEIngotPile) {
/*   92 */       return ingotPileStack(accessor, config);
/*      */     }
/*   94 */     if (tileEntity instanceof TELoom) {
/*   95 */       return loomStack(accessor, config);
/*      */     }
/*   97 */     if (tileEntity instanceof TEMetalSheet) {
/*   98 */       return metalSheetStack(accessor, config);
/*      */     }
/*  100 */     if (tileEntity instanceof TEMetalTrapDoor) {
/*  101 */       return metalTrapDoorStack(accessor, config);
/*      */     }
/*  103 */     if (tileEntity instanceof TEOilLamp) {
/*  104 */       return oilLampStack(accessor, config);
/*      */     }
/*  106 */     if (tileEntity instanceof TEOre) {
/*  107 */       return oreStack(accessor, config);
/*      */     }
/*  109 */     if (block instanceof BlockPartial) {
/*  110 */       return partialStack(accessor, config);
/*      */     }
/*  112 */     if (block instanceof BlockWaterPlant && TFC_Core.isSaltWater(world.func_147439_a(pos.field_72311_b, pos.field_72312_c + 1, pos.field_72309_d))) {
/*  113 */       return ItemFoodTFC.createTag(new ItemStack(TFCItems.seaWeed, 1, 0));
/*      */     }
/*  115 */     if (tileEntity instanceof TEWorldItem) {
/*  116 */       return worldItemStack(accessor, config);
/*      */     }
/*  118 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  124 */     Block block = accessor.getBlock();
/*  125 */     TileEntity tileEntity = accessor.getTileEntity();
/*      */     
/*  127 */     if (tileEntity instanceof TEBarrel) {
/*  128 */       currenttip = barrelHead(itemStack, currenttip, accessor, config);
/*      */     }
/*  130 */     else if (tileEntity instanceof TEFruitLeaves) {
/*  131 */       currenttip = fruitLeavesHead(itemStack, currenttip, accessor, config);
/*      */     }
/*  133 */     else if (tileEntity instanceof TEFruitTreeWood) {
/*  134 */       currenttip = fruitTreeWoodHead(itemStack, currenttip, accessor, config);
/*      */     }
/*  136 */     else if (tileEntity instanceof TEOre) {
/*  137 */       currenttip = oreHead(itemStack, currenttip, accessor, config);
/*      */     }
/*  139 */     else if (tileEntity instanceof TESmokeRack) {
/*  140 */       currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("tile.SmokeRack.name"));
/*      */     }
/*  142 */     else if (block instanceof BlockWaterPlant) {
/*  143 */       currenttip = waterPlantHead(itemStack, currenttip, accessor, config);
/*      */     } 
/*  145 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  151 */     Block block = accessor.getBlock();
/*  152 */     TileEntity tileEntity = accessor.getTileEntity();
/*  153 */     if (tileEntity instanceof TEAnvil) {
/*  154 */       currenttip = anvilBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  156 */     else if (tileEntity instanceof TEBarrel) {
/*  157 */       currenttip = barrelBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  159 */     else if (tileEntity instanceof TEBerryBush) {
/*  160 */       currenttip = berryBushBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  162 */     else if (tileEntity instanceof TEBlastFurnace) {
/*  163 */       currenttip = blastFurnaceBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  165 */     else if (tileEntity instanceof TEBloom) {
/*  166 */       currenttip = bloomBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  168 */     else if (tileEntity instanceof TEBloomery) {
/*  169 */       currenttip = bloomeryBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  171 */     else if (tileEntity instanceof TECrop) {
/*  172 */       currenttip = cropBody(itemStack, currenttip, accessor, config);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  178 */     else if (tileEntity instanceof TEFirepit) {
/*  179 */       currenttip = firepitBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  181 */     else if (tileEntity instanceof TEForge) {
/*  182 */       currenttip = forgeBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  184 */     else if (tileEntity instanceof TEFruitLeaves) {
/*  185 */       currenttip = fruitLeavesBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  187 */     else if (tileEntity instanceof TELogPile) {
/*  188 */       currenttip = logPileBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  190 */     else if (tileEntity instanceof TELoom) {
/*  191 */       currenttip = loomBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  193 */     else if (tileEntity instanceof TEMetalTrapDoor) {
/*  194 */       currenttip = metalTrapDoorBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  196 */     else if (tileEntity instanceof TENestBox) {
/*  197 */       currenttip = nestBoxBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  199 */     else if (tileEntity instanceof TEOilLamp) {
/*  200 */       currenttip = oilLampBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  202 */     else if (tileEntity instanceof TEOre) {
/*  203 */       currenttip = oreBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  205 */     else if (tileEntity instanceof TEPottery) {
/*  206 */       currenttip = potteryBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  208 */     else if (tileEntity instanceof TESapling) {
/*  209 */       currenttip = saplingBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  211 */     else if (tileEntity instanceof TESluice) {
/*  212 */       currenttip = sluiceBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  214 */     else if (tileEntity instanceof TESmokeRack) {
/*  215 */       currenttip = smokeRackBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  217 */     else if (TFC_Core.isSoilWAILA(block)) {
/*  218 */       currenttip = soilBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  220 */     else if (tileEntity instanceof TEWorldItem) {
/*  221 */       currenttip = worldBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  223 */     else if (tileEntity instanceof TESpawnMeter) {
/*  224 */       currenttip = spawnMeterBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  226 */     else if (block == TFCBlocks.torch) {
/*  227 */       currenttip = torchBody(itemStack, currenttip, accessor, config);
/*      */     } 
/*  229 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  235 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
/*  241 */     if (te != null)
/*  242 */       te.func_145841_b(tag); 
/*  243 */     return tag;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void callbackRegister(IWailaRegistrar reg) {
/*  248 */     reg.addConfig("TerraFirmaCraft", "tfc.oreQuality");
/*      */     
/*  250 */     reg.registerStackProvider(new WAILAData(), BlockAnvil.class);
/*  251 */     reg.registerBodyProvider(new WAILAData(), TEAnvil.class);
/*  252 */     reg.registerNBTProvider(new WAILAData(), TEAnvil.class);
/*      */     
/*  254 */     reg.registerHeadProvider(new WAILAData(), TEBarrel.class);
/*  255 */     reg.registerBodyProvider(new WAILAData(), TEBarrel.class);
/*  256 */     reg.registerNBTProvider(new WAILAData(), TEBarrel.class);
/*      */     
/*  258 */     reg.registerStackProvider(new WAILAData(), TEBerryBush.class);
/*  259 */     reg.registerBodyProvider(new WAILAData(), TEBerryBush.class);
/*  260 */     reg.registerNBTProvider(new WAILAData(), TEBerryBush.class);
/*      */     
/*  262 */     reg.registerBodyProvider(new WAILAData(), TEBlastFurnace.class);
/*  263 */     reg.registerNBTProvider(new WAILAData(), TEBlastFurnace.class);
/*      */     
/*  265 */     reg.registerStackProvider(new WAILAData(), TEBloom.class);
/*  266 */     reg.registerBodyProvider(new WAILAData(), TEBloom.class);
/*  267 */     reg.registerNBTProvider(new WAILAData(), TEBloom.class);
/*      */     
/*  269 */     reg.registerBodyProvider(new WAILAData(), TEBloomery.class);
/*  270 */     reg.registerNBTProvider(new WAILAData(), TEBloomery.class);
/*      */     
/*  272 */     reg.registerStackProvider(new WAILAData(), BlockCharcoal.class);
/*  273 */     reg.registerStackProvider(new WAILAData(), BlockClay.class);
/*  274 */     reg.registerStackProvider(new WAILAData(), BlockClayGrass.class);
/*  275 */     reg.registerStackProvider(new WAILAData(), BlockCobble.class);
/*      */     
/*  277 */     reg.registerStackProvider(new WAILAData(), TECrop.class);
/*  278 */     reg.registerBodyProvider(new WAILAData(), TECrop.class);
/*  279 */     reg.registerNBTProvider(new WAILAData(), TECrop.class);
/*      */     
/*  281 */     reg.registerStackProvider(new WAILAData(), BlockCustomDoor.class);
/*      */     
/*  283 */     reg.registerBodyProvider(new WAILAData(), TEFarmland.class);
/*  284 */     reg.registerNBTProvider(new WAILAData(), TEFarmland.class);
/*      */     
/*  286 */     reg.registerBodyProvider(new WAILAData(), TEFirepit.class);
/*  287 */     reg.registerNBTProvider(new WAILAData(), TEFirepit.class);
/*      */     
/*  289 */     reg.registerBodyProvider(new WAILAData(), TEForge.class);
/*  290 */     reg.registerNBTProvider(new WAILAData(), TEForge.class);
/*      */     
/*  292 */     reg.registerStackProvider(new WAILAData(), TEFruitLeaves.class);
/*  293 */     reg.registerHeadProvider(new WAILAData(), TEFruitLeaves.class);
/*  294 */     reg.registerBodyProvider(new WAILAData(), TEFruitLeaves.class);
/*  295 */     reg.registerNBTProvider(new WAILAData(), TEFruitLeaves.class);
/*      */     
/*  297 */     reg.registerStackProvider(new WAILAData(), TEFruitTreeWood.class);
/*  298 */     reg.registerHeadProvider(new WAILAData(), TEFruitTreeWood.class);
/*      */     
/*  300 */     reg.registerStackProvider(new WAILAData(), TEIngotPile.class);
/*  301 */     reg.registerHeadProvider(new WAILAData(), TEIngotPile.class);
/*  302 */     reg.registerNBTProvider(new WAILAData(), TEIngotPile.class);
/*      */     
/*  304 */     reg.registerBodyProvider(new WAILAData(), TELogPile.class);
/*  305 */     reg.registerNBTProvider(new WAILAData(), TELogPile.class);
/*      */     
/*  307 */     reg.registerStackProvider(new WAILAData(), TELoom.class);
/*  308 */     reg.registerBodyProvider(new WAILAData(), TELoom.class);
/*  309 */     reg.registerNBTProvider(new WAILAData(), TELoom.class);
/*      */     
/*  311 */     reg.registerStackProvider(new WAILAData(), TEMetalSheet.class);
/*  312 */     reg.registerNBTProvider(new WAILAData(), TEMetalSheet.class);
/*      */     
/*  314 */     reg.registerStackProvider(new WAILAData(), TEMetalTrapDoor.class);
/*  315 */     reg.registerBodyProvider(new WAILAData(), TEMetalTrapDoor.class);
/*  316 */     reg.registerNBTProvider(new WAILAData(), TEMetalTrapDoor.class);
/*      */     
/*  318 */     reg.registerBodyProvider(new WAILAData(), TENestBox.class);
/*  319 */     reg.registerNBTProvider(new WAILAData(), TENestBox.class);
/*      */     
/*  321 */     reg.registerStackProvider(new WAILAData(), TEOilLamp.class);
/*  322 */     reg.registerBodyProvider(new WAILAData(), TEOilLamp.class);
/*  323 */     reg.registerNBTProvider(new WAILAData(), TEOilLamp.class);
/*      */     
/*  325 */     reg.registerStackProvider(new WAILAData(), TEOre.class);
/*  326 */     reg.registerHeadProvider(new WAILAData(), TEOre.class);
/*  327 */     reg.registerBodyProvider(new WAILAData(), TEOre.class);
/*      */     
/*  329 */     reg.registerStackProvider(new WAILAData(), BlockPartial.class);
/*  330 */     reg.registerNBTProvider(new WAILAData(), BlockPartial.class);
/*      */     
/*  332 */     reg.registerBodyProvider(new WAILAData(), TEPottery.class);
/*  333 */     reg.registerNBTProvider(new WAILAData(), TEPottery.class);
/*      */     
/*  335 */     reg.registerBodyProvider(new WAILAData(), TESapling.class);
/*  336 */     reg.registerNBTProvider(new WAILAData(), TESapling.class);
/*      */     
/*  338 */     reg.registerBodyProvider(new WAILAData(), TESluice.class);
/*  339 */     reg.registerNBTProvider(new WAILAData(), TESluice.class);
/*      */     
/*  341 */     reg.registerHeadProvider(new WAILAData(), TESmokeRack.class);
/*  342 */     reg.registerBodyProvider(new WAILAData(), TESmokeRack.class);
/*  343 */     reg.registerNBTProvider(new WAILAData(), TESmokeRack.class);
/*      */     
/*  345 */     reg.registerBodyProvider(new WAILAData(), TESpawnMeter.class);
/*  346 */     reg.registerNBTProvider(new WAILAData(), TESpawnMeter.class);
/*      */ 
/*      */     
/*  349 */     reg.registerBodyProvider(new WAILAData(), BlockDirt.class);
/*  350 */     reg.registerBodyProvider(new WAILAData(), BlockSand.class);
/*  351 */     reg.registerBodyProvider(new WAILAData(), BlockGrass.class);
/*  352 */     reg.registerBodyProvider(new WAILAData(), BlockGravel.class);
/*      */     
/*  354 */     reg.registerBodyProvider(new WAILAData(), BlockTorch.class);
/*  355 */     reg.registerNBTProvider(new WAILAData(), BlockTorch.class);
/*  356 */     reg.registerStackProvider(new WAILAData(), BlockWaterPlant.class);
/*  357 */     reg.registerHeadProvider(new WAILAData(), BlockWaterPlant.class);
/*      */     
/*  359 */     reg.registerStackProvider(new WAILAData(), TEWorldItem.class);
/*  360 */     reg.registerNBTProvider(new WAILAData(), TEWorldItem.class);
/*  361 */     reg.registerBodyProvider(new WAILAData(), TEWorldItem.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ItemStack anvilStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  368 */     Block block = accessor.getBlock();
/*  369 */     int meta = accessor.getMetadata();
/*  370 */     int type = BlockAnvil.getAnvilTypeFromMeta(meta);
/*      */     
/*  372 */     return new ItemStack(block, 1, type);
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack berryBushStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  377 */     NBTTagCompound tag = accessor.getNBTData();
/*  378 */     boolean hasFruit = tag.func_74767_n("hasFruit");
/*  379 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockBerryBush.metaNames[accessor.getMetadata()]);
/*      */     
/*  381 */     if (hasFruit) {
/*  382 */       return ItemFoodTFC.createTag(index.getOutput());
/*      */     }
/*  384 */     return null;
/*      */   }
/*      */   
/*      */   public ItemStack cropStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*      */     ItemStack itemstack;
/*  389 */     NBTTagCompound tag = accessor.getNBTData();
/*  390 */     int cropId = tag.func_74762_e("cropId");
/*      */     
/*  392 */     CropIndex crop = CropManager.getInstance().getCropFromId(cropId);
/*      */ 
/*      */     
/*  395 */     if (crop.output2 != null) {
/*  396 */       itemstack = new ItemStack(crop.output2);
/*      */     } else {
/*  398 */       itemstack = new ItemStack(crop.output1);
/*      */     } 
/*  400 */     ItemFoodTFC.createTag(itemstack);
/*  401 */     return itemstack;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack fruitLeavesStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  406 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockFruitLeaves.getType(accessor.getBlock(), accessor.getMetadata() % 8));
/*      */     
/*  408 */     if (index != null) {
/*  409 */       return ItemFoodTFC.createTag(index.getOutput());
/*      */     }
/*  411 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack fruitTreeWoodStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  416 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockFruitWood.getType(accessor.getMetadata()));
/*      */     
/*  418 */     if (index != null) {
/*  419 */       return ItemFoodTFC.createTag(index.getOutput());
/*      */     }
/*  421 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack ingotPileStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  426 */     NBTTagCompound tag = accessor.getNBTData();
/*  427 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  429 */     if (storage[0] != null) {
/*  430 */       return storage[0];
/*      */     }
/*  432 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack loomStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  437 */     NBTTagCompound tag = accessor.getNBTData();
/*  438 */     boolean finished = tag.func_74767_n("finished");
/*  439 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  441 */     if (finished && storage[1] != null)
/*      */     {
/*  443 */       return storage[1];
/*      */     }
/*  445 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack metalSheetStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  450 */     NBTTagCompound tag = accessor.getNBTData();
/*  451 */     return ItemStack.func_77949_a(tag.func_74775_l("sheetType"));
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack metalTrapDoorStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  456 */     NBTTagCompound tag = accessor.getNBTData();
/*  457 */     return ItemStack.func_77949_a(tag.func_74775_l("sheetType"));
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack oilLampStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  462 */     int meta = accessor.getMetadata();
/*  463 */     if ((meta & 0x8) != 0) {
/*  464 */       meta -= 8;
/*      */     }
/*  466 */     return new ItemStack(TFCBlocks.oilLamp, 1, meta);
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack oreStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  471 */     int meta = accessor.getMetadata();
/*  472 */     TEOre te = (TEOre)accessor.getTileEntity();
/*  473 */     ItemStack itemstack = null;
/*      */     
/*  475 */     if (accessor.getBlock() == TFCBlocks.ore) {
/*      */       
/*  477 */       if (config.getConfig("tfc.oreQuality")) {
/*  478 */         itemstack = new ItemStack(TFCItems.oreChunk, 1, getOreGrade(te, meta));
/*      */       } else {
/*  480 */         itemstack = new ItemStack(TFCItems.oreChunk, 1, meta);
/*      */       } 
/*  482 */       if (meta == 14 || meta == 15) {
/*  483 */         itemstack = new ItemStack(TFCItems.coal);
/*      */       }
/*  485 */       return itemstack;
/*      */     } 
/*  487 */     if (accessor.getBlock() == TFCBlocks.ore2) {
/*      */       
/*  489 */       itemstack = new ItemStack(TFCItems.oreChunk, 1, meta + Global.ORE_METAL.length);
/*  490 */       if (meta == 5) {
/*  491 */         itemstack = new ItemStack(TFCItems.gemDiamond);
/*  492 */       } else if (meta == 13) {
/*  493 */         itemstack = new ItemStack(TFCItems.powder, 1, 4);
/*      */       } 
/*  495 */       return itemstack;
/*      */     } 
/*  497 */     if (accessor.getBlock() == TFCBlocks.ore3) {
/*      */       
/*  499 */       itemstack = new ItemStack(TFCItems.oreChunk, 1, meta + Global.ORE_METAL.length + Global.ORE_MINERAL.length);
/*  500 */       return itemstack;
/*      */     } 
/*      */     
/*  503 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack partialStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  508 */     NBTTagCompound tag = accessor.getNBTData();
/*  509 */     byte metaID = tag.func_74771_c("metaID");
/*  510 */     int typeID = tag.func_74765_d("typeID");
/*      */     
/*  512 */     return new ItemStack(Block.func_149729_e(typeID), 1, metaID);
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack worldItemStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  517 */     NBTTagCompound tag = accessor.getNBTData();
/*  518 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  519 */     return storage[0];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> barrelHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  525 */     String head = currenttip.get(0);
/*  526 */     NBTTagCompound tag = accessor.getNBTData();
/*  527 */     FluidStack fluid = FluidStack.loadFluidStackFromNBT(tag.func_74775_l("fluidNBT"));
/*      */     
/*  529 */     if (fluid != null) {
/*      */       
/*  531 */       head = head + " (" + fluid.getLocalizedName() + ")";
/*  532 */       currenttip.set(0, head);
/*      */     } 
/*  534 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> fruitLeavesHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  539 */     NBTTagCompound tag = accessor.getNBTData();
/*  540 */     boolean hasFruit = tag.func_74767_n("hasFruit");
/*  541 */     String type = BlockFruitLeaves.getType(accessor.getBlock(), accessor.getMetadata());
/*      */     
/*  543 */     if (!hasFruit) {
/*  544 */       currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("gui." + type));
/*      */     }
/*  546 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> fruitTreeWoodHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  551 */     String type = BlockFruitWood.getType(accessor.getMetadata());
/*      */     
/*  553 */     currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("gui." + type));
/*      */     
/*  555 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> ingotPileHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  560 */     String head = currenttip.get(0);
/*  561 */     currenttip.set(0, head + " " + TFC_Core.translate("gui.pile"));
/*  562 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> oreHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  567 */     int meta = accessor.getMetadata();
/*      */     
/*  569 */     if (accessor.getBlock() == TFCBlocks.ore) {
/*      */       
/*  571 */       if (meta == 14)
/*      */       {
/*  573 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Bituminous Coal.name"));
/*      */       }
/*  575 */       else if (meta == 15)
/*      */       {
/*  577 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Lignite.name"));
/*      */       }
/*      */     
/*  580 */     } else if (accessor.getBlock() == TFCBlocks.ore2) {
/*      */       
/*  582 */       if (meta == 5) {
/*      */         
/*  584 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Kimberlite.name"));
/*      */       }
/*  586 */       else if (meta == 13) {
/*      */         
/*  588 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Saltpeter.name"));
/*      */       } 
/*      */     } 
/*      */     
/*  592 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> waterPlantHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  597 */     MovingObjectPosition pos = accessor.getPosition();
/*  598 */     World world = accessor.getWorld();
/*  599 */     Block blockDirectlyAbove = world.func_147439_a(pos.field_72311_b, pos.field_72312_c + 1, pos.field_72309_d);
/*  600 */     boolean airTwoAbove = world.func_147437_c(pos.field_72311_b, pos.field_72312_c + 2, pos.field_72309_d);
/*      */     
/*  602 */     if (TFC_Core.isFreshWater(blockDirectlyAbove))
/*      */     {
/*  604 */       if (airTwoAbove) {
/*      */         
/*  606 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("tile.Flora.Cat Tails.name"));
/*      */       }
/*      */       else {
/*      */         
/*  610 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("tile.Flora.Pond Weed.name"));
/*      */       } 
/*      */     }
/*      */     
/*  614 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> anvilBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  620 */     NBTTagCompound tag = accessor.getNBTData();
/*      */     
/*  622 */     int tier = tag.func_74762_e("Tier");
/*  623 */     currenttip.add(TFC_Core.translate("gui.tier") + " : " + tier);
/*      */     
/*  625 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  626 */     ItemStack flux = storage[6];
/*      */     
/*  628 */     if (flux != null && flux.func_77973_b() == TFCItems.powder && flux.func_77960_j() == 0 && flux.field_77994_a > 0) {
/*  629 */       currenttip.add(TFC_Core.translate("item.Powder.Flux.name") + " : " + flux.field_77994_a);
/*      */     }
/*  631 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> barrelBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  636 */     TEBarrel te = (TEBarrel)accessor.getTileEntity();
/*  637 */     NBTTagCompound tag = accessor.getNBTData();
/*  638 */     ItemStack[] storage = getStorage(tag, (TileEntity)te);
/*  639 */     ItemStack inStack = storage[0];
/*      */     
/*  641 */     Boolean sealed = Boolean.valueOf(te.getSealed());
/*  642 */     int sealTime = accessor.getNBTInteger(tag, "SealTime");
/*  643 */     FluidStack fluid = FluidStack.loadFluidStackFromNBT(tag.func_74775_l("fluidNBT"));
/*  644 */     BarrelRecipe recipe = BarrelManager.getInstance().findMatchingRecipe(inStack, fluid, sealed.booleanValue(), te.getTechLevel());
/*      */     
/*  646 */     if (sealed.booleanValue() && fluid != null && fluid.getFluid() == TFCFluids.MILKCURDLED && (inStack == null || (inStack
/*  647 */       .func_77973_b() instanceof IFood && ((IFood)inStack.func_77973_b()).getFoodGroup() != EnumFoodGroup.Dairy && ((IFood)inStack.func_77973_b()).isEdible(inStack) && Food.getWeight(inStack) <= 20.0F))) {
/*  648 */       recipe = (new BarrelRecipe(null, new FluidStack(TFCFluids.MILKCURDLED, 10000), ItemFoodTFC.createTag(new ItemStack(TFCItems.cheese, 1), 160.0F), null)).setMinTechLevel(0);
/*      */     }
/*      */     
/*  651 */     if (fluid != null)
/*      */     {
/*  653 */       currenttip.add(fluid.amount + "/" + te.getMaxLiquid() + " mB");
/*      */     }
/*      */ 
/*      */     
/*  657 */     if (sealed.booleanValue() && sealTime != 0)
/*      */     {
/*  659 */       currenttip.add(TFC_Core.translate("gui.Barrel.SealedOn") + " : " + TFC_Time.getDateStringFromHours(sealTime));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  664 */     BarrelPreservativeRecipe preservative = BarrelManager.getInstance().findMatchingPreservativeRepice(te, inStack, fluid, sealed.booleanValue());
/*      */ 
/*      */     
/*  667 */     if (recipe != null) {
/*      */       
/*  669 */       if (!(recipe instanceof com.bioxx.tfc.api.Crafting.BarrelBriningRecipe))
/*      */       {
/*  671 */         currenttip.add(TFC_Core.translate("gui.Output") + " : " + recipe.getRecipeName());
/*      */       }
/*  673 */       else if (sealed.booleanValue() && fluid != null && fluid.getFluid() == TFCFluids.BRINE)
/*      */       {
/*  675 */         if (inStack != null && inStack.func_77973_b() instanceof IFood && (((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack.func_77973_b() == TFCItems.cheese) && !Food.isBrined(inStack))
/*      */         {
/*  677 */           currenttip.add(TFC_Core.translate("gui.barrel.brining"));
/*      */         }
/*      */       }
/*      */     
/*  681 */     } else if (sealed.booleanValue() && fluid != null && inStack != null && inStack.func_77973_b() instanceof IFood && fluid.getFluid() == TFCFluids.VINEGAR) {
/*      */       
/*  683 */       if (!Food.isPickled(inStack) && Food.getWeight(inStack) / fluid.amount <= 160.0F / te.getMaxLiquid()) {
/*      */         
/*  685 */         if ((((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack.func_77973_b() == TFCItems.cheese) && Food.isBrined(inStack))
/*      */         {
/*  687 */           currenttip.add(TFC_Core.translate("gui.barrel.pickling"));
/*      */         }
/*      */       }
/*  690 */       else if (Food.isPickled(inStack) && Food.getWeight(inStack) / fluid.amount <= 160.0F / te.getMaxLiquid() * 2.0F) {
/*      */         
/*  692 */         currenttip.add(TFC_Core.translate("gui.barrel.preserving"));
/*      */       } 
/*  694 */     } else if (preservative != null) {
/*  695 */       currenttip.add(TFC_Core.translate(preservative.getPreservingString()));
/*      */     } 
/*      */     
/*  698 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> berryBushBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  703 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockBerryBush.metaNames[accessor.getMetadata()]);
/*  704 */     currenttip.add(TFC_Time.SEASONS[index.harvestStart] + " - " + TFC_Time.SEASONS[index.harvestFinish]);
/*  705 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> blastFurnaceBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  710 */     TEBlastFurnace te = (TEBlastFurnace)accessor.getTileEntity();
/*  711 */     NBTTagCompound tag = accessor.getNBTData();
/*      */     
/*  713 */     int charcoalCount = tag.func_74762_e("charcoalCount");
/*  714 */     int oreCount = tag.func_74771_c("oreCount");
/*  715 */     int stackSize = tag.func_74762_e("maxValidStackSize");
/*  716 */     float temperature = 0.0F;
/*      */     
/*  718 */     ItemStack[] storage = getStorage(tag, (TileEntity)te);
/*  719 */     ItemStack oreStack = storage[0];
/*      */     
/*  721 */     HeatRegistry manager = HeatRegistry.getInstance();
/*      */     
/*  723 */     if (oreStack != null) {
/*      */       
/*  725 */       HeatIndex index = manager.findMatchingIndex(oreStack);
/*  726 */       if (index != null)
/*      */       {
/*  728 */         temperature = TFC_ItemHeat.getTemp(oreStack);
/*      */       }
/*      */     } 
/*  731 */     String temp = TFC_ItemHeat.getHeatColor(temperature, te.maxFireTempScale);
/*      */     
/*  733 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Charcoal") + " : " + charcoalCount + "/" + (stackSize * 4));
/*  734 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Ore") + " : " + oreCount + "/" + (stackSize * 4));
/*      */     
/*  736 */     if (te.storage[1] != null) {
/*  737 */       currenttip.add(TFC_Core.translate("gui.plans.tuyere") + EnumChatFormatting.GREEN.toString() + " ✔");
/*      */     } else {
/*  739 */       currenttip.add(TFC_Core.translate("gui.plans.tuyere") + EnumChatFormatting.RED.toString() + " ✘");
/*      */     } 
/*  741 */     if (temperature > 0.0F)
/*      */     {
/*  743 */       currenttip.add(temp);
/*      */     }
/*      */     
/*  746 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> bloomBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  751 */     NBTTagCompound tag = accessor.getNBTData();
/*  752 */     int size = tag.func_74762_e("size");
/*      */     
/*  754 */     currenttip.add(TFC_Core.translate("gui.units") + " : " + size);
/*  755 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> bloomeryBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  760 */     NBTTagCompound tag = accessor.getNBTData();
/*  761 */     boolean isLit = tag.func_74767_n("isLit");
/*  762 */     int charcoalCount = tag.func_74762_e("charcoalCount");
/*  763 */     int oreCount = tag.func_74762_e("oreCount");
/*      */     
/*  765 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Charcoal") + " : " + charcoalCount);
/*  766 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Ore") + " : " + oreCount);
/*      */     
/*  768 */     if (isLit) {
/*      */       
/*  770 */       long hours = tag.func_74763_f("fuelTimeLeft") / 1000L - TFC_Time.getTotalHours();
/*      */       
/*  772 */       if (hours > 0L) {
/*      */         
/*  774 */         float percent = Helper.roundNumber(Math.min(100.0F - (float)hours / TFCOptions.bloomeryBurnTime * 100.0F, 100.0F), 10.0F);
/*  775 */         currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + percent + "%)");
/*      */       } 
/*      */     } 
/*      */     
/*  779 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> cropBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  784 */     NBTTagCompound tag = accessor.getNBTData();
/*  785 */     float growth = tag.func_74760_g("growth");
/*  786 */     int cropId = tag.func_74762_e("cropId");
/*      */     
/*  788 */     CropIndex crop = CropManager.getInstance().getCropFromId(cropId);
/*  789 */     int percentGrowth = (int)Math.min(growth / crop.numGrowthStages * 100.0F, 100.0F);
/*      */     
/*  791 */     if (percentGrowth < 100) {
/*  792 */       currenttip.add(TFC_Core.translate("gui.growth") + " : " + percentGrowth + "%");
/*      */     } else {
/*  794 */       currenttip.add(TFC_Core.translate("gui.growth") + " : " + TFC_Core.translate("gui.mature"));
/*      */     } 
/*  796 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> farmlandBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  801 */     SkillStats.SkillRank rank = TFC_Core.getSkillStats(accessor.getPlayer()).getSkillRank("skill.agriculture");
/*  802 */     if (rank == SkillStats.SkillRank.Expert || rank == SkillStats.SkillRank.Master) {
/*      */       
/*  804 */       TEFarmland te = (TEFarmland)accessor.getTileEntity();
/*  805 */       NBTTagCompound tag = accessor.getNBTData();
/*      */       
/*  807 */       int[] nutrients = tag.func_74759_k("nutrients");
/*  808 */       int soilMax = te.getSoilMax();
/*      */       
/*  810 */       for (int i = 0; i < nutrients.length; i++) {
/*      */         
/*  812 */         int percent = Math.max(nutrients[i] * 100 / soilMax, 0);
/*      */         
/*  814 */         if (i == 0) {
/*  815 */           currenttip.add(EnumChatFormatting.RED + TFC_Core.translate("gui.Nutrient.A") + " : " + percent + "%");
/*  816 */         } else if (i == 1) {
/*  817 */           currenttip.add(EnumChatFormatting.GOLD + TFC_Core.translate("gui.Nutrient.B") + " : " + percent + "%");
/*  818 */         } else if (i == 2) {
/*  819 */           currenttip.add(EnumChatFormatting.YELLOW + TFC_Core.translate("gui.Nutrient.C") + " : " + percent + "%");
/*  820 */         } else if (i == 3 && percent != 0) {
/*  821 */           currenttip.add(EnumChatFormatting.WHITE + TFC_Core.translate("item.Fertilizer.name") + " : " + percent + "%");
/*      */         } 
/*      */       } 
/*      */     } 
/*  825 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> firepitBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  830 */     NBTTagCompound tag = accessor.getNBTData();
/*  831 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  833 */     if (storage != null) {
/*      */       
/*  835 */       int fuelCount = 0;
/*  836 */       for (ItemStack is : storage) {
/*      */         
/*  838 */         if (is != null && is.func_77973_b() != null && (is.func_77973_b() == TFCItems.logs || is.func_77973_b() == Item.func_150898_a(TFCBlocks.peat))) {
/*  839 */           fuelCount++;
/*      */         }
/*      */       } 
/*  842 */       if (fuelCount > 0) {
/*  843 */         currenttip.add(TFC_Core.translate("gui.fuel") + " : " + fuelCount + "/4");
/*      */       }
/*      */     } 
/*  846 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> forgeBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  851 */     NBTTagCompound tag = accessor.getNBTData();
/*  852 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  854 */     if (storage != null) {
/*      */       
/*  856 */       int fuelCount = 0;
/*  857 */       boolean hasMold = false;
/*      */       
/*  859 */       for (int i = 5; i <= 9; i++) {
/*      */         
/*  861 */         if (storage[i] != null && storage[i].func_77973_b() != null && storage[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemCoal) {
/*  862 */           fuelCount++;
/*      */         }
/*      */       } 
/*  865 */       if (fuelCount > 0) {
/*  866 */         currenttip.add(TFC_Core.translate("gui.fuel") + " : " + fuelCount + "/5");
/*      */       }
/*  868 */       for (int j = 10; j <= 13; j++) {
/*      */         
/*  870 */         if (storage[j] != null && storage[j].func_77973_b() == TFCItems.ceramicMold && (storage[j]).field_77994_a > 0)
/*  871 */           hasMold = true; 
/*      */       } 
/*  873 */       if (hasMold) {
/*  874 */         currenttip.add(TFC_Core.translate("item.Mold.Ceramic Mold.name") + EnumChatFormatting.GREEN.toString() + " ✔");
/*      */       } else {
/*  876 */         currenttip.add(TFC_Core.translate("item.Mold.Ceramic Mold.name") + EnumChatFormatting.RED.toString() + " ✘");
/*      */       } 
/*      */     } 
/*  879 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> fruitLeavesBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  884 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockFruitLeaves.getType(accessor.getBlock(), accessor.getMetadata()));
/*  885 */     if (index != null)
/*  886 */       currenttip.add(TFC_Time.SEASONS[index.harvestStart] + " - " + TFC_Time.SEASONS[index.harvestFinish]); 
/*  887 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> logPileBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  892 */     NBTTagCompound tag = accessor.getNBTData();
/*  893 */     Boolean isOnFire = Boolean.valueOf(tag.func_74767_n("isOnFire"));
/*      */     
/*  895 */     if (isOnFire.booleanValue()) {
/*      */       
/*  897 */       int fireTimer = tag.func_74762_e("fireTimer");
/*  898 */       int hours = (int)(TFCOptions.charcoalPitBurnTime - (float)(TFC_Time.getTotalHours() - fireTimer));
/*  899 */       currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(100.0F - hours / TFCOptions.charcoalPitBurnTime * 100.0F, 10.0F) + "%)");
/*      */     }
/*      */     else {
/*      */       
/*  903 */       ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  904 */       boolean[] counted = { false, false, false, false };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  911 */       for (int j = 0; j < storage.length; j++) {
/*      */         
/*  913 */         if (storage[j] != null && !counted[j]) {
/*      */           
/*  915 */           String log = storage[j].func_82833_r() + " : ";
/*  916 */           int count = (storage[j]).field_77994_a;
/*  917 */           for (int k = j + 1; k < storage.length; k++) {
/*      */             
/*  919 */             if (storage[k] != null && storage[j].func_77969_a(storage[k])) {
/*      */               
/*  921 */               count += (storage[k]).field_77994_a;
/*  922 */               counted[k] = true;
/*      */             } 
/*      */           } 
/*  925 */           currenttip.add(log + count);
/*  926 */           counted[j] = true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  931 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> loomBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  936 */     NBTTagCompound tag = accessor.getNBTData();
/*  937 */     boolean finished = tag.func_74767_n("finished");
/*  938 */     int wovenStrings = tag.func_74762_e("cloth");
/*  939 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  941 */     if (!finished && storage[0] != null) {
/*      */       
/*  943 */       LoomRecipe recipe = LoomManager.getInstance().findPotentialRecipes(storage[0]);
/*  944 */       int maxStrings = recipe.getReqSize();
/*      */       
/*  946 */       if ((storage[0]).field_77994_a < maxStrings) {
/*      */         
/*  948 */         String name = storage[0].func_82833_r() + " : ";
/*  949 */         currenttip.add(name + (storage[0]).field_77994_a + "/" + maxStrings);
/*      */       }
/*      */       else {
/*      */         
/*  953 */         String name = recipe.getOutItemStack().func_82833_r() + " : ";
/*  954 */         int percent = (int)(100.0D * wovenStrings / maxStrings);
/*  955 */         currenttip.add(TFC_Core.translate("gui.weaving") + " " + name + percent + "%");
/*      */       } 
/*      */     } 
/*      */     
/*  959 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> metalTrapDoorBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  964 */     NBTTagCompound tag = accessor.getNBTData();
/*  965 */     ItemStack sheetStack = ItemStack.func_77949_a(tag.func_74775_l("sheetType"));
/*      */     
/*  967 */     String metalType = BlockMetalTrapDoor.metalNames[sheetStack.func_77960_j() & 0x1F];
/*  968 */     currenttip.add(TFC_Core.translate("gui.metal." + metalType.replaceAll("\\s", "")));
/*  969 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> nestBoxBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  974 */     NBTTagCompound tag = accessor.getNBTData();
/*  975 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  976 */     int eggCount = 0, fertEggCount = 0;
/*      */     
/*  978 */     for (ItemStack is : storage) {
/*      */       
/*  980 */       if (is != null && is.func_77973_b() == TFCItems.egg)
/*      */       {
/*  982 */         if (is.func_77942_o() && is.func_77978_p().func_74764_b("Fertilized")) {
/*  983 */           fertEggCount++;
/*      */         } else {
/*  985 */           eggCount++;
/*      */         } 
/*      */       }
/*      */     } 
/*  989 */     if (eggCount > 0)
/*  990 */       currenttip.add(TFC_Core.translate("gui.eggs") + " : " + eggCount); 
/*  991 */     if (fertEggCount > 0) {
/*  992 */       currenttip.add(TFC_Core.translate("gui.fertEggs") + " : " + fertEggCount);
/*      */     }
/*  994 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> oilLampBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  999 */     NBTTagCompound tag = accessor.getNBTData();
/* 1000 */     if (tag.func_74764_b("Fuel")) {
/*      */       
/* 1002 */       FluidStack fuel = FluidStack.loadFluidStackFromNBT(tag.func_74775_l("Fuel"));
/* 1003 */       int hours = fuel.amount * TFCOptions.oilLampFuelMult / 8;
/* 1004 */       if (fuel.getFluid() == TFCFluids.OLIVEOIL) {
/* 1005 */         currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(hours / 250.0F * TFCOptions.oilLampFuelMult * 100.0F, 10.0F) + "%)");
/* 1006 */       } else if (fuel.getFluid() == TFCFluids.LAVA) {
/* 1007 */         currenttip.add(TFC_Core.translate("gui.infinite") + " " + TFC_Core.translate("gui.hoursRemaining"));
/*      */       } 
/* 1009 */     }  return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> oreBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1014 */     int meta = accessor.getMetadata();
/*      */     
/* 1016 */     if (accessor.getBlock() == TFCBlocks.ore) {
/*      */       
/* 1018 */       switch (meta) {
/*      */         
/*      */         case 0:
/*      */         case 9:
/*      */         case 13:
/* 1023 */           currenttip.add(TFC_Core.translate("gui.metal.Copper"));
/*      */           break;
/*      */         case 1:
/* 1026 */           currenttip.add(TFC_Core.translate("gui.metal.Gold"));
/*      */           break;
/*      */         case 2:
/* 1029 */           currenttip.add(TFC_Core.translate("gui.ore.Platinum"));
/*      */           break;
/*      */         case 3:
/*      */         case 10:
/*      */         case 11:
/* 1034 */           currenttip.add(TFC_Core.translate("gui.metal.Iron"));
/*      */           break;
/*      */         case 4:
/* 1037 */           currenttip.add(TFC_Core.translate("gui.metal.Silver"));
/*      */           break;
/*      */         case 5:
/* 1040 */           currenttip.add(TFC_Core.translate("gui.metal.Tin"));
/*      */           break;
/*      */         case 6:
/* 1043 */           currenttip.add(TFC_Core.translate("gui.ore.Lead"));
/*      */           break;
/*      */         case 7:
/* 1046 */           currenttip.add(TFC_Core.translate("gui.metal.Bismuth"));
/*      */           break;
/*      */         case 8:
/* 1049 */           currenttip.add(TFC_Core.translate("gui.metal.Nickel"));
/*      */           break;
/*      */         case 12:
/* 1052 */           currenttip.add(TFC_Core.translate("gui.metal.Zinc"));
/*      */           break;
/*      */         case 14:
/*      */         case 15:
/* 1056 */           currenttip.add(TFC_Core.translate("item.coal.coal.name"));
/* 1057 */           return currenttip;
/*      */       } 
/*      */       
/* 1060 */       if (config.getConfig("tfc.oreQuality"))
/*      */       {
/* 1062 */         TEOre te = (TEOre)accessor.getTileEntity();
/*      */         
/* 1064 */         int ore = getOreGrade(te, meta);
/*      */         
/* 1066 */         int units = (ore < 14) ? TFCOptions.normalOreUnits : ((ore < 49) ? TFCOptions.richOreUnits : ((ore < 63) ? TFCOptions.poorOreUnits : 0));
/* 1067 */         if (units > 0) {
/* 1068 */           currenttip.add(TFC_Core.translate("gui.units") + " : " + units);
/*      */         }
/*      */       }
/*      */     
/* 1072 */     } else if (accessor.getBlock() == TFCBlocks.ore2) {
/*      */       
/* 1074 */       switch (meta) {
/*      */         
/*      */         case 1:
/* 1077 */           currenttip.add(TFC_Core.translate("gui.ore.gypsum"));
/*      */           break;
/*      */         case 2:
/* 1080 */           currenttip.add(TFC_Core.translate("gui.ore.satinspar"));
/*      */           break;
/*      */         case 3:
/* 1083 */           currenttip.add(TFC_Core.translate("gui.ore.selenite"));
/*      */           break;
/*      */         case 6:
/* 1086 */           currenttip.add(TFC_Core.translate("gui.ore.petrifiedwood"));
/*      */           break;
/*      */         case 7:
/* 1089 */           currenttip.add(TFC_Core.translate("gui.ore.sulphur"));
/*      */           break;
/*      */         case 8:
/* 1092 */           currenttip.add(TFC_Core.translate("gui.ore.jet"));
/*      */           break;
/*      */         case 9:
/* 1095 */           currenttip.add(TFC_Core.translate("gui.ore.microcline"));
/*      */           break;
/*      */         case 10:
/* 1098 */           currenttip.add(TFC_Core.translate("gui.ore.pitchblende"));
/*      */           break;
/*      */         case 14:
/* 1101 */           currenttip.add(TFC_Core.translate("gui.ore.serpentine"));
/*      */           break;
/*      */         case 5:
/* 1104 */           currenttip.add(TFC_Core.translate("item.Diamond.Normal.name"));
/*      */           break;
/*      */         case 11:
/*      */         case 12:
/* 1108 */           currenttip.add(TFC_Core.translate("item.redstone.name"));
/*      */           break;
/*      */         case 15:
/* 1111 */           currenttip.add(TFC_Core.translate("item.Fertilizer.name"));
/*      */           break;
/*      */       } 
/*      */     
/* 1115 */     } else if (accessor.getBlock() == TFCBlocks.ore3) {
/*      */       
/* 1117 */       switch (meta) {
/*      */         
/*      */         case 0:
/* 1120 */           currenttip.add(TFC_Core.translate("item.Powder.Flux.name"));
/*      */           break;
/*      */         case 1:
/* 1123 */           currenttip.add(TFC_Core.translate("gui.ore.olivine"));
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/* 1128 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> potteryBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1133 */     NBTTagCompound tag = accessor.getNBTData();
/* 1134 */     long burnStart = tag.func_74763_f("burnStart");
/* 1135 */     int wood = tag.func_74762_e("wood");
/* 1136 */     int straw = tag.func_74762_e("straw");
/*      */     
/* 1138 */     if (straw > 0 && straw < 8) {
/* 1139 */       currenttip.add(TFC_Core.translate("item.Straw.name") + " : " + straw + "/8");
/* 1140 */     } else if (wood > 0 && wood < 8) {
/* 1141 */       currenttip.add(TFC_Core.translate("gui.logs") + " : " + wood + "/8");
/* 1142 */     } else if (burnStart > 0L) {
/*      */       
/* 1144 */       int hours = (int)(TFCOptions.pitKilnBurnTime - (float)(TFC_Time.getTotalHours() - burnStart / 1000L));
/* 1145 */       currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(100.0F - hours / TFCOptions.pitKilnBurnTime * 100.0F, 10.0F) + "%)");
/*      */     } 
/*      */     
/* 1148 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> saplingBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1153 */     NBTTagCompound tag = accessor.getNBTData();
/* 1154 */     boolean enoughSpace = tag.func_74767_n("enoughSpace");
/* 1155 */     long growTime = tag.func_74763_f("growTime");
/* 1156 */     int days = (int)((growTime - TFC_Time.getTotalTicks()) / 24000L);
/* 1157 */     if (days > 0) {
/*      */       
/* 1159 */       currenttip.add(days + " " + TFC_Core.translate("gui.daysRemaining"));
/*      */     }
/* 1161 */     else if (!enoughSpace) {
/*      */       
/* 1163 */       currenttip.add(TFC_Core.translate("gui.enoughSpace"));
/*      */     } 
/*      */     
/* 1166 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> sluiceBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1171 */     NBTTagCompound tag = accessor.getNBTData();
/* 1172 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/* 1173 */     int soilAmount = tag.func_74762_e("soilAmount");
/*      */     
/* 1175 */     if (soilAmount == -1) {
/* 1176 */       currenttip.add(TFC_Core.translate("gui.Sluice.Overworked"));
/* 1177 */     } else if (soilAmount > 0) {
/*      */       
/* 1179 */       currenttip.add(TFC_Core.translate("gui.Sluice.Soil") + " : " + soilAmount + "/50");
/*      */     } 
/*      */     
/* 1182 */     int gemCount = 0, oreCount = 0;
/* 1183 */     for (ItemStack is : storage) {
/*      */       
/* 1185 */       if (is != null)
/*      */       {
/* 1187 */         if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemGem) {
/* 1188 */           gemCount++;
/* 1189 */         } else if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemOre) {
/* 1190 */           oreCount++;
/*      */         } 
/*      */       }
/*      */     } 
/* 1194 */     if (gemCount > 0)
/* 1195 */       currenttip.add(TFC_Core.translate("gui.gems") + " : " + gemCount); 
/* 1196 */     if (oreCount > 0) {
/* 1197 */       currenttip.add(TFC_Core.translate("gui.Bloomery.Ore") + " : " + oreCount);
/*      */     }
/* 1199 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> smokeRackBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1204 */     NBTTagCompound tag = accessor.getNBTData();
/* 1205 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/* 1207 */     for (int i = 0; i < storage.length; i++) {
/*      */       
/* 1209 */       ItemStack is = storage[i];
/* 1210 */       if (is != null) {
/*      */         
/* 1212 */         int dryHours = 4 - Food.getDried(is);
/* 1213 */         int smokeHours = 12 - Food.getSmokeCounter(is);
/*      */         
/* 1215 */         if (smokeHours < 12 && !Food.isSmoked(is)) {
/*      */           
/* 1217 */           smokeHours++;
/* 1218 */           float percent = Helper.roundNumber(100.0F - 100.0F * smokeHours / 12.0F, 10.0F);
/* 1219 */           currenttip.add(TFC_Core.translate("word.smoking") + " " + is.func_82833_r());
/* 1220 */           currenttip.add("· " + smokeHours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + percent + "%)");
/*      */         }
/* 1222 */         else if (dryHours < 4 && !Food.isDried(is)) {
/*      */           
/* 1224 */           float percent = Helper.roundNumber(100.0F - 100.0F * dryHours / 4.0F, 10.0F);
/* 1225 */           currenttip.add(TFC_Core.translate("word.drying") + " " + is.func_82833_r());
/* 1226 */           currenttip.add("· " + dryHours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + percent + "%)");
/*      */         } else {
/*      */           
/* 1229 */           currenttip.add(is.func_82833_r());
/*      */         } 
/*      */       } 
/*      */     } 
/* 1233 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> spawnMeterBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1238 */     NBTTagCompound tag = accessor.getNBTData();
/* 1239 */     int hours = tag.func_74762_e("protectionHours");
/*      */     
/* 1241 */     if (hours > 0)
/*      */     {
/* 1243 */       currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining"));
/*      */     }
/*      */     
/* 1246 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> soilBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1251 */     Block b = accessor.getBlock();
/* 1252 */     int dam = itemStack.func_77960_j();
/* 1253 */     if (b == TFCBlocks.dirt2 || b == TFCBlocks.sand2 || TFC_Core.isGrassType2(b) || b == TFCBlocks.gravel2)
/*      */     {
/* 1255 */       dam += 16;
/*      */     }
/*      */     
/* 1258 */     if (dam < Global.STONE_ALL.length) {
/* 1259 */       currenttip.add(Global.STONE_ALL[dam]);
/*      */     } else {
/* 1261 */       currenttip.add(EnumChatFormatting.DARK_RED + "Unknown");
/*      */     } 
/* 1263 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> torchBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1268 */     if (accessor.getMetadata() < 8 && TFCOptions.torchBurnTime != 0) {
/*      */       
/* 1270 */       NBTTagCompound tag = accessor.getNBTData();
/* 1271 */       long hours = TFCOptions.torchBurnTime - TFC_Time.getTotalHours() - tag.func_74762_e("hourPlaced");
/*      */       
/* 1273 */       if (hours > 0L)
/* 1274 */         currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(100.0F * (float)hours / TFCOptions.torchBurnTime, 10.0F) + "%)"); 
/*      */     } 
/* 1276 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> worldBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1281 */     int meta = itemStack.func_77960_j();
/* 1282 */     Item item = itemStack.func_77973_b();
/*      */     
/* 1284 */     if (item == TFCItems.smallOreChunk)
/*      */     {
/* 1286 */       switch (meta) {
/*      */         
/*      */         case 0:
/*      */         case 9:
/*      */         case 13:
/* 1291 */           currenttip.add(TFC_Core.translate("gui.metal.Copper"));
/*      */           break;
/*      */         case 1:
/* 1294 */           currenttip.add(TFC_Core.translate("gui.metal.Gold"));
/*      */           break;
/*      */         case 2:
/* 1297 */           currenttip.add(TFC_Core.translate("gui.metal.Platinum"));
/*      */           break;
/*      */         case 3:
/*      */         case 10:
/*      */         case 11:
/* 1302 */           currenttip.add(TFC_Core.translate("gui.metal.Iron"));
/*      */           break;
/*      */         case 4:
/* 1305 */           currenttip.add(TFC_Core.translate("gui.metal.Silver"));
/*      */           break;
/*      */         case 5:
/* 1308 */           currenttip.add(TFC_Core.translate("gui.metal.Tin"));
/*      */           break;
/*      */         case 6:
/* 1311 */           currenttip.add(TFC_Core.translate("gui.metal.Lead"));
/*      */           break;
/*      */         case 7:
/* 1314 */           currenttip.add(TFC_Core.translate("gui.metal.Bismuth"));
/*      */           break;
/*      */         case 8:
/* 1317 */           currenttip.add(TFC_Core.translate("gui.metal.Nickel"));
/*      */           break;
/*      */         case 12:
/* 1320 */           currenttip.add(TFC_Core.translate("gui.metal.Zinc"));
/*      */           break;
/*      */         case 14:
/*      */         case 15:
/* 1324 */           currenttip.add(TFC_Core.translate("item.coal.coal.name"));
/* 1325 */           return currenttip;
/*      */       } 
/*      */     }
/* 1328 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemStack[] getStorage(NBTTagCompound tag, TileEntity te) {
/* 1334 */     if (te instanceof IInventory) {
/*      */       
/* 1336 */       IInventory inv = (IInventory)te;
/* 1337 */       NBTTagList tagList = tag.func_150295_c("Items", 10);
/* 1338 */       ItemStack[] storage = new ItemStack[inv.func_70302_i_()];
/* 1339 */       for (int i = 0; i < tagList.func_74745_c(); i++) {
/*      */         
/* 1341 */         NBTTagCompound itemTag = tagList.func_150305_b(i);
/* 1342 */         byte slot = itemTag.func_74771_c("Slot");
/* 1343 */         if (slot >= 0 && slot < storage.length) {
/* 1344 */           storage[slot] = ItemStack.func_77949_a(itemTag);
/*      */         }
/*      */       } 
/* 1347 */       return storage;
/*      */     } 
/*      */     
/* 1350 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private int getOreGrade(TEOre te, int ore) {
/* 1355 */     if (te != null) {
/*      */       
/* 1357 */       int grade = te.extraData & 0x7;
/* 1358 */       if (grade == 1) {
/* 1359 */         ore += 35;
/* 1360 */       } else if (grade == 2) {
/* 1361 */         ore += 49;
/*      */       } 
/* 1363 */     }  return ore;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WAILA\WAILAData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */