/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.api.Tools.ChiselManager;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.DrawBlockHighlightEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChiselHighlightHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void drawBlockHighlightEvent(DrawBlockHighlightEvent evt) {
/*  26 */     EntityPlayer player = evt.player;
/*  27 */     World world = player.field_70170_p;
/*     */     
/*  29 */     if (evt.currentItem != null && evt.currentItem.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemChisel) {
/*     */       
/*  31 */       boolean hasHammer = false;
/*  32 */       for (int i = 0; i < 9; i++) {
/*     */         
/*  34 */         if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer) {
/*     */           
/*  36 */           hasHammer = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  41 */       if (hasHammer) {
/*     */         
/*  43 */         MovingObjectPosition target = evt.target;
/*  44 */         Block id = world.func_147439_a(target.field_72311_b, target.field_72312_c, target.field_72309_d);
/*  45 */         int mode = (PlayerManagerTFC.getInstance().getClientPlayer()).chiselMode;
/*     */ 
/*     */         
/*  48 */         if (mode > -1) {
/*     */ 
/*     */           
/*  51 */           double hitX = Math.round((target.field_72307_f.field_72450_a - target.field_72311_b) * 100.0D) / 100.0D;
/*  52 */           double hitY = Math.round((target.field_72307_f.field_72448_b - target.field_72312_c) * 100.0D) / 100.0D;
/*  53 */           double hitZ = Math.round((target.field_72307_f.field_72449_c - target.field_72309_d) * 100.0D) / 100.0D;
/*     */           
/*  55 */           ChiselManager.getInstance().setDivision(mode, target.field_72310_e);
/*  56 */           int divX = ChiselManager.getInstance().getDivX(mode, id);
/*  57 */           int divY = ChiselManager.getInstance().getDivY(mode, id);
/*  58 */           int divZ = ChiselManager.getInstance().getDivZ(mode, id);
/*     */           
/*  60 */           if (divX > 0) {
/*     */ 
/*     */ 
/*     */             
/*  64 */             double subX = (int)(hitX * divX) / divX;
/*  65 */             double subY = (int)(hitY * divY) / divY;
/*  66 */             double subZ = (int)(hitZ * divZ) / divZ;
/*     */             
/*  68 */             switch (target.field_72310_e) {
/*     */               
/*     */               case 1:
/*  71 */                 subY -= 1.0D / divY;
/*  72 */                 if (hitX == 1.0D)
/*  73 */                   subX -= 1.0D / divX; 
/*  74 */                 if (hitZ == 1.0D)
/*  75 */                   subZ -= 1.0D / divZ; 
/*     */                 break;
/*     */               case 3:
/*  78 */                 subZ -= 1.0D / divZ;
/*  79 */                 if (hitX == 1.0D)
/*  80 */                   subX -= 1.0D / divX; 
/*  81 */                 if (hitY == 1.0D)
/*  82 */                   subY -= 1.0D / divY; 
/*     */                 break;
/*     */               case 5:
/*  85 */                 subX -= 1.0D / divX;
/*  86 */                 if (hitY == 1.0D)
/*  87 */                   subY -= 1.0D / divY; 
/*  88 */                 if (hitZ == 1.0D) {
/*  89 */                   subZ -= 1.0D / divZ;
/*     */                 }
/*     */                 break;
/*     */             } 
/*     */             
/*  94 */             double minX = target.field_72311_b + subX;
/*  95 */             double minY = target.field_72312_c + subY;
/*  96 */             double minZ = target.field_72309_d + subZ;
/*  97 */             double maxX = minX + 1.0D / divX;
/*  98 */             double maxY = minY + 1.0D / divY;
/*  99 */             double maxZ = minZ + 1.0D / divZ;
/*     */             
/* 101 */             double var8 = player.field_70142_S + (player.field_70165_t - player.field_70142_S) * evt.partialTicks;
/* 102 */             double var10 = player.field_70137_T + (player.field_70163_u - player.field_70137_T) * evt.partialTicks;
/* 103 */             double var12 = player.field_70136_U + (player.field_70161_v - player.field_70136_U) * evt.partialTicks;
/*     */ 
/*     */             
/* 106 */             GL11.glEnable(3042);
/* 107 */             GL11.glBlendFunc(1, 1);
/* 108 */             GL11.glDisable(3553);
/* 109 */             GL11.glDepthMask(false);
/*     */ 
/*     */             
/* 112 */             GL11.glBlendFunc(770, 771);
/* 113 */             GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.4F);
/* 114 */             GL11.glLineWidth(4.0F);
/* 115 */             GL11.glDepthMask(true);
/*     */             
/* 117 */             drawOutlinedBoundingBox(AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ).func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */             
/* 119 */             GL11.glDepthMask(true);
/* 120 */             GL11.glEnable(3553);
/* 121 */             GL11.glDisable(3042);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
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
/*     */   
/*     */   public void drawOutlinedBoundingBox(AxisAlignedBB par1AxisAlignedBB) {
/* 194 */     Tessellator var2 = Tessellator.field_78398_a;
/* 195 */     var2.func_78371_b(3);
/* 196 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 197 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 198 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 199 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 200 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 201 */     var2.func_78381_a();
/* 202 */     var2.func_78371_b(3);
/* 203 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 204 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 205 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 206 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 207 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 208 */     var2.func_78381_a();
/* 209 */     var2.func_78371_b(1);
/* 210 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 211 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 212 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 213 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 214 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 215 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 216 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 217 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 218 */     var2.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\ChiselHighlightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */