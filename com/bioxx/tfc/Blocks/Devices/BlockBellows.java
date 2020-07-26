/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TileEntities.TEBellows;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockBellows
/*     */   extends BlockTerraContainer
/*     */ {
/*  22 */   public static IIcon[] sides = new IIcon[4];
/*     */   
/*     */   public static IIcon bellowsFront;
/*     */   public static IIcon bellowsBack;
/*     */   
/*     */   public static int getDirectionFromMetadata(int i) {
/*  28 */     return i & 0x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockBellows(Material material) {
/*  33 */     super(material);
/*  34 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
/*  40 */     super.func_149727_a(world, i, j, k, entityplayer, par6, par7, par8, par9);
/*  41 */     TEBellows teb = null;
/*  42 */     TileEntity te = world.func_147438_o(i, j, k);
/*  43 */     if (!world.field_72995_K && te != null && te instanceof TEBellows) {
/*     */       
/*  45 */       teb = (TEBellows)te;
/*  46 */       if (!teb.shouldBlow) {
/*     */         
/*  48 */         teb.shouldBlow = true;
/*  49 */         world.func_147471_g(i, j, k);
/*     */         
/*  51 */         world.func_72908_a(i, j, k, "terrafirmacraft:bellows.blow.air", 0.4F, 1.0F);
/*     */       } 
/*     */     } 
/*  54 */     return true;
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
/*     */   public IIcon func_149691_a(int i, int j) {
/*  66 */     if (i == 0) {
/*     */       
/*  68 */       if (j == 0) return sides[0]; 
/*  69 */       if (j == 1) return sides[1]; 
/*  70 */       if (j == 2) return sides[3]; 
/*  71 */       if (j == 3) return sides[2];
/*     */     
/*  73 */     } else if (i == 1) {
/*     */       
/*  75 */       if (j == 0) return sides[0]; 
/*  76 */       if (j == 1) return sides[1]; 
/*  77 */       if (j == 2) return sides[3]; 
/*  78 */       if (j == 3) return sides[2];
/*     */     
/*  80 */     } else if (i == 2) {
/*     */       
/*  82 */       if (j == 0) return bellowsBack; 
/*  83 */       if (j == 1) return sides[2]; 
/*  84 */       if (j == 2) return bellowsBack; 
/*  85 */       if (j == 3) return sides[1];
/*     */     
/*  87 */     } else if (i == 3) {
/*     */       
/*  89 */       if (j == 0) return bellowsBack; 
/*  90 */       if (j == 1) return sides[1]; 
/*  91 */       if (j == 2) return bellowsBack; 
/*  92 */       if (j == 3) return sides[2];
/*     */     
/*  94 */     } else if (i == 4) {
/*     */       
/*  96 */       if (j == 0) return sides[2]; 
/*  97 */       if (j == 1) return bellowsBack; 
/*  98 */       if (j == 2) return sides[1]; 
/*  99 */       if (j == 3) return bellowsBack;
/*     */     
/* 101 */     } else if (i == 5) {
/*     */       
/* 103 */       if (j == 0) return sides[1]; 
/* 104 */       if (j == 1) return bellowsBack; 
/* 105 */       if (j == 2) return sides[2]; 
/* 106 */       if (j == 3) return bellowsBack;
/*     */     
/*     */     } else {
/*     */       
/* 110 */       return sides[1];
/*     */     } 
/* 112 */     return sides[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 118 */     sides[0] = registerer.func_94245_a("terrafirmacraft:devices/Bellows82");
/* 119 */     sides[1] = registerer.func_94245_a("terrafirmacraft:devices/Bellows83");
/* 120 */     sides[2] = registerer.func_94245_a("terrafirmacraft:devices/Bellows84");
/* 121 */     sides[3] = registerer.func_94245_a("terrafirmacraft:devices/Bellows85");
/* 122 */     bellowsFront = registerer.func_94245_a("terrafirmacraft:devices/Bellows Front");
/* 123 */     bellowsBack = registerer.func_94245_a("terrafirmacraft:devices/Bellows Back");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 129 */     return TFCBlocks.bellowsRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
/* 146 */     super.func_149689_a(world, i, j, k, entityliving, is);
/* 147 */     int l = MathHelper.func_76128_c((entityliving.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 148 */     world.func_72921_c(i, j, k, l, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 160 */     return (TileEntity)new TEBellows();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */