/*     */ package com.bioxx.tfc;
/*     */ 
/*     */ import com.bioxx.tfc.Core.WeatherManager;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.client.particle.EntityRainFX;
/*     */ import net.minecraft.client.particle.EntitySmokeFX;
/*     */ import net.minecraft.client.renderer.RenderGlobal;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ClientOverrides
/*     */ {
/*     */   private static int rainSoundCounter;
/*     */   
/*     */   public static void loadRenderers() {
/*  30 */     RenderGlobal renderG = (Minecraft.func_71410_x()).field_71438_f;
/*  31 */     Object obj = Helper.getObject(renderG, "t", "field_72767_j", "worldRenderersToUpdate", TFCASMLoadingPlugin.runtimeDeobf);
/*  32 */     if (!(obj instanceof List))
/*     */       return; 
/*  34 */     int k = 0, j = 0;
/*  35 */     int renderChunksWide = Helper.getInteger(renderG, "w", "field_72766_m", "renderChunksWide", TFCASMLoadingPlugin.runtimeDeobf);
/*  36 */     int renderChunksTall = Helper.getInteger(renderG, "x", "field_72763_n", "renderChunksTall", TFCASMLoadingPlugin.runtimeDeobf);
/*  37 */     int renderChunksDeep = Helper.getInteger(renderG, "y", "field_72764_o", "renderChunksDeep", TFCASMLoadingPlugin.runtimeDeobf);
/*  38 */     int glRenderListBase = Helper.getInteger(renderG, "z", "field_72778_p", "glRenderListBase", TFCASMLoadingPlugin.runtimeDeobf);
/*  39 */     WorldRenderer[] worldRenderers = (WorldRenderer[])Helper.getObject(renderG, "v", "field_72765_l", "worldRenderers", TFCASMLoadingPlugin.runtimeDeobf);
/*  40 */     WorldRenderer[] sortedWorldRenderers = (WorldRenderer[])Helper.getObject(renderG, "u", "field_72768_k", "sortedWorldRenderers", TFCASMLoadingPlugin.runtimeDeobf);
/*     */     
/*  42 */     List<WorldRenderer> worldRenderersToUpdate = (List<WorldRenderer>)Helper.getObject(renderG, "t", "field_72767_j", "worldRenderersToUpdate", TFCASMLoadingPlugin.runtimeDeobf);
/*  43 */     World world = (World)Helper.getObject(renderG, "r", "field_72769_h", "theWorld", TFCASMLoadingPlugin.runtimeDeobf);
/*     */     
/*  45 */     worldRenderersToUpdate.clear();
/*  46 */     renderG.field_147598_a.clear();
/*     */     
/*  48 */     for (int l = 0; l < renderChunksWide; l++) {
/*     */       
/*  50 */       for (int i1 = renderChunksTall - 1; i1 >= 0; i1--) {
/*     */         
/*  52 */         for (int j1 = 0; j1 < renderChunksDeep; j1++) {
/*     */           
/*  54 */           worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l] = new WorldRenderer(world, renderG.field_147598_a, l * 16, i1 * 16, j1 * 16, glRenderListBase + j);
/*     */           
/*  56 */           if (Helper.getBoolean(renderG, "D", "field_72774_t", "occlusionEnabled", TFCASMLoadingPlugin.runtimeDeobf))
/*     */           {
/*  58 */             (worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l]).field_78934_v = ((IntBuffer)Helper.getObject(renderG, "C", "field_72775_s", "glOcclusionQueryBase", TFCASMLoadingPlugin.runtimeDeobf)).get(k);
/*     */           }
/*     */           
/*  61 */           (worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l]).field_78935_u = false;
/*  62 */           (worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l]).field_78936_t = true;
/*  63 */           (worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l]).field_78927_l = true;
/*  64 */           (worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l]).field_78937_s = k++;
/*  65 */           worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l].func_78914_f();
/*  66 */           sortedWorldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l] = worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l];
/*  67 */           worldRenderersToUpdate.add(worldRenderers[(j1 * renderChunksTall + i1) * renderChunksWide + l]);
/*  68 */           j += 3;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void doRainClient(Random random, int rendererUpdateCount) {
/*  78 */     float f = (Minecraft.func_71410_x()).field_71441_e.func_72867_j(1.0F);
/*     */     
/*  80 */     if (!(Minecraft.func_71410_x()).field_71474_y.field_74347_j)
/*     */     {
/*  82 */       f /= 2.0F;
/*     */     }
/*     */     
/*  85 */     if (f != 0.0F) {
/*     */       
/*  87 */       random.setSeed(rendererUpdateCount * 312987231L);
/*  88 */       EntityLivingBase entitylivingbase = (Minecraft.func_71410_x()).field_71451_h;
/*  89 */       WorldClient worldclient = (Minecraft.func_71410_x()).field_71441_e;
/*  90 */       int i = MathHelper.func_76128_c(entitylivingbase.field_70165_t);
/*  91 */       int j = MathHelper.func_76128_c(entitylivingbase.field_70163_u);
/*  92 */       int k = MathHelper.func_76128_c(entitylivingbase.field_70161_v);
/*  93 */       byte b0 = 10;
/*  94 */       double d0 = 0.0D;
/*  95 */       double d1 = 0.0D;
/*  96 */       double d2 = 0.0D;
/*  97 */       int l = 0;
/*  98 */       int i1 = (int)(100.0F * f * f);
/*     */       
/* 100 */       if ((Minecraft.func_71410_x()).field_71474_y.field_74362_aa == 1) {
/*     */         
/* 102 */         i1 >>= 1;
/*     */       }
/* 104 */       else if ((Minecraft.func_71410_x()).field_71474_y.field_74362_aa == 2) {
/*     */         
/* 106 */         i1 = 0;
/*     */       } 
/*     */       
/* 109 */       for (int j1 = 0; j1 < i1; j1++) {
/*     */         
/* 111 */         int x = i + random.nextInt(b0) - random.nextInt(b0);
/* 112 */         int z = k + random.nextInt(b0) - random.nextInt(b0);
/* 113 */         int y = worldclient.func_72874_g(x, z);
/* 114 */         Block b = worldclient.func_147439_a(x, y - 1, z);
/* 115 */         if (!WeatherManager.canSnow((World)(Minecraft.func_71410_x()).field_71441_e, x, y, z))
/*     */         {
/* 117 */           if (y <= j + b0 && y >= j - b0) {
/*     */             
/* 119 */             float f1 = random.nextFloat();
/* 120 */             float f2 = random.nextFloat();
/*     */             
/* 122 */             if (!b.isAir((IBlockAccess)worldclient, x, y - 1, z))
/*     */             {
/* 124 */               if (b.func_149688_o() == Material.field_151587_i) {
/*     */                 
/* 126 */                 (Minecraft.func_71410_x()).field_71452_i.func_78873_a((EntityFX)new EntitySmokeFX((World)worldclient, (x + f1), (y + 0.1F) - b.func_149665_z(), (z + f2), 0.0D, 0.0D, 0.0D));
/*     */               }
/*     */               else {
/*     */                 
/* 130 */                 l++;
/*     */                 
/* 132 */                 if (random.nextInt(l) == 0) {
/*     */                   
/* 134 */                   d0 = (x + f1);
/* 135 */                   d1 = (y + 0.1F) - b.func_149665_z();
/* 136 */                   d2 = (z + f2);
/*     */                 } 
/*     */                 
/* 139 */                 (Minecraft.func_71410_x()).field_71452_i.func_78873_a((EntityFX)new EntityRainFX((World)worldclient, (x + f1), (y + 0.1F) - b.func_149665_z(), (z + f2)));
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 146 */       if (l > 0 && random.nextInt(3) < rainSoundCounter++) {
/*     */         
/* 148 */         rainSoundCounter = 0;
/*     */         
/* 150 */         if (d1 > entitylivingbase.field_70163_u + 1.0D && worldclient.func_72874_g(MathHelper.func_76128_c(entitylivingbase.field_70165_t), MathHelper.func_76128_c(entitylivingbase.field_70161_v)) > MathHelper.func_76128_c(entitylivingbase.field_70163_u)) {
/*     */           
/* 152 */           (Minecraft.func_71410_x()).field_71441_e.func_72980_b(d0, d1, d2, "ambient.weather.rain", 0.1F, 0.5F, false);
/*     */         }
/*     */         else {
/*     */           
/* 156 */           (Minecraft.func_71410_x()).field_71441_e.func_72980_b(d0, d1, d2, "ambient.weather.rain", 0.2F, 1.0F, false);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ClientOverrides.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */