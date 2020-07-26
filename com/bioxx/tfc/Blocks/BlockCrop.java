/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TECrop;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCrop
/*     */   extends BlockContainer
/*     */ {
/*  37 */   private IIcon[] iconsCarrots = new IIcon[5];
/*  38 */   private IIcon[] iconsGarlic = new IIcon[5];
/*  39 */   private IIcon[] iconsCorn = new IIcon[6];
/*  40 */   private IIcon[] iconsCabbage = new IIcon[6];
/*  41 */   private IIcon[] iconsTomato = new IIcon[8];
/*  42 */   private IIcon[] iconsPepperRed = new IIcon[7];
/*  43 */   private IIcon[] iconsPepperYellow = new IIcon[7];
/*  44 */   private IIcon[] iconsWheat = new IIcon[8];
/*  45 */   private IIcon[] iconsRye = new IIcon[8];
/*  46 */   private IIcon[] iconsBarley = new IIcon[8];
/*  47 */   private IIcon[] iconsOat = new IIcon[8];
/*  48 */   private IIcon[] iconsRice = new IIcon[8];
/*  49 */   private IIcon[] iconsGreenbean = new IIcon[7];
/*  50 */   private IIcon[] iconsOnion = new IIcon[7];
/*  51 */   private IIcon[] iconsPotato = new IIcon[7];
/*  52 */   private IIcon[] iconsSoybean = new IIcon[7];
/*  53 */   private IIcon[] iconsSquash = new IIcon[7];
/*  54 */   private IIcon[] iconsJute = new IIcon[6];
/*  55 */   private IIcon[] iconsSugarcane = new IIcon[8];
/*     */   
/*     */   public IIcon iconInfest;
/*     */ 
/*     */   
/*     */   public BlockCrop() {
/*  61 */     super(Material.field_151585_k);
/*  62 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  68 */     return TFCBlocks.cropRenderId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister register) {
/*     */     int i;
/*  74 */     for (i = 1; i < 6; i++) {
/*     */       
/*  76 */       this.iconsCarrots[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Carrots (" + i + ")");
/*  77 */       this.iconsGarlic[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Garlic (" + i + ")");
/*     */     } 
/*  79 */     for (i = 1; i < 7; i++) {
/*     */       
/*  81 */       this.iconsCorn[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Corn (" + i + ")");
/*  82 */       this.iconsCabbage[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Cabbage (" + i + ")");
/*  83 */       this.iconsJute[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Jute (" + i + ")");
/*     */     } 
/*  85 */     for (i = 1; i < 8; i++) {
/*     */       
/*  87 */       this.iconsPepperRed[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/PepperRed (" + i + ")");
/*  88 */       this.iconsPepperYellow[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/PepperYellow (" + i + ")");
/*  89 */       this.iconsGreenbean[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Greenbean (" + i + ")");
/*  90 */       this.iconsOnion[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Onion (" + i + ")");
/*  91 */       this.iconsPotato[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Potato (" + i + ")");
/*  92 */       this.iconsSquash[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Squash (" + i + ")");
/*  93 */       this.iconsSoybean[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Soybean (" + i + ")");
/*     */     } 
/*  95 */     for (i = 1; i < 9; i++) {
/*     */       
/*  97 */       this.iconsTomato[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Tomato (" + i + ")");
/*  98 */       this.iconsWheat[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Wheat (" + i + ")");
/*  99 */       this.iconsRye[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Rye (" + i + ")");
/* 100 */       this.iconsBarley[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Barley (" + i + ")");
/* 101 */       this.iconsOat[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Oat (" + i + ")");
/* 102 */       this.iconsRice[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Rice (" + i + ")");
/* 103 */       this.iconsSugarcane[i - 1] = register.func_94245_a("terrafirmacraft:plants/crops/Sugarcane (" + i + ")");
/*     */     } 
/*     */     
/* 106 */     this.iconInfest = register.func_94245_a("terrafirmacraft:bugs");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int meta) {
/* 113 */     TECrop te = (TECrop)access.func_147438_o(x, y, z);
/* 114 */     CropIndex crop = CropManager.getInstance().getCropFromId(te.cropId);
/*     */     
/* 116 */     int stage = (int)Math.floor(te.growth);
/* 117 */     if (stage > crop.numGrowthStages) {
/* 118 */       stage = crop.numGrowthStages;
/*     */     }
/* 120 */     switch (te.cropId) {
/*     */       
/*     */       case 0:
/* 123 */         return this.iconsWheat[stage];
/*     */       case 1:
/* 125 */         return this.iconsCorn[stage];
/*     */       case 2:
/* 127 */         return this.iconsTomato[stage];
/*     */       case 3:
/* 129 */         return this.iconsBarley[stage];
/*     */       case 4:
/* 131 */         return this.iconsRye[stage];
/*     */       case 5:
/* 133 */         return this.iconsOat[stage];
/*     */       case 6:
/* 135 */         return this.iconsRice[stage];
/*     */       case 7:
/* 137 */         return this.iconsPotato[stage];
/*     */       case 8:
/* 139 */         return this.iconsOnion[stage];
/*     */       case 9:
/* 141 */         return this.iconsCabbage[stage];
/*     */       case 10:
/* 143 */         return this.iconsGarlic[stage];
/*     */       case 11:
/* 145 */         return this.iconsCarrots[stage];
/*     */       case 12:
/* 147 */         return this.iconsPepperYellow[stage];
/*     */       case 13:
/* 149 */         return this.iconsPepperRed[stage];
/*     */       case 14:
/* 151 */         return this.iconsSoybean[stage];
/*     */       case 15:
/* 153 */         return this.iconsGreenbean[stage];
/*     */       case 16:
/* 155 */         return this.iconsSquash[stage];
/*     */       case 17:
/* 157 */         return this.iconsJute[stage];
/*     */       case 18:
/* 159 */         return this.iconsSugarcane[stage];
/*     */     } 
/* 161 */     return this.iconsCorn[6];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/* 167 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/* 173 */     TECrop te = (TECrop)world.func_147438_o(x, y, z);
/* 174 */     CropIndex crop = CropManager.getInstance().getCropFromId(te.cropId);
/*     */     
/* 176 */     if (TFCOptions.enableDebugMode) {
/*     */       
/* 178 */       TerraFirmaCraft.LOG.info("Crop ID: " + te.cropId);
/* 179 */       TerraFirmaCraft.LOG.info("Growth: " + te.growth);
/* 180 */       TerraFirmaCraft.LOG.info("Est Growth: " + te.getEstimatedGrowth(crop));
/*     */     } 
/*     */     
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149681_a(World world, int i, int j, int k, int l, EntityPlayer player) {
/* 189 */     TECrop te = (TECrop)world.func_147438_o(i, j, k);
/* 190 */     if (!world.field_72995_K) {
/*     */       
/* 192 */       ItemStack itemstack = player.field_71071_by.func_70448_g();
/* 193 */       int[] equipIDs = OreDictionary.getOreIDs(itemstack);
/*     */       
/* 195 */       for (int id : equipIDs) {
/*     */         
/* 197 */         String name = OreDictionary.getOreName(id);
/* 198 */         if (name.startsWith("itemScythe")) {
/*     */           
/* 200 */           for (int x = -1; x < 2; x++) {
/*     */             
/* 202 */             for (int z = -1; z < 2; z++) {
/*     */               
/* 204 */               if (world.func_147439_a(i + x, j, k + z) == this && player.field_71071_by.func_70301_a(player.field_71071_by.field_70461_c) != null) {
/*     */                 
/* 206 */                 player.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 207 */                 TECrop teX = (TECrop)world.func_147438_o(i + x, j, k + z);
/* 208 */                 teX.onHarvest(world, player, true);
/*     */                 
/* 210 */                 world.func_147468_f(i + x, j, k + z);
/*     */                 
/* 212 */                 itemstack.func_77972_a(1, (EntityLivingBase)player);
/* 213 */                 if (itemstack.field_77994_a == 0) {
/* 214 */                   player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     te.onHarvest(world, player, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 235 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 241 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), y + 0.3D, (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 247 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 259 */     super.func_149695_a(world, x, y, z, b);
/*     */     
/* 261 */     if (!func_149718_j(world, x, y, z)) {
/* 262 */       world.func_147468_f(x, y, z);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 268 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/* 274 */     return (TFC_Core.isFarmland(world.func_147439_a(x, y - 1, z)) || TFC_Core.isSoil(world.func_147439_a(x, y - 1, z)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 280 */     return (TileEntity)new TECrop();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 287 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 300 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockCrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */