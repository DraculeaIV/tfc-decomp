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
/*      */ import com.bioxx.tfc.TileEntities.TEBloomery;
/*      */ import com.bioxx.tfc.TileEntities.TECrop;
/*      */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*      */ import com.bioxx.tfc.TileEntities.TEFruitLeaves;
/*      */ import com.bioxx.tfc.TileEntities.TEFruitTreeWood;
/*      */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*      */ import com.bioxx.tfc.TileEntities.TELoom;
/*      */ import com.bioxx.tfc.TileEntities.TEMetalTrapDoor;
/*      */ import com.bioxx.tfc.TileEntities.TEOilLamp;
/*      */ import com.bioxx.tfc.TileEntities.TEOre;
/*      */ import com.bioxx.tfc.TileEntities.TESmokeRack;
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
/*  220 */     else if (tileEntity instanceof TESpawnMeter) {
/*  221 */       currenttip = spawnMeterBody(itemStack, currenttip, accessor, config);
/*      */     }
/*  223 */     else if (block == TFCBlocks.torch) {
/*  224 */       currenttip = torchBody(itemStack, currenttip, accessor, config);
/*      */     } 
/*  226 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  232 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
/*  238 */     if (te != null)
/*  239 */       te.func_145841_b(tag); 
/*  240 */     return tag;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void callbackRegister(IWailaRegistrar reg) {
/*  245 */     reg.addConfig("TerraFirmaCraft", "tfc.oreQuality");
/*      */     
/*  247 */     reg.registerStackProvider(new WAILAData(), BlockAnvil.class);
/*  248 */     reg.registerBodyProvider(new WAILAData(), TEAnvil.class);
/*  249 */     reg.registerNBTProvider(new WAILAData(), TEAnvil.class);
/*      */     
/*  251 */     reg.registerHeadProvider(new WAILAData(), TEBarrel.class);
/*  252 */     reg.registerBodyProvider(new WAILAData(), TEBarrel.class);
/*  253 */     reg.registerNBTProvider(new WAILAData(), TEBarrel.class);
/*      */     
/*  255 */     reg.registerStackProvider(new WAILAData(), TEBerryBush.class);
/*  256 */     reg.registerBodyProvider(new WAILAData(), TEBerryBush.class);
/*  257 */     reg.registerNBTProvider(new WAILAData(), TEBerryBush.class);
/*      */     
/*  259 */     reg.registerBodyProvider(new WAILAData(), TEBlastFurnace.class);
/*  260 */     reg.registerNBTProvider(new WAILAData(), TEBlastFurnace.class);
/*      */     
/*  262 */     reg.registerStackProvider(new WAILAData(), TEBloom.class);
/*  263 */     reg.registerBodyProvider(new WAILAData(), TEBloom.class);
/*  264 */     reg.registerNBTProvider(new WAILAData(), TEBloom.class);
/*      */     
/*  266 */     reg.registerBodyProvider(new WAILAData(), TEBloomery.class);
/*  267 */     reg.registerNBTProvider(new WAILAData(), TEBloomery.class);
/*      */     
/*  269 */     reg.registerStackProvider(new WAILAData(), BlockCharcoal.class);
/*  270 */     reg.registerStackProvider(new WAILAData(), BlockClay.class);
/*  271 */     reg.registerStackProvider(new WAILAData(), BlockClayGrass.class);
/*  272 */     reg.registerStackProvider(new WAILAData(), BlockCobble.class);
/*      */     
/*  274 */     reg.registerStackProvider(new WAILAData(), TECrop.class);
/*  275 */     reg.registerBodyProvider(new WAILAData(), TECrop.class);
/*  276 */     reg.registerNBTProvider(new WAILAData(), TECrop.class);
/*      */     
/*  278 */     reg.registerStackProvider(new WAILAData(), BlockCustomDoor.class);
/*      */     
/*  280 */     reg.registerBodyProvider(new WAILAData(), TEFarmland.class);
/*  281 */     reg.registerNBTProvider(new WAILAData(), TEFarmland.class);
/*      */     
/*  283 */     reg.registerBodyProvider(new WAILAData(), TEFirepit.class);
/*  284 */     reg.registerNBTProvider(new WAILAData(), TEFirepit.class);
/*      */     
/*  286 */     reg.registerBodyProvider(new WAILAData(), TEForge.class);
/*  287 */     reg.registerNBTProvider(new WAILAData(), TEForge.class);
/*      */     
/*  289 */     reg.registerStackProvider(new WAILAData(), TEFruitLeaves.class);
/*  290 */     reg.registerHeadProvider(new WAILAData(), TEFruitLeaves.class);
/*  291 */     reg.registerBodyProvider(new WAILAData(), TEFruitLeaves.class);
/*  292 */     reg.registerNBTProvider(new WAILAData(), TEFruitLeaves.class);
/*      */     
/*  294 */     reg.registerStackProvider(new WAILAData(), TEFruitTreeWood.class);
/*  295 */     reg.registerHeadProvider(new WAILAData(), TEFruitTreeWood.class);
/*      */     
/*  297 */     reg.registerStackProvider(new WAILAData(), TEIngotPile.class);
/*  298 */     reg.registerHeadProvider(new WAILAData(), TEIngotPile.class);
/*  299 */     reg.registerNBTProvider(new WAILAData(), TEIngotPile.class);
/*      */     
/*  301 */     reg.registerBodyProvider(new WAILAData(), TELogPile.class);
/*  302 */     reg.registerNBTProvider(new WAILAData(), TELogPile.class);
/*      */     
/*  304 */     reg.registerStackProvider(new WAILAData(), TELoom.class);
/*  305 */     reg.registerBodyProvider(new WAILAData(), TELoom.class);
/*  306 */     reg.registerNBTProvider(new WAILAData(), TELoom.class);
/*      */     
/*  308 */     reg.registerStackProvider(new WAILAData(), TEMetalSheet.class);
/*  309 */     reg.registerNBTProvider(new WAILAData(), TEMetalSheet.class);
/*      */     
/*  311 */     reg.registerStackProvider(new WAILAData(), TEMetalTrapDoor.class);
/*  312 */     reg.registerBodyProvider(new WAILAData(), TEMetalTrapDoor.class);
/*  313 */     reg.registerNBTProvider(new WAILAData(), TEMetalTrapDoor.class);
/*      */     
/*  315 */     reg.registerBodyProvider(new WAILAData(), TENestBox.class);
/*  316 */     reg.registerNBTProvider(new WAILAData(), TENestBox.class);
/*      */     
/*  318 */     reg.registerStackProvider(new WAILAData(), TEOilLamp.class);
/*  319 */     reg.registerBodyProvider(new WAILAData(), TEOilLamp.class);
/*  320 */     reg.registerNBTProvider(new WAILAData(), TEOilLamp.class);
/*      */     
/*  322 */     reg.registerStackProvider(new WAILAData(), TEOre.class);
/*  323 */     reg.registerHeadProvider(new WAILAData(), TEOre.class);
/*  324 */     reg.registerBodyProvider(new WAILAData(), TEOre.class);
/*      */     
/*  326 */     reg.registerStackProvider(new WAILAData(), BlockPartial.class);
/*  327 */     reg.registerNBTProvider(new WAILAData(), BlockPartial.class);
/*      */     
/*  329 */     reg.registerBodyProvider(new WAILAData(), TEPottery.class);
/*  330 */     reg.registerNBTProvider(new WAILAData(), TEPottery.class);
/*      */     
/*  332 */     reg.registerBodyProvider(new WAILAData(), TESapling.class);
/*  333 */     reg.registerNBTProvider(new WAILAData(), TESapling.class);
/*      */     
/*  335 */     reg.registerBodyProvider(new WAILAData(), TESluice.class);
/*  336 */     reg.registerNBTProvider(new WAILAData(), TESluice.class);
/*      */     
/*  338 */     reg.registerHeadProvider(new WAILAData(), TESmokeRack.class);
/*  339 */     reg.registerBodyProvider(new WAILAData(), TESmokeRack.class);
/*  340 */     reg.registerNBTProvider(new WAILAData(), TESmokeRack.class);
/*      */     
/*  342 */     reg.registerBodyProvider(new WAILAData(), TESpawnMeter.class);
/*  343 */     reg.registerNBTProvider(new WAILAData(), TESpawnMeter.class);
/*      */ 
/*      */     
/*  346 */     reg.registerBodyProvider(new WAILAData(), BlockDirt.class);
/*  347 */     reg.registerBodyProvider(new WAILAData(), BlockSand.class);
/*  348 */     reg.registerBodyProvider(new WAILAData(), BlockGrass.class);
/*  349 */     reg.registerBodyProvider(new WAILAData(), BlockGravel.class);
/*      */     
/*  351 */     reg.registerBodyProvider(new WAILAData(), BlockTorch.class);
/*  352 */     reg.registerNBTProvider(new WAILAData(), BlockTorch.class);
/*      */     
/*  354 */     reg.registerStackProvider(new WAILAData(), BlockWaterPlant.class);
/*  355 */     reg.registerHeadProvider(new WAILAData(), BlockWaterPlant.class);
/*      */     
/*  357 */     reg.registerStackProvider(new WAILAData(), TEWorldItem.class);
/*  358 */     reg.registerNBTProvider(new WAILAData(), TEWorldItem.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ItemStack anvilStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  364 */     Block block = accessor.getBlock();
/*  365 */     int meta = accessor.getMetadata();
/*  366 */     int type = BlockAnvil.getAnvilTypeFromMeta(meta);
/*      */     
/*  368 */     return new ItemStack(block, 1, type);
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack berryBushStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  373 */     NBTTagCompound tag = accessor.getNBTData();
/*  374 */     boolean hasFruit = tag.func_74767_n("hasFruit");
/*  375 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockBerryBush.metaNames[accessor.getMetadata()]);
/*      */     
/*  377 */     if (hasFruit) {
/*  378 */       return ItemFoodTFC.createTag(index.getOutput());
/*      */     }
/*  380 */     return null;
/*      */   }
/*      */   
/*      */   public ItemStack cropStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*      */     ItemStack itemstack;
/*  385 */     NBTTagCompound tag = accessor.getNBTData();
/*  386 */     int cropId = tag.func_74762_e("cropId");
/*      */     
/*  388 */     CropIndex crop = CropManager.getInstance().getCropFromId(cropId);
/*      */ 
/*      */     
/*  391 */     if (crop.output2 != null) {
/*  392 */       itemstack = new ItemStack(crop.output2);
/*      */     } else {
/*  394 */       itemstack = new ItemStack(crop.output1);
/*      */     } 
/*  396 */     ItemFoodTFC.createTag(itemstack);
/*  397 */     return itemstack;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack fruitLeavesStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  402 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockFruitLeaves.getType(accessor.getBlock(), accessor.getMetadata() % 8));
/*      */     
/*  404 */     if (index != null) {
/*  405 */       return ItemFoodTFC.createTag(index.getOutput());
/*      */     }
/*  407 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack fruitTreeWoodStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  412 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockFruitWood.getType(accessor.getMetadata()));
/*      */     
/*  414 */     if (index != null) {
/*  415 */       return ItemFoodTFC.createTag(index.getOutput());
/*      */     }
/*  417 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack ingotPileStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  422 */     NBTTagCompound tag = accessor.getNBTData();
/*  423 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  425 */     if (storage[0] != null) {
/*  426 */       return storage[0];
/*      */     }
/*  428 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack loomStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  433 */     NBTTagCompound tag = accessor.getNBTData();
/*  434 */     boolean finished = tag.func_74767_n("finished");
/*  435 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  437 */     if (finished && storage[1] != null)
/*      */     {
/*  439 */       return storage[1];
/*      */     }
/*  441 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack metalSheetStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  446 */     NBTTagCompound tag = accessor.getNBTData();
/*  447 */     return ItemStack.func_77949_a(tag.func_74775_l("sheetType"));
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack metalTrapDoorStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  452 */     NBTTagCompound tag = accessor.getNBTData();
/*  453 */     return ItemStack.func_77949_a(tag.func_74775_l("sheetType"));
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack oilLampStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  458 */     int meta = accessor.getMetadata();
/*  459 */     if ((meta & 0x8) != 0) {
/*  460 */       meta -= 8;
/*      */     }
/*  462 */     return new ItemStack(TFCBlocks.oilLamp, 1, meta);
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack oreStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  467 */     int meta = accessor.getMetadata();
/*  468 */     TEOre te = (TEOre)accessor.getTileEntity();
/*  469 */     ItemStack itemstack = null;
/*      */     
/*  471 */     if (accessor.getBlock() == TFCBlocks.ore) {
/*      */       
/*  473 */       if (config.getConfig("tfc.oreQuality")) {
/*  474 */         itemstack = new ItemStack(TFCItems.oreChunk, 1, getOreGrade(te, meta));
/*      */       } else {
/*  476 */         itemstack = new ItemStack(TFCItems.oreChunk, 1, meta);
/*      */       } 
/*  478 */       if (meta == 14 || meta == 15) {
/*  479 */         itemstack = new ItemStack(TFCItems.coal);
/*      */       }
/*  481 */       return itemstack;
/*      */     } 
/*  483 */     if (accessor.getBlock() == TFCBlocks.ore2) {
/*      */       
/*  485 */       itemstack = new ItemStack(TFCItems.oreChunk, 1, meta + Global.ORE_METAL.length);
/*  486 */       if (meta == 5) {
/*  487 */         itemstack = new ItemStack(TFCItems.gemDiamond);
/*  488 */       } else if (meta == 13) {
/*  489 */         itemstack = new ItemStack(TFCItems.powder, 1, 4);
/*      */       } 
/*  491 */       return itemstack;
/*      */     } 
/*  493 */     if (accessor.getBlock() == TFCBlocks.ore3) {
/*      */       
/*  495 */       itemstack = new ItemStack(TFCItems.oreChunk, 1, meta + Global.ORE_METAL.length + Global.ORE_MINERAL.length);
/*  496 */       return itemstack;
/*      */     } 
/*      */     
/*  499 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack partialStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  504 */     NBTTagCompound tag = accessor.getNBTData();
/*  505 */     byte metaID = tag.func_74771_c("metaID");
/*  506 */     int typeID = tag.func_74765_d("typeID");
/*      */     
/*  508 */     return new ItemStack(Block.func_149729_e(typeID), 1, metaID);
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack worldItemStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  513 */     NBTTagCompound tag = accessor.getNBTData();
/*  514 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  515 */     return storage[0];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> barrelHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  521 */     String head = currenttip.get(0);
/*  522 */     NBTTagCompound tag = accessor.getNBTData();
/*  523 */     FluidStack fluid = FluidStack.loadFluidStackFromNBT(tag.func_74775_l("fluidNBT"));
/*      */     
/*  525 */     if (fluid != null) {
/*      */       
/*  527 */       head = head + " (" + fluid.getLocalizedName() + ")";
/*  528 */       currenttip.set(0, head);
/*      */     } 
/*  530 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> fruitLeavesHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  535 */     NBTTagCompound tag = accessor.getNBTData();
/*  536 */     boolean hasFruit = tag.func_74767_n("hasFruit");
/*  537 */     String type = BlockFruitLeaves.getType(accessor.getBlock(), accessor.getMetadata());
/*      */     
/*  539 */     if (!hasFruit) {
/*  540 */       currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("gui." + type));
/*      */     }
/*  542 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> fruitTreeWoodHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  547 */     String type = BlockFruitWood.getType(accessor.getMetadata());
/*      */     
/*  549 */     currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("gui." + type));
/*      */     
/*  551 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> ingotPileHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  556 */     String head = currenttip.get(0);
/*  557 */     currenttip.set(0, head + " " + TFC_Core.translate("gui.pile"));
/*  558 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> oreHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  563 */     int meta = accessor.getMetadata();
/*      */     
/*  565 */     if (accessor.getBlock() == TFCBlocks.ore) {
/*      */       
/*  567 */       if (meta == 14)
/*      */       {
/*  569 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Bituminous Coal.name"));
/*      */       }
/*  571 */       else if (meta == 15)
/*      */       {
/*  573 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Lignite.name"));
/*      */       }
/*      */     
/*  576 */     } else if (accessor.getBlock() == TFCBlocks.ore2) {
/*      */       
/*  578 */       if (meta == 5) {
/*      */         
/*  580 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Kimberlite.name"));
/*      */       }
/*  582 */       else if (meta == 13) {
/*      */         
/*  584 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("item.Ore.Saltpeter.name"));
/*      */       } 
/*      */     } 
/*      */     
/*  588 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> waterPlantHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  593 */     MovingObjectPosition pos = accessor.getPosition();
/*  594 */     World world = accessor.getWorld();
/*  595 */     Block blockDirectlyAbove = world.func_147439_a(pos.field_72311_b, pos.field_72312_c + 1, pos.field_72309_d);
/*  596 */     boolean airTwoAbove = world.func_147437_c(pos.field_72311_b, pos.field_72312_c + 2, pos.field_72309_d);
/*      */     
/*  598 */     if (TFC_Core.isFreshWater(blockDirectlyAbove))
/*      */     {
/*  600 */       if (airTwoAbove) {
/*      */         
/*  602 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("tile.Flora.Cat Tails.name"));
/*      */       }
/*      */       else {
/*      */         
/*  606 */         currenttip.set(0, EnumChatFormatting.WHITE.toString() + TFC_Core.translate("tile.Flora.Pond Weed.name"));
/*      */       } 
/*      */     }
/*      */     
/*  610 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> anvilBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  616 */     NBTTagCompound tag = accessor.getNBTData();
/*      */     
/*  618 */     int tier = tag.func_74762_e("Tier");
/*  619 */     currenttip.add(TFC_Core.translate("gui.tier") + " : " + tier);
/*      */     
/*  621 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  622 */     ItemStack flux = storage[6];
/*      */     
/*  624 */     if (flux != null && flux.func_77973_b() == TFCItems.powder && flux.func_77960_j() == 0 && flux.field_77994_a > 0) {
/*  625 */       currenttip.add(TFC_Core.translate("item.Powder.Flux.name") + " : " + flux.field_77994_a);
/*      */     }
/*  627 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> barrelBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  632 */     TEBarrel te = (TEBarrel)accessor.getTileEntity();
/*  633 */     NBTTagCompound tag = accessor.getNBTData();
/*  634 */     ItemStack[] storage = getStorage(tag, (TileEntity)te);
/*  635 */     ItemStack inStack = storage[0];
/*      */     
/*  637 */     Boolean sealed = Boolean.valueOf(te.getSealed());
/*  638 */     int sealTime = accessor.getNBTInteger(tag, "SealTime");
/*  639 */     FluidStack fluid = FluidStack.loadFluidStackFromNBT(tag.func_74775_l("fluidNBT"));
/*  640 */     BarrelRecipe recipe = BarrelManager.getInstance().findMatchingRecipe(inStack, fluid, sealed.booleanValue(), te.getTechLevel());
/*      */     
/*  642 */     if (sealed.booleanValue() && fluid != null && fluid.getFluid() == TFCFluids.MILKCURDLED && (inStack == null || (inStack
/*  643 */       .func_77973_b() instanceof IFood && ((IFood)inStack.func_77973_b()).getFoodGroup() != EnumFoodGroup.Dairy && ((IFood)inStack.func_77973_b()).isEdible(inStack) && Food.getWeight(inStack) <= 20.0F))) {
/*  644 */       recipe = (new BarrelRecipe(null, new FluidStack(TFCFluids.MILKCURDLED, 10000), ItemFoodTFC.createTag(new ItemStack(TFCItems.cheese, 1), 160.0F), null)).setMinTechLevel(0);
/*      */     }
/*      */     
/*  647 */     if (fluid != null)
/*      */     {
/*  649 */       currenttip.add(fluid.amount + "/" + te.getMaxLiquid() + " mB");
/*      */     }
/*      */ 
/*      */     
/*  653 */     if (sealed.booleanValue() && sealTime != 0)
/*      */     {
/*  655 */       currenttip.add(TFC_Core.translate("gui.Barrel.SealedOn") + " : " + TFC_Time.getDateStringFromHours(sealTime));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  660 */     BarrelPreservativeRecipe preservative = BarrelManager.getInstance().findMatchingPreservativeRepice(te, inStack, fluid, sealed.booleanValue());
/*      */ 
/*      */     
/*  663 */     if (recipe != null) {
/*      */       
/*  665 */       if (!(recipe instanceof com.bioxx.tfc.api.Crafting.BarrelBriningRecipe))
/*      */       {
/*  667 */         currenttip.add(TFC_Core.translate("gui.Output") + " : " + recipe.getRecipeName());
/*      */       }
/*  669 */       else if (sealed.booleanValue() && fluid != null && fluid.getFluid() == TFCFluids.BRINE)
/*      */       {
/*  671 */         if (inStack != null && inStack.func_77973_b() instanceof IFood && (((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack.func_77973_b() == TFCItems.cheese) && !Food.isBrined(inStack))
/*      */         {
/*  673 */           currenttip.add(TFC_Core.translate("gui.barrel.brining"));
/*      */         }
/*      */       }
/*      */     
/*  677 */     } else if (sealed.booleanValue() && fluid != null && inStack != null && inStack.func_77973_b() instanceof IFood && fluid.getFluid() == TFCFluids.VINEGAR) {
/*      */       
/*  679 */       if (!Food.isPickled(inStack) && Food.getWeight(inStack) / fluid.amount <= 160.0F / te.getMaxLiquid()) {
/*      */         
/*  681 */         if ((((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Fruit || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Vegetable || ((IFood)inStack.func_77973_b()).getFoodGroup() == EnumFoodGroup.Protein || (IFood)inStack.func_77973_b() == TFCItems.cheese) && Food.isBrined(inStack))
/*      */         {
/*  683 */           currenttip.add(TFC_Core.translate("gui.barrel.pickling"));
/*      */         }
/*      */       }
/*  686 */       else if (Food.isPickled(inStack) && Food.getWeight(inStack) / fluid.amount <= 160.0F / te.getMaxLiquid() * 2.0F) {
/*      */         
/*  688 */         currenttip.add(TFC_Core.translate("gui.barrel.preserving"));
/*      */       } 
/*  690 */     } else if (preservative != null) {
/*  691 */       currenttip.add(TFC_Core.translate(preservative.getPreservingString()));
/*      */     } 
/*      */     
/*  694 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> berryBushBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  699 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockBerryBush.metaNames[accessor.getMetadata()]);
/*  700 */     currenttip.add(TFC_Time.SEASONS[index.harvestStart] + " - " + TFC_Time.SEASONS[index.harvestFinish]);
/*  701 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> blastFurnaceBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  706 */     TEBlastFurnace te = (TEBlastFurnace)accessor.getTileEntity();
/*  707 */     NBTTagCompound tag = accessor.getNBTData();
/*      */     
/*  709 */     int charcoalCount = tag.func_74762_e("charcoalCount");
/*  710 */     int oreCount = tag.func_74771_c("oreCount");
/*  711 */     int stackSize = tag.func_74762_e("maxValidStackSize");
/*  712 */     float temperature = 0.0F;
/*      */     
/*  714 */     ItemStack[] storage = getStorage(tag, (TileEntity)te);
/*  715 */     ItemStack oreStack = storage[0];
/*      */     
/*  717 */     HeatRegistry manager = HeatRegistry.getInstance();
/*      */     
/*  719 */     if (oreStack != null) {
/*      */       
/*  721 */       HeatIndex index = manager.findMatchingIndex(oreStack);
/*  722 */       if (index != null)
/*      */       {
/*  724 */         temperature = TFC_ItemHeat.getTemp(oreStack);
/*      */       }
/*      */     } 
/*  727 */     String temp = TFC_ItemHeat.getHeatColor(temperature, te.maxFireTempScale);
/*      */     
/*  729 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Charcoal") + " : " + charcoalCount + "/" + (stackSize * 4));
/*  730 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Ore") + " : " + oreCount + "/" + (stackSize * 4));
/*      */     
/*  732 */     if (te.storage[1] != null) {
/*  733 */       currenttip.add(TFC_Core.translate("gui.plans.tuyere") + EnumChatFormatting.GREEN.toString() + " ✔");
/*      */     } else {
/*  735 */       currenttip.add(TFC_Core.translate("gui.plans.tuyere") + EnumChatFormatting.RED.toString() + " ✘");
/*      */     } 
/*  737 */     if (temperature > 0.0F)
/*      */     {
/*  739 */       currenttip.add(temp);
/*      */     }
/*      */     
/*  742 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> bloomBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  747 */     NBTTagCompound tag = accessor.getNBTData();
/*  748 */     int size = tag.func_74762_e("size");
/*      */     
/*  750 */     currenttip.add(TFC_Core.translate("gui.units") + " : " + size);
/*  751 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> bloomeryBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  756 */     NBTTagCompound tag = accessor.getNBTData();
/*  757 */     boolean isLit = tag.func_74767_n("isLit");
/*  758 */     int charcoalCount = tag.func_74762_e("charcoalCount");
/*  759 */     int oreCount = tag.func_74762_e("oreCount");
/*      */     
/*  761 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Charcoal") + " : " + charcoalCount);
/*  762 */     currenttip.add(TFC_Core.translate("gui.Bloomery.Ore") + " : " + oreCount);
/*      */     
/*  764 */     if (isLit) {
/*      */       
/*  766 */       long hours = tag.func_74763_f("fuelTimeLeft") / 1000L - TFC_Time.getTotalHours();
/*      */       
/*  768 */       if (hours > 0L) {
/*      */         
/*  770 */         float percent = Helper.roundNumber(Math.min(100.0F - (float)hours / TFCOptions.bloomeryBurnTime * 100.0F, 100.0F), 10.0F);
/*  771 */         currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + percent + "%)");
/*      */       } 
/*      */     } 
/*      */     
/*  775 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> cropBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  780 */     NBTTagCompound tag = accessor.getNBTData();
/*  781 */     float growth = tag.func_74760_g("growth");
/*  782 */     int cropId = tag.func_74762_e("cropId");
/*      */     
/*  784 */     CropIndex crop = CropManager.getInstance().getCropFromId(cropId);
/*  785 */     int percentGrowth = (int)Math.min(growth / crop.numGrowthStages * 100.0F, 100.0F);
/*      */     
/*  787 */     if (percentGrowth < 100) {
/*  788 */       currenttip.add(TFC_Core.translate("gui.growth") + " : " + percentGrowth + "%");
/*      */     } else {
/*  790 */       currenttip.add(TFC_Core.translate("gui.growth") + " : " + TFC_Core.translate("gui.mature"));
/*      */     } 
/*  792 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> farmlandBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  797 */     SkillStats.SkillRank rank = TFC_Core.getSkillStats(accessor.getPlayer()).getSkillRank("skill.agriculture");
/*  798 */     if (rank == SkillStats.SkillRank.Expert || rank == SkillStats.SkillRank.Master) {
/*      */       
/*  800 */       TEFarmland te = (TEFarmland)accessor.getTileEntity();
/*  801 */       NBTTagCompound tag = accessor.getNBTData();
/*      */       
/*  803 */       int[] nutrients = tag.func_74759_k("nutrients");
/*  804 */       int soilMax = te.getSoilMax();
/*      */       
/*  806 */       for (int i = 0; i < nutrients.length; i++) {
/*      */         
/*  808 */         int percent = Math.max(nutrients[i] * 100 / soilMax, 0);
/*      */         
/*  810 */         if (i == 0) {
/*  811 */           currenttip.add(EnumChatFormatting.RED + TFC_Core.translate("gui.Nutrient.A") + " : " + percent + "%");
/*  812 */         } else if (i == 1) {
/*  813 */           currenttip.add(EnumChatFormatting.GOLD + TFC_Core.translate("gui.Nutrient.B") + " : " + percent + "%");
/*  814 */         } else if (i == 2) {
/*  815 */           currenttip.add(EnumChatFormatting.YELLOW + TFC_Core.translate("gui.Nutrient.C") + " : " + percent + "%");
/*  816 */         } else if (i == 3 && percent != 0) {
/*  817 */           currenttip.add(EnumChatFormatting.WHITE + TFC_Core.translate("item.Fertilizer.name") + " : " + percent + "%");
/*      */         } 
/*      */       } 
/*      */     } 
/*  821 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> firepitBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  826 */     NBTTagCompound tag = accessor.getNBTData();
/*  827 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  829 */     if (storage != null) {
/*      */       
/*  831 */       int fuelCount = 0;
/*  832 */       for (ItemStack is : storage) {
/*      */         
/*  834 */         if (is != null && is.func_77973_b() != null && (is.func_77973_b() == TFCItems.logs || is.func_77973_b() == Item.func_150898_a(TFCBlocks.peat))) {
/*  835 */           fuelCount++;
/*      */         }
/*      */       } 
/*  838 */       if (fuelCount > 0) {
/*  839 */         currenttip.add(TFC_Core.translate("gui.fuel") + " : " + fuelCount + "/4");
/*      */       }
/*      */     } 
/*  842 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> forgeBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  847 */     NBTTagCompound tag = accessor.getNBTData();
/*  848 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  850 */     if (storage != null) {
/*      */       
/*  852 */       int fuelCount = 0;
/*  853 */       boolean hasMold = false;
/*      */       
/*  855 */       for (int i = 5; i <= 9; i++) {
/*      */         
/*  857 */         if (storage[i] != null && storage[i].func_77973_b() != null && storage[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemCoal) {
/*  858 */           fuelCount++;
/*      */         }
/*      */       } 
/*  861 */       if (fuelCount > 0) {
/*  862 */         currenttip.add(TFC_Core.translate("gui.fuel") + " : " + fuelCount + "/5");
/*      */       }
/*  864 */       for (int j = 10; j <= 13; j++) {
/*      */         
/*  866 */         if (storage[j] != null && storage[j].func_77973_b() == TFCItems.ceramicMold && (storage[j]).field_77994_a > 0)
/*  867 */           hasMold = true; 
/*      */       } 
/*  869 */       if (hasMold) {
/*  870 */         currenttip.add(TFC_Core.translate("item.Mold.Ceramic Mold.name") + EnumChatFormatting.GREEN.toString() + " ✔");
/*      */       } else {
/*  872 */         currenttip.add(TFC_Core.translate("item.Mold.Ceramic Mold.name") + EnumChatFormatting.RED.toString() + " ✘");
/*      */       } 
/*      */     } 
/*  875 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> fruitLeavesBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  880 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(BlockFruitLeaves.getType(accessor.getBlock(), accessor.getMetadata()));
/*  881 */     if (index != null)
/*  882 */       currenttip.add(TFC_Time.SEASONS[index.harvestStart] + " - " + TFC_Time.SEASONS[index.harvestFinish]); 
/*  883 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> logPileBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  888 */     NBTTagCompound tag = accessor.getNBTData();
/*  889 */     Boolean isOnFire = Boolean.valueOf(tag.func_74767_n("isOnFire"));
/*      */     
/*  891 */     if (isOnFire.booleanValue()) {
/*      */       
/*  893 */       int fireTimer = tag.func_74762_e("fireTimer");
/*  894 */       int hours = (int)(TFCOptions.charcoalPitBurnTime - (float)(TFC_Time.getTotalHours() - fireTimer));
/*  895 */       currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(100.0F - hours / TFCOptions.charcoalPitBurnTime * 100.0F, 10.0F) + "%)");
/*      */     }
/*      */     else {
/*      */       
/*  899 */       ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  900 */       boolean[] counted = { false, false, false, false };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  907 */       for (int j = 0; j < storage.length; j++) {
/*      */         
/*  909 */         if (storage[j] != null && !counted[j]) {
/*      */           
/*  911 */           String log = storage[j].func_82833_r() + " : ";
/*  912 */           int count = (storage[j]).field_77994_a;
/*  913 */           for (int k = j + 1; k < storage.length; k++) {
/*      */             
/*  915 */             if (storage[k] != null && storage[j].func_77969_a(storage[k])) {
/*      */               
/*  917 */               count += (storage[k]).field_77994_a;
/*  918 */               counted[k] = true;
/*      */             } 
/*      */           } 
/*  921 */           currenttip.add(log + count);
/*  922 */           counted[j] = true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  927 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> loomBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  932 */     NBTTagCompound tag = accessor.getNBTData();
/*  933 */     boolean finished = tag.func_74767_n("finished");
/*  934 */     int wovenStrings = tag.func_74762_e("cloth");
/*  935 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/*  937 */     if (!finished && storage[0] != null) {
/*      */       
/*  939 */       LoomRecipe recipe = LoomManager.getInstance().findPotentialRecipes(storage[0]);
/*  940 */       int maxStrings = recipe.getReqSize();
/*      */       
/*  942 */       if ((storage[0]).field_77994_a < maxStrings) {
/*      */         
/*  944 */         String name = storage[0].func_82833_r() + " : ";
/*  945 */         currenttip.add(name + (storage[0]).field_77994_a + "/" + maxStrings);
/*      */       }
/*      */       else {
/*      */         
/*  949 */         String name = recipe.getOutItemStack().func_82833_r() + " : ";
/*  950 */         int percent = (int)(100.0D * wovenStrings / maxStrings);
/*  951 */         currenttip.add(TFC_Core.translate("gui.weaving") + " " + name + percent + "%");
/*      */       } 
/*      */     } 
/*      */     
/*  955 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> metalTrapDoorBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  960 */     NBTTagCompound tag = accessor.getNBTData();
/*  961 */     ItemStack sheetStack = ItemStack.func_77949_a(tag.func_74775_l("sheetType"));
/*      */     
/*  963 */     String metalType = BlockMetalTrapDoor.metalNames[sheetStack.func_77960_j() & 0x1F];
/*  964 */     currenttip.add(TFC_Core.translate("gui.metal." + metalType.replaceAll("\\s", "")));
/*  965 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> nestBoxBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  970 */     NBTTagCompound tag = accessor.getNBTData();
/*  971 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*  972 */     int eggCount = 0, fertEggCount = 0;
/*      */     
/*  974 */     for (ItemStack is : storage) {
/*      */       
/*  976 */       if (is != null && is.func_77973_b() == TFCItems.egg)
/*      */       {
/*  978 */         if (is.func_77942_o() && is.func_77978_p().func_74764_b("Fertilized")) {
/*  979 */           fertEggCount++;
/*      */         } else {
/*  981 */           eggCount++;
/*      */         } 
/*      */       }
/*      */     } 
/*  985 */     if (eggCount > 0)
/*  986 */       currenttip.add(TFC_Core.translate("gui.eggs") + " : " + eggCount); 
/*  987 */     if (fertEggCount > 0) {
/*  988 */       currenttip.add(TFC_Core.translate("gui.fertEggs") + " : " + fertEggCount);
/*      */     }
/*  990 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> oilLampBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/*  995 */     NBTTagCompound tag = accessor.getNBTData();
/*  996 */     if (tag.func_74764_b("Fuel")) {
/*      */       
/*  998 */       FluidStack fuel = FluidStack.loadFluidStackFromNBT(tag.func_74775_l("Fuel"));
/*  999 */       int hours = fuel.amount * TFCOptions.oilLampFuelMult / 8;
/* 1000 */       if (fuel.getFluid() == TFCFluids.OLIVEOIL) {
/* 1001 */         currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(hours / 250.0F * TFCOptions.oilLampFuelMult * 100.0F, 10.0F) + "%)");
/* 1002 */       } else if (fuel.getFluid() == TFCFluids.LAVA) {
/* 1003 */         currenttip.add(TFC_Core.translate("gui.infinite") + " " + TFC_Core.translate("gui.hoursRemaining"));
/*      */       } 
/* 1005 */     }  return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> oreBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1010 */     int meta = accessor.getMetadata();
/*      */     
/* 1012 */     if (accessor.getBlock() == TFCBlocks.ore) {
/*      */       
/* 1014 */       switch (meta) {
/*      */         
/*      */         case 0:
/*      */         case 9:
/*      */         case 13:
/* 1019 */           currenttip.add(TFC_Core.translate("gui.metal.Copper"));
/*      */           break;
/*      */         case 1:
/* 1022 */           currenttip.add(TFC_Core.translate("gui.metal.Gold"));
/*      */           break;
/*      */         case 2:
/* 1025 */           currenttip.add(TFC_Core.translate("gui.metal.Platinum") + " - " + TFC_Core.translate("gui.useless"));
/*      */           break;
/*      */         case 3:
/*      */         case 10:
/*      */         case 11:
/* 1030 */           currenttip.add(TFC_Core.translate("gui.metal.Iron"));
/*      */           break;
/*      */         case 4:
/* 1033 */           currenttip.add(TFC_Core.translate("gui.metal.Silver"));
/*      */           break;
/*      */         case 5:
/* 1036 */           currenttip.add(TFC_Core.translate("gui.metal.Tin"));
/*      */           break;
/*      */         case 6:
/* 1039 */           currenttip.add(TFC_Core.translate("gui.metal.Lead") + " - " + TFC_Core.translate("gui.useless"));
/*      */           break;
/*      */         case 7:
/* 1042 */           currenttip.add(TFC_Core.translate("gui.metal.Bismuth"));
/*      */           break;
/*      */         case 8:
/* 1045 */           currenttip.add(TFC_Core.translate("gui.metal.Nickel"));
/*      */           break;
/*      */         case 12:
/* 1048 */           currenttip.add(TFC_Core.translate("gui.metal.Zinc"));
/*      */           break;
/*      */         case 14:
/*      */         case 15:
/* 1052 */           currenttip.add(TFC_Core.translate("item.coal.coal.name"));
/* 1053 */           return currenttip;
/*      */       } 
/*      */       
/* 1056 */       if (config.getConfig("tfc.oreQuality"))
/*      */       {
/* 1058 */         TEOre te = (TEOre)accessor.getTileEntity();
/*      */         
/* 1060 */         int ore = getOreGrade(te, meta);
/*      */         
/* 1062 */         int units = (ore < 14) ? TFCOptions.normalOreUnits : ((ore < 49) ? TFCOptions.richOreUnits : ((ore < 63) ? TFCOptions.poorOreUnits : 0));
/* 1063 */         if (units > 0) {
/* 1064 */           currenttip.add(TFC_Core.translate("gui.units") + " : " + units);
/*      */         }
/*      */       }
/*      */     
/* 1068 */     } else if (accessor.getBlock() == TFCBlocks.ore2) {
/*      */       
/* 1070 */       switch (meta) {
/*      */         
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/*      */         case 6:
/*      */         case 8:
/*      */         case 9:
/*      */         case 10:
/*      */         case 14:
/* 1080 */           currenttip.add(TFC_Core.translate("gui.useless"));
/*      */           break;
/*      */         case 5:
/* 1083 */           currenttip.add(TFC_Core.translate("item.Diamond.Normal.name"));
/*      */           break;
/*      */         case 11:
/*      */         case 12:
/* 1087 */           currenttip.add(TFC_Core.translate("item.redstone.name"));
/*      */           break;
/*      */         case 15:
/* 1090 */           currenttip.add(TFC_Core.translate("item.Fertilizer.name"));
/*      */           break;
/*      */       } 
/*      */     
/* 1094 */     } else if (accessor.getBlock() == TFCBlocks.ore3) {
/*      */       
/* 1096 */       switch (meta) {
/*      */         
/*      */         case 0:
/* 1099 */           currenttip.add(TFC_Core.translate("item.Powder.Flux.name"));
/*      */           break;
/*      */         case 1:
/* 1102 */           currenttip.add(TFC_Core.translate("gui.useless"));
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/* 1107 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> potteryBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1112 */     NBTTagCompound tag = accessor.getNBTData();
/* 1113 */     long burnStart = tag.func_74763_f("burnStart");
/* 1114 */     int wood = tag.func_74762_e("wood");
/* 1115 */     int straw = tag.func_74762_e("straw");
/*      */     
/* 1117 */     if (straw > 0 && straw < 8) {
/* 1118 */       currenttip.add(TFC_Core.translate("item.Straw.name") + " : " + straw + "/8");
/* 1119 */     } else if (wood > 0 && wood < 8) {
/* 1120 */       currenttip.add(TFC_Core.translate("gui.logs") + " : " + wood + "/8");
/* 1121 */     } else if (burnStart > 0L) {
/*      */       
/* 1123 */       int hours = (int)(TFCOptions.pitKilnBurnTime - (float)(TFC_Time.getTotalHours() - burnStart / 1000L));
/* 1124 */       currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(100.0F - hours / TFCOptions.pitKilnBurnTime * 100.0F, 10.0F) + "%)");
/*      */     } 
/*      */     
/* 1127 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> saplingBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1132 */     NBTTagCompound tag = accessor.getNBTData();
/* 1133 */     boolean enoughSpace = tag.func_74767_n("enoughSpace");
/* 1134 */     long growTime = tag.func_74763_f("growTime");
/* 1135 */     int days = (int)((growTime - TFC_Time.getTotalTicks()) / 24000L);
/* 1136 */     if (days > 0) {
/*      */       
/* 1138 */       currenttip.add(days + " " + TFC_Core.translate("gui.daysRemaining"));
/*      */     }
/* 1140 */     else if (!enoughSpace) {
/*      */       
/* 1142 */       currenttip.add(TFC_Core.translate("gui.enoughSpace"));
/*      */     } 
/*      */     
/* 1145 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> sluiceBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1150 */     NBTTagCompound tag = accessor.getNBTData();
/* 1151 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/* 1152 */     int soilAmount = tag.func_74762_e("soilAmount");
/*      */     
/* 1154 */     if (soilAmount == -1) {
/* 1155 */       currenttip.add(TFC_Core.translate("gui.Sluice.Overworked"));
/* 1156 */     } else if (soilAmount > 0) {
/*      */       
/* 1158 */       currenttip.add(TFC_Core.translate("gui.Sluice.Soil") + " : " + soilAmount + "/50");
/*      */     } 
/*      */     
/* 1161 */     int gemCount = 0, oreCount = 0;
/* 1162 */     for (ItemStack is : storage) {
/*      */       
/* 1164 */       if (is != null)
/*      */       {
/* 1166 */         if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemGem) {
/* 1167 */           gemCount++;
/* 1168 */         } else if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemOre) {
/* 1169 */           oreCount++;
/*      */         } 
/*      */       }
/*      */     } 
/* 1173 */     if (gemCount > 0)
/* 1174 */       currenttip.add(TFC_Core.translate("gui.gems") + " : " + gemCount); 
/* 1175 */     if (oreCount > 0) {
/* 1176 */       currenttip.add(TFC_Core.translate("gui.Bloomery.Ore") + " : " + oreCount);
/*      */     }
/* 1178 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> smokeRackBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1183 */     NBTTagCompound tag = accessor.getNBTData();
/* 1184 */     ItemStack[] storage = getStorage(tag, accessor.getTileEntity());
/*      */     
/* 1186 */     for (int i = 0; i < storage.length; i++) {
/*      */       
/* 1188 */       ItemStack is = storage[i];
/* 1189 */       if (is != null) {
/*      */         
/* 1191 */         int dryHours = 4 - Food.getDried(is);
/* 1192 */         int smokeHours = 12 - Food.getSmokeCounter(is);
/*      */         
/* 1194 */         if (smokeHours < 12 && !Food.isSmoked(is)) {
/*      */           
/* 1196 */           smokeHours++;
/* 1197 */           float percent = Helper.roundNumber(100.0F - 100.0F * smokeHours / 12.0F, 10.0F);
/* 1198 */           currenttip.add(TFC_Core.translate("word.smoking") + " " + is.func_82833_r());
/* 1199 */           currenttip.add("· " + smokeHours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + percent + "%)");
/*      */         }
/* 1201 */         else if (dryHours < 4 && !Food.isDried(is)) {
/*      */           
/* 1203 */           float percent = Helper.roundNumber(100.0F - 100.0F * dryHours / 4.0F, 10.0F);
/* 1204 */           currenttip.add(TFC_Core.translate("word.drying") + " " + is.func_82833_r());
/* 1205 */           currenttip.add("· " + dryHours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + percent + "%)");
/*      */         } else {
/*      */           
/* 1208 */           currenttip.add(is.func_82833_r());
/*      */         } 
/*      */       } 
/*      */     } 
/* 1212 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> spawnMeterBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1217 */     NBTTagCompound tag = accessor.getNBTData();
/* 1218 */     int hours = tag.func_74762_e("protectionHours");
/*      */     
/* 1220 */     if (hours > 0)
/*      */     {
/* 1222 */       currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining"));
/*      */     }
/*      */     
/* 1225 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> soilBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1230 */     Block b = accessor.getBlock();
/* 1231 */     int dam = itemStack.func_77960_j();
/* 1232 */     if (b == TFCBlocks.dirt2 || b == TFCBlocks.sand2 || TFC_Core.isGrassType2(b) || b == TFCBlocks.gravel2)
/*      */     {
/* 1234 */       dam += 16;
/*      */     }
/*      */     
/* 1237 */     if (dam < Global.STONE_ALL.length) {
/* 1238 */       currenttip.add(Global.STONE_ALL[dam]);
/*      */     } else {
/* 1240 */       currenttip.add(EnumChatFormatting.DARK_RED + "Unknown");
/*      */     } 
/* 1242 */     return currenttip;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> torchBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
/* 1247 */     if (accessor.getMetadata() < 8 && TFCOptions.torchBurnTime != 0) {
/*      */       
/* 1249 */       NBTTagCompound tag = accessor.getNBTData();
/* 1250 */       long hours = TFCOptions.torchBurnTime - TFC_Time.getTotalHours() - tag.func_74762_e("hourPlaced");
/*      */       
/* 1252 */       if (hours > 0L)
/* 1253 */         currenttip.add(hours + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(100.0F * (float)hours / TFCOptions.torchBurnTime, 10.0F) + "%)"); 
/*      */     } 
/* 1255 */     return currenttip;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemStack[] getStorage(NBTTagCompound tag, TileEntity te) {
/* 1261 */     if (te instanceof IInventory) {
/*      */       
/* 1263 */       IInventory inv = (IInventory)te;
/* 1264 */       NBTTagList tagList = tag.func_150295_c("Items", 10);
/* 1265 */       ItemStack[] storage = new ItemStack[inv.func_70302_i_()];
/* 1266 */       for (int i = 0; i < tagList.func_74745_c(); i++) {
/*      */         
/* 1268 */         NBTTagCompound itemTag = tagList.func_150305_b(i);
/* 1269 */         byte slot = itemTag.func_74771_c("Slot");
/* 1270 */         if (slot >= 0 && slot < storage.length) {
/* 1271 */           storage[slot] = ItemStack.func_77949_a(itemTag);
/*      */         }
/*      */       } 
/* 1274 */       return storage;
/*      */     } 
/*      */     
/* 1277 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private int getOreGrade(TEOre te, int ore) {
/* 1282 */     if (te != null) {
/*      */       
/* 1284 */       int grade = te.extraData & 0x7;
/* 1285 */       if (grade == 1) {
/* 1286 */         ore += 35;
/* 1287 */       } else if (grade == 2) {
/* 1288 */         ore += 49;
/*      */       } 
/* 1290 */     }  return ore;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WAILA\WAILAData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */