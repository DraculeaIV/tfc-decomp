/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEWoodConstruct;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderWoodConstruct
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/*  22 */     renderOld(i, j, k, block, renderer);
/*  23 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderOld(int i, int j, int k, Block block, RenderBlocks renderer) {
/*  28 */     TEWoodConstruct te = (TEWoodConstruct)renderer.field_147845_a.func_147438_o(i, j, k);
/*     */ 
/*     */     
/*  31 */     int d = TEWoodConstruct.plankDetailLevel;
/*  32 */     int dd = TEWoodConstruct.plankDetailLevel * TEWoodConstruct.plankDetailLevel;
/*  33 */     int dd2 = dd * 2;
/*     */     
/*  35 */     float div = 1.0F / d;
/*     */     
/*  37 */     boolean breaking = false;
/*  38 */     if (renderer.field_147840_d != null) {
/*  39 */       breaking = true;
/*     */     }
/*  41 */     float minX = 0.0F;
/*  42 */     float maxX = 1.0F;
/*  43 */     float minY = 0.0F;
/*  44 */     float maxY = 1.0F;
/*  45 */     float minZ = 0.0F;
/*  46 */     float maxZ = 1.0F;
/*  47 */     boolean render = false; int index;
/*  48 */     for (index = 0; index < dd; ) {
/*     */       
/*  50 */       int in3 = index >> 3;
/*  51 */       if (te.solidCheck[in3]) {
/*     */         
/*  53 */         minX = 0.0F;
/*  54 */         maxX = 1.0F;
/*  55 */         minY = 0.0F;
/*  56 */         maxY = 1.0F;
/*  57 */         minZ = div * in3;
/*  58 */         maxZ = minZ + div;
/*  59 */         if (!breaking)
/*  60 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index]); 
/*  61 */         index++;
/*  62 */         render = true;
/*     */       }
/*  64 */       else if (te.solidCheck[in3 + 24]) {
/*     */         
/*  66 */         minX = 0.0F;
/*  67 */         maxX = 1.0F;
/*  68 */         minY = div * ((index & 0x7) + in3);
/*  69 */         maxY = minY + div;
/*  70 */         minZ = 0.0F;
/*  71 */         maxZ = 1.0F;
/*  72 */         if (!breaking)
/*  73 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index]); 
/*  74 */         index += 8;
/*  75 */         render = true;
/*     */       }
/*  77 */       else if (te.data.get(index)) {
/*     */         
/*  79 */         minX = 0.0F;
/*  80 */         maxX = 1.0F;
/*  81 */         minY = div * (index & 0x7);
/*  82 */         maxY = minY + div;
/*  83 */         minZ = div * in3;
/*  84 */         maxZ = minZ + div;
/*  85 */         if (!breaking)
/*  86 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index]); 
/*  87 */         index++;
/*  88 */         render = true;
/*     */       }
/*     */       else {
/*     */         
/*  92 */         index++;
/*  93 */         render = false;
/*     */       } 
/*     */       
/*  96 */       if (render) {
/*     */         
/*  98 */         renderer.field_147867_u = 3;
/*  99 */         renderer.field_147865_v = 3;
/* 100 */         renderer.func_147782_a((minX + 3.0E-5F), (minY + 3.0E-5F), (minZ + 3.0E-5F), (maxX - 3.0E-5F), (maxY - 3.0E-5F), (maxZ - 3.0E-5F));
/* 101 */         renderer.func_147736_d(block, i, j, k, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     renderer.field_147867_u = 0;
/* 106 */     renderer.field_147865_v = 0;
/* 107 */     for (index = 0; index < dd; ) {
/*     */       
/* 109 */       if (te.solidCheck[dd + index >> 3]) {
/*     */         
/* 111 */         minX = 0.0F;
/* 112 */         maxX = 1.0F;
/* 113 */         minY = 0.0F;
/* 114 */         maxY = 1.0F;
/* 115 */         minZ = div * (index >> 3);
/* 116 */         maxZ = minZ + div;
/* 117 */         if (!breaking)
/* 118 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index + dd]); 
/* 119 */         index += 8;
/* 120 */         render = true;
/*     */       }
/* 122 */       else if (te.data.get(index + dd)) {
/*     */         
/* 124 */         minX = div * (index & 0x7);
/* 125 */         maxX = minX + div;
/* 126 */         minY = 0.0F;
/* 127 */         maxY = 1.0F;
/* 128 */         minZ = div * (index >> 3);
/* 129 */         maxZ = minZ + div;
/* 130 */         if (!breaking)
/* 131 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index + dd]); 
/* 132 */         index++;
/* 133 */         render = true;
/*     */       }
/*     */       else {
/*     */         
/* 137 */         index++;
/* 138 */         render = false;
/*     */       } 
/*     */       
/* 141 */       if (render) {
/*     */         
/* 143 */         renderer.field_147869_t = 1;
/* 144 */         renderer.field_147871_s = 1;
/* 145 */         renderer.field_147875_q = 1;
/* 146 */         renderer.field_147873_r = 1;
/* 147 */         renderer.func_147782_a(minX, minY, minZ, maxX, maxY, maxZ);
/* 148 */         renderer.func_147736_d(block, i, j, k, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 154 */     renderer.field_147869_t = 0;
/* 155 */     renderer.field_147871_s = 0;
/* 156 */     renderer.field_147875_q = 0;
/* 157 */     renderer.field_147873_r = 0;
/*     */     
/* 159 */     for (index = 0; index < dd; ) {
/*     */       
/* 161 */       if (te.solidCheck[dd2 + index >> 3]) {
/*     */         
/* 163 */         minX = 0.0F;
/* 164 */         maxX = 1.0F;
/* 165 */         minY = div * (index >> 3);
/* 166 */         maxY = minY + div;
/* 167 */         minZ = 0.0F;
/* 168 */         maxZ = 1.0F;
/* 169 */         if (!breaking)
/* 170 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index + dd2]); 
/* 171 */         index += 8;
/* 172 */         render = true;
/*     */       }
/* 174 */       else if (te.data.get(index + dd2)) {
/*     */         
/* 176 */         minX = div * (index & 0x7);
/* 177 */         maxX = minX + div;
/* 178 */         minY = div * (index >> 3);
/* 179 */         maxY = minY + div;
/* 180 */         minZ = 0.0F;
/* 181 */         maxZ = 1.0F;
/* 182 */         if (!breaking)
/* 183 */           renderer.field_147840_d = TFCBlocks.woodConstruct.func_149691_a(0, te.woodTypes[index + dd2]); 
/* 184 */         index++;
/* 185 */         render = true;
/*     */       }
/*     */       else {
/*     */         
/* 189 */         index++;
/* 190 */         render = false;
/*     */       } 
/*     */       
/* 193 */       if (render) {
/*     */         
/* 195 */         renderer.field_147867_u = 1;
/* 196 */         renderer.field_147865_v = 1;
/* 197 */         renderer.func_147782_a((minX + 1.0E-5F), (minY + 1.0E-5F), (minZ + 1.0E-5F), (maxX - 1.0E-5F), (maxY - 1.0E-5F), (maxZ - 1.0E-5F));
/* 198 */         renderer.func_147736_d(block, i, j, k, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/* 201 */     renderer.field_147867_u = 0;
/* 202 */     renderer.field_147865_v = 0;
/* 203 */     renderer.func_147771_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 215 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderWoodConstruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */