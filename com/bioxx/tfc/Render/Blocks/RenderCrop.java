/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockCrop;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.TileEntities.TECrop;
/*     */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderCrop
/*     */ {
/*     */   public static boolean render(Block block, int x, int y, int z, RenderBlocks renderblocks) {
/*  21 */     IBlockAccess blockaccess = renderblocks.field_147845_a;
/*  22 */     TECrop cropTE = (TECrop)blockaccess.func_147438_o(x, y, z);
/*     */     
/*  24 */     if (cropTE != null) {
/*  25 */       CropManager.getInstance().getCropFromId(cropTE.cropId);
/*     */     } else {
/*  27 */       return false;
/*     */     } 
/*  29 */     Tessellator var9 = Tessellator.field_78398_a;
/*  30 */     var9.func_78380_c(block.func_149677_c(blockaccess, x, y, z));
/*  31 */     switch (cropTE.cropId) {
/*     */ 
/*     */       
/*     */       case 0:
/*  35 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 0.5D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 1:
/*  40 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 1.0D, 2.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/*  45 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.9D, 2.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/*  50 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 0.5D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 4:
/*  55 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 0.5D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 5:
/*  60 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 0.5D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 6:
/*  65 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 0.5D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 7:
/*  70 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 8:
/*  75 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 9:
/*  80 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 10:
/*  85 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 11:
/*  90 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 12:
/*  95 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 13:
/* 100 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 14:
/* 105 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 15:
/* 110 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 16:
/* 115 */         drawCrossedSquares(block, x, y, z, renderblocks, 0.45D, 1.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 17:
/* 120 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 0.8D, 2.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 18:
/* 125 */         renderBlockCropsImpl(block, x, y, z, renderblocks, 1.0D, 2.0D);
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/* 130 */         renderblocks.func_147796_n(block, x, y, z);
/*     */         break;
/*     */     } 
/*     */     
/* 134 */     TileEntity te = blockaccess.func_147438_o(x, y - 1, z);
/* 135 */     TEFarmland tef = null;
/* 136 */     if (te instanceof TEFarmland)
/* 137 */       tef = (TEFarmland)te; 
/* 138 */     if (tef != null && tef.isInfested) {
/*     */ 
/*     */       
/* 141 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */ 
/*     */       
/* 144 */       tessellator.func_78374_a((x + 0), y + 0.001D, (z + 1), ((BlockCrop)block).iconInfest.func_94209_e(), ((BlockCrop)block).iconInfest.func_94210_h());
/* 145 */       tessellator.func_78374_a((x + 1), y + 0.001D, (z + 1), ((BlockCrop)block).iconInfest.func_94212_f(), ((BlockCrop)block).iconInfest.func_94210_h());
/* 146 */       tessellator.func_78374_a((x + 1), y + 0.001D, (z + 0), ((BlockCrop)block).iconInfest.func_94212_f(), ((BlockCrop)block).iconInfest.func_94206_g());
/* 147 */       tessellator.func_78374_a((x + 0), y + 0.001D, (z + 0), ((BlockCrop)block).iconInfest.func_94209_e(), ((BlockCrop)block).iconInfest.func_94206_g());
/*     */     } 
/*     */ 
/*     */     
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderBlockCropsImpl(Block block, double i, double j, double k, RenderBlocks renderblocks, double width, double height) {
/* 156 */     Tessellator tess = Tessellator.field_78398_a;
/* 157 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 158 */     int brightness = block.func_149677_c(renderblocks.field_147845_a, (int)i, (int)j, (int)k);
/* 159 */     tess.func_78380_c(brightness);
/* 160 */     tess.func_78386_a(1.0F, 1.0F, 1.0F);
/*     */     
/* 162 */     IIcon icon = block.func_149673_e(renderblocks.field_147845_a, (int)i, (int)j, (int)k, renderblocks.field_147845_a.func_72805_g((int)i, (int)j, (int)k));
/* 163 */     if (renderblocks.func_147744_b()) {
/* 164 */       icon = renderblocks.field_147840_d;
/*     */     }
/* 166 */     if (icon != null) {
/*     */       
/* 168 */       if (((int)i & 0x1) > 0)
/*     */       {
/* 170 */         k += 1.0E-4D;
/*     */       }
/* 172 */       if (((int)k & 0x1) > 0)
/*     */       {
/* 174 */         i += 1.0E-4D;
/*     */       }
/*     */       
/* 177 */       double minU = icon.func_94209_e();
/* 178 */       double maxU = icon.func_94212_f();
/* 179 */       double minV = icon.func_94206_g();
/* 180 */       double maxV = icon.func_94210_h();
/* 181 */       double minX = i + 0.25D;
/* 182 */       double maxX = i + 0.75D;
/* 183 */       double minZ = k + 0.5D - width;
/* 184 */       double maxZ = k + 0.5D + width;
/* 185 */       double y = j;
/*     */       
/* 187 */       tess.func_78374_a(minX, y + height, minZ, minU, minV);
/* 188 */       tess.func_78374_a(minX, y, minZ, minU, maxV);
/* 189 */       tess.func_78374_a(minX, y, maxZ, maxU, maxV);
/* 190 */       tess.func_78374_a(minX, y + height, maxZ, maxU, minV);
/* 191 */       tess.func_78374_a(minX, y + height, maxZ, minU, minV);
/* 192 */       tess.func_78374_a(minX, y, maxZ, minU, maxV);
/* 193 */       tess.func_78374_a(minX, y, minZ, maxU, maxV);
/* 194 */       tess.func_78374_a(minX, y + height, minZ, maxU, minV);
/* 195 */       tess.func_78374_a(maxX, y + height, maxZ, minU, minV);
/* 196 */       tess.func_78374_a(maxX, y, maxZ, minU, maxV);
/* 197 */       tess.func_78374_a(maxX, y, minZ, maxU, maxV);
/* 198 */       tess.func_78374_a(maxX, y + height, minZ, maxU, minV);
/* 199 */       tess.func_78374_a(maxX, y + height, minZ, minU, minV);
/* 200 */       tess.func_78374_a(maxX, y, minZ, minU, maxV);
/* 201 */       tess.func_78374_a(maxX, y, maxZ, maxU, maxV);
/* 202 */       tess.func_78374_a(maxX, y + height, maxZ, maxU, minV);
/* 203 */       minX = i + 0.5D - width;
/* 204 */       maxX = i + 0.5D + width;
/* 205 */       minZ = k + 0.5D - 0.25D;
/* 206 */       maxZ = k + 0.5D + 0.25D;
/* 207 */       tess.func_78374_a(minX, y + height, minZ, minU, minV);
/* 208 */       tess.func_78374_a(minX, y, minZ, minU, maxV);
/* 209 */       tess.func_78374_a(maxX, y, minZ, maxU, maxV);
/* 210 */       tess.func_78374_a(maxX, y + height, minZ, maxU, minV);
/* 211 */       tess.func_78374_a(maxX, y + height, minZ, minU, minV);
/* 212 */       tess.func_78374_a(maxX, y, minZ, minU, maxV);
/* 213 */       tess.func_78374_a(minX, y, minZ, maxU, maxV);
/* 214 */       tess.func_78374_a(minX, y + height, minZ, maxU, minV);
/* 215 */       tess.func_78374_a(maxX, y + height, maxZ, minU, minV);
/* 216 */       tess.func_78374_a(maxX, y, maxZ, minU, maxV);
/* 217 */       tess.func_78374_a(minX, y, maxZ, maxU, maxV);
/* 218 */       tess.func_78374_a(minX, y + height, maxZ, maxU, minV);
/* 219 */       tess.func_78374_a(minX, y + height, maxZ, minU, minV);
/* 220 */       tess.func_78374_a(minX, y, maxZ, minU, maxV);
/* 221 */       tess.func_78374_a(maxX, y, maxZ, maxU, maxV);
/* 222 */       tess.func_78374_a(maxX, y + height, maxZ, maxU, minV);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void drawCrossedSquares(Block block, double x, double y, double z, RenderBlocks renderblocks, double width, double height) {
/* 228 */     Tessellator tess = Tessellator.field_78398_a;
/* 229 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */     
/* 231 */     int brightness = block.func_149677_c(renderblocks.field_147845_a, (int)x, (int)y, (int)z);
/* 232 */     tess.func_78380_c(brightness);
/* 233 */     tess.func_78386_a(1.0F, 1.0F, 1.0F);
/*     */     
/* 235 */     IIcon icon = block.func_149673_e(renderblocks.field_147845_a, (int)x, (int)y, (int)z, renderblocks.field_147845_a.func_72805_g((int)x, (int)y, (int)z));
/* 236 */     if (renderblocks.func_147744_b()) {
/* 237 */       icon = renderblocks.field_147840_d;
/*     */     }
/* 239 */     double minU = icon.func_94209_e();
/* 240 */     double maxU = icon.func_94212_f();
/* 241 */     double minV = icon.func_94206_g();
/* 242 */     double maxV = icon.func_94210_h();
/*     */     
/* 244 */     double minX = x + 0.5D - width;
/* 245 */     double maxX = x + 0.5D + width;
/* 246 */     double minZ = z + 0.5D - width;
/* 247 */     double maxZ = z + 0.5D + width;
/*     */     
/* 249 */     tess.func_78374_a(minX, y + height, minZ, minU, minV);
/* 250 */     tess.func_78374_a(minX, y + 0.0D, minZ, minU, maxV);
/* 251 */     tess.func_78374_a(maxX, y + 0.0D, maxZ, maxU, maxV);
/* 252 */     tess.func_78374_a(maxX, y + height, maxZ, maxU, minV);
/*     */     
/* 254 */     tess.func_78374_a(maxX, y + height, maxZ, minU, minV);
/* 255 */     tess.func_78374_a(maxX, y + 0.0D, maxZ, minU, maxV);
/* 256 */     tess.func_78374_a(minX, y + 0.0D, minZ, maxU, maxV);
/* 257 */     tess.func_78374_a(minX, y + height, minZ, maxU, minV);
/*     */     
/* 259 */     tess.func_78374_a(minX, y + height, maxZ, minU, minV);
/* 260 */     tess.func_78374_a(minX, y + 0.0D, maxZ, minU, maxV);
/* 261 */     tess.func_78374_a(maxX, y + 0.0D, minZ, maxU, maxV);
/* 262 */     tess.func_78374_a(maxX, y + height, minZ, maxU, minV);
/*     */     
/* 264 */     tess.func_78374_a(maxX, y + height, minZ, minU, minV);
/* 265 */     tess.func_78374_a(maxX, y + 0.0D, minZ, minU, maxV);
/* 266 */     tess.func_78374_a(minX, y + 0.0D, maxZ, maxU, maxV);
/* 267 */     tess.func_78374_a(minX, y + height, maxZ, maxU, minV);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderCrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */