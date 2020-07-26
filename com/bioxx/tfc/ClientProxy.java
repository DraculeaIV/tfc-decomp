/*     */ package com.bioxx.tfc;
/*     */ import com.bioxx.tfc.Core.ColorizerFoliageTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.EntityJavelin;
/*     */ import com.bioxx.tfc.Handlers.Client.BlockRenderHandler;
/*     */ import com.bioxx.tfc.Handlers.Client.FMLClientEventHandler;
/*     */ import com.bioxx.tfc.Handlers.Client.GuiHandler;
/*     */ import com.bioxx.tfc.Handlers.Client.KeyBindingHandler;
/*     */ import com.bioxx.tfc.Handlers.Client.PlayerRenderHandler;
/*     */ import com.bioxx.tfc.Handlers.Client.RenderOverlayHandler;
/*     */ import com.bioxx.tfc.Render.Blocks.RenderCrucible;
/*     */ import com.bioxx.tfc.Render.Blocks.RenderSupportBeam;
/*     */ import com.bioxx.tfc.Render.Models.ModelBear;
/*     */ import com.bioxx.tfc.Render.Models.ModelPigTFC;
/*     */ import com.bioxx.tfc.Render.Models.ModelWolfTFC;
/*     */ import com.bioxx.tfc.Render.RenderDeer;
/*     */ import com.bioxx.tfc.Render.RenderSkeletonTFC;
/*     */ import com.bioxx.tfc.Render.TESR.TESRQuern;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.Util.KeyBindings;
/*     */ import cpw.mods.fml.client.registry.ClientRegistry;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelSlime;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderMinecart;
/*     */ import net.minecraft.client.renderer.entity.RenderSpider;
/*     */ import net.minecraft.client.renderer.entity.RenderZombie;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.client.resources.IReloadableResourceManager;
/*     */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.GuiIngameForge;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ public class ClientProxy extends CommonProxy {
/*     */   public void registerFluidIcons() {
/*  48 */     TFCFluids.LAVA.setIcons(TFCBlocks.lava.func_149691_a(0, 0), TFCBlocks.lava.func_149691_a(2, 0));
/*  49 */     TFCFluids.SALTWATER.setIcons(TFCBlocks.saltWater.func_149691_a(0, 0), TFCBlocks.saltWater.func_149691_a(2, 0));
/*  50 */     TFCFluids.FRESHWATER.setIcons(TFCBlocks.freshWater.func_149691_a(0, 0), TFCBlocks.freshWater.func_149691_a(2, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerRenderInformation() {
/*  57 */     (Minecraft.func_71410_x()).field_71460_t = (EntityRenderer)new EntityRendererTFC(Minecraft.func_71410_x(), Minecraft.func_71410_x().func_110442_L());
/*  58 */     IReloadableResourceManager iRRM = (IReloadableResourceManager)Minecraft.func_71410_x().func_110442_L();
/*  59 */     iRRM.func_110542_a((IResourceManagerReloadListener)new GrassColorReloadListener());
/*  60 */     iRRM.func_110542_a((IResourceManagerReloadListener)new FoliageColorReloadListener());
/*  61 */     iRRM.func_110542_a((IResourceManagerReloadListener)(Minecraft.func_71410_x()).field_71460_t);
/*     */     
/*  63 */     RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, (Render)new RenderTerraJavelin());
/*  64 */     RenderingRegistry.registerEntityRenderingHandler(EntitySquidTFC.class, (Render)new RenderSquidTFC((ModelBase)new ModelSquidTFC(), 0.7F));
/*  65 */     RenderingRegistry.registerEntityRenderingHandler(EntityCowTFC.class, (Render)new RenderCowTFC((ModelBase)new ModelCowTFC(), 0.7F));
/*  66 */     RenderingRegistry.registerEntityRenderingHandler(EntitySheepTFC.class, (Render)new RenderSheepTFC((ModelBase)new ModelSheep2TFC(), (ModelBase)new ModelSheep1TFC(), 0.4F));
/*  67 */     RenderingRegistry.registerEntityRenderingHandler(EntityWolfTFC.class, (Render)new RenderWolfTFC((ModelBase)new ModelWolfTFC(), (ModelBase)new ModelWolfTFC(), 0.5F));
/*  68 */     RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, (Render)new RenderBear((ModelBase)new ModelBear(), 0.9F));
/*  69 */     RenderingRegistry.registerEntityRenderingHandler(EntityPheasantTFC.class, (Render)new RenderPheasantTFC((ModelBase)new ModelPheasant(), 0.3F));
/*  70 */     RenderingRegistry.registerEntityRenderingHandler(EntityChickenTFC.class, (Render)new RenderChickenTFC((ModelBase)new ModelChickenTFC(), 0.3F));
/*  71 */     RenderingRegistry.registerEntityRenderingHandler(EntityPigTFC.class, (Render)new RenderPigTFC((ModelBase)new ModelPigTFC(), (ModelBase)new ModelPigTFC(0.5F), 0.7F));
/*  72 */     RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, (Render)new RenderDeer((ModelBase)new ModelDeer(), 0.9F));
/*  73 */     RenderingRegistry.registerEntityRenderingHandler(EntityHorseTFC.class, (Render)new RenderHorseTFC((ModelBase)new ModelHorseTFC(), 0.9F));
/*  74 */     RenderingRegistry.registerEntityRenderingHandler(EntityCustomMinecart.class, (Render)new RenderMinecart());
/*  75 */     RenderingRegistry.registerEntityRenderingHandler(EntityStand.class, (Render)new RenderEntityStand());
/*  76 */     RenderingRegistry.registerEntityRenderingHandler(EntityFishTFC.class, (Render)new RenderFishTFC((ModelBase)new ModelBass(), 0.7F));
/*  77 */     RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTFC.class, (Render)new RenderSkeletonTFC());
/*  78 */     RenderingRegistry.registerEntityRenderingHandler(EntityZombieTFC.class, (Render)new RenderZombie());
/*  79 */     RenderingRegistry.registerEntityRenderingHandler(EntitySpiderTFC.class, (Render)new RenderSpider());
/*  80 */     RenderingRegistry.registerEntityRenderingHandler(EntitySlimeTFC.class, (Render)new RenderSlime((ModelBase)new ModelSlime(16), (ModelBase)new ModelSlime(0), 0.25F));
/*  81 */     RenderingRegistry.registerEntityRenderingHandler(EntitySilverfishTFC.class, (Render)new RenderSilverfish());
/*  82 */     RenderingRegistry.registerEntityRenderingHandler(EntityGhastTFC.class, (Render)new RenderGhast());
/*  83 */     RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderTFC.class, (Render)new RenderSpider());
/*  84 */     RenderingRegistry.registerEntityRenderingHandler(EntityBlazeTFC.class, (Render)new RenderBlaze());
/*  85 */     RenderingRegistry.registerEntityRenderingHandler(EntityEndermanTFC.class, (Render)new RenderEnderman());
/*  86 */     RenderingRegistry.registerEntityRenderingHandler(EntityPigZombieTFC.class, (Render)new RenderZombie());
/*  87 */     RenderingRegistry.registerEntityRenderingHandler(EntityIronGolemTFC.class, (Render)new RenderIronGolem());
/*     */     
/*  89 */     RenderingRegistry.registerEntityRenderingHandler(EntityProjectileTFC.class, (Render)new RenderArrow());
/*  90 */     RenderingRegistry.registerEntityRenderingHandler(EntityFishHookTFC.class, (Render)new RenderFish());
/*  91 */     RenderingRegistry.registerEntityRenderingHandler(EntityBarrel.class, (Render)new RenderBarrelEntity());
/*  92 */     RenderingRegistry.registerEntityRenderingHandler(EntityFallingBlockTFC.class, (Render)new RenderFallingBlock());
/*     */     
/*  94 */     RenderingRegistry.registerBlockHandler(TFCBlocks.chestRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderChest());
/*  95 */     RenderingRegistry.registerBlockHandler(TFCBlocks.clayGrassRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/*  96 */     RenderingRegistry.registerBlockHandler(TFCBlocks.peatGrassRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/*  97 */     RenderingRegistry.registerBlockHandler(TFCBlocks.sulfurRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/*  98 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodSupportRenderIdH = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSupportBeam());
/*  99 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodSupportRenderIdV = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSupportBeam());
/* 100 */     RenderingRegistry.registerBlockHandler(TFCBlocks.grassRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 101 */     RenderingRegistry.registerBlockHandler(TFCBlocks.oreRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderOre());
/* 102 */     RenderingRegistry.registerBlockHandler(TFCBlocks.moltenRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 103 */     RenderingRegistry.registerBlockHandler(TFCBlocks.looseRockRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 104 */     RenderingRegistry.registerBlockHandler(TFCBlocks.firepitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 105 */     RenderingRegistry.registerBlockHandler(TFCBlocks.anvilRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderAnvil());
/* 106 */     RenderingRegistry.registerBlockHandler(TFCBlocks.bellowsRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderBellows());
/* 107 */     RenderingRegistry.registerBlockHandler(TFCBlocks.forgeRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 108 */     RenderingRegistry.registerBlockHandler(TFCBlocks.sluiceRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 109 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodFruitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 110 */     RenderingRegistry.registerBlockHandler(TFCBlocks.leavesFruitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 111 */     RenderingRegistry.registerBlockHandler(TFCBlocks.stairRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 112 */     RenderingRegistry.registerBlockHandler(TFCBlocks.slabRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 113 */     RenderingRegistry.registerBlockHandler(TFCBlocks.cropRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 114 */     RenderingRegistry.registerBlockHandler(TFCBlocks.cookingPitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 115 */     RenderingRegistry.registerBlockHandler(TFCBlocks.leavesRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 116 */     RenderingRegistry.registerBlockHandler(TFCBlocks.detailedRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 117 */     RenderingRegistry.registerBlockHandler(TFCBlocks.wallRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderWall());
/* 118 */     RenderingRegistry.registerBlockHandler(TFCBlocks.fenceRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderFence());
/* 119 */     RenderingRegistry.registerBlockHandler(TFCBlocks.fenceGateRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderFenceGate());
/* 120 */     RenderingRegistry.registerBlockHandler(TFCBlocks.toolRackRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderToolRack());
/*     */     
/* 122 */     RenderingRegistry.registerBlockHandler(TFCBlocks.quernRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new TESRQuern());
/* 123 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodConstructRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderWoodConstruct());
/* 124 */     RenderingRegistry.registerBlockHandler(TFCBlocks.barrelRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderBarrel());
/* 125 */     RenderingRegistry.registerBlockHandler(TFCBlocks.loomRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderLoom());
/* 126 */     RenderingRegistry.registerBlockHandler(TFCBlocks.standRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderStand());
/* 127 */     RenderingRegistry.registerBlockHandler(TFCBlocks.nestBoxRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderNestBox());
/* 128 */     RenderingRegistry.registerBlockHandler(TFCBlocks.potteryRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderPottery());
/* 129 */     RenderingRegistry.registerBlockHandler(TFCBlocks.tuyereRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderTuyere());
/* 130 */     RenderingRegistry.registerBlockHandler(TFCBlocks.crucibleRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderCrucible());
/* 131 */     RenderingRegistry.registerBlockHandler(TFCBlocks.waterPlantRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/*     */     
/* 133 */     RenderingRegistry.registerBlockHandler(TFCBlocks.bloomeryRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderBloomery());
/* 134 */     RenderingRegistry.registerBlockHandler(TFCBlocks.metalsheetRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderMetalSheet());
/* 135 */     RenderingRegistry.registerBlockHandler(TFCBlocks.leatherRackRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderLeatherRack());
/* 136 */     RenderingRegistry.registerBlockHandler(TFCBlocks.grillRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderGrill());
/* 137 */     RenderingRegistry.registerBlockHandler(TFCBlocks.metalTrapDoorRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderMetalTrapDoor());
/* 138 */     RenderingRegistry.registerBlockHandler(TFCBlocks.vesselRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderVessel());
/* 139 */     RenderingRegistry.registerBlockHandler(TFCBlocks.torchRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderTorch());
/* 140 */     RenderingRegistry.registerBlockHandler(TFCBlocks.smokeRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSmoke());
/* 141 */     RenderingRegistry.registerBlockHandler(TFCBlocks.smokeRackRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSmokeRack());
/* 142 */     RenderingRegistry.registerBlockHandler(TFCBlocks.oilLampRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderOilLamp());
/* 143 */     RenderingRegistry.registerBlockHandler(TFCBlocks.hopperRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderHopper());
/* 144 */     RenderingRegistry.registerBlockHandler(TFCBlocks.flowerPotRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderFlowerPot());
/*     */     
/* 146 */     MinecraftForge.EVENT_BUS.register(new RenderOverlayHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBiomeEventHandler() {
/* 154 */     MinecraftForge.EVENT_BUS.register(new BiomeEventHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setupGuiIngameForge() {
/* 161 */     GuiIngameForge.renderHealth = false;
/* 162 */     GuiIngameForge.renderArmor = false;
/* 163 */     GuiIngameForge.renderExperiance = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerTileEntities(boolean b) {
/* 170 */     super.registerTileEntities(false);
/* 171 */     ClientRegistry.registerTileEntity(TEChest.class, "chest", (TileEntitySpecialRenderer)new TESRChest());
/* 172 */     ClientRegistry.registerTileEntity(TEIngotPile.class, "ingotPile", (TileEntitySpecialRenderer)new TESRIngotPile());
/* 173 */     ClientRegistry.registerTileEntity(TEFirepit.class, "TerraFirepit", (TileEntitySpecialRenderer)new TESRFirepit());
/* 174 */     ClientRegistry.registerTileEntity(TELoom.class, "Loom", (TileEntitySpecialRenderer)new TESRLoom());
/*     */     
/* 176 */     ClientRegistry.registerTileEntity(TEPottery.class, "Pottery", (TileEntitySpecialRenderer)new TESRPottery());
/* 177 */     ClientRegistry.registerTileEntity(TEFoodPrep.class, "FoodPrep", (TileEntitySpecialRenderer)new TESRFoodPrep());
/* 178 */     ClientRegistry.registerTileEntity(TEBellows.class, "Bellows", (TileEntitySpecialRenderer)new TESRBellows());
/* 179 */     ClientRegistry.registerTileEntity(TEToolRack.class, "ToolRack", (TileEntitySpecialRenderer)new TESRToolrack());
/* 180 */     ClientRegistry.registerTileEntity(TEAnvil.class, "TerraAnvil", (TileEntitySpecialRenderer)new TESRAnvil());
/* 181 */     ClientRegistry.registerTileEntity(TEWorldItem.class, "worldItem", (TileEntitySpecialRenderer)new TESRWorldItem());
/* 182 */     ClientRegistry.registerTileEntity(TEQuern.class, "Quern", (TileEntitySpecialRenderer)new TESRQuern());
/* 183 */     ClientRegistry.registerTileEntity(TEGrill.class, "GrillTESR", (TileEntitySpecialRenderer)new TESRGrill());
/* 184 */     ClientRegistry.registerTileEntity(TESmokeRack.class, "SmokeRackTESR", (TileEntitySpecialRenderer)new TESRSmokeRack());
/* 185 */     ClientRegistry.registerTileEntity(TEHopper.class, "HopperTESR", (TileEntitySpecialRenderer)new TESRHopper());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onClientLogin() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public World getCurrentWorld() {
/* 199 */     return (World)(Minecraft.func_71410_x()).field_71441_e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRemote() {
/* 205 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int waterColorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 211 */     return 3493173;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int grassColorMultiplier(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 217 */     int var5 = 0;
/* 218 */     int var6 = 0;
/* 219 */     int var7 = 0;
/*     */     
/* 221 */     for (int z = -1; z <= 1; z++) {
/*     */       
/* 223 */       for (int x = -1; x <= 1; x++) {
/*     */         
/* 225 */         int var10 = TFC_Climate.getGrassColor(getCurrentWorld(), i + x, j, k + z);
/* 226 */         var5 += (var10 & 0xFF0000) >> 16;
/* 227 */         var6 += (var10 & 0xFF00) >> 8;
/* 228 */         var7 += var10 & 0xFF;
/*     */       } 
/*     */     } 
/* 231 */     return (var5 / 9 & 0xFF) << 16 | (var6 / 9 & 0xFF) << 8 | var7 / 9 & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int foliageColorMultiplier(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 240 */     int[] rgb = { 0, 0, 0 };
/* 241 */     float temperature = TFC_Climate.getHeightAdjustedTempSpecificDay(getCurrentWorld(), TFC_Time.getDayOfYear(), i, j, k);
/*     */ 
/*     */     
/* 244 */     int meta = par1IBlockAccess.func_72805_g(i, j, k);
/* 245 */     if (par1IBlockAccess.func_147439_a(i, j, k) == TFCBlocks.fruitTreeLeaves) {
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
/* 256 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 258 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 260 */           int var10 = TFC_Climate.getFoliageColor(getCurrentWorld(), i + m, j, k + var9);
/* 261 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 264 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 266 */     if (par1IBlockAccess.func_147439_a(i, j, k) == TFCBlocks.vine) {
/*     */       
/* 268 */       if (TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && 
/* 269 */         (TFC_Climate.getCacheManager(getCurrentWorld()).getEVTLayerAt(i, k)).floatdata1 >= 0.8D && 
/* 270 */         TFC_Climate.getHeightAdjustedTemp(getCurrentWorld(), i, j, k) < 30.0F) {
/*     */         
/* 272 */         int color = 0;
/* 273 */         for (int n = -1; n <= 1; n++) {
/*     */           
/* 275 */           for (int var9 = -1; var9 <= 1; var9++) {
/*     */             
/* 277 */             color = TFC_Climate.getFoliageColor(getCurrentWorld(), i + n, j, k + var9);
/* 278 */             rgb = applyColor(color, rgb);
/*     */           } 
/*     */         } 
/* 281 */         return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */       } 
/* 283 */       if (TFC_Time.getSeasonAdjustedMonth(k) >= 11 || (TFC_Time.getSeasonAdjustedMonth(k) <= 0 && 
/* 284 */         (TFC_Climate.getCacheManager(getCurrentWorld()).getEVTLayerAt(i, k)).floatdata1 >= 0.8D && 
/* 285 */         TFC_Climate.getHeightAdjustedTemp(getCurrentWorld(), i, j, k) < 30.0F)) {
/*     */         
/* 287 */         for (int n = -1; n <= 1; n++) {
/*     */           
/* 289 */           for (int var9 = -1; var9 <= 1; var9++) {
/*     */             
/* 291 */             int color = TFC_Climate.getFoliageColor(getCurrentWorld(), i + n, j, k + var9);
/* 292 */             rgb = applyColor(color, rgb);
/*     */           } 
/*     */         } 
/* 295 */         return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */       } 
/* 297 */       if (TFC_Time.getSeasonAdjustedMonth(k) >= 9 && 
/* 298 */         (TFC_Climate.getCacheManager(getCurrentWorld()).getEVTLayerAt(i, k)).floatdata1 >= 0.8D && 
/* 299 */         TFC_Climate.getHeightAdjustedTemp(getCurrentWorld(), i, j, k) < 30.0F) {
/*     */         
/* 301 */         for (int n = -1; n <= 1; n++) {
/*     */           
/* 303 */           for (int var9 = -1; var9 <= 1; var9++) {
/*     */             
/* 305 */             int color = ColorizerFoliageTFC.getFoliageDead();
/* 306 */             rgb = applyColor(color, rgb);
/*     */           } 
/*     */         } 
/* 309 */         return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */       } 
/*     */ 
/*     */       
/* 313 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 315 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 317 */           int color = TFC_Climate.getFoliageColor(getCurrentWorld(), i + m, j, k + var9);
/* 318 */           rgb = applyColor(color, rgb);
/*     */         } 
/*     */       } 
/* 321 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/*     */     
/* 324 */     if (TFC_Time.getSeasonAdjustedMonth(k) >= 6 && (EnumTree.values()[meta]).isEvergreen) {
/*     */       
/* 326 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 328 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 330 */           int var10 = TFC_Climate.getFoliageColorEvergreen(getCurrentWorld(), i + m, j, k + var9);
/* 331 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 334 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 336 */     if (temperature <= 10.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && (meta == 4 || meta == 7 || meta == 5 || meta == 14)) {
/*     */       
/* 338 */       int color = 0;
/*     */       
/* 340 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 342 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 344 */           color = ColorizerFoliageTFC.getFoliageYellow();
/* 345 */           rgb = applyColor(color, rgb);
/*     */         } 
/*     */       } 
/* 348 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 350 */     if (temperature <= 10.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && meta == 6) {
/*     */       
/* 352 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 354 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 356 */           int var10 = ColorizerFoliageTFC.getFoliageRed();
/* 357 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 360 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 362 */     if (temperature <= 10.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && meta != 15) {
/*     */       
/* 364 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 366 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 368 */           int var10 = ColorizerFoliageTFC.getFoliageOrange();
/* 369 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 372 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 374 */     if (temperature <= 8.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && meta != 15) {
/*     */       
/* 376 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 378 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 380 */           int var10 = ColorizerFoliageTFC.getFoliageDead();
/* 381 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 384 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/*     */ 
/*     */     
/* 388 */     for (int var8 = -1; var8 <= 1; var8++) {
/*     */       
/* 390 */       for (int var9 = -1; var9 <= 1; var9++) {
/*     */         
/* 392 */         int var10 = TFC_Climate.getFoliageColor(getCurrentWorld(), i + var8, j, k + var9);
/* 393 */         rgb = applyColor(var10, rgb);
/*     */       } 
/*     */     } 
/* 396 */     return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
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
/*     */   private int[] applyColor(int c, int[] rgb) {
/* 408 */     rgb[0] = rgb[0] + ((c & 0xFF0000) >> 16);
/* 409 */     rgb[1] = rgb[1] + ((c & 0xFF00) >> 8);
/* 410 */     rgb[2] = rgb[2] + (c & 0xFF);
/* 411 */     return rgb;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getArmorRenderID(String name) {
/* 417 */     return RenderingRegistry.addNewArmourRendererPrefix(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerKeys() {
/* 423 */     KeyBindings.addKeyBinding(KeyBindingHandler.keyToolMode);
/* 424 */     KeyBindings.addIsRepeating(false);
/* 425 */     KeyBindings.addKeyBinding(KeyBindingHandler.keyLockTool);
/* 426 */     KeyBindings.addIsRepeating(false);
/*     */ 
/*     */     
/* 429 */     uploadKeyBindingsToGame();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerKeyBindingHandler() {
/* 435 */     FMLCommonHandler.instance().bus().register(new KeyBindingHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void uploadKeyBindingsToGame() {
/* 441 */     GameSettings settings = (Minecraft.func_71410_x()).field_71474_y;
/* 442 */     KeyBinding[] tfcKeyBindings = KeyBindings.gatherKeyBindings();
/* 443 */     KeyBinding[] allKeys = new KeyBinding[settings.field_74324_K.length + tfcKeyBindings.length];
/* 444 */     System.arraycopy(settings.field_74324_K, 0, allKeys, 0, settings.field_74324_K.length);
/* 445 */     System.arraycopy(tfcKeyBindings, 0, allKeys, settings.field_74324_K.length, tfcKeyBindings.length);
/* 446 */     settings.field_74324_K = allKeys;
/* 447 */     settings.func_74300_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerHandlers() {
/* 453 */     MinecraftForge.EVENT_BUS.register(new ChiselHighlightHandler());
/* 454 */     MinecraftForge.EVENT_BUS.register(new FarmlandHighlightHandler());
/* 455 */     MinecraftForge.EVENT_BUS.register(new PlankHighlightHandler());
/* 456 */     MinecraftForge.EVENT_BUS.register(new ArmourStandHighlightHandler());
/* 457 */     MinecraftForge.EVENT_BUS.register(new FamiliarityHighlightHandler());
/* 458 */     MinecraftForge.EVENT_BUS.register(new FogHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerPlayerRenderEventHandler() {
/* 465 */     PlayerRenderHandler pRHandler = new PlayerRenderHandler();
/* 466 */     MinecraftForge.EVENT_BUS.register(pRHandler);
/* 467 */     FMLCommonHandler.instance().bus().register(pRHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSoundHandler() {
/* 473 */     MinecraftForge.EVENT_BUS.register(new SoundHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerTickHandler() {
/* 479 */     super.registerTickHandler();
/* 480 */     FMLCommonHandler.instance().bus().register(new ClientTickHandler());
/* 481 */     FMLCommonHandler.instance().bus().register(new FMLClientEventHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerGuiHandler() {
/* 487 */     NetworkRegistry.INSTANCE.registerGuiHandler(TerraFirmaCraft.instance, (IGuiHandler)new GuiHandler());
/*     */     
/* 489 */     MinecraftForge.EVENT_BUS.register(new GuiHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrentLanguage() {
/* 495 */     return Minecraft.func_71410_x().func_135016_M().func_135041_c().func_135034_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getGraphicsLevel() {
/* 501 */     Minecraft.func_71410_x();
/* 502 */     return Minecraft.func_71375_t();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hideNEIItems() {
/* 508 */     if (Loader.isModLoaded("NotEnoughItems")) NEIIntegration.hideNEIItems(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ClientProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */