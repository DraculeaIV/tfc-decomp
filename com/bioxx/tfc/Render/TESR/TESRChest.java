/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockChestTFC;
/*     */ import com.bioxx.tfc.TileEntities.TEChest;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.model.ModelChest;
/*     */ import net.minecraft.client.model.ModelLargeChest;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TESRChest
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private static ResourceLocation[] texNormal;
/*     */   private static ResourceLocation[] texNormalDouble;
/*  25 */   private ModelChest chestModel = new ModelChest();
/*     */ 
/*     */   
/*  28 */   private ModelChest largeChestModel = (ModelChest)new ModelLargeChest();
/*     */ 
/*     */   
/*     */   public TESRChest() {
/*  32 */     if (texNormal == null) {
/*     */       
/*  34 */       texNormal = new ResourceLocation[Global.WOOD_ALL.length];
/*  35 */       texNormalDouble = new ResourceLocation[Global.WOOD_ALL.length];
/*  36 */       for (int i = 0; i < Global.WOOD_ALL.length; i++) {
/*     */         
/*  38 */         texNormal[i] = new ResourceLocation("terrafirmacraft:textures/models/chest/normal_" + Global.WOOD_ALL[i] + ".png");
/*  39 */         texNormalDouble[i] = new ResourceLocation("terrafirmacraft:textures/models/chest/normal_double_" + Global.WOOD_ALL[i] + ".png");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTileEntityChestAt(TEChest te, double par2, double par4, double par6, float par8) {
/*     */     int i;
/*  51 */     if (!te.func_145830_o()) {
/*     */       
/*  53 */       i = 0;
/*     */     }
/*     */     else {
/*     */       
/*  57 */       Block block = te.func_145838_q();
/*  58 */       i = te.func_145832_p();
/*     */       
/*  60 */       if (block instanceof BlockChestTFC && i == 0) {
/*     */ 
/*     */         
/*     */         try {
/*  64 */           ((BlockChestTFC)block).unifyAdjacentChests(te.func_145831_w(), te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*     */         }
/*  66 */         catch (ClassCastException e) {
/*     */           
/*  68 */           FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", new Object[] {
/*  69 */                 Integer.valueOf(te.field_145851_c), Integer.valueOf(te.field_145848_d), Integer.valueOf(te.field_145849_e) });
/*     */         } 
/*  71 */         i = te.func_145832_p();
/*     */       } 
/*     */       
/*  74 */       te.func_145979_i();
/*     */     } 
/*     */     
/*  77 */     if (te.field_145992_i == null && te.field_145991_k == null) {
/*     */       ModelChest modelchest;
/*     */ 
/*     */       
/*  81 */       if (te.field_145990_j == null && te.field_145988_l == null && !te.isDoubleChest) {
/*     */         
/*  83 */         modelchest = this.chestModel;
/*     */         
/*  85 */         func_147499_a(texNormal[te.type]);
/*     */       }
/*     */       else {
/*     */         
/*  89 */         modelchest = this.largeChestModel;
/*     */         
/*  91 */         func_147499_a(texNormalDouble[te.type]);
/*     */       } 
/*     */       
/*  94 */       GL11.glPushMatrix();
/*  95 */       GL11.glEnable(32826);
/*  96 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  97 */       GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
/*  98 */       GL11.glScalef(1.0F, -1.0F, -1.0F);
/*  99 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 100 */       short short1 = 0;
/*     */       
/* 102 */       if (i == 2)
/*     */       {
/* 104 */         short1 = 180;
/*     */       }
/*     */       
/* 107 */       if (i == 3)
/*     */       {
/* 109 */         short1 = 0;
/*     */       }
/*     */       
/* 112 */       if (i == 4)
/*     */       {
/* 114 */         short1 = 90;
/*     */       }
/*     */       
/* 117 */       if (i == 5)
/*     */       {
/* 119 */         short1 = -90;
/*     */       }
/*     */       
/* 122 */       if (i == 2 && te.field_145990_j != null)
/*     */       {
/* 124 */         GL11.glTranslatef(1.0F, 0.0F, 0.0F);
/*     */       }
/*     */       
/* 127 */       if (i == 5 && te.field_145988_l != null)
/*     */       {
/* 129 */         GL11.glTranslatef(0.0F, 0.0F, -1.0F);
/*     */       }
/*     */       
/* 132 */       GL11.glRotatef(short1, 0.0F, 1.0F, 0.0F);
/* 133 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/*     */       
/* 135 */       if (te.isDoubleChest)
/*     */       {
/* 137 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/*     */       }
/*     */       
/* 140 */       float f1 = te.field_145986_n + (te.field_145989_m - te.field_145986_n) * par8;
/*     */ 
/*     */       
/* 143 */       if (te.field_145992_i != null) {
/*     */         
/* 145 */         float f2 = te.field_145992_i.field_145986_n + (te.field_145992_i.field_145989_m - te.field_145992_i.field_145986_n) * par8;
/*     */         
/* 147 */         if (f2 > f1)
/*     */         {
/* 149 */           f1 = f2;
/*     */         }
/*     */       } 
/*     */       
/* 153 */       if (te.field_145991_k != null) {
/*     */         
/* 155 */         float f2 = te.field_145991_k.field_145986_n + (te.field_145991_k.field_145989_m - te.field_145991_k.field_145986_n) * par8;
/*     */         
/* 157 */         if (f2 > f1)
/*     */         {
/* 159 */           f1 = f2;
/*     */         }
/*     */       } 
/*     */       
/* 163 */       f1 = 1.0F - f1;
/* 164 */       f1 = 1.0F - f1 * f1 * f1;
/* 165 */       modelchest.field_78234_a.field_78795_f = -(f1 * 3.1415927F / 2.0F);
/* 166 */       modelchest.func_78231_a();
/* 167 */       GL11.glDisable(32826);
/* 168 */       GL11.glPopMatrix();
/* 169 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 176 */     renderTileEntityChestAt((TEChest)par1TileEntity, par2, par4, par6, par8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */