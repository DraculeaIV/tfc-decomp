/*     */ package com.bioxx.tfc;
/*     */ import com.bioxx.tfc.Entities.EntityBarrel;
/*     */ import com.bioxx.tfc.Entities.EntityCustomMinecart;
/*     */ import com.bioxx.tfc.Entities.EntityFallingBlockTFC;
/*     */ import com.bioxx.tfc.Entities.EntityJavelin;
/*     */ import com.bioxx.tfc.Entities.EntityStand;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityBear;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityBlazeTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCaveSpiderTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityChickenTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCowTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCreeperTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityDeer;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityEndermanTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityFishTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityGhastTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityIronGolemTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityOcelotTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityPheasantTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityPigTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityPigZombieTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityPolarBear;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntitySilverfishTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntitySkeletonTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntitySlimeTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntitySpiderTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntitySquidTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityWolfTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityZombieTFC;
/*     */ import com.bioxx.tfc.TileEntities.TEBloomery;
/*     */ import com.bioxx.tfc.TileEntities.TECrop;
/*     */ import com.bioxx.tfc.TileEntities.TEDetailed;
/*     */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*     */ import com.bioxx.tfc.TileEntities.TEForge;
/*     */ import com.bioxx.tfc.TileEntities.TEFruitLeaves;
/*     */ import com.bioxx.tfc.TileEntities.TEFruitTreeWood;
/*     */ import com.bioxx.tfc.TileEntities.TEMetalTrapDoor;
/*     */ import com.bioxx.tfc.TileEntities.TEOilLamp;
/*     */ import com.bioxx.tfc.TileEntities.TEOre;
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.TileEntities.TEWorldItem;
/*     */ import com.bioxx.tfc.Tools.ChiselMode_Slab;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Tools.ChiselManager;
/*     */ import com.bioxx.tfc.api.Tools.ChiselMode;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.event.FMLInterModComms;
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import net.minecraftforge.fluids.FluidRegistry;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ 
/*     */ public class CommonProxy {
/*     */   public void registerFluidIcons() {}
/*     */   
/*     */   public String getCurrentLanguage() {
/*  63 */     return null;
/*     */   } public void registerRenderInformation() {} public void registerBiomeEventHandler() {}
/*     */   public void registerPlayerRenderEventHandler() {}
/*     */   public void setupGuiIngameForge() {}
/*     */   public void registerTileEntities(boolean b) {
/*  68 */     GameRegistry.registerTileEntity(TELogPile.class, "TerraLogPile");
/*  69 */     GameRegistry.registerTileEntity(TEWorkbench.class, "TerraWorkbench");
/*  70 */     GameRegistry.registerTileEntity(TEForge.class, "TerraForge");
/*  71 */     GameRegistry.registerTileEntity(TEBlastFurnace.class, "TerraBloomery");
/*  72 */     GameRegistry.registerTileEntity(TEBloomery.class, "TerraEarlyBloomery");
/*  73 */     GameRegistry.registerTileEntity(TESluice.class, "TerraSluice");
/*  74 */     GameRegistry.registerTileEntity(TEFarmland.class, "TileEntityFarmland");
/*  75 */     GameRegistry.registerTileEntity(TECrop.class, "TileEntityCrop");
/*  76 */     GameRegistry.registerTileEntity(TEFruitTreeWood.class, "FruitTreeWood");
/*  77 */     GameRegistry.registerTileEntity(TEPartial.class, "Partial");
/*  78 */     GameRegistry.registerTileEntity(TEDetailed.class, "Detailed");
/*  79 */     GameRegistry.registerTileEntity(TESpawnMeter.class, "SpawnMeter");
/*  80 */     GameRegistry.registerTileEntity(TESapling.class, "Sapling");
/*  81 */     GameRegistry.registerTileEntity(TEWoodConstruct.class, "WoodConstruct");
/*  82 */     GameRegistry.registerTileEntity(TEBarrel.class, "Barrel");
/*  83 */     GameRegistry.registerTileEntity(TEFenceGate.class, "FenceGate");
/*  84 */     GameRegistry.registerTileEntity(TEBloom.class, "IronBloom");
/*  85 */     GameRegistry.registerTileEntity(TECrucible.class, "Crucible");
/*  86 */     GameRegistry.registerTileEntity(TENestBox.class, "Nest Box");
/*  87 */     GameRegistry.registerTileEntity(TEStand.class, "Armour Stand");
/*  88 */     GameRegistry.registerTileEntity(TEBerryBush.class, "Berry Bush");
/*  89 */     GameRegistry.registerTileEntity(TEFruitLeaves.class, "Fruit Leaves");
/*  90 */     GameRegistry.registerTileEntity(TEMetalSheet.class, "Metal Sheet");
/*  91 */     GameRegistry.registerTileEntity(TEOre.class, "ore");
/*  92 */     GameRegistry.registerTileEntity(TELeatherRack.class, "leatherRack");
/*  93 */     GameRegistry.registerTileEntity(TEMetalTrapDoor.class, "MetalTrapDoor");
/*  94 */     GameRegistry.registerTileEntity(TEWaterPlant.class, "Sea Weed");
/*  95 */     GameRegistry.registerTileEntity(TEVessel.class, "Vessel");
/*  96 */     GameRegistry.registerTileEntity(TELightEmitter.class, "LightEmitter");
/*  97 */     GameRegistry.registerTileEntity(TESmokeRack.class, "Smoke Rack");
/*  98 */     GameRegistry.registerTileEntity(TEOilLamp.class, "Oil Lamp");
/*     */ 
/*     */     
/* 101 */     if (b) {
/*     */       
/* 103 */       GameRegistry.registerTileEntity(TEFirepit.class, "TerraFirepit");
/* 104 */       GameRegistry.registerTileEntity(TEIngotPile.class, "ingotPile");
/* 105 */       GameRegistry.registerTileEntity(TEPottery.class, "Pottery");
/* 106 */       GameRegistry.registerTileEntity(TEChest.class, "chest");
/* 107 */       GameRegistry.registerTileEntity(TEFoodPrep.class, "FoodPrep");
/* 108 */       GameRegistry.registerTileEntity(TEBellows.class, "Bellows");
/* 109 */       GameRegistry.registerTileEntity(TEToolRack.class, "ToolRack");
/* 110 */       GameRegistry.registerTileEntity(TEAnvil.class, "TerraAnvil");
/* 111 */       GameRegistry.registerTileEntity(TEWorldItem.class, "worldItem");
/* 112 */       GameRegistry.registerTileEntity(TEQuern.class, "Quern");
/* 113 */       GameRegistry.registerTileEntity(TELoom.class, "Loom");
/* 114 */       GameRegistry.registerTileEntity(TEGrill.class, "grill");
/* 115 */       GameRegistry.registerTileEntity(TEHopper.class, "HopperTFC");
/*     */     } 
/*     */     
/* 118 */     EntityRegistry.registerGlobalEntityID(EntitySquidTFC.class, "squidTFC", EntityRegistry.findGlobalUniqueEntityId(), 3953766, 2490406);
/* 119 */     EntityRegistry.registerGlobalEntityID(EntityFishTFC.class, "fishTFC", EntityRegistry.findGlobalUniqueEntityId(), 5460529, 2490406);
/* 120 */     EntityRegistry.registerGlobalEntityID(EntityCowTFC.class, "cowTFC", EntityRegistry.findGlobalUniqueEntityId(), 4009763, 2490406);
/* 121 */     EntityRegistry.registerGlobalEntityID(EntityWolfTFC.class, "wolfTFC", EntityRegistry.findGlobalUniqueEntityId(), 9670540, 2490406);
/* 122 */     EntityRegistry.registerGlobalEntityID(EntityBear.class, "bearTFC", EntityRegistry.findGlobalUniqueEntityId(), 6048571, 2490406);
/* 123 */     EntityRegistry.registerGlobalEntityID(EntityPolarBear.class, "polarbearTFC", EntityRegistry.findGlobalUniqueEntityId(), 855309, 2490406);
/* 124 */     EntityRegistry.registerGlobalEntityID(EntityChickenTFC.class, "chickenTFC", EntityRegistry.findGlobalUniqueEntityId(), 15987806, 2490406);
/* 125 */     EntityRegistry.registerGlobalEntityID(EntityPigTFC.class, "pigTFC", EntityRegistry.findGlobalUniqueEntityId(), 15173510, 2490406);
/* 126 */     EntityRegistry.registerGlobalEntityID(EntityDeer.class, "deerTFC", EntityRegistry.findGlobalUniqueEntityId(), 8151628, 2490406);
/*     */     
/* 128 */     EntityRegistry.registerGlobalEntityID(EntitySkeletonTFC.class, "skeletonTFC", EntityRegistry.findGlobalUniqueEntityId(), 9934743, 2490406);
/* 129 */     EntityRegistry.registerGlobalEntityID(EntityZombieTFC.class, "zombieTFC", EntityRegistry.findGlobalUniqueEntityId(), 4352563, 2490406);
/* 130 */     EntityRegistry.registerGlobalEntityID(EntitySpiderTFC.class, "spiderTFC", EntityRegistry.findGlobalUniqueEntityId(), 3287844, 2490406);
/* 131 */     EntityRegistry.registerGlobalEntityID(EntitySlimeTFC.class, "slimeTFC", EntityRegistry.findGlobalUniqueEntityId(), 7254876, 2490406);
/* 132 */     EntityRegistry.registerGlobalEntityID(EntitySilverfishTFC.class, "silverfishTFC", EntityRegistry.findGlobalUniqueEntityId(), 8751239, 2490406);
/* 133 */     EntityRegistry.registerGlobalEntityID(EntityGhastTFC.class, "ghastTFC", EntityRegistry.findGlobalUniqueEntityId(), 15461355, 2490406);
/* 134 */     EntityRegistry.registerGlobalEntityID(EntityCaveSpiderTFC.class, "caveSpiderTFC", EntityRegistry.findGlobalUniqueEntityId(), 1192502, 2490406);
/* 135 */     EntityRegistry.registerGlobalEntityID(EntityBlazeTFC.class, "blazeTFC", EntityRegistry.findGlobalUniqueEntityId(), 11365643, 2490406);
/* 136 */     EntityRegistry.registerGlobalEntityID(EntityEndermanTFC.class, "endermanTFC", EntityRegistry.findGlobalUniqueEntityId(), 855309, 2490406);
/* 137 */     EntityRegistry.registerGlobalEntityID(EntityPigZombieTFC.class, "pigZombieTFC", EntityRegistry.findGlobalUniqueEntityId(), 11957087, 2490406);
/* 138 */     EntityRegistry.registerGlobalEntityID(EntityIronGolemTFC.class, "irongolemTFC", EntityRegistry.findGlobalUniqueEntityId(), 12564890, 2490406);
/* 139 */     EntityRegistry.registerGlobalEntityID(EntityCreeperTFC.class, "creeperTFC", EntityRegistry.findGlobalUniqueEntityId(), 6735196, 2490406);
/* 140 */     EntityRegistry.registerGlobalEntityID(EntityOcelotTFC.class, "ocelotTFC", EntityRegistry.findGlobalUniqueEntityId(), 16711680, 16777215);
/*     */     
/* 142 */     EntityRegistry.registerGlobalEntityID(EntitySheepTFC.class, "sheepTFC", EntityRegistry.findGlobalUniqueEntityId(), 13483956, 2490406);
/* 143 */     EntityRegistry.registerGlobalEntityID(EntityPheasantTFC.class, "pheasantTFC", EntityRegistry.findGlobalUniqueEntityId(), 8530972, 2490406);
/*     */     
/* 145 */     EntityRegistry.registerGlobalEntityID(EntityHorseTFC.class, "horseTFC", EntityRegistry.findGlobalUniqueEntityId(), 9857334, 2490406);
/*     */     
/* 147 */     EntityRegistry.registerGlobalEntityID(EntityCustomMinecart.class, "minecartTFC", EntityRegistry.findGlobalUniqueEntityId());
/* 148 */     EntityRegistry.registerGlobalEntityID(EntityProjectileTFC.class, "arrowTFC", EntityRegistry.findGlobalUniqueEntityId());
/* 149 */     EntityRegistry.registerGlobalEntityID(EntityStand.class, "standTFC", EntityRegistry.findGlobalUniqueEntityId());
/*     */     
/* 151 */     EntityRegistry.registerGlobalEntityID(EntityFallingBlockTFC.class, "fallingBlock", EntityRegistry.findGlobalUniqueEntityId());
/* 152 */     EntityRegistry.registerGlobalEntityID(EntityBarrel.class, "barrel", EntityRegistry.findGlobalUniqueEntityId());
/*     */     
/* 154 */     EntityRegistry.registerModEntity(EntityJavelin.class, "javelin", 1, TerraFirmaCraft.instance, 64, 5, true);
/* 155 */     EntityRegistry.registerModEntity(EntitySquidTFC.class, "squidTFC", 2, TerraFirmaCraft.instance, 64, 5, true);
/* 156 */     EntityRegistry.registerModEntity(EntityCowTFC.class, "cowTFC", 6, TerraFirmaCraft.instance, 160, 5, true);
/* 157 */     EntityRegistry.registerModEntity(EntityWolfTFC.class, "wolfTFC", 7, TerraFirmaCraft.instance, 160, 5, true);
/* 158 */     EntityRegistry.registerModEntity(EntityBear.class, "bearTFC", 8, TerraFirmaCraft.instance, 160, 5, true);
/* 159 */     EntityRegistry.registerModEntity(EntityPolarBear.class, "polarbearTFC", 30, TerraFirmaCraft.instance, 160, 5, true);
/* 160 */     EntityRegistry.registerModEntity(EntityChickenTFC.class, "chickenTFC", 9, TerraFirmaCraft.instance, 160, 5, true);
/* 161 */     EntityRegistry.registerModEntity(EntityPigTFC.class, "pigTFC", 10, TerraFirmaCraft.instance, 160, 5, true);
/* 162 */     EntityRegistry.registerModEntity(EntityDeer.class, "deerTFC", 11, TerraFirmaCraft.instance, 160, 5, true);
/* 163 */     EntityRegistry.registerModEntity(EntityCustomMinecart.class, "minecartTFC", 12, TerraFirmaCraft.instance, 80, 5, true);
/* 164 */     EntityRegistry.registerModEntity(EntitySkeletonTFC.class, "skeletonTFC", 13, TerraFirmaCraft.instance, 160, 5, true);
/* 165 */     EntityRegistry.registerModEntity(EntityZombieTFC.class, "zombieTFC", 14, TerraFirmaCraft.instance, 160, 5, true);
/* 166 */     EntityRegistry.registerModEntity(EntitySpiderTFC.class, "spiderTFC", 15, TerraFirmaCraft.instance, 160, 5, true);
/* 167 */     EntityRegistry.registerModEntity(EntitySlimeTFC.class, "slimeTFC", 16, TerraFirmaCraft.instance, 160, 5, true);
/* 168 */     EntityRegistry.registerModEntity(EntitySilverfishTFC.class, "silverFishTFC", 17, TerraFirmaCraft.instance, 160, 5, true);
/* 169 */     EntityRegistry.registerModEntity(EntityGhastTFC.class, "ghastTFC", 18, TerraFirmaCraft.instance, 160, 5, true);
/* 170 */     EntityRegistry.registerModEntity(EntityCaveSpiderTFC.class, "caveSpiderTFC", 19, TerraFirmaCraft.instance, 160, 5, true);
/* 171 */     EntityRegistry.registerModEntity(EntityBlazeTFC.class, "blazeTFC", 20, TerraFirmaCraft.instance, 160, 5, true);
/* 172 */     EntityRegistry.registerModEntity(EntityEndermanTFC.class, "endermanTFC", 21, TerraFirmaCraft.instance, 160, 5, true);
/* 173 */     EntityRegistry.registerModEntity(EntityPigZombieTFC.class, "pigZombieTFC", 22, TerraFirmaCraft.instance, 160, 5, true);
/* 174 */     EntityRegistry.registerModEntity(EntityIronGolemTFC.class, "irongolemTFC", 23, TerraFirmaCraft.instance, 160, 5, true);
/* 175 */     EntityRegistry.registerModEntity(EntityCreeperTFC.class, "creeperTFC", 24, TerraFirmaCraft.instance, 160, 5, true);
/* 176 */     EntityRegistry.registerModEntity(EntityStand.class, "standTFC", 25, TerraFirmaCraft.instance, 64, 20, false);
/* 177 */     EntityRegistry.registerModEntity(EntityPheasantTFC.class, "PheasantTFC", 26, TerraFirmaCraft.instance, 160, 5, true);
/* 178 */     EntityRegistry.registerModEntity(EntityFishTFC.class, "fishTFC", 27, TerraFirmaCraft.instance, 64, 5, true);
/* 179 */     EntityRegistry.registerModEntity(EntityFallingBlockTFC.class, "fallingBlock", 28, TerraFirmaCraft.instance, 160, 20, true);
/* 180 */     EntityRegistry.registerModEntity(EntityBarrel.class, "barrel", 29, TerraFirmaCraft.instance, 64, 20, true);
/* 181 */     EntityRegistry.registerModEntity(EntityOcelotTFC.class, "ocelotTFC", 31, TerraFirmaCraft.instance, 160, 5, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerFluids() {
/* 197 */     FluidRegistry.registerFluid(TFCFluids.LAVA);
/* 198 */     FluidRegistry.registerFluid(TFCFluids.SALTWATER);
/* 199 */     FluidRegistry.registerFluid(TFCFluids.FRESHWATER);
/* 200 */     FluidRegistry.registerFluid(TFCFluids.HOTWATER);
/* 201 */     FluidRegistry.registerFluid(TFCFluids.RUM);
/* 202 */     FluidRegistry.registerFluid(TFCFluids.BEER);
/* 203 */     FluidRegistry.registerFluid(TFCFluids.RYEWHISKEY);
/* 204 */     FluidRegistry.registerFluid(TFCFluids.CORNWHISKEY);
/* 205 */     FluidRegistry.registerFluid(TFCFluids.WHISKEY);
/* 206 */     FluidRegistry.registerFluid(TFCFluids.SAKE);
/* 207 */     FluidRegistry.registerFluid(TFCFluids.VODKA);
/* 208 */     FluidRegistry.registerFluid(TFCFluids.CIDER);
/* 209 */     FluidRegistry.registerFluid(TFCFluids.TANNIN);
/* 210 */     FluidRegistry.registerFluid(TFCFluids.VINEGAR);
/* 211 */     FluidRegistry.registerFluid(TFCFluids.BRINE);
/* 212 */     FluidRegistry.registerFluid(TFCFluids.LIMEWATER);
/* 213 */     FluidRegistry.registerFluid(TFCFluids.MILK);
/* 214 */     FluidRegistry.registerFluid(TFCFluids.MILKCURDLED);
/* 215 */     FluidRegistry.registerFluid(TFCFluids.MILKVINEGAR);
/* 216 */     FluidRegistry.registerFluid(TFCFluids.OLIVEOIL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupFluids() {
/* 221 */     FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid(TFCFluids.LAVA.getName()), new ItemStack(TFCItems.blueSteelBucketLava), new ItemStack(TFCItems.blueSteelBucketEmpty));
/* 222 */     FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid(TFCFluids.FRESHWATER.getName()), new ItemStack(TFCItems.redSteelBucketWater), new ItemStack(TFCItems.redSteelBucketEmpty));
/* 223 */     FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid(TFCFluids.SALTWATER.getName()), new ItemStack(TFCItems.redSteelBucketSaltWater), new ItemStack(TFCItems.redSteelBucketEmpty));
/* 224 */     FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid(TFCFluids.FRESHWATER.getName()), new ItemStack(TFCItems.woodenBucketWater), new ItemStack(TFCItems.woodenBucketEmpty));
/* 225 */     FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid(TFCFluids.SALTWATER.getName()), new ItemStack(TFCItems.woodenBucketSaltWater), new ItemStack(TFCItems.woodenBucketEmpty));
/* 226 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.FRESHWATER, 1000), new ItemStack(TFCItems.potteryJug, 1, 2), new ItemStack(TFCItems.potteryJug, 1, 1));
/* 227 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.RUM, 250), new ItemStack(TFCItems.rum), new ItemStack(TFCItems.glassBottle));
/* 228 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.BEER, 250), new ItemStack(TFCItems.beer), new ItemStack(TFCItems.glassBottle));
/* 229 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.RYEWHISKEY, 250), new ItemStack(TFCItems.ryeWhiskey), new ItemStack(TFCItems.glassBottle));
/* 230 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.WHISKEY, 250), new ItemStack(TFCItems.whiskey), new ItemStack(TFCItems.glassBottle));
/* 231 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.CORNWHISKEY, 250), new ItemStack(TFCItems.cornWhiskey), new ItemStack(TFCItems.glassBottle));
/* 232 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.SAKE, 250), new ItemStack(TFCItems.sake), new ItemStack(TFCItems.glassBottle));
/* 233 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.CIDER, 250), new ItemStack(TFCItems.cider), new ItemStack(TFCItems.glassBottle));
/* 234 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.VODKA, 250), new ItemStack(TFCItems.vodka), new ItemStack(TFCItems.glassBottle));
/* 235 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.MILK, 1000), new ItemStack(TFCItems.woodenBucketMilk), new ItemStack(TFCItems.woodenBucketEmpty));
/* 236 */     FluidContainerRegistry.registerFluidContainer(new FluidStack(TFCFluids.VINEGAR, 1000), new ItemStack(TFCItems.vinegar), new ItemStack(TFCItems.woodenBucketEmpty));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerToolClasses() {
/* 249 */     TFCItems.bismuthBronzePick.setHarvestLevel("pickaxe", 2);
/* 250 */     TFCItems.bismuthBronzePick.setHarvestLevel("pickaxe", 2);
/* 251 */     TFCItems.blackBronzePick.setHarvestLevel("pickaxe", 2);
/* 252 */     TFCItems.blackSteelPick.setHarvestLevel("pickaxe", 5);
/* 253 */     TFCItems.blueSteelPick.setHarvestLevel("pickaxe", 6);
/* 254 */     TFCItems.bronzePick.setHarvestLevel("pickaxe", 2);
/* 255 */     TFCItems.copperPick.setHarvestLevel("pickaxe", 1);
/* 256 */     TFCItems.wroughtIronPick.setHarvestLevel("pickaxe", 3);
/* 257 */     TFCItems.redSteelPick.setHarvestLevel("pickaxe", 6);
/* 258 */     TFCItems.steelPick.setHarvestLevel("pickaxe", 4);
/*     */     
/* 260 */     TFCItems.igInShovel.setHarvestLevel("shovel", 1);
/* 261 */     TFCItems.igExShovel.setHarvestLevel("shovel", 1);
/* 262 */     TFCItems.sedShovel.setHarvestLevel("shovel", 1);
/* 263 */     TFCItems.mMShovel.setHarvestLevel("shovel", 1);
/* 264 */     TFCItems.bismuthBronzeShovel.setHarvestLevel("shovel", 2);
/* 265 */     TFCItems.blackBronzeShovel.setHarvestLevel("shovel", 2);
/* 266 */     TFCItems.blackSteelShovel.setHarvestLevel("shovel", 5);
/* 267 */     TFCItems.blueSteelShovel.setHarvestLevel("shovel", 6);
/* 268 */     TFCItems.bronzeShovel.setHarvestLevel("shovel", 2);
/* 269 */     TFCItems.copperShovel.setHarvestLevel("shovel", 1);
/* 270 */     TFCItems.wroughtIronShovel.setHarvestLevel("shovel", 3);
/* 271 */     TFCItems.redSteelShovel.setHarvestLevel("shovel", 6);
/* 272 */     TFCItems.steelShovel.setHarvestLevel("shovel", 4);
/*     */     
/* 274 */     TFCItems.igInAxe.setHarvestLevel("axe", 1);
/* 275 */     TFCItems.igExAxe.setHarvestLevel("axe", 1);
/* 276 */     TFCItems.sedAxe.setHarvestLevel("axe", 1);
/* 277 */     TFCItems.mMAxe.setHarvestLevel("axe", 1);
/* 278 */     TFCItems.bismuthBronzeAxe.setHarvestLevel("axe", 2);
/* 279 */     TFCItems.blackBronzeAxe.setHarvestLevel("axe", 2);
/* 280 */     TFCItems.blackSteelAxe.setHarvestLevel("axe", 5);
/* 281 */     TFCItems.blueSteelAxe.setHarvestLevel("axe", 6);
/* 282 */     TFCItems.bronzeAxe.setHarvestLevel("axe", 2);
/* 283 */     TFCItems.copperAxe.setHarvestLevel("axe", 1);
/* 284 */     TFCItems.wroughtIronAxe.setHarvestLevel("axe", 3);
/* 285 */     TFCItems.redSteelAxe.setHarvestLevel("axe", 6);
/* 286 */     TFCItems.steelAxe.setHarvestLevel("axe", 4);
/*     */     
/* 288 */     TFCItems.bismuthBronzeSaw.setHarvestLevel("axe", 2);
/* 289 */     TFCItems.blackBronzeSaw.setHarvestLevel("axe", 2);
/* 290 */     TFCItems.blackSteelSaw.setHarvestLevel("axe", 5);
/* 291 */     TFCItems.blueSteelSaw.setHarvestLevel("axe", 6);
/* 292 */     TFCItems.bronzeSaw.setHarvestLevel("axe", 2);
/* 293 */     TFCItems.copperSaw.setHarvestLevel("axe", 1);
/* 294 */     TFCItems.wroughtIronSaw.setHarvestLevel("axe", 3);
/* 295 */     TFCItems.redSteelSaw.setHarvestLevel("axe", 6);
/* 296 */     TFCItems.steelSaw.setHarvestLevel("axe", 4);
/*     */     
/* 298 */     TFCItems.stoneHammer.setHarvestLevel("hammer", 1);
/* 299 */     TFCItems.bismuthBronzeHammer.setHarvestLevel("hammer", 2);
/* 300 */     TFCItems.blackBronzeHammer.setHarvestLevel("hammer", 2);
/* 301 */     TFCItems.blackSteelHammer.setHarvestLevel("hammer", 5);
/* 302 */     TFCItems.blueSteelHammer.setHarvestLevel("hammer", 6);
/* 303 */     TFCItems.bronzeHammer.setHarvestLevel("hammer", 2);
/* 304 */     TFCItems.copperHammer.setHarvestLevel("hammer", 1);
/* 305 */     TFCItems.wroughtIronHammer.setHarvestLevel("hammer", 3);
/* 306 */     TFCItems.redSteelHammer.setHarvestLevel("hammer", 6);
/* 307 */     TFCItems.steelHammer.setHarvestLevel("hammer", 4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onClientLogin() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSkyProvider(TFCProvider p) {}
/*     */ 
/*     */   
/*     */   public boolean isRemote() {
/* 320 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public World getCurrentWorld() {
/* 325 */     return MinecraftServer.func_71276_C().func_130014_f_();
/*     */   }
/*     */ 
/*     */   
/*     */   public int waterColorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 330 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int grassColorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 335 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int foliageColorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 340 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory) {
/* 345 */     FMLCommonHandler.instance().firePlayerCraftingEvent(entityplayer, itemstack, iinventory);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getArmorRenderID(String name) {
/* 350 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getGraphicsLevel() {
/* 355 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerKeys() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerKeyBindingHandler() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void uploadKeyBindingsToGame() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerHandlers() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSoundHandler() {}
/*     */ 
/*     */   
/*     */   public void registerTickHandler() {
/* 380 */     FMLCommonHandler.instance().bus().register(new ServerTickHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerGuiHandler() {
/* 385 */     NetworkRegistry.INSTANCE.registerGuiHandler(TerraFirmaCraft.instance, (IGuiHandler)new GuiHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerWailaClasses() {
/* 390 */     FMLInterModComms.sendMessage("Waila", "register", "com.bioxx.tfc.WAILA.WAILAData.callbackRegister");
/* 391 */     FMLInterModComms.sendMessage("Waila", "register", "com.bioxx.tfc.WAILA.WMobs.callbackRegister");
/* 392 */     FMLInterModComms.sendMessage("Waila", "register", "com.bioxx.tfc.WAILA.WCrucible.callbackRegister");
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerChiselModes() {
/* 397 */     ChiselManager.getInstance().addChiselMode((ChiselMode)new ChiselMode_Smooth("Smooth"));
/* 398 */     ChiselManager.getInstance().addChiselMode((ChiselMode)new ChiselMode_Stair("Stairs"));
/* 399 */     ChiselManager.getInstance().addChiselMode((ChiselMode)new ChiselMode_Slab("Slabs"));
/* 400 */     ChiselManager.getInstance().addChiselMode((ChiselMode)new ChiselMode_Detailed("Detailed"));
/*     */   }
/*     */   
/*     */   public void hideNEIItems() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\CommonProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */