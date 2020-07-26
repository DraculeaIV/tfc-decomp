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
/*     */ import com.bioxx.tfc.Render.Models.ModelOcelotTFC;
/*     */ import com.bioxx.tfc.Render.Models.ModelPigTFC;
/*     */ import com.bioxx.tfc.Render.Models.ModelWolfTFC;
/*     */ import com.bioxx.tfc.Render.RenderDeer;
/*     */ import com.bioxx.tfc.Render.RenderPigTFC;
/*     */ import com.bioxx.tfc.Render.RenderSkeletonTFC;
/*     */ import com.bioxx.tfc.Render.TESR.TESRQuern;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.Util.KeyBindings;
/*     */ import cpw.mods.fml.client.registry.ClientRegistry;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.Loader;
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
/*  51 */     TFCFluids.LAVA.setIcons(TFCBlocks.lava.func_149691_a(0, 0), TFCBlocks.lava.func_149691_a(2, 0));
/*  52 */     TFCFluids.SALTWATER.setIcons(TFCBlocks.saltWater.func_149691_a(0, 0), TFCBlocks.saltWater.func_149691_a(2, 0));
/*  53 */     TFCFluids.FRESHWATER.setIcons(TFCBlocks.freshWater.func_149691_a(0, 0), TFCBlocks.freshWater.func_149691_a(2, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerRenderInformation() {
/*  60 */     (Minecraft.func_71410_x()).field_71460_t = (EntityRenderer)new EntityRendererTFC(Minecraft.func_71410_x(), Minecraft.func_71410_x().func_110442_L());
/*  61 */     IReloadableResourceManager iRRM = (IReloadableResourceManager)Minecraft.func_71410_x().func_110442_L();
/*  62 */     iRRM.func_110542_a((IResourceManagerReloadListener)new GrassColorReloadListener());
/*  63 */     iRRM.func_110542_a((IResourceManagerReloadListener)new FoliageColorReloadListener());
/*  64 */     iRRM.func_110542_a((IResourceManagerReloadListener)(Minecraft.func_71410_x()).field_71460_t);
/*     */     
/*  66 */     RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, (Render)new RenderTerraJavelin());
/*  67 */     RenderingRegistry.registerEntityRenderingHandler(EntitySquidTFC.class, (Render)new RenderSquidTFC((ModelBase)new ModelSquidTFC(), 0.7F));
/*  68 */     RenderingRegistry.registerEntityRenderingHandler(EntityCowTFC.class, (Render)new RenderCowTFC((ModelBase)new ModelCowTFC(), 0.7F));
/*  69 */     RenderingRegistry.registerEntityRenderingHandler(EntitySheepTFC.class, (Render)new RenderSheepTFC((ModelBase)new ModelSheep2TFC(), (ModelBase)new ModelSheep1TFC(), 0.4F));
/*  70 */     RenderingRegistry.registerEntityRenderingHandler(EntityOcelotTFC.class, (Render)new RenderOcelotTFC((ModelBase)new ModelOcelotTFC(), 0.4F));
/*  71 */     RenderingRegistry.registerEntityRenderingHandler(EntityWolfTFC.class, (Render)new RenderWolfTFC((ModelBase)new ModelWolfTFC(), (ModelBase)new ModelWolfTFC(), 0.5F));
/*  72 */     RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, (Render)new RenderBear((ModelBase)new ModelBear(), 0.9F));
/*  73 */     RenderingRegistry.registerEntityRenderingHandler(EntityPolarBear.class, (Render)new RenderPolarBear((ModelBase)new ModelBear(), 0.9F));
/*  74 */     RenderingRegistry.registerEntityRenderingHandler(EntityPheasantTFC.class, (Render)new RenderPheasantTFC((ModelBase)new ModelPheasant(), 0.3F));
/*  75 */     RenderingRegistry.registerEntityRenderingHandler(EntityChickenTFC.class, (Render)new RenderChickenTFC((ModelBase)new ModelChickenTFC(), 0.3F));
/*  76 */     RenderingRegistry.registerEntityRenderingHandler(EntityPigTFC.class, (Render)new RenderPigTFC((ModelBase)new ModelPigTFC(), (ModelBase)new ModelPigTFC(0.5F), 0.7F));
/*  77 */     RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, (Render)new RenderDeer((ModelBase)new ModelDeer(), 0.9F));
/*  78 */     RenderingRegistry.registerEntityRenderingHandler(EntityHorseTFC.class, (Render)new RenderHorseTFC((ModelBase)new ModelHorseTFC(), 0.9F));
/*  79 */     RenderingRegistry.registerEntityRenderingHandler(EntityCustomMinecart.class, (Render)new RenderMinecart());
/*  80 */     RenderingRegistry.registerEntityRenderingHandler(EntityStand.class, (Render)new RenderEntityStand());
/*  81 */     RenderingRegistry.registerEntityRenderingHandler(EntityFishTFC.class, (Render)new RenderFishTFC((ModelBase)new ModelBass(), 0.7F));
/*  82 */     RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTFC.class, (Render)new RenderSkeletonTFC());
/*  83 */     RenderingRegistry.registerEntityRenderingHandler(EntityZombieTFC.class, (Render)new RenderZombie());
/*  84 */     RenderingRegistry.registerEntityRenderingHandler(EntitySpiderTFC.class, (Render)new RenderSpider());
/*  85 */     RenderingRegistry.registerEntityRenderingHandler(EntitySlimeTFC.class, (Render)new RenderSlime((ModelBase)new ModelSlime(16), (ModelBase)new ModelSlime(0), 0.25F));
/*  86 */     RenderingRegistry.registerEntityRenderingHandler(EntitySilverfishTFC.class, (Render)new RenderSilverfish());
/*  87 */     RenderingRegistry.registerEntityRenderingHandler(EntityGhastTFC.class, (Render)new RenderGhast());
/*  88 */     RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderTFC.class, (Render)new RenderSpider());
/*  89 */     RenderingRegistry.registerEntityRenderingHandler(EntityBlazeTFC.class, (Render)new RenderBlaze());
/*  90 */     RenderingRegistry.registerEntityRenderingHandler(EntityEndermanTFC.class, (Render)new RenderEnderman());
/*  91 */     RenderingRegistry.registerEntityRenderingHandler(EntityPigZombieTFC.class, (Render)new RenderZombie());
/*  92 */     RenderingRegistry.registerEntityRenderingHandler(EntityIronGolemTFC.class, (Render)new RenderIronGolem());
/*     */     
/*  94 */     RenderingRegistry.registerEntityRenderingHandler(EntityProjectileTFC.class, (Render)new RenderArrow());
/*  95 */     RenderingRegistry.registerEntityRenderingHandler(EntityFishHookTFC.class, (Render)new RenderFish());
/*  96 */     RenderingRegistry.registerEntityRenderingHandler(EntityBarrel.class, (Render)new RenderBarrelEntity());
/*  97 */     RenderingRegistry.registerEntityRenderingHandler(EntityFallingBlockTFC.class, (Render)new RenderFallingBlock());
/*     */     
/*  99 */     RenderingRegistry.registerBlockHandler(TFCBlocks.chestRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderChest());
/* 100 */     RenderingRegistry.registerBlockHandler(TFCBlocks.clayGrassRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 101 */     RenderingRegistry.registerBlockHandler(TFCBlocks.peatGrassRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 102 */     RenderingRegistry.registerBlockHandler(TFCBlocks.sulfurRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 103 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodSupportRenderIdH = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSupportBeam());
/* 104 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodSupportRenderIdV = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSupportBeam());
/* 105 */     RenderingRegistry.registerBlockHandler(TFCBlocks.grassRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 106 */     RenderingRegistry.registerBlockHandler(TFCBlocks.oreRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderOre());
/* 107 */     RenderingRegistry.registerBlockHandler(TFCBlocks.moltenRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 108 */     RenderingRegistry.registerBlockHandler(TFCBlocks.looseRockRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 109 */     RenderingRegistry.registerBlockHandler(TFCBlocks.firepitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 110 */     RenderingRegistry.registerBlockHandler(TFCBlocks.anvilRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderAnvil());
/* 111 */     RenderingRegistry.registerBlockHandler(TFCBlocks.bellowsRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderBellows());
/* 112 */     RenderingRegistry.registerBlockHandler(TFCBlocks.forgeRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 113 */     RenderingRegistry.registerBlockHandler(TFCBlocks.sluiceRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 114 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodFruitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 115 */     RenderingRegistry.registerBlockHandler(TFCBlocks.leavesFruitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 116 */     RenderingRegistry.registerBlockHandler(TFCBlocks.stairRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 117 */     RenderingRegistry.registerBlockHandler(TFCBlocks.slabRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 118 */     RenderingRegistry.registerBlockHandler(TFCBlocks.cropRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 119 */     RenderingRegistry.registerBlockHandler(TFCBlocks.cookingPitRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 120 */     RenderingRegistry.registerBlockHandler(TFCBlocks.leavesRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 121 */     RenderingRegistry.registerBlockHandler(TFCBlocks.detailedRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/* 122 */     RenderingRegistry.registerBlockHandler(TFCBlocks.wallRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderWall());
/* 123 */     RenderingRegistry.registerBlockHandler(TFCBlocks.fenceRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderFence());
/* 124 */     RenderingRegistry.registerBlockHandler(TFCBlocks.fenceGateRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderFenceGate());
/* 125 */     RenderingRegistry.registerBlockHandler(TFCBlocks.toolRackRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderToolRack());
/*     */     
/* 127 */     RenderingRegistry.registerBlockHandler(TFCBlocks.quernRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new TESRQuern());
/* 128 */     RenderingRegistry.registerBlockHandler(TFCBlocks.woodConstructRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderWoodConstruct());
/* 129 */     RenderingRegistry.registerBlockHandler(TFCBlocks.barrelRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderBarrel());
/* 130 */     RenderingRegistry.registerBlockHandler(TFCBlocks.loomRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderLoom());
/* 131 */     RenderingRegistry.registerBlockHandler(TFCBlocks.standRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderStand());
/* 132 */     RenderingRegistry.registerBlockHandler(TFCBlocks.nestBoxRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderNestBox());
/* 133 */     RenderingRegistry.registerBlockHandler(TFCBlocks.potteryRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderPottery());
/* 134 */     RenderingRegistry.registerBlockHandler(TFCBlocks.tuyereRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderTuyere());
/* 135 */     RenderingRegistry.registerBlockHandler(TFCBlocks.crucibleRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderCrucible());
/* 136 */     RenderingRegistry.registerBlockHandler(TFCBlocks.waterPlantRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new BlockRenderHandler());
/*     */     
/* 138 */     RenderingRegistry.registerBlockHandler(TFCBlocks.bloomeryRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderBloomery());
/* 139 */     RenderingRegistry.registerBlockHandler(TFCBlocks.metalsheetRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderMetalSheet());
/* 140 */     RenderingRegistry.registerBlockHandler(TFCBlocks.leatherRackRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderLeatherRack());
/* 141 */     RenderingRegistry.registerBlockHandler(TFCBlocks.grillRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderGrill());
/* 142 */     RenderingRegistry.registerBlockHandler(TFCBlocks.metalTrapDoorRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderMetalTrapDoor());
/* 143 */     RenderingRegistry.registerBlockHandler(TFCBlocks.vesselRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderVessel());
/* 144 */     RenderingRegistry.registerBlockHandler(TFCBlocks.torchRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderTorch());
/* 145 */     RenderingRegistry.registerBlockHandler(TFCBlocks.smokeRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSmoke());
/* 146 */     RenderingRegistry.registerBlockHandler(TFCBlocks.smokeRackRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderSmokeRack());
/* 147 */     RenderingRegistry.registerBlockHandler(TFCBlocks.oilLampRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderOilLamp());
/* 148 */     RenderingRegistry.registerBlockHandler(TFCBlocks.hopperRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderHopper());
/* 149 */     RenderingRegistry.registerBlockHandler(TFCBlocks.flowerPotRenderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)new RenderFlowerPot());
/*     */     
/* 151 */     MinecraftForge.EVENT_BUS.register(new RenderOverlayHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBiomeEventHandler() {
/* 159 */     MinecraftForge.EVENT_BUS.register(new BiomeEventHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setupGuiIngameForge() {
/* 166 */     GuiIngameForge.renderHealth = false;
/* 167 */     GuiIngameForge.renderArmor = false;
/* 168 */     GuiIngameForge.renderExperiance = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerTileEntities(boolean b) {
/* 175 */     super.registerTileEntities(false);
/* 176 */     ClientRegistry.registerTileEntity(TEChest.class, "chest", (TileEntitySpecialRenderer)new TESRChest());
/* 177 */     ClientRegistry.registerTileEntity(TEIngotPile.class, "ingotPile", (TileEntitySpecialRenderer)new TESRIngotPile());
/* 178 */     ClientRegistry.registerTileEntity(TEFirepit.class, "TerraFirepit", (TileEntitySpecialRenderer)new TESRFirepit());
/* 179 */     ClientRegistry.registerTileEntity(TELoom.class, "Loom", (TileEntitySpecialRenderer)new TESRLoom());
/*     */     
/* 181 */     ClientRegistry.registerTileEntity(TEPottery.class, "Pottery", (TileEntitySpecialRenderer)new TESRPottery());
/* 182 */     ClientRegistry.registerTileEntity(TEFoodPrep.class, "FoodPrep", (TileEntitySpecialRenderer)new TESRFoodPrep());
/* 183 */     ClientRegistry.registerTileEntity(TEBellows.class, "Bellows", (TileEntitySpecialRenderer)new TESRBellows());
/* 184 */     ClientRegistry.registerTileEntity(TEToolRack.class, "ToolRack", (TileEntitySpecialRenderer)new TESRToolrack());
/* 185 */     ClientRegistry.registerTileEntity(TEAnvil.class, "TerraAnvil", (TileEntitySpecialRenderer)new TESRAnvil());
/* 186 */     ClientRegistry.registerTileEntity(TEWorldItem.class, "worldItem", (TileEntitySpecialRenderer)new TESRWorldItem());
/* 187 */     ClientRegistry.registerTileEntity(TEQuern.class, "Quern", (TileEntitySpecialRenderer)new TESRQuern());
/* 188 */     ClientRegistry.registerTileEntity(TEGrill.class, "GrillTESR", (TileEntitySpecialRenderer)new TESRGrill());
/* 189 */     ClientRegistry.registerTileEntity(TESmokeRack.class, "SmokeRackTESR", (TileEntitySpecialRenderer)new TESRSmokeRack());
/* 190 */     ClientRegistry.registerTileEntity(TEHopper.class, "HopperTESR", (TileEntitySpecialRenderer)new TESRHopper());
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
/* 204 */     return (World)(Minecraft.func_71410_x()).field_71441_e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRemote() {
/* 210 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int waterColorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 216 */     return 3493173;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int grassColorMultiplier(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 222 */     int var5 = 0;
/* 223 */     int var6 = 0;
/* 224 */     int var7 = 0;
/*     */     
/* 226 */     for (int z = -1; z <= 1; z++) {
/*     */       
/* 228 */       for (int x = -1; x <= 1; x++) {
/*     */         
/* 230 */         int var10 = TFC_Climate.getGrassColor(getCurrentWorld(), i + x, j, k + z);
/* 231 */         var5 += (var10 & 0xFF0000) >> 16;
/* 232 */         var6 += (var10 & 0xFF00) >> 8;
/* 233 */         var7 += var10 & 0xFF;
/*     */       } 
/*     */     } 
/* 236 */     return (var5 / 9 & 0xFF) << 16 | (var6 / 9 & 0xFF) << 8 | var7 / 9 & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int foliageColorMultiplier(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 245 */     int[] rgb = { 0, 0, 0 };
/* 246 */     float temperature = TFC_Climate.getHeightAdjustedTempSpecificDay(getCurrentWorld(), TFC_Time.getDayOfYear(), i, j, k);
/*     */ 
/*     */     
/* 249 */     int meta = par1IBlockAccess.func_72805_g(i, j, k);
/* 250 */     if (par1IBlockAccess.func_147439_a(i, j, k) == TFCBlocks.fruitTreeLeaves) {
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
/* 261 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 263 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 265 */           int var10 = TFC_Climate.getFoliageColor(getCurrentWorld(), i + m, j, k + var9);
/* 266 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 269 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 271 */     if (par1IBlockAccess.func_147439_a(i, j, k) == TFCBlocks.vine) {
/*     */       
/* 273 */       if (TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && 
/* 274 */         (TFC_Climate.getCacheManager(getCurrentWorld()).getEVTLayerAt(i, k)).floatdata1 >= 0.8D && 
/* 275 */         TFC_Climate.getHeightAdjustedTemp(getCurrentWorld(), i, j, k) < 30.0F) {
/*     */         
/* 277 */         int color = 0;
/* 278 */         for (int n = -1; n <= 1; n++) {
/*     */           
/* 280 */           for (int var9 = -1; var9 <= 1; var9++) {
/*     */             
/* 282 */             color = TFC_Climate.getFoliageColor(getCurrentWorld(), i + n, j, k + var9);
/* 283 */             rgb = applyColor(color, rgb);
/*     */           } 
/*     */         } 
/* 286 */         return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */       } 
/* 288 */       if (TFC_Time.getSeasonAdjustedMonth(k) >= 11 || (TFC_Time.getSeasonAdjustedMonth(k) <= 0 && 
/* 289 */         (TFC_Climate.getCacheManager(getCurrentWorld()).getEVTLayerAt(i, k)).floatdata1 >= 0.8D && 
/* 290 */         TFC_Climate.getHeightAdjustedTemp(getCurrentWorld(), i, j, k) < 30.0F)) {
/*     */         
/* 292 */         for (int n = -1; n <= 1; n++) {
/*     */           
/* 294 */           for (int var9 = -1; var9 <= 1; var9++) {
/*     */             
/* 296 */             int color = TFC_Climate.getFoliageColor(getCurrentWorld(), i + n, j, k + var9);
/* 297 */             rgb = applyColor(color, rgb);
/*     */           } 
/*     */         } 
/* 300 */         return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */       } 
/* 302 */       if (TFC_Time.getSeasonAdjustedMonth(k) >= 9 && 
/* 303 */         (TFC_Climate.getCacheManager(getCurrentWorld()).getEVTLayerAt(i, k)).floatdata1 >= 0.8D && 
/* 304 */         TFC_Climate.getHeightAdjustedTemp(getCurrentWorld(), i, j, k) < 30.0F) {
/*     */         
/* 306 */         for (int n = -1; n <= 1; n++) {
/*     */           
/* 308 */           for (int var9 = -1; var9 <= 1; var9++) {
/*     */             
/* 310 */             int color = ColorizerFoliageTFC.getFoliageDead();
/* 311 */             rgb = applyColor(color, rgb);
/*     */           } 
/*     */         } 
/* 314 */         return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */       } 
/*     */ 
/*     */       
/* 318 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 320 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 322 */           int color = TFC_Climate.getFoliageColor(getCurrentWorld(), i + m, j, k + var9);
/* 323 */           rgb = applyColor(color, rgb);
/*     */         } 
/*     */       } 
/* 326 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/*     */     
/* 329 */     if (TFC_Time.getSeasonAdjustedMonth(k) >= 6 && (EnumTree.values()[meta]).isEvergreen) {
/*     */       
/* 331 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 333 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 335 */           int var10 = TFC_Climate.getFoliageColorEvergreen(getCurrentWorld(), i + m, j, k + var9);
/* 336 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 339 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 341 */     if (temperature <= 10.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && (meta == 4 || meta == 7 || meta == 5 || meta == 14)) {
/*     */       
/* 343 */       int color = 0;
/*     */       
/* 345 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 347 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 349 */           color = ColorizerFoliageTFC.getFoliageYellow();
/* 350 */           rgb = applyColor(color, rgb);
/*     */         } 
/*     */       } 
/* 353 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 355 */     if (temperature <= 10.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && meta == 6) {
/*     */       
/* 357 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 359 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 361 */           int var10 = ColorizerFoliageTFC.getFoliageRed();
/* 362 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 365 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 367 */     if (temperature <= 10.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && TFC_Time.getSeasonAdjustedMonth(k) < 9 && meta != 15) {
/*     */       
/* 369 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 371 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 373 */           int var10 = ColorizerFoliageTFC.getFoliageOrange();
/* 374 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 377 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/* 379 */     if (temperature <= 8.0F && TFC_Time.getSeasonAdjustedMonth(k) >= 6 && meta != 15) {
/*     */       
/* 381 */       for (int m = -1; m <= 1; m++) {
/*     */         
/* 383 */         for (int var9 = -1; var9 <= 1; var9++) {
/*     */           
/* 385 */           int var10 = ColorizerFoliageTFC.getFoliageDead();
/* 386 */           rgb = applyColor(var10, rgb);
/*     */         } 
/*     */       } 
/* 389 */       return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
/*     */     } 
/*     */ 
/*     */     
/* 393 */     for (int var8 = -1; var8 <= 1; var8++) {
/*     */       
/* 395 */       for (int var9 = -1; var9 <= 1; var9++) {
/*     */         
/* 397 */         int var10 = TFC_Climate.getFoliageColor(getCurrentWorld(), i + var8, j, k + var9);
/* 398 */         rgb = applyColor(var10, rgb);
/*     */       } 
/*     */     } 
/* 401 */     return (rgb[0] / 9 & 0xFF) << 16 | (rgb[1] / 9 & 0xFF) << 8 | rgb[2] / 9 & 0xFF;
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
/* 413 */     rgb[0] = rgb[0] + ((c & 0xFF0000) >> 16);
/* 414 */     rgb[1] = rgb[1] + ((c & 0xFF00) >> 8);
/* 415 */     rgb[2] = rgb[2] + (c & 0xFF);
/* 416 */     return rgb;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getArmorRenderID(String name) {
/* 422 */     return RenderingRegistry.addNewArmourRendererPrefix(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerKeys() {
/* 428 */     KeyBindings.addKeyBinding(KeyBindingHandler.keyToolMode);
/* 429 */     KeyBindings.addIsRepeating(false);
/* 430 */     KeyBindings.addKeyBinding(KeyBindingHandler.keyLockTool);
/* 431 */     KeyBindings.addIsRepeating(false);
/*     */ 
/*     */     
/* 434 */     uploadKeyBindingsToGame();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerKeyBindingHandler() {
/* 440 */     FMLCommonHandler.instance().bus().register(new KeyBindingHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void uploadKeyBindingsToGame() {
/* 446 */     GameSettings settings = (Minecraft.func_71410_x()).field_71474_y;
/* 447 */     KeyBinding[] tfcKeyBindings = KeyBindings.gatherKeyBindings();
/* 448 */     KeyBinding[] allKeys = new KeyBinding[settings.field_74324_K.length + tfcKeyBindings.length];
/* 449 */     System.arraycopy(settings.field_74324_K, 0, allKeys, 0, settings.field_74324_K.length);
/* 450 */     System.arraycopy(tfcKeyBindings, 0, allKeys, settings.field_74324_K.length, tfcKeyBindings.length);
/* 451 */     settings.field_74324_K = allKeys;
/* 452 */     settings.func_74300_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerHandlers() {
/* 458 */     MinecraftForge.EVENT_BUS.register(new ChiselHighlightHandler());
/* 459 */     MinecraftForge.EVENT_BUS.register(new FarmlandHighlightHandler());
/* 460 */     MinecraftForge.EVENT_BUS.register(new PlankHighlightHandler());
/* 461 */     MinecraftForge.EVENT_BUS.register(new ArmourStandHighlightHandler());
/* 462 */     MinecraftForge.EVENT_BUS.register(new FamiliarityHighlightHandler());
/* 463 */     MinecraftForge.EVENT_BUS.register(new FogHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerPlayerRenderEventHandler() {
/* 470 */     PlayerRenderHandler pRHandler = new PlayerRenderHandler();
/* 471 */     MinecraftForge.EVENT_BUS.register(pRHandler);
/* 472 */     FMLCommonHandler.instance().bus().register(pRHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSoundHandler() {
/* 478 */     MinecraftForge.EVENT_BUS.register(new SoundHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerTickHandler() {
/* 484 */     super.registerTickHandler();
/* 485 */     FMLCommonHandler.instance().bus().register(new ClientTickHandler());
/* 486 */     FMLCommonHandler.instance().bus().register(new FMLClientEventHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerGuiHandler() {
/* 492 */     NetworkRegistry.INSTANCE.registerGuiHandler(TerraFirmaCraft.instance, (IGuiHandler)new GuiHandler());
/*     */     
/* 494 */     MinecraftForge.EVENT_BUS.register(new GuiHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrentLanguage() {
/* 500 */     return Minecraft.func_71410_x().func_135016_M().func_135041_c().func_135034_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getGraphicsLevel() {
/* 506 */     Minecraft.func_71410_x();
/* 507 */     return Minecraft.func_71375_t();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hideNEIItems() {
/* 513 */     if (Loader.isModLoaded("NotEnoughItems")) NEIIntegration.hideNEIItems(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ClientProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */