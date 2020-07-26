/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEQuern;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TESRQuern
/*     */   extends TESRBase
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*  24 */   private static final ResourceLocation BASE_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Quern Base.png");
/*  25 */   private static final ResourceLocation TOP1_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Quern Top 1.png");
/*  26 */   private static final ResourceLocation TOP2_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Quern Top 2.png");
/*  27 */   private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/wood/Oak Plank.png");
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity te, double xDis, double yDis, double zDis, float f) {
/*  32 */     TEQuern teq = (TEQuern)te;
/*     */     
/*  34 */     Tessellator tess = Tessellator.field_78398_a;
/*  35 */     GL11.glPushMatrix();
/*     */     
/*  37 */     GL11.glTranslatef((float)xDis, (float)yDis, (float)zDis);
/*  38 */     renderBase(tess);
/*  39 */     if (teq.hasQuern) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  45 */       renderRoundTop(tess, teq.rotatetimer, (teq.func_145831_w()).field_73012_v, 0.8D, Boolean.valueOf(true));
/*     */ 
/*     */       
/*  48 */       renderWoodHandle(tess, teq.rotatetimer, (teq.func_145831_w()).field_73012_v, 0.8D);
/*     */       
/*  50 */       if (teq.storage[0] != null) renderItem(teq.storage[0]);
/*     */     
/*     */     } 
/*  53 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderItem(ItemStack is) {
/*  58 */     EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/*  59 */     float blockScale = 0.7F;
/*  60 */     float timeD = (float)-(360.0D * (System.currentTimeMillis() & 0x3FFFL) / 16383.0D);
/*     */     
/*  62 */     func_147499_a(TextureMap.field_110576_c);
/*  63 */     customitem.func_92058_a(is);
/*  64 */     customitem.field_70290_d = 0.0F;
/*     */     
/*  66 */     GL11.glTranslatef(0.5F, 0.83F, 0.5F);
/*  67 */     GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  68 */     GL11.glScalef(blockScale, blockScale, blockScale);
/*  69 */     itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderRoundTop(Tessellator t, int pos, Random rand, double angle, Boolean renderSides) {
/*  74 */     int sides = 4;
/*  75 */     double speed = (pos * 4);
/*  76 */     double i = 0.625D;
/*  77 */     double j = i + 0.2D;
/*  78 */     if (!renderSides.booleanValue()) j = i + 0.201D;
/*     */     
/*  80 */     double center = 0.5D;
/*  81 */     double rad = 0.5D;
/*     */ 
/*     */     
/*  84 */     if (pos > 0) {
/*  85 */       center = 0.494D + rand.nextDouble() * 0.006D + 0.003D;
/*     */     }
/*  87 */     for (int l = 0; l < sides; l++) {
/*     */       
/*  89 */       double a = ((l * 360 / sides) + speed + (4 * pos)) * Math.PI / 180.0D;
/*  90 */       double b = (((1 + l) * 360 / sides) + speed + (4 * pos)) * Math.PI / 180.0D;
/*  91 */       double x1 = Math.cos(a + angle) * rad + center;
/*  92 */       double y1 = Math.sin(a + angle) * rad + center;
/*  93 */       double x2 = Math.cos(b + angle) * rad + center;
/*  94 */       double y2 = Math.sin(b + angle) * rad + center;
/*     */ 
/*     */       
/*  97 */       a = (l * 360 / sides) * Math.PI / 180.0D;
/*  98 */       b = ((1 + l) * 360 / sides) * Math.PI / 180.0D;
/*  99 */       double xx1 = Math.cos(a + angle) * rad + center;
/* 100 */       double yy1 = Math.sin(a + angle) * rad + center;
/* 101 */       double xx2 = Math.cos(b + angle) * rad + center;
/* 102 */       double yy2 = Math.sin(b + angle) * rad + center;
/*     */       
/* 104 */       func_147499_a(TOP2_TEXTURE);
/* 105 */       t.func_78371_b(4);
/* 106 */       t.func_78374_a(x1, j, y1, xx1, yy1);
/* 107 */       t.func_78374_a(center, j, center, center, center);
/* 108 */       t.func_78374_a(x2, j, y2, xx2, yy2);
/* 109 */       t.func_78381_a();
/*     */       
/* 111 */       if (renderSides.booleanValue()) {
/*     */         
/* 113 */         func_147499_a(BASE_TEXTURE);
/* 114 */         t.func_78382_b();
/* 115 */         t.func_78374_a(x1, i, y1, 0.73D, 1.0D - j);
/* 116 */         t.func_78374_a(x1, j, y1, 0.73D, 0.0D);
/* 117 */         t.func_78374_a(x2, j, y2, 0.0D, 0.0D);
/* 118 */         t.func_78374_a(x2, i, y2, 0.0D, 1.0D - j);
/* 119 */         t.func_78381_a();
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
/*     */   private void renderWoodHandle(Tessellator t, int pos, Random rand, double angle) {
/* 163 */     double speed = (pos * 4);
/* 164 */     double j = 0.825D;
/* 165 */     double k = j + 0.175D;
/* 166 */     double center = 0.5D;
/* 167 */     double rad = 0.5D;
/*     */ 
/*     */     
/* 170 */     double a = ((pos * 4 - 5) + speed) * Math.PI / 180.0D;
/* 171 */     double a1 = ((pos * 4) - 5.7D + speed) * Math.PI / 180.0D;
/* 172 */     double b = ((pos * 4 + 5) + speed) * Math.PI / 180.0D;
/* 173 */     double b1 = ((pos * 4) + 5.7D + speed) * Math.PI / 180.0D;
/* 174 */     double x1 = Math.cos(a + angle) * (rad - 0.05D) + center;
/* 175 */     double y1 = Math.sin(a + angle) * (rad - 0.05D) + center;
/* 176 */     double xx1 = Math.cos(a1 + angle) * (rad - 0.125D) + center;
/* 177 */     double yy1 = Math.sin(a1 + angle) * (rad - 0.125D) + center;
/* 178 */     double x2 = Math.cos(b + angle) * (rad - 0.05D) + center;
/* 179 */     double y2 = Math.sin(b + angle) * (rad - 0.05D) + center;
/* 180 */     double xx2 = Math.cos(b1 + angle) * (rad - 0.125D) + center;
/* 181 */     double yy2 = Math.sin(b1 + angle) * (rad - 0.125D) + center;
/*     */     
/* 183 */     func_147499_a(WOOD_TEXTURE);
/*     */     
/* 185 */     t.func_78382_b();
/* 186 */     t.func_78374_a(x1, j, y1, 0.0D, 0.0D);
/* 187 */     t.func_78374_a(xx1, j, yy1, 0.0D, 0.2D);
/* 188 */     t.func_78374_a(xx1, k, yy1, 0.2D, 0.2D);
/* 189 */     t.func_78374_a(x1, k, y1, 0.2D, 0.0D);
/* 190 */     t.func_78381_a();
/*     */     
/* 192 */     t.func_78382_b();
/* 193 */     t.func_78374_a(xx1, j, yy1, 0.0D, 0.0D);
/* 194 */     t.func_78374_a(xx2, j, yy2, 0.0D, 0.2D);
/* 195 */     t.func_78374_a(xx2, k, yy2, 0.2D, 0.2D);
/* 196 */     t.func_78374_a(xx1, k, yy1, 0.2D, 0.0D);
/* 197 */     t.func_78381_a();
/*     */     
/* 199 */     t.func_78382_b();
/* 200 */     t.func_78374_a(xx2, j, yy2, 0.0D, 0.0D);
/* 201 */     t.func_78374_a(x2, j, y2, 0.0D, 0.2D);
/* 202 */     t.func_78374_a(x2, k, y2, 0.2D, 0.2D);
/* 203 */     t.func_78374_a(xx2, k, yy2, 0.2D, 0.0D);
/* 204 */     t.func_78381_a();
/*     */     
/* 206 */     t.func_78382_b();
/* 207 */     t.func_78374_a(x2, j, y2, 0.0D, 0.0D);
/* 208 */     t.func_78374_a(x1, j, y1, 0.0D, 0.2D);
/* 209 */     t.func_78374_a(x1, k, y1, 0.2D, 0.2D);
/* 210 */     t.func_78374_a(x2, k, y2, 0.2D, 0.0D);
/* 211 */     t.func_78381_a();
/*     */     
/* 213 */     t.func_78382_b();
/* 214 */     t.func_78374_a(x1, k, y1, 0.0D, 0.0D);
/* 215 */     t.func_78374_a(xx1, k, yy1, 0.0D, 0.2D);
/* 216 */     t.func_78374_a(xx2, k, yy2, 0.2D, 0.2D);
/* 217 */     t.func_78374_a(x2, k, y2, 0.2D, 0.0D);
/* 218 */     t.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderBase(Tessellator t) {
/* 223 */     double i = 0.625D;
/* 224 */     func_147499_a(BASE_TEXTURE);
/* 225 */     t.func_78382_b();
/*     */     
/* 227 */     t.func_78374_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D);
/* 228 */     t.func_78374_a(0.0D, i, 0.0D, 1.0D, 1.0D - i);
/* 229 */     t.func_78374_a(1.0D, i, 0.0D, 0.0D, 1.0D - i);
/* 230 */     t.func_78374_a(1.0D, 0.0D, 0.0D, 0.0D, 1.0D);
/*     */     
/* 232 */     t.func_78374_a(1.0D, 0.0D, 0.0D, 1.0D, 1.0D);
/* 233 */     t.func_78374_a(1.0D, i, 0.0D, 1.0D, 1.0D - i);
/* 234 */     t.func_78374_a(1.0D, i, 1.0D, 0.0D, 1.0D - i);
/* 235 */     t.func_78374_a(1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/*     */     
/* 237 */     t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 238 */     t.func_78374_a(1.0D, i, 1.0D, 1.0D, 1.0D - i);
/* 239 */     t.func_78374_a(0.0D, i, 1.0D, 0.0D, 1.0D - i);
/* 240 */     t.func_78374_a(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/*     */     
/* 242 */     t.func_78374_a(0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 243 */     t.func_78374_a(0.0D, i, 1.0D, 1.0D, 1.0D - i);
/* 244 */     t.func_78374_a(0.0D, i, 0.0D, 0.0D, 1.0D - i);
/* 245 */     t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 1.0D);
/* 246 */     t.func_78381_a();
/*     */     
/* 248 */     func_147499_a(TOP2_TEXTURE);
/* 249 */     t.func_78382_b();
/* 250 */     t.func_78374_a(0.0D, i, 0.0D, 0.0D, 0.0D);
/* 251 */     t.func_78374_a(0.0D, i, 1.0D, 0.0D, 1.0D);
/* 252 */     t.func_78374_a(1.0D, i, 1.0D, 1.0D, 1.0D);
/* 253 */     t.func_78374_a(1.0D, i, 0.0D, 1.0D, 0.0D);
/* 254 */     t.func_78381_a();
/*     */     
/* 256 */     func_147499_a(TOP1_TEXTURE);
/* 257 */     t.func_78382_b();
/* 258 */     t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 259 */     t.func_78374_a(1.0D, 0.0D, 0.0D, 0.0D, 1.0D);
/* 260 */     t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 261 */     t.func_78374_a(0.0D, 0.0D, 1.0D, 1.0D, 0.0D);
/* 262 */     t.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderblocks) {
/* 268 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 274 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D);
/* 275 */     Tessellator var14 = Tessellator.field_78398_a;
/* 276 */     var14.func_78382_b();
/* 277 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 278 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, 1));
/* 279 */     var14.func_78381_a();
/* 280 */     var14.func_78382_b();
/* 281 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 282 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, 0));
/* 283 */     var14.func_78381_a();
/* 284 */     var14.func_78382_b();
/* 285 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 286 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, 0));
/* 287 */     var14.func_78381_a();
/* 288 */     var14.func_78382_b();
/* 289 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 290 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, 0));
/* 291 */     var14.func_78381_a();
/* 292 */     var14.func_78382_b();
/* 293 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 294 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, 0));
/* 295 */     var14.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 301 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 307 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRQuern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */